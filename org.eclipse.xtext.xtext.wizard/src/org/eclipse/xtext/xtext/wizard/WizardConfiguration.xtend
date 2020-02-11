/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import com.google.common.collect.ImmutableSet
import java.nio.charset.Charset
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.XtextVersion
import org.eclipse.xtext.util.JavaVersion
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.util.JUnitVersion

@Accessors
class WizardConfiguration {
	String rootLocation
	String baseName
	XtextVersion xtextVersion = XtextVersion.current
	val Ecore2XtextConfiguration ecore2Xtext = new Ecore2XtextConfiguration

	Charset encoding = Charset.defaultCharset
	String lineDelimiter = Strings.newLine
	BuildSystem preferredBuildSystem = BuildSystem.NONE
	
	SourceLayout sourceLayout = SourceLayout.PLAIN
	ProjectLayout projectLayout = ProjectLayout.FLAT
	
	boolean needsGradleWrapper = true
	JavaVersion javaVersion = JavaVersion.JAVA8
	LanguageServer languageServer = LanguageServer.NONE
	JUnitVersion junitVersion = JUnitVersion.DEFAULT;
	
	val LanguageDescriptor language = new LanguageDescriptor

	val runtimeProject = new RuntimeProjectDescriptor(this)
	val ideProject = new IdeProjectDescriptor(this)
	val uiProject = new UiProjectDescriptor(this)
	val webProject = new WebProjectDescriptor(this)
	val parentProject = new ParentProjectDescriptor(this)
	val targetPlatformProject = new TargetPlatformProject(this)
	val sdkProject = new SdkFeatureProject(this)
	val p2Project = new P2RepositoryProject(this)

	def Set<ProjectDescriptor> getEnabledProjects() {
		val productionProjects = #[
			parentProject,
			runtimeProject,
			ideProject,
			uiProject,
			webProject,
			targetPlatformProject,
			sdkProject,
			p2Project
		].filter[enabled]
		
		val testProjects = productionProjects
			.filter(TestedProjectDescriptor)
			.map[testProject]
			.filter[enabled && separate]
		ImmutableSet.copyOf(productionProjects + testProjects)
	}
	
	def boolean needsMavenBuild() {
		preferredBuildSystem == BuildSystem.MAVEN || preferredBuildSystem == BuildSystem.GRADLE && uiProject.enabled
	}
	
	def boolean needsTychoBuild() {
		needsMavenBuild && runtimeProject.isEclipsePluginProject
	}
	
	def boolean needsGradleBuild() {
		preferredBuildSystem == BuildSystem.GRADLE
	}
	
	def boolean isNeedsGradleWrapper() {
		return needsGradleWrapper && needsGradleBuild
	}
}
