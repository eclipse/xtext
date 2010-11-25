/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguageStandaloneSetup;
import org.eclipse.xtext.util.StringInputStream;

public class EmptyModelTest extends AbstractXtextTests {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(OptionalEmptyTestLanguageStandaloneSetup.class);
	}
	
	public void testParseEmpty() throws Exception {
		EObject model = getModel("");
		assertNull(model);
		model = getModel("hallo welt");
		assertWithXtend("'welt'", "child.name", model);
	}
	
	public void testParseCommentOnly() throws Exception {
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
	
	public void testParseWhitespaceOnly() throws Exception {
        String model = "    \t\n\r  \t\n\n ";
	    assertEmptyModel(model);
	}
	
}
