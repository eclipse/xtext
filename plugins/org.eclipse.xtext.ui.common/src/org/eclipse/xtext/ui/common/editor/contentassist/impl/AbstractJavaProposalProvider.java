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
import java.util.List;

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
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractJavaProposalProvider implements IProposalProvider {

	// constants
	// protected static final String LEXER_RULE_ID = "ID";
	protected static final String LEXER_RULE_INT = "INT";
	protected static final String LEXER_RULE_STRING = "STRING";

	// logger available to subclasses
	protected final static Logger logger = Logger
			.getLogger(IProposalProvider.class);

	@Inject
	protected IScopeProvider scopeProvider;

	protected JavaReflectiveMethodInvoker invoker;

	protected AbstractJavaProposalProvider() {
		invoker = new JavaReflectiveMethodInvoker(this);
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeKeyword(Keyword,
	 *      IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeKeyword(Keyword keyword,
			IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKeyword '" + keyword.getValue()
					+ "' for model '" + contentAssistContext.getModel()
					+ "' and prefix '"
					+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(keyword,
				keyword.getValue(), contentAssistContext));
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeRuleCall(RuleCall,
	 *      IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeRuleCall(
			RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger
					.debug("completeRuleCall '"
							+ ruleCall.getRule().getName()
							+ "' cardinality '"
							+ ruleCall.getCardinality()
							+ "' for model '"
							+ contentAssistContext.getModel()
							+ "' and prefix '"
							+ contentAssistContext.getMatchString().trim()
									.trim() + "'");
		}

		AbstractRule calledRule = ruleCall.getRule();

		if (calledRule instanceof LexerRule) {
			return completeLexerRuleRuleCall((LexerRule) calledRule, ruleCall,
					contentAssistContext);
		} else if (calledRule.getType() != null) {

			TypeRef typeRef = calledRule.getType();

			return invokeMethod(
					"complete"
							+ Strings.toFirstUpper(typeRef.getMetamodel()
									.getAlias()) + "_"
							+ Strings.toFirstUpper(typeRef.getType().getName()),
					Arrays
							.<Class<?>> asList(
									RuleCall.class,
									contentAssistContext.getModel() == null ? EObject.class
											: contentAssistContext.getModel()
													.getClass(),
									IContentAssistContext.class), Arrays
							.asList(ruleCall, contentAssistContext.getModel(),
									contentAssistContext));
		}
		return Collections.emptyList();
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeAssignment(Assignment,
	 *      IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeAssignment(
			Assignment assignment, IContentAssistContext contentAssistContext) {
		ParserRule parserRule = GrammarUtil.containingParserRule(assignment);
		// TODO : Better call completeRuleCall ?
		return invokeMethod("complete"
				+ Strings.toFirstUpper(parserRule.getName()) + "_"
				+ Strings.toFirstUpper(assignment.getFeature()), Arrays
				.<Class<?>> asList(Assignment.class,
						IContentAssistContext.class), Arrays.asList(assignment,
				contentAssistContext));
	}

	/**
	 * @return a new <code>XtextCompletionProposal</code> for the given text and
	 *         offset.
	 */
	protected ICompletionProposal createCompletionProposal(
			AbstractElement abstractElement, String displayString,
			IContentAssistContext contentAssistContext) {
		return new XtextCompletionProposal(abstractElement, displayString,
				contentAssistContext);
	}

	@SuppressWarnings("unchecked")
	protected List<? extends ICompletionProposal> invokeMethod(
			String methodName, List<Class<?>> parameterTypes,
			List<?> parameterValues) {
		try {
			return (List<? extends ICompletionProposal>) invoker.invoke(
					methodName, parameterTypes, parameterValues);
		} catch (NullPointerException exc) {
			return null;
		}
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#getTemplateContextType(Keyword,
	 *      IContentAssistContext)
	 */
	public TemplateContextType getTemplateContextType(Keyword keyword,
			IContentAssistContext contentAssistContext) {
		return null;
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#getTemplateContextType(RuleCall,
	 *      IContentAssistContext)
	 */
	public TemplateContextType getTemplateContextType(RuleCall ruleCall,
			IContentAssistContext contentAssistContext) {
		return null;
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#getTemplates(String)
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
	protected List<? extends ICompletionProposal> completeLexerRuleRuleCall(
			LexerRule lexerRule, RuleCall ruleCall,
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
			List<? extends ICompletionProposal> completionProposalList,
			IContentAssistContext contentAssistContext) {
		return ProposalFilterSorterUtil.sortAndFilter(completionProposalList,
				contentAssistContext);
	}

	/**
	 * Concrete subclasses can override this to provide custom lookup behavior
	 * for <code>CrossReference</code>. This implementation delegates to the
	 * injected LinkingService
	 * 
	 * @return a list of <code>ICompletionProposal</code> matching the given
	 *         assignment
	 */
	protected List<? extends ICompletionProposal> lookupCrossReference(
			CrossReference crossReference,
			IContentAssistContext contentAssistContext) {

		List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();

		if (scopeProvider != null) {
			ParserRule containingParserRule = GrammarUtil
					.containingParserRule(crossReference);
			if (!GrammarUtil.isDatatypeRule(containingParserRule)) {
				final EClass eClass = (EClass) containingParserRule.getType()
						.getType();
				final EReference ref = GrammarUtil.getReference(crossReference,
						eClass);
				final String trimmedPrefix = contentAssistContext
						.getMatchString().trim();
				final Iterable<IScopedElement> candidates = scopeProvider
						.getScope(contentAssistContext.getModel(), ref)
						.getAllContents();
				for (IScopedElement candidate : candidates) {
					if (candidate.name() != null
							&& isCandidateMatchingPrefix(contentAssistContext
									.getModel(), ref, candidate, trimmedPrefix)) {
						completionProposalList.add(createCompletionProposal(
								crossReference, candidate.name(),
								contentAssistContext));
					}
				}
			}
		}

		return completionProposalList;
	}

	protected boolean isCandidateMatchingPrefix(EObject model, EReference ref,
			IScopedElement candidate, String prefix) {
		if (candidate.name() == null)
			throw new IllegalArgumentException(
					"unnamed candidates may not be proposed");
		return candidate.name().regionMatches(true, 0, prefix, 0,
				prefix.length());
	}
}
