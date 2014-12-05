/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.io.IOException;
import java.util.Map;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageInputStream;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A resource implementation that can load itself from ResourceStorage.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class StorageAwareResource extends LazyLinkingResource {
  private final static Logger LOG = Logger.getLogger(StorageAwareResource.class);
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private ResourceStorageFacade resourceStorageFacade;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  protected boolean isLoadedFromStorage = false;
  
  public void load(final Map<?, ?> options) throws IOException {
    boolean _and = false;
    if (!((!this.isLoaded) && (!this.isLoading))) {
      _and = false;
    } else {
      boolean _shouldLoadFromStorage = this.resourceStorageFacade.shouldLoadFromStorage(this);
      _and = _shouldLoadFromStorage;
    }
    if (_and) {
      final ResourceStorageInputStream in = this.resourceStorageFacade.getExistingResourceStorageInputStream(this);
      this.load(in);
    } else {
      super.load(options);
    }
  }
  
  public void load(final ResourceStorageInputStream storageInputStream) {
    boolean _equals = Objects.equal(storageInputStream, null);
    if (_equals) {
      throw new NullPointerException("storageInputStream");
    }
    this.isLoading = true;
    this.isLoadedFromStorage = true;
    try {
      storageInputStream.loadIntoResource(this);
      this.isLoaded = true;
    } finally {
      this.isLoading = false;
    }
  }
  
  protected void clearInternalState() {
    this.isLoadedFromStorage = false;
    super.clearInternalState();
  }
  
  @Pure
  public ResourceStorageFacade getResourceStorageFacade() {
    return this.resourceStorageFacade;
  }
  
  @Pure
  public boolean isIsLoadedFromStorage() {
    return this.isLoadedFromStorage;
  }
}
