/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.tests;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.DefaultEcoreElementFactory;
import org.eclipse.xtext.parser.packrat.AbstractPackratParser;
import org.eclipse.xtext.parser.packrat.ParseResultFactory;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Heiko Behrens
 * 
 */
public abstract class AbstractGeneratorTest extends AbstractXtextTests {

	protected void setAstFactory(AbstractPackratParser parser) {
		ParseResultFactory factory = new ParseResultFactory();
		DefaultEcoreElementFactory astFactory = new DefaultEcoreElementFactory();
		astFactory.setConverterService(getValueConverterService());
		astFactory.setGrammarAccess(getGrammarAccess());
		factory.setFactory(astFactory);
		parser.setParseResultFactory(factory);
//		parser.setParseResultFactory(IParseResultFactory.NullParseResultFactory.INSTANCE);
	}

}
