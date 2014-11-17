package org.eclipse.xtext.idea.resource.impl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import java.util.ArrayList;
import java.util.Collections;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.resource.AbstractScopeBasedSelectable;
import org.eclipse.xtext.idea.resource.ProjectAdapter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ProjectScopeBasedResourceDescriptions extends AbstractScopeBasedSelectable implements IResourceDescriptions.IContextAware {
  @Accessors(AccessorType.PUBLIC_GETTER)
  private Project project;
  
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
    this.context = ctx;
    Project _project = ProjectAdapter.getProject(ctx);
    this.project = _project;
    boolean _equals = Objects.equal(this.project, null);
    if (_equals) {
      throw new IllegalStateException("project is null");
    }
    GlobalSearchScope _projectScope = GlobalSearchScope.projectScope(this.project);
    this.setScope(_projectScope);
  }
  
  public boolean isIndexing() {
    boolean _xblockexpression = false;
    {
      boolean _isIndexing = this.compilerPhases.isIndexing(this.context);
      if (_isIndexing) {
        return true;
      }
      _xblockexpression = DumbService.isDumb(this.project);
    }
    return _xblockexpression;
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
