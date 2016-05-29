/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import io.typefox.lsapi.Diagnostic;
import io.typefox.lsapi.DidChangeTextDocumentParamsImpl;
import io.typefox.lsapi.DidChangeWatchedFilesParamsImpl;
import io.typefox.lsapi.DidCloseTextDocumentParamsImpl;
import io.typefox.lsapi.DidOpenTextDocumentParamsImpl;
import io.typefox.lsapi.FileEvent;
import io.typefox.lsapi.FileEventImpl;
import io.typefox.lsapi.PositionImpl;
import io.typefox.lsapi.RangeImpl;
import io.typefox.lsapi.TextDocumentContentChangeEventImpl;
import io.typefox.lsapi.TextDocumentIdentifierImpl;
import io.typefox.lsapi.TextDocumentItemImpl;
import io.typefox.lsapi.VersionedTextDocumentIdentifierImpl;
import io.typefox.lsapi.services.WorkspaceService;
import java.util.ArrayList;
import java.util.Collections;
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
  public void testOpenedDocumentShadowsPersistedFile() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("NonExisting foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String firstFile = this.operator_mappedTo("MyType1.testlang", _builder);
    this.initialize();
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
    final Procedure1<DidChangeWatchedFilesParamsImpl> _function = (DidChangeWatchedFilesParamsImpl it) -> {
      FileEventImpl _fileEventImpl = new FileEventImpl();
      final Procedure1<FileEventImpl> _function_1 = (FileEventImpl it_1) -> {
        it_1.setUri(path);
        it_1.setType(FileEvent.TYPE_CREATED);
      };
      FileEventImpl _doubleArrow = ObjectExtensions.<FileEventImpl>operator_doubleArrow(_fileEventImpl, _function_1);
      ArrayList<FileEventImpl> _newArrayList = CollectionLiterals.<FileEventImpl>newArrayList(_doubleArrow);
      it.setChanges(_newArrayList);
    };
    DidChangeWatchedFilesParamsImpl _doubleArrow = ObjectExtensions.<DidChangeWatchedFilesParamsImpl>operator_doubleArrow(_didChangeWatchedFilesParamsImpl, _function);
    _workspaceService.didChangeWatchedFiles(_doubleArrow);
    List<? extends Diagnostic> _get_1 = this.diagnostics.get(firstFile);
    Diagnostic _head_1 = IterableExtensions.head(_get_1);
    String _message_1 = _head_1.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message_1);
    DidOpenTextDocumentParamsImpl _didOpenTextDocumentParamsImpl = new DidOpenTextDocumentParamsImpl();
    final Procedure1<DidOpenTextDocumentParamsImpl> _function_1 = (DidOpenTextDocumentParamsImpl it) -> {
      TextDocumentItemImpl _textDocumentItemImpl = new TextDocumentItemImpl();
      final Procedure1<TextDocumentItemImpl> _function_2 = (TextDocumentItemImpl it_1) -> {
        it_1.setUri(path);
        it_1.setVersion(1);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("type NonExisting {");
        _builder_2.newLine();
        _builder_2.append("}");
        _builder_2.newLine();
        it_1.setText(_builder_2.toString());
      };
      TextDocumentItemImpl _doubleArrow_1 = ObjectExtensions.<TextDocumentItemImpl>operator_doubleArrow(_textDocumentItemImpl, _function_2);
      it.setTextDocument(_doubleArrow_1);
    };
    DidOpenTextDocumentParamsImpl _doubleArrow_1 = ObjectExtensions.<DidOpenTextDocumentParamsImpl>operator_doubleArrow(_didOpenTextDocumentParamsImpl, _function_1);
    this.languageServer.didOpen(_doubleArrow_1);
    List<? extends Diagnostic> _get_2 = this.diagnostics.get(firstFile);
    Diagnostic _head_2 = IterableExtensions.head(_get_2);
    Assert.assertNull(_head_2);
    DidCloseTextDocumentParamsImpl _didCloseTextDocumentParamsImpl = new DidCloseTextDocumentParamsImpl();
    final Procedure1<DidCloseTextDocumentParamsImpl> _function_2 = (DidCloseTextDocumentParamsImpl it) -> {
      TextDocumentIdentifierImpl _textDocumentIdentifierImpl = new TextDocumentIdentifierImpl();
      final Procedure1<TextDocumentIdentifierImpl> _function_3 = (TextDocumentIdentifierImpl it_1) -> {
        it_1.setUri(path);
      };
      TextDocumentIdentifierImpl _doubleArrow_2 = ObjectExtensions.<TextDocumentIdentifierImpl>operator_doubleArrow(_textDocumentIdentifierImpl, _function_3);
      it.setTextDocument(_doubleArrow_2);
    };
    DidCloseTextDocumentParamsImpl _doubleArrow_2 = ObjectExtensions.<DidCloseTextDocumentParamsImpl>operator_doubleArrow(_didCloseTextDocumentParamsImpl, _function_2);
    this.languageServer.didClose(_doubleArrow_2);
    List<? extends Diagnostic> _get_3 = this.diagnostics.get(firstFile);
    Diagnostic _head_3 = IterableExtensions.head(_get_3);
    String _message_2 = _head_3.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message_2);
  }
  
  @Test
  public void testDidChange() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Test {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("NonExisting foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final String firstFile = this.operator_mappedTo("MyType1.testlang", _builder);
    this.initialize();
    List<? extends Diagnostic> _get = this.diagnostics.get(firstFile);
    Diagnostic _head = IterableExtensions.head(_get);
    String _message = _head.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message);
    DidOpenTextDocumentParamsImpl _didOpenTextDocumentParamsImpl = new DidOpenTextDocumentParamsImpl();
    final Procedure1<DidOpenTextDocumentParamsImpl> _function = (DidOpenTextDocumentParamsImpl it) -> {
      TextDocumentItemImpl _textDocumentItemImpl = new TextDocumentItemImpl();
      final Procedure1<TextDocumentItemImpl> _function_1 = (TextDocumentItemImpl it_1) -> {
        it_1.setUri(firstFile);
        it_1.setVersion(1);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("type Test {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("NonExisting foo");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        it_1.setText(_builder_1.toString());
      };
      TextDocumentItemImpl _doubleArrow = ObjectExtensions.<TextDocumentItemImpl>operator_doubleArrow(_textDocumentItemImpl, _function_1);
      it.setTextDocument(_doubleArrow);
    };
    DidOpenTextDocumentParamsImpl _doubleArrow = ObjectExtensions.<DidOpenTextDocumentParamsImpl>operator_doubleArrow(_didOpenTextDocumentParamsImpl, _function);
    this.languageServer.didOpen(_doubleArrow);
    List<? extends Diagnostic> _get_1 = this.diagnostics.get(firstFile);
    Diagnostic _head_1 = IterableExtensions.head(_get_1);
    String _message_1 = _head_1.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message_1);
    DidChangeTextDocumentParamsImpl _didChangeTextDocumentParamsImpl = new DidChangeTextDocumentParamsImpl();
    final Procedure1<DidChangeTextDocumentParamsImpl> _function_1 = (DidChangeTextDocumentParamsImpl it) -> {
      VersionedTextDocumentIdentifierImpl _versionedTextDocumentIdentifierImpl = new VersionedTextDocumentIdentifierImpl();
      final Procedure1<VersionedTextDocumentIdentifierImpl> _function_2 = (VersionedTextDocumentIdentifierImpl it_1) -> {
        it_1.setUri(firstFile);
        it_1.setVersion(2);
      };
      VersionedTextDocumentIdentifierImpl _doubleArrow_1 = ObjectExtensions.<VersionedTextDocumentIdentifierImpl>operator_doubleArrow(_versionedTextDocumentIdentifierImpl, _function_2);
      it.setTextDocument(_doubleArrow_1);
      TextDocumentContentChangeEventImpl _textDocumentContentChangeEventImpl = new TextDocumentContentChangeEventImpl();
      final Procedure1<TextDocumentContentChangeEventImpl> _function_3 = (TextDocumentContentChangeEventImpl it_1) -> {
        RangeImpl _rangeImpl = new RangeImpl();
        final Procedure1<RangeImpl> _function_4 = (RangeImpl it_2) -> {
          PositionImpl _positionImpl = new PositionImpl();
          final Procedure1<PositionImpl> _function_5 = (PositionImpl it_3) -> {
            it_3.setLine(1);
            it_3.setCharacter(4);
          };
          PositionImpl _doubleArrow_2 = ObjectExtensions.<PositionImpl>operator_doubleArrow(_positionImpl, _function_5);
          it_2.setStart(_doubleArrow_2);
          PositionImpl _positionImpl_1 = new PositionImpl();
          final Procedure1<PositionImpl> _function_6 = (PositionImpl it_3) -> {
            it_3.setLine(1);
            it_3.setCharacter(15);
          };
          PositionImpl _doubleArrow_3 = ObjectExtensions.<PositionImpl>operator_doubleArrow(_positionImpl_1, _function_6);
          it_2.setEnd(_doubleArrow_3);
        };
        RangeImpl _doubleArrow_2 = ObjectExtensions.<RangeImpl>operator_doubleArrow(_rangeImpl, _function_4);
        it_1.setRange(_doubleArrow_2);
        it_1.setText("Test");
      };
      TextDocumentContentChangeEventImpl _doubleArrow_2 = ObjectExtensions.<TextDocumentContentChangeEventImpl>operator_doubleArrow(_textDocumentContentChangeEventImpl, _function_3);
      it.setContentChanges(Collections.<TextDocumentContentChangeEventImpl>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEventImpl>newArrayList(_doubleArrow_2)));
    };
    DidChangeTextDocumentParamsImpl _doubleArrow_1 = ObjectExtensions.<DidChangeTextDocumentParamsImpl>operator_doubleArrow(_didChangeTextDocumentParamsImpl, _function_1);
    this.languageServer.didChange(_doubleArrow_1);
    List<? extends Diagnostic> _get_2 = this.diagnostics.get(firstFile);
    Diagnostic _head_2 = IterableExtensions.head(_get_2);
    Assert.assertNull(_head_2);
  }
}
