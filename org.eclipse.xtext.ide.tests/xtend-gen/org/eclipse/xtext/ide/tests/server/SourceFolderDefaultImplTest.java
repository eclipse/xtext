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
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.ide.tests.server.AbstractTestLangLanguageServerTest;
import org.eclipse.xtext.util.IFileSystemScanner;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests default methods ISourceFolder#contains(URI) and ISourceFolder#getAllResources(IFileSystemScanner)
 */
@SuppressWarnings("all")
public class SourceFolderDefaultImplTest extends AbstractTestLangLanguageServerTest {
  @Inject
  private WorkspaceManager workspaceManager;
  
  @Inject
  private IFileSystemScanner scanner;
  
  /**
   * Asserts that the default implementation returns all files in the configured source folder
   */
  @Test
  public void testDefaultSourceFolderImplementation() {
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
    Assert.assertTrue(IterableExtensions.<URI>exists(allResources, _function_1));
    Assert.assertEquals(allResources.size(), 2);
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
