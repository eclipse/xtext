This page explains common tasks related to working with Xtext's source code.

## Report an Issue

Please create any new issue in the most appropriate repository (see full list on the [entry page](README.md)). When in doubt, create it in this umbrella repository.

Eclipse Bugzilla issues are deprecated for Xtext. However, we still accept them.

## Set up your Eclipse Workspace
1. Download and start the [Eclipse Installer](https://wiki.eclipse.org/Eclipse_Oomph_Installer).
2. On the initial page, click on the *Switch to Advanced Mode* button in the top right.
3. On the *Product* page, select *Eclipse IDE for Eclipse Committers*.
4. On the *Projects* page, expand the *Xtext* node.
5. Below the *Xtext* node there is a subproject entry for each module. Select those you would like to install. If in doubt, select all of them.
6. Choose your preferred installation settings on the *Variables* page. Enter credentials for your Bugzilla and GitHub account.
7. Finish the wizard, drink a cup of coffee, and watch how your Xtext development environment is assembled.

## Contribute via Fork
All you need is a [GitHub](https://github.com/) account.

 1. Make sure there is a GitHub issue for what you want to work on.
 2. Announce in the comments section that you want to work on the issue. Also describe the solution you want to implement. To improve the chances for your contribution to be accepted, you'll want to wait for the feedback of the committers.
 3. Implement your change. Take care to follow the [quality guidelines](QUALITY_GUIDELINES.md) to improve chances of accepting it by a committer.
 4. Run the Maven/Gradle build locally to see if everything compiles and all tests pass.
 5. Push your changes to your forked repository. It is recommended to create a separate branch, this will make it easier to include the feedback from committers and update your changes.
 6. Create a [pull request](https://help.github.com/articles/using-pull-requests/).

## Contributing for Committers
You're a committer if you have write-access to the Xtext git-repositories.

 1. Make sure there is a GitHub issue for what you want to work on
 2. Assign the issue to yourself.
 3. Create a local git branch.
 4. Implement your change. Take care to follow the [quality guidelines](QUALITY_GUIDELINES.md).
 5. Push the branch into the repository.
 6. [Jenkins](http://services.typefox.io/open-source/jenkins/) will automatically create a job for your branch and build it.
 7. If, and only if, all tests have passed, create a pull request and ask somebody who is familiar with the code you modified to review it.
 8. If the reviewer approves, merge.

## Create a release locally
 1. Run the Maven / Gradle build locally.
 2. Find the artifacts at `build/maven-repository` or `build/p2-repository` in a folder relative to the repository root.

## Consume the Latest Artifacts
There are two ways / sources: 

 * All Maven artifacts are published every 24 hours to the [public Sonatype snapshot repository](https://oss.sonatype.org/content/repositories/snapshots/org/eclipse/xtext/) and can be consumed from there.
 * The [Jenkins](http://services.typefox.io/open-source/jenkins/) archives the created repositories. So you can find the repository of your choice at: `http://services.typefox.io/open-source/jenkins/job/<git-repo-name>/job/<git-branch>/(lastSuccessfulBuild|<build-number>)/artifact/build/(maven|p2)-repository/`


JUST TEST - IGNORE!
