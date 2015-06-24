/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.impl;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.internal.EmfAdaptable;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * A IResourceDescriptions implementation that holds its resource description in chunks, each identified by a string.
 * The strings represent units such as projects, source sets, and libraries.
 * 
 * @see ProjectDescription
 * @see ProjectDescriptionBasedContainerManager
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@Beta
@EmfAdaptable
@SuppressWarnings("all")
public class ChunkedResourceDescriptions extends AbstractCompoundSelectable implements IResourceDescriptions, IResourceDescriptions.IContextAware {
  public static class ChunkedResourceDescriptionsAdapter extends AdapterImpl {
    private ChunkedResourceDescriptions element;
    
    public ChunkedResourceDescriptionsAdapter(final ChunkedResourceDescriptions element) {
      this.element = element;
    }
    
    public ChunkedResourceDescriptions get() {
      return this.element;
    }
    
    public boolean isAdapterForType(final Object object) {
      return object == ChunkedResourceDescriptions.class;
    }
  }
  
  protected ConcurrentHashMap<String, ResourceDescriptionsData> chunk2resourceDescriptions = new ConcurrentHashMap<String, ResourceDescriptionsData>();
  
  protected ResourceSet resourceSet;
  
  @Override
  public void setContext(final Notifier context) {
    final ResourceSet newResourceSet = EcoreUtil2.getResourceSet(context);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(this.resourceSet, null));
    if (!_notEquals) {
      _and = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(this.resourceSet, newResourceSet));
      _and = _notEquals_1;
    }
    if (_and) {
      Class<? extends ChunkedResourceDescriptions> _class = this.getClass();
      String _name = _class.getName();
      String _plus = ("This " + _name);
      String _plus_1 = (_plus + " is already associated with a different resource set.");
      throw new IllegalStateException(_plus_1);
    }
    final ChunkedResourceDescriptions index = ChunkedResourceDescriptions.findInEmfObject(newResourceSet);
    boolean _and_1 = false;
    boolean _notEquals_2 = (!Objects.equal(index, null));
    if (!_notEquals_2) {
      _and_1 = false;
    } else {
      boolean _notEquals_3 = (!Objects.equal(index, this));
      _and_1 = _notEquals_3;
    }
    if (_and_1) {
      Class<? extends ChunkedResourceDescriptions> _class_1 = this.getClass();
      String _name_1 = _class_1.getName();
      String _plus_2 = ("There is already a different " + _name_1);
      String _plus_3 = (_plus_2 + " installed in the given resource set.");
      throw new IllegalStateException(_plus_3);
    }
    this.resourceSet = newResourceSet;
  }
  
  public ResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  public ChunkedResourceDescriptions() {
  }
  
  public ChunkedResourceDescriptions(final Map<String, ResourceDescriptionsData> initialData) {
    ConcurrentHashMap<String, ResourceDescriptionsData> _concurrentHashMap = new ConcurrentHashMap<String, ResourceDescriptionsData>(initialData);
    this.chunk2resourceDescriptions = _concurrentHashMap;
  }
  
  /**
   * Creates a flat copy of the resource descriptions. i.e. the inner ResourceDescriptionsData objects are not copied.
   * Also doesn't copy over the referenced ResourceSet
   */
  public ChunkedResourceDescriptions createFreshFlatCopy() {
    return new ChunkedResourceDescriptions(this.chunk2resourceDescriptions);
  }
  
  public ResourceDescriptionsData setContainer(final String name, final ResourceDescriptionsData descriptions) {
    return this.chunk2resourceDescriptions.put(name, descriptions);
  }
  
  @Override
  protected Iterable<? extends ISelectable> getSelectables() {
    return this.chunk2resourceDescriptions.values();
  }
  
  @Override
  public Iterable<IResourceDescription> getAllResourceDescriptions() {
    Collection<ResourceDescriptionsData> _values = this.chunk2resourceDescriptions.values();
    final Function1<ResourceDescriptionsData, Iterable<IResourceDescription>> _function = new Function1<ResourceDescriptionsData, Iterable<IResourceDescription>>() {
      @Override
      public Iterable<IResourceDescription> apply(final ResourceDescriptionsData it) {
        return it.getAllResourceDescriptions();
      }
    };
    Iterable<Iterable<IResourceDescription>> _map = IterableExtensions.<ResourceDescriptionsData, Iterable<IResourceDescription>>map(_values, _function);
    return Iterables.<IResourceDescription>concat(_map);
  }
  
  @Override
  public IResourceDescription getResourceDescription(final URI uri) {
    Collection<ResourceDescriptionsData> _values = this.chunk2resourceDescriptions.values();
    for (final ResourceDescriptionsData selectable : _values) {
      {
        final IResourceDescription result = selectable.getResourceDescription(uri);
        boolean _notEquals = (!Objects.equal(result, null));
        if (_notEquals) {
          return result;
        }
      }
    }
    return null;
  }
  
  public ResourceDescriptionsData getContainer(final URI uri) {
    Collection<ResourceDescriptionsData> _values = this.chunk2resourceDescriptions.values();
    for (final ResourceDescriptionsData container : _values) {
      {
        final IResourceDescription result = container.getResourceDescription(uri);
        boolean _notEquals = (!Objects.equal(result, null));
        if (_notEquals) {
          return container;
        }
      }
    }
    return null;
  }
  
  public ResourceDescriptionsData getContainer(final String containerHandle) {
    return this.chunk2resourceDescriptions.get(containerHandle);
  }
  
  public static ChunkedResourceDescriptions findInEmfObject(final Notifier emfObject) {
    for (Adapter adapter : emfObject.eAdapters()) {
    	if (adapter instanceof org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions.ChunkedResourceDescriptionsAdapter) {
    		return ((org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions.ChunkedResourceDescriptionsAdapter) adapter).get();
    	}
    }
    return null;
  }
  
  public void attachToEmfObject(final Notifier emfObject) {
    ChunkedResourceDescriptions result = findInEmfObject(emfObject);
    if (result != null)
    	throw new IllegalStateException("The given EMF object already contains an adapter for ChunkedResourceDescriptions");
    org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions.ChunkedResourceDescriptionsAdapter adapter = new org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions.ChunkedResourceDescriptionsAdapter(this);
    emfObject.eAdapters().add(adapter);
  }
}
