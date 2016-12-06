SUMMARY = "Asteroid's system settings app"
HOMEPAGE = "https://github.com/AsteroidOS/asteroid-settings.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/AsteroidOS/asteroid-settings.git;protocol=https"
SRCREV = "44f907b5e25e301d1c24d92a637fbd4b8ec0a8c2"
PR = "r1"
PV = "+git${SRCREV}"
S = "${WORKDIR}/git"
inherit qmake5

DEPENDS += "qml-asteroid nemo-qml-plugin-systemsettings nemo-qml-plugin-dbus mapplauncherd-booster-qtcomponents"
RDEPENDS_${PN} += "nemo-qml-plugin-systemsettings nemo-qml-plugin-dbus"
FILES_${PN} += "/usr/share/translations/"

do_install_append() {
    lrelease ${S}/asteroid-settings.*.ts
    install -d ${D}/usr/share/translations/
    cp ${S}/asteroid-settings.*.qm ${D}/usr/share/translations/
}
