/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.xtext.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class FilteringResourceDescriptions implements IResourceDescriptions {
  private final IResourceDescriptions delegate;
  
  private final Function1<? super URI, ? extends Boolean> filter;
  
  public Iterable<IResourceDescription> getAllResourceDescriptions() {
    Iterable<IResourceDescription> _allResourceDescriptions = this.delegate.getAllResourceDescriptions();
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
      return this.delegate.getResourceDescription(normalizedURI);
    }
    return null;
  }
  
  private boolean isContainedUri(final URI uri) {
    return (this.filter.apply(uri)).booleanValue();
  }
  
  public Iterable<IEObjectDescription> getExportedObjects() {
    Iterable<IEObjectDescription> _exportedObjects = this.delegate.getExportedObjects();
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return Boolean.valueOf(FilteringResourceDescriptions.this.isContainedUri(_eObjectURI));
      }
    };
    return IterableExtensions.<IEObjectDescription>filter(_exportedObjects, _function);
  }
  
  public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name, final boolean ignoreCase) {
    Iterable<IEObjectDescription> _exportedObjects = this.delegate.getExportedObjects(type, name, ignoreCase);
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return Boolean.valueOf(FilteringResourceDescriptions.this.isContainedUri(_eObjectURI));
      }
    };
    return IterableExtensions.<IEObjectDescription>filter(_exportedObjects, _function);
  }
  
  public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
    Iterable<IEObjectDescription> _exportedObjectsByObject = this.delegate.getExportedObjectsByObject(object);
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return Boolean.valueOf(FilteringResourceDescriptions.this.isContainedUri(_eObjectURI));
      }
    };
    return IterableExtensions.<IEObjectDescription>filter(_exportedObjectsByObject, _function);
  }
  
  public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
    Iterable<IEObjectDescription> _exportedObjectsByType = this.delegate.getExportedObjectsByType(type);
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription it) {
        URI _eObjectURI = it.getEObjectURI();
        return Boolean.valueOf(FilteringResourceDescriptions.this.isContainedUri(_eObjectURI));
      }
    };
    return IterableExtensions.<IEObjectDescription>filter(_exportedObjectsByType, _function);
  }
  
  public boolean isEmpty() {
    Iterable<IResourceDescription> _allResourceDescriptions = this.getAllResourceDescriptions();
    return IterableExtensions.isEmpty(_allResourceDescriptions);
  }
  
  public FilteringResourceDescriptions(final IResourceDescriptions delegate, final Function1<? super URI, ? extends Boolean> filter) {
    super();
    this.delegate = delegate;
    this.filter = filter;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.delegate== null) ? 0 : this.delegate.hashCode());
    result = prime * result + ((this.filter== null) ? 0 : this.filter.hashCode());
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
    if (this.delegate == null) {
      if (other.delegate != null)
        return false;
    } else if (!this.delegate.equals(other.delegate))
      return false;
    if (this.filter == null) {
      if (other.filter != null)
        return false;
    } else if (!this.filter.equals(other.filter))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("delegate", this.delegate);
    b.add("filter", this.filter);
    return b.toString();
  }
  
  @Pure
  public IResourceDescriptions getDelegate() {
    return this.delegate;
  }
  
  @Pure
  public Function1<? super URI, ? extends Boolean> getFilter() {
    return this.filter;
  }
}
