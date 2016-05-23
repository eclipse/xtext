/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.inject.Inject;
import com.google.inject.Injector;
import io.typefox.lsapi.Diagnostic;
import io.typefox.lsapi.DidChangeWatchedFilesParamsImpl;
import io.typefox.lsapi.FileEvent;
import io.typefox.lsapi.FileEventImpl;
import io.typefox.lsapi.InitializeParamsImpl;
import io.typefox.lsapi.WorkspaceService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.tests.server.AbstractLanguageServerTest;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageStandaloneSetup;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
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
public class ServerTest extends AbstractLanguageServerTest {
  @Inject
  public Object voidRegisterTestLanguage(final IResourceServiceProvider.Registry registry) {
    Object _xblockexpression = null;
    {
      TestLanguageStandaloneSetup _testLanguageStandaloneSetup = new TestLanguageStandaloneSetup();
      final Injector injector = _testLanguageStandaloneSetup.createInjectorAndDoEMFRegistration();
      Map<String, Object> _extensionToFactoryMap = registry.getExtensionToFactoryMap();
      FileExtensionProvider _instance = injector.<FileExtensionProvider>getInstance(FileExtensionProvider.class);
      String _primaryFileExtension = _instance.getPrimaryFileExtension();
      IResourceServiceProvider _instance_1 = injector.<IResourceServiceProvider>getInstance(IResourceServiceProvider.class);
      _xblockexpression = _extensionToFactoryMap.put(_primaryFileExtension, _instance_1);
    }
    return _xblockexpression;
  }
  
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
    InitializeParamsImpl _initializeParamsImpl = new InitializeParamsImpl();
    final Procedure1<InitializeParamsImpl> _function = new Procedure1<InitializeParamsImpl>() {
      @Override
      public void apply(final InitializeParamsImpl it) {
        String _absolutePath = ServerTest.this.root.getAbsolutePath();
        it.setRootPath(_absolutePath);
      }
    };
    InitializeParamsImpl _doubleArrow = ObjectExtensions.<InitializeParamsImpl>operator_doubleArrow(_initializeParamsImpl, _function);
    this.languageServer.initialize(_doubleArrow);
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
    InitializeParamsImpl _initializeParamsImpl = new InitializeParamsImpl();
    final Procedure1<InitializeParamsImpl> _function = new Procedure1<InitializeParamsImpl>() {
      @Override
      public void apply(final InitializeParamsImpl it) {
        String _absolutePath = ServerTest.this.root.getAbsolutePath();
        it.setRootPath(_absolutePath);
      }
    };
    InitializeParamsImpl _doubleArrow = ObjectExtensions.<InitializeParamsImpl>operator_doubleArrow(_initializeParamsImpl, _function);
    this.languageServer.initialize(_doubleArrow);
    Collection<List<? extends Diagnostic>> _values = this.diagnostics.values();
    List<? extends Diagnostic> _head = IterableExtensions.<List<? extends Diagnostic>>head(_values);
    Diagnostic _head_1 = IterableExtensions.head(_head);
    String _message = null;
    if (_head_1!=null) {
      _message=_head_1.getMessage();
    }
    Assert.assertEquals("Couldn\'t resolve reference to TypeDeclaration \'NonExisting\'.", _message);
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
    InitializeParamsImpl _initializeParamsImpl = new InitializeParamsImpl();
    final Procedure1<InitializeParamsImpl> _function = new Procedure1<InitializeParamsImpl>() {
      @Override
      public void apply(final InitializeParamsImpl it) {
        String _absolutePath = ServerTest.this.root.getAbsolutePath();
        it.setRootPath(_absolutePath);
      }
    };
    InitializeParamsImpl _doubleArrow = ObjectExtensions.<InitializeParamsImpl>operator_doubleArrow(_initializeParamsImpl, _function);
    this.languageServer.initialize(_doubleArrow);
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
    List<? extends Diagnostic> _get = this.diagnostics.get(path);
    Assert.assertNotNull(_get);
    Collection<List<? extends Diagnostic>> _values_1 = this.diagnostics.values();
    String _join = IterableExtensions.join(_values_1, ",");
    Collection<List<? extends Diagnostic>> _values_2 = this.diagnostics.values();
    final Function1<List<? extends Diagnostic>, Boolean> _function_2 = new Function1<List<? extends Diagnostic>, Boolean>() {
      @Override
      public Boolean apply(final List<? extends Diagnostic> it) {
        return Boolean.valueOf(it.isEmpty());
      }
    };
    boolean _forall = IterableExtensions.<List<? extends Diagnostic>>forall(_values_2, _function_2);
    Assert.assertTrue(_join, _forall);
  }
}
