/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import static java.lang.Math.max;
import static org.eclipse.xtext.parsetree.ParseTreeUtil.getCurrentOrFollowingNodeByOffset;
import static org.eclipse.xtext.parsetree.ParseTreeUtil.getLastCompleteNodeByOffset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistCalculator;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.ITemplateContentAssistProcessor;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * The default implementation of interface {@link IContentAssistProcessor} provided with Xtext.
 *
 * @author Michael Clay - Initial contribution and API
 * @author Heiko Behrens
 * @author Jan K&ouml;hnlein
 */
public class DefaultContentAssistProcessor implements IContentAssistProcessor {
	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());
	@Inject
	protected ITemplateContentAssistProcessor templateContentAssistProcessor;
	@Inject
	protected IContentAssistCalculator contentAssistCalculator;
	@Inject
	protected IProposalProvider proposalProvider;
	/**
	 * Computes the possible grammar elements following the one at the given offset and calls the respective methods on
	 * the proposal provider.
	 */
	public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer, final int offset) {
		IXtextDocument document = (IXtextDocument) viewer.getDocument();
		return document.readOnly(new ContentAssistProcessorUow(offset, viewer));
	}
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
	 */
	public String getErrorMessage() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer, int)
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
	 */
	public IContextInformationValidator getContextInformationValidator() {
		return new ContextInformationValidator(this);
	}
	
	protected List<ICompletionProposal> collectCompletionProposals(List<AbstractElement> computeProposalElements, IContentAssistContext contentAssistContext) {
		List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();
		for (AbstractElement computeProposalElement : computeProposalElements) {
			List<? extends ICompletionProposal> proposals;
			switch(computeProposalElement.eClass().getClassifierID()) {
				case XtextPackage.KEYWORD:
					proposals = proposalProvider.completeKeyword((Keyword) computeProposalElement, contentAssistContext);
					addAllIfNotNull(completionProposalList,proposals);
					break;
				case XtextPackage.RULE_CALL:
					proposals = proposalProvider.completeRuleCall((RuleCall) computeProposalElement, contentAssistContext);
					addAllIfNotNull(completionProposalList,proposals);
					break;
				case XtextPackage.ASSIGNMENT:
					proposals = proposalProvider.completeAssignment((Assignment) computeProposalElement, contentAssistContext);
					addAllIfNotNull(completionProposalList,proposals);
					break;
			}
		}
		return completionProposalList;
	}

	private <T> void addAllIfNotNull(List<T> completionProposalList,
			List<? extends T> proposals) {
		Iterables.addAll(completionProposalList, Iterables.filter(proposals, Predicates.notNull()));
	}
	
	protected List<TemplateContextType> collectTemplateContextTypes(List<AbstractElement> computeProposalElements,
			IContentAssistContext contentAssistContext) {
		List<TemplateContextType> templateContextTypes = new ArrayList<TemplateContextType>();
		for (AbstractElement computeProposalElement : computeProposalElements) {
			TemplateContextType templateContextType;
			switch (computeProposalElement.eClass().getClassifierID()) {
				case XtextPackage.KEYWORD:
					templateContextType = proposalProvider.getTemplateContextType((Keyword) computeProposalElement,
							contentAssistContext);
					addIfNotNull(templateContextTypes, templateContextType);
					break;
				case XtextPackage.RULE_CALL:
					templateContextType = proposalProvider.getTemplateContextType((RuleCall) computeProposalElement,
							contentAssistContext);
					addIfNotNull(templateContextTypes, templateContextType);
					break;
				case XtextPackage.ASSIGNMENT:
					// TODO: change interface
					// templateContextType =
					// proposalProvider.getTemplateContextType((Assignment)computeProposalElement, contentAssistContext);
					// addIfNotNull(templateContextTypes, templateContextType);
					break;
			}
		}
		return templateContextTypes;
	}
	
	private <T> void addIfNotNull(List<T> result, T obj) {
		if (obj != null)
			result.add(obj);
	}
	
	/**
	 * Adds templates to the list of proposals,
	 *
	 * @param viewer the viewer whose document is used to compute the proposals
	 * @param offset an offset within the document for which completions should be computed
	 * @param contentAssistContext the current context of the content assist proposal request
	 * @param templateContextType within which templates are resolved
	 * @param completionProposalList list of proposal to add to
	 */
	protected void addTemplates(ITextViewer viewer, int offset, IContentAssistContext contentAssistContext,
			TemplateContextType templateContextType, List<ICompletionProposal> completionProposalList) {
		if (templateContentAssistProcessor != null) {
			templateContentAssistProcessor.setContentAssistContext(contentAssistContext);
			templateContentAssistProcessor.setContextType(templateContextType);
			completionProposalList.addAll(Arrays.asList(templateContentAssistProcessor.computeCompletionProposals(
					viewer, offset)));
		}
	}
	/**
	 * Creates a new <code>IContentAssistContext</code> with all required informations for the current CA request.
	 *
	 * @param resource the underlying EMF resource to read (parse) from
	 * @param viewer the viewer whose document is used to compute the proposals
	 * @param offset the offset within the resource for which the context should be created
	 * @return a list of applicable <code>IContentAssistContext</code>
	 */
	protected List<IContentAssistContext> createContextList(XtextResource resource, String text, final int offset) {
		List<IContentAssistContext> result = new ArrayList<IContentAssistContext>();
		IParseResult parseResult = resource.getParseResult();
		Assert.isNotNull(parseResult);
		CompositeNode rootNode = parseResult.getRootNode();
		AbstractNode referenceNode = getLastCompleteNodeByOffset(rootNode, offset);
		AbstractNode nodeAtOffset  = getCurrentOrFollowingNodeByOffset(rootNode, offset);

		if (referenceNode.getOffset()+referenceNode.getLength() == offset) {
			AbstractNode precedingReferenceNode = getLastCompleteNodeByOffset(rootNode,max(0, referenceNode.getOffset()));
			String matchingString = computeMatchString(referenceNode);
			result.add(newContentAssistContext(matchingString, offset, rootNode, precedingReferenceNode));
			if (referenceNode.getGrammarElement() instanceof Keyword ||
				referenceNode.getGrammarElement() instanceof CrossReference ||
				(referenceNode.getGrammarElement() instanceof RuleCall &&
				((RuleCall)referenceNode.getGrammarElement()).getRule() instanceof TerminalRule)) {
				result.add(newContentAssistContext("", offset, rootNode, referenceNode));
			}
		} else if (referenceNode == nodeAtOffset) {
			AbstractNode precedingReferenceNode = getLastCompleteNodeByOffset(rootNode,max(0, referenceNode.getOffset()));
			String matchingString = calculateMatchString(nodeAtOffset,text, offset);
			result.add(newContentAssistContext(matchingString, offset, rootNode, precedingReferenceNode));
		} else {
			String matchingString = calculateMatchString(nodeAtOffset,text, offset);
			result.add(newContentAssistContext(matchingString, offset, rootNode, referenceNode));
		}
		
		return result;
	}
	
	protected String computeMatchString(AbstractNode node) {
		if (node instanceof LeafNode) {
			return ((LeafNode) node).getText();
		}
		StringBuilder result = new StringBuilder(node.getTotalLength());
		doComputeMatchString((CompositeNode) node, result);
		return result.toString();
	}
	
	protected void doComputeMatchString(CompositeNode node, StringBuilder result) {
		List<LeafNode> hiddens = new ArrayList<LeafNode>(2);
		for (AbstractNode child: node.getChildren()) {
			if (child instanceof CompositeNode) {
				doComputeMatchString((CompositeNode) child, result);
			} else {
				if (((LeafNode) child).isHidden()) {
					if (result.length() != 0)
						hiddens.add((LeafNode)child);
				} else {
					Iterator<LeafNode> iter = hiddens.iterator();
					while(iter.hasNext()) {
						result.append(iter.next().getText());
						iter.remove();
					}
					result.append(((LeafNode) child).getText());
				}
			}
		}
	}
	
	/**
	 * Calculates the match string of the based on the specified location within the given text.
	 *
	 * @param caretNode the node at the current caret position
	 * @param text the text to compute the matching string
	 * @param offset an offset within the document for which the matchstring should be computed
	 * @return a matching string
	 */
	protected String calculateMatchString(AbstractNode caretNode, String text, int offset) {
		StringBuilder matchString = new StringBuilder();
		char c = ' ';
		while (offset>caretNode.getOffset() && !Character.isWhitespace(c = text.charAt(--offset))) {
			matchString.insert(0, c);
		}
		return matchString.toString();
	}
	
	private ContentAssistContext newContentAssistContext(String matchingString, final int offset, CompositeNode rootNode,
			AbstractNode referenceNode) {
		EObject model = NodeUtil.getNearestSemanticObject(referenceNode);
		AbstractNode node = getCurrentOrFollowingNodeByOffset(rootNode, offset);
		return new ContentAssistContext(model, offset, matchingString, node, referenceNode, rootNode);
	}
	
	private final class ContentAssistProcessorUow implements UnitOfWork<ICompletionProposal[]> {
		private final int offset;
		private final ITextViewer viewer;

		private ContentAssistProcessorUow(int offset, ITextViewer viewer) {
			this.offset = offset;
			this.viewer = viewer;
		}

		public ICompletionProposal[] exec(XtextResource resource) throws Exception {
			List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();
			List<IContentAssistContext> contextList = createContextList(
					resource, viewer.getTextWidget().getText(), offset);
			for (IContentAssistContext contentAssistContext : contextList) {
				List<AbstractElement> computedElements = contentAssistCalculator
						.computeProposalElements(contentAssistContext);
				completionProposalList.addAll(collectCompletionProposals(computedElements,contentAssistContext));
				for (TemplateContextType templateContextType : collectTemplateContextTypes(computedElements,
						contentAssistContext)) {
					addTemplates(viewer, offset, contentAssistContext, templateContextType, completionProposalList);
				}
				proposalProvider.filter(completionProposalList,contentAssistContext);
			}
			proposalProvider.sort(completionProposalList);
			return completionProposalList.toArray(new ICompletionProposal[completionProposalList.size()]);
		}
	}

}

