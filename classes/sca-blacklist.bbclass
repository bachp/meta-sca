## SPDX-License-Identifier: BSD-2-Clause
## Copyright (c) 2019, Konrad Weihmann

## This class provides the configuration for blacklisting modules from certain recipes
## All configuration is described through space-separated regular expression
SCA_BLACKLIST ?= ".*-native .*-cross nativesdk-.*"
SCA_BLACKLIST_alexkohler ?= ""
SCA_BLACKLIST_ansible ?= ""
SCA_BLACKLIST_ansiblelint ?= ""
SCA_BLACKLIST_bandit ?= "linux-.*"
SCA_BLACKLIST_bitbake ?= ""
SCA_BLACKLIST_cbmc ?= "linux-.* busybox"
SCA_BLACKLIST_clang ?= "linux-.*"
SCA_BLACKLIST_configcheck ?= ""
SCA_BLACKLIST_cppcheck ?= "linux-.*"
SCA_BLACKLIST_cpplint ?= "linux-.*"
SCA_BLACKLIST_cqmetrics ?= ""
SCA_BLACKLIST_cspell ?= "linux-.*"
SCA_BLACKLIST_cvecheck ?= ""
SCA_BLACKLIST_darglint ?= ""
SCA_BLACKLIST_dennis ?= "linux-.*"
SCA_BLACKLIST_detectsecrets ?= "linux-.*"
SCA_BLACKLIST_eslint ?= "linux-.*"
SCA_BLACKLIST_flake8 ?= ""
SCA_BLACKLIST_flawfinder ?= ""
SCA_BLACKLIST_flint ?= "linux-.*"
SCA_BLACKLIST_gcc ?= ""
SCA_BLACKLIST_gixy ?= ""
SCA_BLACKLIST_golint ?= ""
SCA_BLACKLIST_gosec ?= ""
SCA_BLACKLIST_govet ?= ""
SCA_BLACKLIST_htmlhint ?= ""
SCA_BLACKLIST_ikos ?= "linux-.* busybox.*"
SCA_BLACKLIST_jsonlint ?= ""
SCA_BLACKLIST_kconfighard ?= ""
SCA_BLACKLIST_looong ?= "linux-.*"
SCA_BLACKLIST_luacheck ?= ""
SCA_BLACKLIST_lynis ?= ""
SCA_BLACKLIST_msgcheck ?= ""
SCA_BLACKLIST_mypy ?= "linux-.*"
SCA_BLACKLIST_nixauditor ?= ""
SCA_BLACKLIST_npmaudit ?= ""
SCA_BLACKLIST_oclint ?= "linux-.*"
SCA_BLACKLIST_oelint ?= ""
SCA_BLACKLIST_phan ?= ""
SCA_BLACKLIST_phpcodefixer ?= ""
SCA_BLACKLIST_phpstan ?= ""
SCA_BLACKLIST_progpilot ?= ""
SCA_BLACKLIST_proselint ?= ""
SCA_BLACKLIST_pscan ?= ""
SCA_BLACKLIST_pyfindinjection ?= ""
SCA_BLACKLIST_pylint ?= "linux-.*"
SCA_BLACKLIST_pyright ?= ""
SCA_BLACKLIST_pysymcheck ?= ""
SCA_BLACKLIST_pytype ?= "linux-.*"
SCA_BLACKLIST_radon ?= ""
SCA_BLACKLIST_rats ?= ""
SCA_BLACKLIST_retire ?= ""
SCA_BLACKLIST_revive ?= ""
SCA_BLACKLIST_ropgadget ?= "linux-.*"
SCA_BLACKLIST_safety ?= ""
SCA_BLACKLIST_score ?= ""
SCA_BLACKLIST_shellcheck ?= ""
SCA_BLACKLIST_slick ?= ""
SCA_BLACKLIST_sparse ?= ""
SCA_BLACKLIST_splint ?= "linux-.*"
SCA_BLACKLIST_standard ?= "linux-.*"
SCA_BLACKLIST_stank ?= ""
SCA_BLACKLIST_stylelint ?= "linux-.*"
SCA_BLACKLIST_systemdlint ?= ""
SCA_BLACKLIST_textlint ?= ""
SCA_BLACKLIST_tiger ?= ""
SCA_BLACKLIST_tlv ?= "linux-.*"
SCA_BLACKLIST_tscanscode ?= "linux-.*"
SCA_BLACKLIST_upc ?= ""
SCA_BLACKLIST_vulture ?= ""
SCA_BLACKLIST_wotan ?= ""
SCA_BLACKLIST_xmllint ?= ""
SCA_BLACKLIST_yamllint ?= ""
SCA_BLACKLIST_yara ?= ""
SCA_BLACKLIST_zrd ?= "linux-.*"
SCA_BLAckLIST_bashate ?= ""
SCA_BLAckLIST_checkbashism ?= ""

inherit sca-helper

def sca_is_module_blacklisted(d, tool):
    import re
    pn = d.getVar("PN")
    matches = [x for x in (d.getVar("SCA_BLACKLIST") or "").split(" ") if x]
    matches += [x for x in (d.getVar("SCA_BLACKLIST_{}".format(tool.replace("-", "_"))) or "").split(" ") if x]
    _pns = [re.match(x, pn) for x in matches]
    _def_deps = [x for x in d.getVar("BASE_DEFAULT_DEPS").split(" ")]
    _prov = [x for x in d.getVar("PROVIDES").split(" ")]
    return any(_pns + intersect_lists(d, _def_deps, _prov))
