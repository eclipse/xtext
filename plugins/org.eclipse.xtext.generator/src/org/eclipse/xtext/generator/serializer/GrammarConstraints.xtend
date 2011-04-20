package org.eclipse.xtext.generator.serializer

import org.eclipse.xtext.Grammar
import static extension org.eclipse.xtext.generator.serializer.SemanticSequencerUtil.*

class GrammarConstraints extends GeneratedFile {
	
	@Inject Grammar
	
	override getFileExtension() {
		"xtext"
	}
	 	
	override getQualifiedName() {
		getName("", "GrammarConstraints")
	} 	
	
	override getFileContents() { '''
		grammar «grammar.name»«FOR ug:grammar.usedGrammars BEFORE " with " SEPARATOR ", "»«ug.name»«ENDFOR»
		
		generate model "http://«grammar.name»"
		
		
		// ******** constraint contexts ********
		«FOR gcc:grammar.grammarConstraintContexts SEPARATOR "\n"»
			«gcc.name» returns «gcc.commonType.name»:
				«FOR constraint:gcc.constraints SEPARATOR " | "»«constraint.name»«ENDFOR»;
		«ENDFOR»
		
		
		
		// ******** constraints ********
		«FOR constraint:grammar.grammarConstraints SEPARATOR "\n"»
			«constraint.name» returns «constraint.type.name»:
				«IF constraint.body == null»
					{«constraint.type.name»};
				«ELSE»
					«constraint.body»;
				«ENDIF»
		«ENDFOR»
	'''.toString }
}
