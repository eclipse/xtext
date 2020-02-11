/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.DocumentSymbolConfiguraiton;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DocumentSymbolTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testDocumentSymbol_01() {
    final Procedure1<DocumentSymbolConfiguraiton> _function = (DocumentSymbolConfiguraiton it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int bar");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("type Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("symbol \"Foo\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("kind: 7");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("location: MyModel.testlang [[0, 5] .. [0, 8]]");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("symbol \"Foo.bar\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("kind: 7");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("location: MyModel.testlang [[1, 5] .. [1, 8]]");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("container: \"Foo\"");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("symbol \"Foo.bar.int\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("kind: 7");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("location: MyModel.testlang [[1, 1] .. [1, 4]]");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("container: \"Foo.bar\"");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("symbol \"Bar\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("kind: 7");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("location: MyModel.testlang [[3, 5] .. [3, 8]]");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("symbol \"Bar.foo\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("kind: 7");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("location: MyModel.testlang [[4, 5] .. [4, 8]]");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("container: \"Bar\"");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setExpectedSymbols(_builder_1.toString());
    };
    this.testDocumentSymbol(_function);
  }
}
