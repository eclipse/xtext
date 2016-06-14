package org.eclipse.xtext.index

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.index.indexTestLanguage.Entity

class IndexTestLanguageGenerator extends  AbstractGenerator {
	
	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
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
	
}
