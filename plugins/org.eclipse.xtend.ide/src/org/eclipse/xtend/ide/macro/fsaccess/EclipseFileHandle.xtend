package org.eclipse.xtend.ide.macro.fsaccess

import com.google.common.io.CharStreams
import java.io.BufferedInputStream
import java.io.BufferedWriter
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtend.lib.macro.services.FileHandle
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.xbase.lib.Functions.Function1
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1

import static org.eclipse.xtend.core.macro.fsaccess.IOUtils.*

import static extension com.google.common.io.CharStreams.*

class EclipseFileHandle extends EclipseResourceHandle implements FileHandle {

	new(IProject project, IPath path, IEncodingProvider encodingProvider) {
		super(project, path, encodingProvider)
	}

	override getMember() {
		file
	}

	override getContents() {
		CharStreams.toString(new InputStreamReader(file.contents, encoding))
	}

	override read(Procedure1<InputStream> function) {
		tryWith([|file.contents], function)
	}

	override writeContents(Function1<FileHandle, CharSequence> function) {
		write [ outputStream |
			function.apply(this).write [ |
				new BufferedWriter(new OutputStreamWriter(outputStream))
			]
		]
	}

	override write(Procedure1<OutputStream> function) {
		tryWith([|new ByteArrayOutputStream]) [
			function.apply(it)
			tryWith([|new BufferedInputStream(new ByteArrayInputStream(toByteArray))]) [
				file.ensureCreated.setContents(it, true, true, new NullProgressMonitor)
			]
		]
	}

	def dispatch IFile ensureCreated(IFile it) {
		if (!exists) {
			parent.ensureCreated
			create(new ByteArrayInputStream(newByteArrayOfSize(0)), true, new NullProgressMonitor)
		}
		file
	}

	def dispatch IFile ensureCreated(IFolder it) {
		if (!exists) {
			parent.ensureCreated
			create(true, true, new NullProgressMonitor)
		}
		null
	}

	def dispatch IFile ensureCreated(IContainer it) {
		if (!exists) {
			throw new IllegalStateException('''Container does not exist: '«path»'.''')
		}
		null
	}

}
