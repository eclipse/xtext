package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
class IntellijProjectDescriptor extends ProjectDescriptor {

	override getNameQualifier() {
		".idea"
	}
	
	override isEclipsePluginProject() {
		false
	}

	override getUpstreamProjects() {
		#{config.runtimeProject, config.ideProject}
	}

	override buildGradle() {
		super.buildGradle => [
			pluginsSection = '''
				plugins {
					id 'org.xtext.idea-plugin' version '0.3.21'
				}
			'''
			additionalContent = '''
				ideaDevelopment {
					ideaVersion = '141.814.3'
					pluginRepositories {
						url "http://download.eclipse.org/modeling/tmf/xtext/idea/${xtextVersion}/updatePlugins.xml"
					}
					pluginDependencies {
						id 'org.eclipse.xtext.idea' version xtextVersion
					}
				}
			'''
		]
	}

	override pom() {
		throw new UnsupportedOperationException("IntelliJ projects cannot be built with Maven")
	}

}