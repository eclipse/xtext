/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.common.editor.codecompletion.impl.XtextCompletionProposal;
import org.eclipse.xtext.util.Strings;

/**
 * Convenient super class for <code>IProposalProvider</code> implementations.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Heiko Behrens
 * 
 * @see IProposalProvider
 */
public abstract class AbstractProposalProvider implements IProposalProvider {
	// constants
	protected static final String LEXER_RULE_ID = "ID";
	protected static final String LEXER_RULE_INT = "INT";
	protected static final String LEXER_RULE_STRING = "STRING";
	
	protected static final Comparator<ICompletionProposal> PROPOSAL_COMPARATOR= new ProposalComparator();
	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	@Inject
	protected ILinkingCandidatesService linkingCandidatesService;

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#completeKeyword(org.eclipse.xtext.Keyword, org.eclipse.xtext.ui.common.editor.codecompletion.IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeKeyword(Keyword keyword, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKeyword '" + keyword.getValue() + "' for model '" + contentAssistContext.getModel() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		String text = keyword.getValue().length() == 1 ? keyword.getValue() : keyword.getValue() + " ";
		return Collections.singletonList(createCompletionProposal(keyword, text, contentAssistContext));
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#completeRuleCall(org.eclipse.xtext.RuleCall, org.eclipse.xtext.ui.common.editor.codecompletion.IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeRuleCall(RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRuleCall '" + ruleCall.getRule().getName() + "' cardinality '" + ruleCall.getCardinality()
					+ "' for model '" + contentAssistContext.getModel() + "' and prefix '" + contentAssistContext.getMatchString().trim().trim() + "'");
		}

		AbstractRule calledRule = ruleCall.getRule();

		if (calledRule instanceof LexerRule) {
			return doCompleteLexerRuleRuleCall((LexerRule) calledRule, ruleCall, contentAssistContext);
		}

		return Collections.emptyList();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#getTemplateContextType(org.eclipse.xtext.Keyword, org.eclipse.xtext.ui.common.editor.codecompletion.IContentAssistContext)
	 */
	public TemplateContextType getTemplateContextType(Keyword keyword, IContentAssistContext contentAssistContext) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#getTemplateContextType(org.eclipse.xtext.RuleCall, org.eclipse.xtext.ui.common.editor.codecompletion.IContentAssistContext)
	 */
	public TemplateContextType getTemplateContextType(RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#getTemplates(java.lang.String)
	 */
	public Template[] getTemplates(String contextTypeId) {
		return new Template[]{};
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider#sortAndFilter(java.util.List, org.eclipse.xtext.ui.common.editor.codecompletion.IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> sortAndFilter(
			List<? extends ICompletionProposal> completionProposalList, IContentAssistContext contentAssistContext) {
		return doSortAndFilter(completionProposalList,contentAssistContext);
	}

	/**
	 * Concrete subclasses can override this to provide a more meaningful and sophisticated behaviour whenever a list of
	 * ICompletionProposal's should be computed for simple <code>LexerRule</code> call's.
	 * 
	 * This implementation returns one <code>ICompletionProposal</code> with a displayString composed of the name of the
	 * containing rule plus the featurename of an optional assignment and at the end the name of the given LexerRule
	 * (e.i. ParserRuleName+AssignmentFeatureName+LexerRuleName) or {@link #getDefaultIntegerValue()} if its <i>INT</i>
	 * based LexerRule.
	 * 
	 * @param lexerRule the 'called' LexerRule instance
	 * @param ruleCall  the ruleCall for the provided lexerRule
	 * @param offset an offset within the document for which completions should be computed
	 * @return a computed list of <code>ICompletionProposal</code> for the given <code>LexerRule</code>
	 */
	protected List<? extends ICompletionProposal> doCompleteLexerRuleRuleCall(LexerRule lexerRule, RuleCall ruleCall,
			IContentAssistContext contentAssistContext) {
		ParserRule containingParserRule = GrammarUtil.containingParserRule(ruleCall);
		Assignment containingAssignment = GrammarUtil.containingAssignment(ruleCall);

		String defaultDisplayString = containingParserRule.getName()
				+ (null != containingAssignment ? firstLetterCapitalized(containingAssignment.getFeature()) : "")
				+ lexerRule.getName();

		if (LEXER_RULE_INT.equalsIgnoreCase(lexerRule.getName())) {
			defaultDisplayString = String.valueOf(getDefaultIntegerValue());
		}
		else if (LEXER_RULE_STRING.equalsIgnoreCase(lexerRule.getName())) {
			defaultDisplayString = "\"" + defaultDisplayString + "\"";
		}

		return Collections.singletonList(createCompletionProposal(containingAssignment, defaultDisplayString, contentAssistContext));
	}

	/**
	 * @return the default integer value for ecore::EInt <code>RuleCall<></code>
	 */
	protected int getDefaultIntegerValue() {
		return 0;
	}

	/**
	 * 
	 * @return the id of the plug-in containing the image files; <code>null </code> is returned if the plug-in does not
	 *         exist
	 */
	protected abstract String getPluginId();

	/**
	 * Returns the the relative path of the default image file, relative to the root of the containing plug-in; the path
	 * must be legal The image would typically be shown to the left of the <code>ICompletionProposal</code> display
	 * string.
	 * 
	 * @return the image file path of the default image to be shown or <code>null</code> if no image is desired
	 * @see #getPluginId()
	 */
	protected abstract String getDefaultImageFilePath();

	/**
	 * Concrete subclasses can override this to provide custom lookup behaviour for <code>CrossReference</code>. This
	 * implementation delegates to the injected LinkingService
	 * 
	 * @return a list of <code>ICompletionProposal</code> matching the given assignment
	 */
	protected List<? extends ICompletionProposal> lookupCrossReference(CrossReference crossReference, IContentAssistContext contentAssistContext) {

		List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();

		if (linkingCandidatesService != null) {
			ParserRule containingParserRule = GrammarUtil.containingParserRule(crossReference);
			if (!GrammarUtil.isDatatypeRule(containingParserRule)) {
				final EClass eClass = (EClass) containingParserRule.getType().getType();
				final EReference ref = GrammarUtil.getReference(crossReference, eClass);
				final String trimmedPrefix = contentAssistContext.getMatchString().trim();
				final Iterable<IScopedElement> candidates = linkingCandidatesService.getLinkingCandidates(contentAssistContext.getModel(), ref);
				for (IScopedElement candidate : candidates) {
					if (candidate.name() != null && isCandidateMatchingPrefix(contentAssistContext.getModel(), ref, candidate, trimmedPrefix)) {
						completionProposalList.add(
								createCompletionProposal(crossReference, candidate.name(), contentAssistContext));
					}
				}	
			}
		}

		return completionProposalList;
	}
	
	protected boolean isCandidateMatchingPrefix(EObject model, EReference ref, IScopedElement candidate, String prefix) {
		if (candidate.name() == null)
			throw new IllegalArgumentException("unnamed candidates may not be proposed");
		return candidate.name().regionMatches(true, 0, prefix, 0, prefix.length());
	}
	
	/**
	 * @return a new <code>XtextCompletionProposal</code> for the given text and offset.
	 */
	protected ICompletionProposal createCompletionProposal(AbstractElement abstractElement, String displayString,IContentAssistContext contentAssistContext) {
		return new XtextCompletionProposal(abstractElement,displayString,contentAssistContext);
	}

	/**
	 * Concrete subclasses can override this for custom sort and filter behavior. Called right after all completion
	 * proposals have been collected.
	 * 
	 * The default behavior of this implementation is to sort duplicates and to trim matching
	 * <code>ICompletionProposal#displayString</code> with matching prefix values.
	 * 
	 * @see #sortAndFilter(List, EObject, String, IDocument, int, AbstractNode, LeafNode)
	 */
	protected List<? extends ICompletionProposal> doSortAndFilter(
			List<? extends ICompletionProposal> completionProposalList, IContentAssistContext contentAssistContext) {

		Map<String, ICompletionProposal> displayString2ICompletionProposalMap = new HashMap<String, ICompletionProposal>();

		for (Iterator<? extends ICompletionProposal> iterator = completionProposalList.iterator(); iterator.hasNext();) {

			ICompletionProposal completionProposal = iterator.next();

			// filter duplicate
			if (!displayString2ICompletionProposalMap.containsKey(completionProposal.getDisplayString())) {

				displayString2ICompletionProposalMap.put(completionProposal.getDisplayString(), completionProposal);

				// filter by prefix 
				if (isFiltered(completionProposal)) {
					if (logger.isDebugEnabled()) {
						logger.debug("filter completionProposal '" + completionProposal + "'");
					}
					iterator.remove();
				}
			}
			else {
				if (logger.isDebugEnabled()) {
					logger.debug("filter duplicate completionProposal '" + completionProposal + "'");
				}
				iterator.remove();
			}
		}

		Collections.sort(completionProposalList, PROPOSAL_COMPARATOR);
		
		return completionProposalList;
	}

	/**
	 * The default behaviour of this method delegates to {@link XtextCompletionProposal#matches(String)} to 
	 * test if the given prefix string matches or not.
	 * 
	 * @param completionProposal contains information used to present the proposed completion to the user
	 * @return true or false whether the given prefix matches the text of this completion proposal
	 */
	protected boolean isFiltered(ICompletionProposal completionProposal) {
		
		if (completionProposal instanceof XtextCompletionProposal) {
		
			XtextCompletionProposal xtextCompletionProposal = (XtextCompletionProposal) completionProposal;
			
			return !xtextCompletionProposal.matches();
		}
		
		return false;
	}

	/**
	 * @param text to apply
	 * @return the provided string with the first letter capitalized
	 */
	protected final String firstLetterCapitalized(String text) {
		return Strings.toFirstUpper(text);
	}
	
	/**
	 * 
	 * Simple {@link Comparator} implementation to compare
	 * <code>ICompletionProposal</code> by disaply strings'.
	 * 
	 */
	private static final class ProposalComparator implements Comparator<ICompletionProposal> {
		public int compare(ICompletionProposal o1, ICompletionProposal o2) {
			return o1.getDisplayString().compareTo(o2.getDisplayString());
		}
	}

}
