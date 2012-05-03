package org.eclipse.xtext.xtext.ui.wizard.project

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.ui.util.IProjectFactoryContributor$IFileCreator


/**
 * Contributes build.properties file and the launch configuration file to a new dsl test project
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
class TestProjectContributor extends DefaultProjectFactoryContributor {
	
	XtextProjectInfo projectInfo
	
	new(XtextProjectInfo projectInfo) {
		this.projectInfo = projectInfo
	}

	override contributeFiles(IProject project, IFileCreator fileWriter) {
		contributeBuildProperties(fileWriter)
		contributeLaunchConfig(fileWriter)
	}
	
	def private contributeBuildProperties(IFileCreator fileWriter) {
		'''
		source.. = src/,\
		          src-gen/
		bin.includes = META-INF/,\
		       .
		'''.writeToFile(fileWriter, "build.properties")
	}
	
	def private contributeLaunchConfig(IFileCreator fileWriter) {
		'''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<launchConfiguration type="org.eclipse.jdt.junit.launchconfig">
		<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_PATHS">
		<listEntry value="/«projectInfo.testProjectName»"/>
		</listAttribute>
		<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_TYPES">
		<listEntry value="4"/>
		</listAttribute>
		<stringAttribute key="org.eclipse.jdt.junit.CONTAINER" value="=«projectInfo.testProjectName»"/>
		<booleanAttribute key="org.eclipse.jdt.junit.KEEPRUNNING_ATTR" value="false"/>
		<stringAttribute key="org.eclipse.jdt.junit.TEST_KIND" value="org.eclipse.jdt.junit.loader.junit4"/>
		<stringAttribute key="org.eclipse.jdt.launching.PROJECT_ATTR" value="«projectInfo.testProjectName»"/>
		</launchConfiguration>
		'''.writeToFile(fileWriter, projectInfo.testProjectName+".launch")
	}
}