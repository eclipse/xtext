# The Build Infrastructure of Xtext

## Preparing Releases and Milestones

Branch names should be `milestone_«version»` for milestones, and `release_«version»` for releases. Tag names should be `v«version»`. When updating branch names for upstream dependencies, care must be taken to select the correct versions for additional libraries that are included in the Xtext build infrastructure (LSP4J).

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
   * `./gradlew generateP2Build -PuseJenkinsSnapshots=true`
3. xtext-extras
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * `./gradlew generateP2Build -PuseJenkinsSnapshots=true`
4. xtext-eclipse
   * Replace all occurrences of `job/master` according to the release branch name.
   * Set `xtend-maven-plugin-version` property in `releng/org.eclipse.xtext.tycho.parent/pom.xml` to the used Xtend compiler version.
5. xtext-idea
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
6. xtext-web
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
7. xtext-maven
   * Replace all occurrences of the previous version with the release version.
   * Replace all occurrences of `job/master` according to the release branch name.
8. xtext-xtend
   * Create release branch.
   * Set `version` property in `gradle/versions.gradle` to the release version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Replace all occurrences of the previous version with the release version in the Maven plugin related pom.xml files (`maven-pom.xml`, `org.eclipse.xtend.maven.*`).
   * Replace all occurrences of `job/master` according to the release branch name.
   * Set `xtend-maven-plugin-version` property in `releng/org.eclipse.xtend.tycho.parent/pom.xml` to the used Xtend compiler version.
9. xtext-umbrella
   * Replace all occurrences of `job/master` according to the release branch name.
   * Update the name of the zipped p2 repository  according to the release version in `releng/org.eclipse.xtext.sdk.p2-repository/pom.xml` (`tofile` property).
10. Once all previous builds are successful, trigger the build job https://hudson.eclipse.org/xtext/job/xtext-release/ with the release version and branch name as parameters.
11. Ask @dhuebner to publish the Eclipse and Maven artifacts.

## Lifting the Version Number

Once the release branch for a major or minor release has been created, the master branch should be lifted to the next version. Similarly, the third version digit should be increased on the corresponding maintenance branch after every release (including service releases).

Note that the Xtend compiler cannot be set to use snapshot versions from the beginning, since the new snapshots do not exist yet. It should be set to the latest published version (a release candidate or the actual release), and changed to the new snapshot version when it's available.

1. xtext-lib
   * Set `version` property in `gradle/versions.gradle` to the next version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Replace occurrences of the previous version in `MANIFEST.MF` and `feature.xml` files.
   * `./gradlew generateP2Build`
2. xtext-core
   * Set `version` property in `gradle/versions.gradle` to the next version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Replace occurrences of the previous version in `MANIFEST.MF` and `feature.xml` files.
   * `./gradlew generateP2Build -PuseJenkinsSnapshots=true`
3. xtext-extras
   * Set `version` property in `gradle/versions.gradle` to the next version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Replace occurrences of the previous version in `MANIFEST.MF` and `feature.xml` files.
   * `./gradlew generateP2Build -PuseJenkinsSnapshots=true`
4. xtext-eclipse
   * Replace occurrences of the previous version in `MANIFEST.MF`, `feature.xml`, `pom.xml`, and `category.xml` files.
   * Set `xtend-maven-plugin-version` property in `releng/org.eclipse.xtext.tycho.parent/pom.xml` to the used Xtend compiler version.
5. xtext-idea
   * Set `version` property in `gradle/versions.gradle` to the next version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
6. xtext-web
   * Set `version` property in `gradle/versions.gradle` to the next version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
7. xtext-maven
   * Replace all occurrences of the previous version with the next version.
8. xtext-xtend
   * Replace all occurrences of the previous version with the next version.
   * Set `bootstrapXtendVersion` property in `gradle/bootstrap-setup.gradle` to the used Xtend compiler version.
   * Set `xtend-maven-plugin-version` property in `releng/org.eclipse.xtend.tycho.parent/pom.xml` to the used Xtend compiler version.
9. xtext-umbrella
   * Replace all occurrences of the previous version with the next version.
