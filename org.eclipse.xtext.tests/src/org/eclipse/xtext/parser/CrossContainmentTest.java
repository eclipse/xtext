/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerManyChildren;
import org.eclipse.xtext.parser.partialParsingTestUtil.CrossResourceContainerOneChild;
import org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilFactory;
import org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CrossContainmentTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		PartialParsingTestUtilPackage.eINSTANCE.eAdapters(); // initialize
	}
	
	@Test public void testCrossContainment_01() {
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		Resource resource = resourceSet.createResource(URI.createFileURI("container.xmi"));
		Resource childResource = resourceSet.createResource(URI.createFileURI("child.xmi"));
		CrossResourceContainerManyChildren container = PartialParsingTestUtilFactory.eINSTANCE.createCrossResourceContainerManyChildren();
		resource.getContents().add(container);
		Grammar grammar = XtextFactory.eINSTANCE.createGrammar();
		childResource.getContents().add(grammar);
		assertNull(grammar.eContainer());
		container.getChildren().add(grammar);
		assertSame(container, grammar.eContainer());
		assertSame(childResource, grammar.eResource());
		assertSame(resource, container.eResource());
	}
	
	@Test public void testCrossContainment_02() {
		XtextResourceSet resourceSet = get(XtextResourceSet.class);
		resourceSet.setClasspathURIContext(getClass());
		Resource resource = resourceSet.createResource(URI.createFileURI("container.xmi"));
		Resource childResource = resourceSet.createResource(URI.createFileURI("child.xmi"));
		CrossResourceContainerOneChild container = PartialParsingTestUtilFactory.eINSTANCE.createCrossResourceContainerOneChild();
		resource.getContents().add(container);
		Grammar grammar = XtextFactory.eINSTANCE.createGrammar();
		childResource.getContents().add(grammar);
		assertNull(grammar.eContainer());
		container.setChild(grammar);
		assertSame(container, grammar.eContainer());
		assertSame(childResource, grammar.eResource());
		assertSame(resource, container.eResource());
	}
	
}
