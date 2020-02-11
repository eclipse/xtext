/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
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
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.ProjectWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.util.IFileSystemScanner;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.FileSourceFolder;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests customized version of default methods ISourceFolder#contains(URI) and ISourceFolder#getAllResources(IFileSystemScanner)
 */
@SuppressWarnings("all")
public class SourceFolderCustomImplTest extends AbstractTestLangLanguageServerTest {
  public static class CustomWorkspaceConfigFactory extends ProjectWorkspaceConfigFactory {
    @Override
    public void findProjects(final WorkspaceConfig workspaceConfig, final URI uri) {
      if ((uri != null)) {
        final SourceFolderCustomImplTest.CustomFileProjectConfig project = new SourceFolderCustomImplTest.CustomFileProjectConfig(uri, workspaceConfig);
        project.addSourceFolder(".");
        workspaceConfig.addProject(project);
      }
    }
  }
  
  public static class CustomFileProjectConfig extends FileProjectConfig {
    public CustomFileProjectConfig(final URI uri, final WorkspaceConfig workspaceConfig) {
      super(uri, workspaceConfig);
    }
    
    @Override
    public FileSourceFolder addSourceFolder(final String relativePath) {
      SourceFolderCustomImplTest.CustomFileSourceFolder _xblockexpression = null;
      {
        final SourceFolderCustomImplTest.CustomFileSourceFolder sourceFolder = new SourceFolderCustomImplTest.CustomFileSourceFolder(this, relativePath);
        Set<FileSourceFolder> _sourceFolders = this.getSourceFolders();
        _sourceFolders.add(sourceFolder);
        _xblockexpression = sourceFolder;
      }
      return _xblockexpression;
    }
  }
  
  public static class CustomFileSourceFolder extends FileSourceFolder {
    public CustomFileSourceFolder(final FileProjectConfig parent, final String name) {
      super(parent, name);
    }
    
    public boolean filterTheFile(final URI uri) {
      return uri.toFileString().endsWith("sample.testlang");
    }
    
    @Override
    public boolean contains(final URI uri) {
      boolean _xblockexpression = false;
      {
        boolean _filterTheFile = this.filterTheFile(uri);
        if (_filterTheFile) {
          return false;
        }
        _xblockexpression = super.contains(uri);
      }
      return _xblockexpression;
    }
    
    @Override
    public List<URI> getAllResources(final IFileSystemScanner scanner) {
      final List<URI> allResources = super.getAllResources(scanner);
      final Predicate<URI> _function = (URI uri) -> {
        return this.filterTheFile(uri);
      };
      allResources.removeIf(_function);
      return allResources;
    }
  }
  
  @Inject
  private WorkspaceManager workspaceManager;
  
  @Inject
  private IFileSystemScanner scanner;
  
  /**
   * Asserts that the custom implementation returns not all files of the configured source folder
   */
  @Test
  public void testCustomSourceFolderImplementation() {
    this.writeFile("sample.testlang", "MyContent");
    this.initialize();
    final ProjectManager projectManager = this.workspaceManager.getProjectManager("");
    final Set<? extends ISourceFolder> sourceFolders = projectManager.getProjectConfig().getSourceFolders();
    int _size = sourceFolders.size();
    boolean _equals = (_size == 1);
    Assert.assertTrue(_equals);
    final ISourceFolder sourceFolder = ((ISourceFolder[])Conversions.unwrapArray(sourceFolders, ISourceFolder.class))[0];
    final List<URI> allResources = sourceFolder.getAllResources(this.scanner);
    final Function1<URI, Boolean> _function = (URI uri) -> {
      return Boolean.valueOf(uri.toString().endsWith("test-data/test-project/"));
    };
    Assert.assertTrue(IterableExtensions.<URI>exists(allResources, _function));
    final Function1<URI, Boolean> _function_1 = (URI uri) -> {
      return Boolean.valueOf(uri.toString().endsWith("test-data/test-project/sample.testlang"));
    };
    Assert.assertFalse(IterableExtensions.<URI>exists(allResources, _function_1));
    Assert.assertEquals(allResources.size(), 1);
  }
  
  @Override
  protected com.google.inject.Module getServerModule() {
    final com.google.inject.Module defaultModule = super.getServerModule();
    final com.google.inject.Module customModule = new AbstractModule() {
      @Override
      protected void configure() {
        this.<IWorkspaceConfigFactory>bind(IWorkspaceConfigFactory.class).to(SourceFolderCustomImplTest.CustomWorkspaceConfigFactory.class);
        this.<WorkspaceManager>bind(WorkspaceManager.class).in(Scopes.SINGLETON);
      }
    };
    return Modules2.mixin(defaultModule, customModule);
  }
}
