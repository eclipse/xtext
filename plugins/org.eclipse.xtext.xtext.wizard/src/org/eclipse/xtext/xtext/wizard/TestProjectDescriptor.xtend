package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors

abstract class TestProjectDescriptor extends ProjectDescriptor {
	@Accessors val ProjectDescriptor testedProject
	
	new(TestedProjectDescriptor testedProject) {
		super(testedProject.config)
		this.testedProject = testedProject
	}
	
	override getSourceFolders() {
		#{Outlet.TEST_JAVA, Outlet.TEST_RESOURCES, Outlet.TEST_SRC_GEN, Outlet.TEST_XTEND_GEN}.map[sourceFolder].toSet
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
	
	override isEclipsePluginProject() {
		testedProject.isEclipsePluginProject
	}
	
	override pom() {
		super.pom => [
			packaging = if(isEclipsePluginProject) "eclipse-test-plugin" else "jar"
			buildSection = '''
				<build>
					<plugins>
						<plugin>
							<groupId>org.eclipse.xtend</groupId>
							<artifactId>xtend-maven-plugin</artifactId>
						</plugin>
					</plugins>
				</build>
			'''
		]
	}
}