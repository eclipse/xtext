/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.RenameCapabilities;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.WorkspaceEditCapabilities;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class RenameTest2 extends AbstractLanguageServerTest {
  public RenameTest2() {
    super("fileawaretestlanguage");
  }
  
  @Test
  public void testRenameSelfRef() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("element Foo {");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("ref Foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final String file = this.writeFile("foo/Foo.fileawaretestlanguage", model);
      this.initialize();
      final TextDocumentIdentifier identifier = new TextDocumentIdentifier(file);
      final Position position = new Position(2, 9);
      TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams(identifier, position);
      final Range range = this.languageServer.prepareRename(_textDocumentPositionParams).get().getLeft();
      this.assertEquals("Foo", new Document(Integer.valueOf(0), model).getSubstring(range));
      final RenameParams params = new RenameParams(identifier, position, "Bar");
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("changes :");
      _builder_1.newLine();
      _builder_1.append("documentChanges : ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Foo.fileawaretestlanguage <1> : Bar [[2, 8] .. [2, 11]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Bar [[3, 5] .. [3, 8]]");
      _builder_1.newLine();
      this.assertEquals(_builder_1.toString(), this.toExpectation(workspaceEdit));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRenameContainer() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.newLine();
      _builder.append("element Foo {");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("element Bar {");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("}");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("ref foo.Foo.Bar");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("ref Foo.Bar");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("ref Bar");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      final String file = this.writeFile("foo/Foo.fileawaretestlanguage", model);
      this.initialize();
      final TextDocumentIdentifier identifier = new TextDocumentIdentifier(file);
      final Position position = new Position(2, 9);
      TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams(identifier, position);
      final Range range = this.languageServer.prepareRename(_textDocumentPositionParams).get().getLeft();
      this.assertEquals("Foo", new Document(Integer.valueOf(0), model).getSubstring(range));
      final RenameParams params = new RenameParams(identifier, position, "Baz");
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("changes :");
      _builder_1.newLine();
      _builder_1.append("documentChanges : ");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Foo.fileawaretestlanguage <1> : Baz [[2, 8] .. [2, 11]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Bar [[5, 5] .. [5, 16]]");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("Bar [[6, 5] .. [6, 12]]");
      _builder_1.newLine();
      this.assertEquals(_builder_1.toString(), this.toExpectation(workspaceEdit));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected InitializeResult initialize() {
    final Procedure1<InitializeParams> _function = (InitializeParams params) -> {
      ClientCapabilities _clientCapabilities = new ClientCapabilities();
      final Procedure1<ClientCapabilities> _function_1 = (ClientCapabilities it) -> {
        WorkspaceClientCapabilities _workspaceClientCapabilities = new WorkspaceClientCapabilities();
        final Procedure1<WorkspaceClientCapabilities> _function_2 = (WorkspaceClientCapabilities it_1) -> {
          WorkspaceEditCapabilities _workspaceEditCapabilities = new WorkspaceEditCapabilities();
          final Procedure1<WorkspaceEditCapabilities> _function_3 = (WorkspaceEditCapabilities it_2) -> {
            it_2.setDocumentChanges(Boolean.valueOf(true));
          };
          WorkspaceEditCapabilities _doubleArrow = ObjectExtensions.<WorkspaceEditCapabilities>operator_doubleArrow(_workspaceEditCapabilities, _function_3);
          it_1.setWorkspaceEdit(_doubleArrow);
        };
        WorkspaceClientCapabilities _doubleArrow = ObjectExtensions.<WorkspaceClientCapabilities>operator_doubleArrow(_workspaceClientCapabilities, _function_2);
        it.setWorkspace(_doubleArrow);
        TextDocumentClientCapabilities _textDocumentClientCapabilities = new TextDocumentClientCapabilities();
        final Procedure1<TextDocumentClientCapabilities> _function_3 = (TextDocumentClientCapabilities it_1) -> {
          RenameCapabilities _renameCapabilities = new RenameCapabilities();
          final Procedure1<RenameCapabilities> _function_4 = (RenameCapabilities it_2) -> {
            it_2.setPrepareSupport(Boolean.valueOf(true));
          };
          RenameCapabilities _doubleArrow_1 = ObjectExtensions.<RenameCapabilities>operator_doubleArrow(_renameCapabilities, _function_4);
          it_1.setRename(_doubleArrow_1);
        };
        TextDocumentClientCapabilities _doubleArrow_1 = ObjectExtensions.<TextDocumentClientCapabilities>operator_doubleArrow(_textDocumentClientCapabilities, _function_3);
        it.setTextDocument(_doubleArrow_1);
      };
      ClientCapabilities _doubleArrow = ObjectExtensions.<ClientCapabilities>operator_doubleArrow(_clientCapabilities, _function_1);
      params.setCapabilities(_doubleArrow);
    };
    return super.initialize(_function);
  }
}
