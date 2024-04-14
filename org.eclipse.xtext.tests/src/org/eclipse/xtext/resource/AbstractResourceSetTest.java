/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource;

import java.io.File;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractResourceSetTest {
	protected abstract ResourceSetImpl createEmptyResourceSet();

	@Test
	public void testDemandLoadedResourcesAreInMap() {
		ResourceSetImpl rs = this.createEmptyResourceSet();
		Resource.Factory nullFactory = new Resource.Factory() {
			
			@Override
			public Resource createResource(URI uri) {
				NullResource result = new NullResource();
				result.setURI(uri);
				return result;
			}
		};
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", nullFactory);
		Assert.assertEquals(0, rs.getURIResourceMap().size());
		URI uri = URI.createURI("file:/does/not/exist.xmi");
		Resource demandLoaded = rs.getResource(uri, true);
		Assert.assertNotNull(demandLoaded);
		Resource second = rs.getResource(uri, true);
		Assert.assertSame(demandLoaded, second);
		Assert.assertEquals(1, rs.getURIResourceMap().size());
	}

	@Test
	public void testResourceLocatorIsUsed() {
		ResourceSetImpl rs = this.createEmptyResourceSet();
		XtextResource resource = new XtextResource();
		resource.setURI(URI.createFileURI(new File("foo").getAbsolutePath()));
		new ResourceSetImpl.ResourceLocator(rs) {
			@Override
			public Resource getResource(URI uri, boolean loadOnDemand) {
				if (Objects.equals(uri, resource.getURI())) {
					return resource;
				}
				throw new IllegalArgumentException(uri.toString());
			}
		};
		Assert.assertSame(resource, rs.getResource(resource.getURI(), true));
		Assert.assertTrue(rs.getResources().isEmpty());
		Assert.assertNull(resource.getResourceSet());
		try {
			rs.getResource(resource.getURI().appendSegment("doesNotExist"), true);
			Assert.fail();
		} catch (IllegalArgumentException e) {
			Assert.assertTrue(e.getMessage().endsWith("doesNotExist"));
		}
	}
}
