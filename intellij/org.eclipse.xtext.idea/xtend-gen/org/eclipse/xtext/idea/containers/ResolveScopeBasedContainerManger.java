package org.eclipse.xtext.idea.containers;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.containers.ResolveScopeBasedContainer;
import org.eclipse.xtext.idea.resource.impl.ProjectScopeBasedResourceDescriptions;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.DescriptionAddingContainer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

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
    throw new Error("Unresolved compilation problems:"
      + "\nfindContainer cannot be resolved");
  }
  
  protected ResolveScopeBasedContainer getContainer(final IResourceDescription desc, final boolean withDependencies) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method resolveScope is undefined for the type ResolveScopeBasedContainerManger"
      + "\nThe method project is undefined for the type ResolveScopeBasedContainerManger"
      + "\nfindContainer cannot be resolved");
  }
  
  protected ResolveScopeBasedContainer findContainer(final /* Project */Object project, final URI uri, final boolean withDependencies) {
    throw new Error("Unresolved compilation problems:"
      + "\nfindModule cannot be resolved"
      + "\n!= cannot be resolved"
      + "\ngetModuleWithDependenciesAndLibrariesScope cannot be resolved"
      + "\ngetModuleScope cannot be resolved");
  }
  
  protected /* Module */Object findModule(final /* Project */Object project, final URI uri) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field LocalFileSystem is undefined for the type ResolveScopeBasedContainerManger"
      + "\nThe method or field ModuleUtil is undefined for the type ResolveScopeBasedContainerManger"
      + "\ninstance cannot be resolved"
      + "\nfindFileByPath cannot be resolved"
      + "\n!= cannot be resolved"
      + "\nfindModuleForFile cannot be resolved"
      + "\n!= cannot be resolved"
      + "\nfindModule cannot be resolved");
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
