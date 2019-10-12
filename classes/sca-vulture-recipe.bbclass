## SPDX-License-Identifier: BSD-2-Clause
## Copyright (c) 2019, Konrad Weihmann

inherit sca-vulture-core
inherit sca-global

inherit ${@oe.utils.ifelse(d.getVar('SCA_STD_PYTHON_INTERPRETER') == 'python3', 'python3-dir', 'python-dir')}

SCA_DEPLOY_TASK = "do_sca_deploy_vulture_recipe"

python do_sca_deploy_vulture_recipe() {
   sca_conv_deploy(d, "vulture", "txt")
}

do_compile[postfuncs] += "do_sca_vulture_core"
do_package[prefuncs] += "do_sca_deploy_vulture_recipe"

do_sca_vulture_core[nostamp] = "${@sca_force_run(d)}"
do_sca_deploy_vulture_recipe[nostamp] = "${@sca_force_run(d)}"

DEPENDS += "sca-recipe-vulture-rules-native"