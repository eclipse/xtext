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
public class Bug436564Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void test_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_03() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_04() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_05() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s2");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_06() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s2");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_07() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s() {}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_08() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s() {}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_09() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s1() {}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s2() {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_10() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s1() {}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s2() {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_11() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_12() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_13() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_14() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_15() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_16() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_17() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s2");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_18() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("String s2");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_19() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s() {}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_20() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s() {}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_21() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s1() {}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s2() {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_22() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s1() {}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("def s2() {}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_23() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("val s = new Object () {");
    _builder.newLine();
    _builder.append("  \t\t");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
  
  @Test
  public void test_24() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("val o = new Object() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("val s = new Object () {");
    _builder.newLine();
    _builder.append("  \t\t");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("override toString() {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("toString() - Override method from Object");
  }
}
