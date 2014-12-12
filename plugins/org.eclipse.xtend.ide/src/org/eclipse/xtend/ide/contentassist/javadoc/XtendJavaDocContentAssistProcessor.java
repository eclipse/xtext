/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.javadoc;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

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

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		if(viewer instanceof XtextSourceViewer){
			IXtextDocument document = (IXtextDocument) viewer.getDocument();
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
