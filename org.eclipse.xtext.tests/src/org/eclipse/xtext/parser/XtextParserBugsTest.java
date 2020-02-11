/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.testlanguages.FowlerDslTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextParserBugsTest extends AbstractXtextTests {

	@Test public void testFirstTokenIsIllegal_254841() throws Exception {
		with(FowlerDslTestLanguageStandaloneSetup.class);
		String model = "firstToken";
		ICompositeNode rootNode = getRootNodeAndExpect(model, 1);
		assertNotNull(rootNode);
	}

}
