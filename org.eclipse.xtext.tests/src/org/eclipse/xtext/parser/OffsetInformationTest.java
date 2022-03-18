/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.impl.InvariantChecker;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

public class OffsetInformationTest extends AbstractPartialParserTest {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testCheckParsing() throws Exception {
		String string = "spielplatz 34 'holla' {\n"
			+ "  kind (Horst 3)\n"
			+ "  erwachsener (Julia 45)\n"
			+ "  erwachsener (Herrmann 50)\n" 
			+ "  erwachsener (Herrmann 50)\n" 
			+ "  erwachsener (Herrmann 50)\n" 
			+ "  erwachsener (Herrmann 50)\n" 
			+ "  erwachsener (Herrmann 50)\n" 
			+ "}";
		XtextResource resource = getResource(new StringInputStream(string));
		ICompositeNode rootNode = resource.getParseResult().getRootNode();
		
		for (int i=0;i<string.length()/2;i++) {
			String substring = string.substring(i, string.length()-i);
			resource.update(i, substring.length(), substring);
			ICompositeNode model = resource.getParseResult().getRootNode();
			new InvariantChecker().checkInvariant(model);
			assertSameStructure(rootNode, model);
		}
		
	}
}
