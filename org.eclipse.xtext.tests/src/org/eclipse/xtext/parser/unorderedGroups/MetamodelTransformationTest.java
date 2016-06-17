/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.unorderedGroups;

import java.io.InputStream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MetamodelTransformationTest extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	@Test public void testBooleanAssignments() throws Exception {
		EClass clazz = getModel("a?='keyword' & b?='keyword'");
		assertNotNull(clazz.getEStructuralFeature("a"));
		EStructuralFeature feature = clazz.getEStructuralFeature("b");
		assertSame(EcorePackage.Literals.EBOOLEAN, feature.getEType());
		assertFalse(feature.isMany());
	}
	
	@Test public void testSimpleAssignments() throws Exception {
		EClass clazz = getModel("a='keyword' & b='keyword'");
		assertNotNull(clazz.getEStructuralFeature("a"));
		EStructuralFeature feature = clazz.getEStructuralFeature("b");
		assertSame(EcorePackage.Literals.ESTRING, feature.getEType());
		assertFalse(feature.isMany());
	}
	
	@Test public void testMultiValueAssignments() throws Exception {
		EClass clazz = getModel("a+='keyword' & a+='keyword'");
		EStructuralFeature feature = clazz.getEStructuralFeature("a");
		assertSame(EcorePackage.Literals.ESTRING, feature.getEType());
		assertTrue(feature.isMany());
	}
	
	@Override
	protected InputStream getAsStream(String model) {
		return super.getAsStream(surroundWithGrammar(model));
	}
	
	@Override
	public EClass getModel(String model) throws Exception {
		return (EClass) super.getModel(model);
	}
	
	@Override
	protected EClass getModel(XtextResource resource) {
		Grammar grammar = (Grammar) super.getModel(resource);
		return (EClass) grammar.getMetamodelDeclarations().get(0).getEPackage().getEClassifier("Model");
	}

	protected String surroundWithGrammar(String model) {
		String header = "grammar org.some.Grammar with org.eclipse.xtext.common.Terminals\n"
			+ "generate name 'http://my.uri'\n"
			+ "Model: ";
		String footer = ";";
		return header + model + footer;
	}


}
