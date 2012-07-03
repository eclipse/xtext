package generator

import bootstrap.Body
import bootstrap.HtmlExtensions
import bootstrap.PostProcessor
import bootstrap.TargetPaths
import bootstrap.XdocExtensions
import com.google.inject.Binder
import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.Module
import org.eclipse.xtext.xdoc.XdocRuntimeModule
import org.eclipse.xtext.xdoc.XdocStandaloneSetup
import org.eclipse.xtext.xdoc.xdoc.AbstractSection
import org.eclipse.xtext.xdoc.xdoc.Document


class DocumentationPage extends AbstractXdocBaseWebsite {
	
	@Inject extension Body
	@Inject extension HtmlExtensions
	@Inject PostProcessor processor
	@Inject extension TargetPaths
	@Inject extension XdocExtensions

	val AbstractSection section
	val Document document 
	
	new(Document document, AbstractSection section) {
		this.document = document
		this.section = section
	}	
	
	override getDocument() {
		document
	}
	
	override getStandaloneSetup() {
		new DocumentationSetup
	}
	
	override path() {
		section.targetPath
	}
	
	override website() {
		processor.postProcess(super.website())
	}
			
	override contents() '''
		<!--Container-->
		<div id="header_wrapper" class="container">
			<div class="inner">
				<div class="container">
					<div class="page-heading"><h1>Documentation</h1></div>
				</div> <!-- /.container -->
			</div> <!-- /inner -->
			«document.menu»
		</div>
		<div id="page">  
			<div class="inner">
				«section.body»
			</div>
		</div>
	'''
	
	def menu(Document doc) '''
		<ul id="nav-outline">
			«FOR part : doc.parts»
				<li>&nbsp;</li>
				<li style="color : #333;">«part.title.toHtmlText»</li>
				«FOR chapter : part.sections»
					<li><a href="«chapter.href»">«chapter.title.toHtmlText»</a>
					«FOR section : chapter.sections BEFORE subMenuListTag(chapter) AFTER '</ul>'»
						<li><a href="«section.href»">«section.title.toHtmlText»</a></li>
					«ENDFOR»
					</li>
				«ENDFOR»
			«ENDFOR»
			«additionalLinks»
		</ul>
	'''
	
	def String subMenuListTag(AbstractSection section) {
		if(section.targetPath == this.section.targetPath) 
			'<ul style="display: block;">'
		else 
			'<ul>'
	}
	
	def additionalLinks() '''
		<li>&nbsp;</li>
		<li style="color : #333;">Additional Resources
		<li><a href="documentation/2.3.0/Documentation.pdf">Documentation <img src="images/pdf_icon.gif"></a>
		<li><a href="http://download.eclipse.org/modeling/tmf/xtext/javadoc/2.3/">API Documentation (JavaDoc)</a>
	'''
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
	
	override body(AbstractSection rootSection) '''
		<div id="maincontainer" class="container">
			«rootSection.h1»
		</div>
	'''
	
	override h1(AbstractSection section) '''
		<!-- chapter -->
		<section id="«section.hrefId»" style="padding-top: 68px; margin-top: -68px;">
			<div class="row">
				<div class="span8 offset3">
					<h1 style="padding-top: 30px;">
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
	
	override h2(AbstractSection section) '''
		<!--  section -->
		<section id="«section.hrefId»" style="padding-top: 68px; margin-top: -68px;">
		<h2 style="padding-top: 15px;">«section.title.toHtmlText»</h2>
		«FOR content : section.contents»
			«content.toHtmlParagraph»
		«ENDFOR»
		«FOR subsection: section.sections»
			«subsection.h3plus(3)»
		«ENDFOR»
		</section>
	'''
	
	
}