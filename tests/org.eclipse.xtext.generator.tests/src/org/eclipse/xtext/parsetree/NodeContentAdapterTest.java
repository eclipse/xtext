/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree;

import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class NodeContentAdapterTest extends AbstractGeneratorTest{

	public void testNodeContentAdapter() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		CompositeNode rootNode = getRootNode("spielplatz 112 'Jajaja' { kind ( Dennis 7) }");
		NodeUtil.dumpCompositeNodes("", rootNode);
	}
}
