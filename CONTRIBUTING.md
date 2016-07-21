This page explains common tasks related to working with Xtext's source code.

## Report an Issue
(explain)

## Set up your Eclipse Workspace using OOMPH
1. Download and start the [Eclipse Installer](https://wiki.eclipse.org/Eclipse_Oomph_Installer).
2. On the initial page, click on the *Switch to Advanced Mode* button in the top right.
3. On the *Product* page, select *Eclipse IDE for Eclipse Committers*.
4. On the *Projects* page, expand the *Xtext* node.
5. Below the *Xtext* node there is an subproject entry for each module. Select those you would like to install. If in doubt, select all of them.
6. Choose your preferred installation settings on the *Variables* page. Enter credentials for your Bugzilla and GitHub account.
7. Finish the wizard, drink a cup of coffee, and watch how your Xtext development environment is assembled.

## Contribute via Fork
All you need is a Github account.
 1. make sure there is a Github issue for what you want to work on
 2. announce in the comments section that you want to work on the issue. Also describe the solution you want to implement. To improve the chances for your contribution to be accepted, you'll want to wait for the feedback of the committers. 
 3. Implement your change
 4. Run the Maven/Gradle build locally to see if everything compiles and all tests pass
 5. create a pull request

## Contributing for Committers
You're a committer if you have write-access to the Xtext git-repositories.
 1. make sure there is a Github issue for what you want to work on
 2. assign the issue to you
 3. create a local git branch
 4. implement your change
 5. push the branch into the repository
 6. [Jenkins](http://services.typefox.io/open-source/jenkins/) will automatically create a job for your branch an build it
 7. if, and only if, all tests have passed, create a pull request and ask somebody who is familiar the code you modified to review it
 8. if the reviewer approves, merge

## Create a Release Locally
 1. run the maven / gradle build locally
 2. find the artifacts at "build/maven-repository" or "build/p2-repository" in a folder relative to the repository root

## Consume the Latest Artifacts
There are two ways / sources: 
 * All maven artifacts are published every 24 hours to the public Sonatype snapshot repository and can be consumed from there
 * The [Jenkins](http://services.typefox.io/open-source/jenkins/) archives the created repositories. So you can find the repository of your choice at: `http://services.typefox.io/open-source/jenkins/job/<git-repo-name>/job/<git-branch>/(lastSuccessfulBuild|<build-number>)/artifact/build/(maven|p2)-repository/`
