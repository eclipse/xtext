/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JdtAssignabilityComputerTest extends AbstractAssignabilityComputerTest {

	private ResourceSet resourceSet;
	private JdtTypeProvider typeProvider;
	private Resource syntheticResource;
	private MockJavaProjectProvider projectProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		syntheticResource = new XMLResourceImpl(URI.createURI("http://synthetic.resource"));
		resourceSet.getResources().add(syntheticResource);
		projectProvider = new MockJavaProjectProvider();
		typeProvider = new JdtTypeProvider(projectProvider.getJavaProject(resourceSet), resourceSet);
	}
	
	@Override
	protected void tearDown() throws Exception {
		resourceSet = null;
		typeProvider = null;
		syntheticResource = null;
		super.tearDown();
	}
	
	@Override
	protected JdtTypeProvider getTypeProvider() {
		return typeProvider;
	}

	@Override
	protected Resource getSyntheticResource() {
		return syntheticResource;
	}

}
