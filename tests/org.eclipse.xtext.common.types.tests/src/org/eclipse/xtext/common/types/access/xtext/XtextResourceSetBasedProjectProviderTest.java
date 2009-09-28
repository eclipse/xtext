/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.xtext;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.resource.XtextResourceSet;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextResourceSetBasedProjectProviderTest extends TestCase {

	private XtextResourceSet resourceSet;
	private MockJavaProjectProvider mockProjectProvider;
	private XtextResourceSetBasedProjectProvider projectProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = new XtextResourceSet();
		mockProjectProvider = new MockJavaProjectProvider();
		resourceSet.setClasspathURIContext(mockProjectProvider.getJavaProject(null));
		projectProvider = new XtextResourceSetBasedProjectProvider();
	}
	
	@Override
	protected void tearDown() throws Exception {
		mockProjectProvider = null;
		projectProvider = null;
		resourceSet = null;
		super.tearDown();
	}
	
	public void testSetup() {
		assertNotNull(resourceSet.getClasspathURIContext());
		assertTrue(resourceSet.getClasspathURIContext() instanceof IJavaProject);
	}
	
	public void testGetJavaProject_01() {
		assertNull(projectProvider.getJavaProject(null));
	}
	
	public void testGetJavaProject_02() {
		assertNull(projectProvider.getJavaProject(new ResourceSetImpl()));
	}
	
	public void testGetJavaProject_03() {
		assertNull(projectProvider.getJavaProject(new XtextResourceSet()));
	}
	
	public void testGetJavaProject_04() {
		assertSame(resourceSet.getClasspathURIContext(), projectProvider.getJavaProject(resourceSet));
	}
}
