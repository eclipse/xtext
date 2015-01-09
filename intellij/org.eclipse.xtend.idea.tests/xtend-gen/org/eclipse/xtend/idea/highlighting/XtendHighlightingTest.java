/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.highlighting;

import org.eclipse.xtend.idea.LightXtendTest;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class XtendHighlightingTest extends LightXtendTest {
  public void testKeyWord() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public");
    this.configureByText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0-6:[java.awt.Color[r=0,g=0,b=128],null,1,BOXED,null,null]");
    _builder_1.newLine();
    this.assertHighlights(_builder_1.toString());
  }
  
  public void testStringLiteral() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"Foo\"");
    this.configureByText(_builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("0-5:[java.awt.Color[r=0,g=128,b=0],null,1,BOXED,null,null]");
    _builder_1.newLine();
    this.assertHighlights(_builder_1.toString());
  }
  
  public void testNumberLiteral() {
    this.configureByText("5");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0-1:[java.awt.Color[r=0,g=0,b=255],null,0,BOXED,null,null]");
    _builder.newLine();
    this.assertHighlights(_builder.toString());
  }
  
  public void testComment() {
    this.configureByText("//comment");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0-9:[java.awt.Color[r=128,g=128,b=128],null,2,BOXED,null,null]");
    _builder.newLine();
    this.assertHighlights(_builder.toString());
  }
}
