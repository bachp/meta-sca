SUMMARY = "NPM: cspell-lib"
DESCRIPTION = "A library of useful functions used across various cspell tools."
HOMEPAGE = "https://github.com/streetsidesoftware/cspell#readme"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1befbdcbeb73a7fd9b944d31f0fee64"

DEPENDS = "npm-comment-json-native \
           npm-configstore-native \
           npm-cosmiconfig-native \
           npm-cspell-cspell-bundled-dicts-native \
           npm-cspell-cspell-types-native \
           npm-cspell-glob-native \
           npm-cspell-io-native \
           npm-cspell-trie-lib-native \
           npm-fs-extra-native \
           npm-gensequence-native \
           npm-resolve-from-native \
           npm-resolve-global-native \
           npm-vscode-uri-native"

SRC_URI = "https://registry.npmjs.org/cspell-lib/-/cspell-lib-5.5.2.tgz"
SRC_URI[md5sum] = "e89b08f6e4f20ce7abc8f7d6e11ef221"
SRC_URI[sha256sum] = "976b047b04ba6d0e4b6180931b38c20c617fc39e9020eed5e090228d1b0ed3be"

NPM_PKGNAME = "cspell-lib"

inherit npmhelper
inherit native
