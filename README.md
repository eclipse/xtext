# Eclipse Xtext Extras

This repository contains platform-independent add-ons such as [Xbase](https://www.eclipse.org/Xtext/documentation/305_xbase.html).

## How To Build

Check out and run `./gradlew build`.

The additional command line argument `-PcompileXtend=true` activates the [Xtend](http://xtend-lang.org) compiler, but this is optional because the generated Java code is included in the repository.

## Continuos Integration

http://services.typefox.io/open-source/jenkins/job/xtext-extras/
