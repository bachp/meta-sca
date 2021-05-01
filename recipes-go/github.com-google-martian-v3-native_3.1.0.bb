SUMMARY = "go.mod: github.com/google/martian/v3"
HOMEPAGE = "https://pkg.go.dev/github.com/google/martian/v3"

# License is determined by the modules included and will be therefore computed
LICENSE = "${@' & '.join(sorted(set(x for x in (d.getVar('GOSRC_LICENSE') or '').split(' ') if x)))}"

# inject the needed sources
require github.com-google-martian-v3-sources.inc

EXTRA_DEPENDS += "\
    golang.org-x-net-native \
"

GO_IMPORT = "github.com/google/martian/v3"

inherit gosrc
inherit native
