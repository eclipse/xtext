/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import io.typefox.lsapi.Diagnostic;
import io.typefox.lsapi.DidChangeTextDocumentParams;
import io.typefox.lsapi.FileChangeType;
import io.typefox.lsapi.builders.DidChangeTextDocumentParamsBuilder;
import io.typefox.lsapi.builders.TextDocumentContentChangeEventBuilder;
import io.typefox.lsapi.builders.VersionedTextDocumentIdentifierBuilder;
import io.typefox.lsapi.impl.DidChangeWatchedFilesParamsImpl;
import io.typefox.lsapi.impl.FileEventImpl;
import io.typefox.lsapi.impl.PositionImpl;
import io.typefox.lsapi.services.WorkspaceService;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
    final String firstFile = this.writeFile("MyType1.testlang", _builder);
    this.initialize();
    List<? extends Diagnostic> _get = this.diagnostics.get(firstFile);
    Diagnostic _head = IterableExtensions.head(_get);
    String _message = _head.getMessage();
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String path = this.writeFile("MyType2.testlang", _builder_1);
    WorkspaceService _workspaceService = this.languageServer.getWorkspaceService();
    FileEventImpl _fileEventImpl = new FileEventImpl(path, FileChangeType.Created);
    DidChangeWatchedFilesParamsImpl _didChangeWatchedFilesParamsImpl = new DidChangeWatchedFilesParamsImpl(
      Collections.<FileEventImpl>unmodifiableList(CollectionLiterals.<FileEventImpl>newArrayList(_fileEventImpl)));
    _workspaceService.didChangeWatchedFiles(_didChangeWatchedFilesParamsImpl);
    List<? extends Diagnostic> _get_1 = this.diagnostics.get(firstFile);
    Diagnostic _head_1 = IterableExtensions.head(_get_1);
    String _message_1 = _head_1.getMessage();
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message_1);
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
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message_2);
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
    final String firstFile = this.writeFile("MyType1.testlang", _builder);
    this.initialize();
    List<? extends Diagnostic> _get = this.diagnostics.get(firstFile);
    Diagnostic _head = IterableExtensions.head(_get);
    String _message = _head.getMessage();
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message);
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
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message_1);
    final Procedure1<DidChangeTextDocumentParamsBuilder> _function = (DidChangeTextDocumentParamsBuilder it) -> {
      final Procedure1<VersionedTextDocumentIdentifierBuilder> _function_1 = (VersionedTextDocumentIdentifierBuilder it_1) -> {
        it_1.uri(firstFile);
        it_1.version(2);
      };
      it.textDocument(_function_1);
      final Procedure1<TextDocumentContentChangeEventBuilder> _function_2 = (TextDocumentContentChangeEventBuilder it_1) -> {
        PositionImpl _positionImpl = new PositionImpl(1, 4);
        PositionImpl _positionImpl_1 = new PositionImpl(1, 15);
        it_1.range(_positionImpl, _positionImpl_1);
        it_1.text("Test");
      };
      it.contentChange(_function_2);
    };
    DidChangeTextDocumentParamsBuilder _didChangeTextDocumentParamsBuilder = new DidChangeTextDocumentParamsBuilder(_function);
    DidChangeTextDocumentParams _build = _didChangeTextDocumentParamsBuilder.build();
    this.languageServer.didChange(_build);
    List<? extends Diagnostic> _get_2 = this.diagnostics.get(firstFile);
    Diagnostic _head_2 = IterableExtensions.head(_get_2);
    Assert.assertNull(_head_2);
  }
  
  @Test
  public void testDidClose() {
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
    List<? extends Diagnostic> _get = this.diagnostics.get(referencingFileURI);
    boolean _isEmpty = _get.isEmpty();
    Assert.assertFalse(_isEmpty);
    this.open(fileURI, "type Foo {}");
    List<? extends Diagnostic> _get_1 = this.diagnostics.get(referencingFileURI);
    boolean _isEmpty_1 = _get_1.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    this.close(fileURI);
    List<? extends Diagnostic> _get_2 = this.diagnostics.get(referencingFileURI);
    boolean _isEmpty_2 = _get_2.isEmpty();
    Assert.assertFalse(_isEmpty_2);
  }
  
  @Test
  public void testDidCloseInMemory() {
    this.initialize();
    final String fileURI = this.getVirtualFile("Foo.testlang");
    this.open(fileURI, "type Foo {}");
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
    List<? extends Diagnostic> _get = this.diagnostics.get(referencingFileURI);
    boolean _isEmpty = _get.isEmpty();
    Assert.assertTrue(_isEmpty);
    this.close(fileURI);
    List<? extends Diagnostic> _get_1 = this.diagnostics.get(referencingFileURI);
    boolean _isEmpty_1 = _get_1.isEmpty();
    Assert.assertFalse(_isEmpty_1);
  }
}
