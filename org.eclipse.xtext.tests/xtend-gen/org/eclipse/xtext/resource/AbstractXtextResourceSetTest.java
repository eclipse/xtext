/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.resource.AbstractResourceSetTest;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public abstract class AbstractXtextResourceSetTest extends AbstractResourceSetTest {
  @Override
  protected abstract XtextResourceSet createEmptyResourceSet();
  
  @Test
  public void testResourcesAreInMap() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final XtextResource resource = new XtextResource();
    File _file = new File("foo");
    String _absolutePath = _file.getAbsolutePath();
    URI _createFileURI = URI.createFileURI(_absolutePath);
    resource.setURI(_createFileURI);
    EList<Resource> _resources = rs.getResources();
    _resources.add(resource);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(1, _size_1);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.remove(resource);
    EList<Adapter> _eAdapters = resource.eAdapters();
    boolean _isEmpty = _eAdapters.isEmpty();
    Assert.assertTrue(_isEmpty);
    Map<URI, Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_2.size();
    Assert.assertEquals(0, _size_2);
  }
  
  @Test
  public void testResourcesAreInMap_02() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final XtextResource resource = new XtextResource();
    File _file = new File("foo");
    String _absolutePath = _file.getAbsolutePath();
    URI _createFileURI = URI.createFileURI(_absolutePath);
    resource.setURI(_createFileURI);
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(1, _size_1);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.remove(resource);
    EList<Adapter> _eAdapters = resource.eAdapters();
    boolean _isEmpty = _eAdapters.isEmpty();
    Assert.assertTrue(_isEmpty);
    Map<URI, Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_2.size();
    Assert.assertEquals(0, _size_2);
  }
  
  @Test
  public void testResourcesAreInMap_03() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final XtextResource resource = new XtextResource();
    EList<Resource> _resources = rs.getResources();
    _resources.add(resource);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(1, _size_1);
    Map<URI, Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    Resource _get = _uRIResourceMap_2.get(null);
    Assert.assertEquals(resource, _get);
    File _file = new File("foo");
    String _absolutePath = _file.getAbsolutePath();
    URI _createFileURI = URI.createFileURI(_absolutePath);
    resource.setURI(_createFileURI);
    Map<URI, Resource> _uRIResourceMap_3 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_3.size();
    Assert.assertEquals(1, _size_2);
    Map<URI, Resource> _uRIResourceMap_4 = rs.getURIResourceMap();
    boolean _containsKey = _uRIResourceMap_4.containsKey(null);
    Assert.assertFalse(_containsKey);
    Map<URI, Resource> _uRIResourceMap_5 = rs.getURIResourceMap();
    URI _uRI = resource.getURI();
    Resource _get_1 = _uRIResourceMap_5.get(_uRI);
    Assert.assertEquals(resource, _get_1);
    Map<URI, Resource> _uRIResourceMap_6 = rs.getURIResourceMap();
    URIConverter _uRIConverter = rs.getURIConverter();
    URI _uRI_1 = resource.getURI();
    URI _normalize = _uRIConverter.normalize(_uRI_1);
    Resource _get_2 = _uRIResourceMap_6.get(_normalize);
    Assert.assertEquals(resource, _get_2);
    File _file_1 = new File("bar");
    String _absolutePath_1 = _file_1.getAbsolutePath();
    URI _createFileURI_1 = URI.createFileURI(_absolutePath_1);
    resource.setURI(_createFileURI_1);
    Map<URI, Resource> _uRIResourceMap_7 = rs.getURIResourceMap();
    int _size_3 = _uRIResourceMap_7.size();
    Assert.assertEquals(1, _size_3);
    Map<URI, Resource> _uRIResourceMap_8 = rs.getURIResourceMap();
    boolean _containsKey_1 = _uRIResourceMap_8.containsKey(null);
    Assert.assertFalse(_containsKey_1);
    Map<URI, Resource> _uRIResourceMap_9 = rs.getURIResourceMap();
    URI _uRI_2 = resource.getURI();
    Resource _get_3 = _uRIResourceMap_9.get(_uRI_2);
    Assert.assertEquals(resource, _get_3);
    Map<URI, Resource> _uRIResourceMap_10 = rs.getURIResourceMap();
    URIConverter _uRIConverter_1 = rs.getURIConverter();
    URI _uRI_3 = resource.getURI();
    URI _normalize_1 = _uRIConverter_1.normalize(_uRI_3);
    Resource _get_4 = _uRIResourceMap_10.get(_normalize_1);
    Assert.assertEquals(resource, _get_4);
    resource.setURI(null);
    Map<URI, Resource> _uRIResourceMap_11 = rs.getURIResourceMap();
    int _size_4 = _uRIResourceMap_11.size();
    Assert.assertEquals(1, _size_4);
    Map<URI, Resource> _uRIResourceMap_12 = rs.getURIResourceMap();
    Resource _get_5 = _uRIResourceMap_12.get(null);
    Assert.assertEquals(resource, _get_5);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.remove(resource);
    EList<Adapter> _eAdapters = resource.eAdapters();
    boolean _isEmpty = _eAdapters.isEmpty();
    Assert.assertTrue(_isEmpty);
    Map<URI, Resource> _uRIResourceMap_13 = rs.getURIResourceMap();
    int _size_5 = _uRIResourceMap_13.size();
    Assert.assertEquals(0, _size_5);
  }
  
  @Test
  public void testResourcesAreCleared_01() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final XtextResource resource = new XtextResource();
    File _file = new File("foo");
    String _absolutePath = _file.getAbsolutePath();
    URI _createFileURI = URI.createFileURI(_absolutePath);
    resource.setURI(_createFileURI);
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(1, _size_1);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.clear();
    EList<Adapter> _eAdapters = resource.eAdapters();
    boolean _isEmpty = _eAdapters.isEmpty();
    Assert.assertTrue(_isEmpty);
    Map<URI, Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_2.size();
    Assert.assertEquals(0, _size_2);
  }
  
  @Test
  public void testResourcesAreClearedWithDeliverFalse_01() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final XtextResource resource = new XtextResource();
    File _file = new File("foo");
    String _absolutePath = _file.getAbsolutePath();
    URI _createFileURI = URI.createFileURI(_absolutePath);
    resource.setURI(_createFileURI);
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(1, _size_1);
    rs.eSetDeliver(false);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.clear();
    EList<Adapter> _eAdapters = resource.eAdapters();
    boolean _isEmpty = _eAdapters.isEmpty();
    Assert.assertTrue(_isEmpty);
    Map<URI, Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_2.size();
    Assert.assertEquals(0, _size_2);
  }
  
  @Test
  public void testResourcesAreInMapWithNormalizedURI_01() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final XtextResource resource = new XtextResource();
    URI _createURI = URI.createURI("/a/../foo");
    resource.setURI(_createURI);
    EList<Resource> _resources = rs.getResources();
    _resources.add(resource);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(2, _size_1);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.remove(resource);
    EList<Adapter> _eAdapters = resource.eAdapters();
    boolean _isEmpty = _eAdapters.isEmpty();
    Assert.assertTrue(_isEmpty);
    Map<URI, Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_2.size();
    Assert.assertEquals(0, _size_2);
  }
  
  @Test
  public void testResourcesAreInMapWithNormalizedURI_02() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final XtextResource resource = new XtextResource();
    URI _createURI = URI.createURI("/a/../foo");
    resource.setURI(_createURI);
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(2, _size_1);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.remove(resource);
    EList<Adapter> _eAdapters = resource.eAdapters();
    boolean _isEmpty = _eAdapters.isEmpty();
    Assert.assertTrue(_isEmpty);
    Map<URI, Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_2.size();
    Assert.assertEquals(0, _size_2);
  }
  
  @Test
  public void testResourcesAreInMapWithNormalizedURI_03() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final XtextResource resource = new XtextResource();
    EList<Resource> _resources = rs.getResources();
    _resources.add(resource);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(1, _size_1);
    Map<URI, Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    Resource _get = _uRIResourceMap_2.get(null);
    Assert.assertEquals(resource, _get);
    Map<URI, URI> _normalizationMap = rs.getNormalizationMap();
    int _size_2 = _normalizationMap.size();
    Assert.assertEquals(0, _size_2);
    URI _createURI = URI.createURI("/a/../foo");
    resource.setURI(_createURI);
    Map<URI, Resource> _uRIResourceMap_3 = rs.getURIResourceMap();
    int _size_3 = _uRIResourceMap_3.size();
    Assert.assertEquals(2, _size_3);
    Map<URI, Resource> _uRIResourceMap_4 = rs.getURIResourceMap();
    boolean _containsKey = _uRIResourceMap_4.containsKey(null);
    Assert.assertFalse(_containsKey);
    Map<URI, Resource> _uRIResourceMap_5 = rs.getURIResourceMap();
    URI _uRI = resource.getURI();
    Resource _get_1 = _uRIResourceMap_5.get(_uRI);
    Assert.assertEquals(resource, _get_1);
    Map<URI, Resource> _uRIResourceMap_6 = rs.getURIResourceMap();
    URIConverter _uRIConverter = rs.getURIConverter();
    URI _uRI_1 = resource.getURI();
    URI _normalize = _uRIConverter.normalize(_uRI_1);
    Resource _get_2 = _uRIResourceMap_6.get(_normalize);
    Assert.assertEquals(resource, _get_2);
    Map<URI, URI> _normalizationMap_1 = rs.getNormalizationMap();
    int _size_4 = _normalizationMap_1.size();
    Assert.assertEquals(1, _size_4);
    URIConverter _uRIConverter_1 = rs.getURIConverter();
    URI _uRI_2 = resource.getURI();
    URI _normalize_1 = _uRIConverter_1.normalize(_uRI_2);
    Map<URI, URI> _normalizationMap_2 = rs.getNormalizationMap();
    URI _uRI_3 = resource.getURI();
    URI _get_3 = _normalizationMap_2.get(_uRI_3);
    Assert.assertEquals(_normalize_1, _get_3);
    URI _createURI_1 = URI.createURI("/a/../bar");
    resource.setURI(_createURI_1);
    Map<URI, Resource> _uRIResourceMap_7 = rs.getURIResourceMap();
    int _size_5 = _uRIResourceMap_7.size();
    Assert.assertEquals(2, _size_5);
    Map<URI, Resource> _uRIResourceMap_8 = rs.getURIResourceMap();
    boolean _containsKey_1 = _uRIResourceMap_8.containsKey(null);
    Assert.assertFalse(_containsKey_1);
    Map<URI, Resource> _uRIResourceMap_9 = rs.getURIResourceMap();
    URI _uRI_4 = resource.getURI();
    Resource _get_4 = _uRIResourceMap_9.get(_uRI_4);
    Assert.assertEquals(resource, _get_4);
    Map<URI, Resource> _uRIResourceMap_10 = rs.getURIResourceMap();
    URIConverter _uRIConverter_2 = rs.getURIConverter();
    URI _uRI_5 = resource.getURI();
    URI _normalize_2 = _uRIConverter_2.normalize(_uRI_5);
    Resource _get_5 = _uRIResourceMap_10.get(_normalize_2);
    Assert.assertEquals(resource, _get_5);
    Map<URI, URI> _normalizationMap_3 = rs.getNormalizationMap();
    int _size_6 = _normalizationMap_3.size();
    Assert.assertEquals(1, _size_6);
    URIConverter _uRIConverter_3 = rs.getURIConverter();
    URI _uRI_6 = resource.getURI();
    URI _normalize_3 = _uRIConverter_3.normalize(_uRI_6);
    Map<URI, URI> _normalizationMap_4 = rs.getNormalizationMap();
    URI _uRI_7 = resource.getURI();
    URI _get_6 = _normalizationMap_4.get(_uRI_7);
    Assert.assertEquals(_normalize_3, _get_6);
    resource.setURI(null);
    Map<URI, Resource> _uRIResourceMap_11 = rs.getURIResourceMap();
    int _size_7 = _uRIResourceMap_11.size();
    Assert.assertEquals(1, _size_7);
    Map<URI, Resource> _uRIResourceMap_12 = rs.getURIResourceMap();
    Resource _get_7 = _uRIResourceMap_12.get(null);
    Assert.assertEquals(resource, _get_7);
    Map<URI, URI> _normalizationMap_5 = rs.getNormalizationMap();
    int _size_8 = _normalizationMap_5.size();
    Assert.assertEquals(0, _size_8);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.remove(resource);
    EList<Adapter> _eAdapters = resource.eAdapters();
    boolean _isEmpty = _eAdapters.isEmpty();
    Assert.assertTrue(_isEmpty);
    Map<URI, Resource> _uRIResourceMap_13 = rs.getURIResourceMap();
    int _size_9 = _uRIResourceMap_13.size();
    Assert.assertEquals(0, _size_9);
    Map<URI, URI> _normalizationMap_6 = rs.getNormalizationMap();
    int _size_10 = _normalizationMap_6.size();
    Assert.assertEquals(0, _size_10);
  }
  
  @Test
  public void testResourcesAreClearedWithNormalizedURI_01() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final XtextResource resource = new XtextResource();
    URI _createURI = URI.createURI("/a/../foo");
    resource.setURI(_createURI);
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(2, _size_1);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.clear();
    EList<Adapter> _eAdapters = resource.eAdapters();
    boolean _isEmpty = _eAdapters.isEmpty();
    Assert.assertTrue(_isEmpty);
    Map<URI, Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_2.size();
    Assert.assertEquals(0, _size_2);
  }
  
  @Test
  public void testResourcesAreClearedWithDeliverFalseWithNormalizedURI_01() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Map<URI, Resource> _uRIResourceMap = rs.getURIResourceMap();
    int _size = _uRIResourceMap.size();
    Assert.assertEquals(0, _size);
    final XtextResource resource = new XtextResource();
    URI _createURI = URI.createURI("//a/../foo");
    resource.setURI(_createURI);
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Map<URI, Resource> _uRIResourceMap_1 = rs.getURIResourceMap();
    int _size_1 = _uRIResourceMap_1.size();
    Assert.assertEquals(2, _size_1);
    rs.eSetDeliver(false);
    EList<Resource> _resources_1 = rs.getResources();
    _resources_1.clear();
    EList<Adapter> _eAdapters = resource.eAdapters();
    boolean _isEmpty = _eAdapters.isEmpty();
    Assert.assertTrue(_isEmpty);
    Map<URI, Resource> _uRIResourceMap_2 = rs.getURIResourceMap();
    int _size_2 = _uRIResourceMap_2.size();
    Assert.assertEquals(0, _size_2);
  }
}
