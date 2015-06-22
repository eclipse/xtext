package org.eclipse.xtext.idea.facet

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class GeneratorConfigurationState {
	
	boolean activated
	boolean createDirectory
	boolean deleteGenerated
	boolean overwriteExisting
	
	String outputDirectory
	String testOutputDirectory
}
