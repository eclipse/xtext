package org.eclipse.xtext.ui.util

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.SubMonitor
import org.eclipse.swt.widgets.Shell

import static org.eclipse.xtext.ui.util.FeatureProjectFactory.*
import java.util.List
import java.util.ArrayList
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.resources.IFile

/**
 * Creates a simple feature project.<br>
 * Created project contains .project, build.properties and feature.xml files<br>
 * Plugin entries can be added using {@link FeatureProjectFactory#addBundle(String)} method.<br>
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
class FeatureProjectFactory extends ProjectFactory {
	
	static String MANIFEST_FILENAME = "feature.xml";
	
	List<String> containedBundles = new ArrayList()
	String featureLabel
	
	def void setFeatureLabel(String label) {
		featureLabel = label
	}
	
	/**
	 * Adds a new plugin entry
	 */
	def FeatureProjectFactory addBundle(String bundleId) {
		containedBundles.add(bundleId);
		return this;
	}
	
	@Override
	override protected void enhanceProject(IProject project, SubMonitor subMonitor, Shell shell) throws CoreException {
		super.enhanceProject(project, subMonitor, shell);
		createManifest(project, subMonitor.newChild(1));
		createBuildProperties(project, subMonitor.newChild(1));
	}

	def private void createBuildProperties(IProject project, IProgressMonitor monitor) {
		'''
			bin.includes =«MANIFEST_FILENAME»
		'''
		.writeToFile("build.properties", project, monitor);
	}

	def private void createManifest(IProject project, IProgressMonitor monitor) {
		'''
		<?xml version="1.0" encoding="UTF-8"?>
		<feature id="«projectName»"
			label="«if(!featureLabel.nullOrEmpty) featureLabel else projectName + " Feature"»"
			version="1.0.0.qualifier">
			«FOR containedBundle: containedBundles»
			<plugin
					id="«containedBundle»"
					download-size="0"
					install-size="0"
					version="0.0.0"
					unpack="false"/>
			«ENDFOR»
		</feature>
		'''
		.writeToFile(MANIFEST_FILENAME, project, monitor)
	}
	
	def private IFile writeToFile(CharSequence chrSeq, String fileName, IProject project, IProgressMonitor progrMonitor) {
		return createFile(fileName, project, chrSeq.toString, progrMonitor);
	}
}