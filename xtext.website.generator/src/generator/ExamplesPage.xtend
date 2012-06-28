package generator

import bootstrap.Body
import bootstrap.HtmlExtensions
import bootstrap.PostProcessor
import bootstrap.TargetPaths
import bootstrap.XdocExtensions
import com.google.inject.Inject
import org.eclipse.xtext.xdoc.xdoc.AbstractSection
import org.eclipse.xtext.xdoc.xdoc.Document

public class ExamplesPage extends AbstractXdocBaseWebsite {
	@Inject extension Body
	@Inject extension HtmlExtensions
	@Inject PostProcessor processor
	@Inject extension TargetPaths
	@Inject extension XdocExtensions

	val AbstractSection rootSection
	val Document document 
	
	new(Document document, AbstractSection rootSection) {
		this.document = document
		this.rootSection = rootSection
	}	
	
	override getDocument() {
		document
	}
	
	override getStandaloneSetup() {
		new ExamplesSetup
	}
	
	override path() {
		rootSection.targetPath
	}
	
	override website() {
		processor.postProcess(super.website())
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
				«FOR rootSection: document.targetRoots»
					<li><a href="«rootSection.href»">«rootSection.title.toHtmlText»</a></li>
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
				«rootSection.body»
			</div>
		</div>
	'''

}
