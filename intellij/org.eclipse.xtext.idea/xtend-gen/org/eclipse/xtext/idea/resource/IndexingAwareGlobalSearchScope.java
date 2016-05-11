/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.GlobalSearchScope;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.resource.ModuleProvider;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class IndexingAwareGlobalSearchScope extends GlobalSearchScope {
  public static class Factory {
    @Inject
    private Provider<IndexingAwareGlobalSearchScope> provider;
    
    public IndexingAwareGlobalSearchScope createSearchScope(final XtextResourceSet resourceSet) {
      final IndexingAwareGlobalSearchScope indexingAwareGlobalSearchScope = this.provider.get();
      indexingAwareGlobalSearchScope.resourceSet = resourceSet;
      final Module context = ModuleProvider.findModule(resourceSet);
      GlobalSearchScope _moduleScope = context.getModuleScope();
      indexingAwareGlobalSearchScope.filterScope = _moduleScope;
      GlobalSearchScope _moduleWithDependenciesAndLibrariesScope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(context);
      indexingAwareGlobalSearchScope.searchScope = _moduleWithDependenciesAndLibrariesScope;
      return indexingAwareGlobalSearchScope;
    }
  }
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private ResourceSet resourceSet;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private GlobalSearchScope filterScope;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private GlobalSearchScope searchScope;
  
  @Inject
  private CompilerPhases compilerPhases;
  
  @Override
  public Project getProject() {
    return this.searchScope.getProject();
  }
  
  @Override
  public int compare(final VirtualFile file1, final VirtualFile file2) {
    return this.searchScope.compare(file1, file2);
  }
  
  @Override
  public boolean contains(final VirtualFile file) {
    boolean _xblockexpression = false;
    {
      if ((this.compilerPhases.isIndexing(this.resourceSet) && this.filterScope.contains(file))) {
        return false;
      }
      _xblockexpression = this.searchScope.contains(file);
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean isSearchInLibraries() {
    return this.searchScope.isSearchInLibraries();
  }
  
  @Override
  public boolean isSearchInModuleContent(final Module aModule) {
    boolean _xblockexpression = false;
    {
      if ((this.compilerPhases.isIndexing(this.resourceSet) && this.filterScope.isSearchInModuleContent(aModule))) {
        return false;
      }
      _xblockexpression = this.searchScope.isSearchInModuleContent(aModule);
    }
    return _xblockexpression;
  }
  
  public void setResourceSet(final ResourceSet resourceSet) {
    this.resourceSet = resourceSet;
  }
  
  public void setFilterScope(final GlobalSearchScope filterScope) {
    this.filterScope = filterScope;
  }
  
  public void setSearchScope(final GlobalSearchScope searchScope) {
    this.searchScope = searchScope;
  }
}
