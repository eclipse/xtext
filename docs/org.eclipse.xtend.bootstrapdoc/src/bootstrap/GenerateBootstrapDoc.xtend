package bootstrap

import com.google.inject.Inject
import com.google.inject.Provider
import java.io.File
import java.io.FileWriter
import java.util.Collections
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.mwe.PathTraverser
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.eclipse.xtext.xdoc.xdoc.Document
import org.eclipse.xtext.xdoc.xdoc.ImageRef

import static extension com.google.common.io.Files.*
import com.google.inject.name.Named

class GenerateBootstrapDoc {
	
	/**
	 * Use the main methods in xtext.website.generator and xtend.website.generator, instead.
	 */
	def static void main(String[] args) {
		val injector = new Config().createInjectorAndDoEMFRegistration
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
	
	@Inject(optional=true) 
	@Named("documentRoot")
	String documentRoot = "../org.eclipse.xtend.doc.xdoc/xdoc"
	
	@Inject(optional=true) 
	@Named("targetDirectory")
	String targetDirectory = '../../website/documentation'
	
	def void generate() {
		val document = loadDocument
		val targetDir= new File(targetDirectory)
		val sourceDir = new File(documentRoot)
		val file = new File(targetDir, "index.html")
		copyImages(document, sourceDir, targetDir)
		println(file.absoluteFile)
		file.parentFile.mkdirs
		val writer = new FileWriter(file)
		writer.append(main(document))
		writer.close
		println("Done.")
	}
	
	def copyImages(Document doc, File sourceDir, File targetDir) {
		val iter = EcoreUtil::getAllContents(doc.eResource.resourceSet, true)
		iter.filter(typeof(ImageRef)).forEach[
			val source = new File(sourceDir, path)
			if (!source.exists)
				throw new IllegalStateException("Referenced Image "+source.canonicalPath+" does not exist in "+eResource.URI.lastSegment+" line "+NodeModelUtils::getNode(it).startLine)
			val target = new File(targetDir, path)
			println(target.canonicalPath)
			source.newInputStreamSupplier.copy(target)
		]
	}
	
	def loadDocument() {
		val rs = provider.get
		// TODO: use classpath rather than relative path
		val uris = new PathTraverser().resolvePathes(
			Collections::singletonList("../org.eclipse.xtend.doc.xdoc/xdoc"), 
			[fileExtension == "xdoc"]
		).values
		for(uri: uris) {
			println("Loading " + uri)
			rs.getResource(uri, true)
		}
		EcoreUtil2::resolveAll(rs)
		val issues = rs.resources.map[validator.validate(it, CheckMode::ALL, null)].flatten
		if (issues.exists( i | i.severity == Severity::ERROR)) {
			throw new IllegalStateException(issues.map['\n\t'+toString].join())
		} else if (!issues.empty) {
			println(issues.map[toString].join('\n'))
		}
		return rs.allContents.filter(typeof(Document)).head
	}
	
	
	def main(Document document) {
		'''
			«mainSite.header('../bootstrap')»
				«document.menu»
				«document.body»
			«mainSite.footer('../bootstrap')»
		'''.postProcess
	}
		
}