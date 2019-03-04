/**
 * Copyright (c) 2018 TypeFox and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.io.File;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SemanticHighlightingCapabilities;
import org.eclipse.lsp4j.SemanticHighlightingInformation;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class SemanticHighlightingTest extends AbstractTestLangLanguageServerTest {
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  private List<List<String>> scopes;
  
  @Before
  public void before() {
    final Procedure1<InitializeParams> _function = (InitializeParams it) -> {
      ClientCapabilities _clientCapabilities = new ClientCapabilities();
      final Procedure1<ClientCapabilities> _function_1 = (ClientCapabilities it_1) -> {
        TextDocumentClientCapabilities _textDocumentClientCapabilities = new TextDocumentClientCapabilities();
        final Procedure1<TextDocumentClientCapabilities> _function_2 = (TextDocumentClientCapabilities it_2) -> {
          SemanticHighlightingCapabilities _semanticHighlightingCapabilities = new SemanticHighlightingCapabilities();
          final Procedure1<SemanticHighlightingCapabilities> _function_3 = (SemanticHighlightingCapabilities it_3) -> {
            it_3.setSemanticHighlighting(Boolean.valueOf(true));
          };
          SemanticHighlightingCapabilities _doubleArrow = ObjectExtensions.<SemanticHighlightingCapabilities>operator_doubleArrow(_semanticHighlightingCapabilities, _function_3);
          it_2.setSemanticHighlightingCapabilities(_doubleArrow);
        };
        TextDocumentClientCapabilities _doubleArrow = ObjectExtensions.<TextDocumentClientCapabilities>operator_doubleArrow(_textDocumentClientCapabilities, _function_2);
        it_1.setTextDocument(_doubleArrow);
      };
      ClientCapabilities _doubleArrow = ObjectExtensions.<ClientCapabilities>operator_doubleArrow(_clientCapabilities, _function_1);
      it.setCapabilities(_doubleArrow);
    };
    this.scopes = this.initialize(_function).getCapabilities().getSemanticHighlighting().getScopes();
  }
  
  @Test
  public void testDidOpen() {
    Path _path = this.root.toPath();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MyModel.");
    _builder.append(this.fileExtension);
    final File file = _path.resolve(_builder.toString()).toFile();
    final String uri = this._uriExtensions.toUriString(file.toURI());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type A {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("int a");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("op foo() {}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("op foo(a: A): string {}");
    _builder_1.newLine();
    _builder_1.append("}");
    this.open(uri, _builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("0 : [5:1:[typeDeclaration]]");
    _builder_2.newLine();
    _builder_2.append("1 : [2:3:[primitiveType], 6:1:[identifier]]");
    _builder_2.newLine();
    _builder_2.append("2 : [5:3:[identifier]]");
    _builder_2.newLine();
    _builder_2.append("3 : [5:3:[identifier], 9:1:[parameterName], 12:1:[type], 16:6:[primitiveType]]");
    _builder_2.newLine();
    _builder_2.append("4 : []");
    this.assertInfos(uri, _builder_2.toString());
  }
  
  @Test
  public void testDidOpen_multiLine() {
    Path _path = this.root.toPath();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MyModel.");
    _builder.append(this.fileExtension);
    final File file = _path.resolve(_builder.toString()).toFile();
    final String uri = this._uriExtensions.toUriString(file.toURI());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type A {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("op foo() { ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    this.open(uri, _builder_1.toString());
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("0 : [5:1:[typeDeclaration]]");
    _builder_2.newLine();
    _builder_2.append("1 : [5:3:[identifier], 12:1:[opBody]]");
    _builder_2.newLine();
    _builder_2.append("2 : [0:2:[opBody]]");
    _builder_2.newLine();
    _builder_2.append("3 : [0:4:[opBody]]");
    _builder_2.newLine();
    _builder_2.append("4 : [0:2:[opBody]]");
    _builder_2.newLine();
    _builder_2.append("5 : []");
    this.assertInfos(uri, _builder_2.toString());
  }
  
  @Test
  public void testChange() {
    Path _path = this.root.toPath();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("MyModel.");
    _builder.append(this.fileExtension);
    final File file = _path.resolve(_builder.toString()).toFile();
    final String fileUri = this._uriExtensions.toUriString(file.toURI());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type A {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("int a");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("op foo() {}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("op foo(a: A): string {}");
    _builder_1.newLine();
    _builder_1.append("}");
    this.open(fileUri, _builder_1.toString());
    this.notifications.clear();
    DidChangeTextDocumentParams _didChangeTextDocumentParams = new DidChangeTextDocumentParams();
    final Procedure1<DidChangeTextDocumentParams> _function = (DidChangeTextDocumentParams it) -> {
      VersionedTextDocumentIdentifier _versionedTextDocumentIdentifier = new VersionedTextDocumentIdentifier();
      final Procedure1<VersionedTextDocumentIdentifier> _function_1 = (VersionedTextDocumentIdentifier it_1) -> {
        it_1.setUri(fileUri);
        it_1.setVersion(Integer.valueOf(2));
      };
      VersionedTextDocumentIdentifier _doubleArrow = ObjectExtensions.<VersionedTextDocumentIdentifier>operator_doubleArrow(_versionedTextDocumentIdentifier, _function_1);
      it.setTextDocument(_doubleArrow);
      TextDocumentContentChangeEvent _textDocumentContentChangeEvent = new TextDocumentContentChangeEvent();
      final Procedure1<TextDocumentContentChangeEvent> _function_2 = (TextDocumentContentChangeEvent it_1) -> {
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("type A {");
        _builder_2.newLine();
        _builder_2.append("  ");
        _builder_2.append("int a");
        _builder_2.newLine();
        _builder_2.append("  ");
        _builder_2.append("op foo(a: A): string {}");
        _builder_2.newLine();
        _builder_2.append("}");
        it_1.setText(_builder_2.toString());
        Position _position = new Position(0, 0);
        Position _position_1 = new Position(4, 1);
        Range _range = new Range(_position, _position_1);
        it_1.setRange(_range);
      };
      TextDocumentContentChangeEvent _doubleArrow_1 = ObjectExtensions.<TextDocumentContentChangeEvent>operator_doubleArrow(_textDocumentContentChangeEvent, _function_2);
      it.setContentChanges(Collections.<TextDocumentContentChangeEvent>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEvent>newArrayList(_doubleArrow_1)));
    };
    DidChangeTextDocumentParams _doubleArrow = ObjectExtensions.<DidChangeTextDocumentParams>operator_doubleArrow(_didChangeTextDocumentParams, _function);
    this.languageServer.didChange(_doubleArrow);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("0 : [5:1:[typeDeclaration]]");
    _builder_2.newLine();
    _builder_2.append("1 : [2:3:[primitiveType], 6:1:[identifier]]");
    _builder_2.newLine();
    _builder_2.append("2 : [5:3:[identifier], 9:1:[parameterName], 12:1:[type], 16:6:[primitiveType]]");
    _builder_2.newLine();
    _builder_2.append("3 : []");
    this.assertInfos(fileUri, _builder_2.toString());
    this.notifications.clear();
    DidChangeTextDocumentParams _didChangeTextDocumentParams_1 = new DidChangeTextDocumentParams();
    final Procedure1<DidChangeTextDocumentParams> _function_1 = (DidChangeTextDocumentParams it) -> {
      VersionedTextDocumentIdentifier _versionedTextDocumentIdentifier = new VersionedTextDocumentIdentifier();
      final Procedure1<VersionedTextDocumentIdentifier> _function_2 = (VersionedTextDocumentIdentifier it_1) -> {
        it_1.setUri(fileUri);
        it_1.setVersion(Integer.valueOf(3));
      };
      VersionedTextDocumentIdentifier _doubleArrow_1 = ObjectExtensions.<VersionedTextDocumentIdentifier>operator_doubleArrow(_versionedTextDocumentIdentifier, _function_2);
      it.setTextDocument(_doubleArrow_1);
      TextDocumentContentChangeEvent _textDocumentContentChangeEvent = new TextDocumentContentChangeEvent();
      final Procedure1<TextDocumentContentChangeEvent> _function_3 = (TextDocumentContentChangeEvent it_1) -> {
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("type A {");
        _builder_3.newLine();
        _builder_3.append("  ");
        _builder_3.append("int a");
        _builder_3.newLine();
        _builder_3.append("}");
        it_1.setText(_builder_3.toString());
        Position _position = new Position(0, 0);
        Position _position_1 = new Position(3, 1);
        Range _range = new Range(_position, _position_1);
        it_1.setRange(_range);
      };
      TextDocumentContentChangeEvent _doubleArrow_2 = ObjectExtensions.<TextDocumentContentChangeEvent>operator_doubleArrow(_textDocumentContentChangeEvent, _function_3);
      it.setContentChanges(Collections.<TextDocumentContentChangeEvent>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEvent>newArrayList(_doubleArrow_2)));
    };
    DidChangeTextDocumentParams _doubleArrow_1 = ObjectExtensions.<DidChangeTextDocumentParams>operator_doubleArrow(_didChangeTextDocumentParams_1, _function_1);
    this.languageServer.didChange(_doubleArrow_1);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("0 : [5:1:[typeDeclaration]]");
    _builder_3.newLine();
    _builder_3.append("1 : [2:3:[primitiveType], 6:1:[identifier]]");
    _builder_3.newLine();
    _builder_3.append("2 : []");
    this.assertInfos(fileUri, _builder_3.toString());
    this.notifications.clear();
    DidChangeTextDocumentParams _didChangeTextDocumentParams_2 = new DidChangeTextDocumentParams();
    final Procedure1<DidChangeTextDocumentParams> _function_2 = (DidChangeTextDocumentParams it) -> {
      VersionedTextDocumentIdentifier _versionedTextDocumentIdentifier = new VersionedTextDocumentIdentifier();
      final Procedure1<VersionedTextDocumentIdentifier> _function_3 = (VersionedTextDocumentIdentifier it_1) -> {
        it_1.setUri(fileUri);
        it_1.setVersion(Integer.valueOf(3));
      };
      VersionedTextDocumentIdentifier _doubleArrow_2 = ObjectExtensions.<VersionedTextDocumentIdentifier>operator_doubleArrow(_versionedTextDocumentIdentifier, _function_3);
      it.setTextDocument(_doubleArrow_2);
      TextDocumentContentChangeEvent _textDocumentContentChangeEvent = new TextDocumentContentChangeEvent();
      final Procedure1<TextDocumentContentChangeEvent> _function_4 = (TextDocumentContentChangeEvent it_1) -> {
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("type A {");
        _builder_4.newLine();
        _builder_4.append("  ");
        _builder_4.append("int a");
        _builder_4.newLine();
        _builder_4.append("  ");
        _builder_4.append("op foo() {}");
        _builder_4.newLine();
        _builder_4.append("  ");
        _builder_4.append("op foo(a: A): string {}");
        _builder_4.newLine();
        _builder_4.append("}");
        it_1.setText(_builder_4.toString());
        Position _position = new Position(0, 0);
        Position _position_1 = new Position(2, 1);
        Range _range = new Range(_position, _position_1);
        it_1.setRange(_range);
      };
      TextDocumentContentChangeEvent _doubleArrow_3 = ObjectExtensions.<TextDocumentContentChangeEvent>operator_doubleArrow(_textDocumentContentChangeEvent, _function_4);
      it.setContentChanges(Collections.<TextDocumentContentChangeEvent>unmodifiableList(CollectionLiterals.<TextDocumentContentChangeEvent>newArrayList(_doubleArrow_3)));
    };
    DidChangeTextDocumentParams _doubleArrow_2 = ObjectExtensions.<DidChangeTextDocumentParams>operator_doubleArrow(_didChangeTextDocumentParams_2, _function_2);
    this.languageServer.didChange(_doubleArrow_2);
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("0 : [5:1:[typeDeclaration]]");
    _builder_4.newLine();
    _builder_4.append("1 : [2:3:[primitiveType], 6:1:[identifier]]");
    _builder_4.newLine();
    _builder_4.append("2 : [5:3:[identifier]]");
    _builder_4.newLine();
    _builder_4.append("3 : [5:3:[identifier], 9:1:[parameterName], 12:1:[type], 16:6:[primitiveType]]");
    _builder_4.newLine();
    _builder_4.append("4 : []");
    this.assertInfos(fileUri, _builder_4.toString());
  }
  
  protected void assertInfos(final String uri, final String expected) {
    final Map<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>> params = this.getSemanticHighlightingParams();
    Assert.assertEquals(1, params.size());
    final Function1<Map.Entry<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>>, Boolean> _function = (Map.Entry<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>> it) -> {
      String _uri = it.getKey().getUri();
      return Boolean.valueOf(Objects.equal(_uri, uri));
    };
    final Map.Entry<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>> entry = IterableExtensions.<Map.Entry<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>>>findFirst(params.entrySet(), _function);
    Assert.assertNotNull(entry);
    final Comparator<SemanticHighlightingInformation> _function_1 = (SemanticHighlightingInformation left, SemanticHighlightingInformation right) -> {
      int _line = left.getLine();
      int _line_1 = right.getLine();
      return (_line - _line_1);
    };
    final Function1<SemanticHighlightingInformation, Pair<SemanticHighlightingInformation, List<List<String>>>> _function_2 = (SemanticHighlightingInformation it) -> {
      return Pair.<SemanticHighlightingInformation, List<List<String>>>of(it, this.scopes);
    };
    final Function1<Pair<SemanticHighlightingInformation, List<List<String>>>, String> _function_3 = (Pair<SemanticHighlightingInformation, List<List<String>>> it) -> {
      return this.toExpectation(it);
    };
    final String actual = IterableExtensions.join(ListExtensions.<Pair<SemanticHighlightingInformation, List<List<String>>>, String>map(ListExtensions.<SemanticHighlightingInformation, Pair<SemanticHighlightingInformation, List<List<String>>>>map(IterableExtensions.<SemanticHighlightingInformation>sortWith(entry.getValue(), _function_1), _function_2), _function_3), "\n");
    this.assertEquals(expected, actual);
  }
}
