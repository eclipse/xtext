package org.eclipse.xtext.xtext.ui.wizard.project

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.ui.util.IProjectFactoryContributor$IFileCreator

/**
 * Contributes a workflow file and the grammar to the new DSL project
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
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
		creator.writeToFile(wfLaunchConfig,".launch/Generate Language Infrastructure (" + projectInfo.projectName + ").launch")
		if (projectInfo.createEclipseRuntimeLaunchConfig) {
			creator.writeToFile(launchConfig,".launch/Launch Runtime Eclipse.launch")
		}
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
	
	def private wfLaunchConfig() {
		'''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<launchConfiguration type="org.eclipse.emf.mwe2.launch.Mwe2LaunchConfigurationType">
		<stringAttribute key="org.eclipse.debug.core.ATTR_REFRESH_SCOPE" value="${working_set:&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;&#10;&lt;launchConfigurationWorkingSet factoryID=&quot;org.eclipse.ui.internal.WorkingSetFactory&quot; id=&quot;1299248699643_13&quot; label=&quot;working set&quot; name=&quot;working set&quot;&gt;&#10;&lt;item factoryID=&quot;org.eclipse.ui.internal.model.ResourceFactory&quot; path=&quot;/«projectInfo.projectName»&quot; type=&quot;4&quot;/&gt;&#10;&lt;item factoryID=&quot;org.eclipse.ui.internal.model.ResourceFactory&quot; path=&quot;/«projectInfo.generatorProjectName»&quot; type=&quot;4&quot;/&gt;&#10;&lt;item factoryID=&quot;org.eclipse.ui.internal.model.ResourceFactory&quot; path=&quot;/«projectInfo.testProjectName»&quot; type=&quot;4&quot;/&gt;&#10;&lt;item factoryID=&quot;org.eclipse.ui.internal.model.ResourceFactory&quot; path=&quot;/«projectInfo.uiProjectName»&quot; type=&quot;4&quot;/&gt;&#10;&lt;/launchConfigurationWorkingSet&gt;}"/>
		<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_PATHS">
		<listEntry value="/«projectInfo.projectName»"/>
		</listAttribute>
		<listAttribute key="org.eclipse.debug.core.MAPPED_RESOURCE_TYPES">
		<listEntry value="4"/>
		</listAttribute>
		<listAttribute key="org.eclipse.debug.ui.favoriteGroups">
		<listEntry value="org.eclipse.debug.ui.launchGroup.debug"/>
		<listEntry value="org.eclipse.debug.ui.launchGroup.run"/>
		</listAttribute>
		<stringAttribute key="org.eclipse.jdt.launching.MAIN_TYPE" value="org.eclipse.emf.mwe2.launch.runtime.Mwe2Launcher"/>
		<stringAttribute key="org.eclipse.jdt.launching.PROGRAM_ARGUMENTS" value="src/«projectInfo.basePackagePath»/Generate«projectInfo.languageNameAbbreviation».mwe2"/>
		<stringAttribute key="org.eclipse.jdt.launching.PROJECT_ATTR" value="«projectInfo.projectName»"/>
		<stringAttribute key="org.eclipse.jdt.launching.VM_ARGUMENTS" value="-Xmx512m"/>
		</launchConfiguration>
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
		<stringAttribute key="location" value="${workspace_loc}/../runtime-EclipseXtext"/>
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