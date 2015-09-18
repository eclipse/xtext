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
import org.eclipse.xtext.junit4.internal.LineDelimiters
import org.eclipse.xtext.xtext.generator.XtextVersion
import org.eclipse.xtext.xtext.wizard.BuildSystem
import org.eclipse.xtext.xtext.wizard.LanguageDescriptor.FileExtensions
import org.eclipse.xtext.xtext.wizard.ProjectLayout
import org.eclipse.xtext.xtext.wizard.SourceLayout
import org.eclipse.xtext.xtext.wizard.WizardConfiguration
import org.junit.Before
import org.junit.ComparisonFailure
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder

import static org.junit.Assert.*

class CliWizardIntegrationTest {
	@Rule public TemporaryFolder temp = new TemporaryFolder
	
	WizardConfiguration config
	CliProjectsCreator creator
	
	@Before
	def void setup() {
		config = new WizardConfiguration => [
			xtextVersion = new XtextVersion("2.9.0-SNAPSHOT")
			encoding = Charsets.UTF_8
			language => [
				name = "org.xtext.example.mydsl.MyDsl"
				fileExtensions = FileExtensions.fromString("mydsl")
			]
		]
		creator = new CliProjectsCreator
	}
	
	@Test
	def testPlainMavenProject() {
		config.baseName = "org.xtext.example.plainMaven"
		config.preferredBuildSystem = BuildSystem.MAVEN
		config.sourceLayout = SourceLayout.MAVEN
		config.projectLayout = ProjectLayout.HIERARCHICAL
		config.runtimeProject.testProject.enabled = true
		config.ideProject.enabled = true
		config.webProject.enabled = true
		validateCreatedProjects
	}
	
	@Test
	def testMavenTychoProject() {
		config.baseName = "org.xtext.example.mavenTycho"
		config.preferredBuildSystem = BuildSystem.MAVEN
		config.sourceLayout = SourceLayout.PLAIN
		config.projectLayout = ProjectLayout.HIERARCHICAL
		config.runtimeProject.testProject.enabled = true
		config.uiProject.enabled = true
		config.uiProject.testProject.enabled = true
		config.ideProject.enabled = true
		config.webProject.enabled = true
		validateCreatedProjects
	}
	
	@Test
	def testGradleProject() {
		config.baseName = "org.xtext.example.gradle"
		config.preferredBuildSystem = BuildSystem.GRADLE
		config.sourceLayout = SourceLayout.MAVEN
		config.projectLayout = ProjectLayout.HIERARCHICAL
		config.runtimeProject.testProject.enabled = true
		config.ideProject.enabled = true
		config.webProject.enabled = true
		config.intellijProject.enabled = true
		validateCreatedProjects
	}
	
	@Test
	def testEclipsePluginProject() {
		config.baseName = "org.xtext.example.eclipsePlugin"
		config.preferredBuildSystem = BuildSystem.ECLIPSE
		config.sourceLayout = SourceLayout.PLAIN
		config.projectLayout = ProjectLayout.FLAT
		config.runtimeProject.testProject.enabled = true
		config.ideProject.enabled = true
		config.uiProject.enabled = true
		config.uiProject.testProject.enabled = true
		validateCreatedProjects
	}
	
	@Test
	def testFullProject() {
		config.baseName = "org.xtext.example.full"
		config.preferredBuildSystem = BuildSystem.GRADLE
		config.sourceLayout = SourceLayout.PLAIN
		config.projectLayout = ProjectLayout.HIERARCHICAL
		config.runtimeProject.testProject.enabled = true
		config.uiProject.enabled = true
		config.uiProject.testProject.enabled = true
		config.ideProject.enabled = true
		config.webProject.enabled = true
		config.intellijProject.enabled = true
		validateCreatedProjects
	}
	
	private def void validateCreatedProjects() {
		val targetLocation = new File(temp.root, config.baseName)
		config.rootLocation = targetLocation.path
		creator.createProjects(config)
		
		val expectationLocation = new File("testdata/wizard-expectations", config.baseName)
		val expectedFiles= expectationLocation.toFileSet
		val actualFiles = targetLocation.toFileSet
		
		compareFileTrees(expectedFiles, actualFiles)
	}
	
	private def toFileSet(File root) {
		val allFiles = newArrayList
		collectAllFiles(root, allFiles)
		val generatedFiles = allFiles.map[
			val relativePath = path.replace(root.path, "")
			toGeneratedFile(relativePath)
		];
		val Comparator<GeneratedFile> sortByPath = [$0.relativePath <=> $1.relativePath]
		newTreeSet(sortByPath, generatedFiles)
	}
	
	private def void collectAllFiles(File root, List<File> children) {
		children.add(root)
		if (root.isDirectory) {
			root.listFiles.forEach[collectAllFiles(children)]
		}
	}
	
	private def toGeneratedFile(File file, String relativePath) {
		new GeneratedFile(relativePath, if (file.isDirectory) "" else Files.toString(file, config.encoding))
	}
	
	private def compareFileTrees(Set<GeneratedFile> expectedFiles, Set<GeneratedFile> actualFiles) {
		val expectedFilesByPath = expectedFiles.toMap[relativePath]
		val actualFilesByPath = actualFiles.toMap[relativePath]
		
		val difference = Sets.difference(expectedFiles, actualFiles)
		val missingFiles = difference.filter[expectedFiles.contains(it)]
		val unexpectedFiles = difference.filter[actualFiles.contains(it)]
		val comparableFiles = Sets.intersection(expectedFiles, actualFiles)

		missingFiles.forEach[
			throw new ComparisonFailure('''Missing file: «relativePath»''', content, "")
		]
		unexpectedFiles.forEach[
			throw new ComparisonFailure('''Unexpected file: «relativePath»''', "", content)
		]
		comparableFiles.forEach[
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