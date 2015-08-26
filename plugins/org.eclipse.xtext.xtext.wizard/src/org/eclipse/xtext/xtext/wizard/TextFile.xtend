package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
abstract class TextFile extends GeneratedFile {
	@Accessors val ProjectDescriptor project

	override getBytes() {
		content.toString.getBytes(project.config.encoding)
	}
	
	abstract def CharSequence getContent()
}