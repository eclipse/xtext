package org.eclipse.xtend.ide.macro.fsaccess

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtend.lib.macro.services.FileHandle
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1

import static extension org.eclipse.xtend.core.macro.fsaccess.IOUtils.*

class EclipseFileHandle extends EclipseResouceHandle implements FileHandle {

	new(IProject project, IPath path) {
		super(project, path)
	}

	override getContents() {
		tryWith([|file.contents])[asString]
	}

	override read(Procedure1<InputStream> function) {
		tryWith([|file.contents], function)
	}

	override writeContents(Function1<FileHandle, CharSequence> function) {
		function.apply(this) => [ value |
			write [
				tryWith([|writer.buffered]) [
					write(value.toString)
				]
			]
		]
	}

	override write(Procedure1<OutputStream> function) {
		tryWith([|new ByteArrayOutputStream]) [
			function.apply(it)
			tryWith([|toByteArray.inputStream.buffered]) [
				val file = file
				if (file.exists) {
					file.setContents(it, true, true, new NullProgressMonitor)
				} else {
					file.create(it)
				}
			]
		]
	}

	def void create(IFile it, InputStream inputStream) {
		if (!exists) {
			parent.create
			create(inputStream, true, new NullProgressMonitor)
		}
	}

	def dispatch void create(IFolder it) {
		if (!exists) {
			parent.create
			create(true, true, new NullProgressMonitor)
		}
	}

	def dispatch void create(IContainer it) {
		if (!exists) {
			throw new IllegalStateException('''Container does not exist: '«path»'.''')
		}
	}

	override getMember() {
		file
	}

}
