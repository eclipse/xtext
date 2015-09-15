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
	
	override isPartOfGradleBuild() {
		true
	}
	
	override isPartOfMavenBuild() {
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
						«IF config.xtextVersion.isSnapshot»
							url "https://hudson.eclipse.org/xtext/job/xtext-intellij/lastSuccessfulBuild/artifact/git-repo/intellij/build/ideaRepository/updatePlugins.xml"
						«ELSE»
							url "http://download.eclipse.org/modeling/tmf/xtext/idea/${xtextVersion}/updatePlugins.xml"
						«ENDIF»
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