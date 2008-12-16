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
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTest extends AbstractGeneratorTest {
	
	private EStructuralFeature idFeature;
	private EStructuralFeature valueFeature;
	private EStructuralFeature modelFeature;

	protected void setUp() throws Exception {
		super.setUp();
		with(DatatypeRulesTestLanguageStandaloneSetup.class);
		EPackage pack = getMetamodelAccess().getGeneratedEPackages()[0];
		EClass model = (EClass) pack.getEClassifier("Model");
		idFeature = model.getEStructuralFeature("id");
		valueFeature = model.getEStructuralFeature("value");
		EClass compositeModel = (EClass) pack.getEClassifier("CompositeModel");
		modelFeature = compositeModel.getEStructuralFeature("model");
	}
	
	@SuppressWarnings("unchecked")
	public void testParseSimple() throws Exception {
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
	public void testParseSimpleWithSpaces() throws Exception {
		String model = " a . b . c . d ;";
		EObject parsedModel = getModel(model);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a.b.c.d", id);
		assertFalse(firstModel.eIsSet(valueFeature));
	}
	
	@SuppressWarnings("unchecked")
	public void testParseWithFraction() throws Exception {
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
	public void testParseWithFractionError() throws Exception {
		String model = "a.b.c.d: 1/0;";
		Resource r = getResourceFromString(model);
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
	public void testParseWithFractionErrorAndSpaces() throws Exception {
		String model = "a.b.c.d:  1 / 0 ; ";
		Resource r = getResourceFromString(model);
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
	public void testParseWithFractionErrorAndSyntaxError() throws Exception {
		String model = "a.b.c.d: 1/0 ";
		Resource r = getResourceFromString(model);
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
	public void testParseErrors_01() throws Exception {
		String model = "a.b.c.d";
		Resource r = getResourceFromString(model);
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
	public void testParseErrors_02() throws Exception {
		String model = "a.b.c.";
		Resource r = getResourceFromString(model);
		assertEquals(1, r.getErrors().size());
		EObject parsedModel = r.getContents().get(0);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertNotNull(firstModel);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a.b.", id);
	}
	
	@SuppressWarnings("unchecked")
	public void testParseErrors_03() throws Exception {
		String model = "a.b.c. ;";
		Resource r = getResourceFromString(model);
		assertEquals(1, r.getErrors().size());
		EObject parsedModel = r.getContents().get(0);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertNotNull(firstModel);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a.b.c.;", id);
	}
	
	@SuppressWarnings("unchecked")
	public void testParseErrors_04() throws Exception {
		String model = "a.b.c";
		Resource r = getResourceFromString(model);
		assertEquals(1, r.getErrors().size());
		EObject parsedModel = r.getContents().get(0);
		assertNotNull(parsedModel);
		EObject firstModel = ((List<EObject>) parsedModel.eGet(modelFeature)).get(0);
		assertNotNull(firstModel);
		String id = (String) firstModel.eGet(idFeature);
		assertNotNull(id);
		assertEquals("a.b.", id);
	}

}
