/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.builder.builderState.ShadowingResourceDescriptions;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Event.Listener;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ShadowingResourceDescriptionsTest extends TestCase {
	

	public void testSimpleShadowing() throws Exception {
		ResourceDescs target = descs(d("foo"),d("bar"),d("baz"));
		ResourceDescs shadow = descs(         d("bar"));
		Set<URI> deleteUris = uris(                      "baz");
		
		ShadowingResourceDescriptions shadowed = shadowingResourceDescriptions(target, shadow, deleteUris);
		assertSame(get(target,0),shadowed.getResourceDescription(uri("foo")));
		assertSame(get(shadow,0),shadowed.getResourceDescription(uri("bar")));
		assertNull(shadowed.getResourceDescription(uri("baz")));
	}

	private ShadowingResourceDescriptions shadowingResourceDescriptions(ResourceDescs target, ResourceDescs shadow,
			Set<URI> deleteUris) {
		ShadowingResourceDescriptions descriptions = new ShadowingResourceDescriptions();
		descriptions.setShadowed(target);
		descriptions.setShadowing(shadow);
		descriptions.setDeleteUris(deleteUris);
		return descriptions;
	}
	
	public void testSimpleShadowing_1() throws Exception {
		ResourceDescs target = descs(d("foo"),d("bar"),d("baz"));
		ResourceDescs shadow = descs(d("dings"));
		Set<URI> deleteUris = uris("dings");
		
		ShadowingResourceDescriptions shadowed = shadowingResourceDescriptions(target, shadow, deleteUris);
		assertSame(get(target,0),shadowed.getResourceDescription(uri("foo")));
		assertSame(get(target,1),shadowed.getResourceDescription(uri("bar")));
		assertSame(get(target,2),shadowed.getResourceDescription(uri("baz")));
		assertSame(get(shadow,0),shadowed.getResourceDescription(uri("dings")));
	}
	
	private IResourceDescription get(ResourceDescs target, int i) {
		return Lists.newArrayList(target.map.values()).get(i);
	}

	private URI uri(String string) {
		return URI.createURI(string);
	}

	private Set<URI> uris(String ...uris) {
		HashSet<URI> set = Sets.newHashSet();
		for (String s : uris) {
			set.add(uri(s));
		}
		return set;
	}



	public static ResourceDescs descs(ResourceDesc ...descs) {
		ResourceDescs descs2 = new ResourceDescs();
		for (ResourceDesc resourceDesc : descs) {
			descs2.map.put(resourceDesc.getURI(), resourceDesc);
		}
		return descs2;
	}
	
	public static ResourceDesc d(String uri) {
		return new ResourceDesc(uri);
	}
	
	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	static class ResourceDescs implements IResourceDescriptions {
		
		public LinkedHashMap<URI, IResourceDescription> map = Maps.newLinkedHashMap();
		
		public void removeListener(Listener listener) {
		}

		public void addListener(Listener listener) {
		}

		public IResourceDescription getResourceDescription(URI uri) {
			return map.get(uri);
		}

		public Iterable<IResourceDescription> getAllResourceDescriptions() {
			return map.values();
		}
	}
	
	static class ResourceDesc implements IResourceDescription {
		
		private URI uri;

		public ResourceDesc(String uri) {
			this.uri = URI.createURI(uri);
		}

		public Iterable<IEObjectDescription> getExportedObjects() {
			return null;
		}

		public Iterable<IEObjectDescription> getExportedObjects(EClass clazz, String name) {
			return null;
		}

		public Iterable<IEObjectDescription> getExportedObjects(EClass clazz) {
			return null;
		}

		public Iterable<IEObjectDescription> getExportedObjectsForEObject(EObject object) {
			return null;
		}

		public Iterable<String> getImportedNames() {
			return null;
		}

		public URI getURI() {
			return uri;
		}
		
	}

}
