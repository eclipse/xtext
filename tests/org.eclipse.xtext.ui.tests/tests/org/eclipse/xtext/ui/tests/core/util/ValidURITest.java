/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.core.util;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;
import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.EcoreUtil2;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ValidURITest extends TestCase {

	private static final String FILE_PATH = "/test/test.txt";

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		createFile(FILE_PATH, "foo bar");
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		cleanWorkspace();
	}

	public void testIsValidURI() {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=326760
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource dummyResource = resourceSet.createResource(URI.createURI("test.foo"));
		assertTrue(EcoreUtil2.isValidUri(dummyResource, URI.createURI("platform:/resource" + FILE_PATH)));
		assertFalse(EcoreUtil2.isValidUri(dummyResource, URI.createURI("platform://resource" + FILE_PATH)));
		assertFalse(EcoreUtil2.isValidUri(dummyResource, URI.createURI("platform:///resource" + FILE_PATH)));
	}
}
