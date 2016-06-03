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
import io.typefox.lsapi.FileEvent;
import io.typefox.lsapi.FileEventImpl;
import io.typefox.lsapi.PositionImpl;
import io.typefox.lsapi.RangeImpl;
import io.typefox.lsapi.TextDocumentContentChangeEventImpl;
import io.typefox.lsapi.services.WorkspaceService;
import io.typefox.lsapi.util.LsapiFactories;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class OpenDocumentTest extends AbstractTestLangLanguageServerTest {
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
    FileEventImpl _newFileEvent = LsapiFactories.newFileEvent(path, FileEvent.TYPE_CREATED);
    DidChangeWatchedFilesParamsImpl _newDidChangeWatchedFilesParams = LsapiFactories.newDidChangeWatchedFilesParams(Collections.<FileEventImpl>unmodifiableList(CollectionLiterals.<FileEventImpl>newArrayList(_newFileEvent)));
    _workspaceService.didChangeWatchedFiles(_newDidChangeWatchedFilesParams);
    List<? extends Diagnostic> _get_1 = this.diagnostics.get(firstFile);
    Diagnostic _head_1 = IterableExtensions.head(_get_1);
    String _message_1 = _head_1.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message_1);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("type NonExisting {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.open(path, _builder_2.toString());
    List<? extends Diagnostic> _get_2 = this.diagnostics.get(firstFile);
    Diagnostic _head_2 = IterableExtensions.head(_get_2);
    Assert.assertNull(_head_2);
    this.close(path);
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
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type Test {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("NonExisting foo");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.open(firstFile, _builder_1.toString());
    List<? extends Diagnostic> _get_1 = this.diagnostics.get(firstFile);
    Diagnostic _head_1 = IterableExtensions.head(_get_1);
    String _message_1 = _head_1.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message_1);
    PositionImpl _newPosition = LsapiFactories.newPosition(1, 4);
    PositionImpl _newPosition_1 = LsapiFactories.newPosition(1, 15);
    RangeImpl _newRange = LsapiFactories.newRange(_newPosition, _newPosition_1);
    TextDocumentContentChangeEventImpl _newTextDocumentContentChangeEvent = LsapiFactories.newTextDocumentContentChangeEvent(_newRange, null, "Test");
    DidChangeTextDocumentParamsImpl _newDidChangeTextDocumentParamsImpl = LsapiFactories.newDidChangeTextDocumentParamsImpl(firstFile, 2, Collections.<TextDocumentContentChangeEventImpl>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEventImpl>newArrayList(_newTextDocumentContentChangeEvent)));
    this.languageServer.didChange(_newDidChangeTextDocumentParamsImpl);
    List<? extends Diagnostic> _get_2 = this.diagnostics.get(firstFile);
    Diagnostic _head_2 = IterableExtensions.head(_get_2);
    Assert.assertNull(_head_2);
  }
}
