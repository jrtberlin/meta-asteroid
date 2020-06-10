FILESEXTRAPATHS_prepend := "${THISDIR}/qtwayland:"
SRC_URI += " file://0002-Revert-most-of-Remove-QWaylandExtendedSurface-from-t.patch"

DEPENDS_remove = "${XKB_DEPENDS}"
