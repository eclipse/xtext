/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.IndexingDataKeys;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.idea.resource.IResourceSetProvider;
import org.eclipse.xtext.idea.resource.IndexingAwareGlobalSearchScope;
import org.eclipse.xtext.idea.resource.ProjectAdapter;
import org.eclipse.xtext.resource.XtextResourceSet;

@Singleton
@SuppressWarnings("all")
public class ProjectBasedResourceSetProvider implements IResourceSetProvider {
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  private Provider<IndexingAwareGlobalSearchScope> globalSearchScopeProvider;
  
  @Override
  public ResourceSet get(final Object context) {
    XtextResourceSet _xblockexpression = null;
    {
      final XtextResourceSet resourceSet = this.resourceSetProvider.get();
      if ((context instanceof Project)) {
        EList<Adapter> _eAdapters = resourceSet.eAdapters();
        ProjectAdapter _projectAdapter = new ProjectAdapter(((Project)context));
        _eAdapters.add(_projectAdapter);
        GlobalSearchScope _allScope = GlobalSearchScope.allScope(((Project)context));
        resourceSet.setClasspathURIContext(_allScope);
      }
      if ((context instanceof Module)) {
        final Project project = ((Module)context).getProject();
        EList<Adapter> _eAdapters_1 = resourceSet.eAdapters();
        ProjectAdapter _projectAdapter_1 = new ProjectAdapter(project);
        _eAdapters_1.add(_projectAdapter_1);
        final IndexingAwareGlobalSearchScope indexingAwareGlobalSearchScope = this.globalSearchScopeProvider.get();
        indexingAwareGlobalSearchScope.setResourceSet(resourceSet);
        GlobalSearchScope _moduleScope = ((Module)context).getModuleScope();
        indexingAwareGlobalSearchScope.setFilterScope(_moduleScope);
        GlobalSearchScope _moduleWithDependenciesAndLibrariesScope = GlobalSearchScope.moduleWithDependenciesAndLibrariesScope(((Module)context));
        indexingAwareGlobalSearchScope.setSearchScope(_moduleWithDependenciesAndLibrariesScope);
        resourceSet.setClasspathURIContext(indexingAwareGlobalSearchScope);
      }
      if ((context instanceof PsiFile)) {
        final Project project_1 = ((PsiFile)context).getProject();
        EList<Adapter> _eAdapters_2 = resourceSet.eAdapters();
        ProjectAdapter _projectAdapter_2 = new ProjectAdapter(project_1);
        _eAdapters_2.add(_projectAdapter_2);
        final IndexingAwareGlobalSearchScope indexingAwareGlobalSearchScope_1 = this.globalSearchScopeProvider.get();
        indexingAwareGlobalSearchScope_1.setResourceSet(resourceSet);
        GlobalSearchScope _filterScope = this.getFilterScope(((PsiFile)context), project_1);
        indexingAwareGlobalSearchScope_1.setFilterScope(_filterScope);
        GlobalSearchScope _resolveScope = ((PsiFile)context).getResolveScope();
        indexingAwareGlobalSearchScope_1.setSearchScope(_resolveScope);
        resourceSet.setClasspathURIContext(indexingAwareGlobalSearchScope_1);
      }
      _xblockexpression = resourceSet;
    }
    return _xblockexpression;
  }
  
  protected GlobalSearchScope getFilterScope(final PsiFile context, final Project project) {
    GlobalSearchScope _xblockexpression = null;
    {
      final VirtualFile virtualFile = this.findVirtualFile(context);
      Module _xifexpression = null;
      boolean _notEquals = (!Objects.equal(virtualFile, null));
      if (_notEquals) {
        _xifexpression = ModuleUtil.findModuleForFile(virtualFile, project);
      }
      final Module module = _xifexpression;
      GlobalSearchScope _xifexpression_1 = null;
      boolean _equals = Objects.equal(module, null);
      if (_equals) {
        _xifexpression_1 = GlobalSearchScope.projectScope(project);
      } else {
        _xifexpression_1 = module.getModuleScope();
      }
      _xblockexpression = _xifexpression_1;
    }
    return _xblockexpression;
  }
  
  protected VirtualFile findVirtualFile(final PsiFile psiFile) {
    VirtualFile _xblockexpression = null;
    {
      final PsiFile originalFile = psiFile.getOriginalFile();
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(originalFile, psiFile));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _notEquals_1 = (!Objects.equal(originalFile, null));
        _and = _notEquals_1;
      }
      if (_and) {
        return this.findVirtualFile(originalFile);
      }
      VirtualFile _elvis = null;
      VirtualFile _userData = psiFile.<VirtualFile>getUserData(IndexingDataKeys.VIRTUAL_FILE);
      if (_userData != null) {
        _elvis = _userData;
      } else {
        FileViewProvider _viewProvider = psiFile.getViewProvider();
        VirtualFile _virtualFile = _viewProvider.getVirtualFile();
        _elvis = _virtualFile;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
}
