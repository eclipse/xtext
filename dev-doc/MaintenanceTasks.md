# Maintenance Tasks

This document describes things that need to be done during a simrel.

## Bump versions

TODO

## Xtext Bootstrapping

TODO update

1. `versions.gradle` files: Change `xtext_bootstrap` property
1. In xtext-eclipse: `releng/org.eclipse.xtext.tycho.parent/pom.xml` Change `xtend-maven-plugin-version`
1. In xtext-xtend: `releng/org.eclipse.xtend.tycho.parent/pom.xml`: Change `xtend-maven-plugin-version`

## Prepare final simrel target platform

We offer for our `xtext-eclipse` and `xtext-xtend` the possibility to build against any target platform between the minimal and `latest`. Once a new simrel is out we need to add it to the list of the platforms. Here are the steps.

* In [xtext-eclipse](https://github.com/eclipse/xtext-eclipse)
  * Adapt `Jenkinsfile`
    * Add the new release to the `target_platform` choice.
    * Add the new release to the snippet that adapts the `displayName`.
  * Declare new profile in `releng/org.eclipse.xtext.tycho.parent/pom.xml`, `org.eclipse.xtext.ui.codemining/pom.xml` and `org.eclipse.xtext.ui.testing/pom.xml`.
  * Create new target file at `releng/org.eclipse.xtext.target/` and register it in the `releng/org.eclipse.xtext.target/pom.xml`.
* In [xtext-xtend](https://github.com/eclipse/xtext-xtend)
  * Adapt `Jenkinsfile`
    * Add the new release to the `target_platform` choice.
    * Add the new release to the snippet that adapts the `displayName`.
  * Declare new profile in `releng/org.eclipse.xtend.tycho.parent/pom.xml`.
  * Create new target file at `releng/org.eclipse.xtend.target/` and register it in the `releng/org.eclipse.xtend.target/pom.xml`.

## Update latest target platform

TODO

## Update Orbit

TODO

## Update Oomph to new simrel

TODO

## Adap API-Diff jobs

TODO
