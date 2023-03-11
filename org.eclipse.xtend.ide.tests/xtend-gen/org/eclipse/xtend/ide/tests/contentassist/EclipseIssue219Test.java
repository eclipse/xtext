/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class EclipseIssue219Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void testIssue219() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test");
      _builder.newLine();
      _builder.append("class Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).applyProposal("def - public method");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package test");
      _builder_1.newLine();
      _builder_1.append("class Test {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("def name(params) {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
