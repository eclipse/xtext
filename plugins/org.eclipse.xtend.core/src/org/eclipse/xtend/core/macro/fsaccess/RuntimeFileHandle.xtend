package org.eclipse.xtend.core.macro.fsaccess

import java.io.File
import java.io.InputStream
import java.io.OutputStream
import org.eclipse.xtend.lib.macro.services.FileHandle
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1

import static extension org.eclipse.xtend.core.macro.fsaccess.IOUtils.*

class RuntimeFileHandle extends RuntimeResourceHandle implements FileHandle {

	new(File file) {
		super(file)
	}

	override getContents() {
		tryWith([|file.inputStream.buffered])[asString]
	}

	override read(Procedure1<InputStream> function) {
		tryWith([|file.inputStream], function)
	}

	override write(Procedure1<OutputStream> function) {
		val file = file
		if (!file.exists) {
			val parentFile = file.parentFile
			if (!parentFile.exists) {
				parentFile.mkdirs
			}
			file.createNewFile
		}
		tryWith([|file.outputStream], function)
	}

	override writeContents(Function1<FileHandle, CharSequence> function) {
		function.apply(this) => [ value |
			write [
				tryWith([|writer.buffered])[write(value.toString)]
			]
		]
	}

}
