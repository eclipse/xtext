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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.IndexingException;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.impl.EcoreIndexFeederImpl;
import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.guice.AbstractEmfIndexTest;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.resource.impl.IndexFeederImpl;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class ResourceTest extends AbstractEmfIndexTest {

	private static final String RESOURCE_0_URI = "file:/test0.ecore";
	private static final String RESOURCE_1_URI = "file:/test1.ecore";
	
	@Inject
	private IndexStore index;
	
	private Resource resource0;
	private Resource resource1;
	
	private IndexChangeListenerImpl listener;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		URI resource0URI = URI.createURI(RESOURCE_0_URI);
		resource0 = new ResourceImpl(resource0URI);
		URI resource1URI = URI.createURI(RESOURCE_1_URI);
		resource1 = new ResourceImpl(resource1URI);

		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.createResourceDescriptor(resource0, null);
		indexFeeder.commit();

		listener = new IndexChangeListenerImpl();
		index.addIndexChangeListener(listener);
	}
	
	
	public void testAdd() throws Exception {
		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.createResourceDescriptor(resource1, null);
		indexFeeder.commit();

		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(1, events.size());
		IndexChangeEvent firstEvent = events.get(0);
		assertEquals(IndexChangeEvent.Type.ADDED, firstEvent.getType());
		assertTrue(firstEvent.getDescriptor() instanceof ResourceDescriptor);
		assertEquals(resource1.getURI().toString(), ((ResourceDescriptor) firstEvent.getDescriptor()).getURI());		
	}
		
	public void testNoChange() throws Exception {
		ResourceDescriptor resourceDescriptor = index.resourceDAO().createQueryResource(resource0).executeSingleResult();
		assertNotNull(resourceDescriptor);
		long indexingDate0 = resourceDescriptor.getIndexingDate();
		// currentTimeMillis must be different!
		while(indexingDate0 == System.currentTimeMillis())
			Thread.sleep(10);
		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.createResourceDescriptor(resource0, null);
		indexFeeder.commit();

		resourceDescriptor = index.resourceDAO().createQueryResource(resource0).executeSingleResult();
		assertNotNull(resourceDescriptor);
		long indexingDate1 = resourceDescriptor.getIndexingDate();
		assertTrue(indexingDate0 != indexingDate1);

		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(0, events.size());
//		IndexChangeEvent firstEvent = events.get(0);
//		assertEquals(IndexChangeEvent.Type.MODIFIED, firstEvent.getType());
//		assertTrue(firstEvent.getDescriptor() instanceof ResourceDescriptor);
//		assertEquals(resource0.getURI().toString(), ((ResourceDescriptor) firstEvent.getDescriptor()).getURI());		
	}

	public void testModify() throws Exception {
		Map<String, Serializable> userData = new HashMap<String, Serializable>();
		userData.put("impcat", "fatal");

		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.createResourceDescriptor(resource0, userData);
		indexFeeder.commit();

		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(1, events.size());
		IndexChangeEvent firstEvent = events.get(0);
		assertEquals(IndexChangeEvent.Type.MODIFIED, firstEvent.getType());
		assertTrue(firstEvent.getDescriptor() instanceof ResourceDescriptor);
		assertEquals(resource0.getURI().toString(), ((ResourceDescriptor) firstEvent.getDescriptor()).getURI());		
	}
		
	public void testDelete() throws Exception {
		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.deleteResourceDescriptor(resource0.getURI());
		indexFeeder.commit();

		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(1, events.size());
		IndexChangeEvent firstEvent = events.get(0);
		assertEquals(IndexChangeEvent.Type.REMOVED, firstEvent.getType());
		assertTrue(firstEvent.getDescriptor() instanceof ResourceDescriptor);
		assertEquals(resource0.getURI().toString(), ((ResourceDescriptor) firstEvent.getDescriptor()).getURI());		
	}
		
	public void testDeleteAndAddInSameTransaction() throws Exception {
		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.deleteResourceDescriptor(resource1.getURI());
		try {
			indexFeeder.createResourceDescriptor(resource1, null);
			fail("An exception should have been thrown");
		} catch (IndexingException e) {
			// expected behavior
		}
		indexFeeder = new IndexFeederImpl(index);
		indexFeeder.createResourceDescriptor(resource1, null);
		try {
			indexFeeder.deleteResourceDescriptor(resource1.getURI());
			fail("An exception should have been thrown");
		} catch (IndexingException e) {
			// expected behavior
		}
	}
	
	public void testDeleteEObjectsAndEReferencesRecursively() {
		EcoreIndexFeederImpl ecoreIndexFeeder = new EcoreIndexFeederImpl(index);
		ecoreIndexFeeder.index(EcorePackage.eINSTANCE, false);
		EPackage eObject = EcoreFactory.eINSTANCE.createEPackage();
		resource0.getContents().add(eObject);
		
		IndexFeeder indexFeeder = new IndexFeederImpl(index);
		indexFeeder.createEObjectDescriptor(eObject, eObject.getName(), eObject.getName(), null);
		indexFeeder.createEReferenceDescriptor(EcoreUtil.getURI(eObject), "subPackage", 0, EcoreUtil.getURI(eObject));
		indexFeeder.commit();
		
		listener.clearEvents();
		
		indexFeeder = new IndexFeederImpl(index);
		indexFeeder.deleteResourceDescriptor(resource0.getURI());
		indexFeeder.commit();
		
		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(3, events.size());
		for(IndexChangeEvent event: events) {
			assertTrue(event.getType() == IndexChangeEvent.Type.REMOVED);
		}
		
	}
	
}
