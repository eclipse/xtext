#!/bin/bash

# TODO change source branch to 'master'
git checkout -B split-$3 msp/separateBuilds

REMOVALS=`cat $1 | tr '\n' ' '`
git filter-branch -f --prune-empty \
    --index-filter "git rm -qrf --cached --ignore-unmatch $REMOVALS" \
    --parent-filter $2/parent-filter.sh \
    HEAD
