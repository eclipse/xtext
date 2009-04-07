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
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.IScopedElement;
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
	protected static final String LEXER_RULE_INT = "INT";
	protected static final String LEXER_RULE_STRING = "STRING";
	// logger available to subclasses
	protected final static Logger logger = Logger.getLogger(IProposalProvider.class);
	@Inject
	protected IScopeProvider scopeProvider;
	@Inject(optional=true)
	protected AdapterFactory adapterFactory;
	//  @Inject(optional=true) does not work due to some plugin visibility quirks
	protected AdapterFactoryLabelProvider adapterFactoryLabelProvider;
	protected JavaReflectiveMethodInvoker methodInvoker;
	
	protected AbstractJavaProposalProvider() {
		this.methodInvoker = new JavaReflectiveMethodInvoker(this);
	}
	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeKeyword(Keyword,
	 *      IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeKeyword(Keyword keyword,
			IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKeyword '" + keyword.getValue()+ "' for model '" + contentAssistContext.getModel()
				+ "' and prefix '"+ contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections.singletonList(createCompletionProposal(keyword,keyword.getValue(), contentAssistContext));
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeRuleCall(RuleCall,
	 *      IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeRuleCall(
			RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRuleCall '"+ ruleCall.getRule().getName()+ "' cardinality '"
				+ ruleCall.getCardinality()+ "' for model '"+ contentAssistContext.getModel()
				+ "' and prefix '"+ contentAssistContext.getMatchString().trim().trim() + "'");
		}
		AbstractRule calledRule = ruleCall.getRule();
		if (calledRule instanceof TerminalRule) {
			return completeTerminalRuleRuleCall((TerminalRule) calledRule, ruleCall,contentAssistContext);
		} else if (calledRule.getType() != null) {
			TypeRef typeRef = calledRule.getType();
			return invokeMethod("complete"+ Strings.toFirstUpper(typeRef.getMetamodel().getAlias()) + "_"
							+ Strings.toFirstUpper(typeRef.getClassifier().getName()),
							Arrays.<Class<?>> asList(EObject.class, RuleCall.class,contentAssistContext.getModel() == null ? 
							EObject.class : contentAssistContext.getModel().getClass(),
							IContentAssistContext.class), Arrays.asList(
									contentAssistContext.getModel(),ruleCall,contentAssistContext));
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
		return invokeMethod("complete"+ Strings.toFirstUpper(parserRule.getName()) + "_"+ 
					Strings.toFirstUpper(assignment.getFeature()), Arrays.<Class<?>> asList(EObject.class, Assignment.class,
						IContentAssistContext.class), Arrays.asList(contentAssistContext.getModel(), assignment,contentAssistContext));
	}


	/**
	 * @see #createCompletionProposal(AbstractElement, String, IContentAssistContext, Image)
	 */
	protected ICompletionProposal createCompletionProposal(AbstractElement abstractElement, String displayString,
			IContentAssistContext contentAssistContext) {
		return createCompletionProposal(abstractElement, displayString,contentAssistContext,getAdapterFactoryLabelProvider().getImage(abstractElement));
	}

	/**
	 * @param abstractElement the {@link AbstractElement} which is used to create the proposals
	 * @param displayString the string that is already entered by the user prior to requesting content assist
	 * @param contentAssistContext the commonly used set of attributes related to the current content assist request
	 * @param image the {@link Image} for the {@link ICompletionProposal}
	 * @return a new <code>XtextCompletionProposal</code> for the given text and offset.
	 */
	protected ICompletionProposal createCompletionProposal(AbstractElement abstractElement, String displayString,
			IContentAssistContext contentAssistContext, Image image) {
		return new XtextCompletionProposal(abstractElement, displayString,contentAssistContext,image);
	}
	
	@SuppressWarnings("unchecked")
	protected List<? extends ICompletionProposal> invokeMethod(String methodName, List<Class<?>> parameterTypes,
			List<?> parameterValues) {
		return (List<? extends ICompletionProposal>) methodInvoker.invoke(methodName, parameterTypes, parameterValues);
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
	 * @param terminalRule the 'called' {@link TerminalRule} instance
	 * @param ruleCall the ruleCall for the provided lexerRule
	 * @param offset an offset within the document for which completions should be computed
	 * @return a computed list of <code>ICompletionProposal</code> for the given
	 *         <code>LexerRule</code>
	 */
	protected List<? extends ICompletionProposal> completeTerminalRuleRuleCall(
			TerminalRule terminalRule, RuleCall ruleCall,
			IContentAssistContext contentAssistContext) {
		return Collections.emptyList();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#filter(java.util.List, org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> filter(List<ICompletionProposal> completionProposalList,
			IContentAssistContext contentAssistContext) {
		return ProposalFilterSorterUtil.filter(completionProposalList,contentAssistContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#sort(java.util.List)
	 */
	public List<? extends ICompletionProposal> sort(List<ICompletionProposal> completionProposalList) {
		return ProposalFilterSorterUtil.sort(completionProposalList);
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
			CrossReference crossReference,IContentAssistContext contentAssistContext) {
		List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();
		if (null!= scopeProvider) {
			ParserRule containingParserRule = GrammarUtil.containingParserRule(crossReference);
			if (!GrammarUtil.isDatatypeRule(containingParserRule)) {
				EClass eClass = (EClass) containingParserRule.getType().getClassifier();
				EReference ref = GrammarUtil.getReference(crossReference,eClass);
				String trimmedPrefix = contentAssistContext.getMatchString().trim();
				IScope scope = scopeProvider.getScope(contentAssistContext.getModel(), ref);
				Iterable<IScopedElement> candidates = scope.getAllContents();
				for (IScopedElement candidate : candidates) {
					if (null != candidate.name() && isCandidateMatchingPrefix(contentAssistContext
									.getModel(), ref, candidate, trimmedPrefix)) {
						completionProposalList.add(createCompletionProposal(crossReference, candidate.name(),
								contentAssistContext,getAdapterFactoryLabelProvider().getImage(candidate.element())));
					}
				}
			}
		}

		return completionProposalList;
	}

	/**
	 * @return an adapter factory that yield adapters that implement the various item label provider interfaces.
	 * @see AdapterFactory
	 */
	protected AdapterFactory getAdapterFactory() {
		if (null == this.adapterFactory) {
			ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			composedAdapterFactory
					.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			this.adapterFactory = composedAdapterFactory;
		}
		return this.adapterFactory;
	}

	/**
	 * @return an instance that wraps the given {@link #getAdapterFactory()} to delegates its JFace provider 
	 * 	interfaces to corresponding adapter-implemented item provider interfaces
	 * @see AdapterFactoryLabelProvider
	 */
	protected AdapterFactoryLabelProvider getAdapterFactoryLabelProvider() {
		if (null == this.adapterFactoryLabelProvider) {
			this.adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
					getAdapterFactory());
		}
		return this.adapterFactoryLabelProvider;
	}
	
	protected boolean isCandidateMatchingPrefix(EObject model, EReference ref,
			IScopedElement candidate, String prefix) {
		if (candidate.name() == null)
			throw new IllegalArgumentException("unnamed candidates may not be proposed");
		return candidate.name().regionMatches(true, 0, prefix, 0,prefix.length());
	}
}
