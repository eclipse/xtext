/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.MultiProjectWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.ide.server.concurrent.RequestManager;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class MultiProjectTest {
  private File project0;
  
  private File project1;
  
  private Map<URI, List<Issue>> diagnostics = CollectionLiterals.<URI, List<Issue>>newHashMap();
  
  @Inject
  private WorkspaceManager workspaceManager;
  
  @Test
  public void testCrossProjectLink() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type Foo {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("Bar bar");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final URI foo = this.createFile(this.project0, "Foo.testlang", _builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("type Bar {");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final URI bar = this.createFile(this.project1, "Bar.testlang", _builder_1);
    List<URI> _emptyList = CollectionLiterals.<URI>emptyList();
    this.workspaceManager.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(foo, bar)), _emptyList, CancelIndicator.NullImpl);
    int _size = this.diagnostics.size();
    Assert.assertEquals(2, _size);
    List<Issue> _get = this.diagnostics.get(foo);
    int _size_1 = _get.size();
    Assert.assertEquals(1, _size_1);
    List<Issue> _get_1 = this.diagnostics.get(foo);
    Issue _head = IterableExtensions.<Issue>head(_get_1);
    String _code = _head.getCode();
    Assert.assertEquals(Diagnostic.LINKING_DIAGNOSTIC, _code);
    List<Issue> _get_2 = this.diagnostics.get(bar);
    boolean _isEmpty = _get_2.isEmpty();
    Assert.assertTrue(_isEmpty);
    this.diagnostics.clear();
    String _name = this.project0.getName();
    ProjectManager _projectManager = this.workspaceManager.getProjectManager(_name);
    ProjectDescription _projectDescription = _projectManager.getProjectDescription();
    List<String> _dependencies = _projectDescription.getDependencies();
    String _name_1 = this.project1.getName();
    _dependencies.add(_name_1);
    List<URI> _emptyList_1 = CollectionLiterals.<URI>emptyList();
    this.workspaceManager.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(foo, bar)), _emptyList_1, CancelIndicator.NullImpl);
    int _size_2 = this.diagnostics.size();
    Assert.assertEquals(2, _size_2);
    List<Issue> _get_3 = this.diagnostics.get(foo);
    boolean _isEmpty_1 = _get_3.isEmpty();
    Assert.assertTrue(_isEmpty_1);
    List<Issue> _get_4 = this.diagnostics.get(bar);
    boolean _isEmpty_2 = _get_4.isEmpty();
    Assert.assertTrue(_isEmpty_2);
  }
  
  @Before
  public void setup() {
    ServerModule _serverModule = new ServerModule();
    Module _mixin = Modules2.mixin(_serverModule, new AbstractModule() {
      @Override
      protected void configure() {
        AnnotatedBindingBuilder<IWorkspaceConfigFactory> _bind = this.<IWorkspaceConfigFactory>bind(IWorkspaceConfigFactory.class);
        _bind.to(MultiProjectWorkspaceConfigFactory.class);
        AnnotatedBindingBuilder<RequestManager> _bind_1 = this.<RequestManager>bind(RequestManager.class);
        _bind_1.toInstance(new RequestManager() {
          @Override
          public <V extends Object> CompletableFuture<V> runWrite(final Function1<? super CancelIndicator, ? extends V> writeRequest) {
            final CancelIndicator _function = () -> {
              return false;
            };
            V _apply = writeRequest.apply(_function);
            return CompletableFuture.<V>completedFuture(_apply);
          }
          
          @Override
          public <V extends Object> CompletableFuture<V> runRead(final Function1<? super CancelIndicator, ? extends V> readRequest) {
            final CancelIndicator _function = () -> {
              return false;
            };
            V _apply = readRequest.apply(_function);
            return CompletableFuture.<V>completedFuture(_apply);
          }
        });
      }
    });
    final Injector injector = Guice.createInjector(_mixin);
    injector.injectMembers(this);
    final File workspaceRoot = this.getRoot("test-data");
    File _file = new File(workspaceRoot, "test-project0");
    this.project0 = _file;
    File _file_1 = new File(workspaceRoot, "test-project1");
    this.project1 = _file_1;
    this.project0.mkdir();
    this.project1.mkdir();
    String _absolutePath = workspaceRoot.getAbsolutePath();
    URI _createFileURI = URI.createFileURI(_absolutePath);
    final Procedure2<URI, Iterable<Issue>> _function = (URI $0, Iterable<Issue> $1) -> {
      List<Issue> _list = IterableExtensions.<Issue>toList($1);
      this.diagnostics.put($0, _list);
    };
    this.workspaceManager.initialize(_createFileURI, _function, null);
  }
  
  protected File getRoot(final String path) {
    try {
      File _xblockexpression = null;
      {
        final File root = new File(path);
        boolean _mkdirs = root.mkdirs();
        boolean _not = (!_mkdirs);
        if (_not) {
          Files.cleanFolder(root, null, true, false);
        }
        root.deleteOnExit();
        _xblockexpression = root;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public URI createFile(final File root, final String path, final CharSequence contents) {
    try {
      final File file = new File(root, path);
      File _parentFile = file.getParentFile();
      _parentFile.mkdirs();
      file.createNewFile();
      FileWriter _fileWriter = new FileWriter(file);
      final Procedure1<FileWriter> _function = (FileWriter it) -> {
        try {
          String _string = contents.toString();
          it.write(_string);
          it.close();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ObjectExtensions.<FileWriter>operator_doubleArrow(_fileWriter, _function);
      String _absolutePath = file.getAbsolutePath();
      return URI.createFileURI(_absolutePath);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
