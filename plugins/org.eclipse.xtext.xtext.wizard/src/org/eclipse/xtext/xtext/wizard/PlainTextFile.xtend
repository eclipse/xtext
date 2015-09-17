package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

@FinalFieldsConstructor
class PlainTextFile extends TextFile {
	@Accessors val CharSequence content
	
	override String getContent() {
		content.toString
	}
}