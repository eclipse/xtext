package generator

import com.google.inject.Inject
import bootstrap.Body

class Examples extends Documentation {
	
	@Inject extension Body

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