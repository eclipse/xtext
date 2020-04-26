/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.hyperlinking;

import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XbaseHyperlinkingTests extends AbstractHyperlinkingTest {
	@Test
	public void testBug_454791() throws Exception {
		IHyperlink[] hyperlinks = getHyperLinks("{ val Str|ing value = \'foo\' }");
		Assert.assertEquals(1, hyperlinks.length);
		Assert.assertEquals("String", hyperlinks[0].getHyperlinkText());
	}
}
