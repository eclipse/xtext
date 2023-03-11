/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.conversion;

import java.io.StringReader;

import org.antlr.runtime.TokenSource;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtext.xbase.conversion.XbaseValueConverterService;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IntUnderscoreValueConverter extends XbaseValueConverterService.IntUnderscoreValueConverter {

	@Inject
	private FlexerFactory flexerFactory;
	
	@Override
	protected TokenSource getTokenSource(String escapedValue) {
		return flexerFactory.createTokenSource(new StringReader(escapedValue));
	}
	
}
