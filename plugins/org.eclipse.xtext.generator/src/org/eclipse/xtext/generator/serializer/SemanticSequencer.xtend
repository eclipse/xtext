package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject
import org.eclipse.xtext.Grammar

class SemanticSequencer extends GeneratedFile {
	
	@Inject AbstractSemanticSequencer sequencer
	
	override String getQualifiedName(Grammar grammar) {
		grammar.getName("", "SemanticSequencer");		
	}
	
	override CharSequence getFileContents() '''
		package «packageName»;
		
		public class «simpleName» extends «sequencer.simpleName» {
		}
	'''
	
}