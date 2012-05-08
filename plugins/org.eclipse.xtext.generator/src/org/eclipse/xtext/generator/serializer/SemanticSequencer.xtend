package org.eclipse.xtext.generator.serializer

import com.google.inject.Inject

class SemanticSequencer extends GeneratedFile {
	
	@Inject SerializerGenFileNames names
	
	override CharSequence getFileContents(SerializerGenFileNames$GenFileName filename) '''
		package «filename.packageName»;
		
		public class «filename.simpleName» extends «names.abstractSemanticSequencer.simpleName» {
		}
	'''
	
}