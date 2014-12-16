/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
    int _length = hyperlinks.length;
    Assert.assertEquals(1, _length);
    IHyperlink _head = IterableExtensions.<IHyperlink>head(((Iterable<IHyperlink>)Conversions.doWrapArray(hyperlinks)));
    String _hyperlinkText = _head.getHyperlinkText();
    Assert.assertEquals("String", _hyperlinkText);
  }
}
