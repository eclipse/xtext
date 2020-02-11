/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.PrimitiveType
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeDeclaration
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.TypeReference
import org.eclipse.xtext.ide.tests.testlanguage.testLanguage.Property

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class TestLanguageGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		if (fsa.getURI('').scheme == 'inmemory') {
			// Suppress the generator when building in memory, see InMemoryWorkspaceTest
			return
		}
		for (type : resource.allContents.filter(TypeDeclaration).toList) {
			fsa.generateFile(type.name+".java", '''
			public class «type.name» {
				«FOR p : type.members.filter(Property)»
					private «p.type.toJava» «p.name»;
					
					public void set«p.name.toFirstUpper»(«p.type.toJava» «p.name») {
						this.«p.name» = «p.name»;
					}
					
					public «p.type.toJava» get«p.name.toFirstUpper»() {
						return this.«p.name»;
					}
				«ENDFOR»
			}
			''')
		}
	}
	
	def dispatch String toJava(TypeReference type) {
		type.typeRef.name+type.arrayDiemensions.map['[]'].join('')
	}
	
	def dispatch String toJava(PrimitiveType type) {
		type.name+type.arrayDiemensions.map['[]'].join('')
	}
}
