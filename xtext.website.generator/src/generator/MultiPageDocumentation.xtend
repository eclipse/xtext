package generator

import bootstrap.TargetPaths
import com.google.inject.Inject
import java.io.File
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xdoc.xdoc.Chapter
import org.eclipse.xtext.xdoc.xdoc.Document
import org.eclipse.xtext.xdoc.xdoc.ImageRef
import xdocgen.DocumentLoad

import static extension com.google.common.io.Files.*

class MultiPageDocumentation implements Resource {
	
	new() {
		val injector = standaloneSetup.createInjectorAndDoEMFRegistration
		injector.injectMembers(this)
		doc = docLoader.loadDocument(xdocDocumentRootFolder)
		doc.splitAt([it instanceof Chapter], "documentation")	
	}
	
	def getStandaloneSetup() {
		new DocumentationSetup
	}
	
	def getXdocDocumentRootFolder() {
		'../docs/org.eclipse.xtext.doc.xdoc/xdoc'
	}

	val Document doc
	
	@Inject DocumentLoad docLoader
	@Inject extension TargetPaths
	
	override generateTo(File targetDir) {
		for(section: doc.targetRoots) {
			new DocumentationPage(doc, section).generateTo(targetDir)
		}
		copyImages(doc, targetDir)
	}
	
	def copyImages(Document doc, File targetDir) {
		val iter = EcoreUtil::getAllContents(doc.eResource.resourceSet, true)
		iter.filter(typeof(ImageRef)).forEach[
			val source = new File(eResource.URI.trimSegments(1).toFileString, path)
			if (!source.exists)
				throw new IllegalStateException("Referenced Image "+source.canonicalPath+" does not exist in "+eResource.URI.lastSegment+" line "+NodeModelUtils::getNode(it).startLine)
			val target = new File(targetDir, path)
			println(target.canonicalPath)
			
			source.newInputStreamSupplier.copy(target)
		]
	}
}

