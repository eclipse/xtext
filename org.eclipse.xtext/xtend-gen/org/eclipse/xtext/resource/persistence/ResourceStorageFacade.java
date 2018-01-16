/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.IFileSystemAccessExtension3;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.persistence.IResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageProviderAdapter;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.SourceLevelURIsAdapter;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceStorageFacade implements IResourceStorageFacade {
  private static class MyByteArrayOutputStream extends ByteArrayOutputStream {
    @Override
    public synchronized byte[] toByteArray() {
      return this.buf;
    }
    
    public int length() {
      return this.count;
    }
  }
  
  private final static Logger LOG = Logger.getLogger(ResourceStorageFacade.class);
  
  @Inject
  private IContextualOutputConfigurationProvider outputConfigurationProvider;
  
  @Inject
  private Provider<AbstractFileSystemAccess2> fileSystemAccessProvider;
  
  @Accessors
  private boolean storeNodeModel = false;
  
  /**
   * @return whether the given resource should be loaded from stored resource state
   */
  @Override
  public boolean shouldLoadFromStorage(final StorageAwareResource resource) {
    final SourceLevelURIsAdapter adapter = SourceLevelURIsAdapter.findInstalledAdapter(resource.getResourceSet());
    if ((adapter == null)) {
      return false;
    } else {
      boolean _contains = adapter.getSourceLevelURIs().contains(resource.getURI());
      if (_contains) {
        return false;
      }
    }
    return this.doesStorageExist(resource);
  }
  
  /**
   * Finds or creates a ResourceStorageLoadable for the given resource.
   * Clients should first call shouldLoadFromStorage to check whether there exists a storage version
   * of the given resource.
   * 
   * @return an IResourceStorageLoadable
   */
  @Override
  public ResourceStorageLoadable getOrCreateResourceStorageLoadable(final StorageAwareResource resource) {
    try {
      final ResourceStorageProviderAdapter stateProvider = IterableExtensions.<ResourceStorageProviderAdapter>head(Iterables.<ResourceStorageProviderAdapter>filter(resource.getResourceSet().eAdapters(), ResourceStorageProviderAdapter.class));
      if ((stateProvider != null)) {
        final ResourceStorageLoadable inputStream = stateProvider.getResourceStorageLoadable(resource);
        if ((inputStream != null)) {
          return inputStream;
        }
      }
      InputStream _xifexpression = null;
      boolean _exists = resource.getResourceSet().getURIConverter().exists(this.getBinaryStorageURI(resource.getURI()), CollectionLiterals.<Object, Object>emptyMap());
      if (_exists) {
        _xifexpression = resource.getResourceSet().getURIConverter().createInputStream(this.getBinaryStorageURI(resource.getURI()));
      } else {
        InputStream _xblockexpression = null;
        {
          final AbstractFileSystemAccess2 fsa = this.getFileSystemAccess(resource);
          final String outputRelativePath = this.computeOutputPath(resource);
          _xblockexpression = fsa.readBinaryFile(outputRelativePath);
        }
        _xifexpression = _xblockexpression;
      }
      final InputStream inputStream_1 = _xifexpression;
      return this.createResourceStorageLoadable(inputStream_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void saveResource(final StorageAwareResource resource, final IFileSystemAccessExtension3 fsa) {
    final String path = this.computeOutputPath(resource);
    final ResourceStorageFacade.MyByteArrayOutputStream bout = new ResourceStorageFacade.MyByteArrayOutputStream();
    final ResourceStorageWritable outStream = this.createResourceStorageWritable(bout);
    try {
      outStream.writeResource(resource);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        URI _uRI = resource.getURI();
        String _plus = ("Cannot write storage for " + _uRI);
        ResourceStorageFacade.LOG.warn(_plus, e);
        return;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    byte[] _byteArray = bout.toByteArray();
    int _length = bout.length();
    ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray, 0, _length);
    fsa.generateFile(path, _byteArrayInputStream);
  }
  
  @Override
  public ResourceStorageLoadable createResourceStorageLoadable(final InputStream in) {
    boolean _isStoreNodeModel = this.isStoreNodeModel();
    return new ResourceStorageLoadable(in, _isStoreNodeModel);
  }
  
  @Override
  public ResourceStorageWritable createResourceStorageWritable(final OutputStream out) {
    boolean _isStoreNodeModel = this.isStoreNodeModel();
    return new ResourceStorageWritable(out, _isStoreNodeModel);
  }
  
  /**
   * @return whether a stored resource state exists for the given resource
   */
  protected boolean doesStorageExist(final StorageAwareResource resource) {
    final ResourceStorageProviderAdapter stateProvider = IterableExtensions.<ResourceStorageProviderAdapter>head(Iterables.<ResourceStorageProviderAdapter>filter(resource.getResourceSet().eAdapters(), ResourceStorageProviderAdapter.class));
    if (((stateProvider != null) && (stateProvider.getResourceStorageLoadable(resource) != null))) {
      return true;
    }
    boolean _exists = resource.getResourceSet().getURIConverter().exists(this.getBinaryStorageURI(resource.getURI()), CollectionLiterals.<Object, Object>emptyMap());
    if (_exists) {
      return true;
    }
    boolean _isArchive = resource.getURI().isArchive();
    if (_isArchive) {
      return false;
    }
    final AbstractFileSystemAccess2 fsa = this.getFileSystemAccess(resource);
    final String outputRelativePath = this.computeOutputPath(resource);
    final URI uri = fsa.getURI(outputRelativePath);
    return ((uri != null) && resource.getResourceSet().getURIConverter().exists(uri, null));
  }
  
  protected AbstractFileSystemAccess2 getFileSystemAccess(final StorageAwareResource resource) {
    final AbstractFileSystemAccess2 fsa = this.fileSystemAccessProvider.get();
    fsa.setContext(resource);
    final Function1<OutputConfiguration, String> _function = (OutputConfiguration it) -> {
      return it.getName();
    };
    fsa.setOutputConfigurations(IterableExtensions.<String, OutputConfiguration>toMap(this.outputConfigurationProvider.getOutputConfigurations(resource), _function));
    return fsa;
  }
  
  protected String computeOutputPath(final StorageAwareResource resource) {
    final URI srcContainerURI = this.getSourceContainerURI(resource);
    final URI uri = this.getBinaryStorageURI(resource.getURI());
    final String outputRelativePath = uri.deresolve(srcContainerURI, false, false, true).path();
    return outputRelativePath;
  }
  
  protected URI getSourceContainerURI(final StorageAwareResource resource) {
    return resource.getURI().trimSegments(1).appendSegment("");
  }
  
  @Override
  public boolean hasStorageFor(final URI uri) {
    return new ExtensibleURIConverterImpl().exists(this.getBinaryStorageURI(uri), CollectionLiterals.<Object, Object>emptyMap());
  }
  
  protected URI getBinaryStorageURI(final URI sourceURI) {
    URI _trimSegments = sourceURI.trimSegments(1);
    String _lastSegment = sourceURI.lastSegment();
    String _plus = ("." + _lastSegment);
    String _plus_1 = (_plus + "bin");
    return _trimSegments.appendSegment(_plus_1);
  }
  
  @Pure
  public boolean isStoreNodeModel() {
    return this.storeNodeModel;
  }
  
  public void setStoreNodeModel(final boolean storeNodeModel) {
    this.storeNodeModel = storeNodeModel;
  }
}
