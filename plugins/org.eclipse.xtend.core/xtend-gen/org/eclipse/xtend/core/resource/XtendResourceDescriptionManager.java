package org.eclipse.xtend.core.resource;

import com.google.inject.Inject;
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

@SuppressWarnings("all")
public class XtendResourceDescriptionManager extends DerivedStateAwareResourceDescriptionManager implements IResourceDescription.Manager.AllChangeAware {
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private IQualifiedNameConverter nameConverter;
  
  public IResourceDescription createResourceDescription(final Resource resource, final IDefaultResourceDescriptionStrategy strategy) {
    IResourceScopeCache _cache = this.getCache();
    return new XtendResourceDescription(resource, strategy, _cache, this.typeResolver, this.nameConverter);
  }
  
  public boolean hasChanges(final IResourceDescription.Delta delta, final IResourceDescription candidate) {
    boolean _or = false;
    boolean _hasChanges = super.hasChanges(delta, candidate);
    if (_hasChanges) {
      _or = true;
    } else {
      boolean _containsActiveAnnotation = this.containsActiveAnnotation(candidate);
      _or = _containsActiveAnnotation;
    }
    return _or;
  }
  
  private boolean containsActiveAnnotation(final IResourceDescription description) {
    Iterable<IEObjectDescription> _exportedObjects = description.getExportedObjects();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription it) {
        String[] _userDataKeys = it.getUserDataKeys();
        return Boolean.valueOf(((List<String>)Conversions.doWrapArray(_userDataKeys)).contains(XtendResourceDescriptionStrategy.ACTIVE_ANNOTATION_TIMESTAMP));
      }
    };
    return IterableExtensions.<IEObjectDescription>exists(_exportedObjects, _function);
  }
  
  public boolean isAffectedByAny(final Collection<IResourceDescription.Delta> deltas, final IResourceDescription candidate, final IResourceDescriptions context) throws IllegalArgumentException {
    return this.isAffected(deltas, candidate, context);
  }
}
