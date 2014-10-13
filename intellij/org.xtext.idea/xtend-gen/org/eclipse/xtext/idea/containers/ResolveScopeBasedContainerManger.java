package org.eclipse.xtext.idea.containers;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.search.GlobalSearchScope;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.containers.ResolveScopeBasedContainer;
import org.eclipse.xtext.idea.resource.impl.ProjectScopeBasedResourceDescriptions;
import org.eclipse.xtext.idea.resource.impl.PsiFileBasedResourceDescription;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.DescriptionAddingContainer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ResolveScopeBasedContainerManger implements IContainer.Manager {
  @Inject
  private Provider<ResolveScopeBasedContainer> resolveScopeBasedContainerProvider;
  
  public List<IContainer> getVisibleContainers(final IResourceDescription desc, final IResourceDescriptions resourceDescriptions) {
    IContainer _container = this.getContainer(desc, resourceDescriptions, true);
    return Collections.<IContainer>unmodifiableList(CollectionLiterals.<IContainer>newArrayList(_container));
  }
  
  public IContainer getContainer(final IResourceDescription desc, final IResourceDescriptions resourceDescriptions) {
    return this.getContainer(desc, resourceDescriptions, false);
  }
  
  protected IContainer getContainer(final IResourceDescription desc, final IResourceDescriptions resourceDescriptions, final boolean withDependencies) {
    ResolveScopeBasedContainer _xblockexpression = null;
    {
      boolean _isIndexing = this.isIndexing(resourceDescriptions);
      if (_isIndexing) {
        return IContainer.NULL_CONTAINER;
      }
      ResolveScopeBasedContainer _elvis = null;
      ResolveScopeBasedContainer _container = this.getContainer(desc, withDependencies);
      if (_container != null) {
        _elvis = _container;
      } else {
        URI _uRI = desc.getURI();
        ResolveScopeBasedContainer _findContainer = this.findContainer(resourceDescriptions, _uRI, withDependencies);
        _elvis = _findContainer;
      }
      final ResolveScopeBasedContainer container = _elvis;
      boolean _equals = Objects.equal(container, null);
      if (_equals) {
        return IContainer.NULL_CONTAINER;
      }
      URI _uRI_1 = desc.getURI();
      boolean _hasResourceDescription = container.hasResourceDescription(_uRI_1);
      boolean _not = (!_hasResourceDescription);
      if (_not) {
        return new DescriptionAddingContainer(desc, container);
      }
      _xblockexpression = container;
    }
    return _xblockexpression;
  }
  
  protected ResolveScopeBasedContainer findContainer(final IResourceDescriptions resourceDescriptions, final URI uri, final boolean withDependencies) {
    ResolveScopeBasedContainer _xifexpression = null;
    if ((resourceDescriptions instanceof ProjectScopeBasedResourceDescriptions)) {
      ResolveScopeBasedContainer _xblockexpression = null;
      {
        IResourceDescription _resourceDescription = ((ProjectScopeBasedResourceDescriptions)resourceDescriptions).getResourceDescription(uri);
        final ResolveScopeBasedContainer container = this.getContainer(_resourceDescription, withDependencies);
        boolean _notEquals = (!Objects.equal(container, null));
        if (_notEquals) {
          return container;
        }
        Project _project = ((ProjectScopeBasedResourceDescriptions)resourceDescriptions).getProject();
        _xblockexpression = this.findContainer(_project, uri, withDependencies);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  protected ResolveScopeBasedContainer getContainer(final IResourceDescription desc, final boolean withDependencies) {
    ResolveScopeBasedContainer _xifexpression = null;
    if ((desc instanceof PsiFileBasedResourceDescription)) {
      ResolveScopeBasedContainer _xifexpression_1 = null;
      if (withDependencies) {
        ResolveScopeBasedContainer _get = this.resolveScopeBasedContainerProvider.get();
        final Procedure1<ResolveScopeBasedContainer> _function = new Procedure1<ResolveScopeBasedContainer>() {
          public void apply(final ResolveScopeBasedContainer it) {
            BaseXtextFile _xtextFile = ((PsiFileBasedResourceDescription)desc).getXtextFile();
            GlobalSearchScope _resolveScope = _xtextFile.getResolveScope();
            it.setScope(_resolveScope);
          }
        };
        return ObjectExtensions.<ResolveScopeBasedContainer>operator_doubleArrow(_get, _function);
      } else {
        BaseXtextFile _xtextFile = ((PsiFileBasedResourceDescription)desc).getXtextFile();
        Project _project = _xtextFile.getProject();
        URI _uRI = ((PsiFileBasedResourceDescription)desc).getURI();
        _xifexpression_1 = this.findContainer(_project, _uRI, withDependencies);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  protected ResolveScopeBasedContainer findContainer(final Project project, final URI uri, final boolean withDependencies) {
    ResolveScopeBasedContainer _xblockexpression = null;
    {
      final Module module = this.findModule(project, uri);
      ResolveScopeBasedContainer _xifexpression = null;
      boolean _notEquals = (!Objects.equal(module, null));
      if (_notEquals) {
        ResolveScopeBasedContainer _get = this.resolveScopeBasedContainerProvider.get();
        final Procedure1<ResolveScopeBasedContainer> _function = new Procedure1<ResolveScopeBasedContainer>() {
          public void apply(final ResolveScopeBasedContainer it) {
            GlobalSearchScope _xifexpression = null;
            if (withDependencies) {
              _xifexpression = module.getModuleWithDependenciesAndLibrariesScope(true);
            } else {
              _xifexpression = module.getModuleScope(true);
            }
            it.setScope(_xifexpression);
          }
        };
        _xifexpression = ObjectExtensions.<ResolveScopeBasedContainer>operator_doubleArrow(_get, _function);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected Module findModule(final Project project, final URI uri) {
    Module _xblockexpression = null;
    {
      int _segmentCount = uri.segmentCount();
      boolean _equals = (_segmentCount == 0);
      if (_equals) {
        return null;
      }
      LocalFileSystem _instance = LocalFileSystem.getInstance();
      String _path = uri.path();
      final VirtualFile virtualFile = _instance.findFileByPath(_path);
      boolean _notEquals = (!Objects.equal(virtualFile, null));
      if (_notEquals) {
        final Module module = ModuleUtil.findModuleForFile(virtualFile, project);
        boolean _notEquals_1 = (!Objects.equal(module, null));
        if (_notEquals_1) {
          return module;
        }
      }
      URI _trimSegments = uri.trimSegments(1);
      _xblockexpression = this.findModule(project, _trimSegments);
    }
    return _xblockexpression;
  }
  
  protected boolean isIndexing(final IResourceDescriptions resourceDescriptions) {
    boolean _xifexpression = false;
    if ((resourceDescriptions instanceof ProjectScopeBasedResourceDescriptions)) {
      return ((ProjectScopeBasedResourceDescriptions)resourceDescriptions).isIndexing();
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
}
