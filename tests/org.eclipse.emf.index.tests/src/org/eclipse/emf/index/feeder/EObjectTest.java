/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.feeder;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.guice.AbstractEmfIndexTest;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class EObjectTest extends AbstractEmfIndexTest {

	private static final String RESOURCE_URI = "file:/test.ecore";
	
	@Inject
	private IndexStore index;
	
	private Resource resource;

	private EPackage eObject0;
	private EPackage eObject1;

	private IndexChangeListenerImpl listener;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new EcoreIndexFeederImpl(index).index(EcorePackage.eINSTANCE, false);
		URI resourceURI = URI.createURI(RESOURCE_URI);
		resource = new ResourceImpl(resourceURI);
		eObject0 = EcoreFactory.eINSTANCE.createEPackage();
		eObject0.setName("Hugo");
		resource.getContents().add(eObject0);
		eObject1 = EcoreFactory.eINSTANCE.createEPackage();
		eObject1.setName("Anton");
		resource.getContents().add(eObject1);
		
		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.createResourceDescriptor(resource, null);
		indexFeeder.createEObjectDescriptor(eObject0, eObject0.getName(), eObject0.getName(), null);
		indexFeeder.commit();
		
		listener = new IndexChangeListenerImpl();
		index.addIndexChangeListener(listener);
	}
	
	public void testAdd() throws Exception {
		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.createResourceDescriptor(resource, null);
		indexFeeder.createEObjectDescriptor(eObject0, eObject0.getName(), eObject0.getName(), null);
		indexFeeder.createEObjectDescriptor(eObject1, eObject1.getName(), eObject1.getName(), null);
		indexFeeder.commit();
				
		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(1, events.size());
		IndexChangeEvent firstEvent = events.get(0);
		assertEquals(IndexChangeEvent.Type.ADDED, firstEvent.getType());
		assertTrue(firstEvent.getDescriptor() instanceof EObjectDescriptor);
		assertEquals(eObject1.getName(), ((EObjectDescriptor) firstEvent.getDescriptor()).getName());		
	}

	public void testModify() throws Exception {
		Map<String, Serializable> userData = new HashMap<String, Serializable>();
		userData.put("impcat", "fatal");
		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.createResourceDescriptor(resource, null);
		indexFeeder.createEObjectDescriptor(eObject0, eObject0.getName(), eObject0.getName(), userData);
		indexFeeder.commit();
				
		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(1, events.size());
		IndexChangeEvent firstEvent = events.get(0);
		assertEquals(IndexChangeEvent.Type.MODIFIED, firstEvent.getType());
		assertTrue(firstEvent.getDescriptor() instanceof EObjectDescriptor);
		assertEquals(eObject0.getName(), ((EObjectDescriptor) firstEvent.getDescriptor()).getName());		
	}

	public void testDelete() throws Exception {
		Map<String, Serializable> userData = new HashMap<String, Serializable>();
		userData.put("impcat", "fatal");
		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.createResourceDescriptor(resource, null);
		indexFeeder.commit();
				
		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(1, events.size());
		IndexChangeEvent firstEvent = events.get(0);
		assertEquals(IndexChangeEvent.Type.REMOVED, firstEvent.getType());
		assertTrue(firstEvent.getDescriptor() instanceof EObjectDescriptor);
		assertEquals(eObject0.getName(), ((EObjectDescriptor) firstEvent.getDescriptor()).getName());		
	}

}
