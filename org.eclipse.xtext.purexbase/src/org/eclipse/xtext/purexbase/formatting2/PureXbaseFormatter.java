/**
 * Copyright (c) 2017, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.purexbase.formatting2;

import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.purexbase.services.PureXbaseGrammarAccess;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter;

import com.google.inject.Inject;

public class PureXbaseFormatter extends XbaseFormatter {
	@Inject
	private PureXbaseGrammarAccess pureXbaseGrammarAccess;

	protected void _format(Model model, IFormattableDocument document) {
		document.format(model.getImportSection());
		document.format(model.getBlock());
	}

	@Override
	protected void _format(XBlockExpression xBlockExpression, IFormattableDocument document) {
		regionFor(xBlockExpression)
				.keywords(pureXbaseGrammarAccess.getSpecialBlockExpressionAccess().getSemicolonKeyword_1_1())
				.forEach(it -> {
					document.append(it, this::newLine);
				});
		for (XExpression xExpression : xBlockExpression.getExpressions()) {
			document.format(xExpression);
		}
	}

	@Override
	public void format(Object expr, IFormattableDocument format) {
		formatUsingPolymorphicDispatcher(expr, format);
	}
}
