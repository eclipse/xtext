/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.hyperlinking

import org.junit.Test

/**
 * @author Holger Schill - Initial contribution and API
 */
class XbaseHyperlinkingTests extends AbstractHyperlinkingTest {
	@Test
	def void testBug_454791() throws Exception {
		val hyperlinks = getHyperLinks("{ val Str|ing value = 'foo' }")
		assertEquals(1, hyperlinks.length)
		assertEquals("String", hyperlinks.head.getHyperlinkText())
	}

}