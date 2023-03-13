/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.javadoc;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.documentation.IJavaDocTypeReferenceProvider;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendJavaDocCompletionProposalComputer implements IUnitOfWork<ICompletionProposal[], XtextResource>, ICompletionProposalAcceptor {

	private XtendJavaDocState protocol;

	private int offset;

	private ITextViewer viewer;

	private final Collection<ICompletionProposal> proposals;

	public XtendJavaDocCompletionProposalComputer(XtendJavaDocState protocol, ITextViewer viewer, int offset) {
		this.protocol = protocol;
		this.offset = offset;
		this.viewer = viewer;
		this.proposals = new LinkedHashSet<ICompletionProposal>(30);
	}

	@Override
	public ICompletionProposal[] exec(XtextResource resource) throws Exception {

		List<ContentAssistContext> contexts = Arrays.asList(protocol.getContextFactory().create(viewer, offset, resource));
		if (contexts.size() > 0) {
			ContentAssistContext contentAssistContext = contexts.get(contexts.size() -1);
			if(isValidPositionForTypeProposal(contentAssistContext)){
				ITypesProposalProvider typesProposalProvider = protocol.getTypesProposalProvider();
				typesProposalProvider.createTypeProposals(protocol.getProposalFactory(), contentAssistContext, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, this);
			}
		}
		return proposals.toArray(new ICompletionProposal[proposals.size()]);
	}

	@Override
	public void accept(ICompletionProposal proposal) {
		if (proposal == null)
			return;
		proposals.add(proposal);
	}

	@Override
	public boolean canAcceptMoreProposals() {
		return true;
	}

	protected boolean isValidPositionForTypeProposal(ContentAssistContext contentAssistContext){
		INode currentNode = contentAssistContext.getCurrentNode();
		String content = currentNode.getText();
		int offsetInNode = contentAssistContext.getOffset() - currentNode.getOffset() - contentAssistContext.getPrefix().length();
		String textInFront = content.substring(0, offsetInNode);
		int lastIndexOfLink = textInFront.lastIndexOf(IJavaDocTypeReferenceProvider.LINK_TAG_WITH_SUFFIX);
		if(lastIndexOfLink != -1){
			if(textInFront.substring(lastIndexOfLink, offsetInNode).trim().equals(IJavaDocTypeReferenceProvider.LINK_TAG))
				return true;
		}
		int lastIndexOfSee = textInFront.lastIndexOf(IJavaDocTypeReferenceProvider.SEE_TAG_WITH_SUFFIX);
		if(lastIndexOfSee != -1){
			if(textInFront.substring(lastIndexOfSee, offsetInNode).trim().equals(IJavaDocTypeReferenceProvider.SEE_TAG))
				return true;
		}
		return false;
	}

}
