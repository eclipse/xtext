/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.FileChangeType;
import org.eclipse.lsp4j.FileEvent;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentPositionParams;
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
  public void testPublishDiagnosticsAfterInitialized() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("NonExisting foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.writeFile("MyType1.testlang", _builder);
    this.initialize(null, false);
    Assert.assertTrue("Diagnostics produced before \'initialized\' was called", this.getDiagnostics().isEmpty());
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
  public void testIncrementalDeletion() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("NonExisting foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String path = this.writeFile("MyType1.testlang", _builder);
    this.initialize();
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", 
      IterableExtensions.<Diagnostic>head(IterableExtensions.<List<Diagnostic>>head(this.getDiagnostics().values())).getMessage());
    this.deleteFile("MyType1.testlang");
    WorkspaceService _workspaceService = this.languageServer.getWorkspaceService();
    FileEvent _fileEvent = new FileEvent(path, FileChangeType.Deleted);
    DidChangeWatchedFilesParams _didChangeWatchedFilesParams = new DidChangeWatchedFilesParams(Collections.<FileEvent>unmodifiableList(CollectionLiterals.<FileEvent>newArrayList(_fileEvent)));
    _workspaceService.didChangeWatchedFiles(_didChangeWatchedFilesParams);
    Assert.assertTrue(IterableExtensions.<List<Diagnostic>>head(this.getDiagnostics().values()).isEmpty());
  }
  
  @Test
  public void testTwoFilesDeleteClose() {
    final String fileURI = this.writeFile("Foo.testlang", "");
    this.initialize();
    final String referencingFileURI = this.getVirtualFile("Bar.testlang");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Bar {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Foo foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.open(referencingFileURI, _builder.toString());
    Assert.assertFalse("Bar.testlang references missing type Foo from Foo.testlang: expect error", 
      this.getDiagnostics().get(referencingFileURI).isEmpty());
    this.open(fileURI, "type Foo {}");
    Assert.assertTrue("Bar.testlang references type Foo from Foo.testlang: expect no error", 
      this.getDiagnostics().get(referencingFileURI).isEmpty());
    this.deleteFile(fileURI);
    WorkspaceService _workspaceService = this.languageServer.getWorkspaceService();
    FileEvent _fileEvent = new FileEvent(fileURI, FileChangeType.Deleted);
    DidChangeWatchedFilesParams _didChangeWatchedFilesParams = new DidChangeWatchedFilesParams(Collections.<FileEvent>unmodifiableList(CollectionLiterals.<FileEvent>newArrayList(_fileEvent)));
    _workspaceService.didChangeWatchedFiles(_didChangeWatchedFilesParams);
    Assert.assertTrue("delete file on disk: expect no error", this.getDiagnostics().get(referencingFileURI).isEmpty());
    this.close(fileURI);
    Assert.assertFalse("close deleted file: expect error", this.getDiagnostics().get(referencingFileURI).isEmpty());
  }
  
  @Test
  public void testMissingInitialize() {
    try {
      try {
        TextDocumentPositionParams _textDocumentPositionParams = new TextDocumentPositionParams();
        final Procedure1<TextDocumentPositionParams> _function = (TextDocumentPositionParams it) -> {
          TextDocumentIdentifier _textDocumentIdentifier = new TextDocumentIdentifier();
          final Procedure1<TextDocumentIdentifier> _function_1 = (TextDocumentIdentifier it_1) -> {
            it_1.setUri("file:/home/test/workspace/mydoc.testlang");
          };
          TextDocumentIdentifier _doubleArrow = ObjectExtensions.<TextDocumentIdentifier>operator_doubleArrow(_textDocumentIdentifier, _function_1);
          it.setTextDocument(_doubleArrow);
        };
        TextDocumentPositionParams _doubleArrow = ObjectExtensions.<TextDocumentPositionParams>operator_doubleArrow(_textDocumentPositionParams, _function);
        this.languageServer.definition(_doubleArrow).get();
        Assert.fail("Expected a ResponseErrorException");
      } catch (final Throwable _t) {
        if (_t instanceof ExecutionException) {
          final ExecutionException exception = (ExecutionException)_t;
          Throwable _cause = exception.getCause();
          Assert.assertEquals(ResponseErrorCode.serverNotInitialized.getValue(), ((ResponseErrorException) _cause).getResponseError().getCode());
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
