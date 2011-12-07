package bootstrap

import com.google.inject.Inject
import com.google.inject.Provider
import java.io.File
import java.io.FileWriter
import java.util.Collections
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.mwe.PathTraverser
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xdoc.XdocStandaloneSetup
import org.eclipse.xtext.xdoc.xdoc.Document

class GenerateBootstrapDoc {
	
	def static void main(String[] args) {
		val injector = new XdocStandaloneSetup().createInjectorAndDoEMFRegistration
		injector.getInstance(typeof(GenerateBootstrapDoc)).generate
	}
	
	@Inject
	Provider<ResourceSet> provider
	
	@Inject
	MainSite mainSite
	
	@Inject
	extension Menu

	@Inject
	extension Body

	@Inject
	extension PostProcessor
	
	@Inject IResourceValidator validator
	
	def void generate() {
		val document = loadDocument
		val writer = new FileWriter(new File("bootstrap/index.html"))
		writer.append(main(document))
		writer.close
		println("Done.")
	}
	
	def loadDocument() {
		val rs = provider.get
		// TODO: use classpath rather than relative path
		val uris = new PathTraverser().resolvePathes(
			Collections::singletonList("../org.eclipse.xtext.xtend2.doc/xdoc"), 
			[fileExtension == "xdoc"]
		).values
		for(uri: uris) {
			println("Loading " + uri)
			rs.getResource(uri, true)
		}
		EcoreUtil2::resolveAll(rs)
		for(resource: rs.resources) {
			val issues = validator.validate(resource, CheckMode::ALL, null)
			if (issues.exists( i | i.severity == Severity::ERROR)) {
				throw new IllegalStateException(issues.toString)
			}
		}
		return rs.allContents.filter(typeof(Document)).head
	}
	
	
	def main(Document document) {
		'''
			«mainSite.header»
				«document.menu»
				«document.body»
			«mainSite.footer»
		'''.postProcess
	}
		
}