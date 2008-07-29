/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference.ui.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.ParseTreeUtil;
import org.eclipse.xtext.reference.ui.services.contentassist.Proposal;
import org.eclipse.xtext.reference.ui.services.contentassist.XtextCompletionProposal;
import org.eclipse.xtext.ui.editor.model.IEditorModel;
import org.eclipse.xtext.ui.service.impl.AbstractProposalsProvider;
import org.eclipse.xtext.ui.util.GrammarConstants;

/**
 * Represent a 'showcase' implementation of a xtext contentassist proposal
 * provider.
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @author Michael Clay - Initial contribution and API
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class ReferenceProposalsProvider extends AbstractProposalsProvider {

	private class ReferenceCompletionContext extends CompletionContext {

		private final AbstractNode lastCompleteNode;
		private final LeafNode currentLeafNode;
		private final AbstractElement abstractElement;

		public ReferenceCompletionContext(IEditorModel editorModel, Region region, ITextViewer textViewer,
				TemplateContextType templateContextType, AbstractNode lastCompleteNode, LeafNode currentLeafNode,
				AbstractElement abstractElement) {
			super(editorModel, region, textViewer, templateContextType);
			this.lastCompleteNode = lastCompleteNode;
			this.currentLeafNode = currentLeafNode;
			this.abstractElement = abstractElement;
		}

		public AbstractNode getLastCompleteNode() {
			return lastCompleteNode;
		}

		public LeafNode getCurrentLeafNode() {
			return currentLeafNode;
		}

		public AbstractElement getAbstractElement() {
			return abstractElement;
		}

	}

	private final Set<AbstractElement> getProposalElements(AbstractNode contextNode, AbstractElement grammarElement) {

		ParseTreeUtil.assertParameterNotNull(contextNode, "contextNode");

		ParseTreeUtil.assertParameterNotNull(grammarElement, "grammarElement");

		Set<AbstractElement> elementSet = new LinkedHashSet<AbstractElement>();

		if (grammarElement.eContainer() instanceof ParserRule) {

			/**
			 * we have completed the rule of the current context.continue at the
			 * parent context
			 */
			boolean hasLeafNodes = false;

			for (Iterator<LeafNode> iterator = contextNode.getLeafNodes().listIterator(); !hasLeafNodes
					&& iterator.hasNext(); hasLeafNodes = !iterator.next().isHidden()) {
				;
			}

			contextNode = contextNode.getParent();

			while (contextNode != null && contextNode.getGrammarElement() == null) {
				contextNode = contextNode.getParent();
			}

			if (null != contextNode) {

				elementSet
						.addAll(getProposalElements(contextNode, ParseTreeUtil.getGrammarElementFromNode(contextNode)));

			}
			else if (grammarElement.eContainer() instanceof ParserRule) {

				if (!hasLeafNodes || GrammarUtil.isMultipleCardinality(grammarElement)) {
					elementSet.add(grammarElement);
				}

			}

		}
		else if (grammarElement.eContainer() instanceof Alternatives) {
			/**
			 * one out of the alternatives is already fullfilled so we can
			 * simply skip and proceed to the parent
			 */

			elementSet.addAll(getProposalElements(contextNode, (AbstractElement) grammarElement.eContainer()));

		}
		else if (grammarElement.eContainer() instanceof Group) {

			EList<AbstractElement> contents = ((Group) grammarElement.eContainer()).getAbstractTokens();

			int indexOf = contents.indexOf(grammarElement) + 1;

			int size = contents.size();

			// add the current one if has an oneOrMore cardinality
			if (GrammarUtil.isOneOrMoreCardinality(grammarElement)) {
				elementSet.add(grammarElement);
			}

			/**
			 * start at the current (maybe the last) or at the following one
			 * with optional cardinality and add all following with optional
			 * cardinality
			 */
			AbstractElement last = GrammarUtil.isAnyCardinality(grammarElement) || indexOf == size ? grammarElement
					: contents.get(indexOf++);

			while (GrammarUtil.isOptionalCardinality(last) && indexOf < size) {
				elementSet.add(last);
				last = indexOf < size ? contents.get(indexOf++) : last;
			}

			// always add the following if available or the last one if has an
			// any cardinality
			if (last != grammarElement || GrammarUtil.isAnyCardinality(last)) {
				elementSet.add(last);
			}

			// ask parent groups only if we've completed the whole group
			if (indexOf == size) {

				boolean startedAtlastGrammarElementInGroup = last == grammarElement;

				if (startedAtlastGrammarElementInGroup || GrammarUtil.isOptionalCardinality(last)) {

					elementSet.addAll(getProposalElements(contextNode, (AbstractElement) grammarElement.eContainer()));
				}

			}

		}
		else {
			elementSet.addAll(getProposalElements(contextNode, (AbstractElement) grammarElement.eContainer()));

		}

		return elementSet;
	}

	private final List<Proposal> toProposalList(AbstractNode rootNode, AbstractElement abstractElement) {

		List<Proposal> proposals = new ArrayList<Proposal>();

		if (abstractElement instanceof Keyword) {
			proposals.addAll(toProposalList(rootNode, ((Keyword) abstractElement)));
		}
		else if (abstractElement instanceof Alternatives) {
			proposals.addAll(toProposalList(rootNode, ((Alternatives) abstractElement)));
		}
		else if (abstractElement instanceof Assignment) {
			proposals.addAll(toProposalList(rootNode, ((Assignment) abstractElement)));
		}
		else if (abstractElement instanceof RuleCall) {
			proposals.addAll(toProposalList(rootNode, ((RuleCall) abstractElement)));
		}
		else if (abstractElement instanceof Group) {
			proposals.addAll(toProposalList(rootNode, ((Group) abstractElement)));
		}
		else {
			proposals.add(new Proposal(abstractElement.toString()));
		}
		return proposals;
	}

	private final List<Proposal> toProposalList(AbstractNode rootNode, Keyword keyword) {
		// simply add the value of the keyword
		Proposal proposal = new Proposal(keyword.getValue().length() == 1 ? keyword.getValue() : keyword.getValue()
				+ " ");
		proposal.setLabel(new StyledString(keyword.getValue(), StyledString.COUNTER_STYLER));
		return Arrays.asList(proposal);
	}

	private final List<Proposal> toProposalList(AbstractNode rootNode, Alternatives alternatives) {
		// add all possible alternatives
		List<Proposal> proposals = new ArrayList<Proposal>();
		for (AbstractElement alternativeElement : alternatives.getGroups()) {
			proposals.addAll(toProposalList(rootNode, alternativeElement));
		}
		return proposals;
	}

	private final List<Proposal> toProposalList(AbstractNode rootNode, Assignment assignment) {
		// adds the terminal symbol of the assignment
		return toProposalList(rootNode, assignment.getTerminal());
	}

	private final List<Proposal> toProposalList(AbstractNode rootNode, RuleCall ruleCall) {

		// lookup the matching rule and add its alternatives
		AbstractRule abstractRule = GrammarUtil.calledRule(ruleCall);

		if (null == abstractRule) {
			return Arrays.asList(new Proposal(ruleCall.getName()));
		}
		else if (abstractRule instanceof LexerRule) {

			List<Proposal> proposalList = new ArrayList<Proposal>();

			LexerRule lexerRule = (LexerRule) abstractRule;
			Proposal proposal = new Proposal(lexerRule.getName() + " ");
			proposal.setLabel(new StyledString(lexerRule.getName(), StyledString.COUNTER_STYLER));
			proposal.setDescription(lexerRule.getBody());
			// add the proposal for the lexerrule
			proposalList.add(proposal);

			if (GrammarConstants.LEXER_RULE_STRING.equalsIgnoreCase(abstractRule.getName())) {
				proposal.setText("\"" + abstractRule.getName() + "\" ");
			}
			else if (GrammarConstants.LEXER_RULE_INT.equalsIgnoreCase(abstractRule.getName())) {
				proposal.setText("0 ");
			}
			else if (GrammarConstants.LEXER_RULE_ID.equalsIgnoreCase(abstractRule.getName())) {

				Set<AbstractNode> nodesByGrammarElement = ParseTreeUtil.getNodesByGrammarElement(rootNode,
						RuleCall.class);

				for (AbstractNode abstractNode : nodesByGrammarElement) {

					if (GrammarConstants.LEXER_RULE_ID.equalsIgnoreCase(((RuleCall) abstractNode.getGrammarElement())
							.getName())) {

						String identifier = ((LeafNode) abstractNode).getText();
						proposal = new Proposal(identifier + " ");
						proposal.setDescription(abstractNode.getParent().getElement().eClass().getName() + "::"
								+ identifier);
						proposalList.add(proposal);
					}
				}
			}

			return proposalList;

		}
		else {
			return toProposalList(rootNode, ((ParserRule) abstractRule).getAlternatives());
		}
	}

	private final List<Proposal> toProposalList(AbstractNode rootNode, Group group) {

		// add all optional items in this group
		List<Proposal> proposals = new ArrayList<Proposal>();

		Iterator<AbstractElement> iterator = group.getAbstractTokens().iterator();
		boolean includeNext = true;

		while (iterator.hasNext() && includeNext) {
			AbstractElement abstractElement = iterator.next();
			proposals.addAll(toProposalList(rootNode, abstractElement));
			includeNext = GrammarUtil.isOptionalCardinality(abstractElement);
		}

		return proposals;
	}

	@Override
	public ICompletionContext computeContext(IEditorModel model, ITextViewer viewer, int offset) {
		ReferenceCompletionContext completionContext = null;

		// required parsetree available?
		if (model.getParseTreeRootNode(true) != null) {

			// ParseTreeUtil.dumpNode(model.getParseTreeRootNode());

			// get the last COMPLETE node element (node with associated grammar
			// element)
			AbstractNode lastCompleteNode = ParseTreeUtil.getLastCompleteNodeByOffset(model.getParseTreeRootNode(),
					offset);
			// get node at the CURRENT cursor position (node with or without
			// grammar element)
			LeafNode currentLeafNode = (LeafNode) ParseTreeUtil.getCurrentNodeByOffset(model.getParseTreeRootNode(),
					offset);
			// get associated grammar element
			AbstractElement abstractElement = ParseTreeUtil.getGrammarElementFromNode(lastCompleteNode);

			TemplateContextType contextType = new TemplateContextType(languageDescriptor.getId() + ".rootContext");

			// put information in context object which will be sent around
			completionContext = new ReferenceCompletionContext(model, new Region(offset, 1), viewer, contextType,
					lastCompleteNode, currentLeafNode, abstractElement);
		}
		return completionContext;
	}

	@Override
	public List<ICompletionProposal> getProposals(ICompletionContext context) {
		ReferenceCompletionContext referenceCompletionContext = (ReferenceCompletionContext) context;
		AbstractNode lastCompleteNode = referenceCompletionContext.getLastCompleteNode();
		AbstractElement abstractElement = referenceCompletionContext.getAbstractElement();
		IEditorModel model = referenceCompletionContext.getEditorModel();
		LeafNode currentLeafNode = referenceCompletionContext.getCurrentLeafNode();
		int offset = referenceCompletionContext.getOffset();

		List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();

		// add proposal starting at the given grammar element
		Set<AbstractElement> proposalElementSet = getProposalElements(lastCompleteNode, abstractElement);

		// convert proposed elements to proposals
		for (AbstractElement proposedElement : proposalElementSet) {

			List<Proposal> proposalList = toProposalList(model.getParseTreeRootNode(), proposedElement);

			for (Proposal proposal : proposalList) {

				// filter proposals
				if (currentLeafNode != null && !"".equals(currentLeafNode.getText().trim())
						&& (currentLeafNode.isHidden())) {
					if (proposal.getText().startsWith(currentLeafNode.getText())) {
						proposal.setText(proposal.getText().replaceFirst(currentLeafNode.getText(), ""));
						completionProposalList.add(new XtextCompletionProposal(proposal, offset));
					}
				}
				else {
					completionProposalList.add(new XtextCompletionProposal(proposal, offset));
				}
			}

		}

		return completionProposalList;
	}

	@Override
	protected void registerContextTypes(ContributionContextTypeRegistry registry) {
		registry.addContextType(languageDescriptor.getId() + ".rootContext");
	}

}