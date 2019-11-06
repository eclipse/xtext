/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics.ui.quickfix;

import org.eclipse.xtext.example.arithmetics.validation.ArithmeticsValidator;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

/**
 * Custom quickfixes.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
public class ArithmeticsQuickfixProvider extends DefaultQuickfixProvider {
	@Fix(ArithmeticsValidator.NORMALIZABLE)
	public void normalize(Issue issue, IssueResolutionAcceptor acceptor) {
		String string = issue.getData()[0];
		acceptor.accept(issue, "Replace with " + string, "Replace expression with \'" + string + "\'", "upcase.png",
				(IModification) (IModificationContext it) -> {
					it.getXtextDocument().replace((issue.getOffset()).intValue(), (issue.getLength()).intValue(),
							string);
				});
	}

}
