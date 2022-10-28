/**
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
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
public class Bug435184Test extends AbstractXtendContentAssistBugTest {
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
    _builder.append("      ");
    _builder.append("val bytes = new ByteArrayInputStream(\"\".bytes)");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("bytes.rea|");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final ContentAssistProcessorTestBuilder b = _newBuilder.append(_builder.toString());
    b.assertTextAtCursorPosition("|", "read", "read()", "read()", "readAllBytes", "readNBytes()", "readNBytes()");
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
    _builder.append("      ");
    _builder.append("val bytes = new ByteArrayInputStream(\"\".bytes)");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("byte|s.toString");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertTextAtCursorPosition("|", "bytes");
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
    _builder.append("def static void main(String[] args) {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("val in = new InputStream {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("val bytes = new ByteArrayInputStream(\"\".bytes)");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("override read() throws IOException {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("ar|gs.toString");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _newBuilder.append(_builder.toString()).assertTextAtCursorPosition("|", "args");
  }
}
