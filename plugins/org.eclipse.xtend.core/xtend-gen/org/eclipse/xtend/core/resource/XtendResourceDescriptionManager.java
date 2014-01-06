package org.eclipse.xtend.core.resource;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.resource.XtendResourceDescription;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

@SuppressWarnings("all")
public class XtendResourceDescriptionManager extends DerivedStateAwareResourceDescriptionManager {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private IQualifiedNameConverter nameConverter;
  
  public IResourceDescription createResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy) {
    IResourceScopeCache _cache = this.getCache();
    return new XtendResourceDescription(resource, strategy, _cache, this.typeResolver, this.nameConverter);
  }
}
