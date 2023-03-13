/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.javadoc;

import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.contentassist.AbstractContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.ITextRegion;

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
	
	@Override
	protected int getReplacementContextLength(ContentAssistContext context) {
		int replacementOffset = context.getReplaceRegion().getOffset();
		INode currentNode = context.getCurrentNode();
		ITextRegion currentRegion = currentNode.getTextRegion();
		String text = currentNode.getText();
		int index = text.indexOf('}', replacementOffset - currentRegion.getOffset());
		if (index == -1) {
			index = text.indexOf('\n', replacementOffset - currentRegion.getOffset());
		}
		if (index != -1) {
			int indexFromStart = index + currentNode.getOffset();
			return indexFromStart - replacementOffset;
		} else {
			return context.getReplaceContextLength();
		}
	}

}
