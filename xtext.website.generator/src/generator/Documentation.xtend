package generator

import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Module
import org.eclipse.xtext.xdoc.XdocRuntimeModule
import org.eclipse.xtext.xdoc.XdocStandaloneSetup
import xdocgen.DocumentLoad
import com.google.inject.Inject
import bootstrap.Body
import bootstrap.PostProcessor
import java.io.File
import org.eclipse.xtext.xdoc.xdoc.Document
import bootstrap.HtmlExtensions
import org.eclipse.xtext.xdoc.xdoc.ImageRef
import org.eclipse.emf.ecore.util.EcoreUtil
import static extension com.google.common.io.Files.*
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import bootstrap.XdocExtensions
import org.eclipse.xtext.xdoc.xdoc.Chapter
import org.eclipse.xtext.xdoc.xdoc.AbstractSection

class Documentation extends AbstractXdocBaseWebsite {
	
	new() {
		doc = docLoader.loadDocument(xdocDocumentRootFolder)
	}
	
	override getStandaloneSetup() {
		new DocumentationSetup
	}
	
	def getXdocDocumentRootFolder() {
		'../docs/org.eclipse.xtext.doc.xdoc/xdoc'
	}

	override path() {
		"documentation.html"
	}
	
	val Document doc
	
	@Inject DocumentLoad docLoader
	@Inject extension Body
	@Inject extension HtmlExtensions
	@Inject PostProcessor processor
	
	override website() {
		processor.postProcess(super.website())
	}
	
	override generateTo(File targetDir) {
		super.generateTo(targetDir)
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
	
	override contents() '''
		<!--Container-->
		<div id="header_wrapper" class="container" >
			<div class="inner">
				<div class="container">
					<div class="page-heading"><h1>Documentation</h1></div>
				</div> <!-- /.container -->
			</div> <!-- /inner -->
			«doc.menu»
		</div>
		<div id="page">  
			<div class="inner">
				«doc.body»
			</div>
		</div>
	'''
	
	def menu(Document doc) '''
		<ul id="nav-outline">
			«FOR chapter : doc.chapters»
				<li><a href="#«chapter.href»">«chapter.title.toHtmlText»</a>
				«FOR section : chapter.subSections BEFORE '<ul>' AFTER '</ul>'»
					<li><a href="#«section.href»">«section.title.toHtmlText»</a></li>
				«ENDFOR»
				</li>
			«ENDFOR»
			«FOR part : doc.parts»
				<li>&nbsp;</li>
				<li style="color : #333;">«part.title.toHtmlText»</li>
				«FOR chapter : part.chapters»
					<li><a href="#«chapter.href»">«chapter.title.toHtmlText»</a>
					«FOR section : chapter.subSections BEFORE '<ul>' AFTER '</ul>'»
						<li><a href="#«section.href»">«section.title.toHtmlText»</a></li>
					«ENDFOR»
					</li>
				«ENDFOR»
			«ENDFOR»
		</ul>
	'''
	
	override protected getDocument() {
		doc
	}
}

class DocumentationSetup extends XdocStandaloneSetup implements Module {
	
	override createInjector() {
		val module = new XdocRuntimeModule
		Guice::createInjector(module, this)
	}
	
	override configure(Binder binder) {
		binder.bind(typeof(Body)).to(typeof(DocumentationBody))
	}
}

class DocumentationBody extends Body {
	@Inject extension XdocExtensions
	@Inject extension HtmlExtensions
	
	override h1(Chapter chapter) '''
		<!-- chapter -->
		<section id="«chapter.href»" style="margin-bottom: 50px">
			<div class="row">
				<div class="span8 offset3">
					<h1>
						«chapter.title.toHtmlText»
					</h1>
					<hr style="margin-top: 5px; margin-bottom: 5px;">
					«FOR content : chapter.contents»
						«content.toHtmlParagraph»
					«ENDFOR»
					«FOR section: chapter.sections»
						«section.h2»
					«ENDFOR»
				</div>
			</div>
		</section>
	'''
	
	override h2(AbstractSection section) '''
		<!--  section -->
		<section id="«section.href»" style="margin-top: 20px; padding-top: 0;">
		<h2>«section.title.toHtmlText»</h2>
		«FOR content : section.contents»
			«content.toHtmlParagraph»
		«ENDFOR»
		«FOR subsection: section.sections»
			«subsection.h3plus(3)»
		«ENDFOR»
		</section>
	'''
	
}