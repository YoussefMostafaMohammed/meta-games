SUMMARY = "Chicken Invaders game"
DESCRIPTION = "Arcade-style space shooter game port for embedded systems"
HOMEPAGE = "https://github.com/atfoc/chicken-invaders"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/atfoc/chicken-invaders.git;protocol=https;branch=master \
           file://fix-application-include.patch"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = " \
    libsdl2 \
    libglu \
    assimp \
    boost \
    glm \
    devil \
"

TARGET_CXXFLAGS:append = " \
    -Wall \
    -Wextra \
    -std=c++14 \
    -I${S}/include \
    -I${STAGING_INCDIR} \
"

do_configure() {
    install -m 0644 ${WORKDIR}/Makefile ${S}/src/game/
}

do_compile() {
    cd ${S}/src/game
    oe_runmake all \
        CXX="${CXX}" \
        CXXFLAGS="${CXXFLAGS}" \
        LDFLAGS="${LDFLAGS}"
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/src/game/build/chicken-invaders ${D}${bindir}/chicken-invaders

    install -d ${D}${datadir}/games/chicken-invaders
    cp -r ${S}/assets/* ${D}${datadir}/games/chicken-invaders/
}

FILES:${PN} += " \
    ${bindir}/chicken-invaders \
    ${datadir}/games/chicken-invaders/* \
"

