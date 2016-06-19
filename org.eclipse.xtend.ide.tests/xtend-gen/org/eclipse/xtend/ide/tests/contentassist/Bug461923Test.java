/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
public class Bug461923Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void test_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static <T> m(List<? extends T> list, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(list.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("filter[]");
  }
  
  @Test
  public void test_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static <T> m(List<T> list, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(list.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("filter[]");
  }
  
  @Test
  public void test_03() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static <T> m(List<? super T> list, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(list.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("filter[]");
  }
  
  @Test
  public void test_04() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static m(List<? extends String> list, String value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(list.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("filter[]");
  }
  
  @Test
  public void test_05() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static m(List<String> list, String value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(list.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("filter[]");
  }
  
  @Test
  public void test_06() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static m(List<? super String> list, String value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(list.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("filter[]");
  }
  
  @Test
  public void test_07() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static <T> m(T[] arr, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(arr.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("filter[]");
  }
  
  @Test
  public void test_08() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static <T extends Number> m(T[] arr, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(arr.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static sum(List<? extends Number> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("sum");
  }
  
  @Test
  public void test_09() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static <T extends Number> m(List<? extends T> list, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(list.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static sum(List<? extends Number> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("sum");
  }
  
  @Test
  public void test_10() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static <T extends CharSequence> m(CharSequence[] arr, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(arr.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static sum(List<? extends Number> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertNoProposalAtCursor("sum");
  }
  
  @Test
  public void test_11() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static <T extends CharSequence> m(List<? extends T> list, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(list.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def static sum(List<? extends Number> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertNoProposalAtCursor("sum");
  }
  
  @Test
  public void test_12() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <T extends Number> m(T[] arr, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(arr.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def sum(List<? extends Number> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("sum");
  }
  
  @Test
  public void test_13() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <T extends Number> m(List<? extends T> list, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(list.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def sum(List<? extends Number> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertProposalAtCursor("sum");
  }
  
  @Test
  public void test_14() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <T extends CharSequence> m(CharSequence[] arr, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(arr.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def sum(List<? extends Number> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertNoProposalAtCursor("sum");
  }
  
  @Test
  public void test_15() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import com.google.common.collect.ImmutableList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def <T extends CharSequence> m(List<? extends T> list, T value) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ImmutableList.builder.addAll(list.<|>filter[it != value]).build");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def sum(List<? extends Number> list) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("null");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
    _append.assertNoProposalAtCursor("sum");
  }
}
