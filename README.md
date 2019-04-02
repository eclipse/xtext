# Maven Support For The Xtext Framework

This repository contains the [Maven plug-in for Xtext](https://www.eclipse.org/Xtext/documentation/350_continuous_integration.html).

## How To Build

Checkout and run `mvn clean install -PuseSonatypeSnapshots`.

With the above configuration, [Sonatype snapshots](https://oss.sonatype.org/content/repositories/snapshots) are used for upstream Xtext dependencies. The alternative profile `-PuseJenkinsSnapshots` activates the Maven repositories generated on the [Jenkins server](https://ci.eclipse.org/xtext/) for [xtext-lib](https://github.com/eclipse/xtext-lib), [xtext-core](https://github.com/eclipse/xtext-core), and [xtext-extras](https://github.com/eclipse/xtext-extras) instead.

## Continuous Integration

This project is built by the [xtext-maven multi-branch job on Jenkins](https://ci.eclipse.org/xtext/job/xtext-maven/).
