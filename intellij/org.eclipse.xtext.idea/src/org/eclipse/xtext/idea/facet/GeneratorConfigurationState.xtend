package org.eclipse.xtext.idea.facet

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.OutputConfiguration

@Accessors
class GeneratorConfigurationState {
	new() {
	}

	new(OutputConfiguration defOutput) {
		activated = true
		if (defOutput != null) {
			var outputDir = defOutput.outputDirectory
			if ("./src-gen" == outputDir) {
				outputDir = "src-gen"
			}
			outputDirectory = outputDir
			testOutputDirectory = outputDir
			createDirectory = defOutput.createOutputDirectory
			deleteGenerated = defOutput.canClearOutputDirectory
			overwriteExisting = defOutput.overrideExistingResources
		}
	}

	boolean activated
	boolean createDirectory
	boolean deleteGenerated
	boolean overwriteExisting

	String outputDirectory
	String testOutputDirectory
}
