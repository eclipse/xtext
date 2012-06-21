package bootstrap

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xdoc.generator.util.GitExtensions
import org.eclipse.xtext.xdoc.generator.util.JavaDocExtension

class CodeRefs {
	
	@Inject extension GitExtensions 
	
	@Inject extension JavaDocExtension 
	
	static val NO_SOURCE_PACKAGES = newHashSet("java.", "org.eclipse.", "javax.", "com.mongodb.")
	
	def getJavaDocURI(JvmIdentifiableElement element) {
		val uri = genJavaDocLink(element)
		if(uri.nullOrEmpty) {
			println("Missing JavaDoc link for " + element.identifier)
			return null
		}
		uri
	}

	def getSourceCodeURI(JvmIdentifiableElement element) {
		val uri = gitLink(element)
		if((uri == null || uri.contains('broken-link')) && 
				!NO_SOURCE_PACKAGES.exists[element.identifier.startsWith(it)]) {
			println("Missing source link for " + element.identifier)
			return null
		} 
		uri	
	}
}