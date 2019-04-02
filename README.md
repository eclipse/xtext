# Eclipse Support For The Xtext Framework

This repository contains all Eclipse related code for Xtext, including
 - the [general Eclipse support](https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html) for Xtext languages,
 - the Xtext SDK for Eclipse itself.

## How To Build

Checkout and run `mvn clean install`.

Note: The [target platform](releng/org.eclipse.xtext.target/org.eclipse.xtext.target-luna.target) used for the Tycho build loads the required Xtext dependencies ([xtext-lib](https://github.com/eclipse/xtext-lib), [xtext-core](https://github.com/eclipse/xtext-core), [xtext-extras](https://github.com/eclipse/xtext-extras)) from their respective p2 repositories on the [Jenkins server](https://ci.eclipse.org/xtext/).

## How to Work with the Source Code

For
 * how to setup your workspace,
 * how to contribute,
 * and many other useful guides

see [xtext/CONTRIBUTING.md](https://github.com/eclipse/xtext/blob/master/CONTRIBUTING.md).

## Continuous Integration

This project is built by the [xtext-eclipse multi-branch job on Jenkins](https://ci.eclipse.org/xtext/job/xtext-eclipse/).
