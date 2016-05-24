/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import io.typefox.lsapi.Diagnostic;
import io.typefox.lsapi.DidChangeWatchedFilesParamsImpl;
import io.typefox.lsapi.DidCloseTextDocumentParamsImpl;
import io.typefox.lsapi.DidOpenTextDocumentParamsImpl;
import io.typefox.lsapi.FileEvent;
import io.typefox.lsapi.FileEventImpl;
import io.typefox.lsapi.InitializeParamsImpl;
import io.typefox.lsapi.TextDocumentIdentifierImpl;
import io.typefox.lsapi.TextDocumentItemImpl;
import io.typefox.lsapi.WorkspaceService;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractLanguageServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class OpenDocumentTest extends AbstractLanguageServerTest {
  @Test
  public void testOpenDocument() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("NonExisting foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String firstFile = this.operator_mappedTo("MyType1.testlang", _builder);
    InitializeParamsImpl _initializeParamsImpl = new InitializeParamsImpl();
    final Procedure1<InitializeParamsImpl> _function = new Procedure1<InitializeParamsImpl>() {
      @Override
      public void apply(final InitializeParamsImpl it) {
        String _absolutePath = OpenDocumentTest.this.root.getAbsolutePath();
        it.setRootPath(_absolutePath);
      }
    };
    InitializeParamsImpl _doubleArrow = ObjectExtensions.<InitializeParamsImpl>operator_doubleArrow(_initializeParamsImpl, _function);
    this.languageServer.initialize(_doubleArrow);
    List<? extends Diagnostic> _get = this.diagnostics.get(firstFile);
    Diagnostic _head = IterableExtensions.head(_get);
    String _message = _head.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String path = this.operator_mappedTo("MyType2.testlang", _builder_1);
    WorkspaceService _workspaceService = this.languageServer.getWorkspaceService();
    DidChangeWatchedFilesParamsImpl _didChangeWatchedFilesParamsImpl = new DidChangeWatchedFilesParamsImpl();
    final Procedure1<DidChangeWatchedFilesParamsImpl> _function_1 = new Procedure1<DidChangeWatchedFilesParamsImpl>() {
      @Override
      public void apply(final DidChangeWatchedFilesParamsImpl it) {
        FileEventImpl _fileEventImpl = new FileEventImpl();
        final Procedure1<FileEventImpl> _function = new Procedure1<FileEventImpl>() {
          @Override
          public void apply(final FileEventImpl it) {
            it.setUri(path);
            it.setType(FileEvent.TYPE_CREATED);
          }
        };
        FileEventImpl _doubleArrow = ObjectExtensions.<FileEventImpl>operator_doubleArrow(_fileEventImpl, _function);
        ArrayList<FileEventImpl> _newArrayList = CollectionLiterals.<FileEventImpl>newArrayList(_doubleArrow);
        it.setChanges(_newArrayList);
      }
    };
    DidChangeWatchedFilesParamsImpl _doubleArrow_1 = ObjectExtensions.<DidChangeWatchedFilesParamsImpl>operator_doubleArrow(_didChangeWatchedFilesParamsImpl, _function_1);
    _workspaceService.didChangeWatchedFiles(_doubleArrow_1);
    List<? extends Diagnostic> _get_1 = this.diagnostics.get(firstFile);
    Diagnostic _head_1 = IterableExtensions.head(_get_1);
    String _message_1 = _head_1.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message_1);
    DidOpenTextDocumentParamsImpl _didOpenTextDocumentParamsImpl = new DidOpenTextDocumentParamsImpl();
    final Procedure1<DidOpenTextDocumentParamsImpl> _function_2 = new Procedure1<DidOpenTextDocumentParamsImpl>() {
      @Override
      public void apply(final DidOpenTextDocumentParamsImpl it) {
        TextDocumentItemImpl _textDocumentItemImpl = new TextDocumentItemImpl();
        final Procedure1<TextDocumentItemImpl> _function = new Procedure1<TextDocumentItemImpl>() {
          @Override
          public void apply(final TextDocumentItemImpl it) {
            it.setUri(path);
            it.setVersion(1);
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("type NonExisting {");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
            it.setText(_builder.toString());
          }
        };
        TextDocumentItemImpl _doubleArrow = ObjectExtensions.<TextDocumentItemImpl>operator_doubleArrow(_textDocumentItemImpl, _function);
        it.setTextDocument(_doubleArrow);
      }
    };
    DidOpenTextDocumentParamsImpl _doubleArrow_2 = ObjectExtensions.<DidOpenTextDocumentParamsImpl>operator_doubleArrow(_didOpenTextDocumentParamsImpl, _function_2);
    this.languageServer.didOpen(_doubleArrow_2);
    List<? extends Diagnostic> _get_2 = this.diagnostics.get(firstFile);
    Diagnostic _head_2 = IterableExtensions.head(_get_2);
    Assert.assertNull(_head_2);
    DidCloseTextDocumentParamsImpl _didCloseTextDocumentParamsImpl = new DidCloseTextDocumentParamsImpl();
    final Procedure1<DidCloseTextDocumentParamsImpl> _function_3 = new Procedure1<DidCloseTextDocumentParamsImpl>() {
      @Override
      public void apply(final DidCloseTextDocumentParamsImpl it) {
        TextDocumentIdentifierImpl _textDocumentIdentifierImpl = new TextDocumentIdentifierImpl();
        final Procedure1<TextDocumentIdentifierImpl> _function = new Procedure1<TextDocumentIdentifierImpl>() {
          @Override
          public void apply(final TextDocumentIdentifierImpl it) {
            it.setUri(path);
          }
        };
        TextDocumentIdentifierImpl _doubleArrow = ObjectExtensions.<TextDocumentIdentifierImpl>operator_doubleArrow(_textDocumentIdentifierImpl, _function);
        it.setTextDocument(_doubleArrow);
      }
    };
    DidCloseTextDocumentParamsImpl _doubleArrow_3 = ObjectExtensions.<DidCloseTextDocumentParamsImpl>operator_doubleArrow(_didCloseTextDocumentParamsImpl, _function_3);
    this.languageServer.didClose(_doubleArrow_3);
    List<? extends Diagnostic> _get_3 = this.diagnostics.get(firstFile);
    Diagnostic _head_3 = IterableExtensions.head(_get_3);
    String _message_2 = _head_3.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message_2);
  }
}
