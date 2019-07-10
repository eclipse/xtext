#/bin/bash

# Returns BUILD_TYPE based on BUILD_ID
#
# $1 BUILD_ID
#
# BUILD_TYPE N=Nightly, S=Stable, R=Release

if [ ! "$1" ]; then
    echo "Error: No BUILD_ID provided" >&2
    exit 1
fi

BUILD_TYPE=$(echo $1 |cut -c 1)

if [ ! "$BUILD_TYPE" == "N" ] && [ ! "$BUILD_TYPE" == "S" ] && [ ! "$BUILD_TYPE" == "R" ]; then
    echo "Invalid BUILD_ID provided" >&2
    exit 1
fi

echo $BUILD_TYPE
