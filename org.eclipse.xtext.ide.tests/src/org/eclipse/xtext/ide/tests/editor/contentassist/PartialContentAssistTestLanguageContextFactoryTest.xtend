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
import org.eclipse.xtext.ide.editor.contentassist.antlr.PartialContentAssistContextFactory
import org.eclipse.xtext.ide.tests.testlanguage.PartialContentAssistTestLanguageIdeInjectorProvider
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialContentAssistTestLanguageGrammarAccess
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.junit.Assert.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(PartialContentAssistTestLanguageIdeInjectorProvider)
class PartialContentAssistTestLanguageContextFactoryTest {

	@Inject extension ContentAssistContextTestHelper
	@Inject ContentAssistContextFactory factory
	@Inject PartialContentAssistTestLanguageGrammarAccess grammar

	@Test def void testConfig() {
		assertTrue(factory instanceof PartialContentAssistContextFactory)
	}

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
				Assignment: TypeDeclaration:properties+= *
				RuleCall: TypeDeclaration:properties+=Property
				Assignment: Property:type= 
				Keyword: Property:type='int'
				Keyword: Property:type='bool'
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
				Keyword: TypeDeclaration:'type'
				RuleCall: <AbstractElement not contained in AbstractRule!>:TypeDeclaration
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
				Keyword: Property:type='int'
				Keyword: Property:type='bool'
				RuleCall: <AbstractElement not contained in AbstractRule!>:Property
			}
		'''.toString.assertEquals(factory.firstSetGrammarElementsToString)
	}

}
