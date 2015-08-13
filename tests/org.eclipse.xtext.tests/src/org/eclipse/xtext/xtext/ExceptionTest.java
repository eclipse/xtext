/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExceptionTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test public void testNoStackOverflow() throws Exception {
		String model = "grammar test with org.eclipse.xtext.common.Terminals\n" +
			"import 'http://www.eclipse.org/2008/Xtext'	as xtext\n" +
			"generate test 'http://eclipse.org/xtext/tests/SimpleTest'\n" +
			"Foo : name=ID (nameRefs+=NameRef)*;\n" +
			"NameRef returns xtext::RuleCall : rle=[ParserRule];\n" +
			"MyRule returns xtext::ParserRule : name=ID;";
		Resource r = getResourceFromStringAndExpect(model, 1);
		assertEquals(r.getErrors().toString(), 1, r.getErrors().size());
		r = getResourceFromStringAndExpect(model, 1);
		assertEquals(r.getErrors().toString(), 1, r.getErrors().size());
	}

	@Test public void testGeneratedMetamodelWithoutURI() throws Exception {
		String model =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
	        "generate test \n" +
	        "import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore\n" +
	        "Keyword : \n" +
	        "   value=STRING \n" +
	        ";\n";
		assertNoException(model, 3);
	}

	@Test public void testFirstAssignmentWithoutLeftSide() throws Exception {
		String model =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
            "generate test \"test\"\n" +
            "Numbers: =INT n2=INT ;";
		// should in fact be 1 but the parse recovers badly because there are two equally invalid decisions it refused to insert a token
		assertNoException(model, 4); 
	}
	
	@Test public void testFirstAssignmentWithoutLeftSide_02() throws Exception {
		String model =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test \"test\"\n" +
			"Numbers: +=INT n2=INT ;";
		// should in fact be 1 but the parse recovers badly because there are two equally invalid decisions it refused to insert a token
		assertNoException(model, 4); // should in fact be 1 but the parse recovers badly
	}
	
	@Test public void testFirstAssignmentWithoutLeftSide_03() throws Exception {
		String model =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"generate test \"test\"\n" +
			"Numbers: ?=INT n2=INT ;";
		// should in fact be 1 but the parse recovers badly because there are two equally invalid decisions it refused to insert a token
		assertNoException(model, 4); // should in fact be 1 but the parse recovers badly
	}
	
	@Test public void testBug_270773() throws Exception {
		String model =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore\n" +
            "generate test \"test\"\n" +
            "enum Foo returns ecore::EString: Zonk ;";
		assertNoException(model, 2);
	}

	private void assertNoException(String model, int expectedErrors) throws Exception {
		Resource r = getResourceFromStringAndExpect(model, expectedErrors);
		Iterable<ExceptionDiagnostic> filtered = Iterables.filter(r.getErrors(), ExceptionDiagnostic.class);
		assertNotNull(filtered);
		assertFalse(filtered.iterator().hasNext());
	}

}
