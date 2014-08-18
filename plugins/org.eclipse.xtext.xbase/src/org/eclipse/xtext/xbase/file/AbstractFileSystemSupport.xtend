package org.eclipse.xtext.xbase.file

import com.google.common.io.CharStreams
import com.google.inject.Inject
import java.io.IOException
import java.io.InputStreamReader
import java.io.UnsupportedEncodingException
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.generator.IFilePostProcessor
import org.eclipse.emf.common.util.URI

abstract class AbstractFileSystemSupport implements MutableFileSystemSupport {

	@Inject @Accessors IEncodingProvider encodingProvider
	@Inject @Accessors IFilePostProcessor postProcessor
	
	override CharSequence getContents(Path path) {
		try {
			val reader = new InputStreamReader(path.contentsAsStream, path.getCharset)
			var IOException threw = null
			try {
				return CharStreams.toString(reader)
			} catch(IOException e) {
				threw = e;
			} finally {
				try {
					reader.close
				} catch(IOException e) {
					if (threw == null)
						threw = e
				}
			}
			if (threw == null) {
				throw new AssertionError("threw cannot be null here")
			}
			throw threw
		} catch (IOException exc) {
			throw new IllegalArgumentException(exc.message, exc)	
		}
	}
	
	override void setContents(Path path, CharSequence contents) {
		val processedContents = postProcessor.postProcess(URI.createFileURI(path.toString), contents)
		path.parent.mkdir
		try {
			path.setContentsAsStream(new StringInputStream(processedContents.toString, path.getCharset))
		} catch (UnsupportedEncodingException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}
	
	def Path getPath(Resource res);
}