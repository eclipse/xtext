/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.tests

import java.util.List
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Jan Koehnlein - copied and adapted from Xtend
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class ContentAssistTest extends AbstractContentAssistTest {

	// cursor position marker
	val c = '''<|>'''

	@Test def void testImportCompletion() throws Exception {
		newBuilder.append('import java.util.Da').assertText('java.util.Date')
	}

	@Test def void testImportCompletion_1() throws Exception {
		newBuilder.append('import LinkedHashSet').assertText('java.util.LinkedHashSet')
	}

	@Test def void testTypeCompletion() throws Exception {
		newBuilder.append('entity Foo { bar: LinkedHashSet').assertText('java.util.LinkedHashSet')
	}

	@Test def void testEntityTemplateProposal() throws Exception {
		newBuilder.applyProposal("Entity - template for an Entity").expectContent('''
		entity name {
			
		}''')
	}

	@Test def void testPackageTemplateProposal() throws Exception {
		newBuilder.applyProposal("Package - template for a Package").expectContent('''
		package name {
			
		}''')
	}

	@Test def testPropertyTemplateProposal() throws Exception {
		'''
			entity E {
				«c»
			}
		'''.testContentAssistant(#[
			'Operation - template for an Operation',
			'Property - template for a Property',
			'op'
		], 'Property - template for a Property', '''
			entity E {
				propertyName : typeName
			}
		''')
	}

	@Test def testOperationTemplateProposal() throws Exception {
		'''
			entity E {
				«c»
			}
		'''.testContentAssistant(#[
			'Operation - template for an Operation',
			'Property - template for a Property',
			'op'
		], 'Operation - template for an Operation', '''
			entity E {
				op name (paramType1 paramName1) : returnType {
					
				}
			}
		''')
	}

	private def void testContentAssistant(CharSequence text, List<String> expectedProposals, String proposalToApply, String expectedContent) throws Exception {

		val cursorPosition = text.toString.indexOf(c)
		val content = text.toString.replace(c, "")

		newBuilder.append(content).
		assertTextAtCursorPosition(cursorPosition, expectedProposals).
		applyProposal(cursorPosition, proposalToApply).
		expectContent(expectedContent)
	}
}
