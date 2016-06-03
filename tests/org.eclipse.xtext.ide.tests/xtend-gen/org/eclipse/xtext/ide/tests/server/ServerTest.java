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
import io.typefox.lsapi.FileEvent;
import io.typefox.lsapi.FileEventImpl;
import io.typefox.lsapi.Position;
import io.typefox.lsapi.Range;
import io.typefox.lsapi.services.WorkspaceService;
import io.typefox.lsapi.util.LsapiFactories;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    this.operator_mappedTo(
      "MyType1.testlang", _builder);
    this.initialize();
    Set<Map.Entry<String, List<? extends Diagnostic>>> _entrySet = this.diagnostics.entrySet();
    String _join = IterableExtensions.join(_entrySet, ",");
    Collection<List<? extends Diagnostic>> _values = this.diagnostics.values();
    List<? extends Diagnostic> _head = IterableExtensions.<List<? extends Diagnostic>>head(_values);
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
    this.operator_mappedTo(
      "MyType1.testlang", _builder);
    this.initialize();
    Collection<List<? extends Diagnostic>> _values = this.diagnostics.values();
    List<? extends Diagnostic> _head = IterableExtensions.<List<? extends Diagnostic>>head(_values);
    Diagnostic _head_1 = IterableExtensions.head(_head);
    String _message = null;
    if (_head_1!=null) {
      _message=_head_1.getMessage();
    }
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message);
    Collection<List<? extends Diagnostic>> _values_1 = this.diagnostics.values();
    List<? extends Diagnostic> _head_2 = IterableExtensions.<List<? extends Diagnostic>>head(_values_1);
    Diagnostic _head_3 = IterableExtensions.head(_head_2);
    Range _range = _head_3.getRange();
    Position _start = _range.getStart();
    int _line = _start.getLine();
    Assert.assertEquals(1, _line);
    Collection<List<? extends Diagnostic>> _values_2 = this.diagnostics.values();
    List<? extends Diagnostic> _head_4 = IterableExtensions.<List<? extends Diagnostic>>head(_values_2);
    Diagnostic _head_5 = IterableExtensions.head(_head_4);
    Range _range_1 = _head_5.getRange();
    Position _start_1 = _range_1.getStart();
    int _character = _start_1.getCharacter();
    Assert.assertEquals(4, _character);
    Collection<List<? extends Diagnostic>> _values_3 = this.diagnostics.values();
    List<? extends Diagnostic> _head_6 = IterableExtensions.<List<? extends Diagnostic>>head(_values_3);
    Diagnostic _head_7 = IterableExtensions.head(_head_6);
    Range _range_2 = _head_7.getRange();
    Position _end = _range_2.getEnd();
    int _line_1 = _end.getLine();
    Assert.assertEquals(1, _line_1);
    Collection<List<? extends Diagnostic>> _values_4 = this.diagnostics.values();
    List<? extends Diagnostic> _head_8 = IterableExtensions.<List<? extends Diagnostic>>head(_values_4);
    Diagnostic _head_9 = IterableExtensions.head(_head_8);
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
    this.operator_mappedTo(
      "MyType1.testlang", _builder);
    this.initialize();
    Collection<List<? extends Diagnostic>> _values = this.diagnostics.values();
    List<? extends Diagnostic> _head = IterableExtensions.<List<? extends Diagnostic>>head(_values);
    Diagnostic _head_1 = IterableExtensions.head(_head);
    String _message = _head_1.getMessage();
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type NonExisting {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String path = this.operator_mappedTo("MyType2.testlang", _builder_1);
    WorkspaceService _workspaceService = this.languageServer.getWorkspaceService();
    FileEventImpl _newFileEvent = LsapiFactories.newFileEvent(path, FileEvent.TYPE_CREATED);
    DidChangeWatchedFilesParamsImpl _newDidChangeWatchedFilesParams = LsapiFactories.newDidChangeWatchedFilesParams(Collections.<FileEventImpl>unmodifiableList(CollectionLiterals.<FileEventImpl>newArrayList(_newFileEvent)));
    _workspaceService.didChangeWatchedFiles(_newDidChangeWatchedFilesParams);
    List<? extends Diagnostic> _get = this.diagnostics.get(path);
    Assert.assertNotNull(_get);
    Collection<List<? extends Diagnostic>> _values_1 = this.diagnostics.values();
    String _join = IterableExtensions.join(_values_1, ",");
    Collection<List<? extends Diagnostic>> _values_2 = this.diagnostics.values();
    final Function1<List<? extends Diagnostic>, Boolean> _function = new Function1<List<? extends Diagnostic>, Boolean>() {
      @Override
      public Boolean apply(final List<? extends Diagnostic> it) {
        return Boolean.valueOf(it.isEmpty());
      }
    };
    boolean _forall = IterableExtensions.<List<? extends Diagnostic>>forall(_values_2, _function);
    Assert.assertTrue(_join, _forall);
  }
}
