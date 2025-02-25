SRC_URI += "https://proxy.golang.org/github.com/hudl/fargo/@v/v1.3.0.zip;srcoutput=github.com/hudl/fargo;srcinput=github.com/hudl/fargo@v1.3.0;downloadfilename=github-com-hudl-fargo-1.3.0.zip;name=github-com-hudl-fargo"
SRC_URI[github-com-hudl-fargo.sha256sum] = "040aa24d7c5cdf43ed18767d4dff7d5533c65f58f45424f38eed51a5956445cf"
GOSRC_REMOVEDIRS += "github.com/hudl/fargo/tests"

GOSRC_LICENSE += "\
    MIT \
"
LIC_FILES_CHKSUM += "\
    file://src/github.com/hudl/fargo/README.md;md5=74755580a9b05b4b8a1f577d1c178498 \
    file://src/github.com/hudl/fargo/config.go;md5=9826d50764ceba4e3254a9cfe68f7a17 \
    file://src/github.com/hudl/fargo/connection.go;md5=377cf23679ad5e9f803045df1e0dcec9 \
    file://src/github.com/hudl/fargo/dns_discover.go;md5=e1d8edd05d8013d7b0eca944bb7e9f54 \
    file://src/github.com/hudl/fargo/dns_discover_test.go;md5=fdb2aad59bffc3bc4d4868d22dac516f \
    file://src/github.com/hudl/fargo/errors.go;md5=50de211b9a6d2700739d307c75986ef2 \
    file://src/github.com/hudl/fargo/errors_test.go;md5=50171c23aaeda44f92aefb164f2363ee \
    file://src/github.com/hudl/fargo/example_appupdate_test.go;md5=ff58f467ec4fc0fbe008abe01bec0981 \
    file://src/github.com/hudl/fargo/example_common_test.go;md5=16c40a198b057bc86001ff35a7d85d3e \
    file://src/github.com/hudl/fargo/example_instancesetsource_test.go;md5=9777bf2ddeec937ba54abbcfdb84c567 \
    file://src/github.com/hudl/fargo/example_vipupdate_test.go;md5=d4c073a314cd8c635d7220ae8b0c4e94 \
    file://src/github.com/hudl/fargo/log.go;md5=7e56544b51cf77ec4ff957f3e37341e0 \
    file://src/github.com/hudl/fargo/marshal.go;md5=ec6a39a849388718ca2424eaddfade2f \
    file://src/github.com/hudl/fargo/metadata.go;md5=1a3755933a4b73b23a7c9962063357fa \
    file://src/github.com/hudl/fargo/net.go;md5=8cf8c27b2d2e8ce921ccefa10d5d6d34 \
    file://src/github.com/hudl/fargo/net_test.go;md5=5c3e10444597c0c8b6ca1abf77db49f5 \
    file://src/github.com/hudl/fargo/rpc.go;md5=9c9be5d7f7be723b44f2139cf34d4e95 \
    file://src/github.com/hudl/fargo/struct.go;md5=f1e584fc95d4ea63431f519a36480a1d \
"

GOSRC_INCLUDEGUARD += "github.com-hudl-fargo-sources.inc"

require ${@bb.utils.contains('GOSRC_INCLUDEGUARD', 'github.com-cenkalti-backoff-sources.inc', '', 'github.com-cenkalti-backoff-sources.inc', d)}
require ${@bb.utils.contains('GOSRC_INCLUDEGUARD', 'github.com-clbanning-x2j-sources.inc', '', 'github.com-clbanning-x2j-sources.inc', d)}
require ${@bb.utils.contains('GOSRC_INCLUDEGUARD', 'github.com-franela-goreq-sources.inc', '', 'github.com-franela-goreq-sources.inc', d)}
require ${@bb.utils.contains('GOSRC_INCLUDEGUARD', 'github.com-miekg-dns-sources.inc', '', 'github.com-miekg-dns-sources.inc', d)}
require ${@bb.utils.contains('GOSRC_INCLUDEGUARD', 'github.com-op-go-logging-sources.inc', '', 'github.com-op-go-logging-sources.inc', d)}
require ${@bb.utils.contains('GOSRC_INCLUDEGUARD', 'gopkg.in-gcfg.v1-sources.inc', '', 'gopkg.in-gcfg.v1-sources.inc', d)}
