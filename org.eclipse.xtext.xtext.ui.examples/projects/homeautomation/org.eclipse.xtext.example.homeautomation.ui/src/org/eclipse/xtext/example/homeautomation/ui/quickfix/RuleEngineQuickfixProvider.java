/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ui.quickfix;

import org.eclipse.xtext.xbase.ui.quickfix.XbaseQuickfixProvider;

/**
 * Custom quickfixes.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
public class RuleEngineQuickfixProvider extends XbaseQuickfixProvider {

//	@Fix(RuleEngineValidator.INVALID_NAME)
//	public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
//		acceptor.accept(issue, "Capitalize name", "Capitalize the name.", "upcase.png", new IModification() {
//			public void apply(IModificationContext context) throws BadLocationException {
//				IXtextDocument xtextDocument = context.getXtextDocument();
//				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
//				xtextDocument.replace(issue.getOffset(), 1, firstLetter.toUpperCase());
//			}
//		});
//	}

}
