/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.parser.partialParsingTestUtil.PartialParsingTestUtilPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractPartialParserCrossContainmentTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		PartialParsingTestUtilPackage.eINSTANCE.eAdapters(); // initialize
	}
	
	@Override
	protected XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		XtextResource result = super.doGetResource(in, uri);
		setCrossResourceContainer(result);
		return result;
	}
	
	@Test public void testCrossResourceContainment_01_Hugo_Plus_Egon() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 2, 2, "+hugo+egon", true);
	}
	
	@Test public void testCrossResourceContainment_01_Egon() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 8, 5, "egon", false);
	}
	
	@Test public void testCrossResourceContainment_01_Empty() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 1, 2, "", true);
		replaceAndReparse(model, 3, 1, "(x+y+z)", true);
	}
	
	@Test public void testCrossResourceContainment_01_X_Y_Z() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 3, 1, "(x+y+z)", true);
	}
	
	@Test public void testCrossResourceContainment_02_Multiply() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 6, 3, "*", false);
	}
	
	@Test public void testCrossResourceContainment_02_Plus() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse("a b", 1, 1, "+", false);
		replaceAndReparse(model, 3, 1, "x)+(b",false);
	}
	
	@Test public void testCrossResourceContainment_02_New_Parens() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 3, 1, "x)+(b",false);
	}
	
	@Test public void testCrossResourceContainment_03() throws Exception {
		String model = "(a+b+c)*(c/d)";
		replaceAndReparse(model, 0, model.length(), model, true);
	}

	protected void replaceAndReparse(String model, int offset, int length, String inserted, boolean expectSameRoot) throws Exception {
		final XtextResource resource = getResourceFromString(model);
		resource.setUnloader(new IReferableElementsUnloader() {
			@Override
			public void unloadRoot(EObject root) {
				InternalEObject internalEObject = (InternalEObject) root;
				internalEObject.eSetProxyURI(resource.getURI().appendFragment(resource.getURIFragment(internalEObject)));
			    internalEObject.eAdapters().clear();
			}});
		assertEquals(1, resource.getContents().size());
		EObject wasObject = resource.getContents().get(0);
		assertNotNull(wasObject.eContainer());
		assertNotSame(wasObject.eResource(), wasObject.eContainer().eResource());
		resource.update(offset, length, inserted);
		assertEquals(1, resource.getContents().size());
		EObject newRoot = resource.getContents().get(0);
		assertEquals(expectSameRoot, wasObject == newRoot);
		if (!expectSameRoot) {
			assertTrue(((InternalEObject)wasObject).eIsProxy());
			assertNotSame(resource, wasObject.eResource());
		}
		assertSame(resource, newRoot.eResource());
	}

	protected abstract void setCrossResourceContainer(XtextResource resource);
	
}
