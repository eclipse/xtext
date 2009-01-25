/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedTokenCounter extends AbstractParsedTokenVisitor {

	private int counter;
	
	public ParsedTokenCounter() {
		resetCounter();
	}
	
	@Override
	public void visitAbstractParsedToken(AbstractParsedToken token) {
		counter++;
	}

	public void resetCounter() {
		this.counter = 0;
	}

	public int getCounter() {
		return counter;
	}

}
