/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.resource.AbstractXtextResourceSetTest;
import org.eclipse.xtext.resource.NullResource;
import org.eclipse.xtext.resource.SynchronizedXtextResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class SynchronizedXtextResourceSetTest extends AbstractXtextResourceSetTest {
  @Override
  protected XtextResourceSet createEmptyResourceSet() {
    return new SynchronizedXtextResourceSet();
  }
  
  @Test
  public void testSynchronization() {
    try {
      XtextResourceSet _createEmptyResourceSet = this.createEmptyResourceSet();
      final SynchronizedXtextResourceSet resourceSet = ((SynchronizedXtextResourceSet) _createEmptyResourceSet);
      final Resource.Factory _function = (URI uri) -> {
        NullResource _xblockexpression = null;
        {
          final NullResource result = new NullResource();
          result.setURI(uri);
          _xblockexpression = result;
        }
        return _xblockexpression;
      };
      final Resource.Factory nullFactory = _function;
      Resource.Factory.Registry _resourceFactoryRegistry = resourceSet.getResourceFactoryRegistry();
      Map<String, Object> _extensionToFactoryMap = _resourceFactoryRegistry.getExtensionToFactoryMap();
      _extensionToFactoryMap.put("xmi", nullFactory);
      final ArrayList<Thread> threads = CollectionLiterals.<Thread>newArrayList();
      IntegerRange _upTo = new IntegerRange(1, 10);
      final Consumer<Integer> _function_1 = (Integer i) -> {
        final Runnable _function_2 = () -> {
          final ArrayList<Resource> resources = CollectionLiterals.<Resource>newArrayList();
          for (int j = 0; (j < 5000); j++) {
            {
              String _plus = (i + " ");
              String _plus_1 = (_plus + Integer.valueOf(j));
              String _plus_2 = (_plus_1 + ".xmi");
              URI _createURI = URI.createURI(_plus_2);
              final Resource resource = resourceSet.createResource(_createURI);
              Assert.assertNotNull(resource);
              resources.add(resource);
              URI _uRI = resource.getURI();
              String _plus_3 = (_uRI + "b");
              URI _createURI_1 = URI.createURI(_plus_3);
              resource.setURI(_createURI_1);
            }
          }
        };
        Thread _thread = new Thread(_function_2);
        threads.add(_thread);
      };
      _upTo.forEach(_function_1);
      for (final Thread thread : threads) {
        thread.start();
      }
      for (final Thread thread_1 : threads) {
        thread_1.join();
      }
      EList<Resource> _resources = resourceSet.getResources();
      int _size = _resources.size();
      Assert.assertEquals(50000, _size);
      EList<Resource> _resources_1 = resourceSet.getResources();
      Set<Resource> _set = IterableExtensions.<Resource>toSet(_resources_1);
      int _size_1 = _set.size();
      Map<URI, Resource> _uRIResourceMap = resourceSet.getURIResourceMap();
      Collection<Resource> _values = _uRIResourceMap.values();
      Set<Resource> _set_1 = IterableExtensions.<Resource>toSet(_values);
      int _size_2 = _set_1.size();
      Assert.assertEquals(_size_1, _size_2);
      EList<Resource> _resources_2 = resourceSet.getResources();
      final Function1<Resource, List<URI>> _function_2 = (Resource it) -> {
        URI _uRI = it.getURI();
        URIConverter _uRIConverter = resourceSet.getURIConverter();
        URI _uRI_1 = it.getURI();
        URI _normalize = _uRIConverter.normalize(_uRI_1);
        return Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_uRI, _normalize));
      };
      List<List<URI>> _map = ListExtensions.<Resource, List<URI>>map(_resources_2, _function_2);
      Iterable<URI> _flatten = Iterables.<URI>concat(_map);
      Set<URI> _set_2 = IterableExtensions.<URI>toSet(_flatten);
      Map<URI, Resource> _uRIResourceMap_1 = resourceSet.getURIResourceMap();
      Set<URI> _keySet = _uRIResourceMap_1.keySet();
      Assert.assertEquals(_set_2, _keySet);
      EList<Resource> _resources_3 = resourceSet.getResources();
      final Function1<Resource, String> _function_3 = (Resource it) -> {
        URI _uRI = it.getURI();
        return _uRI.toString();
      };
      List<String> _map_1 = ListExtensions.<Resource, String>map(_resources_3, _function_3);
      List<String> _list = IterableExtensions.<String>toList(_map_1);
      List<String> _sort = IterableExtensions.<String>sort(_list);
      String _join = IterableExtensions.join(_sort, "\n");
      Map<URI, URI> _normalizationMap = resourceSet.getNormalizationMap();
      Set<URI> _keySet_1 = _normalizationMap.keySet();
      final Function1<URI, String> _function_4 = (URI it) -> {
        return it.toString();
      };
      Iterable<String> _map_2 = IterableExtensions.<URI, String>map(_keySet_1, _function_4);
      List<String> _list_1 = IterableExtensions.<String>toList(_map_2);
      List<String> _sort_1 = IterableExtensions.<String>sort(_list_1);
      String _join_1 = IterableExtensions.join(_sort_1, "\n");
      Assert.assertEquals(_join, _join_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
