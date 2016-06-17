/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import java.math.BigDecimal;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.datatyperules.datatypeRulesTestLanguage.DatatypeRulesTestLanguagePackage;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTest extends AbstractXtextTests {

	private EStructuralFeature idFeature;
	private EStructuralFeature valueFeature;
	private EStructuralFeature modelFeature;
	private EStructuralFeature dotsFeature;
	private EStructuralFeature vectorFeature;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(DatatypeRulesTestLanguageStandaloneSetup.class);
		EPackage pack = DatatypeRulesTestLanguagePackage.eINSTANCE;
		EClass model = (EClass) pack.getEClassifier("Model");
		idFeature = model.getEStructuralFeature("id");
		valueFeature = model.getEStructuralFeature("value");
		vectorFeature = model.getEStructuralFeature("vector");
		dotsFeature = model.getEStructuralFeature("dots");
		EClass compositeModel = (EClass) pack.getEClassifier("CompositeModel");
		modelFeature = compositeModel.getEStructuralFeature("model");
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseSimple() throws Exception {
		String model = "a.b.c.d;";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		assertEquals("CompositeModel", parsedModel.eClass().getName());
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a.b.c.d", id);
		assertFalse(firstModel.eIsSet(valueFeature));
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseSimpleWithSpaces() throws Exception {
		String model = " a . b . c . d ;";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a . b . c . d", id);
		assertFalse(firstModel.eIsSet(valueFeature));
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseSimpleWithMultipleSpaces() throws Exception {
		String model = "  a  .  b  .  c  .  d  ;";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a . b . c . d", id);
		assertFalse(firstModel.eIsSet(valueFeature));
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseWithFraction() throws Exception {
		String model = "a.b.c.d: 1/2;";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertTrue(firstModel.eIsSet(valueFeature));
		BigDecimal bd = (BigDecimal) firstModel.eGet(valueFeature);
		assertNotNull(bd);
		assertEquals(new BigDecimal("0.5"), bd);
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseWithFractionError() throws Exception {
		String model = "a.b.c.d: 1/0;";
		Resource r = getResourceFromStringAndExpect(model, 1);
		EObject parsedModel = r.getContents().get(0);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertFalse(firstModel.eIsSet(valueFeature));
		assertEquals(1, r.getErrors().size());
		XtextSyntaxDiagnostic diag = (XtextSyntaxDiagnostic) r.getErrors().get(0);
		assertEquals(model.indexOf("1/0"), diag.getOffset());
		assertEquals(3, diag.getLength());
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseWithFractionErrorAndSpaces() throws Exception {
		String model = "a.b.c.d:  1 / 0 ; ";
		Resource r = getResourceFromStringAndExpect(model, 1);
		EObject parsedModel = r.getContents().get(0);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertFalse(firstModel.eIsSet(valueFeature));
		assertEquals(1, r.getErrors().size());
		XtextSyntaxDiagnostic diag = (XtextSyntaxDiagnostic) r.getErrors().get(0);
		assertEquals(model.indexOf("1 / 0"), diag.getOffset());
		assertEquals(5, diag.getLength());
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseWithFractionErrorAndSyntaxError() throws Exception {
		String model = "a.b.c.d: 1/0 ";
		Resource r = getResourceFromStringAndExpect(model, 2);
		EObject parsedModel = r.getContents().get(0);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertFalse(firstModel.eIsSet(valueFeature));
		assertEquals(2, r.getErrors().size());
		XtextSyntaxDiagnostic diag = (XtextSyntaxDiagnostic) r.getErrors().get(0);
		assertEquals(model.indexOf("1/0"), diag.getOffset());
		assertEquals(3, diag.getLength());
		diag = (XtextSyntaxDiagnostic) r.getErrors().get(1);
		assertEquals(model.length() - 1, diag.getOffset());
		assertEquals(1, diag.getLength());
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseWithVector() throws Exception {
		String model = "a.b.c.d # (1 2);";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertTrue(firstModel.eIsSet(vectorFeature));
		String vector = (String) firstModel.eGet(vectorFeature);
		assertNotNull(vector);
		assertEquals("(1 2)", vector);
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseWithVectorAndComment() throws Exception {
		String model = "a.b.c.d # (1/*comment*/2);";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertTrue(firstModel.eIsSet(vectorFeature));
		String vector = (String) firstModel.eGet(vectorFeature);
		assertNotNull(vector);
		assertEquals("(1 2)", vector);
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseWithDots() throws Exception {
		String model = "a.b.c.d + . .;";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertTrue(firstModel.eIsSet(dotsFeature));
		String vector = (String) firstModel.eGet(dotsFeature);
		assertNotNull(vector);
		assertEquals(". .", vector);
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseWithDotsAndLinebreak() throws Exception {
		String model = "a.b.c.d + .\n.;";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertTrue(firstModel.eIsSet(dotsFeature));
		String vector = (String) firstModel.eGet(dotsFeature);
		assertNotNull(vector);
		assertEquals(". .", vector);
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseWithDotsAndComments() throws Exception {
		String model = "a.b.c.d + ./*comment*/.;";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertTrue(firstModel.eIsSet(dotsFeature));
		String vector = (String) firstModel.eGet(dotsFeature);
		assertNotNull(vector);
		assertEquals(". .", vector);
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseWithDoubleDots() throws Exception {
		String model = "a.b.c.d + ..;";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertTrue(firstModel.eIsSet(dotsFeature));
		String vector = (String) firstModel.eGet(dotsFeature);
		assertNotNull(vector);
		assertEquals("..", vector);
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseErrors_01() throws Exception {
		String model = "a.b.c.d";
		Resource r = getResourceFromStringAndExpect(model, 1);
		assertEquals(1, r.getErrors().size());
		EObject parsedModel = r.getContents().get(0);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertNotNull(firstModel);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a.b.c.d", id);
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseErrors_02() throws Exception {
		String model = "a.b.c.";
		Resource r = getResourceFromStringAndExpect(model, 1);
		assertEquals(1, r.getErrors().size());
		EObject parsedModel = r.getContents().get(0);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertNotNull(firstModel);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a.b.c.", id);
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseErrors_03() throws Exception {
		String model = "a.b.c. ;";
		Resource r = getResourceFromStringAndExpect(model, 1);
		assertEquals(1, r.getErrors().size());
		EObject parsedModel = r.getContents().get(0);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertNotNull(firstModel);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a.b.c.", id);
	}

	@SuppressWarnings("unchecked")
	@Test public void testParseErrors_04() throws Exception {
		String model = "a.b.c";
		Resource r = getResourceFromStringAndExpect(model, 1);
		assertEquals(1, r.getErrors().size());
		EObject parsedModel = r.getContents().get(0);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertNotNull(firstModel);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a.b.c", id);
	}

}
