package generator

import org.eclipse.xtext.xdoc.xdoc.Document

abstract class AbstractXdocBaseWebsite extends AbstractWebsite {
	
	def protected Document getDocument()
	
	override javaScriptDocumentStart()
	'''
		«super.javaScriptDocumentStart()»
		«prettify»
	'''
	
	def prettify() { 
		var result = '''
		<link href="google-code-prettify/prettify.css" type="text/css" rel="stylesheet" />
		<script type="text/javascript" src="google-code-prettify/prettify.js"></script>
		<script type="text/javascript" src="google-code-prettify/lang-common.js"></script>'''
		if(document != null){
			val languages = document.langDefs
			if(languages.size > 0)
				// Do not override standard language definitions java & xml in prettify
				result = result + '''
				<script type="text/javascript">
					«FOR lang : languages»
					«IF !(lang.name.equalsIgnoreCase("java") || lang.name.equalsIgnoreCase("xml"))»
					registerLanguage('«FOR keyword : lang.keywords SEPARATOR "|"»«keyword»«ENDFOR»', '«lang.name.toLowerCase»');
					«ENDIF»
					«ENDFOR»
				</script>
				'''
		}
		return result
	}
}