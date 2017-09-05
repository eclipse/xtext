/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.TextDocumentPositionParams;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

@SuppressWarnings("all")
public class UnknownProjectConfigTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testCompletionWithInmemoryScheme_01() {
    final Procedure1<InitializeParams> _function = (InitializeParams it) -> {
      it.setRootUri(null);
    };
    this.initialize(_function);
    final String inmemoryUri = "inmemory:/mydoc.testlang";
    DidOpenTextDocumentParams _didOpenTextDocumentParams = new DidOpenTextDocumentParams();
    final Procedure1<DidOpenTextDocumentParams> _function_1 = (DidOpenTextDocumentParams it) -> {
      TextDocumentItem _textDocumentItem = new TextDocumentItem();
      final Procedure1<TextDocumentItem> _function_2 = (TextDocumentItem it_1) -> {
        it_1.setUri(inmemoryUri);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type Foo {}");
        _builder.newLine();
        it_1.setText(_builder.toString());
      };
      TextDocumentItem _doubleArrow = ObjectExtensions.<TextDocumentItem>operator_doubleArrow(_textDocumentItem, _function_2);
      it.setTextDocument(_doubleArrow);
    };
    DidOpenTextDocumentParams _doubleArrow = ObjectExtensions.<DidOpenTextDocumentParams>operator_doubleArrow(_didOpenTextDocumentParams, _function_1);
    this.languageServer.didOpen(_doubleArrow);
    this.checkCompletion(inmemoryUri);
  }
  
  @Test
  public void testCompletionWithInmemoryScheme_02() {
    this.initialize();
    final String inmemoryUri = "inmemory:/mydoc.testlang";
    DidOpenTextDocumentParams _didOpenTextDocumentParams = new DidOpenTextDocumentParams();
    final Procedure1<DidOpenTextDocumentParams> _function = (DidOpenTextDocumentParams it) -> {
      TextDocumentItem _textDocumentItem = new TextDocumentItem();
      final Procedure1<TextDocumentItem> _function_1 = (TextDocumentItem it_1) -> {
        it_1.setUri(inmemoryUri);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type Foo {}");
        _builder.newLine();
        it_1.setText(_builder.toString());
      };
      TextDocumentItem _doubleArrow = ObjectExtensions.<TextDocumentItem>operator_doubleArrow(_textDocumentItem, _function_1);
      it.setTextDocument(_doubleArrow);
    };
    DidOpenTextDocumentParams _doubleArrow = ObjectExtensions.<DidOpenTextDocumentParams>operator_doubleArrow(_didOpenTextDocumentParams, _function);
    this.languageServer.didOpen(_doubleArrow);
    this.checkCompletion(inmemoryUri);
  }
  
  @Test
  public void testCompletionWithFileScheme_01() {
    final Procedure1<InitializeParams> _function = (InitializeParams it) -> {
      it.setRootUri(null);
    };
    this.initialize(_function);
    final String fileUri = "file:/home/test/workspace/mydoc.testlang";
    DidOpenTextDocumentParams _didOpenTextDocumentParams = new DidOpenTextDocumentParams();
    final Procedure1<DidOpenTextDocumentParams> _function_1 = (DidOpenTextDocumentParams it) -> {
      TextDocumentItem _textDocumentItem = new TextDocumentItem();
      final Procedure1<TextDocumentItem> _function_2 = (TextDocumentItem it_1) -> {
        it_1.setUri(fileUri);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type Foo {}");
        _builder.newLine();
        it_1.setText(_builder.toString());
      };
      TextDocumentItem _doubleArrow = ObjectExtensions.<TextDocumentItem>operator_doubleArrow(_textDocumentItem, _function_2);
      it.setTextDocument(_doubleArrow);
    };
    DidOpenTextDocumentParams _doubleArrow = ObjectExtensions.<DidOpenTextDocumentParams>operator_doubleArrow(_didOpenTextDocumentParams, _function_1);
    this.languageServer.didOpen(_doubleArrow);
    this.checkCompletion(fileUri);
  }
  
  @Test
  public void testCompletionWithFileScheme_02() {
    this.initialize();
    final String fileUri = "file:/home/test/workspace/mydoc.testlang";
    DidOpenTextDocumentParams _didOpenTextDocumentParams = new DidOpenTextDocumentParams();
    final Procedure1<DidOpenTextDocumentParams> _function = (DidOpenTextDocumentParams it) -> {
      TextDocumentItem _textDocumentItem = new TextDocumentItem();
      final Procedure1<TextDocumentItem> _function_1 = (TextDocumentItem it_1) -> {
        it_1.setUri(fileUri);
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("type Foo {}");
        _builder.newLine();
        it_1.setText(_builder.toString());
      };
      TextDocumentItem _doubleArrow = ObjectExtensions.<TextDocumentItem>operator_doubleArrow(_textDocumentItem, _function_1);
      it.setTextDocument(_doubleArrow);
    };
    DidOpenTextDocumentParams _doubleArrow = ObjectExtensions.<DidOpenTextDocumentParams>operator_doubleArrow(_didOpenTextDocumentParams, _function);
    this.languageServer.didOpen(_doubleArrow);
    this.checkCompletion(fileUri);
  }
  
  protected void checkCompletion(final String uri) {
    try {
      TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams();
      final Procedure1<TextDocumentPositionParams> _function = (TextDocumentPositionParams it) -> {
        TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier(uri);
        it.setTextDocument(_textDocumentIdentifier);
        Position _position = new Position(0, 10);
        it.setPosition(_position);
      };
      TextDocumentPositionParams _doubleArrow = ObjectExtensions.<TextDocumentPositionParams>operator_doubleArrow(_textDocumentPositionParams, _function);
      final CompletableFuture<Either<List<CompletionItem>, CompletionList>> completionItems = this.languageServer.completion(_doubleArrow);
      final Either<List<CompletionItem>, CompletionList> result = completionItems.get();
      List<CompletionItem> _xifexpression = null;
      boolean _isLeft = result.isLeft();
      if (_isLeft) {
        _xifexpression = result.getLeft();
      } else {
        _xifexpression = result.getRight().getItems();
      }
      final List<CompletionItem> items = _xifexpression;
      final String actualCompletionItems = this.toExpectation(items);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Foo (TypeDeclaration) -> Foo [[0, 10] .. [0, 10]]");
      _builder.newLine();
      _builder.append("boolean -> boolean [[0, 10] .. [0, 10]]");
      _builder.newLine();
      _builder.append("int -> int [[0, 10] .. [0, 10]]");
      _builder.newLine();
      _builder.append("op -> op [[0, 10] .. [0, 10]]");
      _builder.newLine();
      _builder.append("string -> string [[0, 10] .. [0, 10]]");
      _builder.newLine();
      _builder.append("void -> void [[0, 10] .. [0, 10]]");
      _builder.newLine();
      _builder.append("} -> } [[0, 10] .. [0, 10]]");
      _builder.newLine();
      _builder.append("{ -> { [[0, 9] .. [0, 10]]");
      _builder.newLine();
      final String expectedCompletionItems = _builder.toString();
      this.assertEquals(expectedCompletionItems, actualCompletionItems);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
