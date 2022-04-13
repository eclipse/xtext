/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.editor;

import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractEditorDoubleClickTextSelectionTest;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XtendIDEInjectorProvider.class)
@SuppressWarnings("all")
public class XtendEditorDoubleClickTextSelectionTest extends AbstractEditorDoubleClickTextSelectionTest {
  @Test
  public void selection_in_javadoc_001() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @par|am s");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @return");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@param");
    this.assertSelectedTextAfterDoubleClicking(_builder, _builder_1.toString());
  }

  @Test
  public void selection_in_javadoc_002() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @param s");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @ret|urn");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def m(String s) {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@return");
    this.assertSelectedTextAfterDoubleClicking(_builder, _builder_1.toString());
  }

  @Test
  public void selection_in_rich_string_001() {
    final String tripleQuotes = "\'\'\'";
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val a = ");
    _builder.append(tripleQuotes, "\t");
    _builder.append("te|xt");
    _builder.append(tripleQuotes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("text");
    this.assertSelectedTextAfterDoubleClicking(_builder, _builder_1.toString());
  }
}
