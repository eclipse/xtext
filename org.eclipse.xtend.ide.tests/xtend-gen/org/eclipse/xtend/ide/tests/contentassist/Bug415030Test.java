/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
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
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug415030Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void testMethodOverrides() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("to");
      ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).assertText("\n\toverride toString() {\n\t\tsuper.toString()\n\t}").applyProposal();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class A {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override toString() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("super.toString()");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMethodOverrides_2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("to");
      ContentAssistProcessorTestBuilder _appendAndApplyProposal = _newBuilder.append(_builder.toString()).assertText("\n\toverride toString() {\n\t\tsuper.toString()\n\t}").appendAndApplyProposal("Str");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class A {");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("override toString() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("super.toString()");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _appendAndApplyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
