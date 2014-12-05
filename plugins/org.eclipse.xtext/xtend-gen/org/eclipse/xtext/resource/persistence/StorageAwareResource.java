/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.inject.Inject;
import java.io.IOException;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.persistence.ResourceStorage;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A resource implementation that can load itself from ResourceStorage.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class StorageAwareResource extends LazyLinkingResource {
  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private ResourceStorage storage;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  protected boolean isLoadedFromStorage = false;
  
  public void load(final Map<?, ?> options) throws IOException {
    boolean _and = false;
    if (!((!this.isLoaded) && (!this.isLoading))) {
      _and = false;
    } else {
      boolean _shouldLoadFromStorage = this.storage.shouldLoadFromStorage(this);
      _and = _shouldLoadFromStorage;
    }
    if (_and) {
      this.isLoading = true;
      try {
        this.storage.loadResource(this);
        this.isLoaded = true;
      } finally {
        this.isLoadedFromStorage = true;
        this.isLoading = false;
      }
    } else {
      super.load(options);
    }
  }
  
  protected void clearInternalState() {
    this.isLoadedFromStorage = false;
    super.clearInternalState();
  }
  
  @Pure
  public ResourceStorage getStorage() {
    return this.storage;
  }
  
  @Pure
  public boolean isIsLoadedFromStorage() {
    return this.isLoadedFromStorage;
  }
}
