/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import java.nio.charset.StandardCharsets
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.xml.type.XMLTypePackage
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.testing.GlobalRegistries
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.xtext.generator.grammarAccess.GrammarAccessExtensions
import org.eclipse.xtext.xtext.generator.parser.antlr.KeywordHelper
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class KeywordHelperTest extends AbstractXtextTests {
	
	GlobalStateMemento globalStateMemento;
	
	@Before
	override setUp() {
		globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
		super.setUp();
		EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
		with(XtextStandaloneSetup)
	}
	
	@After
	override tearDown() {
		super.tearDown()
		globalStateMemento.restoreGlobalState();
	}
	
	@Test def void testToAntlrTokenIdentifier() {
		val resource = getResourceFromString('''
		grammar org.eclipse.xtext.xbase.Xbase with org.eclipse.xtext.common.Terminals
		import "http://www.eclipse.org/emf/2002/Ecore" as ecore
		Model returns ecore::EClass : "model" "/EOF" "EOF" "ƒ÷‹‰ˆ¸ﬂ" name=ID;
		''')
		val grammar = resource.contents.head as Grammar
		val keywordHelper = new KeywordHelper(grammar, true, new GrammarAccessExtensions)
		assertEquals("[/EOF, EOF, model, ƒ÷‹‰ˆ¸ﬂ]", keywordHelper.allKeywords.sort.toString)
		assertEquals("KW_EOF_1", keywordHelper.getRuleName("/EOF"))
		assertEquals("KW_EOF", keywordHelper.getRuleName("EOF"))
		assertEquals("Model", keywordHelper.getRuleName("model"))
		assertEquals("AeOeUeaeOeUe", keywordHelper.getRuleName("ƒ÷‹‰ˆ¸ﬂ")) //ﬂ is not escaped
	}
	
	override protected getAsStream(String model) {
		getAsStream(model, StandardCharsets.ISO_8859_1)
	}
	
}