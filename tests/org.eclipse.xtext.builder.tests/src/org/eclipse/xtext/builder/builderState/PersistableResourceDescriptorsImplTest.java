/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PersistableResourceDescriptorsImplTest extends TestCase {
	
	private PersistableResourceDescriptionsImpl descs;

	private int notificationCount;
	
	private List<IResourceDescription.Delta> wasDelta;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		descs = new PersistableResourceDescriptionsImpl();
		notificationCount = 0;
	}
	
	public void testEmpty() throws Exception {
		Iterable<IResourceDescription> resourceDescriptions = descs.getAllResourceDescriptions();
		assertFalse(resourceDescriptions.iterator().hasNext());
	}
	
	public void testUpdateWithNullParams() throws Exception {
		descs.update(null, null);
		Iterable<IResourceDescription> resourceDescriptions = descs.getAllResourceDescriptions();
		assertFalse(resourceDescriptions.iterator().hasNext());
	}
	
	public void testUpdate_Delta() throws Exception {
		// test add
		List<IResourceDescription> newResDesc = newResDesc("foo","bar");
		List<Delta> update = descs.update(newResDesc, null);
		assertNull(update.get(0).getOld());
		assertEquals(newResDesc.get(0),update.get(0).getNew());
		assertNull(update.get(1).getOld());
		assertEquals(newResDesc.get(1),update.get(1).getNew());
		
		// test update
		List<IResourceDescription> updateDescs = newResDesc("foo");
		update = descs.update(updateDescs, null);
		assertEquals(newResDesc.get(0),update.get(0).getOld());
		assertEquals(updateDescs.get(0),update.get(0).getNew());
		
		// test delete
		update = descs.update(null, uris("bar"));
		assertEquals(newResDesc.get(1),update.get(0).getOld());
		assertNull(update.get(0).getNew());
		
		// test no change
		update = descs.update(null, uris("bar"));
		assertTrue(update.isEmpty());
	}
	
	public void testUpdate_NullParams() throws Exception {
		List<IResourceDescription> newResDesc = newResDesc("foo","bar");
		descs.update(newResDesc, null);
		
		assertEquals(uri("foo"),descs.getResourceDescription(uri("foo")).getURI());
		descs.update(null, null);
		assertEquals(uri("foo"),descs.getResourceDescription(uri("foo")).getURI());
		descs.update(null, uris("foo"));
		assertNull(descs.getResourceDescription(uri("foo")));
		assertEquals(uri("bar"),descs.getAllResourceDescriptions().iterator().next().getURI());
		descs.update(null, uris("bar"));
		assertEquals(false,descs.getAllResourceDescriptions().iterator().hasNext());
	}
	

	public void testUpdate_Update() throws Exception {
		List<IResourceDescription> newResDesc = newResDesc("foo","bar");
		List<IResourceDescription> newResDesc2 = newResDesc("foo");
		descs.update(newResDesc, null);
		descs.update(newResDesc2, null);
		assertEquals(2,Collections2.forIterable(descs.getAllResourceDescriptions()).size());
		assertSame(newResDesc2.iterator().next(),descs.getResourceDescription(uri("foo")));
	}
	
	public void testImmutability() throws Exception {
		descs.update(newResDesc("foo","bar","baz"), null);
		Collection<IResourceDescription> collection = Collections2.forIterable(descs.getAllResourceDescriptions());
		assertEquals(3,collection.size());
		descs.update(null, uris("foo"));
		assertEquals(3,collection.size());
		assertEquals(2,Collections2.forIterable(descs.getAllResourceDescriptions()).size());
		descs.update(null, uris("foo","bar","baz"));
		assertEquals(3,collection.size());
		assertEquals(0,Collections2.forIterable(descs.getAllResourceDescriptions()).size());
	}
	
	public void testPrecedenceOfAddOverDelete() throws Exception {
		descs.update(newResDesc("foo","bar","baz"), null);
	}
	
	public void testOneAdded_nullToBeDeleted() throws Exception {
		descs.update(newResDesc("foo","bar"), null);
		assertEquals(uri("foo"),descs.getResourceDescription(uri("foo")).getURI());
	}
	
	public void testNotification_01() throws Exception {
		descs.addListener(new TestListener());
		// test add
		List<IResourceDescription> newResDesc = newResDesc("foo","bar");
		List<Delta> update = descs.update(newResDesc, null);
		assertEquals(wasDelta, update);
		assertEquals(1, notificationCount);
		wasDelta = null;
		
		// test update
		List<IResourceDescription> updateDescs = newResDesc("foo");
		update = descs.update(updateDescs, null);
		assertEquals(wasDelta, update);
		assertEquals(2, notificationCount);
		wasDelta = null;
		
		// test delete
		update = descs.update(null, uris("bar"));
		assertEquals(wasDelta, update);
		assertEquals(3, notificationCount);
		wasDelta = null;
		
		// test no change
		update = descs.update(null, uris("bar"));
		assertEquals(wasDelta, update);
		assertEquals(4, notificationCount);
	}
	
	public void testNotification_02() throws Exception {
		TestListener listener = new TestListener();
		descs.addListener(listener);
		descs.addListener(listener);
		List<IResourceDescription> newResDesc = newResDesc("foo","bar");
		List<Delta> update = descs.update(newResDesc, null);
		assertEquals(wasDelta, update);
		assertEquals(1, notificationCount);
	}
	
	public void testNotification_03() throws Exception {
		descs.addListener(new TestListener());
		descs.addListener(new TestListener());
		List<IResourceDescription> newResDesc = newResDesc("foo","bar");
		List<Delta> update = descs.update(newResDesc, null);
		assertEquals(wasDelta, update);
		assertEquals(2, notificationCount);
	}
	
	public void testNotification_04() throws Exception {
		descs.addListener(new TestListener() {
			{ remove = true; }
		});
		descs.addListener(new TestListener() {
			{ remove = true; }
		});
		descs.addListener(new TestListener() {
			{ remove = true; }
		});
		List<IResourceDescription> newResDesc = newResDesc("foo","bar");
		List<Delta> update = descs.update(newResDesc, null);
		assertEquals(wasDelta, update);
		assertEquals(3, notificationCount);
		newResDesc = newResDesc("foo","bar", "baz");
		descs.update(newResDesc, null);
		assertEquals(3, notificationCount);
	}
	
	private class TestListener implements IResourceDescriptions.Listener {

		boolean remove = false;
		
		public void onDescriptionsChanged(ImmutableList<Delta> delta) {
			notificationCount++;
			if (wasDelta != null)
				assertSame(wasDelta, delta);
			wasDelta = delta;
			if (remove)
				descs.removeListener(this);
		}
		
	}

	private URI uri(String string) {
		return URI.createURI(string);
	}

	private List<IResourceDescription> newResDesc(String ...uris) {
		List<IResourceDescription> result = Lists.newArrayList();
		for (String uri : uris) {
			ResourceDescriptionImpl description = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
			description.setURI(uri(uri));
			result.add(description);
		}
		return result;
	}
	
	private Set<URI> uris(String ...uris) {
		Set<URI> result = Sets.newHashSet();
		for (String uri : uris) {
			result.add(uri(uri));
		}
		return result;
	}
}
