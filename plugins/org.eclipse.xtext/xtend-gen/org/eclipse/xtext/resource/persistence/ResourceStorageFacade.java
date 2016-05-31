/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
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
    public byte[] toByteArray() {
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
    ResourceSet _resourceSet = resource.getResourceSet();
    final SourceLevelURIsAdapter adapter = SourceLevelURIsAdapter.findInstalledAdapter(_resourceSet);
    boolean _equals = Objects.equal(adapter, null);
    if (_equals) {
      return false;
    } else {
      ImmutableSet<URI> _sourceLevelURIs = adapter.getSourceLevelURIs();
      URI _uRI = resource.getURI();
      boolean _contains = _sourceLevelURIs.contains(_uRI);
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
      ResourceSet _resourceSet = resource.getResourceSet();
      EList<Adapter> _eAdapters = _resourceSet.eAdapters();
      Iterable<ResourceStorageProviderAdapter> _filter = Iterables.<ResourceStorageProviderAdapter>filter(_eAdapters, ResourceStorageProviderAdapter.class);
      final ResourceStorageProviderAdapter stateProvider = IterableExtensions.<ResourceStorageProviderAdapter>head(_filter);
      boolean _notEquals = (!Objects.equal(stateProvider, null));
      if (_notEquals) {
        final ResourceStorageLoadable inputStream = stateProvider.getResourceStorageLoadable(resource);
        boolean _notEquals_1 = (!Objects.equal(inputStream, null));
        if (_notEquals_1) {
          return inputStream;
        }
      }
      InputStream _xifexpression = null;
      ResourceSet _resourceSet_1 = resource.getResourceSet();
      URIConverter _uRIConverter = _resourceSet_1.getURIConverter();
      URI _uRI = resource.getURI();
      URI _binaryStorageURI = this.getBinaryStorageURI(_uRI);
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      boolean _exists = _uRIConverter.exists(_binaryStorageURI, _emptyMap);
      if (_exists) {
        ResourceSet _resourceSet_2 = resource.getResourceSet();
        URIConverter _uRIConverter_1 = _resourceSet_2.getURIConverter();
        URI _uRI_1 = resource.getURI();
        URI _binaryStorageURI_1 = this.getBinaryStorageURI(_uRI_1);
        _xifexpression = _uRIConverter_1.createInputStream(_binaryStorageURI_1);
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
    ResourceSet _resourceSet = resource.getResourceSet();
    EList<Adapter> _eAdapters = _resourceSet.eAdapters();
    Iterable<ResourceStorageProviderAdapter> _filter = Iterables.<ResourceStorageProviderAdapter>filter(_eAdapters, ResourceStorageProviderAdapter.class);
    final ResourceStorageProviderAdapter stateProvider = IterableExtensions.<ResourceStorageProviderAdapter>head(_filter);
    if (((!Objects.equal(stateProvider, null)) && (!Objects.equal(stateProvider.getResourceStorageLoadable(resource), null)))) {
      return true;
    }
    ResourceSet _resourceSet_1 = resource.getResourceSet();
    URIConverter _uRIConverter = _resourceSet_1.getURIConverter();
    URI _uRI = resource.getURI();
    URI _binaryStorageURI = this.getBinaryStorageURI(_uRI);
    Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
    boolean _exists = _uRIConverter.exists(_binaryStorageURI, _emptyMap);
    if (_exists) {
      return true;
    }
    URI _uRI_1 = resource.getURI();
    boolean _isArchive = _uRI_1.isArchive();
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
    Set<OutputConfiguration> _outputConfigurations = this.outputConfigurationProvider.getOutputConfigurations(resource);
    final Function1<OutputConfiguration, String> _function = new Function1<OutputConfiguration, String>() {
      @Override
      public String apply(final OutputConfiguration it) {
        return it.getName();
      }
    };
    Map<String, OutputConfiguration> _map = IterableExtensions.<String, OutputConfiguration>toMap(_outputConfigurations, _function);
    fsa.setOutputConfigurations(_map);
    return fsa;
  }
  
  protected String computeOutputPath(final StorageAwareResource resource) {
    final URI srcContainerURI = this.getSourceContainerURI(resource);
    URI _uRI = resource.getURI();
    final URI uri = this.getBinaryStorageURI(_uRI);
    URI _deresolve = uri.deresolve(srcContainerURI, false, false, true);
    final String outputRelativePath = _deresolve.path();
    return outputRelativePath;
  }
  
  protected URI getSourceContainerURI(final StorageAwareResource resource) {
    URI _uRI = resource.getURI();
    URI _trimSegments = _uRI.trimSegments(1);
    return _trimSegments.appendSegment("");
  }
  
  @Override
  public boolean hasStorageFor(final URI uri) {
    ExtensibleURIConverterImpl _extensibleURIConverterImpl = new ExtensibleURIConverterImpl();
    URI _binaryStorageURI = this.getBinaryStorageURI(uri);
    Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
    return _extensibleURIConverterImpl.exists(_binaryStorageURI, _emptyMap);
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
