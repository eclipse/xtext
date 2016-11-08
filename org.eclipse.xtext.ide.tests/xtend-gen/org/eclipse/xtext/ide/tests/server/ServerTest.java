/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.FileChangeType;
import org.eclipse.lsp4j.FileEvent;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
    Map<String, List<Diagnostic>> _diagnostics = this.getDiagnostics();
    Set<Map.Entry<String, List<Diagnostic>>> _entrySet = _diagnostics.entrySet();
    String _join = IterableExtensions.join(_entrySet, ",");
    Map<String, List<Diagnostic>> _diagnostics_1 = this.getDiagnostics();
    Collection<List<Diagnostic>> _values = _diagnostics_1.values();
    List<Diagnostic> _head = IterableExtensions.<List<Diagnostic>>head(_values);
    boolean _isEmpty = _head.isEmpty();
    Assert.assertTrue(_join, _isEmpty);
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
    Map<String, List<Diagnostic>> _diagnostics = this.getDiagnostics();
    Collection<List<Diagnostic>> _values = _diagnostics.values();
    List<Diagnostic> _head = IterableExtensions.<List<Diagnostic>>head(_values);
    Diagnostic _head_1 = IterableExtensions.<Diagnostic>head(_head);
    String _message = null;
    if (_head_1!=null) {
      _message=_head_1.getMessage();
    }
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message);
    Map<String, List<Diagnostic>> _diagnostics_1 = this.getDiagnostics();
    Collection<List<Diagnostic>> _values_1 = _diagnostics_1.values();
    List<Diagnostic> _head_2 = IterableExtensions.<List<Diagnostic>>head(_values_1);
    Diagnostic _head_3 = IterableExtensions.<Diagnostic>head(_head_2);
    Range _range = _head_3.getRange();
    Position _start = _range.getStart();
    int _line = _start.getLine();
    Assert.assertEquals(1, _line);
    Map<String, List<Diagnostic>> _diagnostics_2 = this.getDiagnostics();
    Collection<List<Diagnostic>> _values_2 = _diagnostics_2.values();
    List<Diagnostic> _head_4 = IterableExtensions.<List<Diagnostic>>head(_values_2);
    Diagnostic _head_5 = IterableExtensions.<Diagnostic>head(_head_4);
    Range _range_1 = _head_5.getRange();
    Position _start_1 = _range_1.getStart();
    int _character = _start_1.getCharacter();
    Assert.assertEquals(4, _character);
    Map<String, List<Diagnostic>> _diagnostics_3 = this.getDiagnostics();
    Collection<List<Diagnostic>> _values_3 = _diagnostics_3.values();
    List<Diagnostic> _head_6 = IterableExtensions.<List<Diagnostic>>head(_values_3);
    Diagnostic _head_7 = IterableExtensions.<Diagnostic>head(_head_6);
    Range _range_2 = _head_7.getRange();
    Position _end = _range_2.getEnd();
    int _line_1 = _end.getLine();
    Assert.assertEquals(1, _line_1);
    Map<String, List<Diagnostic>> _diagnostics_4 = this.getDiagnostics();
    Collection<List<Diagnostic>> _values_4 = _diagnostics_4.values();
    List<Diagnostic> _head_8 = IterableExtensions.<List<Diagnostic>>head(_values_4);
    Diagnostic _head_9 = IterableExtensions.<Diagnostic>head(_head_8);
    Range _range_3 = _head_9.getRange();
    Position _end_1 = _range_3.getEnd();
    int _character_1 = _end_1.getCharacter();
    Assert.assertEquals(15, _character_1);
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
    Map<String, List<Diagnostic>> _diagnostics = this.getDiagnostics();
    Collection<List<Diagnostic>> _values = _diagnostics.values();
    List<Diagnostic> _head = IterableExtensions.<List<Diagnostic>>head(_values);
    Diagnostic _head_1 = IterableExtensions.<Diagnostic>head(_head);
    String _message = _head_1.getMessage();
    this.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message);
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
    Map<String, List<Diagnostic>> _diagnostics_1 = this.getDiagnostics();
    List<Diagnostic> _get = _diagnostics_1.get(path);
    Assert.assertNotNull(_get);
    Map<String, List<Diagnostic>> _diagnostics_2 = this.getDiagnostics();
    Collection<List<Diagnostic>> _values_1 = _diagnostics_2.values();
    String _join = IterableExtensions.join(_values_1, ",");
    Map<String, List<Diagnostic>> _diagnostics_3 = this.getDiagnostics();
    Collection<List<Diagnostic>> _values_2 = _diagnostics_3.values();
    final Function1<List<Diagnostic>, Boolean> _function = (List<Diagnostic> it) -> {
      return Boolean.valueOf(it.isEmpty());
    };
    boolean _forall = IterableExtensions.<List<Diagnostic>>forall(_values_2, _function);
    Assert.assertTrue(_join, _forall);
  }
}
