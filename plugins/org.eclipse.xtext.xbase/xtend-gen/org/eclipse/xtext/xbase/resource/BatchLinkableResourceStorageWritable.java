/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.resource;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter;
import org.eclipse.xtext.xbase.jvmmodel.JvmIdentifiableMetaData;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;
import org.eclipse.xtext.xtype.XComputedTypeReference;

/**
 * @author Sven Efftinge
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class BatchLinkableResourceStorageWritable extends ResourceStorageWritable {
  private final static Logger LOG = Logger.getLogger(BatchLinkableResourceStorageWritable.class);
  
  @Override
  protected void writeEntries(final StorageAwareResource resource, final ZipOutputStream zipOut) throws IOException {
    super.writeEntries(resource, zipOut);
    if ((resource instanceof BatchLinkableResource)) {
      ZipEntry _zipEntry = new ZipEntry("associations");
      zipOut.putNextEntry(_zipEntry);
      final BufferedOutputStream buffOut = new BufferedOutputStream(zipOut);
      try {
        this.writeAssociationsAdapter(((BatchLinkableResource)resource), buffOut);
      } finally {
        buffOut.flush();
        zipOut.closeEntry();
      }
    }
  }
  
  @Override
  protected Object beforeSaveEObject(final InternalEObject object, final BinaryResourceImpl.EObjectOutputStream writable) throws IOException {
    JvmType _xblockexpression = null;
    {
      super.beforeSaveEObject(object, writable);
      JvmType _xifexpression = null;
      if ((object instanceof XComputedTypeReference)) {
        _xifexpression = ((XComputedTypeReference)object).getType();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  protected void handleSaveEObject(final InternalEObject object, final BinaryResourceImpl.EObjectOutputStream out) throws IOException {
    super.handleSaveEObject(object, out);
    DocumentationAdapter documentationAdapter = null;
    JvmIdentifiableMetaData metaDataAdapter = null;
    EList<Adapter> _eAdapters = object.eAdapters();
    for (final Adapter adapter : _eAdapters) {
      {
        if ((adapter instanceof DocumentationAdapter)) {
          documentationAdapter = ((DocumentationAdapter)adapter);
        }
        if ((adapter instanceof JvmIdentifiableMetaData)) {
          metaDataAdapter = ((JvmIdentifiableMetaData)adapter);
        }
      }
    }
    boolean _notEquals = (!Objects.equal(documentationAdapter, null));
    if (_notEquals) {
      out.writeBoolean(true);
      String _documentation = documentationAdapter.getDocumentation();
      out.writeString(_documentation);
    } else {
      out.writeBoolean(false);
    }
    boolean _notEquals_1 = (!Objects.equal(metaDataAdapter, null));
    if (_notEquals_1) {
      out.writeBoolean(true);
      boolean _isSynthetic = metaDataAdapter.isSynthetic();
      out.writeBoolean(_isSynthetic);
    } else {
      out.writeBoolean(false);
    }
  }
  
  protected void writeAssociationsAdapter(final BatchLinkableResource resource, final OutputStream zipOut) throws IOException {
    EList<Adapter> _eAdapters = resource.eAdapters();
    Iterable<JvmModelAssociator.Adapter> _filter = Iterables.<JvmModelAssociator.Adapter>filter(_eAdapters, JvmModelAssociator.Adapter.class);
    JvmModelAssociator.Adapter adapter = IterableExtensions.<JvmModelAssociator.Adapter>head(_filter);
    if ((adapter == null)) {
      EList<EObject> _contents = resource.getContents();
      Iterable<EObject> _tail = IterableExtensions.<EObject>tail(_contents);
      final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
        @Override
        public Boolean apply(final EObject it) {
          return Boolean.valueOf((it instanceof JvmType));
        }
      };
      boolean _exists = IterableExtensions.<EObject>exists(_tail, _function);
      if (_exists) {
        URI _uRI = resource.getURI();
        String _plus = ("Missing JvmModelAssociator.Adapter but resource contains inferred types: " + _uRI);
        throw new IOException(_plus);
      }
      JvmModelAssociator.Adapter _adapter = new JvmModelAssociator.Adapter();
      adapter = _adapter;
    }
    final ObjectOutputStream objOut = new ObjectOutputStream(zipOut);
    try {
      final HashMap<String, String> logicalMap = CollectionLiterals.<String, String>newHashMap();
      Set<Map.Entry<EObject, JvmIdentifiableElement>> _entrySet = adapter.logicalContainerMap.entrySet();
      for (final Map.Entry<EObject, JvmIdentifiableElement> entry : _entrySet) {
        EObject _key = entry.getKey();
        Resource _eResource = _key.eResource();
        boolean _notEquals = (!Objects.equal(_eResource, resource));
        if (_notEquals) {
          URI _uRI_1 = resource.getURI();
          String _plus_1 = ((("entry " + entry) + " not from resource ") + _uRI_1);
          String _plus_2 = (_plus_1 + " but from ");
          EObject _key_1 = entry.getKey();
          Resource _eResource_1 = _key_1.eResource();
          URI _uRI_2 = null;
          if (_eResource_1!=null) {
            _uRI_2=_eResource_1.getURI();
          }
          String _plus_3 = (_plus_2 + _uRI_2);
          BatchLinkableResourceStorageWritable.LOG.info(_plus_3);
        } else {
          EObject _key_2 = entry.getKey();
          String _fragment = this.getFragment(_key_2);
          JvmIdentifiableElement _value = entry.getValue();
          String _fragment_1 = this.getFragment(_value);
          logicalMap.put(_fragment, _fragment_1);
        }
      }
      objOut.writeObject(logicalMap);
      final HashMap<String, HashSet<String>> sourceToTarget = CollectionLiterals.<String, HashSet<String>>newHashMap();
      Set<Map.Entry<EObject, Set<EObject>>> _entrySet_1 = adapter.sourceToTargetMap.entrySet();
      for (final Map.Entry<EObject, Set<EObject>> entry_1 : _entrySet_1) {
        EObject _key_3 = entry_1.getKey();
        Resource _eResource_2 = _key_3.eResource();
        boolean _notEquals_1 = (!Objects.equal(_eResource_2, resource));
        if (_notEquals_1) {
          URI _uRI_3 = resource.getURI();
          String _plus_4 = ("entry not from resource " + _uRI_3);
          String _plus_5 = (_plus_4 + " but from ");
          EObject _key_4 = entry_1.getKey();
          Resource _eResource_3 = _key_4.eResource();
          URI _uRI_4 = null;
          if (_eResource_3!=null) {
            _uRI_4=_eResource_3.getURI();
          }
          String _plus_6 = (_plus_5 + _uRI_4);
          BatchLinkableResourceStorageWritable.LOG.info(_plus_6);
        } else {
          EObject _key_5 = entry_1.getKey();
          String _fragment_2 = this.getFragment(_key_5);
          Set<EObject> _value_1 = entry_1.getValue();
          final Function1<EObject, String> _function_1 = new Function1<EObject, String>() {
            @Override
            public String apply(final EObject it) {
              return BatchLinkableResourceStorageWritable.this.getFragment(it);
            }
          };
          Iterable<String> _map = IterableExtensions.<EObject, String>map(_value_1, _function_1);
          HashSet<String> _newHashSet = Sets.<String>newHashSet(_map);
          sourceToTarget.put(_fragment_2, _newHashSet);
        }
      }
      objOut.writeObject(sourceToTarget);
      final HashMap<String, HashSet<String>> targetToSource = CollectionLiterals.<String, HashSet<String>>newHashMap();
      Set<Map.Entry<EObject, Set<EObject>>> _entrySet_2 = adapter.targetToSourceMap.entrySet();
      for (final Map.Entry<EObject, Set<EObject>> entry_2 : _entrySet_2) {
        EObject _key_6 = entry_2.getKey();
        Resource _eResource_4 = _key_6.eResource();
        boolean _notEquals_2 = (!Objects.equal(_eResource_4, resource));
        if (_notEquals_2) {
          URI _uRI_5 = resource.getURI();
          String _plus_7 = ("entry not from resource " + _uRI_5);
          String _plus_8 = (_plus_7 + " but from ");
          EObject _key_7 = entry_2.getKey();
          Resource _eResource_5 = _key_7.eResource();
          URI _uRI_6 = null;
          if (_eResource_5!=null) {
            _uRI_6=_eResource_5.getURI();
          }
          String _plus_9 = (_plus_8 + _uRI_6);
          BatchLinkableResourceStorageWritable.LOG.info(_plus_9);
        } else {
          EObject _key_8 = entry_2.getKey();
          String _fragment_3 = this.getFragment(_key_8);
          Set<EObject> _value_2 = entry_2.getValue();
          final Function1<EObject, String> _function_2 = new Function1<EObject, String>() {
            @Override
            public String apply(final EObject it) {
              return BatchLinkableResourceStorageWritable.this.getFragment(it);
            }
          };
          Iterable<String> _map_1 = IterableExtensions.<EObject, String>map(_value_2, _function_2);
          HashSet<String> _newHashSet_1 = Sets.<String>newHashSet(_map_1);
          targetToSource.put(_fragment_3, _newHashSet_1);
        }
      }
      objOut.writeObject(targetToSource);
    } finally {
      objOut.flush();
    }
  }
  
  protected String getFragment(final EObject obj) {
    String _xblockexpression = null;
    {
      if (((Objects.equal(obj, null) || obj.eIsProxy()) || Objects.equal(obj.eResource(), null))) {
        return "none";
      }
      Resource _eResource = obj.eResource();
      _xblockexpression = _eResource.getURIFragment(obj);
    }
    return _xblockexpression;
  }
  
  public BatchLinkableResourceStorageWritable(final OutputStream out, final boolean storeNodeModel) {
    super(out, storeNodeModel);
  }
}
