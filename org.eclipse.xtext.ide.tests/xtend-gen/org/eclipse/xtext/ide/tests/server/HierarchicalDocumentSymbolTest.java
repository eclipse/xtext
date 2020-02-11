/**
 * Copyright (c) 2018 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.DocumentSymbolCapabilities;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.DocumentSymbolConfiguraiton;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class HierarchicalDocumentSymbolTest extends AbstractTestLangLanguageServerTest {
  private static final Procedure1<? super InitializeParams> INITIALIZER = ((Procedure1<InitializeParams>) (InitializeParams it) -> {
    ClientCapabilities _clientCapabilities = new ClientCapabilities();
    final Procedure1<ClientCapabilities> _function = (ClientCapabilities it_1) -> {
      TextDocumentClientCapabilities _textDocumentClientCapabilities = new TextDocumentClientCapabilities();
      final Procedure1<TextDocumentClientCapabilities> _function_1 = (TextDocumentClientCapabilities it_2) -> {
        DocumentSymbolCapabilities _documentSymbolCapabilities = new DocumentSymbolCapabilities();
        final Procedure1<DocumentSymbolCapabilities> _function_2 = (DocumentSymbolCapabilities it_3) -> {
          it_3.setHierarchicalDocumentSymbolSupport(Boolean.valueOf(true));
        };
        DocumentSymbolCapabilities _doubleArrow = ObjectExtensions.<DocumentSymbolCapabilities>operator_doubleArrow(_documentSymbolCapabilities, _function_2);
        it_2.setDocumentSymbol(_doubleArrow);
      };
      TextDocumentClientCapabilities _doubleArrow = ObjectExtensions.<TextDocumentClientCapabilities>operator_doubleArrow(_textDocumentClientCapabilities, _function_1);
      it_1.setTextDocument(_doubleArrow);
    };
    ClientCapabilities _doubleArrow = ObjectExtensions.<ClientCapabilities>operator_doubleArrow(_clientCapabilities, _function);
    it.setCapabilities(_doubleArrow);
  });
  
  @Test
  public void testDocumentSymbol_01() {
    final Procedure1<DocumentSymbolConfiguraiton> _function = (DocumentSymbolConfiguraiton it) -> {
      it.setInitializer(HierarchicalDocumentSymbolTest.INITIALIZER);
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
      _builder_1.append("    ");
      _builder_1.append("kind: 7");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("range: [[0, 0] .. [2, 1]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("selectionRange: [[0, 5] .. [0, 8]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("details: ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("deprecated: false");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("children: [");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("symbol \"Foo.bar\" {");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("kind: 7");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("range: [[1, 1] .. [1, 8]]");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("selectionRange: [[1, 5] .. [1, 8]]");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("details: ");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("deprecated: false");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("children: [");
      _builder_1.newLine();
      _builder_1.append("                ");
      _builder_1.append("symbol \"Foo.bar.int\" {");
      _builder_1.newLine();
      _builder_1.append("                    ");
      _builder_1.append("kind: 7");
      _builder_1.newLine();
      _builder_1.append("                    ");
      _builder_1.append("range: [[1, 1] .. [1, 4]]");
      _builder_1.newLine();
      _builder_1.append("                    ");
      _builder_1.append("selectionRange: [[1, 1] .. [1, 4]]");
      _builder_1.newLine();
      _builder_1.append("                    ");
      _builder_1.append("details: ");
      _builder_1.newLine();
      _builder_1.append("                    ");
      _builder_1.append("deprecated: false");
      _builder_1.newLine();
      _builder_1.append("                ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("symbol \"Bar\" {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("kind: 7");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("range: [[3, 0] .. [5, 1]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("selectionRange: [[3, 5] .. [3, 8]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("details: ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("deprecated: false");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("children: [");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("symbol \"Bar.foo\" {");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("kind: 7");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("range: [[4, 1] .. [4, 8]]");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("selectionRange: [[4, 5] .. [4, 8]]");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("details: ");
      _builder_1.newLine();
      _builder_1.append("            ");
      _builder_1.append("deprecated: false");
      _builder_1.newLine();
      _builder_1.append("        ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("]");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      it.setExpectedSymbols(_builder_1.toString());
    };
    this.testDocumentSymbol(_function);
  }
}
