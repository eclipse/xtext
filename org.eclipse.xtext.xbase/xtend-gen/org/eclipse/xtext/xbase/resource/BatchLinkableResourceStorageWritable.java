/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.resource;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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
  private static final Logger LOG = Logger.getLogger(BatchLinkableResourceStorageWritable.class);
  
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
    if ((documentationAdapter != null)) {
      out.writeBoolean(true);
      out.writeString(documentationAdapter.getDocumentation());
    } else {
      out.writeBoolean(false);
    }
    if ((metaDataAdapter != null)) {
      out.writeBoolean(true);
      out.writeBoolean(metaDataAdapter.isSynthetic());
    } else {
      out.writeBoolean(false);
    }
  }
  
  protected void writeAssociationsAdapter(final BatchLinkableResource resource, final OutputStream zipOut) throws IOException {
    JvmModelAssociator.Adapter adapter = IterableExtensions.<JvmModelAssociator.Adapter>head(Iterables.<JvmModelAssociator.Adapter>filter(resource.eAdapters(), JvmModelAssociator.Adapter.class));
    if ((adapter == null)) {
      final Function1<EObject, Boolean> _function = (EObject it) -> {
        return Boolean.valueOf((it instanceof JvmType));
      };
      boolean _exists = IterableExtensions.<EObject>exists(IterableExtensions.<EObject>tail(resource.getContents()), _function);
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
      final LinkedHashMap<String, String> logicalMap = CollectionLiterals.<String, String>newLinkedHashMap();
      Set<Map.Entry<EObject, JvmIdentifiableElement>> _entrySet = adapter.logicalContainerMap.entrySet();
      for (final Map.Entry<EObject, JvmIdentifiableElement> entry : _entrySet) {
        Resource _eResource = entry.getKey().eResource();
        boolean _notEquals = (!Objects.equal(_eResource, resource));
        if (_notEquals) {
          URI _uRI_1 = resource.getURI();
          String _plus_1 = ((("entry " + entry) + " not from resource ") + _uRI_1);
          String _plus_2 = (_plus_1 + " but from ");
          Resource _eResource_1 = entry.getKey().eResource();
          URI _uRI_2 = null;
          if (_eResource_1!=null) {
            _uRI_2=_eResource_1.getURI();
          }
          String _plus_3 = (_plus_2 + _uRI_2);
          BatchLinkableResourceStorageWritable.LOG.info(_plus_3);
        } else {
          logicalMap.put(this.getFragment(entry.getKey()), this.getFragment(entry.getValue()));
        }
      }
      objOut.writeObject(logicalMap);
      final LinkedHashMap<String, LinkedHashSet<String>> sourceToTarget = CollectionLiterals.<String, LinkedHashSet<String>>newLinkedHashMap();
      Set<Map.Entry<EObject, Set<EObject>>> _entrySet_1 = adapter.sourceToTargetMap.entrySet();
      for (final Map.Entry<EObject, Set<EObject>> entry_1 : _entrySet_1) {
        Resource _eResource_2 = entry_1.getKey().eResource();
        boolean _notEquals_1 = (!Objects.equal(_eResource_2, resource));
        if (_notEquals_1) {
          URI _uRI_3 = resource.getURI();
          String _plus_4 = ("entry not from resource " + _uRI_3);
          String _plus_5 = (_plus_4 + " but from ");
          Resource _eResource_3 = entry_1.getKey().eResource();
          URI _uRI_4 = null;
          if (_eResource_3!=null) {
            _uRI_4=_eResource_3.getURI();
          }
          String _plus_6 = (_plus_5 + _uRI_4);
          BatchLinkableResourceStorageWritable.LOG.info(_plus_6);
        } else {
          final Function1<EObject, String> _function_1 = (EObject it) -> {
            return this.getFragment(it);
          };
          sourceToTarget.put(this.getFragment(entry_1.getKey()), Sets.<String>newLinkedHashSet(IterableExtensions.<EObject, String>map(entry_1.getValue(), _function_1)));
        }
      }
      objOut.writeObject(sourceToTarget);
      final LinkedHashMap<String, LinkedHashSet<String>> targetToSource = CollectionLiterals.<String, LinkedHashSet<String>>newLinkedHashMap();
      Set<Map.Entry<EObject, Set<EObject>>> _entrySet_2 = adapter.targetToSourceMap.entrySet();
      for (final Map.Entry<EObject, Set<EObject>> entry_2 : _entrySet_2) {
        Resource _eResource_4 = entry_2.getKey().eResource();
        boolean _notEquals_2 = (!Objects.equal(_eResource_4, resource));
        if (_notEquals_2) {
          URI _uRI_5 = resource.getURI();
          String _plus_7 = ("entry not from resource " + _uRI_5);
          String _plus_8 = (_plus_7 + " but from ");
          Resource _eResource_5 = entry_2.getKey().eResource();
          URI _uRI_6 = null;
          if (_eResource_5!=null) {
            _uRI_6=_eResource_5.getURI();
          }
          String _plus_9 = (_plus_8 + _uRI_6);
          BatchLinkableResourceStorageWritable.LOG.info(_plus_9);
        } else {
          final Function1<EObject, String> _function_2 = (EObject it) -> {
            return this.getFragment(it);
          };
          targetToSource.put(this.getFragment(entry_2.getKey()), Sets.<String>newLinkedHashSet(IterableExtensions.<EObject, String>map(entry_2.getValue(), _function_2)));
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
      if ((((obj == null) || obj.eIsProxy()) || (obj.eResource() == null))) {
        return "none";
      }
      _xblockexpression = obj.eResource().getURIFragment(obj);
    }
    return _xblockexpression;
  }
  
  public BatchLinkableResourceStorageWritable(final OutputStream out, final boolean storeNodeModel) {
    super(out, storeNodeModel);
  }
}
