/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.hyperlinking;

import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.ui.tests.hyperlinking.AbstractHyperlinkingTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 */
@SuppressWarnings("all")
public class XbaseHyperlinkingTests extends AbstractHyperlinkingTest {
  @Test
  public void testBug_454791() throws Exception {
    final IHyperlink[] hyperlinks = this.getHyperLinks("{ val Str|ing value = \'foo\' }");
    Assert.assertEquals(1, hyperlinks.length);
    Assert.assertEquals("String", IterableExtensions.<IHyperlink>head(((Iterable<IHyperlink>)Conversions.doWrapArray(hyperlinks))).getHyperlinkText());
  }
}
