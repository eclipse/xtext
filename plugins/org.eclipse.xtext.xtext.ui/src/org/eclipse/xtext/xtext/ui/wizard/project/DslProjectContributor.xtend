package org.eclipse.xtext.xtext.ui.wizard.project

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.ui.util.IProjectFactoryContributor$IFileCreator

class DslProjectContributor extends DefaultProjectFactoryContributor {
	
	XtextProjectInfo projectInfo
	String sourceRoot
	
	new(XtextProjectInfo projectInfo) {
		this.projectInfo = projectInfo
	}
	
	def void setSourceRoot(String sourceRoot) {
		this.sourceRoot = sourceRoot	
	}
	
	override contributeFiles(IProject project, IFileCreator creator) {
		creator.writeToFile(workflow, sourceRoot+"/"+ projectInfo.basePackagePath + "/Generate" + projectInfo.languageNameAbbreviation+".mwe2")
		creator.writeToFile(grammar, sourceRoot+"/"+ projectInfo.grammarFilePath)
		creator.writeToFile(launchConfig,".launch/Generate Language Infrastructure (" + projectInfo.projectName + ").launch")
	}
	
	def private workflow() {
		'''
		module «(projectInfo.basePackagePath+"/Generate"+projectInfo.languageNameAbbreviation).replaceAll("/", ".")»

		import org.eclipse.emf.mwe.utils.*
		import org.eclipse.xtext.generator.*
		import org.eclipse.xtext.ui.generator.*
		
		var grammarURI = "classpath:/«projectInfo.basePackagePath»/«projectInfo.languageNameAbbreviation».xtext"
		var file.extensions = "«projectInfo.fileExtension»"
		var projectName = "«projectInfo.projectName»"
		var runtimeProject = "../${projectName}"
		
		Workflow {
		    «projectInfo.wizardContribution.mweSnippet»
		}
		
		'''
	}
	
	def private grammar() {
		'''
		grammar «projectInfo.languageName» with org.eclipse.xtext.common.Terminals

		generate «projectInfo.languageNameAbbreviation.toFirstLower» "«projectInfo.nsURI»"
		
		Model:
			greetings+=Greeting*;
			
		Greeting:
			'Hello' name=ID '!';
		'''
	}
	
	def private launchConfig() {
		'''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<launchConfiguration type="org.eclipse.pde.ui.RuntimeWorkbench">
		<booleanAttribute key="append.args" value="true"/>
		<booleanAttribute key="askclear" value="true"/>
		<booleanAttribute key="automaticAdd" value="true"/>
		<booleanAttribute key="automaticValidate" value="false"/>
		<stringAttribute key="bad_container_name" value="/«projectInfo.projectName»/.launch/"/>
		<stringAttribute key="bootstrap" value=""/>
		<stringAttribute key="checked" value="[NONE]"/>
		<booleanAttribute key="clearConfig" value="false"/>
		<booleanAttribute key="clearws" value="false"/>
		<booleanAttribute key="clearwslog" value="false"/>
		<stringAttribute key="configLocation" value="${workspace_loc}/.metadata/.plugins/org.eclipse.pde.core/Launch Runtime Eclipse"/>
		<booleanAttribute key="default" value="true"/>
		<booleanAttribute key="includeOptional" value="true"/>
		<stringAttribute key="location" value="${workspace_loc}/../runtime-New_configuration"/>
		<listAttribute key="org.eclipse.debug.ui.favoriteGroups">
		<listEntry value="org.eclipse.debug.ui.launchGroup.debug"/>
		<listEntry value="org.eclipse.debug.ui.launchGroup.run"/>
		</listAttribute>
		<stringAttribute key="org.eclipse.jdt.launching.JRE_CONTAINER" value="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5"/>
		<stringAttribute key="org.eclipse.jdt.launching.PROGRAM_ARGUMENTS" value="-os ${target.os} -ws ${target.ws} -arch ${target.arch} -nl ${target.nl}"/>
		<stringAttribute key="org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER" value="org.eclipse.pde.ui.workbenchClasspathProvider"/>
		<stringAttribute key="org.eclipse.jdt.launching.VM_ARGUMENTS" value="-Xms40m -Xmx512m -XX:MaxPermSize=256m"/>
		<stringAttribute key="pde.version" value="3.3"/>
		<stringAttribute key="product" value="org.eclipse.platform.ide"/>
		<booleanAttribute key="show_selected_only" value="false"/>
		<stringAttribute key="templateConfig" value="${target_home}/configuration/config.ini"/>
		<booleanAttribute key="tracing" value="false"/>
		<booleanAttribute key="useDefaultConfig" value="true"/>
		<booleanAttribute key="useDefaultConfigArea" value="true"/>
		<booleanAttribute key="useProduct" value="true"/>
		<booleanAttribute key="usefeatures" value="false"/>
		</launchConfiguration>
		'''
	}
	
}