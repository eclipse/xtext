/*******************************************************************************
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.quickfix

import org.eclipse.xtext.example.fowlerdsl.validation.StatemachineValidator
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.validation.Issue

/**
 * Custom quickfixes.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
class StatemachineQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(StatemachineValidator.INVALID_NAME)
	def convertNameToFirstLowerCase(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change to '"+issue.data.head.toFirstLower+"'.", "Change to '"+issue.data.head.toFirstLower+"'.", 'upcase.png') [
			val firstLetter = xtextDocument.get(issue.offset, 1)
			xtextDocument.replace(issue.offset, 1, firstLetter.toLowerCase)
		]
	}
}
