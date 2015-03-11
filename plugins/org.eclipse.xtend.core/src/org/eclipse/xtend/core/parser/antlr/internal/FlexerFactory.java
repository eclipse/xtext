/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.parser.antlr.internal;

import java.io.Reader;

import org.eclipse.xtend.core.parser.InternalFlexer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FlexerFactory {
	public InternalFlexer createFlexer(Reader reader) {
		return new InternalXtendFlexer(reader);
	}
	public FlexTokenSource createTokenSource(Reader reader) {
		return new FlexTokenSource(createFlexer(reader));
	}
}