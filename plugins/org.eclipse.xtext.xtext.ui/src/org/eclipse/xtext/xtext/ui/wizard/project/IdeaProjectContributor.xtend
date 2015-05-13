package org.eclipse.xtext.xtext.ui.wizard.project

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.ui.util.IProjectFactoryContributor.IFileCreator

/**
 * Contributes Idea parts to an *.idea project
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.9
 */
class IdeaProjectContributor extends DefaultProjectFactoryContributor {

	XtextProjectInfo projectInfo

	new(XtextProjectInfo projectInfo) {
		this.projectInfo = projectInfo
	}

	override contributeFiles(IProject project, IFileCreator fc) {
		'''
			plugins {
				id 'org.xtend.xtend' version '0.4.7'
				id 'org.xtext.idea-plugin' version '0.3.16'
				id 'eclipse'
			}
			
			dependencies {
				compile project(':«projectInfo.projectName»')
				compile project(':«projectInfo.ideProjectName»')
			}
			
			ideaDevelopment {
				ideaVersion = '141.814.3'
				pluginRepositories {
					url 'https://hudson.eclipse.org/xtext/job/xtext-intellij/lastSuccessfulBuild/artifact/git-repo/intellij/build/ideaRepository/updatePlugins.xml'
				}
				pluginDependencies {
					id 'org.eclipse.xtext.idea' version '2.9.0-SNAPSHOT'
				}
			}

			sourceSets.main.xtendOutputDir = 'xtend-gen'

			allprojects {
				repositories { 
					jcenter()
					maven {
						url "https://oss.sonatype.org/content/repositories/snapshots/"
					}
				}
				apply plugin: 'java'
				sourceSets.main.java.srcDirs = ['src', 'src-gen', 'xtend-gen']
				sourceSets.main.resources.srcDirs = ['src', 'src-gen']
			}
			
			configure(project(':«projectInfo.projectName»')) {
				dependencies {
					compile 'org.eclipse.xtext:org.eclipse.xtext.common.types:+'
				}
			}
			
			configure(project('«projectInfo.ideProjectName»')) {
				dependencies { 
					compile project(':«projectInfo.projectName»')
					compile 'org.eclipse.xtext:org.eclipse.xtext.ide:+' 
				}
			}
		'''.writeToFile(fc, 'build.gradle')

		'''
			includeFlat '«projectInfo.projectName»'
			includeFlat '«projectInfo.ideProjectName»'
		'''.writeToFile(fc, 'settings.gradle')
		
		'''
			To build this project you need to install Gradle.
			https://gradle.org/docs/current/userguide/installation.html
			
			
			The following tasks are available:
			 eclipse - generates Eclipse metadata like .project and .classpath, including the IntelliJ libraries
			 test - runs all your unit tests
			 assemble - creates the shippable build outputs. This includes an ideaZip, which packages your plugin in the format that the IDEA plugin manager understands
			 runIdea - starts IntelliJ IDEA with your plugin installed
			
			 For more information please read: https://github.com/xtext/xtext-gradle-plugin/tree/master/xtext-idea-gradle-plugin
		'''.writeToFile(fc, 'readme.txt')

	}

}