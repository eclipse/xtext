# Eclipse Xtext Library

This repository contains the standard library for [Xbase](https://www.eclipse.org/Xtext/documentation/305_xbase.html) languages such as [Xtend](http://xtend-lang.org).

## How To Build

Check out and run `./gradlew build`.

The additional command line argument `-PcompileXtend=true` activates the [Xtend](http://xtend-lang.org) compiler, but this is optional because the generated Java code is included in the repository.

## Continuous Integration

This project is built by the [xtext-lib multi-branch job on Jenkins](https://ci.eclipse.org/xtext/job/xtext-lib/).
