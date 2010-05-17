/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.services.XtextGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextGrammarSerializationTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void testSimpleSerialization() throws Exception {
		final String model = "grammar foo with org.eclipse.xtext.common.Terminals\n"
				+ "generate mm \"http://bar\" as fooMM\n" + "StartRule returns fooMM::T: name=ID;";
		final String expectedModel = "grammar foo with org.eclipse.xtext.common.Terminals\n\ngenerate "
				+ "mm \"http://bar\" as fooMM\n\nStartRule returns fooMM::T:\n	name=ID;";
		doTestSerialization(model, expectedModel);
	}

	private void doTestSerialization(String model, String expectedModel) throws Exception {
		final XtextResource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().isEmpty());
		final Grammar g = (Grammar) resource.getParseResult().getRootASTElement();
		assertNotNull(g);
		final OutputStream outputStream = new ByteArrayOutputStream();
		resource.save(outputStream, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		final String serializedModel = outputStream.toString();
		assertEquals(expectedModel, serializedModel);
	}

	public void testMetamodelRefSerialization() throws Exception {
		final String model = "grammar foo with org.eclipse.xtext.common.Terminals\n"
				+ "import \"http://www.eclipse.org/2008/Xtext\" as xtext\n" + "generate mm \"http://bar\" as fooMM\n"
				+ "Foo returns fooMM::Foo: name=ID (nameRefs+=NameRef)*;\n"
				+ "NameRef returns xtext::RuleCall : rule=[xtext::ParserRule];\n"
				+ "MyRule returns xtext::ParserRule : name=ID;";
		final String expectedModel = "grammar foo with org.eclipse.xtext.common.Terminals\n\n"
				+ "import \"http://www.eclipse.org/2008/Xtext\" as xtext\n" + "generate mm \"http://bar\" as fooMM\n\n"
				+ "Foo returns fooMM::Foo:\n	name=ID nameRefs+=NameRef*;\n\n"
				+ "NameRef returns xtext::RuleCall:\n	rule=[xtext::ParserRule];\n\n"
				+ "MyRule returns xtext::ParserRule:\n	name=ID;";
		doTestSerialization(model, expectedModel);
	}

	public void _testXtestSerializationSelfTest() throws Exception {
		Resource res = get(XtextResourceSet.class).createResource(URI
				.createURI("myfile.xtext"), ContentHandler.UNSPECIFIED_CONTENT_TYPE);
		res.getContents().add(get(XtextGrammarAccess.class).getGrammar());
		OutputStream outputStream = new ByteArrayOutputStream();
		res.save(outputStream, Collections.emptyMap());
	}

}
