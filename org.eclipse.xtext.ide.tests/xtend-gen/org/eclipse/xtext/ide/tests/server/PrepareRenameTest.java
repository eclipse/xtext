/**
 * Copyright (c) 2019 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.common.base.Throwables;
import com.google.inject.Inject;
import java.io.File;
import java.io.FileNotFoundException;
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
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class PrepareRenameTest extends AbstractTestLangLanguageServerTest {
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  @Test
  public void testRenameFqn_missing_file_null() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("missing.");
      _builder.append(this.fileExtension);
      final String uri = this._uriExtensions.toUriString(new File(_builder.toString()).toURI().normalize());
      this.initializeWithPrepareSupport();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
      Position _position = new Position(2, 5);
      final RenameParams params = new RenameParams(_textDocumentIdentifier, _position, "Does not matter");
      Assert.assertNull(this.languageServer.rename(params).get());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPrepareRenameFqn_missing_file_null() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("missing.");
      _builder.append(this.fileExtension);
      final String uri = this._uriExtensions.toUriString(new File(_builder.toString()).toURI().normalize());
      this.initializeWithPrepareSupport();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
      Position _position = new Position(2, 5);
      final TextDocumentPositionParams params = new TextDocumentPositionParams(_textDocumentIdentifier, _position);
      Assert.assertNull(this.languageServer.prepareRename(params).get());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPrepareRenameFqn_missing_file_exception() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("missing.");
    _builder.append(this.fileExtension);
    final String uri = this._uriExtensions.toUriString(new File(_builder.toString()).toURI().normalize());
    this.initialize();
    TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
    Position _position = new Position(2, 5);
    final TextDocumentPositionParams params = new TextDocumentPositionParams(_textDocumentIdentifier, _position);
    try {
      Assert.assertNull(this.languageServer.prepareRename(params).get());
      Assert.fail("Expected an error.");
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        Throwable _rootCause = Throwables.getRootCause(e);
        Assert.assertTrue((_rootCause instanceof FileNotFoundException));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testRenameFqn_invalid_error() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo.bar {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("type A {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("foo.bar.MyType bar");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("type MyType { }");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String uri = this.writeFile("my-type-invalid.testlang", _builder);
    this.initialize();
    TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
    Position _position = new Position(2, 5);
    final RenameParams params = new RenameParams(_textDocumentIdentifier, _position, "Does not matter");
    try {
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Expected an expcetion when trying to rename document but got a valid workspace edit instead: ");
      _builder_1.append(workspaceEdit);
      Assert.fail(_builder_1.toString());
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        final Throwable rootCause = Throwables.getRootCause(e);
        Assert.assertTrue((rootCause instanceof ResponseErrorException));
        final ResponseError error = ((ResponseErrorException) rootCause).getResponseError();
        Assert.assertTrue(error.getData().toString().contains("No element found at position"));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void testRenameFqn_invalid_null() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo.bar {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type A {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("foo.bar.MyType bar");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type MyType { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String uri = this.writeFile("my-type-invalid.testlang", _builder);
      this.initializeWithPrepareSupport();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
      Position _position = new Position(2, 5);
      final RenameParams params = new RenameParams(_textDocumentIdentifier, _position, "Does not matter");
      Assert.assertNull(this.languageServer.rename(params).get());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRenameFqn_before_ok() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo.bar {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type A {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("foo.bar.MyType bar");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type MyType { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String uri = this.writeFile("my-type-valid.testlang", _builder);
      this.initializeWithPrepareSupport();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
      Position _position = new Position(2, 13);
      final RenameParams params = new RenameParams(_textDocumentIdentifier, _position, "YourType");
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("changes :");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("my-type-valid.testlang : foo.bar.YourType [[2, 4] .. [2, 18]]");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("YourType [[4, 7] .. [4, 13]]");
      _builder_1.newLine();
      _builder_1.append("documentChanges : ");
      _builder_1.newLine();
      this.assertEquals(_builder_1.toString(), this.toExpectation(workspaceEdit));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPrepareRenameFqn_before_nok() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo.bar {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type A {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("foo.bar.MyType bar");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type MyType { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      this.initializeWithPrepareSupport();
      final String uri = this.writeFile("my-type-valid.testlang", model);
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
      Position _position = new Position(2, 11);
      final TextDocumentPositionParams params = new TextDocumentPositionParams(_textDocumentIdentifier, _position);
      Assert.assertNull(this.languageServer.prepareRename(params).get());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPrepareRenameFqn_start_ok() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo.bar {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type A {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("foo.bar.MyType bar");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type MyType { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      this.initializeWithPrepareSupport();
      final String uri = this.writeFile("my-type-valid.testlang", model);
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
      Position _position = new Position(2, 12);
      final TextDocumentPositionParams params = new TextDocumentPositionParams(_textDocumentIdentifier, _position);
      final Range range = this.languageServer.prepareRename(params).get().getLeft();
      this.assertEquals("MyType", new Document(Integer.valueOf(0), model).getSubstring(range));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPrepareRenameFqn_in_ok() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo.bar {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type A {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("foo.bar.MyType bar");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type MyType { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      this.initializeWithPrepareSupport();
      final String uri = this.writeFile("my-type-valid.testlang", model);
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
      Position _position = new Position(2, 14);
      final TextDocumentPositionParams params = new TextDocumentPositionParams(_textDocumentIdentifier, _position);
      final Range range = this.languageServer.prepareRename(params).get().getLeft();
      this.assertEquals("MyType", new Document(Integer.valueOf(0), model).getSubstring(range));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPrepareRenameFqn_end_ok() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo.bar {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type A {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("foo.bar.MyType bar");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type MyType { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      this.initializeWithPrepareSupport();
      final String uri = this.writeFile("my-type-valid.testlang", model);
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
      Position _position = new Position(2, 18);
      final TextDocumentPositionParams params = new TextDocumentPositionParams(_textDocumentIdentifier, _position);
      final Range range = this.languageServer.prepareRename(params).get().getLeft();
      this.assertEquals("MyType", new Document(Integer.valueOf(0), model).getSubstring(range));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPrepareRenameFqn_end_null() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo.bar {");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type A {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("foo.bar.MyType bar");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("type MyType { }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String model = _builder.toString();
      this.initialize();
      final String uri = this.writeFile("my-type-valid.testlang", model);
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
      Position _position = new Position(2, 18);
      final TextDocumentPositionParams params = new TextDocumentPositionParams(_textDocumentIdentifier, _position);
      Assert.assertNull(this.languageServer.prepareRename(params).get());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private InitializeResult initializeWithPrepareSupport() {
    final Procedure1<InitializeParams> _function = (InitializeParams it) -> {
      ClientCapabilities _clientCapabilities = new ClientCapabilities();
      final Procedure1<ClientCapabilities> _function_1 = (ClientCapabilities it_1) -> {
        TextDocumentClientCapabilities _textDocumentClientCapabilities = new TextDocumentClientCapabilities();
        final Procedure1<TextDocumentClientCapabilities> _function_2 = (TextDocumentClientCapabilities it_2) -> {
          RenameCapabilities _renameCapabilities = new RenameCapabilities();
          final Procedure1<RenameCapabilities> _function_3 = (RenameCapabilities it_3) -> {
            it_3.setPrepareSupport(Boolean.valueOf(true));
          };
          RenameCapabilities _doubleArrow = ObjectExtensions.<RenameCapabilities>operator_doubleArrow(_renameCapabilities, _function_3);
          it_2.setRename(_doubleArrow);
        };
        TextDocumentClientCapabilities _doubleArrow = ObjectExtensions.<TextDocumentClientCapabilities>operator_doubleArrow(_textDocumentClientCapabilities, _function_2);
        it_1.setTextDocument(_doubleArrow);
      };
      ClientCapabilities _doubleArrow = ObjectExtensions.<ClientCapabilities>operator_doubleArrow(_clientCapabilities, _function_1);
      it.setCapabilities(_doubleArrow);
    };
    return this.initialize(_function);
  }
}
