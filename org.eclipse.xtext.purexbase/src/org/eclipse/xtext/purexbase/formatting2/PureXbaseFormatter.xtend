/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.formatting2

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.purexbase.pureXbase.Model
import org.eclipse.xtext.purexbase.services.PureXbaseGrammarAccess
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.formatting2.XbaseFormatter

class PureXbaseFormatter extends XbaseFormatter {
	
	@Inject extension PureXbaseGrammarAccess

	def dispatch void format(Model model, extension IFormattableDocument document) {
		model.getImportSection.format;
		model.getBlock.format;
	}

	override dispatch void format(XBlockExpression xBlockExpression, extension IFormattableDocument document) {
		xBlockExpression.regionFor.keywords(specialBlockExpressionAccess.semicolonKeyword_1_1)
			.forEach[append[newLine]]
		for (XExpression xExpression : xBlockExpression.getExpressions()) {
			xExpression.format;
		}
	}
	
}
