/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard.cli

import com.google.common.base.Charsets
import com.google.common.collect.Sets
import com.google.common.io.Files
import java.io.File
import java.util.Comparator
import java.util.List
import java.util.Set
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.tests.LineDelimiters
import org.eclipse.xtext.util.XtextVersion
import org.eclipse.xtext.xtext.wizard.BuildSystem
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor.FileExtensions
import org.eclipse.xtext.xtext.wizard.ProjectLayout
import org.eclipse.xtext.xtext.wizard.SourceLayout
import org.eclipse.xtext.xtext.wizard.WizardConfiguration
import org.junit.ComparisonFailure
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static org.junit.Assert.*

class CliWizardIntegrationTest {

	/**
	 * Use this main method to update the expectations to whatever the wizard currently generates
	 */
	static def void main(String[] args) {
		val creator = newProjectCreator
		projectConfigs.forEach [ config |
			val targetLocation = new File("testdata/wizard-expectations", config.baseName)
			targetLocation.mkdirs
			org.eclipse.xtext.util.Files.sweepFolder(targetLocation)
			config.rootLocation = targetLocation.path
			creator.createProjects(config)
			println("Updating expectations for " + config.baseName)
		]
	}

	static val projectConfigs = #[
		newProjectConfig => [
			baseName = "org.xtext.example.plainMaven"
			preferredBuildSystem = BuildSystem.MAVEN
			sourceLayout = SourceLayout.MAVEN
			projectLayout = ProjectLayout.HIERARCHICAL
			runtimeProject.testProject.enabled = true
			ideProject.enabled = true
			webProject.enabled = true
		],
		newProjectConfig => [
			baseName = "org.xtext.example.mavenTycho"
			preferredBuildSystem = BuildSystem.MAVEN
			sourceLayout = SourceLayout.PLAIN
			projectLayout = ProjectLayout.HIERARCHICAL
			runtimeProject.testProject.enabled = true
			uiProject.enabled = true
			uiProject.testProject.enabled = true
			ideProject.enabled = true
			webProject.enabled = true
		],
		newProjectConfig => [
			baseName = "org.xtext.example.gradle"
			preferredBuildSystem = BuildSystem.GRADLE
			sourceLayout = SourceLayout.MAVEN
			projectLayout = ProjectLayout.HIERARCHICAL
			runtimeProject.testProject.enabled = true
			ideProject.enabled = true
			webProject.enabled = true
			intellijProject.enabled = true
		],
		newProjectConfig => [
			baseName = "org.xtext.example.eclipsePlugin"
			preferredBuildSystem = BuildSystem.NONE
			sourceLayout = SourceLayout.PLAIN
			projectLayout = ProjectLayout.FLAT
			runtimeProject.testProject.enabled = true
			ideProject.enabled = true
			uiProject.enabled = true
			uiProject.testProject.enabled = true
		],
		newProjectConfig => [
			baseName = "org.xtext.example.eclipsePluginP2"
			preferredBuildSystem = BuildSystem.NONE
			sourceLayout = SourceLayout.PLAIN
			projectLayout = ProjectLayout.FLAT
			runtimeProject.testProject.enabled = true
			ideProject.enabled = true
			uiProject.enabled = true
			uiProject.testProject.enabled = true
			p2Project.enabled = true
		],
		newProjectConfig => [
			baseName = "org.xtext.example.mavenTychoP2"
			preferredBuildSystem = BuildSystem.MAVEN
			sourceLayout = SourceLayout.PLAIN
			projectLayout = ProjectLayout.HIERARCHICAL
			runtimeProject.testProject.enabled = true
			uiProject.enabled = true
			uiProject.testProject.enabled = true
			ideProject.enabled = true
			webProject.enabled = true
			p2Project.enabled = true
		],
		newProjectConfig => [
			baseName = "org.xtext.example.full"
			preferredBuildSystem = BuildSystem.GRADLE
			sourceLayout = SourceLayout.PLAIN
			projectLayout = ProjectLayout.HIERARCHICAL
			runtimeProject.testProject.enabled = true
			uiProject.enabled = true
			uiProject.testProject.enabled = true
			ideProject.enabled = true
			webProject.enabled = true
			intellijProject.enabled = true
			p2Project.enabled = true
		]
	]

	private static def newProjectConfig() {
		new WizardConfiguration => [
			xtextVersion = new XtextVersion("2.11.0-SNAPSHOT")
			encoding = Charsets.UTF_8
			language => [
				name = "org.xtext.example.mydsl.MyDsl"
				fileExtensions = FileExtensions.fromString("mydsl")
			]
		]
	}

	private static def newProjectCreator() {
		new CliProjectsCreator => [
			lineDelimiter = "\n"
		]
	}

	@Rule public TemporaryFolder temp = new TemporaryFolder

	WizardConfiguration config
	CliProjectsCreator creator

	@Test
	def testProjectCreation() {
		creator = newProjectCreator
		projectConfigs.forEach[config|
			this.config = config
			validateCreatedProjects
		]
	}

	private def void validateCreatedProjects() {
		val targetLocation = new File(temp.root, config.baseName)
		config.rootLocation = targetLocation.path
		creator.createProjects(config)

		val expectationLocation = new File("testdata/wizard-expectations", config.baseName)
		val expectedFiles = expectationLocation.toFileSet
		val actualFiles = targetLocation.toFileSet

		compareFileTrees(expectedFiles, actualFiles)
	}

	private def toFileSet(File root) {
		val allFiles = newArrayList
		collectAllFiles(root, allFiles)
		val generatedFiles = allFiles.map [
			val relativePath = path.replace(root.path, "")
			toGeneratedFile(relativePath)
		];
		val Comparator<GeneratedFile> sortByPath = [$0.relativePath <=> $1.relativePath]
		newTreeSet(sortByPath, generatedFiles)
	}

	private def void collectAllFiles(File root, List<File> children) {
		if (root.isDirectory) {
			root.listFiles.forEach[collectAllFiles(children)]
		} else {
			children.add(root)
		}
	}

	private def toGeneratedFile(File file, String relativePath) {
		new GeneratedFile(relativePath, if(file.isDirectory) "" else Files.toString(file, config.encoding))
	}

	private def compareFileTrees(Set<GeneratedFile> expectedFiles, Set<GeneratedFile> actualFiles) {
		val expectedFilesByPath = expectedFiles.toMap[relativePath]
		val actualFilesByPath = actualFiles.toMap[relativePath]

		val missingFiles = Sets.difference(expectedFiles, actualFiles)
		val unexpectedFiles = Sets.difference(actualFiles, expectedFiles)
		val comparableFiles = Sets.intersection(expectedFiles, actualFiles)

		missingFiles.forEach [
			throw new ComparisonFailure('''Missing file: «relativePath»''', content, "")
		]
		unexpectedFiles.forEach [
			throw new ComparisonFailure('''Unexpected file: «relativePath»''', "", content)
		]
		comparableFiles.forEach [
			val expectedContent = LineDelimiters.toUnix(expectedFilesByPath.get(relativePath).content)
			val actualContent = LineDelimiters.toUnix(actualFilesByPath.get(relativePath).content)
			assertEquals(relativePath, expectedContent, actualContent)
		]
	}

	@Data
	private static class GeneratedFile {
		String relativePath
		String content
	}
}