/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.MultiProjectWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
    this.workspaceManager.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(foo, bar)), CollectionLiterals.<URI>emptyList(), CancelIndicator.NullImpl);
    Assert.assertEquals(2, this.diagnostics.size());
    Assert.assertEquals(1, this.diagnostics.get(foo).size());
    Assert.assertEquals(Diagnostic.LINKING_DIAGNOSTIC, IterableExtensions.<Issue>head(this.diagnostics.get(foo)).getCode());
    Assert.assertTrue(this.diagnostics.get(bar).isEmpty());
    this.diagnostics.clear();
    List<String> _dependencies = this.workspaceManager.getProjectManager(this.project0.getName()).getProjectDescription().getDependencies();
    String _name = this.project1.getName();
    _dependencies.add(_name);
    this.workspaceManager.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(foo, bar)), CollectionLiterals.<URI>emptyList(), CancelIndicator.NullImpl);
    Assert.assertEquals(2, this.diagnostics.size());
    Assert.assertTrue(this.diagnostics.get(foo).isEmpty());
    Assert.assertTrue(this.diagnostics.get(bar).isEmpty());
  }
  
  @Before
  public void setup() {
    ServerModule _serverModule = new ServerModule();
    final Injector injector = Guice.createInjector(Modules2.mixin(_serverModule, new AbstractModule() {
      @Override
      protected void configure() {
        this.<IWorkspaceConfigFactory>bind(IWorkspaceConfigFactory.class).to(MultiProjectWorkspaceConfigFactory.class);
      }
    }));
    injector.injectMembers(this);
    final File workspaceRoot = this.getRoot("test-data");
    File _file = new File(workspaceRoot, "test-project0");
    this.project0 = _file;
    File _file_1 = new File(workspaceRoot, "test-project1");
    this.project1 = _file_1;
    this.project0.mkdir();
    this.project1.mkdir();
    final Procedure2<URI, Iterable<Issue>> _function = (URI $0, Iterable<Issue> $1) -> {
      this.diagnostics.put($0, IterableExtensions.<Issue>toList($1));
    };
    this.workspaceManager.initialize(URI.createFileURI(workspaceRoot.getAbsolutePath()), _function, null);
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
      file.getParentFile().mkdirs();
      file.createNewFile();
      FileWriter _fileWriter = new FileWriter(file);
      final Procedure1<FileWriter> _function = (FileWriter it) -> {
        try {
          it.write(contents.toString());
          it.close();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ObjectExtensions.<FileWriter>operator_doubleArrow(_fileWriter, _function);
      return URI.createFileURI(file.getAbsolutePath());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
