/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

public abstract class AbstractXtextResourceSetTest extends AbstractResourceSetTest {
	
	@Override
	  protected abstract XtextResourceSet createEmptyResourceSet();
	
	@Test
	public void testResourcesAreInMap() {
		XtextResourceSet rs = createEmptyResourceSet();
		
		assertEquals(0, rs.getURIResourceMap().size());
		
		XtextResource resource = new XtextResource();
		resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
		
		rs.getResources().add(resource);
		
		assertEquals(1, rs.getURIResourceMap().size());
		
		rs.getResources().remove(resource);
		
		assertTrue(resource.eAdapters().isEmpty());
		assertEquals(0, rs.getURIResourceMap().size());
	}
	
	@Test
	public void testResourcesAreInMap_02() {
		XtextResourceSet rs = createEmptyResourceSet();
		
		assertEquals(0, rs.getURIResourceMap().size());
		
		XtextResource resource = new XtextResource();
		resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
		
		rs.getResources().add(resource);
		
		assertEquals(1, rs.getURIResourceMap().size());
		
		rs.getResources().remove(resource);
		
		assertTrue(resource.eAdapters().isEmpty());
		assertEquals(0, rs.getURIResourceMap().size());
	}
	
	@Test
	public void testResourcesAreInMap_03() {
		XtextResourceSet rs = createEmptyResourceSet();
		
		assertEquals(0, rs.getURIResourceMap().size());
		
		XtextResource resource = new XtextResource();
		
		rs.getResources().add(resource);
		assertEquals(1, rs.getURIResourceMap().size());
		assertEquals(resource, rs.getURIResourceMap().get(null));
		
		// set the URI
		resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
		assertEquals(1, rs.getURIResourceMap().size());
		assertFalse(rs.getURIResourceMap().containsKey(null));
		assertEquals(resource, rs.getURIResourceMap().get(resource.getURI()));
		assertEquals(resource, rs.getURIResourceMap().get(rs.getURIConverter().normalize(resource.getURI())));
		
		// set the URI
		resource.setURI(URI.createFileURI(new File("bar").getAbsolutePath()));
		assertEquals(1, rs.getURIResourceMap().size());
		assertFalse(rs.getURIResourceMap().containsKey(null));
		assertEquals(resource, rs.getURIResourceMap().get(resource.getURI()));
		assertEquals(resource, rs.getURIResourceMap().get(rs.getURIConverter().normalize(resource.getURI())));
		
		// set the URI back to null
		resource.setURI(null);
		assertEquals(1, rs.getURIResourceMap().size());
		assertEquals(resource, rs.getURIResourceMap().get(null));
		
		// remove the resource
		rs.getResources().remove(resource);
		
		assertTrue(resource.eAdapters().isEmpty());
		assertEquals(0, rs.getURIResourceMap().size());
	}
	
	@Test
	public void testResourcesAreCleared_01() {
		XtextResourceSet rs = createEmptyResourceSet();
		
		assertEquals(0, rs.getURIResourceMap().size());
		
		XtextResource resource = new XtextResource();
		resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
		
		rs.getResources().add(resource);
		assertEquals(1, rs.getURIResourceMap().size());
		
		rs.getResources().clear();
		
		assertTrue(resource.eAdapters().isEmpty());
		assertEquals(0, rs.getURIResourceMap().size());
	}
	
	@Test
	public void testResourcesAreClearedWithDeliverFalse_01() {
		XtextResourceSet rs = createEmptyResourceSet();
		
		assertEquals(0, rs.getURIResourceMap().size());
		
		XtextResource resource = new XtextResource();
		resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
		
		rs.getResources().add(resource);
		
		assertEquals(1, rs.getURIResourceMap().size());
		rs.eSetDeliver(false);
		rs.getResources().clear();
		
		assertTrue(resource.eAdapters().isEmpty());
		assertEquals(0, rs.getURIResourceMap().size());
	}
	
	@Test
	public void testResourcesAreInMapWithNormalizedURI_01() {
		XtextResourceSet rs = createEmptyResourceSet();
		
		assertEquals(0, rs.getURIResourceMap().size());
		
		XtextResource resource = new XtextResource();
		resource.setURI(URI.createURI("/a/../foo"));
		
		rs.getResources().add(resource);
		
		assertEquals(2, rs.getURIResourceMap().size());
		
		rs.getResources().remove(resource);
		
		assertTrue(resource.eAdapters().isEmpty());
		assertEquals(0, rs.getURIResourceMap().size());
	}
	
	@Test
	public void testResourcesAreInMapWithNormalizedURI_02() {
		XtextResourceSet rs = createEmptyResourceSet();
		
		assertEquals(0, rs.getURIResourceMap().size());
		
		XtextResource resource = new XtextResource();
		resource.setURI(URI.createURI("/a/../foo"));
		
		rs.getResources().add(resource);
		
		assertEquals(2, rs.getURIResourceMap().size());
		
		rs.getResources().remove(resource);
		
		assertTrue(resource.eAdapters().isEmpty());
		assertEquals(0, rs.getURIResourceMap().size());
	}
	
	@Test
	public void testResourcesAreInMapWithNormalizedURI_03() {
		XtextResourceSet rs = createEmptyResourceSet();
		
		assertEquals(0, rs.getURIResourceMap().size());
		
		XtextResource resource = new XtextResource();
		
		rs.getResources().add(resource);
		assertEquals(1, rs.getURIResourceMap().size());
		assertEquals(resource, rs.getURIResourceMap().get(null));
		
		assertEquals(0, rs.getNormalizationMap().size());
		
		// set the URI
		resource.setURI(URI.createURI("/a/../foo"));
		assertEquals(2, rs.getURIResourceMap().size());
		assertFalse(rs.getURIResourceMap().containsKey(null));
		assertEquals(resource, rs.getURIResourceMap().get(resource.getURI()));
		assertEquals(resource, rs.getURIResourceMap().get(rs.getURIConverter().normalize(resource.getURI())));
		
		assertEquals(1, rs.getNormalizationMap().size());
		assertEquals(rs.getURIConverter().normalize(resource.getURI()), rs.getNormalizationMap().get(resource.getURI()));
		
		// set the URI
		resource.setURI(URI.createURI("/a/../bar"));
		assertEquals(2, rs.getURIResourceMap().size());
		assertFalse(rs.getURIResourceMap().containsKey(null));
		assertEquals(resource, rs.getURIResourceMap().get(resource.getURI()));
		assertEquals(resource, rs.getURIResourceMap().get(rs.getURIConverter().normalize(resource.getURI())));
		
		assertEquals(1, rs.getNormalizationMap().size());
		assertEquals(rs.getURIConverter().normalize(resource.getURI()), rs.getNormalizationMap().get(resource.getURI()));
		
		// set the URI back to null
		resource.setURI(null);
		assertEquals(1, rs.getURIResourceMap().size());
		assertEquals(resource, rs.getURIResourceMap().get(null));
		
		assertEquals(0, rs.getNormalizationMap().size());
		
		// remove the resource
		rs.getResources().remove(resource);
		
		assertTrue(resource.eAdapters().isEmpty());
		assertEquals(0, rs.getURIResourceMap().size());
		
		assertEquals(0, rs.getNormalizationMap().size());
	}
	
	@Test
	public void testResourcesAreClearedWithNormalizedURI_01() {
		XtextResourceSet rs = createEmptyResourceSet();
		
		assertEquals(0, rs.getURIResourceMap().size());
		
		XtextResource resource = new XtextResource();
		resource.setURI(URI.createURI("/a/../foo"));
		
		rs.getResources().add(resource);
		
		assertEquals(2, rs.getURIResourceMap().size());
		
		rs.getResources().clear();
		
		assertTrue(resource.eAdapters().isEmpty());
		assertEquals(0, rs.getURIResourceMap().size());
	}
	
	@Test
	public void testResourcesAreClearedWithDeliverFalseWithNormalizedURI_01() {
		XtextResourceSet rs = createEmptyResourceSet();
		
		assertEquals(0, rs.getURIResourceMap().size());
		
		XtextResource resource = new XtextResource();
		resource.setURI(URI.createURI("//a/../foo"));
		
		rs.getResources().add(resource);
		
		assertEquals(2, rs.getURIResourceMap().size());
		rs.eSetDeliver(false);
		rs.getResources().clear();
		
		assertTrue(resource.eAdapters().isEmpty());
		assertEquals(0, rs.getURIResourceMap().size());
	}
}
