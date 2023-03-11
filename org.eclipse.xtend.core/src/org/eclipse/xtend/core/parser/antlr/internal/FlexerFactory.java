/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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