/**
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.concurrent.ExecutionException;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
    TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(modelFile);
    final RenameParams params = new RenameParams(_textDocumentIdentifier, position, "Tescht");
    try {
      this.languageServer.rename(params).get();
      Assert.fail("Rename should have failed");
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception exc = (Exception)_t;
        Assert.assertTrue((exc instanceof ExecutionException));
        Throwable _cause = exc.getCause();
        Assert.assertTrue((_cause instanceof ExecutionException));
        Throwable _cause_1 = exc.getCause().getCause();
        Assert.assertTrue((_cause_1 instanceof ResponseErrorException));
        Throwable _cause_2 = exc.getCause().getCause();
        final ResponseError error = ((ResponseErrorException) _cause_2).getResponseError();
        Assert.assertTrue(error.getData().toString().contains(messageFragment));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected void renameWithSuccess(final String model, final Position position) {
    try {
      final String modelFile = this.writeFile("MyType.testlang", model);
      this.initialize();
      TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(modelFile);
      final RenameParams params = new RenameParams(_textDocumentIdentifier, position, "Tescht");
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
