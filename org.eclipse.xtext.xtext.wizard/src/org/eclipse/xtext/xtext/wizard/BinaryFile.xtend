package org.eclipse.xtext.xtext.wizard

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import java.net.URL

@FinalFieldsConstructor
class BinaryFile extends AbstractFile {

	@Accessors val URL content

	def URL getContent() {
		return content
	}
}