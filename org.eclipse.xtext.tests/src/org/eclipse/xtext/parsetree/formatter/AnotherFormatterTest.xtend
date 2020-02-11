/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parsetree.formatter

import com.google.inject.Key
import com.google.inject.TypeLiteral
import org.eclipse.xtext.formatting.INodeModelFormatter
import org.eclipse.xtext.parsetree.formatter.formattertestlanguage2.Root
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.tests.AbstractXtextTests
import org.junit.Test

/**
 * @author dietrich - Initial contribution and API
 */
class AnotherFormatterTest extends AbstractXtextTests {

	override void setUp() throws Exception {
		super.setUp()
		with(FormatterTestLanguage2StandaloneSetup)
	}

	@Test
	def void loadModel() {
		val parseHelper = injector.getInstance(Key.get(new TypeLiteral<ParseHelper<Root>>() {}))
		val formatter = injector.getInstance(INodeModelFormatter)

		val root = parseHelper.parse('''
			test sample {
			// just a comment
			}
		''')
		assertNotNull(root)
		val errors = root.eResource.errors
		assertTrue('''Unexpected errors: «errors.join(", ")»''', errors.isEmpty)
		var rootNode = (root.eResource as XtextResource).parseResult.rootNode

		val expected = '''
		test sample {
		
		// just a comment
		}'''.toString

		var formattedRegion = formatter.format(rootNode, rootNode.totalOffset, rootNode.totalLength)
		assertEquals(expected, formattedRegion.formattedText)

		formattedRegion = formatter.format(rootNode, rootNode.totalOffset, rootNode.totalLength)
		assertEquals(expected, formattedRegion.formattedText)
	}

}
