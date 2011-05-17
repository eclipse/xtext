package org.eclipse.xtext.generator.serializer

import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.serializer.SemanticSequencerUtil.*
import com.google.inject.Inject

class GrammarConstraints extends GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject extension SemanticSequencerUtil sequencerUtil
	
	override getFileExtension() {
		"xtext"
	}
	 	
	override getQualifiedName(Grammar grammar) {
		grammar.getName("", "GrammarConstraints")
	} 	
	
	override getFileContents() '''
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
	'''
}
