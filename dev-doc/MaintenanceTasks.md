# Maintenance Tasks

This document describes things that need to be done during a simrel.

## Bump versions

TODO

## Xtend/Xtext Bootstrapping

Run [https://ci.eclipse.org/xtext/job/releng/job/bot-updates/build](https://ci.eclipse.org/xtext/job/releng/job/bot-updates/build) with parameters:

* UPDATE_TYPE=XTEXT_BOOTSTRAP_VERSION
* UPDATE_VALUE=Version to Bootstrap against
* GIT_USER_NAME=
* GIT_USER_EMAIL=

Wait for the builds of the branches, review and merge PRs.

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

We build `xtext-eclipse` and `xtext-xtend` against the latest i-builds of platform and the latest milestone of the rest of the simrel. Thus with every version we have to adapt the target platforms.

* In [xtext-eclipse](https://github.com/eclipse/xtext-eclipse)
  * In `releng/org.eclipse.xtext.target/org.eclipse.xtext.target-latest.target` use the latest i-build `https://download.eclipse.org/eclipse/updates/<number>-I-builds` and simrel `https://download.eclipse.org/releases/<version>`
* In [xtext-xtend](https://github.com/eclipse/xtext-xtend)
  * In  `releng/org.eclipse.xtend.target/org.eclipse.xtend.target-latest.target` use the latest i-build `https://download.eclipse.org/eclipse/updates/<number>-I-builds` and simrel `https://download.eclipse.org/releases/<version>`

## Update Orbit

Once Eclipse Orbit provides us with a new simrel orbit alias update site (e.g. `https://download.eclipse.org/tools/orbit/downloads/2019-12`) then we need to adapt our target platforms and the wizard to use it.

* For the target platforms search and replace in all `.target` files in all repositories e.g. `find . -name "*.target" -type f  | xargs sed -i "s?/tools/orbit/downloads/2019-12?/tools/orbit/downloads/2020-03?g"`.
* For the wizard adapt `TargetPlatformProject` in `xtext-core` and run/fix `CliWizardIntegrationTest`.

## Update Oomph to new simrel

TODO

## Adap API-Diff jobs

* Adapt the jobs [Jenkinsfile](https://github.com/xtext/xtext-apidiff/blob/master/Jenkinsfile) and change the choices for old and new version.
* Adapt the jobs [script](https://github.com/xtext/xtext-apidiff/blob/master/create-api-diff.sh)
  * Introduce a new section for the current release.
  * Adapt the nightly section to the current in-development release.
  * Adapt the "Downloading Eclipse" section to pick the current release.
