/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.testlanguages.FowlerDslTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextParserBugsTest extends AbstractGeneratorTest {

	public void testFirstTokenIsIllegal_254841() throws Exception {
		with(FowlerDslTestLanguageStandaloneSetup.class);
		String model = "firstToken";
		CompositeNode rootNode = getRootNodeAndExpect(model, 1);
		assertNotNull(rootNode);
	}

}
