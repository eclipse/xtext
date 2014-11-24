package org.eclipse.xtext.idea.resource.impl;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.resource.AbstractScopeBasedSelectable;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ProjectScopeBasedResourceDescriptions extends AbstractScopeBasedSelectable implements IResourceDescriptions.IContextAware {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private /* Project */Object project;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private Notifier context;
  
  @Inject
  private CompilerPhases compilerPhases;
  
  public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName qualifiedName, final boolean ignoreCase) {
    Iterable<IEObjectDescription> _xblockexpression = null;
    {
      boolean _isIndexing = this.isIndexing();
      if (_isIndexing) {
        return Collections.<IEObjectDescription>emptyList();
      }
      _xblockexpression = super.getExportedObjects(type, qualifiedName, ignoreCase);
    }
    return _xblockexpression;
  }
  
  public IResourceDescription getResourceDescription(final URI uri) {
    IResourceDescription _xblockexpression = null;
    {
      boolean _isIndexing = this.isIndexing();
      if (_isIndexing) {
        return null;
      }
      _xblockexpression = super.getResourceDescription(uri);
    }
    return _xblockexpression;
  }
  
  public Iterable<IResourceDescription> getAllResourceDescriptions() {
    ArrayList<IResourceDescription> _xblockexpression = null;
    {
      boolean _isIndexing = this.isIndexing();
      if (_isIndexing) {
        return null;
      }
      _xblockexpression = super.getResourceDescriptions();
    }
    return _xblockexpression;
  }
  
  public void setContext(final Notifier ctx) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getProject is undefined for the type ProjectScopeBasedResourceDescriptions"
      + "\nThe method or field GlobalSearchScope is undefined for the type ProjectScopeBasedResourceDescriptions"
      + "\n== cannot be resolved"
      + "\nprojectScope cannot be resolved");
  }
  
  public boolean isIndexing() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field DumbService is undefined for the type ProjectScopeBasedResourceDescriptions"
      + "\nisDumb cannot be resolved");
  }
  
  @Pure
  public Project getProject() {
    return this.project;
  }
  
  @Pure
  public Notifier getContext() {
    return this.context;
  }
}
