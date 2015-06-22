package org.eclipse.xtext.idea.sdomain.idea.facet

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class SDomainGeneratorConfigurationState {
	
	boolean activated
	boolean createDirectory
	boolean deleteGenerated
	boolean overwriteExisting
	
	String directory
}
