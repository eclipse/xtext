package generator

import bootstrap.Body
import bootstrap.HtmlExtensions
import bootstrap.XdocExtensions
import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Module
import org.eclipse.xtext.xdoc.XdocRuntimeModule
import org.eclipse.xtext.xdoc.XdocStandaloneSetup
import org.eclipse.xtext.xdoc.xdoc.AbstractSection
import bootstrap.TargetPaths
import java.io.File
import xdocgen.DocumentLoad
import org.eclipse.xtext.xdoc.xdoc.Document
import org.eclipse.xtext.xdoc.xdoc.Chapter
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.xdoc.xdoc.ImageRef
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

import static extension com.google.common.io.Files.*

class ExamplesResource implements Resource {
	
	@Inject extension TargetPaths
	@Inject DocumentLoad docLoader

	val Document doc
	
	new() {
		val injector = standaloneSetup.createInjectorAndDoEMFRegistration
		injector.injectMembers(this)
		doc = docLoader.loadDocument(xdocDocumentRootFolder)
		doc.splitAt([it instanceof Chapter], "examples")	
	}

	def getStandaloneSetup() {
		new generator.ExamplesSetup
	}	

	def getXdocDocumentRootFolder() {
		'../docs/org.xtext.sevenlanguages.doc.xdoc/xdoc'
	}

  	override generateTo(File targetDir) {
		for(section: doc.targetRoots) {
			new ExamplesPage(doc, section).generateTo(targetDir)
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
	
class ExamplesSetup extends XdocStandaloneSetup implements Module {
	
	override createInjector() {
		val module = new XdocRuntimeModule
		Guice::createInjector(module, this)
	}
	
	override configure(Binder binder) {
		binder.bind(typeof(Body)).to(typeof(ExamplesBody))
	}
}

class ExamplesBody extends DocumentationBody {
	@Inject extension XdocExtensions
	@Inject extension HtmlExtensions
	
	override h1(AbstractSection section) '''
		<!-- chapter -->
		<section id="«section.hrefId»" style="padding-top: 68px; margin-top: -68px;">
			<div class="row">
				<div class="span10 offset1">
					<h1>
						«section.title.toHtmlText»
					</h1>
					<hr style="margin-top: 5px; margin-bottom: 5px;">
					«FOR content : section.contents»
						«content?.toHtmlParagraph»
					«ENDFOR»
					«FOR subSection: section.sections»
						«subSection.h2»
					«ENDFOR»
				</div>
			</div>
		</section>
	'''
	
	override body(AbstractSection rootSection) '''
		<div id="maincontainer" class="container">
			«rootSection.h1»
		</div>
	'''
	
}