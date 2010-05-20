/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IPackratParser extends IParser {

	IParseResult parse(CharSequence input);
	
	IParseResult parse(CharSequence input, INonTerminalConsumer consumer);
	
}
