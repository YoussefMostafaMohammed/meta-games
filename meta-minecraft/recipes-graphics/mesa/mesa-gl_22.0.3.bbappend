# Enable VC4 Gallium driver for Raspberry Pi
PACKAGECONFIG:append = " gallium vc4"
PACKAGECONFIG:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11 dri3', '', d)}"
