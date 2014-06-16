package org.eclipse.xtend.ide.builder;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class FilteringResourceDescriptions implements IResourceDescriptions {
  private final IResourceDescriptions _delegate;
  
  private final Function1<? super URI, ? extends Boolean> _filter;
  
  public Iterable<IResourceDescription> getAllResourceDescriptions() {
    IResourceDescriptions _delegate = this.getDelegate();
    Iterable<IResourceDescription> _allResourceDescriptions = _delegate.getAllResourceDescriptions();
    final Function1<IResourceDescription, Boolean> _function = new Function1<IResourceDescription, Boolean>() {
      public Boolean apply(final IResourceDescription it) {
        URI _uRI = it.getURI();
        return Boolean.valueOf(FilteringResourceDescriptions.this.isContainedUri(_uRI));
      }
    };
    return IterableExtensions.<IResourceDescription>filter(_allResourceDescriptions, _function);
  }
  
  public IResourceDescription getResourceDescription(final URI normalizedURI) {
    boolean _isContainedUri = this.isContainedUri(normalizedURI);
    if (_isContainedUri) {
      IResourceDescriptions _delegate = this.getDelegate();
      return _delegate.getResourceDescription(normalizedURI);
    }
    return null;
  }
  
  private boolean isContainedUri(final URI uri) {
    Function1<? super URI, ? extends Boolean> _filter = this.getFilter();
    return (_filter.apply(uri)).booleanValue();
  }
  
  public Iterable<IEObjectDescription> getExportedObjects() {
    IResourceDescriptions _delegate = this.getDelegate();
    Iterable<IEObjectDescription> _exportedObjects = _delegate.getExportedObjects();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return Boolean.valueOf(FilteringResourceDescriptions.this.isContainedUri(_eObjectURI));
      }
    };
    return IterableExtensions.<IEObjectDescription>filter(_exportedObjects, _function);
  }
  
  public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name, final boolean ignoreCase) {
    IResourceDescriptions _delegate = this.getDelegate();
    Iterable<IEObjectDescription> _exportedObjects = _delegate.getExportedObjects(type, name, ignoreCase);
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return Boolean.valueOf(FilteringResourceDescriptions.this.isContainedUri(_eObjectURI));
      }
    };
    return IterableExtensions.<IEObjectDescription>filter(_exportedObjects, _function);
  }
  
  public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
    IResourceDescriptions _delegate = this.getDelegate();
    Iterable<IEObjectDescription> _exportedObjectsByObject = _delegate.getExportedObjectsByObject(object);
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return Boolean.valueOf(FilteringResourceDescriptions.this.isContainedUri(_eObjectURI));
      }
    };
    return IterableExtensions.<IEObjectDescription>filter(_exportedObjectsByObject, _function);
  }
  
  public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
    IResourceDescriptions _delegate = this.getDelegate();
    Iterable<IEObjectDescription> _exportedObjectsByType = _delegate.getExportedObjectsByType(type);
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return Boolean.valueOf(FilteringResourceDescriptions.this.isContainedUri(_eObjectURI));
      }
    };
    return IterableExtensions.<IEObjectDescription>filter(_exportedObjectsByType, _function);
  }
  
  public boolean isEmpty() {
    IResourceDescriptions _delegate = this.getDelegate();
    return _delegate.isEmpty();
  }
  
  public FilteringResourceDescriptions(final IResourceDescriptions delegate, final Function1<? super URI, ? extends Boolean> filter) {
    super();
    this._delegate = delegate;
    this._filter = filter;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._delegate== null) ? 0 : this._delegate.hashCode());
    result = prime * result + ((this._filter== null) ? 0 : this._filter.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FilteringResourceDescriptions other = (FilteringResourceDescriptions) obj;
    if (this._delegate == null) {
      if (other._delegate != null)
        return false;
    } else if (!this._delegate.equals(other._delegate))
      return false;
    if (this._filter == null) {
      if (other._filter != null)
        return false;
    } else if (!this._filter.equals(other._filter))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
  
  @Pure
  public IResourceDescriptions getDelegate() {
    return this._delegate;
  }
  
  @Pure
  public Function1<? super URI, ? extends Boolean> getFilter() {
    return this._filter;
  }
}
