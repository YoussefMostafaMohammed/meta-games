DESCRIPTION = "Open Asset Import Library (Assimp)"
HOMEPAGE = "https://github.com/assimp/assimp"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d9d5275cab4fb13ae624d42ce64865de"

# Use official release tarball for stability
SRC_URI = "https://github.com/assimp/assimp/archive/refs/tags/v5.2.5.tar.gz"
SRC_URI[sha256sum] = "b5219e63ae31d895d60d98001ee5bb809fb2c7b2de1e7f78ceeb600063641e1a"

S = "${WORKDIR}/assimp-5.2.5"

# Specify required Boost components
DEPENDS = "zlib"

inherit cmake

EXTRA_OECMAKE = " \
    -DASSIMP_BUILD_ALL_IMPORTERS_BY_DEFAULT=ON \
    -DASSIMP_BUILD_ALL_EXPORTERS_BY_DEFAULT=ON \
    -DASSIMP_BUILD_TESTS=OFF \
    -DASSIMP_BUILD_SAMPLES=OFF \
    -DASSIMP_INSTALL_PDB=OFF \
    -DASSIMP_BUILD_ZLIB=OFF \
"

# Remove unnecessary task overrides
FILES:${PN} += " \
    ${libdir}/libassimp.so.* \
    ${includedir}/assimp \
"
