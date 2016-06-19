/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.keywords;

import java.io.IOException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.parser.keywords.keywordsTestLanguage.KeywordsTestLanguagePackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTest extends AbstractXtextTests {

	private EStructuralFeature first;
	private EStructuralFeature second;
	private EStructuralFeature third;
	private EStructuralFeature forth;
	private EStructuralFeature fifth;
	private EStructuralFeature sixth;
	private EStructuralFeature seventh;
	private EStructuralFeature eighth;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(KeywordsTestLanguageStandaloneSetup.class);
		EPackage pack = KeywordsTestLanguagePackage.eINSTANCE;
		EClass clazz = (EClass) pack.getEClassifier("Model");
		first = clazz.getEStructuralFeature("first");
		second = clazz.getEStructuralFeature("second");
		third = clazz.getEStructuralFeature("third");
		forth = clazz.getEStructuralFeature("forth");
		fifth = clazz.getEStructuralFeature("fifth");
		sixth = clazz.getEStructuralFeature("sixth");
		seventh = clazz.getEStructuralFeature("seventh");
		eighth = clazz.getEStructuralFeature("eighth");
	}

	private void checkModel(XtextResource resource, EStructuralFeature feature) {
		EObject model = resource.getParseResult().getRootASTElement();
		assertNotNull(model);
		boolean value = (Boolean) model.eGet(feature);
		assertTrue(value);
	}

	@Test public void testFooBar() throws Exception {
		XtextResource resource = parse("foo\\bar");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, first);
	}

	@Test public void testFoo() throws Exception {
		XtextResource resource = parse("foo\\");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, second);
	}

	@Test public void testBar() throws Exception {
		XtextResource resource = parse("\\bar");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, third);
	}

	@Test public void testBackslash() throws Exception {
		XtextResource resource = parse("\\");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, forth);
	}

	@Test public void testFifth() throws Exception {
		XtextResource resource = parse("\"a\"");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, fifth);
	}
	
	@Test public void testSixth() throws Exception {
		XtextResource resource = parse("'b'");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, sixth);
	}
	
	@Test public void testSeventh() throws Exception {
		XtextResource resource = parse("'c'");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, seventh);
	}
	
	@Test public void testEighth() throws Exception {
		XtextResource resource = parse("\"d\"");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, eighth);
	}

	protected XtextResource parse(String model) throws IOException {
		return new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension()).getResourceFromString(model);
	}
}
