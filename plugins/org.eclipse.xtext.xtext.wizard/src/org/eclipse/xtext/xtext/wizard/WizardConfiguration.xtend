package org.eclipse.xtext.xtext.wizard

import java.nio.charset.Charset
import org.eclipse.xtend.lib.annotations.Accessors
import com.google.common.collect.ImmutableSet
import java.util.Set
import org.eclipse.xtext.xtext.generator.XtextVersion

@Accessors
class WizardConfiguration {
	String rootLocation
	String baseName
	XtextVersion xtextVersion = XtextVersion.current
	Ecore2XtextConfiguration ecore2Xtext = new Ecore2XtextConfiguration

	Charset encoding = Charset.defaultCharset
	BuildSystem preferredBuildSystem = BuildSystem.ECLIPSE
	
	SourceLayout sourceLayout = SourceLayout.PLAIN
	ProjectLayout projectLayout = ProjectLayout.FLAT

	val LanguageDescriptor language = new LanguageDescriptor

	val runtimeProject = new RuntimeProjectDescriptor(this)
	val ideProject = new IdeProjectDescriptor(this)
	val uiProject = new UiProjectDescriptor(this)
	val intellijProject = new IntellijProjectDescriptor(this)
	val webProject = new WebProjectDescriptor(this)
	val parentProject = new ParentProjectDescriptor(this)
	val targetPlatformProject = new TargetPlatformProject(this)

	def Set<ProjectDescriptor> getEnabledProjects() {
		val productionProjects = #[
			runtimeProject,
			ideProject,
			uiProject,
			intellijProject,
			webProject,
			parentProject,
			targetPlatformProject
		].filter[enabled]
		
		val testProjects = productionProjects
			.filter(TestedProjectDescriptor)
			.map[testProject]
			.filter[enabled && separate]
		ImmutableSet.copyOf(productionProjects + testProjects)
	}
	
	def needsMavenBuild() {
		preferredBuildSystem == BuildSystem.MAVEN || needsGradleBuild && uiProject.enabled
	}
	
	def needsTychoBuild() {
		needsMavenBuild && enabledProjects.exists[isEclipsePluginProject]
	}
	
	def needsGradleBuild() {
		preferredBuildSystem == BuildSystem.GRADLE || intellijProject.isEnabled
	}
}