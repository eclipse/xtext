/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.generator;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class EMFGeneratorFragment2Test {
  @Test
  public void testTrimMultiLineString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*foo*/");
    _builder.newLine();
    this.assertTrim("foo", _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("/* ");
    _builder_1.newLine();
    _builder_1.append(" ");
    _builder_1.append("* foo*/");
    _builder_1.newLine();
    this.assertTrim("foo", _builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("/* ");
    _builder_2.newLine();
    _builder_2.append(" ");
    _builder_2.append("* ");
    _builder_2.newLine();
    _builder_2.append(" ");
    _builder_2.append("* foo");
    _builder_2.newLine();
    _builder_2.append(" ");
    _builder_2.append("*/");
    _builder_2.newLine();
    this.assertTrim("foo", _builder_2.toString());
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("multi");
    _builder_3.newLine();
    _builder_3.append("foo");
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("/* ");
    _builder_4.newLine();
    _builder_4.append(" ");
    _builder_4.append("* multi");
    _builder_4.newLine();
    _builder_4.append(" ");
    _builder_4.append("* foo");
    _builder_4.newLine();
    _builder_4.append(" ");
    _builder_4.append("* ");
    _builder_4.newLine();
    _builder_4.append(" ");
    _builder_4.append("*/");
    _builder_4.newLine();
    this.assertTrim(_builder_3.toString(), _builder_4.toString());
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("/* foo */");
    _builder_5.newLine();
    this.assertTrim("foo", _builder_5.toString());
    this.assertTrim("foo", "foo");
  }
  
  public void assertTrim(final String expected, final String original) {
    String _trimMultiLineComment = EMFGeneratorFragment2.trimMultiLineComment(original);
    Assert.assertEquals(expected, _trimMultiLineComment);
  }
}
