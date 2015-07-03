package org.eclipse.xtext.index

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.index.indexTestLanguage.Entity

class IndexTestLanguageGenerator implements IGenerator2 {
	
	override beforeGenerate(Resource input, IFileSystemAccess2 fsa) {
	}
	
	override doGenerate(Resource input, IFileSystemAccess2 fsa) {
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
	
	override afterGenerate(Resource input, IFileSystemAccess2 fsa) {
	}
	
}
