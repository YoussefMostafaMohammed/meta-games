SUMMARY = "Minecraft Pi Edition for Raspberry Pi"
DESCRIPTION = "Prebuilt Minecraft Pi binary adapted for Raspberry Pi OS"
HOMEPAGE = "https://www.minecraft.net/en-us/edition/pi"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${S}/LICENSE.txt;md5=ce27c57ce884d2969f6f2ba4c4cd8508"

PV = "0.1.1"
PR = "r0"

SRC_URI = "file://minecraft-pi-${PV}.tar.gz"

S = "${WORKDIR}/mcpi"

DEPENDS = " \
    userland \
    libx11 \
    libxext \
    libpng12 \
    libsdl \
"

RDEPENDS:${PN} += " \
    userland \
    libegl \
    libgles2 \
    libx11 \
    libxext \
    libsdl \
    libpng12 \
"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${datadir}/games/minecraft-pi
    cp -r ${S}/* ${D}${datadir}/games/minecraft-pi/
    
    cat > ${D}${bindir}/minecraft-pi << "EOF"
#!/bin/sh
export LD_LIBRARY_PATH="/opt/vc/lib:${LD_LIBRARY_PATH}"
cd ${datadir}/games/minecraft-pi
exec ./minecraft-pi
EOF
    chmod 755 ${D}${bindir}/minecraft-pi
}

FILES:${PN} += " \
    ${bindir}/minecraft-pi \
    ${datadir}/games/minecraft-pi \
"

INSANE_SKIP:${PN} += "already-stripped file-rdeps"