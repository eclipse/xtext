package org.eclipse.xtend.core.macro.fsaccess

import java.io.File
import java.io.InputStream
import java.io.OutputStream
import org.eclipse.xtend.lib.macro.services.FileHandle
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1

import static org.eclipse.xtend.core.macro.fsaccess.IOUtils.*

import static extension com.google.common.io.Files.*

class RuntimeFileHandle extends RuntimeResourceHandle implements FileHandle {

	new(File file, IEncodingProvider encodingProvider) {
		super(file, encodingProvider)
	}

	override getContents() {
		file.toString(encoding)
	}

	override read(Procedure1<InputStream> function) {
		tryWith([|file.newInputStreamSupplier.input], function)
	}

	override write(Procedure1<OutputStream> function) {
		tryWith([|ensureFileCreated().newOutputStreamSupplier.output], function)
	}

	override writeContents(Function1<FileHandle, CharSequence> function) {
		function.apply(this).write(ensureFileCreated(), encoding)
	}

	def ensureFileCreated() {
		val file = file
		if (!file.exists) {
			file.createParentDirs
			file.createNewFile
		}
		file
	}

}
