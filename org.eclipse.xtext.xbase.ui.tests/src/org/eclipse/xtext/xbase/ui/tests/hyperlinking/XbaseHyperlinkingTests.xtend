/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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