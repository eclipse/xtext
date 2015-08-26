package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors

abstract class TestProjectDescriptor extends ProjectDescriptor {
	@Accessors val ProjectDescriptor testedProject
	
	new(TestedProjectDescriptor testedProject) {
		super(testedProject.config)
		this.testedProject = testedProject
	}
	
	def isInlined() {
		enabled && config.sourceLayout != SourceLayout.PLAIN
	}
	
	def isSeparate() {
		enabled && config.sourceLayout == SourceLayout.PLAIN
	}
	
	override getNameQualifier() {
		testedProject.nameQualifier + ".tests"
	}
	
	override getUpstreamProjects() {
		#{testedProject}
	}
}