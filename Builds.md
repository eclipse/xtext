# The Build Infrastructure of Xtext

## Preparing Releases and Milestones

Branch names should be `milestone_«version»` for milestones, and `release_«version»` for releases. Tag names should be `v«version»`.

The Xtend compiler version used in the build should be the current snapshot or the last milestone for milestones, and it should always be the last milestone for releases (this is important for making release builds reproducible).

Build jobs for releases must be executed in proper order on the build server, i.e. from upstream to downstream jobs. For every upstream change, the downstream jobs must be retriggered manually.

1. xtext-lib
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * `./gradlew generateP2Build`
2. xtext-core
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Set `upstreamBranch` property in `gradle/upstream-repositories.gradle` to the release branch name.
   * `./gradlew generateP2Build -PuseJenkinsSnapshots=true`
3. xtext-extras
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Set `upstreamBranch` property in `gradle/upstream-repositories.gradle` to the release branch name.
   * `./gradlew generateP2Build -PuseJenkinsSnapshots=true`
4. xtext-eclipse
   * Replace all occurrences of `job/master` according to the release branch name.
   * Set `xtend-maven-plugin-version` property in `releng/org.eclipse.xtext.tycho.parent/pom.xml` to the used Xtend compiler version.
5. xtext-idea
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Set `upstreamBranch` property in `gradle/upstream-repositories.gradle` to the release branch name.
6. xtext-web
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Set `upstreamBranch` property in `gradle/upstream-repositories.gradle` to the release branch name.
7. xtext-maven
   * Replace all occurrences of the previous (snapshot) version with the release version.
   * Replace all occurrences of `job/master` according to the release branch name.
8. xtext-xtend
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Set `upstreamBranch` property in `gradle/upstream-repositories.gradle` to the release branch name.
   * Replace all occurrences of the previous (snapshot) version with the release version in the Maven plugin related pom.xml files (`maven-pom.xml`, `org.eclipse.xtend.maven.*`).
   * Replace all occurrences of `job/master` according to the release branch name.
   * Set `xtend-maven-plugin-version` property in `releng/org.eclipse.xtend.tycho.parent/pom.xml` to the used Xtend compiler version.
   * `./gradlew generateP2Build -PuseJenkinsSnapshots=true`
9. xtext-umbrella
   * Replace all occurrences of `job/master` according to the release branch name.
   * Update the name of the zipped p2 repository according to the release version in `releng/org.eclipse.xtext.sdk.p2-repository/pom.xml`.
