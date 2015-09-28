package org.eclipse.xtext.java.resource;

import com.google.inject.Inject;
import java.util.Collection;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy;
import org.eclipse.xtext.java.resource.JavaResource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class JavaResourceDescriptionManager implements IResourceDescription.Manager {
  @Inject
  private JvmTypesResourceDescriptionStrategy descriptionStrategy;
  
  @Inject
  private IResourceScopeCache cache;
  
  @Override
  public IResourceDescription.Delta createDelta(final IResourceDescription oldDescription, final IResourceDescription newDescription) {
    return new DefaultResourceDescriptionDelta(oldDescription, newDescription);
  }
  
  @Override
  public IResourceDescription getResourceDescription(final Resource resource) {
    if ((resource instanceof JavaResource)) {
      boolean _or = false;
      boolean _isInitialized = ((JavaResource)resource).isInitialized();
      if (_isInitialized) {
        _or = true;
      } else {
        boolean _isInitializing = ((JavaResource)resource).isInitializing();
        _or = _isInitializing;
      }
      final boolean initialized = _or;
      try {
        if ((!initialized)) {
          ((JavaResource)resource).eSetDeliver(false);
          ((JavaResource)resource).installStubs();
        }
        final DefaultResourceDescription result = new DefaultResourceDescription(resource, this.descriptionStrategy, this.cache);
        if ((!initialized)) {
          Iterable<IEObjectDescription> _exportedObjects = result.getExportedObjects();
          final Procedure1<IEObjectDescription> _function = new Procedure1<IEObjectDescription>() {
            @Override
            public void apply(final IEObjectDescription it) {
              it.getEObjectURI();
            }
          };
          IterableExtensions.<IEObjectDescription>forEach(_exportedObjects, _function);
        }
        return result;
      } finally {
        if ((!initialized)) {
          ((JavaResource)resource).discardDerivedState();
          ((JavaResource)resource).eSetDeliver(true);
        }
      }
    }
    throw new IllegalArgumentException("Can only handle JavaResources");
  }
  
  @Override
  public boolean isAffected(final IResourceDescription.Delta delta, final IResourceDescription candidate) throws IllegalArgumentException {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean isAffected(final Collection<IResourceDescription.Delta> deltas, final IResourceDescription candidate, final IResourceDescriptions context) throws IllegalArgumentException {
    Iterable<QualifiedName> _importedNames = candidate.getImportedNames();
    Collection<QualifiedName> importedNames = IterableExtensions.<QualifiedName>toSet(_importedNames);
    for (final IResourceDescription.Delta delta : deltas) {
      boolean _hasChanges = this.hasChanges(delta, candidate);
      if (_hasChanges) {
        boolean _or = false;
        IResourceDescription _new = delta.getNew();
        boolean _isAffected = this.isAffected(importedNames, _new);
        if (_isAffected) {
          _or = true;
        } else {
          IResourceDescription _old = delta.getOld();
          boolean _isAffected_1 = this.isAffected(importedNames, _old);
          _or = _isAffected_1;
        }
        if (_or) {
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * Whether the given delta is considered to have changed from the candidate's perspective. By default this will just call{@link Delta#haveEObjectDescriptionsChanged() Delta#haveEObjectDescriptionsChanged()}.
   * But in some cases even "internal" changes (that are not visible in the EObjectDescriptions) could be interesting.
   * @since 2.7
   */
  protected boolean hasChanges(final IResourceDescription.Delta delta, final IResourceDescription candidate) {
    return delta.haveEObjectDescriptionsChanged();
  }
  
  protected boolean isAffected(final Collection<QualifiedName> importedNames, final IResourceDescription description) {
    if ((description != null)) {
      Iterable<IEObjectDescription> _exportedObjects = description.getExportedObjects();
      for (final IEObjectDescription desc : _exportedObjects) {
        QualifiedName _name = desc.getName();
        QualifiedName _lowerCase = _name.toLowerCase();
        boolean _contains = importedNames.contains(_lowerCase);
        if (_contains) {
          return true;
        }
      }
    }
    return false;
  }
}
