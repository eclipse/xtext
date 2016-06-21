package org.eclipse.xtext.java.resource;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.function.Consumer;
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
      final boolean initialized = (((JavaResource)resource).isInitialized() || ((JavaResource)resource).isInitializing());
      try {
        if ((!initialized)) {
          ((JavaResource)resource).eSetDeliver(false);
          ((JavaResource)resource).installStubs();
        }
        final DefaultResourceDescription result = new DefaultResourceDescription(resource, this.descriptionStrategy, this.cache);
        if ((!initialized)) {
          Iterable<IEObjectDescription> _exportedObjects = result.getExportedObjects();
          final Consumer<IEObjectDescription> _function = (IEObjectDescription it) -> {
            it.getEObjectURI();
          };
          _exportedObjects.forEach(_function);
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
        if ((this.isAffected(importedNames, delta.getNew()) || this.isAffected(importedNames, delta.getOld()))) {
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
