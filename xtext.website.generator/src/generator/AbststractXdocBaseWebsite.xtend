package generator

import org.eclipse.xtext.xdoc.xdoc.Document

abstract class AbstractXdocBaseWebsite extends AbstractWebsite {
	
	def protected Document getDocument()
	
	override javaScriptAtTheEnd() '''
		«super.javaScriptAtTheEnd()»
		«prettify»
	'''
	
	override protected isPrettyPrint() {
		true
	}
	
	def prettify() { 
		var result = '''<script type="text/javascript" src="google-code-prettify/lang-common.js"></script>'''
		if(document != null){
			val languages = document.langDefs
			if(languages.size > 0)
				// Do not override standard language definitions java & xml in prettify
				result = result + '''
				<script type="text/javascript">
					«FOR lang : languages»
					«IF !(lang.name.equalsIgnoreCase("java") || lang.name.equalsIgnoreCase("xml") || lang.name.equalsIgnoreCase('xtend')
						
					)»
					registerLanguage('«FOR keyword : lang.keywords SEPARATOR "|"»«keyword»«ENDFOR»', '«lang.name.toLowerCase»');
					«ENDIF»
					«ENDFOR»
				</script>
				'''
		}
		return result
	}
}