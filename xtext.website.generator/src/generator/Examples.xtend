package generator

import com.google.inject.Inject
import bootstrap.Body
import org.eclipse.xtext.xdoc.XdocStandaloneSetup
import com.google.inject.Module
import com.google.inject.Binder
import org.eclipse.xtext.xdoc.XdocRuntimeModule
import com.google.inject.Guice
import org.eclipse.xtext.xdoc.xdoc.Chapter
import bootstrap.XdocExtensions
import bootstrap.HtmlExtensions

class Examples extends Documentation {
	
	@Inject extension Body

	override getStandaloneSetup() {
		new ExampleSetup
	}	

	override getXdocDocumentRootFolder() {
		'../docs/org.xtext.sevenlanguages.doc.xdoc/xdoc'
	}

 	override path() {
    	'examples.html'
  	}
  
	override contents() '''
			<!--Container-->
		<div id="header_wrapper" class="container" >
			<div class="inner">
				<div class="container">
					<div class="page-heading"><h1>Documentation</h1></div>
				</div> <!-- /.container -->
			</div> <!-- /inner -->
		</div>
		<div id="page">  
			<div class="inner">
				«document.body»
			</div>
		</div>
	'''
	
}

class ExampleSetup extends XdocStandaloneSetup implements Module {
	
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
	
	override h1(Chapter chapter) '''
		<!-- chapter -->
		<section id="«chapter.href»" style="margin-bottom: 50px">
			<div class="row">
				<div class="span10 offset1">
					<h1>
						«chapter.title.toHtml»
					</h1>
					<hr style="margin-top: 5px; margin-bottom: 5px;">
					«FOR content : chapter.contents»
						«content?.toHtml»
					«ENDFOR»
					«FOR section: chapter.sections»
						«section.h2»
					«ENDFOR»
				</div>
			</div>
		</section>
	'''
	
}