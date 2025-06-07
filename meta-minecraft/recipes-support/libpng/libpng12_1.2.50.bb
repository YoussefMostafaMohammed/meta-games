SUMMARY = "Legacy libpng 1.2.x"
LICENSE = "Libpng"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c3d807a85c09ebdff087f18b4969ff96"

SRC_URI = "https://downloads.sourceforge.net/project/libpng/libpng12/older-releases/1.2.50/libpng-1.2.50.tar.xz"
SRC_URI[md5sum] = "a3e00fccbfe356174ab515b5c00641c7"
SRC_URI[sha256sum] = "4724f81f8c92ac7f360ad1fbf173396ea7c535923424db9fbaff07bfd9d8e8e7"

DEPENDS = "zlib"

S = "${WORKDIR}/libpng-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-static"

CFLAGS += " \
    -DPNG_NO_MMX_CODE \
    -I${STAGING_INCDIR} \
"

LDFLAGS += " -L${STAGING_LIBDIR} "

# Disable QA check for unrecognized configure options
ERROR_QA:remove = "unknown-configure-option"

BBCLASSEXTEND = "native nativesdk"



