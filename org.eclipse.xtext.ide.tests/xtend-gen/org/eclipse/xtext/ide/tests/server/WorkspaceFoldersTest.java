/**
 * Copyright (c) 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Scopes;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.eclipse.lsp4j.DidChangeWorkspaceFoldersParams;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.WorkspaceFolder;
import org.eclipse.lsp4j.WorkspaceFoldersChangeEvent;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class WorkspaceFoldersTest extends AbstractTestLangLanguageServerTest {
  @Inject
  @Extension
  private UriExtensions _uriExtensions;
  
  @Inject
  private WorkspaceManager workspaceManager;
  
  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();
  
  @Test
  public void testInitialize() {
    try {
      final File rootFolder1 = this.temporaryFolder.newFolder("root1");
      final File rootFolder2 = this.temporaryFolder.newFolder("root2");
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("type Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Bar bar");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.writeFile(rootFolder1, "one.testlang", _builder);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("type Bar {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("Foo foo");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String twoUri = this.writeFile(rootFolder2, "two.testlang", _builder_1);
      final Procedure1<InitializeParams> _function = (InitializeParams it) -> {
        String _uriString = this._uriExtensions.toUriString(rootFolder1.toURI());
        WorkspaceFolder _workspaceFolder = new WorkspaceFolder(_uriString, "root1");
        String _uriString_1 = this._uriExtensions.toUriString(rootFolder2.toURI());
        WorkspaceFolder _workspaceFolder_1 = new WorkspaceFolder(_uriString_1, "root2");
        it.setWorkspaceFolders(Collections.<WorkspaceFolder>unmodifiableList(CollectionLiterals.<WorkspaceFolder>newArrayList(_workspaceFolder, _workspaceFolder_1)));
      };
      this.initialize(_function);
      Assert.assertEquals(2, this.getDiagnostics().size());
      Assert.assertEquals(1, this.getDiagnostics().get(twoUri).size());
      final Procedure0 _function_1 = () -> {
        DidChangeWorkspaceFoldersParams _didChangeWorkspaceFoldersParams = new DidChangeWorkspaceFoldersParams();
        final Procedure1<DidChangeWorkspaceFoldersParams> _function_2 = (DidChangeWorkspaceFoldersParams it) -> {
          WorkspaceFoldersChangeEvent _workspaceFoldersChangeEvent = new WorkspaceFoldersChangeEvent();
          final Procedure1<WorkspaceFoldersChangeEvent> _function_3 = (WorkspaceFoldersChangeEvent it_1) -> {
            String _uriString = this._uriExtensions.toUriString(rootFolder2.toURI());
            WorkspaceFolder _workspaceFolder = new WorkspaceFolder(_uriString, "root2");
            it_1.setRemoved(Collections.<WorkspaceFolder>unmodifiableList(CollectionLiterals.<WorkspaceFolder>newArrayList(_workspaceFolder)));
          };
          WorkspaceFoldersChangeEvent _doubleArrow = ObjectExtensions.<WorkspaceFoldersChangeEvent>operator_doubleArrow(_workspaceFoldersChangeEvent, _function_3);
          it.setEvent(_doubleArrow);
        };
        DidChangeWorkspaceFoldersParams _doubleArrow = ObjectExtensions.<DidChangeWorkspaceFoldersParams>operator_doubleArrow(_didChangeWorkspaceFoldersParams, _function_2);
        this.languageServer.didChangeWorkspaceFolders(_doubleArrow);
      };
      this.withBuild(_function_1);
      Assert.assertEquals(0, this.getDiagnostics().get(twoUri).size());
      final Procedure0 _function_2 = () -> {
        DidChangeWorkspaceFoldersParams _didChangeWorkspaceFoldersParams = new DidChangeWorkspaceFoldersParams();
        final Procedure1<DidChangeWorkspaceFoldersParams> _function_3 = (DidChangeWorkspaceFoldersParams it) -> {
          WorkspaceFoldersChangeEvent _workspaceFoldersChangeEvent = new WorkspaceFoldersChangeEvent();
          final Procedure1<WorkspaceFoldersChangeEvent> _function_4 = (WorkspaceFoldersChangeEvent it_1) -> {
            String _uriString = this._uriExtensions.toUriString(rootFolder2.toURI());
            WorkspaceFolder _workspaceFolder = new WorkspaceFolder(_uriString, "root2");
            it_1.setAdded(Collections.<WorkspaceFolder>unmodifiableList(CollectionLiterals.<WorkspaceFolder>newArrayList(_workspaceFolder)));
          };
          WorkspaceFoldersChangeEvent _doubleArrow = ObjectExtensions.<WorkspaceFoldersChangeEvent>operator_doubleArrow(_workspaceFoldersChangeEvent, _function_4);
          it.setEvent(_doubleArrow);
        };
        DidChangeWorkspaceFoldersParams _doubleArrow = ObjectExtensions.<DidChangeWorkspaceFoldersParams>operator_doubleArrow(_didChangeWorkspaceFoldersParams, _function_3);
        this.languageServer.didChangeWorkspaceFolders(_doubleArrow);
      };
      this.withBuild(_function_2);
      Assert.assertEquals(1, this.getDiagnostics().get(twoUri).size());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void withBuild(final Procedure0 lambda) {
    try {
      final CompletableFuture<Void> future = new CompletableFuture<Void>();
      final ILanguageServerAccess.IBuildListener _function = new ILanguageServerAccess.IBuildListener() {
        @Override
        public void afterBuild(final List<IResourceDescription.Delta> it) {
          WorkspaceFoldersTest.this.workspaceManager.removeBuildListener(this);
          future.complete(null);
        }
      };
      this.workspaceManager.addBuildListener(_function);
      lambda.apply();
      future.get();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String writeFile(final File root, final String path, final CharSequence contents) {
    try {
      final File file = new File(root, path);
      file.getParentFile().mkdirs();
      file.createNewFile();
      final FileWriter writer = new FileWriter(file);
      writer.write(contents.toString());
      writer.close();
      return this._uriExtensions.toUriString(file.toURI().normalize());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  protected com.google.inject.Module getServerModule() {
    final com.google.inject.Module defaultModule = super.getServerModule();
    final com.google.inject.Module customModule = new AbstractModule() {
      @Override
      protected void configure() {
        this.<WorkspaceManager>bind(WorkspaceManager.class).in(Scopes.SINGLETON);
      }
    };
    return Modules2.mixin(defaultModule, customModule);
  }
}
