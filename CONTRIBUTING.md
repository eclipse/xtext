This page explains common tasks related to working with Xtext's source code.

## Report an Issue

Please create any new issue in the most appropriate repository (see full list on the [entry page](README.md)). When in doubt, create it in this umbrella repository.

Eclipse Bugzilla issues are deprecated for Xtext. However, we still accept them.

### Milestones

We have one milestone for each Xtext release. Fixed issues should be assigned to the milestone of the nearest release in which the fix will be included. For example, if an issue is fixed on the `maintenance` branch, the corresponding milestone is the next service release (increasing the third version component). If an issue is fixed on the `master` branch, the next major or minor release should be assigned.

It is possible to assign issues to a milestone before they are fixed, which can be useful for planning. However, make sure someone will actually work on that issue when you do that!

The list of issues assigned to a milestone will give a nice overview of new features and fixed bugs after a release has been done, facilitating the creation of release notes and helping users to know when a fix will be available.

### Issue Labels

Issue labels can serve several purposes:

* Indicate the issue type: `bug`, `enhancement`, `new_feature`, `question`
* Communicate the current status of an issue: `confirmed`, `help_wanted`
* Communicate why an issue has not been fixed: `duplicate`, `invalid`, `wontfix`
* Categorize issues for better overview, e.g. to assign an issue to a specific part of the software. Committers may add categorization labels as required. However, in most cases the `[category]` prefixing in the issue title should be sufficient.

In general we want to keep the number of labels as low as possible in order to avoid contributors to be overwhelmed and to make sure they are actually used. A label is not useful if it's assigned only to a fraction of the issues it belongs to, so it's important for all contributors to use the existing labels consistently.

### Workflow

All committers should feel responsible to read incoming issues. When you read a new issue, please think about an appropriate reaction:

* If possible, assign a type and a status.
* If appropriate, close the issue and explain why it won't be fixed.
* If the report seems reasonable, a comment with some feedback to the reporter would be nice (e.g. describe wich action is required next, such as to confirm the issue or find a solution for it), especially if the reporter is not a committer.
* If you are not familiar enough with the topic of the issue, you might find someone who is and delegate the action.

## Set up your Eclipse Workspace
Before starting the setup process, make sure that you have both an [Eclipse](https://accounts.eclipse.org/user/register) and and a [GitHub](https://github.com/join) account. Also make sure that you have _disabled_ [two factor authorisation](https://github.com/settings/security) on GitHub during the setup process, as the [installer currently cannot handle that](https://bugs.eclipse.org/bugs/show_bug.cgi?id=426144).

1. Download and start the [Eclipse Installer](https://wiki.eclipse.org/Eclipse_Oomph_Installer).
2. On the initial page, click on the *Switch to Advanced Mode* button in the top right.
3. On the *Product* page, select *Eclipse IDE for Eclipse Committers*.
4. On the *Projects* page, expand the *Xtext* node.
5. Below the *Xtext* node there is a subproject entry for each module. Select those you would like to install. If in doubt, select all of them.
6. Choose your preferred installation settings on the *Variables* page. Enter credentials for your Eclipse and GitHub account. If you don't have ssh keys registered with Github then make sure that you select `HTTPS (read-only, anonymous)` or `HTTPS (read-write)` for the Github repository entries.
7. Finish the wizard, drink a cup of coffee, and watch how your Xtext development environment is assembled.

When you run your freshly installed Eclipse IDE for the first time it will clone the relevant repositories and automatically set up your workspace with a number of projects.

NOTE: when the above process has finished and you still have error markers on most of the projects in the workspace, chances are that the generated files `.settings/org.eclipse.buildship.core.prefs` have errors of the shape "Invalid Gradle project configuration file". In such a case, right click on the project `/gradle-composite` (which should be in the working set "Root Projects") and select "Gradle" => "Refresh Gradle Project". If the operation does not succeed, please try reverting all modifications to the repository `xtext-lib` (e.g., from the "Git Staging View", select all the unstaged changes and choose the context menu "Replace with HEAD revision"). Then, try again with the "Refresh Gradle Project" menu as said above. 

## Contribute via Fork
You need a [GitHub](https://github.com/join) and an [Eclipse](https://accounts.eclipse.org/user/register) account for which you signed the [Eclipse Contributor Agreement](https://accounts.eclipse.org/user/login?destination=user/eca).

 1. Make sure there is a GitHub issue for what you want to work on.
 2. Announce in the comments section that you want to work on the issue. Also describe the solution you want to implement. To improve the chances for your contribution to be accepted, you'll want to wait for the feedback of the committers.
 3. Implement your change. Take care to follow the [quality guidelines](QUALITY_GUIDELINES.md) to improve the chances of your contribution being accepted by a committer.
 4. [Sign off](https://git-scm.com/docs/git-commit#git-commit--s) your commits using the same email address you are using for your Eclipse account.
 5. Run the Maven/Gradle build locally to see if everything compiles and all tests pass.
 6. Push your changes to your forked repository. It is recommended to create a separate branch, this will make it easier to include the feedback from committers and update your changes.
 7. Create a [pull request](https://help.github.com/articles/using-pull-requests/).

## Contributing for Committers
You're a committer if you have write-access to the Xtext git-repositories.

 1. Make sure there is a GitHub issue for what you want to work on
 2. Assign the issue to yourself.
 3. Create a local git branch.
 4. Implement your change. Take care to follow the [quality guidelines](QUALITY_GUIDELINES.md).
 5. [Sign off](https://git-scm.com/docs/git-commit#git-commit--s) your commits using the same email address you are using for your Eclipse account.
 6. Push the branch into the repository.
 7. [Jenkins](https://ci.eclipse.org/xtext) will automatically create a job for your branch and build it.
 8. If, and only if, all tests have passed, create a pull request and ask somebody who is familiar with the code you modified to review it.
 9. If the reviewer approves, merge.

## Create a release locally
 1. Run the Maven / Gradle build locally.
 2. Find the artifacts at `build/maven-repository` or `build/p2-repository` in a folder relative to the repository root.

## Consume the Latest Artifacts
There are two ways / sources: 

 * All Maven artifacts are published every 24 hours to the [public Sonatype snapshot repository](https://oss.sonatype.org/content/repositories/snapshots/org/eclipse/xtext/) and can be consumed from there.
 * The [Jenkins](https://ci.eclipse.org/xtext) archives the created repositories. So you can find the repository of your choice at: `https://ci.eclipse.org/xtext/job/<git-repo-name>/job/<git-branch>/(lastSuccessfulBuild|<build-number>)/artifact/build/(maven|p2)-repository/`

## Eclipse Contributor Agreement

Before your contribution can be accepted by the project team contributors must
electronically sign the Eclipse Contributor Agreement (ECA).

* http://www.eclipse.org/legal/ECA.php

Commits that are provided by non-committers must have a Signed-off-by field in
the footer indicating that the author is aware of the terms by which the
contribution has been provided to the project. The non-committer must
additionally have an Eclipse Foundation account and must have a signed Eclipse
Contributor Agreement (ECA) on file.

For more information, please see the Eclipse Committer Handbook:
https://www.eclipse.org/projects/handbook/#resources-commit
