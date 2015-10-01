/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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
		newLinkedHashSet(config.runtimeProject, config.ideProject)
	}

	override buildGradle() {
		super.buildGradle => [
			pluginsSection = '''
				//see https://github.com/xtext/xtext-gradle-plugin/tree/master/xtext-idea-gradle-plugin
				apply plugin: 'org.xtext.idea-plugin'
				apply plugin: 'org.xtext.idea-repository'
				
			'''
			additionalContent = '''
				
				ideaDevelopment {
					ideaVersion = '142.5047.6'
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
				
				ideaRepository.rootUrl = "${buildDir}/ideaRepository"
			'''
		]
	}
}