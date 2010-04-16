/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import java.io.InputStream;
import java.io.Reader;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein
 */
public interface IAntlrParser extends IParser {
	
	@Deprecated
	IParseResult parse(String ruleName, InputStream in);

	IParseResult parse(String ruleName, Reader reader);
	
}
