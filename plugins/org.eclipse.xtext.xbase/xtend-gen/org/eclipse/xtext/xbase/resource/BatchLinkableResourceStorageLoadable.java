/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.resource;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
        final Procedure1<DocumentationAdapter> _function = new Procedure1<DocumentationAdapter>() {
          @Override
          public void apply(final DocumentationAdapter it) {
            it.setDocumentation(doc);
          }
        };
        DocumentationAdapter _doubleArrow = ObjectExtensions.<DocumentationAdapter>operator_doubleArrow(_documentationAdapter, _function);
        _eAdapters.add(_doubleArrow);
      }
      boolean _xifexpression = false;
      boolean _readBoolean_1 = input.readBoolean();
      if (_readBoolean_1) {
        EList<Adapter> _eAdapters_1 = loaded.eAdapters();
        JvmIdentifiableMetaData _jvmIdentifiableMetaData = new JvmIdentifiableMetaData();
        final Procedure1<JvmIdentifiableMetaData> _function_1 = new Procedure1<JvmIdentifiableMetaData>() {
          @Override
          public void apply(final JvmIdentifiableMetaData it) {
            try {
              boolean _readBoolean = input.readBoolean();
              it.setSynthetic(_readBoolean);
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
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
      EList<Adapter> _eAdapters = resource.eAdapters();
      Iterable<JvmModelAssociator.Adapter> _filter = Iterables.<JvmModelAssociator.Adapter>filter(_eAdapters, JvmModelAssociator.Adapter.class);
      final JvmModelAssociator.Adapter existing = IterableExtensions.<JvmModelAssociator.Adapter>head(_filter);
      JvmModelAssociator.Adapter _elvis = null;
      if (existing != null) {
        _elvis = existing;
      } else {
        JvmModelAssociator.Adapter _adapter = new JvmModelAssociator.Adapter();
        final Procedure1<JvmModelAssociator.Adapter> _function = new Procedure1<JvmModelAssociator.Adapter>() {
          @Override
          public void apply(final JvmModelAssociator.Adapter it) {
            EList<Adapter> _eAdapters = resource.eAdapters();
            _eAdapters.add(it);
          }
        };
        JvmModelAssociator.Adapter _doubleArrow = ObjectExtensions.<JvmModelAssociator.Adapter>operator_doubleArrow(_adapter, _function);
        _elvis = _doubleArrow;
      }
      final JvmModelAssociator.Adapter adapter = _elvis;
      stream.getNextEntry();
      final ObjectInputStream objIn = new ObjectInputStream(stream);
      Object _readObject = objIn.readObject();
      final Map<String, String> logicalMap = ((Map<String, String>) _readObject);
      Set<Map.Entry<String, String>> _entrySet = logicalMap.entrySet();
      for (final Map.Entry<String, String> it : _entrySet) {
        String _key = it.getKey();
        EObject _eObject = resource.getEObject(_key);
        String _value = it.getValue();
        EObject _eObject_1 = resource.getEObject(_value);
        adapter.logicalContainerMap.put(_eObject, ((JvmIdentifiableElement) _eObject_1));
      }
      Object _readObject_1 = objIn.readObject();
      final Map<String, Set<String>> sourceToTargetMap = ((Map<String, Set<String>>) _readObject_1);
      Set<Map.Entry<String, Set<String>>> _entrySet_1 = sourceToTargetMap.entrySet();
      for (final Map.Entry<String, Set<String>> it_1 : _entrySet_1) {
        String _key_1 = it_1.getKey();
        EObject _eObject_2 = resource.getEObject(_key_1);
        Set<String> _value_1 = it_1.getValue();
        final Function1<String, EObject> _function_1 = new Function1<String, EObject>() {
          @Override
          public EObject apply(final String it) {
            return resource.getEObject(it);
          }
        };
        Iterable<EObject> _map = IterableExtensions.<String, EObject>map(_value_1, _function_1);
        HashSet<EObject> _newHashSet = Sets.<EObject>newHashSet(_map);
        adapter.sourceToTargetMap.put(_eObject_2, _newHashSet);
      }
      Object _readObject_2 = objIn.readObject();
      final Map<String, Set<String>> targetToSourceMap = ((Map<String, Set<String>>) _readObject_2);
      Set<Map.Entry<String, Set<String>>> _entrySet_2 = targetToSourceMap.entrySet();
      for (final Map.Entry<String, Set<String>> it_2 : _entrySet_2) {
        String _key_2 = it_2.getKey();
        EObject _eObject_3 = resource.getEObject(_key_2);
        Set<String> _value_2 = it_2.getValue();
        final Function1<String, EObject> _function_2 = new Function1<String, EObject>() {
          @Override
          public EObject apply(final String it) {
            return resource.getEObject(it);
          }
        };
        Iterable<EObject> _map_1 = IterableExtensions.<String, EObject>map(_value_2, _function_2);
        HashSet<EObject> _newHashSet_1 = Sets.<EObject>newHashSet(_map_1);
        adapter.targetToSourceMap.put(_eObject_3, _newHashSet_1);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public BatchLinkableResourceStorageLoadable(final InputStream in, final boolean storeNodeModel) {
    super(in, storeNodeModel);
  }
}
