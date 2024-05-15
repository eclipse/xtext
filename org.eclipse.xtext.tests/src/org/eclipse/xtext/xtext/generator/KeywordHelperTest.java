/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions;
import org.eclipse.xtext.xtext.generator.parser.antlr.KeywordHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class KeywordHelperTest extends AbstractXtextTests {
	private GlobalRegistries.GlobalStateMemento globalStateMemento;

	@Before
	@Override
	public void setUp() throws Exception {
		globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
		super.setUp();
		EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
		with(XtextStandaloneSetup.class);
	}

	@After
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		globalStateMemento.restoreGlobalState();
	}

	@Test
	public void testToAntlrTokenIdentifier() throws Exception {
		// @formatter:off
		String model =
		"grammar org.eclipse.xtext.xbase.Xbase with org.eclipse.xtext.common.Terminals\n" +
		"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
		"Model returns ecore::EClass : 'model' '/EOF' 'EOF' 'ƒ÷‹‰ˆ¸ﬂ' name=ID;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		KeywordHelper keywordHelper = new KeywordHelper(grammar, true, new GrammarAccessExtensions());
		Assert.assertEquals("[/EOF, EOF, model, ƒ÷‹‰ˆ¸ﬂ]",
				IterableExtensions.sort(keywordHelper.getAllKeywords()).toString());
		Assert.assertEquals("KW_EOF_1", keywordHelper.getRuleName("/EOF"));
		Assert.assertEquals("KW_EOF", keywordHelper.getRuleName("EOF"));
		Assert.assertEquals("Model", keywordHelper.getRuleName("model"));
		Assert.assertEquals("AeOeUeaeOeUe", keywordHelper.getRuleName("ƒ÷‹‰ˆ¸ﬂ"));
	}

	@Override
	protected InputStream getAsStream(String model) {
		return getAsStream(model, StandardCharsets.ISO_8859_1);
	}
}
