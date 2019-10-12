## SPDX-License-Identifier: BSD-2-Clause
## Copyright (c) 2019, Konrad Weihmann

inherit sca-helper
inherit sca-global
inherit sca-wotan-core

SCA_DEPLOY_TASK = "do_sca_deploy_wotan_recipe"

python do_sca_deploy_wotan_recipe() {
    sca_conv_deploy(d, "wotan", "json")
}

do_compile[postfuncs] += "do_sca_wotan_core"
do_package[prefuncs] += "do_sca_deploy_wotan_recipe"

do_sca_wotan_core[nostamp] = "${@sca_force_run(d)}"
do_sca_deploy_wotan_recipe[nostamp] = "${@sca_force_run(d)}"

DEPENDS += "sca-recipe-wotan-rules-native"
