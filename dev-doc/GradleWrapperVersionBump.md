# Gradle Wrapper Version Bump

This document describes what needs to be done to bump the used Gradle (Wrapper) version used in Xtext.

## CQ

We ship the Gradle Wrapper with our code. Thus a CQ needs to be filed. Here is an [example from the past](https://dev.eclipse.org/ipzilla/show_bug.cgi?id=18944)

1. Open the [Xtext Project Page](https://projects.eclipse.org/projects/modeling.tmf.xtext/) and make sure you are logged in.
1. Under __Intellectual Property__ click on __Create a Contribution Questionaire__
1. The _Create a Contribution Questionnaire_ pages opens.
1. Select __Third-Party Code Request.__ and click continue.
1. In the search box type __Gradle Wrapper \<Version>__.
   1. If there is already an Existing on (unlikely) then you can piggy back it.
   2. If not click __continue__.
1. The __Create a Contribution Questionnaire for a Third Party Library__ page opens.
   1. Under __Due Diligence Type__ select __Type B__.
   1. Under __Description__ enter an arbitry text like `We at Xtext Ship the Gradle Wrapper Scripts and Jar to our clients to allow easy build of Xtext projects with Gradle. This Updated the used Gradle version from 4.10.2 to 5.0`.
   1. Under __Cryptography__ type no.
   1. For __Project Website of the Contribution__ type `https://gradle.org/`.
   1. As __Source URL__ type `https://github.com/gradle/gradle/tree/master/subprojects/wrapper`.
   1. __License__  is __Apache License 2.0__ (Double Check if not changed).
   1. __Distribution__ is __Binary Only__.
   1. And for __Modified__ select __Unmodified__.
   1. Click Continue
   1. Check the Data and click __Finish__.
1. The __CQ Created__ message should show up. Click on the _CQXXX__ link to open the CQ in IPZilla.
1. Now we need to attach the Wrapper Source code to the IPZilla.
   1. go to a temp dir and do a `git clone --branch v<version> git@github.com:gradle/gradle.git` (or switch to the versions tag in an existing clone location).
   1. go to `subprojects/wrapper/`.
   1. Create a zip file of the contents excluding the tests and integ tests.
   1. Attach it to the IPZilla.
   1. Go to a location where you have already a gradle project with wrapper and run `./gradlew wrapper --gradle-version <version>` twice.
   1. Create a second zip containing `gradlew`, `gradlew.bat` and `gradle/wrapper/gradle-wrapper.properties`.
   1. There is also an experimental script to create both zips automatically at https://github.com/xtext/gradle-wrapper-cq-helper.
   1. Attach the second zip to the IPZilla.

## Builds

All our gradle based builds needs to be adapted and tested.

1. Run `./gradlew wrapper --gradle-version <version>` twice in all our gradle projects (`xtext-lib`,`xtext-core`,`xtext-extras`,`xtext-xtend`,`xtext-web`,`xtext-umbrella/releng/gradle-composite`).
1. Test if it works locally and on Jenkins. Run the build with `--warning-mode all` to see if there are new deprecations and if yes make sure a issue exists for them.

## Wizard

We need to update and test the Wizard.

1. Copy the `gradlew`, `gradlew.bat`, `gradle-wrapper.properties` and `gradle-wrapper.jar` at `xtext-core/org.eclipse.xtext.xtext.wizard/resources/gradlew`
1. Run `CliWizardIntegrationTest` as Java Application to update Test expections and as Unit Test to make sure it worked.
1. Start Runtime Eclipse. Create new Gradle Projects and make sure they work. Run the Build with `--warning-mode all` to see if there are new deprecations and if yes make sure a issue exists for them.