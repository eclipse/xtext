/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.ui.quickfix;

import org.eclipse.xtext.example.fowlerdsl.validation.StatemachineValidator;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Custom quickfixes.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
public class StatemachineQuickfixProvider extends DefaultQuickfixProvider {
	@Fix(StatemachineValidator.INVALID_NAME)
	public void convertNameToFirstLowerCase(Issue issue, IssueResolutionAcceptor acceptor) {
		String[] data = issue.getData();
		String firstLower = StringExtensions.toFirstLower(data[0]);
		String label = "Change to \'" + firstLower + "\'.";
		acceptor.accept(issue, label, label, "upcase.png", (IModification) (IModificationContext ctx) -> {
			IXtextDocument xtextDocument = ctx.getXtextDocument();
			String firstLetter = xtextDocument.get(issue.getOffset(), 1);
			xtextDocument.replace(issue.getOffset(), 1, firstLetter.toLowerCase());
		});
	}

}
