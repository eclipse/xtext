package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject

class SyntacticSequencer extends GeneratedFile {
	
	@Inject SerializerGenFileNames names
	
	override getFileContents(SerializerGenFileNames$GenFileName filename) '''
		package «filename.packageName»;
		
		public class «filename.simpleName» extends «names.abstractSyntacticSequencer.simpleName» {
		}
	'''

}