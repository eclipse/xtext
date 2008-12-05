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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextGrammarSerializationTest extends AbstractGeneratorTest {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void testSerialization() throws Exception {
		String model = "language foo\n"
				+ "generate mm \"http://bar\" as fooMM\n"
				+ "StartRule returns T: name=ID;";
		String expectedModel = "language foo\n"
				+ "generate mm 'http://bar' as fooMM\n"
				+ "StartRule returns fooMM :: T: name=ID;";
		XtextResource resource = getResourceFromString(model);
		assertTrue(resource.getErrors().isEmpty());
		Grammar g = (Grammar) resource.getParseResult().getRootASTElement();
		assertNotNull(g);
		OutputStream outputStream = new ByteArrayOutputStream();
		resource.save(outputStream, Collections.emptyMap());
		String serializedModel = outputStream.toString();
		assertEquals(expectedModel, serializedModel);
	}

	/**
	 * TODO for Sebastian from Moritz: Can you please make this test work again.
	 * It fails becuse
	 * org.eclipse.xtext.xtext.XtextLinkingService.getLinkText(EObject,
	 * EReference, EObject) returns null. In my opinion it must never do so. For
	 * details, talk to me.
	 */
//	public void testXtestSerializationSelfTest() throws Exception {
//		Resource res = new XtextResourceSet().createResource(URI
//				.createURI("myfile.xtext"));
//		res.getContents().add(XtextGrammarAccess.INSTANCE.getGrammar());
//		res.save(System.out, Collections.emptyMap());
//	}

}
