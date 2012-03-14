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
	static String CATEGORY_FILE_NAME = "category.xml";
	static String BUILD_PROPS_FILE_NAME = "build.properties";
	
	List containedBundles = new ArrayList()
	List includedFeatures = new ArrayList()
	Boolean createCategoryFile = false
	String mainCategoryName
	
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
	
	/**
	 * Adds a new included feature entry
	 */
	def FeatureProjectFactory addFeature(String featureId) {
		includedFeatures.add(featureId);
		return this;
	}
	
	
	def FeatureProjectFactory withCategoryFile(String mainCategoryName) {
		createCategoryFile = true
		this.mainCategoryName = mainCategoryName
		return this;
	}
	
	@Override
	override protected void enhanceProject(IProject project, SubMonitor subMonitor, Shell shell) throws CoreException {
		super.enhanceProject(project, subMonitor, shell);
		createManifest(project, subMonitor.newChild(1));
		createBuildProperties(project, subMonitor.newChild(1));
		if(createCategoryFile) {
			createCategoryFile(project, mainCategoryName, subMonitor.newChild(1))
		}
	}

	def private void createBuildProperties(IProject project, IProgressMonitor monitor) {
		'''
			bin.includes =«MANIFEST_FILENAME»
		'''
		.writeToFile(BUILD_PROPS_FILE_NAME, project, monitor);
	}

	def private void createManifest(IProject project, IProgressMonitor monitor) {
		'''
		<?xml version="1.0" encoding="UTF-8"?>
		<feature id="«projectName»"
			label="«if(!featureLabel.nullOrEmpty) featureLabel else projectName + " Feature"»"
			version="1.0.0.qualifier">
			«FOR includedFeature: includedFeatures»
			<includes
				id="«includedFeature»"
				version="0.0.0"/>
        	«ENDFOR»
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
	
	def private void createCategoryFile(IProject project, String categoryName, IProgressMonitor monitor) {	
		'''
		<?xml version="1.0" encoding="UTF-8"?>
		<site>
			«FOR includedFeature: includedFeatures»
			<feature id="«includedFeature»" version="0.0.0">
				<category name="main"/>
			</feature>
			<feature id="«includedFeature».source" version="0.0.0">
				<category name="main.source"/>
			</feature>
			«ENDFOR»
		   <category-def name="main" label="«categoryName»"/>
		   <category-def name="main.source" label="Source for «categoryName»"/>
		</site>
		'''
		.writeToFile(CATEGORY_FILE_NAME, project, monitor);
	}
	
	def private IFile writeToFile(CharSequence chrSeq, String fileName, IProject project, IProgressMonitor progrMonitor) {
		return createFile(fileName, project, chrSeq.toString, progrMonitor);
	}
}