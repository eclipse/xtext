/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.core.containers.JavaElementBasedContainer;
import org.eclipse.xtext.ui.core.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.core.resource.Storage2UriMapperJavaImpl;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaElementBasedContainerTest extends AbstractContainerTest {

	private URI uri1;
	private URI uri2;
	private URI uri3;
	
	private IJavaProject javaProject1;
	private JavaElementBasedContainer container;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		javaProject1 = makeJavaProject(project1);
		addSourceFolder(javaProject1, "src2");
		uri1 = createFileAndRegisterResource(project1, "src/file1");
		uri2 = createFileAndRegisterResource(project1, "src/file2");
		uri3 = createFileAndRegisterResource(project2, "src2/file3");
		IResource member = javaProject1.getProject().findMember("src");
		IPackageFragmentRoot fragmentRoot = javaProject1.getPackageFragmentRoot(member);
		IStorage2UriMapper mapper = new Storage2UriMapperJavaImpl();
		container = new JavaElementBasedContainer(this, fragmentRoot, mapper);
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
