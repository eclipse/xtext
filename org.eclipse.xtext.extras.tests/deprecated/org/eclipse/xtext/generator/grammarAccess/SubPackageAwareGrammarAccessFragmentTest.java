/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.grammarAccess;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class SubPackageAwareGrammarAccessFragmentTest extends AbstractXtextTests {

	private EPackage metamodel;
	private GrammarAccessFragment fragment;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		XtextResourceSet set = new XtextResourceSet();
		set.setClasspathURIContext(getClass());
		Resource resource = set.getResource(URI.createURI("classpath:/org/eclipse/xtext/generator/grammarAccess/ametamodel.ecore"), true);
		metamodel = (EPackage) resource.getContents().get(0);
		fragment = new GrammarAccessFragment();
	}
	
	@Override
	public void tearDown() throws Exception {
		metamodel = null;
		super.tearDown();
	}
	
	@Test public void testMoveSubpackagesToNewResource() {
		String expected = metamodel.getESubpackages().get(0).getNsURI();
		ResourceSet set = new ResourceSetImpl();
		fragment.moveSubpackagesToNewResource(metamodel, set);
		assertEquals(1, set.getResources().size());
		assertEquals(expected, set.getResources().get(0).getURI().toString());
	}
}
