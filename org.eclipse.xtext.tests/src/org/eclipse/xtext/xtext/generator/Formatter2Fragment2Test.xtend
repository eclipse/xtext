/*******************************************************************************
 * Copyright (c) 2016, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.xtext.generator.formatting.Formatter2Fragment2
import org.junit.Test

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
class Formatter2Fragment2Test extends AbstractGeneratorFragmentTests {
	
	var TestableFormatter2Fragment2 fragment = new TestableFormatter2Fragment2

	static class TestableFormatter2Fragment2 extends Formatter2Fragment2 {
		
		override toVarName(ENamedElement element, String... reservedNames) {
			super.toVarName(element, reservedNames)
		}
		
		override doGetXtendStubFile() {
			super.doGetXtendStubFile
		}
	}

	@Test def void testVarNameWithEClass() {
		"eClass".assertEquals(fragment.toVarName(EcorePackage.eINSTANCE.EClass))
	}

	@Test def void testVarNameWithMultiReference() {
		"eOperation".assertEquals(fragment.toVarName(EcorePackage.eINSTANCE.EClass_EAllOperations))
	}

	@Test def void testVarNameWithSingleReference() {
		"name".assertEquals(fragment.toVarName(EcorePackage.eINSTANCE.ENamedElement_Name))
	}

	@Test def void testVarNameConflictingWithXtendKeyword() {
		"_abstract".assertEquals(fragment.toVarName(EcorePackage.eINSTANCE.EClass_Abstract))
	}

	@Test def void testVarNameConflictingWithParam() {
		"_xxx".assertEquals(fragment.toVarName(EcoreFactory.eINSTANCE.createEAttribute=>[name="xxx"]),"xxx")
	}

	@Test def void testVarNameConflictingWithXtendKeywordAndParam() {
		"__abstract".assertEquals(fragment.toVarName(EcorePackage.eINSTANCE.EClass_Abstract, "_abstract"))
	}
	
	@Test def void testFormatMethodGeneration01() {
		fragment = TestableFormatter2Fragment2.initializeFragmentWithGrammarFromString('''
		grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
		generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
		Model:
			greetings+=Greeting*;
		Greeting:
			'Hello' name=ID '!';
		''')
		
		val actual = fragment.doGetXtendStubFile.concatenationClientToString
		val expected = '''
		package org.xtext.example.mydsl.formatting2
		
		import com.google.inject.Inject
		import org.eclipse.xtext.formatting2.AbstractFormatter2
		import org.eclipse.xtext.formatting2.IFormattableDocument
		import org.xtext.example.mydsl.myDsl.Model
		import org.xtext.example.mydsl.services.MyDslGrammarAccess
		
		class MyDslFormatter extends AbstractFormatter2 {
			
			@Inject extension MyDslGrammarAccess
		
			def dispatch void format(Model model, extension IFormattableDocument document) {
				// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
				for (greeting : model.greetings) {
					greeting.format
				}
			}
			
			// TODO: implement for 
		}
		'''
		expected.assertEquals(actual)
	}
	
	@Test def void testFormatMethodGeneration02() {
		fragment = TestableFormatter2Fragment2.initializeFragmentWithGrammarFromString('''
		grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals
		generate myDsl "http://www.xtext.org/example/mydsl/MyDsl"
		Model:
			greetings+=Greeting*
			description=Description;
		Greeting:
			'Hello' person=Person '!';
		Person:
			firstname=ID lastname=ID;
		Description:
			text=STRING;
		''')
		
		val actual = fragment.doGetXtendStubFile.concatenationClientToString
		val expected = '''
		package org.xtext.example.mydsl.formatting2
		
		import com.google.inject.Inject
		import org.eclipse.xtext.formatting2.AbstractFormatter2
		import org.eclipse.xtext.formatting2.IFormattableDocument
		import org.xtext.example.mydsl.myDsl.Greeting
		import org.xtext.example.mydsl.myDsl.Model
		import org.xtext.example.mydsl.services.MyDslGrammarAccess
		
		class MyDslFormatter extends AbstractFormatter2 {
			
			@Inject extension MyDslGrammarAccess
		
			def dispatch void format(Model model, extension IFormattableDocument document) {
				// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
				for (greeting : model.greetings) {
					greeting.format
				}
				model.description.format
			}
		
			def dispatch void format(Greeting greeting, extension IFormattableDocument document) {
				// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
				greeting.person.format
			}
			
			// TODO: implement for 
		}
		'''
		expected.assertEquals(actual)
	}
}
