package org.eclipse.xtext.idea.facet

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.OutputConfiguration

@Accessors
class GeneratorConfigurationState {
	new() {}
	new (OutputConfiguration defOutput) {
		this.setActivated(true);
		if (defOutput != null) {
			this.setOutputDirectory(defOutput.getOutputDirectory());
			this.setTestOutputDirectory(defOutput.getOutputDirectory());
			this.setCreateDirectory(defOutput.isCreateOutputDirectory());
			this.setDeleteGenerated(defOutput.isCanClearOutputDirectory());
			this.setOverwriteExisting(defOutput.isOverrideExistingResources());
		}
	}
	
	boolean activated
	boolean createDirectory
	boolean deleteGenerated
	boolean overwriteExisting
	
	String outputDirectory
	String testOutputDirectory
}
