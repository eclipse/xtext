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
public class Bug435043Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void test_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val in = new InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val in = new InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val in = new InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val in = new InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val in = new InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes2 = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val in = new InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes2 = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val in = new InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val in = new InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = \"FooBar\".bytes.iterator");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = new Object() {}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bytes = new Object() {}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("new() {}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("import java.io.*");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class C2 extends InputStream {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("new() {}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("toS<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if(bytes.hasNext) bytes.next else -1");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
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
    _builder.append("def static m() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("new Object {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val foo = \"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override toString() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("\"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bar = \"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("equals(Object) - Override method from Object");
  }
  
  @Test
  public void test_24() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static m() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("new Object {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val foo = \"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override toString() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("\"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>\t\t\t");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bar = \"\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("equals(Object) - Override method from Object");
  }
  
  @Test
  public void test_25() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static m() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("new Object {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val foo = \"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override toString() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("\"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bar = \"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("equals(Object) - Override method from Object");
  }
  
  @Test
  public void test_26() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("def static m() {");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("val x = \'\'");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("val y = new Object() {");
    _builder.newLine();
    _builder.append("  \t\t");
    _builder.append("val z = <|>");
    _builder.newLine();
    _builder.append("  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("x");
  }
  
  @Test
  public void test_27() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class D {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val foo = \"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override toString() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("\"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bar = \"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("equals(Object) - Override method from Object");
  }
  
  @Test
  public void test_28() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class D {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val foo = \"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override toString() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("\"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>\t\t\t");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bar = \"\"");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("equals(Object) - Override method from Object");
  }
  
  @Test
  public void test_29() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("static class D {");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val foo = \"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("override toString() {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("\"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("val bar = \"\"");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalDisplayedAtCursor("equals(Object) - Override method from Object");
  }
}
