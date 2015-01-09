package bootstrap

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.xdoc.generator.util.GitExtensions
import org.eclipse.xtext.xdoc.generator.util.JavaDocExtension
import org.apache.log4j.Logger

class CodeRefs {
	
	static val LOG = Logger::getLogger(typeof(CodeRefs))
	
	@Inject extension GitExtensions 
	
	@Inject extension JavaDocExtension 
	
	static val NO_JAVADOC_PACKAGE_PREFIXES = newHashSet('org.xtext.')
	static val NO_SOURCE_PACKAGE_PREFIXES = newHashSet('java.', 'org.eclipse.', 'javax.', 'com.mongodb.', 'com.google.', 'org.junit.')
	
	def getJavaDocURI(JvmIdentifiableElement element) {
		val uri = genJavaDocLink(element)
		if(uri.nullOrEmpty && !NO_JAVADOC_PACKAGE_PREFIXES.exists[val identifier = element?.identifier identifier != null && identifier.startsWith(it)]) {
			LOG.error('Missing JavaDoc link for ' + element.identifier)
			return null
		}
		uri
	}

	def getSourceCodeURI(JvmIdentifiableElement element) {
		val uri = gitLink(element)
		if((uri == null || uri.contains('broken-link')) && element.identifier != null &&
				!NO_SOURCE_PACKAGE_PREFIXES.exists[element.identifier.startsWith(it)]) {
			LOG.error('Missing source link for ' + element.identifier)
			return null
		} 
		uri	
	}
}