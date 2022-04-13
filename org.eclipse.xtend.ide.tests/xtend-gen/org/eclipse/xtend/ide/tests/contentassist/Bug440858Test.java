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
import org.eclipse.xtext.util.Strings;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug440858Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void test_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class MyInner {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("toSt<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor(Strings.toPlatformLineSeparator("\n\t\toverride toString() {\n\t\t\tsuper.toString()\n\t\t}\n\t\t"));
  }

  @Test
  public void test_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("annotation MyTest {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("static class MyInner {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<|>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor(Strings.toPlatformLineSeparator("\n\t\toverride toString() {\n\t\t\tsuper.toString()\n\t\t}\n\t\t"));
  }
}
