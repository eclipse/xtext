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
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@Ignore("https://github.com/eclipse/xtext-xtend/issues/345")
@SuppressWarnings("all")
public class Issue242Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void test_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Test {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void m() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val ^default = 1");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(^de<|>");
    ContentAssistProcessorTestBuilder _apply = _newBuilder.append(_builder.toString()).assertProposalAtCursor("^default").apply();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("class Test {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("def void m() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("val ^default = 1");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("println(^default");
    _apply.expectContent(_builder_1.toString());
  }
}
