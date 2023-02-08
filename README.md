# Eclipse Support For The Xtext Framework

This repository contains all Eclipse related code for Xtext, including
 - the [general Eclipse support](https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html) for Xtext languages,
 - the Xtext SDK for Eclipse itself.

## How To Build

Checkout and run `mvn clean install`.

Note: The [target platform](releng/org.eclipse.xtext.target/org.eclipse.xtext.target-luna.target) used for the Tycho build loads the required Xtext dependencies ([xtext-lib](https://github.com/eclipse/xtext-lib), [xtext-core](https://github.com/eclipse/xtext-core), [xtext-extras](https://github.com/eclipse/xtext-extras)) from their respective p2 repositories on the [Jenkins server](https://ci.eclipse.org/xtext/).

Note: The default Maven profile uses Tycho 2.6.0. If you use Tycho 2.7.0+ on the same machine, you may run into [an issue](https://github.com/eclipse-tycho/tycho/issues/725) with an error about `bundleLocation not found`. One workaround is to use a separate Maven repository for Tycho 2.6.0: `mvn -Dmaven.repo.local=./some/path clean install`. Another workaround is to use a different Xtext Maven profile such as `latest` which uses a newer Tycho version: `mvn -P latest clean install`.

## How to Work with the Source Code

For
 * how to setup your workspace,
 * how to contribute,
 * and many other useful guides

see [xtext/CONTRIBUTING.md](https://github.com/eclipse/xtext/blob/master/CONTRIBUTING.md).

## Continuous Integration

This project is built by the [xtext-eclipse multi-branch job on Jenkins](https://ci.eclipse.org/xtext/job/xtext-eclipse/).
