/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import org.eclipse.xtext.Grammar

class GrammarConstraints extends GeneratedFile {
	
	@Inject Grammar grammar
	
	@Inject extension SemanticSequencerUtil sequencerUtil
	
	override getFileContents(SerializerGenFileNames$GenFileName filename) '''
		grammar «grammar.name»«FOR ug:grammar.usedGrammars BEFORE " with " SEPARATOR ", "»«ug.name»«ENDFOR»
		
		generate model "http://«grammar.name»"
		
		
		// ******** constraint contexts ********
		«FOR gcc:grammar.grammarConstraintContexts SEPARATOR "\n"»
			«gcc.name» returns «gcc.commonType?.name»:
				«FOR constraint:gcc.constraints SEPARATOR " | "»«constraint.name»«ENDFOR»;
		«ENDFOR»
		
		
		
		// ******** constraints ********
		«FOR constraint:grammar.grammarConstraints SEPARATOR "\n"»
			«constraint.name» returns «constraint.type?.name»:
				«IF constraint.body == null»
					{«constraint.type?.name»};
				«ELSE»
					«constraint.body»;
				«ENDIF»
		«ENDFOR»
	'''
}
