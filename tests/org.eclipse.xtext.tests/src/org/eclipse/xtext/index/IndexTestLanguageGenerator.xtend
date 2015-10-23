package org.eclipse.xtext.index

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.index.indexTestLanguage.Entity
import org.eclipse.xtext.util.CancelIndicator

class IndexTestLanguageGenerator implements IGenerator2 {
	
	override beforeGenerate(Resource input, IFileSystemAccess2 fsa, CancelIndicator cancelIndicator) {
	}
	
	override doGenerate(Resource input, IFileSystemAccess2 fsa, CancelIndicator cancelIndicator) {
		val iter = input.allContents
		while (iter.hasNext) {
			switch e : iter.next {
				Entity :
					fsa.generateFile(e.name+".txt", '''
						Hello «e.name»!
					''')
			}
		}
	}
	
	override afterGenerate(Resource input, IFileSystemAccess2 fsa, CancelIndicator cancelIndicator) {
	}
	
}
