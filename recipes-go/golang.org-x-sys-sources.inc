SRC_URI += "https://proxy.golang.org/golang.org/x/sys/@v/v0.0.0-20210603125802-9665404d3644.zip;srcoutput=golang.org/x/sys;srcinput=golang.org/x/sys@v0.0.0-20210603125802-9665404d3644;downloadfilename=golang-org-x-sys-0.0.0-20210603125802-9665404d3644.zip;name=golang-org-x-sys"
SRC_URI[golang-org-x-sys.sha256sum] = "9f29a987fe0470ed135b36a75aaa913d17947bebdb2ce4bba4c134eb3b5b5463"

GOSRC_LICENSE += "\
    BSD-3-Clause \
"
LIC_FILES_CHKSUM += "\
    file://src/golang.org/x/sys/LICENSE;md5=5d4950ecb7b26d2c5e4e7b4e0dd74707 \
"

GOSRC_INCLUDEGUARD += "golang.org-x-sys-sources.inc"

