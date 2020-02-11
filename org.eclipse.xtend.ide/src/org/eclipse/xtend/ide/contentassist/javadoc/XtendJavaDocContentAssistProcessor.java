/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.javadoc;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendJavaDocContentAssistProcessor extends AbstractJavaDocContentAssistProcessor implements  XtendJavaDocState{

	@Inject
	protected IScopeProvider scopeProvider;

	@Inject
	protected XtendJavaDocContentAssistContextFactory contentAssistFactory;

	@Inject
	private ITypesProposalProvider typeProposalProvider;

	@Inject
	private XtendJavaDocProposalFactory proposalFactory;
	
	/**
	 * @since 2.19
	 */
	@Inject
	private XtextDocumentUtil xtextDocumentUtil;

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		IXtextDocument document = xtextDocumentUtil.getXtextDocument(viewer);
		if (document != null) {
			return document.priorityReadOnly(createCompletionProposalComputer(viewer, offset));
		}
		return new ICompletionProposal[0];
	}

	private XtendJavaDocCompletionProposalComputer createCompletionProposalComputer(ITextViewer viewer,
			int offset) {
		return new XtendJavaDocCompletionProposalComputer(this, viewer, offset);
	}

	@Override
	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	@Override
	public ContentAssistContext.Factory getContextFactory() {
		return contentAssistFactory;
	}

	@Override
	public ITypesProposalProvider getTypesProposalProvider() {
		return typeProposalProvider;
	}

	@Override
	public XtendJavaDocProposalFactory getProposalFactory() {
		return proposalFactory;
	}
}
