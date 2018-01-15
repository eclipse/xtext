/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import com.google.common.io.CharStreams;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.zip.ZipInputStream;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.nodemodel.impl.SerializableNodeModel;
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class ResourceStorageLoadable {
  private final static Logger LOG = Logger.getLogger(ResourceStorageLoadable.class);
  
  private final InputStream in;
  
  private final boolean storeNodeModel;
  
  protected void loadIntoResource(final StorageAwareResource resource) throws IOException {
    boolean _isLoadedFromStorage = resource.isLoadedFromStorage();
    boolean _not = (!_isLoadedFromStorage);
    if (_not) {
      throw new IllegalStateException("Please use StorageAwareResource#load(ResourceStorageLoadable).");
    }
    final ZipInputStream zin = new ZipInputStream(this.in);
    try {
      this.loadEntries(resource, zin);
    } finally {
      zin.close();
    }
  }
  
  /**
   * Load entries from the storage.
   * Overriding methods should first delegate to super before adding their own entries.
   */
  protected void loadEntries(final StorageAwareResource resource, final ZipInputStream zipIn) throws IOException {
    zipIn.getNextEntry();
    BufferedInputStream _bufferedInputStream = new BufferedInputStream(zipIn);
    this.readContents(resource, _bufferedInputStream);
    zipIn.getNextEntry();
    BufferedInputStream _bufferedInputStream_1 = new BufferedInputStream(zipIn);
    this.readResourceDescription(resource, _bufferedInputStream_1);
    if (this.storeNodeModel) {
      zipIn.getNextEntry();
      BufferedInputStream _bufferedInputStream_2 = new BufferedInputStream(zipIn);
      this.readNodeModel(resource, _bufferedInputStream_2);
    }
  }
  
  protected void readContents(final StorageAwareResource resource, final InputStream inputStream) throws IOException {
    Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
    final BinaryResourceImpl.EObjectInputStream in = new BinaryResourceImpl.EObjectInputStream(inputStream, _emptyMap) {
      @Override
      public int readCompressedInt() throws IOException {
        int _xblockexpression = (int) 0;
        {
          this.resourceSet = null;
          _xblockexpression = super.readCompressedInt();
        }
        return _xblockexpression;
      }
      
      @Override
      public InternalEObject loadEObject() throws IOException {
        final InternalEObject result = super.loadEObject();
        ResourceStorageLoadable.this.handleLoadEObject(result, this);
        return result;
      }
    };
    in.loadResource(resource);
  }
  
  protected Object handleLoadEObject(final InternalEObject loaded, final BinaryResourceImpl.EObjectInputStream input) throws IOException {
    return null;
  }
  
  protected void readResourceDescription(final StorageAwareResource resource, final InputStream inputStream) throws IOException {
    try {
      final ObjectInputStream objectIn = new ObjectInputStream(inputStream);
      Object _readObject = objectIn.readObject();
      final SerializableResourceDescription description = ((SerializableResourceDescription) _readObject);
      description.updateResourceURI(resource.getURI());
      resource.setResourceDescription(description);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void readNodeModel(final StorageAwareResource resource, final InputStream inputStream) throws IOException {
    final SerializableNodeModel serializableNodeModel = new SerializableNodeModel(resource);
    boolean _exists = resource.getResourceSet().getURIConverter().exists(resource.getURI(), resource.getResourceSet().getLoadOptions());
    boolean _not = (!_exists);
    if (_not) {
      URI _uRI = resource.getURI();
      String _plus = ("Skipping loading node model for synthetic resource " + _uRI);
      ResourceStorageLoadable.LOG.info(_plus);
      return;
    }
    final InputStream stream = resource.getResourceSet().getURIConverter().createInputStream(resource.getURI());
    String _encoding = resource.getEncoding();
    final InputStreamReader in = new InputStreamReader(stream, _encoding);
    final String completeContent = CharStreams.toString(in);
    final DeserializationConversionContext deserializationContext = new DeserializationConversionContext(resource, completeContent);
    final DataInputStream dataIn = new DataInputStream(inputStream);
    serializableNodeModel.readObjectData(dataIn, deserializationContext);
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    boolean _hasErrors = deserializationContext.hasErrors();
    ParseResult _parseResult = new ParseResult(_head, serializableNodeModel.root, _hasErrors);
    resource.setParseResult(_parseResult);
  }
  
  public ResourceStorageLoadable(final InputStream in, final boolean storeNodeModel) {
    super();
    this.in = in;
    this.storeNodeModel = storeNodeModel;
  }
}
