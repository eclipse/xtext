package org.eclipse.xtext.xtext.ui.wizard.releng.templates

import org.eclipse.xtext.xtext.ui.wizard.releng.RelengProjectInfo
import org.eclipse.xtext.ui.util.IProjectFactoryContributor
import org.eclipse.core.resources.IProject
import org.eclipse.xtext.ui.util.IProjectFactoryContributor$IFileCreator
import org.eclipse.core.resources.IFile
/**
 * Creates spex for the site feature to define build time dependencies.<br>
 *
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
class SiteSpexCreator implements IProjectFactoryContributor {
	RelengProjectInfo projectInfo
	
	new(RelengProjectInfo projectInfo) {
		this.projectInfo = projectInfo
	}
	
	override contributeFiles(IProject project, IFileCreator fileCreator) {
		'''
		<?xml version="1.0" encoding="UTF-8"?>
		<cs:cspecExtension xmlns:com="http://www.eclipse.org/buckminster/Common-1.0" xmlns:cs="http://www.eclipse.org/buckminster/CSpec-1.0">
			<cs:dependencies>
				«FOR testProject:projectInfo.testLaunchers.map([it.project])»
				<cs:dependency name="«testProject.name»" componentType="osgi.bundle" />
				«ENDFOR»
			</cs:dependencies>
		</cs:cspecExtension>
		'''.writeToFile(fileCreator, "buckminster.cspex")
	}
	
	def private IFile writeToFile(CharSequence chrSeq, IFileCreator fCreator, String fileName) {
		return fCreator.writeToFile(chrSeq,fileName);
	}
}