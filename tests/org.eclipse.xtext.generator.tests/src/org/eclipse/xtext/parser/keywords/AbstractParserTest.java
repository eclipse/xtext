/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.keywords;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.parser.antlr.IAntlrParser;
import org.eclipse.xtext.parser.keywords.keywordsTestLanguage.KeywordsTestLanguagePackage;
import org.eclipse.xtext.parser.packrat.IPackratParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParserTest extends AbstractGeneratorTest {

	private ParserTestHelper helper;
	private EStructuralFeature first;
	private EStructuralFeature second;
	private EStructuralFeature third;
	private EStructuralFeature forth;
	private EStructuralFeature fifth;
	private EStructuralFeature sixth;
	private EStructuralFeature seventh;
	private EStructuralFeature eighth;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(KeywordsTestLanguageStandaloneSetup.class);
		helper = new ParserTestHelper(getResourceFactory(), getParserUnderTest(), get(Keys.RESOURCE_SET_KEY));
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

	protected abstract IParser getParserUnderTest();

	private void checkModel(XtextResource resource, EStructuralFeature feature) {
		EObject model = resource.getParseResult().getRootASTElement();
		assertNotNull(model);
		boolean value = (Boolean) model.eGet(feature);
		assertTrue(value);
	}

	public void testFooBar() throws Exception {
		XtextResource resource = helper.getResourceFromString("foo\\bar");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, first);
	}

	public void testFoo() throws Exception {
		XtextResource resource = helper.getResourceFromString("foo\\");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, second);
	}

	public void testBar() throws Exception {
		XtextResource resource = helper.getResourceFromString("\\bar");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, third);
	}

	public void testBackslash() throws Exception {
		XtextResource resource = helper.getResourceFromString("\\");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, forth);
	}

	public void testFifth() throws Exception {
		XtextResource resource = helper.getResourceFromString("\"a\"");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, fifth);
	}
	
	public void testSixth() throws Exception {
		XtextResource resource = helper.getResourceFromString("'b'");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, sixth);
	}
	
	public void testSeventh() throws Exception {
		XtextResource resource = helper.getResourceFromString("'c'");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, seventh);
	}
	
	public void testEighth() throws Exception {
		XtextResource resource = helper.getResourceFromString("\"d\"");
		assertTrue(resource.getErrors().isEmpty());
		checkModel(resource, eighth);
	}
	
	public static class Antlr extends AbstractParserTest {

		@Override
		protected IAntlrParser getParserUnderTest() {
			return getAntlrParser();
		}

	}

	public static class Packrat extends AbstractParserTest {

		@Override
		protected IPackratParser getParserUnderTest() {
			return getPackratParser();
		}

	}
}
