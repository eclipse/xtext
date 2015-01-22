/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.base.Objects;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.nodemodel.impl.SerializableNodeModel;
import org.eclipse.xtext.nodemodel.serialization.SerializationConversionContext;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.persistence.PortableURIs;
import org.eclipse.xtext.resource.persistence.SerializableReferenceDescription;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class ResourceStorageWritable {
  private final static Logger LOG = Logger.getLogger(ResourceStorageWritable.class);
  
  private final OutputStream out;
  
  private final boolean storeNodeModel;
  
  public void writeResource(final StorageAwareResource resource) {
    try {
      boolean _isLoadedFromStorage = resource.isLoadedFromStorage();
      if (_isLoadedFromStorage) {
        URI _uRI = resource.getURI();
        String _plus = ("cannot write resources loaded from storage. URI was " + _uRI);
        throw new IllegalStateException(_plus);
      }
      final ZipOutputStream zipOut = new ZipOutputStream(this.out);
      try {
        this.writeEntries(resource, zipOut);
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException e = (IOException)_t;
          String _message = e.getMessage();
          ResourceStorageWritable.LOG.error(_message, e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        zipOut.close();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Write entries into the storage.
   * Overriding methods should first delegate to super before adding their own entries.
   */
  protected void writeEntries(final StorageAwareResource resource, final ZipOutputStream zipOut) {
    try {
      ZipEntry _zipEntry = new ZipEntry("emf-contents");
      zipOut.putNextEntry(_zipEntry);
      try {
        this.writeContents(resource, zipOut);
      } finally {
        zipOut.closeEntry();
      }
      ZipEntry _zipEntry_1 = new ZipEntry("resource-description");
      zipOut.putNextEntry(_zipEntry_1);
      try {
        this.writeResourceDescription(resource, zipOut);
      } finally {
        zipOut.closeEntry();
      }
      if (this.storeNodeModel) {
        ZipEntry _zipEntry_2 = new ZipEntry("node-model");
        zipOut.putNextEntry(_zipEntry_2);
        try {
          this.writeNodeModel(resource, zipOut);
        } finally {
          zipOut.closeEntry();
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void writeContents(final StorageAwareResource storageAwareResource, final OutputStream outputStream) {
    try {
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      final BinaryResourceImpl.EObjectOutputStream out = new BinaryResourceImpl.EObjectOutputStream(outputStream, _emptyMap) {
        @Override
        public void writeURI(final URI uri, final String fragment) throws IOException {
          final URI fullURI = uri.appendFragment(fragment);
          URI _elvis = null;
          PortableURIs _portableURIs = storageAwareResource.getPortableURIs();
          URI _portableURI = _portableURIs.toPortableURI(storageAwareResource, fullURI);
          if (_portableURI != null) {
            _elvis = _portableURI;
          } else {
            _elvis = fullURI;
          }
          final URI uriToWrite = _elvis;
          URI _trimFragment = uriToWrite.trimFragment();
          String _fragment = uriToWrite.fragment();
          super.writeURI(_trimFragment, _fragment);
        }
        
        @Override
        public void saveEObject(final InternalEObject internalEObject, final BinaryResourceImpl.EObjectOutputStream.Check check) throws IOException {
          super.saveEObject(internalEObject, check);
          ResourceStorageWritable.this.handleSaveEObject(internalEObject, this);
        }
      };
      try {
        out.saveResource(storageAwareResource);
      } finally {
        out.flush();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void handleSaveEObject(final InternalEObject object, final BinaryResourceImpl.EObjectOutputStream out) {
  }
  
  protected void writeResourceDescription(final StorageAwareResource resource, final OutputStream outputStream) {
    try {
      IResourceServiceProvider _resourceServiceProvider = resource.getResourceServiceProvider();
      IResourceDescription.Manager _resourceDescriptionManager = _resourceServiceProvider.getResourceDescriptionManager();
      final IResourceDescription description = _resourceDescriptionManager.getResourceDescription(resource);
      final SerializableResourceDescription serializableDescription = SerializableResourceDescription.createCopy(description);
      this.convertExternalURIsToPortableURIs(serializableDescription, resource);
      final ObjectOutputStream out = new ObjectOutputStream(outputStream);
      try {
        out.writeObject(serializableDescription);
      } finally {
        out.flush();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void convertExternalURIsToPortableURIs(final SerializableResourceDescription description, final StorageAwareResource resource) {
    Iterable<IReferenceDescription> _referenceDescriptions = description.getReferenceDescriptions();
    for (final IReferenceDescription ref : _referenceDescriptions) {
      URI _targetEObjectUri = ref.getTargetEObjectUri();
      URI _trimFragment = _targetEObjectUri.trimFragment();
      URI _uRI = resource.getURI();
      boolean _notEquals = (!Objects.equal(_trimFragment, _uRI));
      if (_notEquals) {
        PortableURIs _portableURIs = resource.getPortableURIs();
        URI _targetEObjectUri_1 = ref.getTargetEObjectUri();
        URI _portableURI = _portableURIs.toPortableURI(resource, _targetEObjectUri_1);
        ((SerializableReferenceDescription) ref).setTargetEObjectUri(_portableURI);
      }
    }
  }
  
  protected void writeNodeModel(final StorageAwareResource resource, final OutputStream outputStream) {
    try {
      final DataOutputStream out = new DataOutputStream(outputStream);
      final SerializableNodeModel serializableNodeModel = new SerializableNodeModel(resource);
      final SerializationConversionContext conversionContext = new SerializationConversionContext(resource);
      serializableNodeModel.writeObjectData(out, conversionContext);
      out.flush();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResourceStorageWritable(final OutputStream out, final boolean storeNodeModel) {
    super();
    this.out = out;
    this.storeNodeModel = storeNodeModel;
  }
}
