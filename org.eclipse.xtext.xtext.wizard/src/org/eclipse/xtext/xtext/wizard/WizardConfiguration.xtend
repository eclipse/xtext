/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.wizard

import com.google.common.collect.ImmutableSet
import java.nio.charset.Charset
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.XtextVersion
import org.eclipse.xtext.util.JavaVersion

@Accessors
class WizardConfiguration {
	String rootLocation
	String baseName
	XtextVersion xtextVersion = XtextVersion.current
	val Ecore2XtextConfiguration ecore2Xtext = new Ecore2XtextConfiguration

	Charset encoding = Charset.defaultCharset
	BuildSystem preferredBuildSystem = BuildSystem.NONE
	
	SourceLayout sourceLayout = SourceLayout.PLAIN
	ProjectLayout projectLayout = ProjectLayout.FLAT
	
	boolean needsGradleWrapper = true
	JavaVersion javaVersion = JavaVersion.JAVA8
	
	val LanguageDescriptor language = new LanguageDescriptor

	val runtimeProject = new RuntimeProjectDescriptor(this)
	val ideProject = new IdeProjectDescriptor(this)
	val uiProject = new UiProjectDescriptor(this)
	val intellijProject = new IntellijProjectDescriptor(this)
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
			intellijProject,
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
		preferredBuildSystem == BuildSystem.GRADLE || intellijProject.isEnabled
	}
	
	def boolean isNeedsGradleWrapper() {
		return needsGradleWrapper && needsGradleBuild
	}
}