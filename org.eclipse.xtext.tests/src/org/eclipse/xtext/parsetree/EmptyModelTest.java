/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.optionalEmpty.Model;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

public class EmptyModelTest extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(OptionalEmptyTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testParseEmpty() throws Exception {
		Model model = (Model) getModel("");
		assertNull(model);
		model = (Model) getModel("hallo welt");
		assertEquals("welt", model.getChild().getName());
	}
	
	@Test public void testParseCommentOnly() throws Exception {
	    String model = "// some single line comment \n /* and \n a \n \n multiline \n comment */";
        assertEmptyModel(model);
	}

    private void assertEmptyModel(String model) throws Exception {
        IParseResult parseResult = getResource(new StringInputStream(model)).getParseResult();
	    assertNull(parseResult.getRootASTElement());
	    ICompositeNode rootNode = parseResult.getRootNode();
        assertNotNull(rootNode);
        assertEquals(model, rootNode.getText());
    }
	
	@Test public void testParseWhitespaceOnly() throws Exception {
        String model = "    \t\n\r  \t\n\n ";
	    assertEmptyModel(model);
	}
	
}
