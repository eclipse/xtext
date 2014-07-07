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
public class Bug439019Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void test_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@A(NA<|>)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("E[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("enum E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("NAME");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("NAME");
  }
  
  @Test
  public void test_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@A(NAME, NA<|>)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("E[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("enum E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("NAME");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("NAME");
  }
  
  @Test
  public void test_03() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@A(#[NA<|>])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s3");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("E[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("enum E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("NAME");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("NAME");
  }
  
  @Test
  public void test_04() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@A(value=NA<|>)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s4");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@A(value=#[NAME])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s5");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("E[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("enum E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("NAME");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("NAME");
  }
  
  @Test
  public void test_05() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@A(value=#[NAME, NA<|>])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String s5");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("annotation A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("E[] value");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("enum E {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("NAME");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("NAME");
  }
}
