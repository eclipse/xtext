/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.inject.Inject;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.PortableURIs;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A resource implementation that can load itself from ResourceStorage.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class StorageAwareResource extends LazyLinkingResource {
  public final static String UNRESOLVABLE_FRAGMENT = "UNRESOLVABLE";
  
  private final static Logger LOG = Logger.getLogger(StorageAwareResource.class);
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject(optional = true)
  private IResourceStorageFacade resourceStorageFacade;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  @Inject
  private PortableURIs portableURIs;
  
  @Accessors
  private boolean isLoadedFromStorage = false;
  
  @Accessors
  private IResourceDescription resourceDescription = null;
  
  @Override
  public void load(final Map<?, ?> options) throws IOException {
    if (((((!this.isLoaded) && (!this.isLoading)) && (this.resourceStorageFacade != null)) && this.resourceStorageFacade.shouldLoadFromStorage(this))) {
      boolean _isDebugEnabled = StorageAwareResource.LOG.isDebugEnabled();
      if (_isDebugEnabled) {
        URI _uRI = this.getURI();
        String _plus = ("Loading " + _uRI);
        String _plus_1 = (_plus + " from storage.");
        StorageAwareResource.LOG.debug(_plus_1);
      }
      try {
        final ResourceStorageLoadable in = this.resourceStorageFacade.getOrCreateResourceStorageLoadable(this);
        this.loadFromStorage(in);
        return;
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          this.contents.clear();
          this.eAdapters.clear();
          this.unload();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
    super.load(options);
  }
  
  public void loadFromStorage(final ResourceStorageLoadable storageInputStream) throws IOException {
    if ((storageInputStream == null)) {
      throw new NullPointerException("storageInputStream");
    }
    final Stopwatches.StoppedTask task = Stopwatches.forTask("Loading from storage");
    task.start();
    this.isLoading = true;
    this.isLoadedFromStorage = true;
    try {
      storageInputStream.loadIntoResource(this);
      this.isLoaded = true;
    } finally {
      this.isLoading = false;
      task.stop();
    }
  }
  
  @Override
  protected void doUnload() {
    super.doUnload();
    this.isLoadedFromStorage = false;
  }
  
  @Override
  protected void clearInternalState() {
    this.isLoadedFromStorage = false;
    super.clearInternalState();
  }
  
  @Override
  public synchronized EObject getEObject(final String uriFragment) {
    EObject _xblockexpression = null;
    {
      boolean _isPortableURIFragment = this.portableURIs.isPortableURIFragment(uriFragment);
      if (_isPortableURIFragment) {
        return this.portableURIs.resolve(this, uriFragment);
      }
      _xblockexpression = super.getEObject(uriFragment);
    }
    return _xblockexpression;
  }
  
  @Override
  protected Set<String> getUnresolvableURIFragments() {
    if (this.isLoadedFromStorage) {
      return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(StorageAwareResource.UNRESOLVABLE_FRAGMENT));
    } else {
      return super.getUnresolvableURIFragments();
    }
  }
  
  @Pure
  public IResourceStorageFacade getResourceStorageFacade() {
    return this.resourceStorageFacade;
  }
  
  @Pure
  public PortableURIs getPortableURIs() {
    return this.portableURIs;
  }
  
  @Pure
  public boolean isLoadedFromStorage() {
    return this.isLoadedFromStorage;
  }
  
  public void setIsLoadedFromStorage(final boolean isLoadedFromStorage) {
    this.isLoadedFromStorage = isLoadedFromStorage;
  }
  
  @Pure
  public IResourceDescription getResourceDescription() {
    return this.resourceDescription;
  }
  
  public void setResourceDescription(final IResourceDescription resourceDescription) {
    this.resourceDescription = resourceDescription;
  }
}
