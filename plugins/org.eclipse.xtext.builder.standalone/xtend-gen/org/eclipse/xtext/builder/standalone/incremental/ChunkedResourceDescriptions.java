/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@SuppressWarnings("all")
public class ChunkedResourceDescriptions extends AbstractCompoundSelectable implements IResourceDescriptions {
  protected volatile ConcurrentHashMap<String, ResourceDescriptionsData> chunk2resourceDescriptions = new ConcurrentHashMap<String, ResourceDescriptionsData>();
  
  public ChunkedResourceDescriptions() {
  }
  
  public ChunkedResourceDescriptions(final Map<String, ResourceDescriptionsData> initialData) {
    ConcurrentHashMap<String, ResourceDescriptionsData> _concurrentHashMap = new ConcurrentHashMap<String, ResourceDescriptionsData>(initialData);
    this.chunk2resourceDescriptions = _concurrentHashMap;
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
}
