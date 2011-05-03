package org.eclipse.xtext.generator.serializer

import org.eclipse.xtext.Grammar

class SemanticSequencer extends GeneratedFile {
	
	@Inject AbstractSemanticSequencer
	
	override String getQualifiedName(Grammar grammar) {
		grammar.getName("", "SemanticSequencer");		
	}
	
	override String getFileContents() { '''
		package «packageName»;
		
		public class «simpleName» extends «abstractSemanticSequencer.simpleName» {
		}
		'''.toString
	}
	
}