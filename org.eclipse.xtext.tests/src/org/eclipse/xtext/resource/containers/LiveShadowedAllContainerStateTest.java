/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.LiveContainerTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
@InjectWith(LiveContainerTestLanguageInjectorProvider.class)
@RunWith(XtextRunner.class)
public class LiveShadowedAllContainerStateTest {

	@Inject
	private FileExtensionProvider fep;

	@Inject
	private LiveShadowedAllContainerState.Provider containerStateProvider;

	@Inject
	private Provider<XtextResourceSet> rsp;

	@Inject
	private IResourceServiceProvider.Registry registry;

	@Test
	public void testContainsURI() {
		String fileExtension = fep.getPrimaryFileExtension();
		XtextResourceSet xtextResourceSet1 = rsp.get();
		xtextResourceSet1.createResource(URI.createURI("/a/x." + fileExtension));
		xtextResourceSet1.createResource(URI.createURI("/b/x1." + fileExtension));
		ResourceSetBasedResourceDescriptions liveState = new ResourceSetBasedResourceDescriptions();
		liveState.setContext(xtextResourceSet1);
		liveState.setRegistry(registry);
		Multimap<String, URI> container2Uris = ArrayListMultimap.create();
		container2Uris.put("a", URI.createURI("/a/x." + fileExtension));
		container2Uris.put("a", URI.createURI("/a/y." + fileExtension));
		container2Uris.put("b", URI.createURI("/b/x1." + fileExtension));
		container2Uris.put("b", URI.createURI("/b/x2." + fileExtension));
		IAllContainersState containersState = containerStateProvider.get(liveState,
				new FakeAllContainerState(container2Uris));
		assertTrue(containersState.containsURI("a", URI.createURI("/a/x." + fileExtension)));
		assertTrue(containersState.containsURI("a", URI.createURI("/a/y." + fileExtension)));
		assertFalse(containersState.containsURI("b", URI.createURI("/a/x." + fileExtension)));
		assertFalse(containersState.containsURI("b", URI.createURI("/a/y." + fileExtension)));
		assertTrue(containersState.containsURI("b", URI.createURI("/b/x1." + fileExtension)));
		assertTrue(containersState.containsURI("b", URI.createURI("/b/x2." + fileExtension)));
		assertFalse(containersState.containsURI("a", URI.createURI("/b/x1." + fileExtension)));
		assertFalse(containersState.containsURI("a", URI.createURI("/b/x2." + fileExtension)));
	}

	public static final class FakeAllContainerState implements IAllContainersState {
		private final Multimap<String, URI> container2Uris;

		public FakeAllContainerState(Multimap<String, URI> container2Uris) {
			this.container2Uris = container2Uris;
		}

		@Override
		public boolean isEmpty(String containerHandle) {
			return container2Uris.get(containerHandle).isEmpty();
		}

		@Override
		public List<String> getVisibleContainerHandles(String handle) {
			return Lists.newArrayList();
		}

		@Override
		public Collection<URI> getContainedURIs(String containerHandle) {
			return container2Uris.get(containerHandle);
		}

		@Override
		public String getContainerHandle(URI uri) {
			for (Entry<String, URI> e : container2Uris.entries()) {
				if (e.getValue().equals(uri)) {
					return e.getKey();
				}
			}
			return null;
		}
	}
}
