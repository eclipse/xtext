package org.eclipse.xtend.core.macro.fsaccess

import java.io.File
import org.eclipse.xtend.lib.macro.services.ResourceHandle
import org.eclipse.xtext.parser.IEncodingProvider

import static extension java.nio.charset.Charset.*

abstract class RuntimeResourceHandle implements ResourceHandle {

	protected final File file

	protected final IEncodingProvider encodingProvider

	new(File file, IEncodingProvider encodingProvider) {
		this.file = file
		this.encodingProvider = encodingProvider
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

	def getEncoding() {
		encodingProvider.getEncoding(null).forName
	}

}
