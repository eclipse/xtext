/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend.ide.tests.contentassist.AbstractXtendContentAssistBugTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
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
      _builder.append("t");
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _assertText = _append.assertText("\n\toverride toString() {\n\t\tsuper.toString()\n\t}");
      ContentAssistProcessorTestBuilder _applyProposal = _assertText.applyProposal();
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
      _builder.append("t");
      ContentAssistProcessorTestBuilder _append = _newBuilder.append(_builder.toString());
      ContentAssistProcessorTestBuilder _assertText = _append.assertText("\n\toverride toString() {\n\t\tsuper.toString()\n\t}");
      ContentAssistProcessorTestBuilder _appendAndApplyProposal = _assertText.appendAndApplyProposal("oStr");
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
