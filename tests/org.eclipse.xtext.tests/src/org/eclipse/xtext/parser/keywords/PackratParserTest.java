/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.keywords;

import org.eclipse.xtext.parser.packrat.IPackratParser;

public class PackratParserTest extends AbstractParserTest {

	@Override
	protected IPackratParser getParserUnderTest() {
		return getPackratParser();
	}

}