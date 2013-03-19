package xdocgen

import com.google.inject.Inject
import org.eclipse.xtext.resource.XtextResourceSet
import com.google.inject.Provider
import org.eclipse.xtext.mwe.PathTraverser
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.xdoc.xdoc.Document
import org.eclipse.xtext.validation.Issue

class DocumentLoad {
	
	@Inject
	Provider<XtextResourceSet> provider
	
	val validate = false
	
	def loadDocument(String ... baseDirs) {
		val rs = provider.get
		// TODO: use classpath rather than relative path
		val uris = new PathTraverser().resolvePathes(
			baseDirs, 
			[fileExtension == "xdoc"]
		).values
		for(uri: uris + xtendFiles) {
			println("Loading " + uri)
			rs.getResource(uri, true)
		}
		if (validate) {
			EcoreUtil2::resolveAll(rs)
			val issues = rs.resources.map[
				switch it {
					XtextResource : {
						val validator = it.resourceServiceProvider.resourceValidator
						validator.validate(it, CheckMode::ALL, null)
					}
					default : <Issue>emptyList
				}
			].flatten
			if (issues.exists( i | i.severity == Severity::ERROR)) {
				throw new IllegalStateException(issues.map['\n\t'+toString].join())
			} else if (!issues.empty) {
				println(issues.map[toString].join('\n'))
			}
		}
		val docs = rs.allContents.filter(typeof(Document)).toList
		return docs.head
	}
	
	
	def protected getXtendFiles() {
		val classPath = System::getProperty("java.class.path");
		val separator = System::getProperty("path.separator");
		val entries = classPath.split(separator);
		new PathTraverser().resolvePathes(entries, [fileExtension == 'xtend']).values
	}
}