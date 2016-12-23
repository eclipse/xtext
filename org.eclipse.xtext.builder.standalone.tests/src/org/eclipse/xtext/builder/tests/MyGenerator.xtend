package org.eclipse.xtext.builder.tests

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.builder.tests.builderTestLanguage.Element
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGenerator

class MyGenerator implements IGenerator {
	
	override void doGenerate(Resource input, IFileSystemAccess fsa) {
		for (ele : input.allContents.toIterable.filter(Element)) {
			if (fsa instanceof IFileSystemAccess2) {
				if (fsa.isFile('''«ele.getName()».txt''')) {
					fsa.readTextFile('''«ele.getName()».txt''')
				}
			}
			fsa.generateFile('''«ele.getName()».txt''', '''object «ele.getName()»''')
		}
	}

}
