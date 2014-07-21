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

abstract class AbstractFileSystemSupport implements MutableFileSystemSupport {

	@Inject @Accessors IEncodingProvider encodingProvider
	
	override CharSequence getContents(Path path) {
		try {
			return CharStreams.toString [| new InputStreamReader(path.contentsAsStream, path.getCharset) ]
		} catch (IOException exc) {
			throw new IllegalArgumentException(exc.message, exc)	
		}
	}
	
	override void setContents(Path path, CharSequence contents) {
		path.parent.mkdir
		try {
			path.setContentsAsStream(new StringInputStream(contents.toString, path.getCharset))
		} catch (UnsupportedEncodingException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}
	
	def Path getPath(Resource res);
}