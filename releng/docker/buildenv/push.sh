#!/bin/bash
if [ -z "$1" ]; then
  TAG=latest
else
  TAG=$1
fi

docker push smoht/xtext-buildenv:$TAG
