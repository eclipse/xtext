/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.core.containers.ProjectBasedContainer;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ProjectBasedContainerTest extends AbstractContainerTest {

	private URI uri1;
	private URI uri2;
	private URI uri3;
	
	private ProjectBasedContainer container;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		uri1 = createFileAndRegisterResource(project1, "file1");
		uri2 = createFileAndRegisterResource(project1, "file2");
		uri3 = createFileAndRegisterResource(project2, "file3");
		container = new ProjectBasedContainer(this, project1);
	}

	public void testGetResourceDescription() {
		assertNotNull(container.getResourceDescription(uri1));
		assertNotNull(container.getResourceDescription(uri2));
		assertNull(container.getResourceDescription(uri3));
	}
	
	public void testGetResourceDescriptions() {
		ArrayList<IResourceDescription> list = Lists.newArrayList(container.getResourceDescriptions());
		assertEquals(2, list.size());
		assertFalse(list.contains(uriToResourceDescription.get(uri3)));
	}
	
}
