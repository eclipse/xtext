package org.eclipse.xtext.generator.serializer

class SemanticSequencer extends GeneratedFile {
	
	@Inject AbstractSemanticSequencer
	
	override String getQualifiedName() {
		getName("", "SemanticSequencer");		
	}
	
	override String getFileContents() { '''
		package «packageName»;
		
		public class «simpleName» extends «abstractSemanticSequencer.simpleName» {
		}
		'''.toString
	}
	
}