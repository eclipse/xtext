/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import static org.eclipse.xtext.diagnostics.Diagnostic.*;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.ValueConverterWithValueException;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SyntaxErrorMessageProvider implements ISyntaxErrorMessageProvider {

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
		return new SyntaxErrorMessage(context.getDefaultMessage(), SYNTAX_DIAGNOSTIC);
	}

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IValueConverterErrorContext context) {
		ValueConverterException cause = context.getValueConverterException();
		if (cause instanceof ValueConverterWithValueException) {
			ValueConverterWithValueException casted = (ValueConverterWithValueException) cause;
			if (casted.hasRange()) {
				return createRangedSyntaxErrorMessage(context, casted.getOffset(), casted.getLength());
			}
		}
		return new SyntaxErrorMessage(context.getDefaultMessage(), SYNTAX_DIAGNOSTIC);
	}

	/**
	 * @since 2.7
	 */
	protected SyntaxErrorMessage createRangedSyntaxErrorMessage(IValueConverterErrorContext context, int offset,
			int length) {
		String range = offset + ":" + length;
		return new SyntaxErrorMessage(context.getDefaultMessage(), SYNTAX_DIAGNOSTIC_WITH_RANGE, new String[] { range });
	}
}
