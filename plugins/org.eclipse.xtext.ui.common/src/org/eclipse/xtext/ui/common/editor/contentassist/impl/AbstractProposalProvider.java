/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.util.Strings;

/**
 * Super class for <code>IProposalProvider</code> implementations.
 * 
 * Delegates calls to {@link #completeRuleCall(RuleCall, IContentAssistContext)}
 * and {@link #completeAssignment(Assignment, IContentAssistContext)} to grammar
 * specific methods for assignments using reflection. The signature of such
 * methods invoked reflectively follows the following pattern:
 * 
 * public List<ICompletionProposal> complete[Typename][featureName](Assignment
 * ele, EObject model, String prefix)
 * 
 * <b>Example</b> Given the following grammar : <code>
 *  RuleA returns MyType :
 *  	"myType" name=ID;
 *  </code>
 * 
 * One could provide the following method in an implementation of this
 * interface: <code>
 * 	public List<ICompletionProposal> completeMyTypeName(Assignment ele, EObject model, String prefix, IDocument doc) {...}
 *  </code> Note that if you have generated Java classes for your
 * domain model (meta model) you can alternatively declare the second parameter
 * using a specific type: <code>
 * 	public List<ICompletionProposal> completeMyTypeName(Assignment ele, MyType model, String prefix, IDocument doc) {...}
 *  </code>
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Heiko Behrens
 * @author Jan K&ouml;hnlein
 * 
 * @see IProposalProvider
 */
public abstract class AbstractProposalProvider implements IProposalProvider {
	// constants
	// protected static final String LEXER_RULE_ID = "ID";
	protected static final String LEXER_RULE_INT = "INT";
	protected static final String LEXER_RULE_STRING = "STRING";

	protected static final Comparator<ICompletionProposal> PROPOSAL_COMPARATOR = new ProposalComparator();
	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());

	@Inject
	protected IScopeProvider scopeProvider;

	@Inject
	protected IContentAssistInvocationHandler invocationHandler;

	public List<? extends ICompletionProposal> completeKeyword(Keyword keyword,
			IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKeyword '" + keyword.getValue() + "' for model '" + contentAssistContext.getModel()
					+ "' and prefix '" + contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(keyword, keyword.getValue(), contentAssistContext));
	}

	public List<? extends ICompletionProposal> completeRuleCall(RuleCall ruleCall,
			IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRuleCall '" + ruleCall.getRule().getName() + "' cardinality '"
					+ ruleCall.getCardinality() + "' for model '" + contentAssistContext.getModel() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim().trim() + "'");
		}

		AbstractRule calledRule = ruleCall.getRule();

		if (calledRule instanceof LexerRule) {
			return completeLexerRuleRuleCall((LexerRule) calledRule, ruleCall, contentAssistContext);
		}
		else if (calledRule.getType() != null) {

			TypeRef typeRef = calledRule.getType();

			return invokeMethod("complete" + firstLetterCapitalized(typeRef.getMetamodel().getAlias())
					+ firstLetterCapitalized(typeRef.getType().getName()), Arrays.<Class<?>> asList(RuleCall.class,
					contentAssistContext.getModel() == null ? EObject.class : contentAssistContext.getModel()
							.getClass(), IContentAssistContext.class), Arrays.asList(ruleCall, contentAssistContext
					.getModel(), contentAssistContext));
		}
		return Collections.emptyList();
	}

	public List<? extends ICompletionProposal> completeAssignment(Assignment assignment,
			IContentAssistContext contentAssistContext) {
		ParserRule parserRule = GrammarUtil.containingParserRule(assignment);
		// TODO : Better call completeRuleCall ?
		return invokeMethod("complete" + firstLetterCapitalized(parserRule.getName())
				+ firstLetterCapitalized(assignment.getFeature()), Arrays.<Class<?>> asList(Assignment.class,
				IContentAssistContext.class), Arrays.asList(assignment, contentAssistContext));
	}

	protected List<? extends ICompletionProposal> invokeMethod(String methodName, List<Class<?>> parameterTypes,
			List<?> parameterValues) {
		return invocationHandler.invoke(methodName, parameterTypes, parameterValues);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#
	 * getTemplateContextType(org.eclipse.xtext.Keyword,
	 * org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext)
	 */
	public TemplateContextType getTemplateContextType(Keyword keyword, IContentAssistContext contentAssistContext) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#
	 * getTemplateContextType(org.eclipse.xtext.RuleCall,
	 * org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext)
	 */
	public TemplateContextType getTemplateContextType(RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#
	 * getTemplates(java.lang.String)
	 */
	public Template[] getTemplates(String contextTypeId) {
		return new Template[] {};
	}

	/**
	 * Concrete subclasses can override this to provide a more meaningful and
	 * sophisticated behavior whenever a list of ICompletionProposal's should be
	 * computed for simple <code>LexerRule</code> call's.
	 * 
	 * This implementation returns an empty list by default.
	 * 
	 * @param lexerRule
	 *            the 'called' LexerRule instance
	 * @param ruleCall
	 *            the ruleCall for the provided lexerRule
	 * @param offset
	 *            an offset within the document for which completions should be
	 *            computed
	 * @return a computed list of <code>ICompletionProposal</code> for the given
	 *         <code>LexerRule</code>
	 */
	protected List<? extends ICompletionProposal> completeLexerRuleRuleCall(LexerRule lexerRule, RuleCall ruleCall,
			IContentAssistContext contentAssistContext) {
		return Collections.emptyList();
	}

	/**
	 * @return the id of the plug-in containing the image files;
	 *         <code>null </code> is returned if the plug-in does not exist
	 */
	protected abstract String getPluginId();

	/**
	 * Returns the the relative path of the default image file, relative to the
	 * root of the containing plug-in; the path must be legal The image would
	 * typically be shown to the left of the <code>ICompletionProposal</code>
	 * display string.
	 * 
	 * @return the image file path of the default image to be shown or
	 *         <code>null</code> if no image is desired
	 * @see #getPluginId()
	 */
	protected abstract String getDefaultImageFilePath();

	/**
	 * Concrete subclasses can override this to provide custom lookup behavior
	 * for <code>CrossReference</code>. This implementation delegates to the
	 * injected LinkingService
	 * 
	 * @return a list of <code>ICompletionProposal</code> matching the given
	 *         assignment
	 */
	protected List<? extends ICompletionProposal> lookupCrossReference(CrossReference crossReference,
			IContentAssistContext contentAssistContext) {

		List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();

		if (scopeProvider != null) {
			ParserRule containingParserRule = GrammarUtil.containingParserRule(crossReference);
			if (!GrammarUtil.isDatatypeRule(containingParserRule)) {
				final EClass eClass = (EClass) containingParserRule.getType().getType();
				final EReference ref = GrammarUtil.getReference(crossReference, eClass);
				final String trimmedPrefix = contentAssistContext.getMatchString().trim();
				final Iterable<IScopedElement> candidates = scopeProvider
						.getScope(contentAssistContext.getModel(), ref).getAllContents();
				for (IScopedElement candidate : candidates) {
					if (candidate.name() != null
							&& isCandidateMatchingPrefix(contentAssistContext.getModel(), ref, candidate, trimmedPrefix)) {
						completionProposalList.add(createCompletionProposal(crossReference, candidate.name(),
								contentAssistContext));
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
	 * @return a new <code>XtextCompletionProposal</code> for the given text and
	 *         offset.
	 */
	protected ICompletionProposal createCompletionProposal(AbstractElement abstractElement, String displayString,
			IContentAssistContext contentAssistContext) {
		return new XtextCompletionProposal(abstractElement, displayString, contentAssistContext);
	}

	/**
	 * Concrete subclasses can override this for custom sort and filter
	 * behavior. Called right after all completion proposals have been
	 * collected.
	 * 
	 * The default behavior of this implementation is to filter duplicates and
	 * to trim matching <code>ICompletionProposal#displayString</code> with
	 * matching prefix values.
	 * 
	 * @see #sortAndFilter(List, EObject, String, IDocument, int, AbstractNode,
	 *      LeafNode)
	 */
	public List<? extends ICompletionProposal> sortAndFilter(
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
	 * The default behavior of this method delegates to
	 * {@link XtextCompletionProposal#matches(String)} to test if the given
	 * prefix string matches or not.
	 * 
	 * @param completionProposal
	 *            contains information used to present the proposed completion
	 *            to the user
	 * @return true or false whether the given prefix matches the text of this
	 *         completion proposal
	 */
	protected boolean isFiltered(ICompletionProposal completionProposal) {
		if (completionProposal instanceof XtextCompletionProposal) {
			XtextCompletionProposal xtextCompletionProposal = (XtextCompletionProposal) completionProposal;
			return !xtextCompletionProposal.matches();
		}
		return false;
	}

	/**
	 * @param text
	 *            to apply
	 * @return the provided string with the first letter capitalized
	 */
	protected final String firstLetterCapitalized(String text) {
		return Strings.toFirstUpper(text);
	}

	/**
	 * Simple {@link Comparator} implementation to compare
	 * <code>ICompletionProposal</code> by display strings'.
	 * 
	 */
	private static final class ProposalComparator implements Comparator<ICompletionProposal> {
		public int compare(ICompletionProposal o1, ICompletionProposal o2) {
			return o1.getDisplayString().compareTo(o2.getDisplayString());
		}
	}

}
