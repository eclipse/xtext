/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.javadoc;

import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendJavaDocProposalFactory extends AbstractContentProposalProvider {

	@Override
	public void completeKeyword(Keyword object, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {}

	@Override
	public void completeRuleCall(RuleCall object, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {}

	@Override
	public void completeAssignment(Assignment object, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {}

}
