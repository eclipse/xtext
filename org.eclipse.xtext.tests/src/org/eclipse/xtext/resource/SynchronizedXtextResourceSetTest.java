/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class SynchronizedXtextResourceSetTest extends AbstractXtextResourceSetTest {
	@Override
	protected XtextResourceSet createEmptyResourceSet() {
		return new SynchronizedXtextResourceSet();
	}

	@Test
	public void testSynchronization() throws Exception {
		SynchronizedXtextResourceSet resourceSet = (SynchronizedXtextResourceSet) createEmptyResourceSet();
		Resource.Factory nullFactory = (URI uri) -> {
			NullResource result = new NullResource();
			result.setURI(uri);
			return result;
		};
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", nullFactory);
		List<Thread> threads = new ArrayList<>();
		new IntegerRange(1, 10).forEach((Integer i) -> {
			threads.add(new Thread(() -> {
				List<Resource> resources = new ArrayList<>();
				for (int j = 0; j < 5000; j++) {
					Resource resource = resourceSet.createResource(URI.createURI(i + " " + j + ".xmi"));
					Assert.assertNotNull(resource);
					resources.add(resource);
					resource.setURI(URI.createURI(resource.getURI() + "b"));
				}
			}));
		});
		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		Assert.assertEquals(50000, resourceSet.getResources().size());
		Assert.assertEquals(Sets.newLinkedHashSet(resourceSet.getResources()).size(),
				Sets.newLinkedHashSet(resourceSet.getURIResourceMap().values()).size());
		Assert.assertEquals(
				Sets.newLinkedHashSet(Iterables.concat(Lists.transform(resourceSet.getResources(), (Resource it) -> {
					return Lists.<URI>newArrayList(it.getURI(), resourceSet.getURIConverter().normalize(it.getURI()));
				}))), resourceSet.getURIResourceMap().keySet());
		Assert.assertEquals(
				Joiner.on("\n")
						.join(IterableExtensions.sort(IterableExtensions.toList(Lists.<Resource, String>transform(
								resourceSet.getResources(), it -> it.getURI().toString())))),
				Joiner.on("\n").join(IterableExtensions.sort(IterableExtensions
						.toList(Iterables.transform(resourceSet.getNormalizationMap().keySet(), URI::toString)))));
	}
}
