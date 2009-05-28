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
import org.eclipse.xtext.tests.AbstractGeneratorTest;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExceptionTest extends AbstractGeneratorTest {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void testNoStackOverflow() throws Exception {
		String model = "grammar test with org.eclipse.xtext.common.Terminals\n" +
			"import 'http://www.eclipse.org/2008/Xtext'	as xtext\n" +
			"generate test 'http://eclipse.org/xtext/tests/SimpleTest'\n" +
			"Foo : name=ID (nameRefs+=NameRef)*;\n" +
			"NameRef returns xtext::RuleCall : rle=[ParserRule];\n" +
			"MyRule returns xtext::ParserRule : name=ID;";
		Resource r = getResourceFromString(model);
		assertEquals(r.getErrors().toString(), 1, r.getErrors().size());
		r = getResourceFromString(model);
		assertEquals(r.getErrors().toString(), 1, r.getErrors().size());
	}

	public void testGeneratedMetamodelWithoutURI() throws Exception {
		String model =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
	        "generate test \n" +
	        "import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore\n" +
	        "Keyword : \n" +
	        "   value=STRING \n" +
	        ";\n";
		assertNoException(model);
	}

	public void testFirstAssignmentWithoutLeftSide() throws Exception {
		String model =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
            "generate test \"test\"\n" +
            "Numbers: =INT n2=INT ;";
		assertNoException(model);
	}
	
	public void testBug_270773() throws Exception {
		String model =
			"grammar test with org.eclipse.xtext.common.Terminals\n" +
			"import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore\n" +
            "generate test \"test\"\n" +
            "enum Foo returns ecore::EString: Zonk ;";
		assertNoException(model);
	}

	private void assertNoException(String model) throws Exception {
		Resource r = getResourceFromString(model);
		Iterable<ExceptionDiagnostic> filtered = Iterables.filter(r.getErrors(), ExceptionDiagnostic.class);
		assertNotNull(filtered);
		assertFalse(filtered.iterator().hasNext());
	}

}
