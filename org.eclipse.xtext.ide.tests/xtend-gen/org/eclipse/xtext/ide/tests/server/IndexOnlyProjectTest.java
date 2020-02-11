/**
 * Copyright (c) 2019 NumberFour AG (http://www.enfore.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import java.io.File;
import java.util.Collections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.FileChangeType;
import org.eclipse.lsp4j.FileEvent;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.ProjectWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.testing.ReferenceTestConfiguration;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

/**
 * Checks functionality of method IProjectConfig#isIndexOnly()
 * 
 * @author Marcus Mews - Initial contribution and API
 */
@SuppressWarnings("all")
public class IndexOnlyProjectTest extends AbstractTestLangLanguageServerTest {
  @Override
  public com.google.inject.Module getServerModule() {
    ServerModule _serverModule = new ServerModule();
    final com.google.inject.Module _function = (Binder it) -> {
      AnnotatedBindingBuilder<IWorkspaceConfigFactory> _bind = it.<IWorkspaceConfigFactory>bind(IWorkspaceConfigFactory.class);
      _bind.toInstance(new ProjectWorkspaceConfigFactory() {
        @Override
        public void findProjects(final WorkspaceConfig workspaceConfig, final URI location) {
          if ((location != null)) {
            final FileProjectConfig project = new FileProjectConfig(location, workspaceConfig) {
              @Override
              public boolean isIndexOnly() {
                return true;
              }
            };
            project.addSourceFolder(".");
            workspaceConfig.addProject(project);
          }
        }
      });
    };
    return Modules2.mixin(_serverModule, _function);
  }
  
  /**
   * Shows that the resource is indexed
   */
  @Test
  public void testIndexByUsingReferences() {
    final Procedure1<ReferenceTestConfiguration> _function = (ReferenceTestConfiguration it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {}");
      _builder.newLine();
      _builder.append("type Bar {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Foo foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      it.setModel(_builder.toString());
      it.setColumn("type F".length());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("MyModel.testlang [[2, 1] .. [2, 4]]");
      _builder_1.newLine();
      it.setExpectedReferences(_builder_1.toString());
    };
    this.testReferences(_function);
  }
  
  /**
   * Shows that the resource is not validated during initial build
   */
  @Test
  public void testInitializeBuildNoValidation() {
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
    Assert.assertTrue(IterableExtensions.join(this.getDiagnostics().entrySet(), ","), this.getDiagnostics().isEmpty());
  }
  
  /**
   * Shows that the error-free resource is not generated during initial build
   */
  @Test
  public void testInitializeBuildNoGeneration() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("type TestType {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("int foo");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.writeFile("MyType1.testlang", _builder);
    this.initialize();
    final File outputFile = new File(this.root, "src-gen/TestType.java");
    Assert.assertFalse(IterableExtensions.join(this.getDiagnostics().entrySet(), ","), outputFile.isFile());
  }
  
  /**
   * Shows that the resource is not validated during incremental build
   */
  @Test
  public void testIncrementalBuildNoValidation() {
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
    Assert.assertTrue(IterableExtensions.join(this.getDiagnostics().entrySet(), ","), this.getDiagnostics().isEmpty());
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
    Assert.assertTrue(IterableExtensions.join(this.getDiagnostics().entrySet(), ","), this.getDiagnostics().isEmpty());
  }
}
