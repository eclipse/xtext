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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.resource.persistence.ResourceStorageOutputStream;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;

@SuppressWarnings("all")
public class BatchLinkableResourceStorageOutputStream extends ResourceStorageOutputStream {
  private final static Logger LOG = Logger.getLogger(BatchLinkableResourceStorageOutputStream.class);
  
  public BatchLinkableResourceStorageOutputStream(final OutputStream out) {
    super(out);
  }
  
  protected void writeEntries(final StorageAwareResource resource, final ZipOutputStream zipOut) {
    super.writeEntries(resource, zipOut);
    if ((resource instanceof BatchLinkableResource)) {
      this.writeAssociationsAdapter(((BatchLinkableResource)resource), zipOut);
    }
  }
  
  protected void writeAssociationsAdapter(final BatchLinkableResource resource, final ZipOutputStream zipOut) {
    try {
      EList<Adapter> _eAdapters = resource.eAdapters();
      Iterable<JvmModelAssociator.Adapter> _filter = Iterables.<JvmModelAssociator.Adapter>filter(_eAdapters, JvmModelAssociator.Adapter.class);
      final JvmModelAssociator.Adapter adapter = IterableExtensions.<JvmModelAssociator.Adapter>head(_filter);
      boolean _equals = Objects.equal(adapter, null);
      if (_equals) {
        URI _uRI = resource.getURI();
        String _plus = ("No associations in " + _uRI);
        IllegalStateException _illegalStateException = new IllegalStateException();
        BatchLinkableResourceStorageOutputStream.LOG.error(_plus, _illegalStateException);
      } else {
        ZipEntry _zipEntry = new ZipEntry("associations");
        zipOut.putNextEntry(_zipEntry);
        final ObjectOutputStream objOut = new ObjectOutputStream(zipOut);
        final HashMap<String, String> logicalMap = CollectionLiterals.<String, String>newHashMap();
        Set<Map.Entry<EObject, JvmIdentifiableElement>> _entrySet = adapter.logicalContainerMap.entrySet();
        for (final Map.Entry<EObject, JvmIdentifiableElement> entry : _entrySet) {
          EObject _key = entry.getKey();
          Resource _eResource = _key.eResource();
          boolean _notEquals = (!Objects.equal(_eResource, resource));
          if (_notEquals) {
            URI _uRI_1 = resource.getURI();
            String _plus_1 = ("entry not from resource " + _uRI_1);
            String _plus_2 = (_plus_1 + " but from ");
            EObject _key_1 = entry.getKey();
            Resource _eResource_1 = _key_1.eResource();
            URI _uRI_2 = _eResource_1.getURI();
            String _plus_3 = (_plus_2 + _uRI_2);
            BatchLinkableResourceStorageOutputStream.LOG.error(_plus_3);
          } else {
            EObject _key_2 = entry.getKey();
            String _fragment = this.getFragment(_key_2);
            JvmIdentifiableElement _value = entry.getValue();
            String _fragment_1 = this.getFragment(_value);
            logicalMap.put(_fragment, _fragment_1);
          }
        }
        objOut.writeObject(logicalMap);
        final HashMap<String, HashSet<Iterable<String>>> sourceToTarget = CollectionLiterals.<String, HashSet<Iterable<String>>>newHashMap();
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
            URI _uRI_4 = _eResource_3.getURI();
            String _plus_6 = (_plus_5 + _uRI_4);
            BatchLinkableResourceStorageOutputStream.LOG.error(_plus_6);
          } else {
            EObject _key_5 = entry_1.getKey();
            String _fragment_2 = this.getFragment(_key_5);
            Set<EObject> _value_1 = entry_1.getValue();
            final Function1<EObject, String> _function = new Function1<EObject, String>() {
              public String apply(final EObject it) {
                return BatchLinkableResourceStorageOutputStream.this.getFragment(it);
              }
            };
            Iterable<String> _map = IterableExtensions.<EObject, String>map(_value_1, _function);
            HashSet<Iterable<String>> _newHashSet = CollectionLiterals.<Iterable<String>>newHashSet(_map);
            sourceToTarget.put(_fragment_2, _newHashSet);
          }
        }
        objOut.writeObject(sourceToTarget);
        final HashMap<String, HashSet<Iterable<String>>> targetToSource = CollectionLiterals.<String, HashSet<Iterable<String>>>newHashMap();
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
            URI _uRI_6 = _eResource_5.getURI();
            String _plus_9 = (_plus_8 + _uRI_6);
            BatchLinkableResourceStorageOutputStream.LOG.error(_plus_9);
          } else {
            EObject _key_8 = entry_2.getKey();
            String _fragment_3 = this.getFragment(_key_8);
            Set<EObject> _value_2 = entry_2.getValue();
            final Function1<EObject, String> _function_1 = new Function1<EObject, String>() {
              public String apply(final EObject it) {
                return BatchLinkableResourceStorageOutputStream.this.getFragment(it);
              }
            };
            Iterable<String> _map_1 = IterableExtensions.<EObject, String>map(_value_2, _function_1);
            HashSet<Iterable<String>> _newHashSet_1 = CollectionLiterals.<Iterable<String>>newHashSet(_map_1);
            targetToSource.put(_fragment_3, _newHashSet_1);
          }
        }
        objOut.writeObject(targetToSource);
        zipOut.closeEntry();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String getFragment(final EObject obj) {
    Resource _eResource = obj.eResource();
    return _eResource.getURIFragment(obj);
  }
}
