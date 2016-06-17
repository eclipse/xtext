/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtext.util.XtextVersion
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor.FileExtensions
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.util.JavaVersion

class WizardConfigurationTest {

	WizardConfiguration config
	
	@Before
	def void setupConfig() {
		config = new WizardConfiguration => [
			baseName = "org.example.mydsl"
			rootLocation = ""
			language => [
				name = "org.example.mydsl.MyDsl"
				fileExtensions = FileExtensions.fromString("mydsl")
			]
		]
	}
	
	@Test
	def void runtimeProjectCanBeBuiltAsPlainMavenProject() {
		config.preferredBuildSystem = BuildSystem.MAVEN
		assertFalse(config.runtimeProject.isEclipsePluginProject)
		assertFalse(config.runtimeProject.pom.content.contains("eclipse-plugin"))
		assertFalse(config.parentProject.pom.content.contains("tycho"))
		assertFalse(allJavaProjects.filter[!isEclipsePluginProject].exists[pom.content.contains("tycho")])
	}
	
	@Test
	def void runtimeProjectIsPluginProjectWhenUiProjectIsEnabled() {
		config.uiProject.enabled = true
		assertTrue(config.runtimeProject.isEclipsePluginProject)
	}
	
	@Test
	def void eclipsePluginsAreBuiltWithTychoWhenMavenBuiltIsEnabled() {
		config.uiProject.enabled = true
		config.ideProject.enabled = true
		config.preferredBuildSystem = BuildSystem.MAVEN
		assertTrue(config.needsTychoBuild)
		#[config.runtimeProject, config.ideProject, config.uiProject].forEach[
			assertTrue(pom.content.contains("eclipse-plugin"))
		]
		assertTrue(config.parentProject.pom.content.contains("tycho"))
	}

	@Test
	def void p2AndSdkProjectsAreBuiltWithTychoWhenMavenBuiltIsEnabled() {
		config.uiProject.enabled = true
		config.p2Project.enabled = true
		config.preferredBuildSystem = BuildSystem.MAVEN
		assertTrue(config.needsTychoBuild)
		assertTrue(config.sdkProject.pom.content.contains("eclipse-feature"))
		assertTrue(config.p2Project.pom.content.contains("eclipse-repository"))
		assertTrue(config.parentProject.pom.content.contains("tycho"))
	}

	@Test
	def void p2ProjectsEnablesSourceGenerationWithTychoWhenMavenBuiltIsEnabled() {
		config.uiProject.enabled = true
		config.p2Project.enabled = true
		config.preferredBuildSystem = BuildSystem.MAVEN
		assertTrue(config.needsTychoBuild)
		config.parentProject.pom.content => [
			assertTrue(contains("tycho-source-plugin"))
			assertTrue(contains("tycho-source-feature-plugin"))
		]
	}

	@Test
	def void aTychoBuildIncludesATargetPlatform() {
		config.uiProject.enabled = true
		config.preferredBuildSystem = BuildSystem.MAVEN
		assertTrue(config.targetPlatformProject.enabled)
	}

	@Test
	def void testProjectIsPluginProjectWhenRuntimeProjectIsPluginProject() {
		config.runtimeProject.testProject.enabled = true
		assertTrue(config.runtimeProject.testProject.isEclipsePluginProject)
	}

	@Test
	def void p2ProjectEnablesSdkProject() {
		config.p2Project.enabled = true
		config.sdkProject.enabled = false
		assertTrue(config.sdkProject.enabled)
	}

	@Test
	def void eclipseUiCanBeBuiltWithPDE() {
		config.uiProject.enabled = true
		assertFalse(config.needsGradleBuild)
		assertFalse(config.needsMavenBuild)
	}

	@Test
	def void eclipseUiIsBuiltWithTychoWhenNotUsingPDE() {
		config.uiProject.enabled = true
		config.preferredBuildSystem = BuildSystem.GRADLE
		assertTrue(config.needsTychoBuild)
	}

	@Test
	def void intellijNeedsAGradleBuild() {
		config.intellijProject.enabled = true
		assertTrue(config.needsGradleBuild)
	}

	@Test
	def void mavenNeedsAParentProject() {
		config.preferredBuildSystem = BuildSystem.MAVEN
		assertTrue(config.parentProject.enabled)
	}

	@Test
	def void gradleNeedsAParentProject() {
		config.preferredBuildSystem = BuildSystem.GRADLE
		assertTrue(config.parentProject.enabled)
	}
	
	@Test
	def void inlinedTestProjectsDontOverrideMainSources() {
		config.runtimeProject.testProject.enabled = true
		config.preferredBuildSystem = BuildSystem.MAVEN
		config.sourceLayout = SourceLayout.MAVEN
		val pom = config.runtimeProject.files.findFirst[relativePath == "pom.xml"]
		assertTrue(pom instanceof PomFile)
		assertTrue((pom as PomFile).content.toString.contains("<artifactId>org.example.mydsl</artifactId>"))
	}
	
	@Test
	def void inlinedTestProjectsAddTheirDependenciesToTheMainProject() {
		config.runtimeProject.testProject.enabled = true
		config.sourceLayout = SourceLayout.MAVEN
		config.runtimeProject.testProject.externalDependencies.forEach[testDependency|
			assertTrue(config.runtimeProject.externalDependencies.exists[
				maven.artifactId == testDependency.maven.artifactId
				&& p2.bundleId == testDependency.p2.bundleId
				&& p2.packages == testDependency.p2.packages
			])
		]
	}
	
	@Test
	def void inlinedTestProjectsAddTheirSourceFoldersToTheMainProject() {
		config.runtimeProject.testProject.enabled = true
		config.sourceLayout = SourceLayout.MAVEN
		config.runtimeProject.testProject.sourceFolders.forEach[testFolder|
			assertTrue(config.runtimeProject.sourceFolders.contains(testFolder))
		]
	}
	
	@Test
	def void mavenProjectsHaveAPom() {
		config.preferredBuildSystem = BuildSystem.MAVEN
		allJavaProjects.filter[isPartOfMavenBuild].forEach[
			enabled = true
			assertTrue(files.exists[relativePath == "pom.xml"])
		]
	}
	
	@Test
	def void gradleProjectsHaveABuildFile() {
		config.preferredBuildSystem = BuildSystem.GRADLE
		allJavaProjects.filter[isPartOfGradleBuild].forEach[
			enabled = true
			assertTrue(files.exists[relativePath == "build.gradle"])
		]
	}
	
	@Test
	def void pluginProjectsHaveEclipseMetaData() {
		allJavaProjects.filter[isEclipsePluginProject].forEach[
			enabled = true
			assertTrue(files.exists[relativePath == "MANIFEST.MF"])
			assertTrue(files.exists[relativePath == "build.properties"])
		]
	}

	@Test
	def void featureProjectsHaveEclipseBuildProperties() {
		assertTrue(config.sdkProject.files.exists[relativePath == "build.properties"])
	}
	
	@Test
	def void projectsCanBeBuiltAgainstXtextNightlies() {
		config.preferredBuildSystem = BuildSystem.GRADLE
		config.uiProject.enabled = true
		config.intellijProject.enabled = true
		config.xtextVersion = new XtextVersion("2.9.0-SNAPSHOT")
		
		val snapshotsRepo = "repositories/snapshots"
		assertTrue(config.parentProject.pom.content.contains(snapshotsRepo))
		assertTrue(config.parentProject.buildGradle.content.contains(snapshotsRepo))
		val xtextIntellijSnapshots = "/xtext-intellij/lastSuccessfulBuild/"
		assertTrue(config.intellijProject.buildGradle.content.contains(xtextIntellijSnapshots))
		val nightlyUpdateSite = 'xtext/updates/nightly'
		assertTrue(config.targetPlatformProject.target.toString.contains(nightlyUpdateSite))
	}
	
	@Test
	def void projectsCanBeBuiltAgainstXtextReleases() {
		config.preferredBuildSystem = BuildSystem.GRADLE
		config.uiProject.enabled = true
		config.intellijProject.enabled = true
		config.xtextVersion = new XtextVersion("2.9.0")
		
		val snapshotsRepo = "repositories/snapshots"
		assertFalse(config.parentProject.pom.content.contains(snapshotsRepo))
		assertFalse(config.parentProject.buildGradle.content.contains(snapshotsRepo))
		val xtextIntellijRelease = "xtext/idea/${xtextVersion}"
		assertTrue(config.intellijProject.buildGradle.content.contains(xtextIntellijRelease))
		val releaseUpdateSite = 'xtext/updates/releases/2.9.0'
		assertTrue(config.targetPlatformProject.target.toString.contains(releaseUpdateSite))
	}
	
	@Test 
	def gradleEclipseClasspathIsIgnoredForPluginProjects() {
		config.preferredBuildSystem = BuildSystem.GRADLE
		config.uiProject.enabled = true
		config.ideProject.enabled = true
		config.enabledProjects.filter[eclipsePluginProject].forEach[
			assertTrue(buildGradle.content.contains("eclipseClasspath.enabled=false"))
		]
	}
	
	@Test
	def parentContainsOtherProjectsInHierarchicallayout() {
		config.projectLayout = ProjectLayout.HIERARCHICAL
		allJavaProjects.forEach[
			assertTrue(location.startsWith(config.parentProject.location + "/"))
		]
	}
	
	@Test
	def plainMavenProjectsCanBeBuiltWithEclipseLayout() {
		config.preferredBuildSystem = BuildSystem.MAVEN
		config.sourceLayout = SourceLayout.PLAIN
		val plainMavenProjects = allJavaProjects.filter[!isEclipsePluginProject && isPartOfMavenBuild]
		plainMavenProjects.forEach[
			assertTrue(pom.content.contains("<directory>src</directory>"))
			assertTrue(pom.content.contains("<source>src-gen</source>"))
			assertTrue(pom.content.contains("<directory>src-gen</directory>"))
		]
		plainMavenProjects.filter[!(it instanceof TestProjectDescriptor)].forEach[
			assertTrue(pom.content.contains("<sourceDirectory>src</sourceDirectory>"))
			assertTrue(pom.content.contains("add-source"))
			assertTrue(pom.content.contains("add-resource"))
			assertFalse(pom.content.contains("add-test-source"))
			assertFalse(pom.content.contains("add-test-resource"))
		]
		plainMavenProjects.filter(TestProjectDescriptor).forEach[
			assertTrue(pom.content.contains("<testSourceDirectory>src</testSourceDirectory>"))
			assertTrue(pom.content.contains("add-test-source"))
			assertTrue(pom.content.contains("add-test-resource"))
			assertFalse(pom.content.contains("add-source"))
			assertFalse(pom.content.contains("add-resource"))
		]
	}
	
	@Test
	def void plainMavenProjectsCanBeBuiltWithMavenLayout() {
		config.preferredBuildSystem = BuildSystem.MAVEN
		config.sourceLayout = SourceLayout.MAVEN
		val plainMavenProjects = allJavaProjects.filter[!isEclipsePluginProject && isPartOfMavenBuild]
		val mainProjects = plainMavenProjects.filter[!(it instanceof TestProjectDescriptor)]
		
		plainMavenProjects.forEach[enabled = true]
		
		assertTrue(plainMavenProjects.filter(TestProjectDescriptor).forall[isInlined])
		mainProjects.forEach[
			assertTrue(pom.content.contains("add-source"))
			assertTrue(pom.content.contains("add-resource"))
			assertTrue(pom.content.contains("<source>src/main/xtext-gen</source>"))
			assertTrue(pom.content.contains("<directory>src/main/xtext-gen</directory>"))
		]
		mainProjects.filter(TestedProjectDescriptor).forEach[
			assertTrue(pom.content.contains("add-test-source"))
			assertTrue(pom.content.contains("add-test-resource"))
			assertTrue(pom.content.contains("<source>src/test/xtext-gen</source>"))
			assertTrue(pom.content.contains("<directory>src/test/xtext-gen</directory>"))
		]
	}
	
	@Test
	def void pomFileDontDuplicateMavenDefaults() {
		config.preferredBuildSystem = BuildSystem.MAVEN
		config.sourceLayout = SourceLayout.MAVEN
		val plainMavenProjects = allJavaProjects.filter[!isEclipsePluginProject && isPartOfMavenBuild]
		val mainProjects = plainMavenProjects.filter[!(it instanceof TestProjectDescriptor)]
		
		plainMavenProjects.forEach[enabled = true]
		
		mainProjects.forEach[
			assertFalse(pom.content.contains("<sourceDirectory>"))
			assertFalse(pom.content.contains("<directory>src/main/resources</directory>"))
			assertFalse(pom.content.contains("<testSourceDirectory>"))
			assertFalse(pom.content.contains("<directory>src/test/resources</directory>"))
		]
	}
	
	@Test
	def void uiTestsNeedTychoUiHarness() {
		config.preferredBuildSystem = BuildSystem.MAVEN
		config.uiProject.enabled = true
		val pom = config.uiProject.testProject.pom.content
		assertTrue(pom.contains("useUIHarness"))
	}
	
	@Test
	def void runtimeTestsDontNeedTychoUiHarness() {
		config.preferredBuildSystem = BuildSystem.MAVEN
		config.uiProject.enabled = true
		val pom = config.runtimeProject.testProject.pom.content
		assertFalse(pom.contains("useUIHarness"))
	}
	
	@Test
	def void tychoDoesNotFailOnMissingTests() {
		config.preferredBuildSystem = BuildSystem.MAVEN
		config.uiProject.enabled = true
		val poms = allJavaProjects.filter(TestProjectDescriptor).filter[isEclipsePluginProject].map[pom]
		poms.forEach[
			assertTrue(content.contains("failIfNoTests"))
		]
	}
	
	@Test
	def void allBuildSystemsUseJava8() {
		val parentPom = config.parentProject.pom.content
		assertTrue(parentPom.contains("<maven.compiler.source>1.8</maven.compiler.source>"))
		assertTrue(parentPom.contains("<maven.compiler.target>1.8</maven.compiler.target>"))
		val parentGradle = config.parentProject.buildGradle.content
		assertTrue(parentGradle.contains("sourceCompatibility = '1.8'"))
		assertTrue(parentGradle.contains("targetCompatibility = '1.8'"))
		allJavaProjects.map[manifest].forEach[
			assertTrue(contains("Bundle-RequiredExecutionEnvironment: JavaSE-1.8"))
		]
	}
	
	@Test
	def void allBuildSystemsUseOtherJava() {
		config.javaVersion = JavaVersion.JAVA7
		val parentPom = config.parentProject.pom.content
		assertTrue(parentPom.contains("<maven.compiler.source>1.7</maven.compiler.source>"))
		assertTrue(parentPom.contains("<maven.compiler.target>1.7</maven.compiler.target>"))
		val parentGradle = config.parentProject.buildGradle.content
		assertTrue(parentGradle.contains("sourceCompatibility = '1.7'"))
		assertTrue(parentGradle.contains("targetCompatibility = '1.7'"))
		allJavaProjects.map[manifest].forEach[
			assertTrue(contains("Bundle-RequiredExecutionEnvironment: JavaSE-1.7"))
		]
	}
	
	def allJavaProjects() {
		#[
			config.runtimeProject,
			config.runtimeProject.testProject,
			config.uiProject,
			config.uiProject.testProject,
			config.ideProject,
			config.intellijProject,
			config.webProject
		]
	}
}