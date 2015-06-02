/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.inject.Inject;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.GlobalSearchScope;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.resource.CompilerPhases;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class IndexingAwareGlobalSearchScope extends GlobalSearchScope {
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
      boolean _and = false;
      boolean _isIndexing = this.compilerPhases.isIndexing(this.resourceSet);
      if (!_isIndexing) {
        _and = false;
      } else {
        boolean _contains = this.filterScope.contains(file);
        _and = _contains;
      }
      if (_and) {
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
      boolean _and = false;
      boolean _isIndexing = this.compilerPhases.isIndexing(this.resourceSet);
      if (!_isIndexing) {
        _and = false;
      } else {
        boolean _isSearchInModuleContent = this.filterScope.isSearchInModuleContent(aModule);
        _and = _isSearchInModuleContent;
      }
      if (_and) {
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
