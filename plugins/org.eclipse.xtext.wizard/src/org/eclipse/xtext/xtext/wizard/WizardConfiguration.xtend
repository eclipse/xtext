package org.eclipse.xtext.xtext.wizard

import java.nio.charset.Charset
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class WizardConfiguration {
	String rootLocation
	String baseName
	String xtextVersion = '2.8.4'

	Charset encoding = Charset.defaultCharset
	BuildSystem buildSystem = BuildSystem.ECLIPSE
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

	def getEnabledProjects() {
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
		productionProjects + testProjects
	}
}