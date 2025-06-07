SUMMARY = "Minecraft Pi Edition image"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += "splash ssh-server-openssh x11-sato"

# Essential components for Wic and graphics
DEPENDS += " \
    virtual/kernel \
    wic-tools \
    bmap-tools-native \
"

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-base-extended \
    userland \
    libegl \
    libgles2 \
    libpng12 \
    libsdl \
    libx11 \
    libdrm \
    libxext \
    libxcursor \
    minecraft-pi \
    psplash-raspberrypi \
    kernel-image \
    kernel-devicetree \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'packagegroup-core-x11', '', d)} \
"

WKS_FILE = "sdimage-raspberrypi.wks"