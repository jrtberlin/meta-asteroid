SUMMARY = "Meego Locale library"
HOMEPAGE = "https://git.merproject.org/mer-core/libmlocale"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE.LGPL;md5=7635eef25dff78f483059bf21a20686d"

SRC_URI = "git://git.merproject.org/mer-core/libmlocale.git;protocol=https \
           file://0003-Disable-tests-and-doc.patch \
           file://0004-configure-Use-a-usr-prefix-by-default.patch \
           file://0005-Make-the-usage-of-icu-namespace-explicit.patch"
SRCREV = "3b0686ab1616b149b26f509ef70bed2c255d1b57"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"

do_configure_prepend() {
    ../git/configure
    sed -i "s@ICUBINDIR = \$\$system(icu-config --bindir)@ICUBINDIR = ${STAGING_DIR_NATIVE}/usr/bin/@" ../git/src/icu-extradata/icu-extradata.pro
}

DEPENDS += "qtbase icu-native qttools-native"
inherit qmake5

FILES_${PN}-dev += "/usr/share/mkspecs/ /usr/lib/libmlocale5.prl"
FILES_${PN}-dbg += "/usr/lib/libmlocale-benchmarks5 /usr/share/libmlocale-benchmarks5"
FILES_${PN} += "/usr/share/mlocale5"
