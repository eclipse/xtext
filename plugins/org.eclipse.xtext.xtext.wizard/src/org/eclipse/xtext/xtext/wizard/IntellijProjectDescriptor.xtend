package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
class IntellijProjectDescriptor extends ProjectDescriptor {

	override getNameQualifier() {
		".idea"
	}

	override getUpstreamProjects() {
		#{config.runtimeProject, config.ideProject}
	}

	override getSourceFolders() {
		#{Outlet.MAIN_JAVA, Outlet.MAIN_RESOURCES}.map[sourceFolder].toSet
	}

	override buildGradle() {
		super.buildGradle => [
			pluginsSection = '''
				plugins {
					id 'org.xtext.idea-plugin' version '0.3.17'
				}
			'''
			additionalContent = '''
				ideaDevelopment {
					ideaVersion = '141.814.3'
					pluginRepositories {
						url 'http://download.eclipse.org/modeling/tmf/xtext/idea/«config.xtextVersion»/updatePlugins.xml'
					}
					pluginDependencies {
						id 'org.eclipse.xtext.idea' version '«config.xtextVersion»'
					}
				}
			'''
		]
	}

	override pom() {
		throw new UnsupportedOperationException("IntelliJ projects cannot be built with Maven")
	}

}