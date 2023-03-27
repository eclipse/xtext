# Maintenance Tasks

This document describes things that need to be done during a simrel.

## Bump versions

With a final release the Xtext version has to be incremented. This is triggered automatically by the [sign-and-deploy job](https://ci.eclipse.org/xtext/job/releng/job/sign-and-deploy/) when a GA release is deployed. This triggers the [bot-updates job](https://ci.eclipse.org/xtext/job/releng/job/bot-updates/) with `UPDATE_TYPE=XTEXT-VERSION` and `UPDATE_VALUE=<NEW_MINOR_VERSION>`.

Wait for the builds of the branches, review and merge PRs.

For version updates in the micro or major version the [bot-updates job](https://ci.eclipse.org/xtext/job/releng/job/bot-updates/) has to be run manually. Please take care that the `SOURCE_BRANCH` parameter may be different than '`master`'.

## Xtend/Xtext Bootstrapping

Run [https://ci.eclipse.org/xtext/job/releng/job/bot-updates/build](https://ci.eclipse.org/xtext/job/releng/job/bot-updates/build) with parameters:

* `UPDATE_TYPE=XTEXT_BOOTSTRAP_VERSION`
* `UPDATE_VALUE=<Version to Bootstrap against>`
* `GIT_USER_NAME=<Your Full Name>`
* `GIT_USER_EMAIL=<Your GitHub/Eclipse Email Address>`

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
* The simrel `https://download.eclipse.org/releases/<version>` needs also to be used in `./xtext-eclipse/org.eclipse.xtext.xtext.ui.examples/projects/domainmodel/org.eclipse.xtext.example.domainmodel.releng/tp/domainmodel.target` and `xtext-core` in `TargetPlatformProject` +  tests adapted (`CliWizardIntegrationTest`)

## Update Orbit

Once Eclipse Orbit provides us with a new simrel orbit alias update site (e.g. `https://download.eclipse.org/tools/orbit/downloads/2019-12`) then we need to adapt our target platforms and the wizard to use it.

Run [https://ci.eclipse.org/xtext/job/releng/job/bot-updates/build](https://ci.eclipse.org/xtext/job/releng/job/bot-updates/build) with parameters:

* `UPDATE_TYPE=ORBIT_URL`
* `UPDATE_VALUE=<New Orbit URL>`
* `GIT_USER_NAME=<Your Full Name>`
* `GIT_USER_EMAIL=<Your GitHub/Eclipse Email Address>`

Wait for the builds of the branches, review and merge PRs.

## Update Oomph Setup for new SimRel

* Open `xtext-eclipse/releng/org.eclipse.xtext.contributor/Xtext.setup`
* Modify variable `p2.orbit` with the new Orbit URL for the release to `https://download.eclipse.org/tools/orbit/downloads/YYYY-MM`
* Modify variable `eclipse.target.platform`
  * Add Choice entry for the new release (`value=YYYY-MM, label='Eclipse YYYY-MM - 4.NN'`)
  * Set default value to new `YYYY-MM` value
* Open _Eclipse Support / Modular Target / Xtext Target Platform_
* Copy the _Repository List_ entry of the latest release and paste it. Rename it to the new SimRel name.
* From the previously copied _Repository List_ remove the `I-builds` repository entry
* In the new _Repository List_ update the `I-builds` repository entry to the next Eclipse Platform version

## Adapt API-Diff jobs

* Adapt the jobs [Jenkinsfile](https://github.com/xtext/xtext-apidiff/blob/master/Jenkinsfile) and change the choices for old and new version.
* Adapt the jobs [script](https://github.com/xtext/xtext-apidiff/blob/master/create-api-diff.sh)
  * Introduce a new section for the current release.
  * Adapt the nightly section to the current in-development release.
  * Adapt the "Downloading Eclipse" section to pick the current release.

## Update Xtext Reference Projects

The repository [xtext-reference-projects](https://github.com/itemis/xtext-reference-projects) contains a set of projects that are created by the project wizard, and the Domainmodel example. These projects are built by TravisCI.

After each release a new set of projects should be added. Follow the instructions in the repository's [README](https://github.com/itemis/xtext-reference-projects/blob/master/README.md).

## Marketplace

With each release the Marketplace composite site descriptors have to be adjusted. The update steps are described in https://github.com/eclipse/xtext/blob/master/Builds.md#preparing-milestones-and-releases.
