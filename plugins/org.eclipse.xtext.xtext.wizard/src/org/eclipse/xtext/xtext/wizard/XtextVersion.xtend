package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Data

@Data
class XtextVersion {
	String version
	
	def isSnapshot() {
		version.endsWith("-SNAPSHOT")
	}
	
	override toString() {
		version
	}
}