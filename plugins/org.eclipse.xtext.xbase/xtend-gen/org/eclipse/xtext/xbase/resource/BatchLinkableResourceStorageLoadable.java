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
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;

@SuppressWarnings("all")
public class BatchLinkableResourceStorageLoadable extends ResourceStorageLoadable {
  public BatchLinkableResourceStorageLoadable(final InputStream in) {
    super(in);
  }
  
  protected void loadEntries(final StorageAwareResource resource, final ZipInputStream zipIn) {
    super.loadEntries(resource, zipIn);
    if ((resource instanceof BatchLinkableResource)) {
      this.readAssociationsAdapter(((BatchLinkableResource)resource), zipIn);
    }
  }
  
  protected void readAssociationsAdapter(final BatchLinkableResource resource, final ZipInputStream stream) {
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
      final Procedure1<Map.Entry<String, String>> _function_1 = new Procedure1<Map.Entry<String, String>>() {
        public void apply(final Map.Entry<String, String> it) {
          String _key = it.getKey();
          EObject _eObject = resource.getEObject(_key);
          String _value = it.getValue();
          EObject _eObject_1 = resource.getEObject(_value);
          adapter.logicalContainerMap.put(_eObject, ((JvmIdentifiableElement) _eObject_1));
        }
      };
      IterableExtensions.<Map.Entry<String, String>>forEach(_entrySet, _function_1);
      Object _readObject_1 = objIn.readObject();
      final Map<String, Set<String>> sourceToTargetMap = ((Map<String, Set<String>>) _readObject_1);
      Set<Map.Entry<String, Set<String>>> _entrySet_1 = sourceToTargetMap.entrySet();
      final Procedure1<Map.Entry<String, Set<String>>> _function_2 = new Procedure1<Map.Entry<String, Set<String>>>() {
        public void apply(final Map.Entry<String, Set<String>> it) {
          String _key = it.getKey();
          EObject _eObject = resource.getEObject(_key);
          Set<String> _value = it.getValue();
          final Function1<String, EObject> _function = new Function1<String, EObject>() {
            public EObject apply(final String it) {
              return resource.getEObject(it);
            }
          };
          Iterable<EObject> _map = IterableExtensions.<String, EObject>map(_value, _function);
          HashSet<EObject> _newHashSet = Sets.<EObject>newHashSet(_map);
          adapter.sourceToTargetMap.put(_eObject, _newHashSet);
        }
      };
      IterableExtensions.<Map.Entry<String, Set<String>>>forEach(_entrySet_1, _function_2);
      Object _readObject_2 = objIn.readObject();
      final Map<String, Set<String>> targetToSourceMap = ((Map<String, Set<String>>) _readObject_2);
      Set<Map.Entry<String, Set<String>>> _entrySet_2 = targetToSourceMap.entrySet();
      final Procedure1<Map.Entry<String, Set<String>>> _function_3 = new Procedure1<Map.Entry<String, Set<String>>>() {
        public void apply(final Map.Entry<String, Set<String>> it) {
          String _key = it.getKey();
          EObject _eObject = resource.getEObject(_key);
          Set<String> _value = it.getValue();
          final Function1<String, EObject> _function = new Function1<String, EObject>() {
            public EObject apply(final String it) {
              return resource.getEObject(it);
            }
          };
          Iterable<EObject> _map = IterableExtensions.<String, EObject>map(_value, _function);
          HashSet<EObject> _newHashSet = Sets.<EObject>newHashSet(_map);
          adapter.targetToSourceMap.put(_eObject, _newHashSet);
        }
      };
      IterableExtensions.<Map.Entry<String, Set<String>>>forEach(_entrySet_2, _function_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
