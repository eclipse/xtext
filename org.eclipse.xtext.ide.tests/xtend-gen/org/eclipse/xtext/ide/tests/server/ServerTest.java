/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.Collections;
import java.util.List;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.FileChangeType;
import org.eclipse.lsp4j.FileEvent;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseErrorCode;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ServerTest extends AbstractTestLangLanguageServerTest {
  @Test
  public void testInitializeBuild() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("string foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.writeFile("MyType1.testlang", _builder);
    this.initialize();
    Assert.assertTrue(IterableExtensions.join(this.getDiagnostics().entrySet(), ","), IterableExtensions.<List<Diagnostic>>head(this.getDiagnostics().values()).isEmpty());
  }
  
  @Test
  public void testInitializeBuildWithError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("NonExisting foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.writeFile("MyType1.testlang", _builder);
    this.initialize();
    Diagnostic _head = IterableExtensions.<Diagnostic>head(IterableExtensions.<List<Diagnostic>>head(this.getDiagnostics().values()));
    String _message = null;
    if (_head!=null) {
      _message=_head.getMessage();
    }
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message);
    Assert.assertEquals(1, IterableExtensions.<Diagnostic>head(IterableExtensions.<List<Diagnostic>>head(this.getDiagnostics().values())).getRange().getStart().getLine());
    Assert.assertEquals(4, IterableExtensions.<Diagnostic>head(IterableExtensions.<List<Diagnostic>>head(this.getDiagnostics().values())).getRange().getStart().getCharacter());
    Assert.assertEquals(1, IterableExtensions.<Diagnostic>head(IterableExtensions.<List<Diagnostic>>head(this.getDiagnostics().values())).getRange().getEnd().getLine());
    Assert.assertEquals(15, IterableExtensions.<Diagnostic>head(IterableExtensions.<List<Diagnostic>>head(this.getDiagnostics().values())).getRange().getEnd().getCharacter());
  }
  
  @Test
  public void testIncrementalBuildWithError() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("NonExisting foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.writeFile("MyType1.testlang", _builder);
    this.initialize();
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", IterableExtensions.<Diagnostic>head(IterableExtensions.<List<Diagnostic>>head(this.getDiagnostics().values())).getMessage());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type NonExisting {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String path = this.writeFile("MyType2.testlang", _builder_1);
    WorkspaceService _workspaceService = this.languageServer.getWorkspaceService();
    FileEvent _fileEvent = new FileEvent(path, FileChangeType.Created);
    DidChangeWatchedFilesParams _didChangeWatchedFilesParams = new DidChangeWatchedFilesParams(Collections.<FileEvent>unmodifiableList(CollectionLiterals.<FileEvent>newArrayList(_fileEvent)));
    _workspaceService.didChangeWatchedFiles(_didChangeWatchedFilesParams);
    Assert.assertNotNull(this.getDiagnostics().get(path));
    final Function1<List<Diagnostic>, Boolean> _function = (List<Diagnostic> it) -> {
      return Boolean.valueOf(it.isEmpty());
    };
    Assert.assertTrue(IterableExtensions.join(this.getDiagnostics().values(), ","), IterableExtensions.<List<Diagnostic>>forall(this.getDiagnostics().values(), _function));
  }
  
  @Test
  public void testMissingInitialize() {
    try {
      DidOpenTextDocumentParams _didOpenTextDocumentParams = new DidOpenTextDocumentParams();
      final Procedure1<DidOpenTextDocumentParams> _function = (DidOpenTextDocumentParams it) -> {
        TextDocumentItem _textDocumentItem = new TextDocumentItem();
        final Procedure1<TextDocumentItem> _function_1 = (TextDocumentItem it_1) -> {
          it_1.setUri("file:/home/test/workspace/mydoc.testlang");
          it_1.setText("type Foo {}");
        };
        TextDocumentItem _doubleArrow = ObjectExtensions.<TextDocumentItem>operator_doubleArrow(_textDocumentItem, _function_1);
        it.setTextDocument(_doubleArrow);
      };
      DidOpenTextDocumentParams _doubleArrow = ObjectExtensions.<DidOpenTextDocumentParams>operator_doubleArrow(_didOpenTextDocumentParams, _function);
      this.languageServer.didOpen(_doubleArrow);
      Assert.fail("Expected a ResponseErrorException");
    } catch (final Throwable _t) {
      if (_t instanceof ResponseErrorException) {
        final ResponseErrorException exception = (ResponseErrorException)_t;
        Assert.assertEquals(ResponseErrorCode.serverNotInitialized.getValue(), exception.getResponseError().getCode());
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
