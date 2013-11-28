/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ChangedResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainerTest;
import org.junit.After;
import org.junit.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StateBasedContainerTest extends ResourceDescriptionsBasedContainerTest implements IContainerState {

	private boolean simulateEmpty;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		simulateEmpty = false;
	}
	
	@After
	public void tearDown() throws Exception {
		simulateEmpty = false;
	}
	 
	@Override
	protected ResourceDescriptionsBasedContainer createContainer() {
		return new StateBasedContainer(this, this);
	}

	public Collection<URI> getContents() {
		if (simulateEmpty)
			return Collections.emptyList();
		return Collections.singleton(uri);
	}

	public boolean contains(URI uri) {
		if (simulateEmpty)
			return false;
		return uri.equals(this.uri);	
	}
	
	@Override
	@Test public void testBug352214() {
		container.getResourceDescriptions(); // initialize uri map
		ResourceDescriptionChangeEvent event = new ResourceDescriptionChangeEvent(Collections.<IResourceDescription.Delta>singletonList(
				new ChangedResourceDescriptionDelta(resourceDescription, null)));
		simulateEmpty = true;
		container.descriptionsChanged(event);
		assertEquals(0, container.getResourceDescriptionCount());
		assertTrue(Iterables.all(container.getResourceDescriptions(), Predicates.notNull()));
		assertFalse(container.hasResourceDescription(uri)); 
		assertNull(container.getResourceDescription(uri));
	}
	
}
