package org.eclipse.xtext.xtext.ui.wizard.releng.templates

import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.Path
import org.eclipse.xtext.xtext.ui.wizard.releng.RelengProjectInfo

import static org.eclipse.xtext.xtext.ui.wizard.releng.templates.BuckminsterFilesCreator.*
import org.eclipse.xtext.ui.util.IProjectFactoryContributor
import org.eclipse.xtext.xtext.ui.wizard.releng.P2DirectorLaunch

/**
 * Creates some buckminster files. cquery, spec, rmap etc.
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
class BuckminsterFilesCreator {
	static String CSPEC_FILE_NAME = "buckminster.cspec"
	static String PROJECT = "project"
	static String PROJECT_CQUERY_NAME = PROJECT+".cquery"
	static String PLATFORM_CQUERY_NAME = PROJECT+"s-platform.cquery"
	static String PROJECT_RMAP_NAME = PROJECT+".rmap"
	static String PLATFORM_RMAP_NAME = PROJECT+"s-platform.rmap"
	static String COMMANDS_FILE_NAME = "commands.txt"
	static String INSTALL_BUCKY_LAUNCH = ".InstallHeadlessBuckminster.launch"
	
	IProjectFactoryContributor$IFileCreator fileCreator
	
	new(IProjectFactoryContributor$IFileCreator fileCreator) {
		this.fileCreator = fileCreator
	}
	
	def createBuckminsterFiles(RelengProjectInfo projectInfo) {
		projectInfo.createCspec
		projectInfo.createCommands
		projectInfo.createProjectCquery
		projectInfo.createPlatformCquery
		projectInfo.createPlatformRmap
		projectInfo.createProjectRmap
	}
	
	def private IFile writeToFile(CharSequence chrSeq, String fileName) {
		return fileCreator.writeToFile(chrSeq,fileName);
	}
	
	/**
	 * Creates commands text file that it used to instruct headless buckminster, what to do.<br>
	 *
	 */
	def private createCommands(RelengProjectInfo projectInfo) {
		'''
		setpref targetPlatformPath="${target.platform}"
		resolve "${projects.location}/«projectInfo.projectName»/«PLATFORM_CQUERY_NAME»"
		resolve "${projects.location}/«projectInfo.projectName»/«PROJECT_CQUERY_NAME»"
		«FOR preCompileLauncher :projectInfo.preCompileLaunchers»
		launch -l "«preCompileLauncher»"
		«ENDFOR»
		build
		«FOR testLauncher: projectInfo.testLaunchers»
		junit -l "«new Path(testLauncher.project.name).append(testLauncher.projectRelativePath)»"  --flatXML --output "${buckminster.output.root}/test.results/«testLauncher.name».xml"
		«ENDFOR»
		perform "«projectInfo.siteFeatureProjectName»#site.p2"
		'''.writeToFile(COMMANDS_FILE_NAME)
	}
	
	/**
	 * Creates buckminster scpec.<br>
	 * @param projectInfo Project configuration to use
	 */
	def private createCspec(RelengProjectInfo projectInfo) {
		'''
		<?xml version="1.0" encoding="UTF-8"?>
		<cs:cspec xmlns:cs="http://www.eclipse.org/buckminster/CSpec-1.0" name="«projectInfo.projectName»" componentType="buckminster" version="1.0.0">
		    <cs:dependencies>
		        <cs:dependency name="org.eclipse.platform" componentType="eclipse.feature"/>
		        <cs:dependency name="org.eclipse.xtext.sdk" componentType="eclipse.feature"/>
		    </cs:dependencies>
		</cs:cspec>
		'''.writeToFile(CSPEC_FILE_NAME)
	}
	
	/**
	 * Creates project cquery.<br>
	 * @param projectInfo Project configuration to use
	 */
	def private createProjectCquery(RelengProjectInfo projectInfo) {
		'''
		<?xml version="1.0" encoding="UTF-8"?>
		<cq:componentQuery xmlns:cq="http://www.eclipse.org/buckminster/CQuery-1.0" resourceMap="«PROJECT_RMAP_NAME»">
		    <cq:rootRequest name="«projectInfo.siteFeatureProjectName»" componentType="eclipse.feature"/>
		</cq:componentQuery>
		'''.writeToFile(PROJECT_CQUERY_NAME)
	}
	
	/**
	 * Creates platform cquery.<br>
	 * @param projectInfo Project configuration to use
	 */
	def private createPlatformCquery(RelengProjectInfo projectInfo) {
		'''
		<?xml version="1.0" encoding="UTF-8"?>
		<cq:componentQuery xmlns:cq="http://www.eclipse.org/buckminster/CQuery-1.0" resourceMap="«PLATFORM_RMAP_NAME»">
		    <cq:rootRequest name="«projectInfo.projectName»" componentType="buckminster"/>
		    <cq:property key="target.arch" value="*"/>
		    <cq:property key="target.os" value="*"/>
		    <cq:property key="target.ws" value="*"/>
		    <cq:advisorNode namePattern="^.*\.source$" skipComponent="true"/>
		</cq:componentQuery>

		'''.writeToFile(PLATFORM_CQUERY_NAME)
	}
	
	/**
	 * Creates platform rmap.<br>
	 * @param projectInfo Project configuration to use
	 */
	def private createPlatformRmap(RelengProjectInfo projectInfo) {
		'''
		<?xml version="1.0" encoding="UTF-8"?>
		<rm:rmap xmlns:bc="http://www.eclipse.org/buckminster/Common-1.0" xmlns:rm="http://www.eclipse.org/buckminster/RMap-1.0">
		  <rm:property key="eclipse.download" value="http://download.eclipse.org"/>
		  <rm:property key="xtext.p2.repository" value="${eclipse.download}/modeling/tmf/xtext/updates/composite/releases/"/>
		  <rm:property key="eclipse.target.platform" value="${eclipse.download}/releases/juno"/>
		  <rm:redirect pattern="«projectInfo.projectName»" href="«PROJECT_RMAP_NAME»"/>
		  <rm:locator pattern="^org\.eclipse\.(?:xtext|xpand|xtend|xtend2|emf\.mwe|emf\.mwe2)(?:\..+)?$" searchPathRef="xtext"/>
		  <rm:locator pattern="^com\.google.*" searchPathRef="xtext"/>
		  <rm:locator pattern="^org\.antlr.*" searchPathRef="xtext"/>
		  <rm:locator pattern="javax.inject" searchPathRef="xtext"/>
		  <rm:locator searchPathRef="eclipse"/>
		  <rm:searchPath name="xtext">
		    <rm:provider componentTypes="osgi.bundle,eclipse.feature" readerType="p2" source="false">
		      <rm:property key="buckminster.source" value="false"/>
		      <rm:uri format="{0}">
		        <bc:propertyRef key="xtext.p2.repository"/>
		      </rm:uri>
		    </rm:provider>
		  </rm:searchPath>
		  <rm:searchPath name="eclipse">
		    <rm:provider componentTypes="eclipse.feature,osgi.bundle" readerType="p2" source="false" mutable="false">
		      <rm:property key="buckminster.source" value="false"/>
		      <rm:property key="buckminster.mutable" value="false"/>
		      <rm:uri format="{0}">
		        <bc:propertyRef key="eclipse.target.platform"/>
		      </rm:uri>
		    </rm:provider>
		  </rm:searchPath>
		</rm:rmap>
		'''.writeToFile(PLATFORM_RMAP_NAME)
	}
	
	/**
	 * Creates projects rmap.<br>
	 * @param projectInfo Project configuration to use
	 */
	def private createProjectRmap(RelengProjectInfo projectInfo) {
		'''
		<?xml version="1.0" encoding="UTF-8"?>
		<rm:rmap xmlns:bc="http://www.eclipse.org/buckminster/Common-1.0" xmlns:rm="http://www.eclipse.org/buckminster/RMap-1.0">
		  <rm:property key="projects.location" value="${workspace.root}"/>
		  <rm:locator pattern="^«projectInfo.projectNameSpace.replaceAll("\\.","\\.")»(?:\..+)?$" searchPathRef="project"/>
		  <rm:searchPath name="project">
		    <rm:provider componentTypes="eclipse.feature,osgi.bundle,buckminster" readerType="local" mutable="false">
		      <rm:property key="buckminster.mutable" value="false"/>
		      <rm:uri format="{0}/{1}">
		        <bc:propertyRef key="projects.location"/>
		        <bc:propertyRef key="buckminster.component"/>
		      </rm:uri>
		    </rm:provider>
		  </rm:searchPath>
		</rm:rmap>
		'''.writeToFile(PROJECT_RMAP_NAME)
	}
	
	/**
	 * Creates launch configuration file that installs headless buckminster<br>
	 * @param projectInfo Project configuration to use
	 */
	def  createInstallBuckminsterLaunch(RelengProjectInfo projectInfo) {
		'''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<launchConfiguration type="org.eclipse.pde.ui.RuntimeWorkbench">
		<booleanAttribute key="append.args" value="true"/>
		<booleanAttribute key="askclear" value="true"/>
		<booleanAttribute key="automaticAdd" value="true"/>
		<booleanAttribute key="automaticValidate" value="false"/>
		<stringAttribute key="bootstrap" value=""/>
		<stringAttribute key="checked" value="[NONE]"/>
		<booleanAttribute key="clearConfig" value="false"/>
		<booleanAttribute key="clearws" value="false"/>
		<booleanAttribute key="clearwslog" value="false"/>
		<stringAttribute key="configLocation" value="${workspace_loc}/.metadata/.plugins/org.eclipse.pde.core/Install headless buckminster"/>
		<booleanAttribute key="default" value="true"/>
		<booleanAttribute key="includeOptional" value="true"/>
		<stringAttribute key="location" value="«P2DirectorLaunch::LOCATION»"/>
		<stringAttribute key="org.eclipse.jdt.launching.PROGRAM_ARGUMENTS" value="-os ${target.os} -ws ${target.ws} -arch ${target.arch} -nl ${target.nl} -consoleLog «P2DirectorLaunch::args»"/>
		<stringAttribute key="org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER" value="org.eclipse.pde.ui.workbenchClasspathProvider"/>
		<stringAttribute key="org.eclipse.jdt.launching.VM_ARGUMENTS" value="-Xms40m -Xmx512m"/>
		<stringAttribute key="pde.version" value="3.3"/>
		<stringAttribute key="product" value="«P2DirectorLaunch::PRODUCT»"/>
		<booleanAttribute key="show_selected_only" value="false"/>
		<stringAttribute key="templateConfig" value="${target_home}/configuration/config.ini"/>
		<booleanAttribute key="tracing" value="false"/>
		<booleanAttribute key="useCustomFeatures" value="false"/>
		<booleanAttribute key="useDefaultConfig" value="true"/>
		<booleanAttribute key="useDefaultConfigArea" value="true"/>
		<booleanAttribute key="useProduct" value="true"/>
		</launchConfiguration>
		'''.writeToFile(INSTALL_BUCKY_LAUNCH)
	}
	
}