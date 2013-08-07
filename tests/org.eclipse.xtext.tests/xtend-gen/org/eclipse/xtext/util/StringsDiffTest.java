/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.util;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.util.DiffUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class StringsDiffTest {
  @Test
  public void testDiff_0() {
    this.assertDiff("foo", "foo", null);
  }
  
  @Test
  public void testDiff_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[foo]");
    _builder.newLine();
    _builder.append("vs");
    _builder.newLine();
    _builder.append("[bar]");
    _builder.newLine();
    this.assertDiff("foo", "bar", _builder);
  }
  
  @Test
  public void testDiff_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo[1]");
    _builder.newLine();
    _builder.append("vs");
    _builder.newLine();
    _builder.append("foo[bar]");
    _builder.newLine();
    this.assertDiff("foo1", "foobar", _builder);
  }
  
  @Test
  public void testDiff_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("foo[]");
    _builder.newLine();
    _builder.append("vs");
    _builder.newLine();
    _builder.append("foo[foo]");
    _builder.newLine();
    this.assertDiff("foo", "foofoo", _builder);
  }
  
  @Test
  public void testDiff_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[]foo");
    _builder.newLine();
    _builder.append("vs");
    _builder.newLine();
    _builder.append("[bar]foo");
    _builder.newLine();
    this.assertDiff("foo", "barfoo", _builder);
  }
  
  @Test
  public void testDiff_5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[2]foo");
    _builder.newLine();
    _builder.append("vs");
    _builder.newLine();
    _builder.append("[bar]foo");
    _builder.newLine();
    this.assertDiff("2foo", "barfoo", _builder);
  }
  
  @Test
  public void testDiff_6() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("...3456789foo[1]");
    _builder.newLine();
    _builder.append("vs");
    _builder.newLine();
    _builder.append("...3456789foo[bar]");
    _builder.newLine();
    this.assertDiff("0123456789foo1", "0123456789foobar", _builder);
  }
  
  @Test
  public void testDiff_7() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("...3456789foo[]");
    _builder.newLine();
    _builder.append("vs");
    _builder.newLine();
    _builder.append("...3456789foo[foo]");
    _builder.newLine();
    this.assertDiff("0123456789foo", "0123456789foofoo", _builder);
  }
  
  @Test
  public void testDiff_8() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[]foo0123456...");
    _builder.newLine();
    _builder.append("vs");
    _builder.newLine();
    _builder.append("[bar]foo0123456...");
    _builder.newLine();
    this.assertDiff("foo0123456789", "barfoo0123456789", _builder);
  }
  
  @Test
  public void testDiff_9() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[2]foo0123456...");
    _builder.newLine();
    _builder.append("vs");
    _builder.newLine();
    _builder.append("[bar]foo0123456...");
    _builder.newLine();
    this.assertDiff("2foo0123456789", "barfoo0123456789", _builder);
  }
  
  protected void assertDiff(final String one, final String two, final CharSequence expected) {
    String _string = null;
    if (expected!=null) {
      _string=expected.toString();
    }
    String _trim = null;
    if (_string!=null) {
      _trim=_string.trim();
    }
    String _diff = DiffUtil.diff(one, two);
    Assert.assertEquals(_trim, _diff);
  }
}
