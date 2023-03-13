#!/bin/bash
if [ -z "$1" ]; then
  TAG=latest
else
  TAG=$1
fi

docker build . -t docker.io/smoht/xtext-buildenv:$TAG
