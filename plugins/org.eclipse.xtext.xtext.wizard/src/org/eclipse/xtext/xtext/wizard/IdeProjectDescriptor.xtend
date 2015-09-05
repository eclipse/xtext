package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

import static org.eclipse.xtext.xtext.wizard.ExternalDependency.*

@FinalFieldsConstructor
class IdeProjectDescriptor extends ProjectDescriptor {
	
	override getNameQualifier() {
		".ide"
	}

	override getUpstreamProjects() {
		#{config.runtimeProject}
	}
	
	override isEclipsePluginProject() {
		config.buildSystem.isPluginBuild || config.uiProject.enabled
	}
	
	override getExternalDependencies() {
		val deps = newHashSet
		deps += super.externalDependencies
		deps += createXtextDependency("org.eclipse.xtext.ide")
		deps += createXtextDependency("org.eclipse.xtext.xbase.ide")
		deps
	}
	
	override pom() {
		super.pom => [
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
			packaging = if (isEclipsePluginProject) "eclipse-plugin" else "jar"
		]
	}

}