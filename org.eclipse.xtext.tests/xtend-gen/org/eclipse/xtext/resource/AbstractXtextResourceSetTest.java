/**
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import com.google.common.collect.Iterables;
import java.io.File;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
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
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final XtextResource resource = new XtextResource();
    resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
    EList<Resource> _resources = rs.getResources();
    _resources.add(resource);
    Assert.assertEquals(1, rs.getURIResourceMap().size());
    rs.getResources().remove(resource);
    Assert.assertTrue(resource.eAdapters().isEmpty());
    Assert.assertEquals(0, rs.getURIResourceMap().size());
  }
  
  @Test
  public void testResourcesAreInMap_02() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final XtextResource resource = new XtextResource();
    resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Assert.assertEquals(1, rs.getURIResourceMap().size());
    rs.getResources().remove(resource);
    Assert.assertTrue(resource.eAdapters().isEmpty());
    Assert.assertEquals(0, rs.getURIResourceMap().size());
  }
  
  @Test
  public void testResourcesAreInMap_03() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final XtextResource resource = new XtextResource();
    EList<Resource> _resources = rs.getResources();
    _resources.add(resource);
    Assert.assertEquals(1, rs.getURIResourceMap().size());
    Assert.assertEquals(resource, rs.getURIResourceMap().get(null));
    resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
    Assert.assertEquals(1, rs.getURIResourceMap().size());
    Assert.assertFalse(rs.getURIResourceMap().containsKey(null));
    Assert.assertEquals(resource, rs.getURIResourceMap().get(resource.getURI()));
    Assert.assertEquals(resource, rs.getURIResourceMap().get(rs.getURIConverter().normalize(resource.getURI())));
    resource.setURI(URI.createFileURI(new File("bar").getAbsolutePath()));
    Assert.assertEquals(1, rs.getURIResourceMap().size());
    Assert.assertFalse(rs.getURIResourceMap().containsKey(null));
    Assert.assertEquals(resource, rs.getURIResourceMap().get(resource.getURI()));
    Assert.assertEquals(resource, rs.getURIResourceMap().get(rs.getURIConverter().normalize(resource.getURI())));
    resource.setURI(null);
    Assert.assertEquals(1, rs.getURIResourceMap().size());
    Assert.assertEquals(resource, rs.getURIResourceMap().get(null));
    rs.getResources().remove(resource);
    Assert.assertTrue(resource.eAdapters().isEmpty());
    Assert.assertEquals(0, rs.getURIResourceMap().size());
  }
  
  @Test
  public void testResourcesAreCleared_01() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final XtextResource resource = new XtextResource();
    resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Assert.assertEquals(1, rs.getURIResourceMap().size());
    rs.getResources().clear();
    Assert.assertTrue(resource.eAdapters().isEmpty());
    Assert.assertEquals(0, rs.getURIResourceMap().size());
  }
  
  @Test
  public void testResourcesAreClearedWithDeliverFalse_01() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final XtextResource resource = new XtextResource();
    resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Assert.assertEquals(1, rs.getURIResourceMap().size());
    rs.eSetDeliver(false);
    rs.getResources().clear();
    Assert.assertTrue(resource.eAdapters().isEmpty());
    Assert.assertEquals(0, rs.getURIResourceMap().size());
  }
  
  @Test
  public void testResourcesAreInMapWithNormalizedURI_01() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final XtextResource resource = new XtextResource();
    resource.setURI(URI.createURI("/a/../foo"));
    EList<Resource> _resources = rs.getResources();
    _resources.add(resource);
    Assert.assertEquals(2, rs.getURIResourceMap().size());
    rs.getResources().remove(resource);
    Assert.assertTrue(resource.eAdapters().isEmpty());
    Assert.assertEquals(0, rs.getURIResourceMap().size());
  }
  
  @Test
  public void testResourcesAreInMapWithNormalizedURI_02() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final XtextResource resource = new XtextResource();
    resource.setURI(URI.createURI("/a/../foo"));
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Assert.assertEquals(2, rs.getURIResourceMap().size());
    rs.getResources().remove(resource);
    Assert.assertTrue(resource.eAdapters().isEmpty());
    Assert.assertEquals(0, rs.getURIResourceMap().size());
  }
  
  @Test
  public void testResourcesAreInMapWithNormalizedURI_03() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final XtextResource resource = new XtextResource();
    EList<Resource> _resources = rs.getResources();
    _resources.add(resource);
    Assert.assertEquals(1, rs.getURIResourceMap().size());
    Assert.assertEquals(resource, rs.getURIResourceMap().get(null));
    Assert.assertEquals(0, rs.getNormalizationMap().size());
    resource.setURI(URI.createURI("/a/../foo"));
    Assert.assertEquals(2, rs.getURIResourceMap().size());
    Assert.assertFalse(rs.getURIResourceMap().containsKey(null));
    Assert.assertEquals(resource, rs.getURIResourceMap().get(resource.getURI()));
    Assert.assertEquals(resource, rs.getURIResourceMap().get(rs.getURIConverter().normalize(resource.getURI())));
    Assert.assertEquals(1, rs.getNormalizationMap().size());
    Assert.assertEquals(rs.getURIConverter().normalize(resource.getURI()), rs.getNormalizationMap().get(resource.getURI()));
    resource.setURI(URI.createURI("/a/../bar"));
    Assert.assertEquals(2, rs.getURIResourceMap().size());
    Assert.assertFalse(rs.getURIResourceMap().containsKey(null));
    Assert.assertEquals(resource, rs.getURIResourceMap().get(resource.getURI()));
    Assert.assertEquals(resource, rs.getURIResourceMap().get(rs.getURIConverter().normalize(resource.getURI())));
    Assert.assertEquals(1, rs.getNormalizationMap().size());
    Assert.assertEquals(rs.getURIConverter().normalize(resource.getURI()), rs.getNormalizationMap().get(resource.getURI()));
    resource.setURI(null);
    Assert.assertEquals(1, rs.getURIResourceMap().size());
    Assert.assertEquals(resource, rs.getURIResourceMap().get(null));
    Assert.assertEquals(0, rs.getNormalizationMap().size());
    rs.getResources().remove(resource);
    Assert.assertTrue(resource.eAdapters().isEmpty());
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    Assert.assertEquals(0, rs.getNormalizationMap().size());
  }
  
  @Test
  public void testResourcesAreClearedWithNormalizedURI_01() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final XtextResource resource = new XtextResource();
    resource.setURI(URI.createURI("/a/../foo"));
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Assert.assertEquals(2, rs.getURIResourceMap().size());
    rs.getResources().clear();
    Assert.assertTrue(resource.eAdapters().isEmpty());
    Assert.assertEquals(0, rs.getURIResourceMap().size());
  }
  
  @Test
  public void testResourcesAreClearedWithDeliverFalseWithNormalizedURI_01() {
    final XtextResourceSet rs = this.createEmptyResourceSet();
    Assert.assertEquals(0, rs.getURIResourceMap().size());
    final XtextResource resource = new XtextResource();
    resource.setURI(URI.createURI("//a/../foo"));
    EList<Resource> _resources = rs.getResources();
    ArrayList<Resource> _newArrayList = CollectionLiterals.<Resource>newArrayList(resource);
    Iterables.<Resource>addAll(_resources, _newArrayList);
    Assert.assertEquals(2, rs.getURIResourceMap().size());
    rs.eSetDeliver(false);
    rs.getResources().clear();
    Assert.assertTrue(resource.eAdapters().isEmpty());
    Assert.assertEquals(0, rs.getURIResourceMap().size());
  }
}
