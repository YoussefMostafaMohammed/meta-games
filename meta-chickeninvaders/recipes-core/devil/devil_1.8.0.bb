SUMMARY = "DevIL - Developer's Image Library"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fc178bcd425090939a8b634d1d6a9594"

SRC_URI = "https://github.com/DentonW/DevIL/archive/refs/tags/v1.8.0.tar.gz"
SRC_URI[sha256sum] = "52129f247b26fcb5554643c9e6bbee75c4b9717735fdbf3c6ebff08cee38ad37"

DEPENDS = "libjpeg-turbo libpng tiff"

# If the main CMakeLists.txt is in the DevIL subdirectory:
S = "${WORKDIR}/DevIL-1.8.0/DevIL"
# Otherwise, if it’s at the top level, uncomment the following line and comment out the above:
# S = "${WORKDIR}/DevIL-1.8.0"

inherit cmake pkgconfig

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON \
                 -DILUT_BUILD_EXAMPLES=OFF \
                 -DILU_BUILD_EXAMPLES=OFF \
                 -DDEVIL_BUILD_TESTS=OFF"

