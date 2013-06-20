/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.junit.Test;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class PartialParsingPointerReferenceTest extends AbstractPartialParsingPointerTest {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
	}
	
	@Test public void testReference() throws Exception {
		String model = "spielplatz 17 { kind ( Dennis 6 ) kind ( Sven 7 ) }";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, model.indexOf("Sven"), 4);
		checkParseRegionPointers(parsingPointers, " kind ( Sven 7 )", "RuleCall", "Kind");
	}
}
