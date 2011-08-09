package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import org.eclipse.xtext.Grammar

class SyntacticSequencer extends GeneratedFile {
	
	@Inject AbstractSyntacticSequencer sequencer
	
	override String getQualifiedName(Grammar grammar) {
		grammar.getName("", "SyntacticSequencer");		
	}
	
	override getFileContents() '''
		package «packageName»;
		
		public class «simpleName» extends «sequencer.simpleName» {
		}
	'''

}