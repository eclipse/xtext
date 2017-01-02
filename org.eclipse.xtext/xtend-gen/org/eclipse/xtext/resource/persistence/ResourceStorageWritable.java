/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.base.Objects;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.nodemodel.impl.SerializableNodeModel;
import org.eclipse.xtext.nodemodel.serialization.SerializationConversionContext;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.persistence.SerializableReferenceDescription;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class ResourceStorageWritable {
  private final OutputStream out;
  
  private final boolean storeNodeModel;
  
  public void writeResource(final StorageAwareResource resource) throws IOException {
    boolean _isLoadedFromStorage = resource.isLoadedFromStorage();
    if (_isLoadedFromStorage) {
      URI _uRI = resource.getURI();
      String _plus = ("cannot write resources loaded from storage. URI was " + _uRI);
      throw new IllegalStateException(_plus);
    }
    final ZipOutputStream zipOut = new ZipOutputStream(this.out);
    try {
      this.writeEntries(resource, zipOut);
    } finally {
      zipOut.close();
    }
  }
  
  /**
   * Write entries into the storage.
   * Overriding methods should first delegate to super before adding their own entries.
   */
  protected void writeEntries(final StorageAwareResource resource, final ZipOutputStream zipOut) throws IOException {
    final BufferedOutputStream bufferedOutput = new BufferedOutputStream(zipOut);
    ZipEntry _zipEntry = new ZipEntry("emf-contents");
    zipOut.putNextEntry(_zipEntry);
    try {
      this.writeContents(resource, bufferedOutput);
    } finally {
      bufferedOutput.flush();
      zipOut.closeEntry();
    }
    ZipEntry _zipEntry_1 = new ZipEntry("resource-description");
    zipOut.putNextEntry(_zipEntry_1);
    try {
      this.writeResourceDescription(resource, bufferedOutput);
    } finally {
      bufferedOutput.flush();
      zipOut.closeEntry();
    }
    if (this.storeNodeModel) {
      ZipEntry _zipEntry_2 = new ZipEntry("node-model");
      zipOut.putNextEntry(_zipEntry_2);
      try {
        this.writeNodeModel(resource, bufferedOutput);
      } finally {
        bufferedOutput.flush();
        zipOut.closeEntry();
      }
    }
  }
  
  protected void writeContents(final StorageAwareResource storageAwareResource, final OutputStream outputStream) throws IOException {
    Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
    final BinaryResourceImpl.EObjectOutputStream out = new BinaryResourceImpl.EObjectOutputStream(outputStream, _emptyMap) {
      @Override
      public void writeURI(final URI uri, final String fragment) throws IOException {
        final URI fullURI = uri.appendFragment(fragment);
        URI _elvis = null;
        URI _portableURI = storageAwareResource.getPortableURIs().toPortableURI(storageAwareResource, fullURI);
        if (_portableURI != null) {
          _elvis = _portableURI;
        } else {
          _elvis = fullURI;
        }
        final URI uriToWrite = _elvis;
        super.writeURI(uriToWrite.trimFragment(), uriToWrite.fragment());
      }
      
      @Override
      public void saveEObject(final InternalEObject internalEObject, final BinaryResourceImpl.EObjectOutputStream.Check check) throws IOException {
        ResourceStorageWritable.this.beforeSaveEObject(internalEObject, this);
        super.saveEObject(internalEObject, check);
        ResourceStorageWritable.this.handleSaveEObject(internalEObject, this);
      }
    };
    try {
      out.saveResource(storageAwareResource);
    } finally {
      out.flush();
    }
  }
  
  protected Object beforeSaveEObject(final InternalEObject object, final BinaryResourceImpl.EObjectOutputStream writable) throws IOException {
    return null;
  }
  
  protected void handleSaveEObject(final InternalEObject object, final BinaryResourceImpl.EObjectOutputStream out) throws IOException {
  }
  
  protected void writeResourceDescription(final StorageAwareResource resource, final OutputStream outputStream) throws IOException {
    final IResourceDescription description = resource.getResourceServiceProvider().getResourceDescriptionManager().getResourceDescription(resource);
    final SerializableResourceDescription serializableDescription = SerializableResourceDescription.createCopy(description);
    this.convertExternalURIsToPortableURIs(serializableDescription, resource);
    final ObjectOutputStream out = new ObjectOutputStream(outputStream);
    try {
      out.writeObject(serializableDescription);
    } finally {
      out.flush();
    }
  }
  
  protected void convertExternalURIsToPortableURIs(final SerializableResourceDescription description, final StorageAwareResource resource) {
    Iterable<IReferenceDescription> _referenceDescriptions = description.getReferenceDescriptions();
    for (final IReferenceDescription ref : _referenceDescriptions) {
      URI _trimFragment = ref.getTargetEObjectUri().trimFragment();
      URI _uRI = resource.getURI();
      boolean _notEquals = (!Objects.equal(_trimFragment, _uRI));
      if (_notEquals) {
        URI _elvis = null;
        URI _portableURI = resource.getPortableURIs().toPortableURI(resource, ref.getTargetEObjectUri());
        if (_portableURI != null) {
          _elvis = _portableURI;
        } else {
          URI _targetEObjectUri = ref.getTargetEObjectUri();
          _elvis = _targetEObjectUri;
        }
        ((SerializableReferenceDescription) ref).setTargetEObjectUri(_elvis);
      }
    }
  }
  
  protected void writeNodeModel(final StorageAwareResource resource, final OutputStream outputStream) throws IOException {
    final DataOutputStream out = new DataOutputStream(outputStream);
    final SerializableNodeModel serializableNodeModel = new SerializableNodeModel(resource);
    final SerializationConversionContext conversionContext = new SerializationConversionContext(resource);
    serializableNodeModel.writeObjectData(out, conversionContext);
    out.flush();
  }
  
  public ResourceStorageWritable(final OutputStream out, final boolean storeNodeModel) {
    super();
    this.out = out;
    this.storeNodeModel = storeNodeModel;
  }
}
