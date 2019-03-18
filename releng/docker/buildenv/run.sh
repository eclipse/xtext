#!/bin/bash
docker run -it -v $HOME:/home/$(whoami) smoht/xtext-buildenv:latest
