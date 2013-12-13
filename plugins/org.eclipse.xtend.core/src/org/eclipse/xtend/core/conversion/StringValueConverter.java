/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.conversion;

import java.io.StringReader;

import org.antlr.runtime.TokenSource;
import org.eclipse.xtend.core.parser.antlr.internal.FlexTokenSource;
import org.eclipse.xtext.conversion.impl.STRINGValueConverter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StringValueConverter extends STRINGValueConverter {

	@Override
	protected TokenSource getTokenSource(String escapedValue) {
		return new FlexTokenSource(new StringReader(escapedValue));
	}
	
}
