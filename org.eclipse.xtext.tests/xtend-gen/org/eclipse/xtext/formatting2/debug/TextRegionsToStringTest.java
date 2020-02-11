/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.debug;

import org.eclipse.xtext.formatting2.debug.TextRegionsToString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Florian Stolte - Initial contribution and API
 */
@SuppressWarnings("all")
public class TextRegionsToStringTest {
  private TextRegionsToString textRegionsToString;
  
  @Before
  public void init() {
    TextRegionsToString _textRegionsToString = new TextRegionsToString();
    this.textRegionsToString = _textRegionsToString;
    this.textRegionsToString.setIgnoreCarriageReturnInQuotes(true);
  }
  
  @Test
  public void testQuote() {
    Assert.assertEquals("\"import some.thing\"", this.textRegionsToString.quote("import some.thing", 30));
    Assert.assertEquals("\"import some.thing\"", this.textRegionsToString.quote("import some.thing", 17));
    Assert.assertEquals("\"import ...\"", this.textRegionsToString.quote("import some.thing", 10));
    Assert.assertEquals("\"import some.t...\"", this.textRegionsToString.quote("import some.thing", 16));
    Assert.assertEquals("\"\\nimport some.thing\\n\"", this.textRegionsToString.quote("\r\nimport some.thing\r\n", 30));
    Assert.assertEquals("\"\\nimport some.thing\\n\"", this.textRegionsToString.quote("\r\nimport some.thing\r\n", 19));
    Assert.assertEquals("\"\\nimport...\"", this.textRegionsToString.quote("\r\nimport some.thing\r\n", 10));
    Assert.assertEquals("\"\\nimport some.th...\"", this.textRegionsToString.quote("\r\nimport some.thing\r\n", 18));
    this.textRegionsToString.setIgnoreCarriageReturnInQuotes(false);
    Assert.assertEquals("\"\\r\\nimport some.thing\\r\\n\"", this.textRegionsToString.quote("\r\nimport some.thing\r\n", 30));
  }
}
