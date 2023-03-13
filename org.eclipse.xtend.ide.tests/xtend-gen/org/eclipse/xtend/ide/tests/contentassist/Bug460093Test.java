/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * This test class is disabled due to https://bugs.eclipse.org/bugs/show_bug.cgi?id=463547
 * ({@link AbstractXtendUITestCase#setJavaVersion(JavaVersion)} uses {@link org.junit.Assume})
 * 
 * @author Miro Spoenemann - Initial contribution and API
 */
@Ignore
@SuppressWarnings("all")
public class Bug460093Test extends AbstractXtendContentAssistBugTest {
  @Before
  public void prepareJavaVersion() {
    try {
      this.setJavaVersion(JavaVersion.JAVA8);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMethodOverrides1() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("interface I extends List<String> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("str");
      ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).assertText("\n\toverride stream() {\n\t\tList.super.stream()\n\t}").applyProposal();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import java.util.List");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("interface I extends List<String> {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override stream() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("List.super.stream()");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMethodOverrides2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.Comparator");
      _builder.newLine();
      _builder.newLine();
      _builder.append("interface I extends Comparator<String> {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("r");
      ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).assertText("\n\toverride reversed() {\n\t\tComparator.super.reversed()\n\t}").applyProposal();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import java.util.Comparator");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("interface I extends Comparator<String> {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override reversed() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("Comparator.super.reversed()");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
