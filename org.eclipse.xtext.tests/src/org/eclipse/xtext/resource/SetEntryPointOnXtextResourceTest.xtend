/** 
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io/) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource

import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.util.StringInputStream
import org.junit.Test

/** 
 * @author Moritz Eysholdt - Initial contribution and API
 */
class SetEntryPointOnXtextResourceTest extends AbstractXtextTests {

	@Test def void test1() {
		with(ReferenceGrammarTestLanguageStandaloneSetup)
		val model = "kind (Hugo 13)"

		val kindRule = get(ReferenceGrammarTestLanguageGrammarAccess).kindRule
		val resource = createResource()

		// test 1: parse and assume there are no errors
		resource.entryPoint = kindRule
		resource.load(new StringInputStream(model), emptyMap)
		assertTrue(resource.errors.isEmpty)
		assertEquals(kindRule, NodeModelUtils.getEntryParserRule(resource.parseResult.rootNode))

		// test 2: update and assume node model does not change
		val originalNodeModel = NodeModelUtils.compactDump(resource.parseResult.rootNode, false)
		resource.update(0, model.length, " " + model + " ")
		val reparsedNodeModel = NodeModelUtils.compactDump(resource.parseResult.rootNode, false)
		assertEquals(originalNodeModel, reparsedNodeModel)

		// test 3: change parser rule
		val erwachsenerRule = get(ReferenceGrammarTestLanguageGrammarAccess).erwachsenerRule
		resource.entryPoint = erwachsenerRule
		resource.update(0, model.length, "erwachsener (Peter 30)")
		assertEquals(erwachsenerRule, NodeModelUtils.getEntryParserRule(resource.parseResult.rootNode))
	}

	def private createResource() {
		get(IResourceFactory).createResource(URI.createURI("dummy." + currentFileExtension)) as XtextResource
	}
}
