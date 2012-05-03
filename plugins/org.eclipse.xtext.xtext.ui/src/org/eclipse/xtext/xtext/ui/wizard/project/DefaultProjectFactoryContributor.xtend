package org.eclipse.xtext.xtext.ui.wizard.project

import org.eclipse.core.resources.IProject
import org.eclipse.xtext.ui.util.IProjectFactoryContributor
import org.eclipse.xtext.ui.util.IProjectFactoryContributor$IFileCreator
import org.eclipse.core.resources.IFile

/**
 * Default implemetation of org.eclipse.xtext.ui.util.IProjectFactoryContributor
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
class DefaultProjectFactoryContributor implements IProjectFactoryContributor {

	override contributeFiles(IProject project, IFileCreator fileWriter) {}
	
	def protected  IFile writeToFile(CharSequence chrSeq, IFileCreator fCreator, String fileName) {
		return fCreator.writeToFile(chrSeq,fileName);
	}
}