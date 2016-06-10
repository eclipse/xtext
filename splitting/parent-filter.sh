#!/bin/bash
read INPUT
if [ -n "$INPUT" ]
then
  SHOW_BRANCH=`git show-branch --independent ${INPUT//-p/}`
  for PARENT in $SHOW_BRANCH
  do
    echo -n "-p $PARENT "
  done
fi
