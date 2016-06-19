/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.terminalrules.hiddenTerminalsTestLanguage.HiddenTerminalsTestLanguagePackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class HiddensTest extends AbstractXtextTests {
	
	@Override
	protected boolean shouldTestSerializer(XtextResource resource) {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361355
		return false;
	}

	private EClass withoutHiddens;
	private EClass withHiddens;
	private EClass overridingHiddens;
	private EClass inheritingHiddens;
	private EClass model;
	private EClass datatypeHiddens;
	private EStructuralFeature spacesWithoutHiddens;
	private EStructuralFeature valid;
	private EClass overridingHiddensCall;
	private EClass inheritingHiddensCall;
	private EStructuralFeature overridingCall;
	private EStructuralFeature inheritingCall;
	private EStructuralFeature overridingValid;
	private EStructuralFeature inheritingValid;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(HiddenTerminalsTestLanguageStandaloneSetup.class);
		EPackage pack = HiddenTerminalsTestLanguagePackage.eINSTANCE;
		withoutHiddens = (EClass) pack.getEClassifier("WithoutHiddens");
		withHiddens = (EClass) pack.getEClassifier("WithHiddens");
		datatypeHiddens = (EClass) pack.getEClassifier("DatatypeHiddens");
		overridingHiddens = (EClass) pack.getEClassifier("OverridingHiddens");
		overridingHiddensCall = (EClass) pack.getEClassifier("OverridingHiddensCall");
		inheritingHiddens = (EClass) pack.getEClassifier("InheritingHiddens");
		inheritingHiddensCall = (EClass) pack.getEClassifier("InheritingHiddensCall");
		model = (EClass) pack.getEClassifier("Model");
		spacesWithoutHiddens = withoutHiddens.getEStructuralFeature("spaces");
		valid = model.getEStructuralFeature("valid");
		overridingValid = overridingHiddensCall.getEStructuralFeature("valid");
		inheritingValid = inheritingHiddensCall.getEStructuralFeature("valid");
		inheritingCall = inheritingHiddens.getEStructuralFeature("called");
		overridingCall = overridingHiddens.getEStructuralFeature("called");
	}

	@Test public void testSetup() {
		assertNotNull(withoutHiddens);
		assertNotNull(withHiddens);
		assertNotNull(overridingHiddens);
		assertNotNull(inheritingHiddens);
		assertNotNull(overridingHiddensCall);
		assertNotNull(inheritingHiddensCall);
		assertNotNull(model);
		assertNotNull(spacesWithoutHiddens);
		assertNotNull(valid);
		assertNotNull(overridingValid);
		assertNotNull(inheritingValid);
		assertNotNull(overridingCall);
		assertNotNull(inheritingCall);
	}

	@Test public void testWithoutHiddens_01() throws Exception {
		String model = "without hiddens ;";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(withoutHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testWithoutHiddens_02() throws Exception {
		String model = "without hiddens;";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(withoutHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testWithHiddens_01() throws Exception {
		String model = "with hiddens ;";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(withHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testWithHiddens_02() throws Exception {
		String model = "with/* comment */hiddens;";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(withHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testOverridingHiddens_01() throws Exception {
		String model = "overriding hiddens (call;);";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(overridingHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testOverridingHiddens_02() throws Exception {
		String model = "overriding hiddens ( call ; ) ;";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(overridingHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testInheritingHiddens_01() throws Exception {
		String model = "inheriting hiddens (call;);";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(inheritingHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testInheritingHiddens_02() throws Exception {
		String model = "inheriting hiddens ( call /*comment */ ; ) ;";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(inheritingHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testInheritingHiddens_03() throws Exception {
		String model = "inheriting hiddens ( hiding call; ) ;";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(inheritingHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testInheritingHiddens_04() throws Exception {
		String model = "inheriting hiddens (/*comment*/hiding call;/*comment*/) ;";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(inheritingHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testDatatypeHiddens_01() throws Exception {
		String model = "datatype rule;";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(datatypeHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testDatatypeHiddens_02() throws Exception {
		String model = "datatype rule  ;";
		Resource res = getResourceFromString(model);
		assertTrue(res.getErrors().isEmpty());
		EObject root = res.getContents().get(0);
		assertNotNull(root);
		assertEquals(datatypeHiddens, root.eClass());
		assertTrue((Boolean) root.eGet(valid));
	}

	@Test public void testDatatypeHiddens_03() throws Exception {
		String model = "datatype rule /* foo */ ;";
		Resource res = getResourceFromStringAndExpect(model, 1);
		assertFalse(res.getErrors().isEmpty());
		assertEquals(1, res.getErrors().size());
	}
}
