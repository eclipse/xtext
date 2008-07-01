/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parser.impl.PartialParsingUtil;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.testlanguages.SimpleExpressionsStandaloneSetup;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class PartialParsingPerformanceTest extends AbstractPartialParserTest {

	public void testPerformance() throws Exception {
		with(SimpleExpressionsStandaloneSetup.class);
		StringBuffer modelBuffer = new StringBuffer();
		for(int i=0; i<200; ++i) {
			modelBuffer.append("(a+(b*");
		}
		modelBuffer.append("c");
		for(int i=0; i<200; ++i) {
			modelBuffer.append(")+d)");
		}
		String model = modelBuffer.toString();
		CompositeNode rootNode = getRootNode(model);
		IParseResult reparse = PartialParsingUtil.reparse(getParser(), rootNode, model.indexOf('c'), 1, "Hugo", null);
		assertTrue(reparse.getParseErrors() == null || reparse.getParseErrors().isEmpty());
	}
	
}
