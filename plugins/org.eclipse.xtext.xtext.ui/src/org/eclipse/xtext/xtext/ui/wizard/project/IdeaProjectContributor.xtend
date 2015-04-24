package org.eclipse.xtext.xtext.ui.wizard.project

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.ui.util.IProjectFactoryContributor.IFileCreator

/**
 * Contributes Idea parts to a new dsl test project
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
			buildscript {
				repositories { jcenter() }
				dependencies { classpath 'org.xtext:xtext-idea-gradle-plugin:+'}
			}
			
			apply plugin: 'org.xtext.idea-plugin'
			apply plugin: 'eclipse'
			
			dependencies {
				compile project(':«projectInfo.projectName»')
				compile project(':«projectInfo.ideProjectName»')
			}
			
			ideaDevelopment {
				ideaVersion = '141.178.9'
				pluginRepositories {
					url 'https://hudson.eclipse.org/xtext/job/xtext-intellij/lastSuccessfulBuild/artifact/git-repo/intellij/build/ideaRepository/updatePlugins.xml'
				}
				pluginDependencies {
					id 'org.eclipse.xtext.idea'
				}
			}
			
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

	}

}