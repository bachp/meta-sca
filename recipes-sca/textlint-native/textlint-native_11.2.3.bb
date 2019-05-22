SUMMARY = "The pluggable natural language linter for text and markdown."
DESCRIPTION = "The pluggable natural language linter for text and markdown."
HOMEPAGE = "https://github.com/textlint/textlint"

SRC_URI = "file://textlint.sca.description \
           file://textlint.sca.score"

LICENSE = "MIT"
LIC_FILES_CHKSUM  = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

do_configure[noexec] = "1"

FILES_${PN} = "${datadir}/"

inherit native
inherit npm-helper

python do_compile() {
    import os
    import json

    # npm --prefix . install textlint@11.2.3
    # npm --prefix . install textlint-rule-no-todo@2.0.1
    # npm --prefix . install textlint-rule-no-start-duplicated-conjunction@2.0.2
    # npm --prefix . install textlint-rule-max-number-of-lines@1.0.3
    # npm --prefix . install textlint-rule-max-comma@1.0.4
    # npm --prefix . install textlint-rule-no-exclamation-question-mark@1.0.2
    # npm --prefix . install textlint-rule-ng-word@1.0.0
    # npm --prefix . install textlint-rule-no-dead-link@4.4.1
    # npm --prefix . install textlint-rule-no-empty-section@1.1.0
    # npm --prefix . install textlint-rule-unexpanded-acronym@1.2.3
    # npm --prefix . install textlint-rule-alex@1.3.1
    # npm --prefix . install textlint-rule-write-good@latest
    # npm --prefix . install textlint-rule-rousseau@1.4.5
    # npm --prefix . install textlint-rule-en-max-word-count@1.0.1
    # npm --prefix . install textlint-filter-rule-comments@1.2.2
    # npm --prefix . install textlint-plugin-html@0.2.0
    # npm --prefix . install textlint-plugin-rst@latest
    # npm --prefix . install textlint-rule-date-weekday-mismatch@1.0.5
    # npm --prefix . install textlint-rule-terminology@1.1.30
    # npm --prefix . install textlint-rule-period-in-list-item@0.3.0
    # npm --prefix . install textlint-rule-no-nfd@1.0.1
    # npm --prefix . install @textlint-rule/textlint-rule-no-invalid-control-character@1.2.0
    # npm --prefix . install textlint-rule-no-surrogate-pair@1.0.1
    # npm --prefix . install textlint-rule-abbr-within-parentheses@1.0.2
    # npm --prefix . install textlint-rule-common-misspellings@latest
    # npm --prefix . install textlint-rule-ginger@2.2.1
    # npm --prefix . install textlint-rule-apostrophe@1.0.0
    # npm --prefix . install textlint-rule-diacritics@0.0.2
    # npm --prefix . install textlint-rule-stop-words@1.0.13
    # npm --prefix . install textlint-rule-en-capitalization@2.0.2

    online_pkgs = ["textlint-rule-no-dead-link"]
    plugins = ["textlint-plugin-html", "textlint-plugin-rst"]
    filters = ["textlint-filter-rule-comments"]

    with open(os.path.join(d.getVar("B"), "online-rules.json"), "w") as o:
        json.dump(online_pkgs, o)

    ## Install needed pkgs
    pkgs = {
        "execa": "0.7.0",
        "moment": "2.24.0",
        "escape-html": "1.0.3",
        "textlint-rule-no-todo": "2.0.1",
        "unist-util-remove-position": "1.1.2",
        "nlcst-is-literal": "1.1.2",
        "textlint-rule-terminology": "1.1.30",
        "form-data": "2.3.3",
        "vfile-location": "2.0.4",
        "unified": "2.1.4",
        "strip-json-comments": "2.0.1",
        "safe-buffer": "5.1.2",
        "array-iterate": "1.1.3",
        "commander": "2.20.0",
        "log-symbols": "1.0.2",
        "lodash.isarguments": "3.1.0",
        "resolve-from": "4.0.0",
        "ret": "0.1.15",
        "isomorphic-fetch": "2.2.1",
        "unist-util-map": "1.0.4",
        "map-like": "1.1.3",
        "textlint-rule-no-surrogate-pair": "1.0.1",
        "cuss": "1.13.1",
        "simple-lru-cache": "0.0.1",
        "require-from-string": "2.0.2",
        "redent": "1.0.0",
        "path-type": "3.0.0",
        "htmlparser2": "3.10.1",
        "ansi-regex": "3.0.0",
        "nlcst-normalize": "2.1.2",
        "sentence-case": "1.1.3",
        "ci-info": "1.6.0",
        "request": "2.88.0",
        "slice-ansi": "0.0.4",
        "textlint-rule-ng-word": "1.0.0",
        "bcrypt-pbkdf": "1.0.2",
        "is-alphanumerical": "1.0.2",
        "parse-english": "4.1.1",
        "en-inflectors": "1.0.12",
        "textlint-rule-period-in-list-item": "0.3.0",
        "file-entry-cache": "2.0.0",
        "parse-entities": "1.2.1",
        "forever-agent": "0.6.1",
        "registry-url": "3.1.0",
        "object-keys": "0.4.0",
        "ajv-keywords": "1.5.1",
        "domelementtype": "1.3.1",
        "textlint-rule-stop-words": "1.0.13",
        "fast-json-stable-stringify": "2.0.0",
        "buffer-from": "1.1.1",
        "crypt": "0.0.2",
        "interop-require": "1.0.0",
        "camelcase-keys": "2.1.0",
        "adverb-where": "0.0.9",
        "pinkie": "2.0.4",
        "fn-name": "2.0.1",
        "encoding": "0.1.12",
        "passive-voice": "0.1.0",
        "is-arrayish": "0.2.1",
        "regex-not": "1.0.2",
        "aws-sign2": "0.7.0",
        "update-notifier": "2.5.0",
        "npm-prefix": "1.2.0",
        "tokenize-text": "1.1.3",
        "brace-expansion": "1.1.11",
        "match-casing": "1.0.1",
        "unique-string": "1.0.0",
        "domutils": "1.7.0",
        "@textlint/markdown-to-ast": "6.1.3",
        "asn1": "0.2.4",
        "has-ansi": "2.0.0",
        "boundary": "1.0.1",
        "@textlint/ast-traverse": "2.1.3",
        "traverse": "0.6.6",
        "pseudomap": "1.0.2",
        "alex": "5.1.0",
        "package-json": "4.0.1",
        "vfile-statistics": "1.1.2",
        "emoji-regex": "6.5.1",
        "lodash._basecopy": "3.0.1",
        "unist-util-visit": "1.4.0",
        "extsprintf": "1.3.0",
        "unzip-response": "2.0.1",
        "pump-chain": "1.0.0",
        "replace-ext": "1.0.0",
        "import-lazy": "2.1.0",
        "lodash.intersection": "4.4.0",
        "find-up": "1.1.2",
        "textlint-rule-date-weekday-mismatch": "1.0.5",
        "cli-boxes": "1.0.0",
        "argparse": "1.0.10",
        "@textlint/types": "1.1.5",
        "readable-stream": "3.3.0",
        "util-deprecate": "1.0.2",
        "@textlint-rule/textlint-rule-no-invalid-control-character": "1.2.0",
        "normalize-package-data": "2.5.0",
        "path-is-inside": "1.0.2",
        "qs": "6.5.2",
        "ansi-styles": "3.2.1",
        "flat-cache": "1.3.4",
        "extend": "3.0.2",
        "es-to-primitive": "1.2.0",
        "is-hidden": "1.1.1",
        "strip-bom": "2.0.0",
        "diff": "2.2.3",
        "unist-util-filter": "0.2.1",
        "is-callable": "1.1.4",
        "lodash": "3.10.1",
        "write-good": "0.11.3",
        "unist-util-visit-children": "1.1.2",
        "through2": "2.0.5",
        "hast": "0.0.2",
        "character-reference-invalid": "1.1.2",
        "p-limit": "1.3.0",
        "spdx-exceptions": "2.2.0",
        "read-pkg-up": "1.0.1",
        "x-is-function": "1.0.4",
        "duplexer": "0.1.1",
        "nlcst-to-string": "2.0.2",
        "cities-list": "1.0.3",
        "safe-regex": "1.1.0",
        "lower-case": "1.1.4",
        "isarray": "0.0.1",
        "weasel-words": "0.1.1",
        "resolve": "1.10.1",
        "map-obj": "1.0.1",
        "boxen": "1.3.0",
        "regexp.prototype.flags": "1.2.0",
        "vfile-find-up": "2.0.2",
        "get-stream": "3.0.0",
        "en-pos": "1.0.16",
        "to-vfile": "2.2.0",
        "dashdash": "1.14.1",
        "textlint-rule-alex": "1.3.1",
        "which": "1.3.1",
        "timed-out": "4.0.1",
        "jsprim": "1.4.1",
        "unique-concat": "0.2.2",
        "x-is-string": "0.1.0",
        "json-schema-traverse": "0.4.1",
        "got": "6.7.1",
        "unist-util-select": "1.5.0",
        "xtend": "2.1.2",
        "p-try": "1.0.0",
        "end-with": "1.0.2",
        "iconv-lite": "0.4.24",
        "dot-prop": "4.2.0",
        "function-bind": "1.1.1",
        "json-stringify-safe": "5.0.1",
        "textlint-rule-helper": "1.2.0",
        "unist-util-position": "3.0.2",
        "e-prime": "0.10.2",
        "boolbase": "1.0.0",
        "no-cliches": "0.1.1",
        "lodash._createassigner": "3.1.1",
        "split-lines": "2.0.0",
        "charenc": "0.0.2",
        "co": "3.1.0",
        "select-section": "0.4.6",
        "path-is-absolute": "1.0.1",
        "es6-promisify": "5.0.0",
        "ent": "2.2.0",
        "is-date-object": "1.0.1",
        "getpass": "0.1.7",
        "define-properties": "1.1.3",
        "crc": "3.2.1",
        "textlint-plugin-html": "0.2.0",
        "bluebird": "3.5.4",
        "lodash._getnative": "3.9.1",
        "latest-version": "3.1.0",
        "@azu/format-text": "1.0.1",
        "concat-map": "0.0.1",
        "textlint-util-to-string": "2.1.1",
        "tough-cookie": "2.4.3",
        "to-regex": "3.0.2",
        "@textlint/text-to-ast": "3.1.3",
        "format": "0.2.2",
        "domhandler": "2.4.2",
        "read-pkg": "1.1.0",
        "es6-promise": "4.2.6",
        "structured-source": "3.0.2",
        "shellsubstitute": "1.2.0",
        "is-npm": "1.0.0",
        "map-stream": "0.1.0",
        "remark-parse": "4.0.0",
        "lodash.defaults": "3.1.2",
        "@textlint/fixer-formatter": "3.1.5",
        "@textlint/feature-flag": "3.1.3",
        "uri-js": "4.2.2",
        "esprima": "4.0.1",
        "ini": "1.3.5",
        "quotation": "1.1.1",
        "strip-eof": "1.0.0",
        "@types/bluebird": "3.5.26",
        "ecc-jsbn": "0.1.2",
        "is-whitespace-character": "1.0.2",
        "bash-color": "0.0.3",
        "typedarray": "0.0.6",
        "lodash.difference": "4.5.0",
        "assert-plus": "1.0.0",
        "parse-json": "4.0.0",
        "is-retry-allowed": "1.1.0",
        "whatwg-fetch": "3.0.0",
        "repeating": "2.0.1",
        "is-typedarray": "1.0.0",
        "event-stream": "3.1.7",
        "node-fetch": "1.7.3",
        "is-object": "1.0.1",
        "textlint-rule-abbr-within-parentheses": "1.0.2",
        "write": "0.2.1",
        "humannames": "1.0.5",
        "object.values": "1.1.0",
        "os-homedir": "1.0.2",
        "remark-frontmatter": "1.3.1",
        "stream-combiner": "0.0.4",
        "load-json-file": "4.0.0",
        "mdast-util-to-nlcst": "3.2.2",
        "object-assign": "4.1.1",
        "oauth-sign": "0.9.0",
        "misspellings": "1.1.0",
        "is-installed-globally": "0.1.0",
        "execall": "1.0.0",
        "json-schema": "0.2.3",
        "lodash._bindcallback": "3.0.1",
        "pump": "1.0.3",
        "md5": "2.2.1",
        "is-plain-obj": "1.1.0",
        "unified-diff": "1.0.2",
        "untildify": "2.1.0",
        "minimist": "1.2.0",
        "fs-extra": "5.0.0",
        "textlint-rule-no-nfd": "1.0.1",
        "inherits": "2.0.3",
        "vfile-sort": "2.2.0",
        "ajv": "6.10.0",
        "lodash.uniq": "4.5.0",
        "json-stable-stringify": "1.0.1",
        "is-redirect": "1.0.0",
        "p-finally": "1.0.0",
        "is-regexp": "1.0.0",
        "p-locate": "2.0.0",
        "unorm": "1.5.0",
        "too-wordy": "0.1.6",
        "code-point-at": "1.1.0",
        "pinkie-promise": "2.0.1",
        "inflight": "1.0.6",
        "en-stemmer": "1.0.3",
        "path-exists": "2.1.0",
        "is-finite": "1.0.2",
        "imurmurhash": "0.1.4",
        "is-supported-regexp-flag": "1.0.1",
        "locate-path": "2.0.0",
        "unified-message-control": "1.0.4",
        "is-file": "1.0.0",
        "make-dir": "1.3.0",
        "xml-escape": "1.1.0",
        "safer-buffer": "2.1.2",
        "har-schema": "2.0.0",
        "json-parse-better-errors": "1.0.2",
        "lowercase-keys": "1.0.1",
        "textlint-rule-no-dead-link": "4.4.1",
        "core-util-is": "1.0.2",
        "@textlint/kernel": "3.1.6",
        "sshpk": "1.16.1",
        "assign-symbols": "1.0.0",
        "is-ci": "1.2.1",
        "glob": "7.1.3",
        "vfile": "1.4.0",
        "is-plain-object": "2.0.4",
        "param-case": "1.1.2",
        "@textlint/ast-node-types": "4.2.2",
        "uuid": "3.3.2",
        "registry-auth-token": "3.4.0",
        "psl": "1.1.31",
        "currently-unhandled": "0.4.1",
        "minimatch": "3.0.4",
        "is-extendable": "1.0.1",
        "lodash.isarray": "3.0.4",
        "create-error-class": "3.0.2",
        "txt-ast-traverse": "1.2.1",
        "try-resolve": "1.0.1",
        "textlint-rule-no-empty-section": "1.1.0",
        "tokenize-htmltext": "1.0.0",
        "@azu/style-format": "1.0.0",
        "nth-check": "1.0.2",
        "has": "1.0.3",
        "remark-retext": "3.1.2",
        "widest-line": "2.0.1",
        "textlint-rule-no-exclamation-question-mark": "1.0.2",
        "prelude-ls": "1.1.2",
        "chalk": "2.4.2",
        "retext-equality": "3.2.0",
        "spdx-license-ids": "3.0.4",
        "retext-english": "3.0.2",
        "camelcase": "1.2.1",
        "debug": "2.6.9",
        "entities": "1.1.2",
        "unist-util-modify-children": "1.1.3",
        "tweetnacl": "0.14.5",
        "decamelize": "1.2.0",
        "textlint-rule-ginger": "2.2.1",
        "wordwrap": "1.0.0",
        "wrappy": "1.0.2",
        "clone-regexp": "1.0.1",
        "type-check": "0.3.2",
        "signal-exit": "3.0.2",
        "color-convert": "1.9.3",
        "string.prototype.padstart": "3.0.0",
        "isstream": "0.1.2",
        "punycode": "1.4.1",
        "trim-newlines": "1.0.0",
        "nlcst-search": "1.5.0",
        "fast-deep-equal": "2.0.1",
        "remark-message-control": "4.1.1",
        "textlint-rule-max-number-of-lines": "1.0.3",
        "match-index": "1.0.1",
        "is-descriptor": "1.0.2",
        "concat-stream": "1.6.2",
        "es-abstract": "1.13.0",
        "is-fullwidth-code-point": "2.0.0",
        "combined-stream": "1.0.7",
        "unherit": "1.1.1",
        "bail": "1.0.4",
        "supports-color": "4.5.0",
        "spdx-expression-parse": "3.0.0",
        "rimraf": "2.6.3",
        "http-signature": "1.2.0",
        "js-yaml": "3.13.1",
        "asynckit": "0.4.0",
        "is-decimal": "1.0.2",
        "write-file-atomic": "2.4.2",
        "is-hexadecimal": "1.0.2",
        "is-symbol": "1.0.2",
        "url-parse-lax": "1.0.0",
        "aws4": "1.8.0",
        "end-of-stream": "1.4.1",
        "css-selector-parser": "1.3.0",
        "circular-json": "0.3.3",
        "is-utf8": "0.2.1",
        "textlint-rule-max-comma": "1.0.4",
        "trim-trailing-lines": "1.1.1",
        "textlint-rule-common-misspellings": "1.0.1",
        "ware": "1.3.0",
        "bubble-stream-error": "0.0.1",
        "once": "1.4.0",
        "error-ex": "1.3.2",
        "delayed-stream": "1.0.0",
        "gingerbread": "0.5.0",
        "universalify": "0.1.2",
        "process-nextick-args": "2.0.0",
        "check-ends-with-period": "1.0.1",
        "textlint-plugin-rst": "0.1.1",
        "dom-serializer": "0.1.1",
        "@textlint/linter-formatter": "3.1.5",
        "textlint-filter-rule-comments": "1.2.2",
        "is-word-character": "1.0.2",
        "object.assign": "4.1.0",
        "rc-config-loader": "2.0.2",
        "is-empty": "1.2.0",
        "global-dirs": "0.1.1",
        "vfile-reporter": "4.0.0",
        "colors": "1.0.3",
        "vfile-message": "1.1.1",
        "yallist": "2.1.2",
        "strip-indent": "1.0.1",
        "extend-shallow": "3.0.2",
        "path-to-glob-pattern": "1.0.2",
        "fast-levenshtein": "2.0.6",
        "json5": "1.0.1",
        "crypto-random-string": "1.0.0",
        "lodash._isiterateecall": "3.0.9",
        "property-information": "2.0.0",
        "get-stdin": "4.0.1",
        "jsonfile": "4.0.0",
        "spawn-to-readstream": "0.1.3",
        "lru-cache": "4.1.5",
        "path-key": "2.0.1",
        "number-is-nan": "1.0.1",
        "lodash.keys": "3.1.2",
        "verror": "1.10.0",
        "unist-util-visit-parents": "2.0.1",
        "meow": "3.7.0",
        "git-spawned-stream": "0.1.1",
        "retext-profanities": "4.4.0",
        "lodash.uniqwith": "4.5.0",
        "character-entities": "1.2.2",
        "textlint-rule-unexpanded-acronym": "1.2.3",
        "tunnel-agent": "0.6.0",
        "fs.realpath": "1.0.0",
        "unist-util-stringify-position": "1.1.2",
        "escape-string-regexp": "1.0.5",
        "parse-latin": "4.1.1",
        "jsbn": "0.1.1",
        "textlint-rule-write-good": "1.6.2",
        "@textlint/textlint-plugin-text": "4.1.6",
        "from": "0.1.7",
        "ansi-align": "2.0.0",
        "sentence-splitter": "2.3.2",
        "cli-table": "0.3.1",
        "through": "2.3.8",
        "mkdirp": "0.5.1",
        "pify": "3.0.0",
        "jsonify": "0.0.0",
        "unified-engine": "4.0.1",
        "is-alphabetical": "1.0.2",
        "split-string-words": "1.0.0",
        "indent-string": "2.1.0",
        "wrap-fn": "0.1.5",
        "caseless": "0.12.0",
        "is-capitalized": "1.0.0",
        "semver-diff": "2.1.0",
        "define-property": "2.0.2",
        "isobject": "3.0.1",
        "mime-types": "2.1.24",
        "fault": "1.0.2",
        "semver": "5.7.0",
        "sprintf-js": "1.0.3",
        "unist-util-is": "1.0.0",
        "array-find-index": "1.0.2",
        "is-regex": "1.0.4",
        "deep-equal": "1.0.1",
        "@textlint/regexp-string-matcher": "1.0.2",
        "cross-spawn": "5.1.0",
        "load-plugin": "2.3.0",
        "trough": "1.0.3",
        "is-stream": "1.1.0",
        "path-parse": "1.0.6",
        "is-buffer": "1.1.6",
        "split-transform-stream": "0.1.1",
        "sliced": "1.0.1",
        "kind-of": "6.0.2",
        "textlint-rule-diacritics": "0.0.2",
        "trim": "0.0.1",
        "rousseau": "1.0.5",
        "pluralize": "7.0.0",
        "character-entities-legacy": "1.1.2",
        "find-line-column": "0.5.2",
        "textlint-rule-no-start-duplicated-conjunction": "2.0.2",
        "spdx-correct": "3.1.0",
        "has-symbols": "1.0.0",
        "table": "3.8.3",
        "capture-stack-trace": "1.0.1",
        "color-name": "1.1.3",
        "deep-is": "0.1.3",
        "balanced-match": "1.0.0",
        "lodash._baseassign": "3.2.0",
        "performance-now": "2.1.0",
        "string-width": "2.1.1",
        "flatmap": "0.0.3",
        "collapse-white-space": "1.0.5",
        "@textlint/textlint-plugin-markdown": "5.1.6",
        "shebang-command": "1.2.0",
        "har-validator": "5.1.3",
        "ms": "2.0.0",
        "is-accessor-descriptor": "1.0.0",
        "loud-rejection": "1.6.0",
        "validate-npm-package-license": "3.0.4",
        "is-data-descriptor": "1.0.0",
        "optionator": "0.8.2",
        "is-obj": "1.0.1",
        "git-diff-tree": "1.0.0",
        "graceful-fs": "4.1.15",
        "state-toggle": "1.0.1",
        "levn": "0.3.0",
        "hosted-git-info": "2.7.1",
        "prepend-http": "1.0.4",
        "textlint": "11.2.3",
        "configstore": "3.1.2",
        "shebang-regex": "1.0.0",
        "limit-spawn": "0.0.3",
        "markdown-escapes": "1.0.2",
        "repeat-string": "1.6.1",
        "rc": "1.2.8",
        "textlint-rule-apostrophe": "1.0.0",
        "xdg-basedir": "3.0.0",
        "is-path-inside": "1.0.1"
    }

    for name, version in pkgs.items():
        npm_install_package(d, d.getVar("B"), name, version)

    ## Strip of hardcoded paths in packages
    npm_postinst_fix_paths(d, d.getVar("B"), "textlint")
}

INSANE_SKIP_${PN} += "host-user-contaminated"

do_install() {
    mkdir -p ${D}${datadir}/textlint/
    cp -Ra ${B}/* ${D}${datadir}/textlint
    install ${WORKDIR}/textlint.sca.description ${D}${datadir}
    install ${WORKDIR}/textlint.sca.score ${D}${datadir}
}

