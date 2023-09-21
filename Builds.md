
# Building Releases and Milestones

1. Tag the current `main` branch locally.  
`git tag v2.31.0.M3` or `git tag v2.31.0`

1. Run the Full Deploy Job
   * For milestones run the [xtext-monorepo-full-deploy-milestone](https://ci.eclipse.org/xtext/job/xtext-monorepo-full-deploy-milestone/) job and select the milestone postfix (M1, M2, ...) as the `RELEASE_TYPE` parameter.
   * For releases run the [xtext-monorepo-full-deploy-release](https://ci.eclipse.org/xtext/job/xtext-monorepo-full-deploy-release/) Job.

1. Wait for the job to finish  
Check the Update Site and Drop dirs to contain the new Milestone or Release
   * For milestones https://download.eclipse.org/modeling/tmf/xtext/updates/milestones/ and https://download.eclipse.org/modeling/tmf/xtext/downloads/drops/
   * For releases https://download.eclipse.org/modeling/tmf/xtext/updates/releases/ and https://download.eclipse.org/modeling/tmf/xtext/downloads/drops/

1. Promote staged milestone/release on [s01.oss.sonatype.org](https://s01.oss.sonatype.org/). Can only be done by Xtext release engineer with the right credentials at sonatype
   * Log in with your sonatype user.
   * Select Staging Repositories
   * Search for orgeclipsextext-NNNN and orgeclipsextend-NNNN with status open
   * Select both and perform the Close toolbar action
   * Wait until the checks have run successfully
   * Select both repositories again the perform the Release toolbar action

1. Contribute milestone / release to Simrel Aggregation Build
    * Clone / pull `git@github.com:eclipse-simrel/simrel.build.git`
    * Edit `tmf-xtext.aggrcon` and enter new repo path and version numbers.
    * Create a commit
    * Create a pr at github
    * Submit the pr

1. Update and publish Release Notes (for Releases only)
   * Create and review release notes (https://github.com/eclipse/xtext-website/tree/main/xtend-website/_posts/releasenotes and https://github.com/eclipse/xtend-website/tree/main/xtend-website/_posts/releasenotes)
   * For committer activity count `git shortlog -s -n -e v<PREV_RELEASE>..v<NEW_RELEASE>`
   * Remove published: false from release post
   * [Create PR](https://github.com/eclipse/xtext-website/compare/published...main?expand=1) to merge branch main into published
   * Merge the PR
   * Wait for the [website-deploy](https://ci.eclipse.org/xtext/job/releng/job/website-deploy/) to finish. Shortly after the new Release Notes should pop up on the [Xtext website](https://www.eclipse.org/Xtext/download.html) and the [Xtend website](https://www.eclipse.org/xtend/download.html).

1. Update Marketplace entries (for Releases only)
   * Market place entry for [Xtext](https://marketplace.eclipse.org/content/eclipse-xtext/edit)
   * Market place entry for [Xtend](https://marketplace.eclipse.org/content/eclipse-xtend/edit)
   * For each update the properties:
     * Version Number
     * Supported Eclipse Release(s)
   * Click 'Save item to list' AND 'Save' afterwards - otherwise nothing will be saved.
   * Update Composite Repository for Eclipse Marketplace
     * In repository https://github.com/xtext/xtext-p2-orbit update files
       * [`updates/composite/marketplace/compositeArtifacts.xml`](https://github.com/xtext/xtext-p2-orbit/blob/master/updates/composite/marketplace/compositeArtifacts.xml)
       * [`updates/composite/marketplace/compositeContent.xml`](https://github.com/xtext/xtext-p2-orbit/blob/master/updates/composite/marketplace/compositeContent.xml)
     * Run job [update-composite-sites](https://ci.eclipse.org/xtext/job/releng/job/update-composite-sites/)  

1. Check availability of artifacts on Maven Central
   * It can take some hours until the artifacts are mirrored to Maven Central. Note: search.maven.org might not show the new release immediately when it is available. Check the availability of the artifacts for example with `mvn dependency:get -U -DgroupId=org.eclipse.xtext -DartifactId=org.eclipse.xtext -Dversion=<VERSION>`

1. Push the tag. `git push origin <tag_name>`

1. As soon as Maven Central is updated - send notifications
   * Newsgroup / Forum
   * Mailing list
   * Gitter
   * Ecliape Chat / matrix.eclipse.org
   * Twitter

1. Bump the version number (for Releases only)
   * run the `scripts/fixVersions.sh -f '<old-version>` e.g ` ./scripts/fixVersions.sh -f '2.31.0'`.
   * commit and pull request the changed files

1. Bootstrap the main branch against new release (for Releases only)
   * Edit the `xtend-maven-plugin-version` property in  `pom.xml` to contain the created release/milestone version and commit and pr the change.

1. xtext-apidiff (for Releases only)
   * adapt https://github.com/xtext/xtext-apidiff/blob/master/create-api-diff.sh
   * adapt Jenkins Configuration https://github.com/xtext/xtext-apidiff/blob/master/Jenkinsfile

1. Add / Update [xtext-reference-projects](https://github.com/xtext/xtext-reference-projects/) (for Releases only)
   * should be done in the days after the release
   * import the root (only) into your Xtext dev env
   * adapt the current versions to use the current release in poms/build.gradle/target files.
   * commit and pr these changes.
   * edit and run the scripts in the `launch` folder.
   * create new scripts in the `scripts` folder.
   * adapt the Jenkins files and the Github action to make use of the new scripts.
   * commit and pr the adaptations

1. TODOs
   * create new target for the current eclipse release once it is out
   * adapt latest target to use new orbit / I-builds / eclipse release alias once available
   * prepare release notes and website changes for next release
