/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.Flaky;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug440069Test extends AbstractXtendContentAssistBugTest {
  @Flaky
  @Test
  public void test_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyExtension {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String getXyzManager() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \'\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension MyExtension = new MyExtension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xyzManage<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor("xyzManager");
  }

  @Test
  public void test_AfterDef() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def <|> test() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor("String");
  }

  @Test
  public void test_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension MyExtension.*");
    _builder.newLine();
    _builder.append("class MyExtension {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static String getXyzManager() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \'\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getXyzManage<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor("xyzManager");
  }

  @Flaky
  @Test
  public void test_03() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class MyExtension {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String getXyzManager(Object o) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \'\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("extension MyExtension = new MyExtension");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("xyzManage<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor("xyzManager");
  }

  @Test
  public void test_04() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import static extension MyExtension.*");
    _builder.newLine();
    _builder.append("class MyExtension {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def static String getXyzManager(Object o) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \'\'");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("class MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def test() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getXyzManage<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor("xyzManager");
  }
}
