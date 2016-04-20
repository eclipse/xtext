package org.eclipse.xtend.core.resource;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.resource.XtendResourceDescription;
import org.eclipse.xtend.core.resource.XtendResourceDescriptionStrategy;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

@Singleton
@SuppressWarnings("all")
public class XtendResourceDescriptionManager extends DerivedStateAwareResourceDescriptionManager implements IResourceDescription.Manager.AllChangeAware {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private IQualifiedNameConverter nameConverter;
  
  @Override
  public IResourceDescription createResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy) {
    IResourceScopeCache _cache = this.getCache();
    return new XtendResourceDescription(resource, strategy, _cache, this.typeResolver, this.nameConverter);
  }
  
  @Override
  public boolean hasChanges(final IResourceDescription.Delta delta, final IResourceDescription candidate) {
    return (super.hasChanges(delta, candidate) || this.containsActiveAnnotation(candidate));
  }
  
  private boolean containsActiveAnnotation(final IResourceDescription description) {
    Iterable<IEObjectDescription> _exportedObjects = description.getExportedObjects();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      @Override
      public Boolean apply(final IEObjectDescription it) {
        String[] _userDataKeys = it.getUserDataKeys();
        return Boolean.valueOf(((List<String>)Conversions.doWrapArray(_userDataKeys)).contains(XtendResourceDescriptionStrategy.ACTIVE_ANNOTATION_TIMESTAMP));
      }
    };
    return IterableExtensions.<IEObjectDescription>exists(_exportedObjects, _function);
  }
  
  /**
   * When an annotation processor changes, even if it is just its implementation, the downstream classes should be rebuilt. That is why we are interested even in
   * deltas that have no changed EObjectDescriptions
   */
  @Override
  public boolean isAffectedByAny(final Collection<IResourceDescription.Delta> deltas, final IResourceDescription candidate, final IResourceDescriptions context) throws IllegalArgumentException {
    return this.isAffected(deltas, candidate, context);
  }
}
