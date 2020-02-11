/**
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.common.base.Throwables;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.PrepareRenameResult;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.RenameCapabilities;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class RenamePositionTest extends AbstractLanguageServerTest {
  public RenamePositionTest() {
    super("renametl");
  }
  
  @Test
  public void testRenameBeginningOfFile() {
    Position _position = new Position(0, 0);
    this.renameAndFail("type Test", _position, "No element found at position");
  }
  
  @Test
  public void testRenameNameAtEndOfFile() {
    final String model = "type Test";
    int _length = model.length();
    Position _position = new Position(0, _length);
    this.renameWithSuccess(model, _position);
  }
  
  @Test
  public void testBeyondBeginningOfFile() {
    Position _position = new Position((-1), 0);
    this.renameAndFail("type Test", _position, "");
  }
  
  @Test
  public void testRenameBeyondLine() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test");
    _builder.newLine();
    _builder.append("{}");
    _builder.newLine();
    Position _position = new Position(0, 11);
    this.renameAndFail(_builder.toString(), _position, "Invalid document position");
  }
  
  @Test
  public void testBeyondEndOfFile() {
    final String model = "type Test";
    int _length = model.length();
    int _plus = (_length + 1);
    Position _position = new Position(0, _plus);
    this.renameAndFail(model, _position, "Invalid document position");
  }
  
  @Test
  public void testRenameAtBraceAfterIdentifier() {
    final String model = "type Test{}";
    int _indexOf = model.indexOf("{");
    Position _position = new Position(0, _indexOf);
    this.renameWithSuccess(model, _position);
  }
  
  @Test
  public void testRenameAtBrace() {
    final String model = "type Test{}";
    int _indexOf = model.indexOf("}");
    Position _position = new Position(0, _indexOf);
    this.renameAndFail(model, _position, "No element found at position");
  }
  
  protected void renameAndFail(final String model, final Position position, final String messageFragment) {
    final String modelFile = this.writeFile("MyType.testlang", model);
    this.initialize();
    try {
      final TextDocumentIdentifier identifier = new TextDocumentIdentifier(modelFile);
      TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams(identifier, position);
      final Either<Range, PrepareRenameResult> prepareRenameResult = this.languageServer.prepareRename(_textDocumentPositionParams).get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("expected null result got ");
      _builder.append(prepareRenameResult);
      _builder.append(" instead");
      Assert.assertNull(_builder.toString(), prepareRenameResult);
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(modelFile);
      final RenameParams renameParams = new RenameParams(_textDocumentIdentifier, position, "Tescht");
      this.languageServer.rename(renameParams).get();
      Assert.fail("Rename should have failed");
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exc = (Exception)_t;
        final Throwable rootCause = Throwables.getRootCause(exc);
        Assert.assertTrue((rootCause instanceof ResponseErrorException));
        final ResponseError error = ((ResponseErrorException) rootCause).getResponseError();
        Assert.assertTrue(error.getData().toString().contains(messageFragment));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected void renameWithSuccess(final String model, final Position position) {
    try {
      final String modelFile = this.writeFile("MyType.testlang", model);
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
      this.initialize(_function);
      final TextDocumentIdentifier identifier = new TextDocumentIdentifier(modelFile);
      TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams(identifier, position);
      final Range range = this.languageServer.prepareRename(_textDocumentPositionParams).get().getLeft();
      Assert.assertNotNull(range);
      this.assertEquals(new Document(Integer.valueOf(0), model).getSubstring(range), "Test");
      final RenameParams params = new RenameParams(identifier, position, "Tescht");
      final WorkspaceEdit workspaceEdit = this.languageServer.rename(params).get();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("changes :");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("MyType.testlang : Tescht [[0, 5] .. [0, 9]]");
      _builder.newLine();
      _builder.append("documentChanges : ");
      _builder.newLine();
      this.assertEquals(_builder.toString(), this.toExpectation(workspaceEdit));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
