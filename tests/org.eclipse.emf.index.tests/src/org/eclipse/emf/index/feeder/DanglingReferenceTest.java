/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.feeder;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.event.IndexChangeEvent;
import org.eclipse.emf.index.guice.AbstractEmfIndexTest;
import org.eclipse.emf.index.resource.IndexFeeder;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class DanglingReferenceTest extends AbstractEmfIndexTest {

	private static final String REFERENCE_NAME = "subPackage";

	private static final String RESOURCE_URI = "file:/test.ecore";
	
	@Inject
	private IndexStore index;
	
	@Inject
	private Provider<IndexFeeder> indexFeederProvider;
	
	@Inject 
	private EcoreIndexFeeder ecoreIndexFeeder;

	private Resource resource;

	private EPackage source;

	private EPackage target;

	private IndexChangeListenerImpl listener;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ecoreIndexFeeder.index(EcorePackage.eINSTANCE, false);
		URI resourceURI = URI.createURI(RESOURCE_URI);
		resource = new ResourceImpl(resourceURI);
		source = EcoreFactory.eINSTANCE.createEPackage();
		source.setName("Hugo");
		target = EcoreFactory.eINSTANCE.createEPackage();
		target.setName("Anton");
		resource.getContents().add(source);
		resource.getContents().add(target);
		
		IndexFeeder indexFeeder = indexFeederProvider.get();
		indexFeeder.createResourceDescriptor(resource, null);
		indexFeeder.createEObjectDescriptor(source, source.getName(), source.getName(), null);
		indexFeeder.createEObjectDescriptor(target, target.getName(), target.getName(), null);
		indexFeeder.createEReferenceDescriptor(EcoreUtil.getURI(source), REFERENCE_NAME, 0, EcoreUtil.getURI(target));
		indexFeeder.commit();
		
		listener = new IndexChangeListenerImpl();
		index.addIndexChangeListener(listener);
	}
	
	public void testDeleteSource() throws Exception {
		EReferenceDescriptor eRefDesc = index.eReferenceDAO().createQuery().referenceName(REFERENCE_NAME).executeSingleResult();
		assertNotNull(eRefDesc);
		
		IndexFeeder indexFeeder = indexFeederProvider.get();
		indexFeeder.createResourceDescriptor(resource, null);
		indexFeeder.createEObjectDescriptor(target, target.getName(), target.getName(), null);
		indexFeeder.createEReferenceDescriptor(EcoreUtil.getURI(source), REFERENCE_NAME, 0, EcoreUtil.getURI(target));
		indexFeeder.commit();
		
		eRefDesc = index.eReferenceDAO().createQuery().referenceName(REFERENCE_NAME).executeSingleResult();
		assertNotNull(eRefDesc);
		
		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(1, events.size());
		IndexChangeEvent firstEvent = events.get(0);
		assertEquals(IndexChangeEvent.Type.REMOVED, firstEvent.getType());
		assertTrue(firstEvent.getDescriptor() instanceof EObjectDescriptor);
		assertEquals(source.getName(), ((EObjectDescriptor) firstEvent.getDescriptor()).getName());		
	}

	public void testDeleteTarget() throws Exception {
		EReferenceDescriptor eRefDesc = index.eReferenceDAO().createQuery().referenceName(REFERENCE_NAME).executeSingleResult();
		assertNotNull(eRefDesc);
		
		IndexFeeder indexFeeder = indexFeederProvider.get();
		indexFeeder.createResourceDescriptor(resource, null);
		indexFeeder.createEObjectDescriptor(source, source.getName(), source.getName(), null);
		indexFeeder.createEReferenceDescriptor(EcoreUtil.getURI(source), REFERENCE_NAME, 0, EcoreUtil.getURI(target));
		indexFeeder.commit();
		
		eRefDesc = index.eReferenceDAO().createQuery().referenceName(REFERENCE_NAME).executeSingleResult();
		assertNotNull(eRefDesc);
		
		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(1, events.size());
		IndexChangeEvent firstEvent = events.get(0);
		assertEquals(IndexChangeEvent.Type.REMOVED, firstEvent.getType());
		assertTrue(firstEvent.getDescriptor() instanceof EObjectDescriptor);
		assertEquals(target.getName(), ((EObjectDescriptor) firstEvent.getDescriptor()).getName());
	}

	public void testDeleteReference() throws Exception {
		EReferenceDescriptor eRefDesc = index.eReferenceDAO().createQuery().referenceName(REFERENCE_NAME).executeSingleResult();
		assertNotNull(eRefDesc);
		
		IndexFeeder indexFeeder = indexFeederProvider.get();
		indexFeeder.createResourceDescriptor(resource, null);
		indexFeeder.createEObjectDescriptor(source, source.getName(), source.getName(), null);
		indexFeeder.createEObjectDescriptor(target, target.getName(), target.getName(), null);
		indexFeeder.commit();
		
		eRefDesc = index.eReferenceDAO().createQuery().referenceName(REFERENCE_NAME).executeSingleResult();
		assertNull(eRefDesc);
		
		List<IndexChangeEvent> events = listener.getEvents();
		assertEquals(1, events.size());
		IndexChangeEvent firstEvent = events.get(0);
		assertEquals(IndexChangeEvent.Type.REMOVED, firstEvent.getType());
		assertTrue(firstEvent.getDescriptor() instanceof EReferenceDescriptor);
	}
	
}
