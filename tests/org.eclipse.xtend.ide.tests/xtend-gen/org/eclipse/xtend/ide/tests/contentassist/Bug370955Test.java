/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend.ide.tests.contentassist.AbstractXtendContentAssistBugTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug370955Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void test_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method(CharSequence c) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("c.toString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    int _length = "toString".length();
    _append.assertTextAtCursorPosition("toString", _length, 
      "!=", "!==", "+", "->", "<", "<=", "<=>", "==", "===", "=>", ">", ">=", "?:", 
      "toString");
  }
  
  @Test
  public void test_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method(CharSequence c) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("method(c.toString)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    int _length = "toString".length();
    _append.assertTextAtCursorPosition("toString", _length, 
      "!=", "!==", "+", "->", "<", "<=", "<=>", "==", "===", "=>", ">", ">=", "?:", 
      "toString");
  }
  
  @Test
  public void test_03() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method(CharSequence c) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (true)");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("method(c.toString)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    int _length = "toString".length();
    _append.assertTextAtCursorPosition("toString", _length, 
      "!=", "!==", "+", "->", "<", "<=", "<=>", "==", "===", "=>", ">", ">=", "?:", 
      "toString");
  }
  
  @Test
  public void test_04() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void method(CharSequence c) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (true) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("method(c.toString)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    int _length = "toString".length();
    _append.assertTextAtCursorPosition("toString", _length, 
      "!=", "!==", "+", "->", "<", "<=", "<=>", "==", "===", "=>", ">", ">=", "?:", 
      "toString");
  }
}
