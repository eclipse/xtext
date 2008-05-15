/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference;

import org.apache.tools.ant.filters.StringInputStream;
import org.eclipse.xtext.reference.parser.ReferenceGrammarASTFactory;
import org.eclipse.xtext.reference.parser.ReferenceGrammarParser;

import junit.framework.TestCase;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public class ReferenceGrammarTest extends TestCase {
	
	{
		ReferenceGrammarStandaloneSetup.doSetup();
	}
	
	public void testParseGrammar() {
		String grammar = 
			"spielplatz '200' {" +
			"    kind (soeren '7')" +
			"    kind (lennart '4')" +
			"    kind (jonas '1')" +
			"    erwachsener (peter '33')" + 
			"    erwachsener (anne '33')" + 
			"}";
		
		ReferenceGrammarParser parser = new ReferenceGrammarParser();
		Object object = parser.parse(new StringInputStream(grammar), new ReferenceGrammarASTFactory());
		System.out.println(object);
		
	}

}
