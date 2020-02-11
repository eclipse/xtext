/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.editor.contentassist

import com.google.inject.Inject
import org.eclipse.xtext.ide.editor.contentassist.antlr.ContentAssistContextFactory
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(TestLanguageIdeInjectorProvider)
class ContentAssistContextFactoryTest {

	@Inject extension ContentAssistContextTestHelper
	@Inject ContentAssistContextFactory factory
	@Inject TestLanguageGrammarAccess grammar

	@Test def void testSimple1() {
		document = '''
			type Foo <|>{
				int bar
			}
		'''
		'''
			context0 {
				Keyword: TypeDeclaration:'extends'
				Keyword: TypeDeclaration:'{'
			}
		'''.toString.assertEquals(factory.firstSetGrammarElementsToString)
	}

	@Test def void testSimple2() {
		document = '''
			type Foo {
				<|>int bar
			}
		'''
		'''
			context0 {
				Assignment: TypeDeclaration:members+= *
				RuleCall: TypeDeclaration:members+=Member
				RuleCall: Member:Property
				Assignment: Property:type= 
				RuleCall: Property:type=Type
				RuleCall: Type:TypeReference
				Assignment: TypeReference:typeRef= 
				RuleCall: Type:PrimitiveType
				Assignment: PrimitiveType:name= 
				Keyword: PrimitiveType:name='string'
				Keyword: PrimitiveType:name='int'
				Keyword: PrimitiveType:name='boolean'
				Keyword: PrimitiveType:name='void'
				RuleCall: Member:Operation
				Keyword: Operation:'op'
				Keyword: TypeDeclaration:'}'
			}
		'''.toString.assertEquals(factory.firstSetGrammarElementsToString)
	}

	@Test def void testBeginning() {
		document = '''
			<|>type Foo {
				int bar
			}
		'''
		'''
			context0 {
				Assignment: Model:elements+= *
				RuleCall: Model:elements+=AbstractElement
				RuleCall: AbstractElement:PackageDeclaration
				Keyword: PackageDeclaration:'package'
				RuleCall: AbstractElement:TypeDeclaration
				Keyword: TypeDeclaration:'type'
				RuleCall: <AbstractElement not contained in AbstractRule!>:Model
			}
		'''.toString.assertEquals(factory.firstSetGrammarElementsToString)
	}

	@Test def void testCustomEntryPoint() {
		entryPoint = grammar.propertyRule
		document = '''
			int <|>bar
		'''
		'''
			context0 {
				Assignment: Type:arrayDiemensions+= 
				Keyword: Type:arrayDiemensions+='['
				Assignment: Property:name= 
				RuleCall: Property:name=ID
			}
		'''.toString.assertEquals(factory.firstSetGrammarElementsToString)
	}

	@Test def void testCustomEntryPointBeginning() {
		entryPoint = grammar.propertyRule
		document = '''
			<|>int bar
		'''
		'''
			context0 {
				Assignment: Property:type= 
				RuleCall: Property:type=Type
				RuleCall: Type:TypeReference
				Assignment: TypeReference:typeRef= 
				RuleCall: Type:PrimitiveType
				Assignment: PrimitiveType:name= 
				Keyword: PrimitiveType:name='string'
				Keyword: PrimitiveType:name='int'
				Keyword: PrimitiveType:name='boolean'
				Keyword: PrimitiveType:name='void'
				RuleCall: <AbstractElement not contained in AbstractRule!>:Type
			}
		'''.toString.assertEquals(factory.firstSetGrammarElementsToString)
	}

}
