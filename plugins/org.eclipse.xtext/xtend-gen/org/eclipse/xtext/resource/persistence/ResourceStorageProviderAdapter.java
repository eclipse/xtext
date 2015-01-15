/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.base.Objects;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;

/**
 * An adapter that can be installed into a SerializableResource,
 * to provide resource state. It is used with dirty editors providing the dirty non persisted
 * state to other editors.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceStorageProviderAdapter extends AdapterImpl {
  @Override
  public boolean isAdapterForType(final Object type) {
    return Objects.equal(type, ResourceStorageProviderAdapter.class);
  }
  
  public ResourceStorageLoadable getResourceStorageLoadable(final StorageAwareResource resource) {
    return null;
  }
}
