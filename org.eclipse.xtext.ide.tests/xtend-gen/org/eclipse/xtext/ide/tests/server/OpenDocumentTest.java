/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.Collections;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.FileChangeType;
import org.eclipse.lsp4j.FileEvent;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
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
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", IterableExtensions.<Diagnostic>head(this.getDiagnostics().get(firstFile)).getMessage());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type Foo {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String path = this.writeFile("MyType2.testlang", _builder_1);
    WorkspaceService _workspaceService = this.languageServer.getWorkspaceService();
    FileEvent _fileEvent = new FileEvent(path, FileChangeType.Created);
    DidChangeWatchedFilesParams _didChangeWatchedFilesParams = new DidChangeWatchedFilesParams(
      Collections.<FileEvent>unmodifiableList(CollectionLiterals.<FileEvent>newArrayList(_fileEvent)));
    _workspaceService.didChangeWatchedFiles(_didChangeWatchedFilesParams);
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", IterableExtensions.<Diagnostic>head(this.getDiagnostics().get(firstFile)).getMessage());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("type NonExisting {");
    _builder_2.newLine();
    _builder_2.append("}");
    _builder_2.newLine();
    this.open(path, _builder_2.toString());
    Assert.assertNull(IterableExtensions.<Diagnostic>head(this.getDiagnostics().get(firstFile)));
    this.close(path);
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", IterableExtensions.<Diagnostic>head(this.getDiagnostics().get(firstFile)).getMessage());
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
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", IterableExtensions.<Diagnostic>head(this.getDiagnostics().get(firstFile)).getMessage());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type Test {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("NonExisting foo");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.open(firstFile, _builder_1.toString());
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", IterableExtensions.<Diagnostic>head(this.getDiagnostics().get(firstFile)).getMessage());
    DidChangeTextDocumentParams _didChangeTextDocumentParams = new DidChangeTextDocumentParams();
    final Procedure1<DidChangeTextDocumentParams> _function = (DidChangeTextDocumentParams it) -> {
      VersionedTextDocumentIdentifier _versionedTextDocumentIdentifier = new VersionedTextDocumentIdentifier();
      final Procedure1<VersionedTextDocumentIdentifier> _function_1 = (VersionedTextDocumentIdentifier it_1) -> {
        it_1.setUri(firstFile);
        it_1.setVersion(2);
      };
      VersionedTextDocumentIdentifier _doubleArrow = ObjectExtensions.<VersionedTextDocumentIdentifier>operator_doubleArrow(_versionedTextDocumentIdentifier, _function_1);
      it.setTextDocument(_doubleArrow);
      TextDocumentContentChangeEvent _textDocumentContentChangeEvent = new TextDocumentContentChangeEvent();
      final Procedure1<TextDocumentContentChangeEvent> _function_2 = (TextDocumentContentChangeEvent it_1) -> {
        Position _position = new Position(1, 4);
        Position _position_1 = new Position(1, 15);
        Range _range = new Range(_position, _position_1);
        it_1.setRange(_range);
        it_1.setText("Test");
      };
      TextDocumentContentChangeEvent _doubleArrow_1 = ObjectExtensions.<TextDocumentContentChangeEvent>operator_doubleArrow(_textDocumentContentChangeEvent, _function_2);
      it.setContentChanges(Collections.<TextDocumentContentChangeEvent>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEvent>newArrayList(_doubleArrow_1)));
    };
    DidChangeTextDocumentParams _doubleArrow = ObjectExtensions.<DidChangeTextDocumentParams>operator_doubleArrow(_didChangeTextDocumentParams, _function);
    this.languageServer.didChange(_doubleArrow);
    Assert.assertNull(IterableExtensions.<Diagnostic>head(this.getDiagnostics().get(firstFile)));
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
    Assert.assertFalse(this.getDiagnostics().get(referencingFileURI).isEmpty());
    this.open(fileURI, "type Foo {}");
    Assert.assertTrue(this.getDiagnostics().get(referencingFileURI).isEmpty());
    this.close(fileURI);
    Assert.assertFalse(this.getDiagnostics().get(referencingFileURI).isEmpty());
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
    Assert.assertTrue(this.getDiagnostics().get(referencingFileURI).isEmpty());
    this.close(fileURI);
    Assert.assertFalse(this.getDiagnostics().get(referencingFileURI).isEmpty());
  }
  
  @Test
  public void testInMemory_GH_456() {
    this.initialize();
    final String uri = "inmemory:/foo/bar.testlang";
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Foo { }");
    _builder.newLine();
    this.open(uri, _builder.toString());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Diagnostics could be empty but never null.");
    Assert.assertNotNull(_builder_1.toString(), this.getDiagnostics().get(uri));
  }
}
