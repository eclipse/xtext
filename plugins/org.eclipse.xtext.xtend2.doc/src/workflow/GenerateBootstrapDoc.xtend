package workflow

import bootstrap.MainSite
import bootstrap.Menu
import com.google.inject.Inject
import com.google.inject.Provider
import java.io.File
import java.io.FileWriter
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xdoc.XdocStandaloneSetup
import org.eclipse.xtext.xdoc.xdoc.XdocFile
import org.eclipse.xtext.diagnostics.Severity

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
	
	@Inject IResourceValidator validator
	
	def void generate() {
		val file = loadFile
		val writer = new FileWriter(new File("index.html"))
		writer.append(main(file))
		writer.close
	}
	
	def loadFile() {
		val rs = provider.get
		val resource = rs.getResource(URI::createURI("xdoc/Xtend.xdoc"), true)
		val issues = validator.validate(resource, CheckMode::ALL, null)
		if (issues.exists( i | i.severity == Severity::ERROR)) {
			throw new IllegalStateException(issues.toString)
		}
		return resource.contents.head as XdocFile
	}
	
	
	def main(XdocFile file) '''
		«mainSite.header»
			«file.menu»
		«mainSite.footer»
	'''
}