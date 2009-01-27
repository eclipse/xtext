/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parser.packrat.XtextPackratParser;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextGrammarComparingTest extends AbstractXtextGrammarParsingTest {

	@Override
	protected XtextPackratParser createPackratParser() {
		XtextPackratParser result = new XtextPackratParser();
		setAstFactory(result);
		return result;
	}

	@Override
	protected Class<?> getStandaloneSetupClass() {
		return XtextStandaloneSetup.class;
	}

}
