/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.core.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.After;
import org.junit.Assert;

public abstract class AbstractClasspathUriResolverTest extends Assert {

	protected IProject _project;
	protected static final String MODEL_FILE = "simple.ecore";
	protected static final String JAR_FILE = "simple.jar";
	protected static final String JAR_FILE2 = "simpleroot.jar";
	protected static final String TEST_PROJECT_NAME = "test";

	@After
	public void tearDown() throws Exception {
		if (_project != null && _project.exists()) {
			_project.delete(true, null);
		}
	}

	protected void assertResourceLoadable(URI classpathUri, URI normalizedUri,
			String expectedUri) {
		if(expectedUri != null) {
			assertEquals(expectedUri, normalizedUri.toString());
		}
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(normalizedUri.trimFragment(), true);
		assertNotNull("Classpath URI ot registered", resource);
		assertTrue("Resource not loaded", resource.isLoaded());
	}

}
