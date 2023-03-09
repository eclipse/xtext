/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Pierre Jeanjean - Initial contribution and API
 */
public class XtextSerializationTokensTest extends AbstractXtextTests {

	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.with(new XtextStandaloneSetup());
	}

	@Ignore
	@Test
	public void testParserRuleReturnsToken() throws Exception {
		this.serializeAndCheckTokens(
				"grammar org.eclipse.xtext.serializer.XtextSerializationTokensTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore\n" +
				"\n" +
				"Concept returns ecore::EObject:\n" +
				"	{ecore::EObject};"
		);
	}

	@Ignore
	@Test
	public void testParserRuleGreaterSignToken() throws Exception {
		this.serializeAndCheckTokens(
				"grammar org.eclipse.xtext.serializer.XtextSerializationTokensTestLanguage with org.eclipse.xtext.common.Terminals\n" +
				"\n" +
				"import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore\n" +
				"\n" +
				"Concept <param1, param2> returns ecore::EObject:\n" +
				"	{ecore::EObject};"
		);
	}

	public void serializeAndCheckTokens(String grammarString) throws Exception {
		XtextResource resource = this.getResourceFromString(grammarString);
		Grammar grammarCopy = (Grammar) EcoreUtil.copy(resource.getContents().get(0));
		resource.getContents().add(0, grammarCopy);
		assertEquals(grammarString, this.serialize(grammarCopy));
	}

}
