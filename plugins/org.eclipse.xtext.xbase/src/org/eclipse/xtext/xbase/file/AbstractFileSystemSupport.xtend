package org.eclipse.xtext.xbase.file

import com.google.common.io.CharStreams
import com.google.inject.Inject
import java.io.InputStreamReader
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.emf.ecore.resource.Resource

abstract class AbstractFileSystemSupport implements MutableFileSystemSupport {

	@Inject @Property IEncodingProvider encodingProvider
	
	override CharSequence getContents(Path path) {
		return CharStreams.toString [| new InputStreamReader(path.contentsAsStream, path.getCharset) ];
	}
	
	override void setContents(Path path, CharSequence contents) {
		path.parent.mkdir
		path.setContentsAsStream(new StringInputStream(contents.toString, path.getCharset))
	}
	
	def Path getPath(Resource res);
}