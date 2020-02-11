/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.resource;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.zip.ZipInputStream;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.jvmmodel.JvmIdentifiableMetaData;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class BatchLinkableResourceStorageLoadable extends ResourceStorageLoadable {
  @Override
  protected void loadEntries(final StorageAwareResource resource, final ZipInputStream zipIn) throws IOException {
    super.loadEntries(resource, zipIn);
    if ((resource instanceof BatchLinkableResource)) {
      this.readAssociationsAdapter(((BatchLinkableResource)resource), zipIn);
    }
  }
  
  @Override
  protected Object handleLoadEObject(final InternalEObject loaded, final BinaryResourceImpl.EObjectInputStream input) throws IOException {
    boolean _xblockexpression = false;
    {
      super.handleLoadEObject(loaded, input);
      boolean _readBoolean = input.readBoolean();
      if (_readBoolean) {
        final String doc = input.readString();
        EList<Adapter> _eAdapters = loaded.eAdapters();
        DocumentationAdapter _documentationAdapter = new DocumentationAdapter();
        final Procedure1<DocumentationAdapter> _function = (DocumentationAdapter it) -> {
          it.setDocumentation(doc);
        };
        DocumentationAdapter _doubleArrow = ObjectExtensions.<DocumentationAdapter>operator_doubleArrow(_documentationAdapter, _function);
        _eAdapters.add(_doubleArrow);
      }
      boolean _xifexpression = false;
      boolean _readBoolean_1 = input.readBoolean();
      if (_readBoolean_1) {
        EList<Adapter> _eAdapters_1 = loaded.eAdapters();
        JvmIdentifiableMetaData _jvmIdentifiableMetaData = new JvmIdentifiableMetaData();
        final Procedure1<JvmIdentifiableMetaData> _function_1 = (JvmIdentifiableMetaData it) -> {
          try {
            it.setSynthetic(input.readBoolean());
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        };
        JvmIdentifiableMetaData _doubleArrow_1 = ObjectExtensions.<JvmIdentifiableMetaData>operator_doubleArrow(_jvmIdentifiableMetaData, _function_1);
        _xifexpression = _eAdapters_1.add(_doubleArrow_1);
      }
      _xblockexpression = _xifexpression;
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  protected void readAssociationsAdapter(final BatchLinkableResource resource, final ZipInputStream stream) throws IOException {
    try {
      final JvmModelAssociator.Adapter existing = IterableExtensions.<JvmModelAssociator.Adapter>head(Iterables.<JvmModelAssociator.Adapter>filter(resource.eAdapters(), JvmModelAssociator.Adapter.class));
      JvmModelAssociator.Adapter _elvis = null;
      if (existing != null) {
        _elvis = existing;
      } else {
        JvmModelAssociator.Adapter _adapter = new JvmModelAssociator.Adapter();
        final Procedure1<JvmModelAssociator.Adapter> _function = (JvmModelAssociator.Adapter it) -> {
          EList<Adapter> _eAdapters = resource.eAdapters();
          _eAdapters.add(it);
        };
        JvmModelAssociator.Adapter _doubleArrow = ObjectExtensions.<JvmModelAssociator.Adapter>operator_doubleArrow(_adapter, _function);
        _elvis = _doubleArrow;
      }
      final JvmModelAssociator.Adapter adapter = _elvis;
      stream.getNextEntry();
      BufferedInputStream _bufferedInputStream = new BufferedInputStream(stream);
      final ObjectInputStream objIn = new ObjectInputStream(_bufferedInputStream);
      Object _readObject = objIn.readObject();
      final Map<String, String> logicalMap = ((Map<String, String>) _readObject);
      final Consumer<Map.Entry<String, String>> _function_1 = (Map.Entry<String, String> it) -> {
        EObject _eObject = resource.getEObject(it.getValue());
        adapter.logicalContainerMap.put(resource.getEObject(it.getKey()), ((JvmIdentifiableElement) _eObject));
      };
      logicalMap.entrySet().forEach(_function_1);
      Object _readObject_1 = objIn.readObject();
      final Map<String, Set<String>> sourceToTargetMap = ((Map<String, Set<String>>) _readObject_1);
      final Consumer<Map.Entry<String, Set<String>>> _function_2 = (Map.Entry<String, Set<String>> it) -> {
        final Function1<String, EObject> _function_3 = (String it_1) -> {
          return resource.getEObject(it_1);
        };
        adapter.sourceToTargetMap.put(resource.getEObject(it.getKey()), Sets.<EObject>newLinkedHashSet(IterableExtensions.<String, EObject>map(it.getValue(), _function_3)));
      };
      sourceToTargetMap.entrySet().forEach(_function_2);
      Object _readObject_2 = objIn.readObject();
      final Map<String, Set<String>> targetToSourceMap = ((Map<String, Set<String>>) _readObject_2);
      final Consumer<Map.Entry<String, Set<String>>> _function_3 = (Map.Entry<String, Set<String>> it) -> {
        final Function1<String, EObject> _function_4 = (String it_1) -> {
          return resource.getEObject(it_1);
        };
        adapter.targetToSourceMap.put(resource.getEObject(it.getKey()), Sets.<EObject>newLinkedHashSet(IterableExtensions.<String, EObject>map(it.getValue(), _function_4)));
      };
      targetToSourceMap.entrySet().forEach(_function_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public BatchLinkableResourceStorageLoadable(final InputStream in, final boolean storeNodeModel) {
    super(in, storeNodeModel);
  }
}
