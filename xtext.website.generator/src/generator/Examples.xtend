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
	@Inject extension XdocExtensions
	@Inject extension HtmlExtensions

	override getStandaloneSetup() {
		new ExampleSetup
	}	

	override getXdocDocumentRootFolder() {
		'../docs/org.xtext.sevenlanguages.doc.xdoc/xdoc'
	}

 	override path() {
    	'examples.html'
  	}
  	
  	override navBar() '''
		<!-- Navbar -->
		<div class="navbar navbar-fixed-top"
			style="border-bottom: 1px solid #000;">
			<div class="navbar-inner">
				<div class="container">
					<a class="btn btn-navbar" data-toggle="collapse"
						data-target=".nav-collapse"> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="brand" href="index.html"></a>
		
		
					<div class="nav-collapse collapse" style="height: 0px;">
						<ul class="nav">
							<li «IF path == 'download.html'»class="active"«ENDIF»><a href="download.html">Download</a></li>
							«navbarDropdown»
							<li «IF path == 'documentation.html'»class="active"«ENDIF»><a href="documentation.html">Documentation</a></li>
							<li «IF path == 'community.html'»class="active"«ENDIF»><a href="community.html">Community</a></li>
							<li><a href="http://www.eclipse.org">Eclipse.org</a></li>
						</ul>
		
					</div>
					<!--/.nav-collapse -->
		
				</div>
			</div>
		</div>
		<!-- Navbar End -->
	'''
  	
  	def navbarDropdown() '''
		<li class="dropdown«IF path == 'examples.html'» active«ENDIF»">
			<a href="examples.html" class="dropdown-toggle" data-toggle="dropdown">Examples<b class="caret"></b></a>
			<ul class="dropdown-menu">
				«FOR chapter: document.allChapters»
					<li><a href="#«chapter.href»">«chapter.title.toHtmlText»</a></li>
				«ENDFOR»
			</ul>
		</li>
  	'''
  
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
		<section id="«chapter.href»" style="padding-top: 68px; margin-top: -68px;">
			<div class="row">
				<div class="span10 offset1">
					<h1>
						«chapter.title.toHtmlText»
					</h1>
					<hr style="margin-top: 5px; margin-bottom: 5px;">
					«FOR content : chapter.contents»
						«content?.toHtmlParagraph»
					«ENDFOR»
					«FOR section: chapter.sections»
						«section.h2»
					«ENDFOR»
				</div>
			</div>
		</section>
	'''
	
}