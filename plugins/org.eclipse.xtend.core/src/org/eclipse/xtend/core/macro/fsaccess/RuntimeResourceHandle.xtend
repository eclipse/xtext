package org.eclipse.xtend.core.macro.fsaccess

import java.io.File
import org.eclipse.xtend.lib.macro.services.ResourceHandle

abstract class RuntimeResourceHandle implements ResourceHandle {

	protected final File file

	new(File file) {
		this.file = file
	}

	override exists() {
		file.exists
	}

	override getName() {
		file.name
	}

	override getPath() {
		file.canonicalPath
	}

}
