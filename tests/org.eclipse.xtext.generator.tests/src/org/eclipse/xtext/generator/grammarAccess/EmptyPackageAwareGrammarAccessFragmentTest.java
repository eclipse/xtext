/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmptyPackageAwareGrammarAccessFragmentTest extends AbstractXtextTests {

	private EPackage metamodel;
	private EmptyPackageAwareGrammarAccessFragment fragment;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextResourceSet set = new XtextResourceSet();
		set.setClasspathURIContext(getClass());
		Resource resource = set.getResource(URI.createURI("classpath:/org/eclipse/xtext/generator/grammarAccess/ametamodel.ecore"), true);
		metamodel = (EPackage) resource.getContents().get(0);
		fragment = new EmptyPackageAwareGrammarAccessFragment();
	}
	
	@Override
	protected void tearDown() throws Exception {
		metamodel = null;
		super.tearDown();
	}
	
	public void testMoveSubpackagesToNewResource() {
		String expected = metamodel.getESubpackages().get(0).getNsURI();
		ResourceSet set = new ResourceSetImpl();
		fragment.moveSubpackagesToNewResource(metamodel, set);
		assertEquals(1, set.getResources().size());
		assertEquals(expected, set.getResources().get(0).getURI().toString());
	}
}
