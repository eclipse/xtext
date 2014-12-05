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
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider;
import org.eclipse.xtext.generator.IFileSystemAccessExtension3;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.resource.persistence.ResourceStateProviderAdapter;
import org.eclipse.xtext.resource.persistence.SourceLevelURIsAdapter;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Service for storing and reading computed resource state
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ResourceStorage {
  @Inject(optional = true)
  private IContextualOutputConfigurationProvider outputConfigurationProvider;
  
  @Inject(optional = true)
  private Provider<AbstractFileSystemAccess2> fileSystemAccessProvider;
  
  /**
   * @return whether the given resource should be loaded from stored resource state
   */
  public boolean shouldLoadFromStorage(final StorageAwareResource resource) {
    boolean _or = false;
    boolean _equals = Objects.equal(this.outputConfigurationProvider, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _equals_1 = Objects.equal(this.fileSystemAccessProvider, null);
      _or = _equals_1;
    }
    if (_or) {
      return false;
    }
    ResourceSet _resourceSet = resource.getResourceSet();
    final SourceLevelURIsAdapter adapter = SourceLevelURIsAdapter.findInstalledAdapter(_resourceSet);
    boolean _equals_2 = Objects.equal(adapter, null);
    if (_equals_2) {
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
   * @return whether a stored resource state exists for the given resource
   */
  public boolean doesStorageExist(final StorageAwareResource resource) {
    ResourceSet _resourceSet = resource.getResourceSet();
    EList<Adapter> _eAdapters = _resourceSet.eAdapters();
    final Iterable<ResourceStateProviderAdapter> stateProviders = Iterables.<ResourceStateProviderAdapter>filter(_eAdapters, ResourceStateProviderAdapter.class);
    final Function1<ResourceStateProviderAdapter, Boolean> _function = new Function1<ResourceStateProviderAdapter, Boolean>() {
      public Boolean apply(final ResourceStateProviderAdapter it) {
        URI _uRI = resource.getURI();
        return Boolean.valueOf(it.hasStateFor(_uRI));
      }
    };
    boolean _exists = IterableExtensions.<ResourceStateProviderAdapter>exists(stateProviders, _function);
    if (_exists) {
      return true;
    }
    ResourceSet _resourceSet_1 = resource.getResourceSet();
    URIConverter _uRIConverter = _resourceSet_1.getURIConverter();
    URI _binURI = this.getBinURI(resource);
    Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
    boolean _exists_1 = _uRIConverter.exists(_binURI, _emptyMap);
    if (_exists_1) {
      return true;
    }
    final AbstractFileSystemAccess2 fsa = this.getFileSystemAccess(resource);
    final String outputRelativePath = this.computeOutputPath(resource);
    final URI uri = fsa.getURI(outputRelativePath);
    ResourceSet _resourceSet_2 = resource.getResourceSet();
    URIConverter _uRIConverter_1 = _resourceSet_2.getURIConverter();
    return _uRIConverter_1.exists(uri, null);
  }
  
  /**
   * loads the given resource from stored resource state
   */
  public void loadResource(final StorageAwareResource resource) {
    try {
      ResourceSet _resourceSet = resource.getResourceSet();
      EList<Adapter> _eAdapters = _resourceSet.eAdapters();
      final Iterable<ResourceStateProviderAdapter> stateProviders = Iterables.<ResourceStateProviderAdapter>filter(_eAdapters, ResourceStateProviderAdapter.class);
      for (final ResourceStateProviderAdapter stateProvider : stateProviders) {
        URI _uRI = resource.getURI();
        boolean _hasStateFor = stateProvider.hasStateFor(_uRI);
        if (_hasStateFor) {
          stateProvider.installState(resource);
          return;
        }
      }
      InputStream _xifexpression = null;
      ResourceSet _resourceSet_1 = resource.getResourceSet();
      URIConverter _uRIConverter = _resourceSet_1.getURIConverter();
      URI _binURI = this.getBinURI(resource);
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      boolean _exists = _uRIConverter.exists(_binURI, _emptyMap);
      if (_exists) {
        ResourceSet _resourceSet_2 = resource.getResourceSet();
        URIConverter _uRIConverter_1 = _resourceSet_2.getURIConverter();
        URI _binURI_1 = this.getBinURI(resource);
        _xifexpression = _uRIConverter_1.createInputStream(_binURI_1);
      } else {
        InputStream _xblockexpression = null;
        {
          final AbstractFileSystemAccess2 fsa = this.getFileSystemAccess(resource);
          final String outputRelativePath = this.computeOutputPath(resource);
          _xblockexpression = fsa.readBinaryFile(outputRelativePath);
        }
        _xifexpression = _xblockexpression;
      }
      final InputStream inputStream = _xifexpression;
      Map<Object, Object> _emptyMap_1 = CollectionLiterals.<Object, Object>emptyMap();
      final BinaryResourceImpl.EObjectInputStream in = new BinaryResourceImpl.EObjectInputStream(inputStream, _emptyMap_1);
      in.loadResource(resource);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected AbstractFileSystemAccess2 getFileSystemAccess(final StorageAwareResource resource) {
    AbstractFileSystemAccess2 _xblockexpression = null;
    {
      final AbstractFileSystemAccess2 fsa = this.fileSystemAccessProvider.get();
      fsa.setContext(resource);
      Set<OutputConfiguration> _outputConfigurations = this.outputConfigurationProvider.getOutputConfigurations(resource);
      final Function1<OutputConfiguration, String> _function = new Function1<OutputConfiguration, String>() {
        public String apply(final OutputConfiguration it) {
          return it.getName();
        }
      };
      Map<String, OutputConfiguration> _map = IterableExtensions.<String, OutputConfiguration>toMap(_outputConfigurations, _function);
      fsa.setOutputConfigurations(_map);
      _xblockexpression = fsa;
    }
    return _xblockexpression;
  }
  
  protected String computeOutputPath(final StorageAwareResource resource) {
    final URI uri = this.getBinURI(resource);
    URI _trimFileExtension = uri.trimFileExtension();
    int _segmentCount = uri.segmentCount();
    int _minus = (_segmentCount - 3);
    URI _trimSegments = _trimFileExtension.trimSegments(_minus);
    final String srcFolderPath = _trimSegments.toString();
    String _string = uri.toString();
    int _length = srcFolderPath.length();
    int _plus = (_length + 1);
    final String outputRelativePath = _string.substring(_plus);
    return outputRelativePath;
  }
  
  protected URI getBinURI(final StorageAwareResource resource) {
    URI _uRI = resource.getURI();
    return _uRI.appendFileExtension(".bin");
  }
  
  /**
   * safes the given resource's state
   */
  public void safeResource(final StorageAwareResource resource, final IFileSystemAccessExtension3 fsa) {
    try {
      final String path = this.computeOutputPath(resource);
      final ByteArrayOutputStream bout = new ByteArrayOutputStream();
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      final BinaryResourceImpl.EObjectOutputStream out = new BinaryResourceImpl.EObjectOutputStream(bout, _emptyMap);
      try {
        out.saveResource(resource);
      } finally {
        out.flush();
      }
      byte[] _byteArray = bout.toByteArray();
      ByteArrayInputStream _byteArrayInputStream = new ByteArrayInputStream(_byteArray);
      fsa.generateFile(path, _byteArrayInputStream);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
