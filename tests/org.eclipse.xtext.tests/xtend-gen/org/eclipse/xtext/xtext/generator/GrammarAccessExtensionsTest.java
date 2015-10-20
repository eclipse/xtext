/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class GrammarAccessExtensionsTest {
  @Extension
  private GrammarAccessExtensions _grammarAccessExtensions = new GrammarAccessExtensions();
  
  @Test
  public void testToJavaIdentifier() {
    String _javaIdentifier = this._grammarAccessExtensions.toJavaIdentifier("foo Bar", true);
    Assert.assertEquals("FooBar", _javaIdentifier);
    String _javaIdentifier_1 = this._grammarAccessExtensions.toJavaIdentifier("foo;", true);
    Assert.assertEquals("Foo", _javaIdentifier_1);
    String _javaIdentifier_2 = this._grammarAccessExtensions.toJavaIdentifier("foo;", false);
    Assert.assertEquals("foo", _javaIdentifier_2);
    String _javaIdentifier_3 = this._grammarAccessExtensions.toJavaIdentifier(":", true);
    Assert.assertEquals("Colon", _javaIdentifier_3);
    String _javaIdentifier_4 = this._grammarAccessExtensions.toJavaIdentifier(":", false);
    Assert.assertEquals("Colon", _javaIdentifier_4);
    String _javaIdentifier_5 = this._grammarAccessExtensions.toJavaIdentifier(";", false);
    Assert.assertEquals("Semicolon", _javaIdentifier_5);
    String _javaIdentifier_6 = this._grammarAccessExtensions.toJavaIdentifier("@\'", false);
    Assert.assertEquals("CommercialAtApostrophe", _javaIdentifier_6);
    String _javaIdentifier_7 = this._grammarAccessExtensions.toJavaIdentifier("Grün", true);
    Assert.assertEquals("Grün", _javaIdentifier_7);
    String _javaIdentifier_8 = this._grammarAccessExtensions.toJavaIdentifier("$", true);
    Assert.assertEquals("DollarSign", _javaIdentifier_8);
    String _javaIdentifier_9 = this._grammarAccessExtensions.toJavaIdentifier("_", true);
    Assert.assertEquals("_", _javaIdentifier_9);
  }
  
  /**
   * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=298492
   */
  @Test
  public void testBug() throws Exception {
    String _javaIdentifier = this._grammarAccessExtensions.toJavaIdentifier("\u308b", true);
    Assert.assertEquals("HiraganaLetterRu", _javaIdentifier);
  }
  
  @Test
  public void testSmoke() throws Exception {
    for (int i = 0; (i < 4000); i++) {
      {
        String _valueOf = String.valueOf(((char) i));
        final String identifier = this._grammarAccessExtensions.toJavaIdentifier(_valueOf, false);
        for (int j = 0; (j < identifier.length()); j++) {
          {
            final char charAt = identifier.charAt(j);
            boolean _isValidJavaLatinIdentifier = this._grammarAccessExtensions.isValidJavaLatinIdentifier(charAt, (j == 0));
            Assert.assertTrue(((identifier + ":") + Character.valueOf(charAt)), _isValidJavaLatinIdentifier);
          }
        }
      }
    }
  }
}
