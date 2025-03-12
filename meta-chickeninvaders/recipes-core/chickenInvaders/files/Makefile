CXX ?= g++
INCLUDE = ../../include
BUILD_DIR = build

override CXXFLAGS += -Wall -Wextra -std=c++14 -I$(INCLUDE)
override LDFLAGS += -lSDL2 -lGL -lGLU -lpthread -lIL -lassimp -lboost_system -lboost_filesystem

# Find all source files recursively
SRC := $(shell find ../../src/engine . -name '*.cpp')
OBJ := $(addprefix $(BUILD_DIR)/,$(SRC:.cpp=.o))

# Ensure build directory structure exists
$(shell mkdir -p $(dir $(OBJ)))

.PHONY: all clean

all: $(BUILD_DIR)/chicken-invaders

$(BUILD_DIR)/chicken-invaders: $(OBJ)
	$(CXX) $^ $(LDFLAGS) -o $@

$(BUILD_DIR)/%.o: %.cpp
	$(CXX) $(CXXFLAGS) -c $< -o $@

clean:
	rm -rf $(BUILD_DIR)
