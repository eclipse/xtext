/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.parser;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
public class CardinalityAwareSyntaxErrorMessageProvider extends SyntaxErrorMessageProvider {

	public static final String CARDINALITY_ISSUE = "CardinalityAwareSyntaxErrorMessageProvider.overriddenCardinality";
	
	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IValueConverterErrorContext context) {
		ValueConverterException cause = context.getValueConverterException();
		if (cause instanceof MoreThanOneCardinalityException) {
			return new SyntaxErrorMessage(context.getDefaultMessage(), CARDINALITY_ISSUE);
		}
		return super.getSyntaxErrorMessage(context);
	}
	
}
