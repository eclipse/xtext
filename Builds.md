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
   *
5. xtext-idea
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Set `upstreamBranch` property in `gradle/upstream-repositories.gradle` to the release branch name.
5. xtext-web
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Set `upstreamBranch` property in `gradle/upstream-repositories.gradle` to the release branch name.
