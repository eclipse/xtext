/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug443025Test extends AbstractXtendContentAssistBugTest {
  @Test
  public void test_01() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import ArLi<|>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor("java.util.ArrayList");
  }

  @Test
  public void test_02() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import <|>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor("java.util.ArrayList");
  }

  @Test
  public void test_03() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import static ArLi<|>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor("java.util.ArrayList");
  }

  @Test
  public void test_04() throws Exception {
    ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import static <|>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class C {}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertProposalAtCursor("java.util.ArrayList");
  }
}
