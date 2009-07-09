/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.IScopedElement;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;
import org.eclipse.xtext.util.PolymorphicDispatcher.NullErrorHandler;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractJavaBasedContentProposalProvider extends AbstractContentProposalProvider {
	
	protected class DefaultProposalCreator implements Function<IScopedElement, ICompletionProposal> {
		private final ContentAssistContext contentAssistContext;
		private final String ruleName;

		protected DefaultProposalCreator(ContentAssistContext contentAssistContext, String ruleName) {
			this.contentAssistContext = contentAssistContext;
			this.ruleName = ruleName;
		}

		public ICompletionProposal apply(IScopedElement candidate) {
			ICompletionProposal result = null;
			if (ruleName != null) {
				String proposal = getValueConverter().toString(getDisplayString(candidate), ruleName);
				result = createCompletionProposal(candidate.element(), proposal, getDisplayString(candidate), contentAssistContext);
			} else {
				result = createCompletionProposal(candidate, contentAssistContext);
			}
			adjustPriority(result, contentAssistContext.getPrefix(), getCrossReferencePriority());			
			return result;
		}

	}

	private final static Logger logger = Logger.getLogger(AbstractJavaBasedContentProposalProvider.class);
	
	@Inject
	private IScopeProvider scopeProvider;
	
	private final Map<String, PolymorphicDispatcher<Void>> dispatchers;
	
	protected AbstractJavaBasedContentProposalProvider() {
		dispatchers = new HashMap<String, PolymorphicDispatcher<Void>>();
	}
	
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKeyword '" + keyword.getValue()+ "' for model '" + contentAssistContext.getCurrentModel()
				+ "' and prefix '"+ contentAssistContext.getPrefix() + "'");
		}
		ICompletionProposal proposal = createCompletionProposal(keyword, keyword.getValue(), contentAssistContext);
		adjustPriority(proposal, contentAssistContext.getPrefix(), getKeywordPriority());
		acceptor.accept(proposal);
	}

	public void adjustPriority(ICompletionProposal proposal, String prefix, int priority) {
		if (proposal == null || !(proposal instanceof ConfigurableCompletionProposal))
			return;
		ConfigurableCompletionProposal castedProposal = (ConfigurableCompletionProposal) proposal;
		if (castedProposal.getPriority() != getDefaultPriority())
			return;
		int adjustedPriority = priority;
		if (!Strings.isEmpty(prefix)) {
			if (castedProposal.getReplacementString().equals(prefix))
				adjustedPriority = (int) (adjustedPriority * getSameTextMultiplier());
			else
				adjustedPriority = adjustedPriority * getProposalWithPrefixMultiplier();
		}
		castedProposal.setPriority(adjustedPriority);
	}

	@Override
	public void completeRuleCall(RuleCall ruleCall, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRuleCall '"+ ruleCall.getRule().getName()+ "' cardinality '"
				+ ruleCall.getCardinality()+ "' for model '"+ contentAssistContext.getCurrentModel()
				+ "' and prefix '"+ contentAssistContext.getPrefix() + "'");
		}
		AbstractRule calledRule = ruleCall.getRule();
		String methodName = "complete_"+ calledRule.getName();
		invokeMethod(methodName, acceptor, contentAssistContext.getCurrentModel(), ruleCall, contentAssistContext);
	}

	@Override
	public void completeAssignment(Assignment assignment, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		ParserRule parserRule = GrammarUtil.containingParserRule(assignment);
		String methodName = "complete"+ Strings.toFirstUpper(parserRule.getName()) + "_"+
			Strings.toFirstUpper(assignment.getFeature());
		invokeMethod(methodName, acceptor, contentAssistContext.getCurrentModel(), assignment, contentAssistContext);
	}

	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(crossReference, contentAssistContext, acceptor, Predicates.<IScopedElement>alwaysTrue());
	}
	
	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor, Function<IScopedElement, ICompletionProposal> proposalFactory) {
		lookupCrossReference(crossReference, contentAssistContext, acceptor, Predicates.<IScopedElement>alwaysTrue(), proposalFactory);
	}
	
	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor, Predicate<IScopedElement> filter) {
		ParserRule containingParserRule = GrammarUtil.containingParserRule(crossReference);
		if (!GrammarUtil.isDatatypeRule(containingParserRule)) {
			EClass eClass = (EClass) containingParserRule.getType().getClassifier();
			EReference ref = GrammarUtil.getReference(crossReference, eClass);
			lookupCrossReference(crossReference, ref, contentAssistContext,	acceptor, filter);
		}
	}
	
	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor, Predicate<IScopedElement> filter, Function<IScopedElement, ICompletionProposal> proposalFactory) {
		ParserRule containingParserRule = GrammarUtil.containingParserRule(crossReference);
		if (!GrammarUtil.isDatatypeRule(containingParserRule)) {
			EClass eClass = (EClass) containingParserRule.getType().getClassifier();
			EReference ref = GrammarUtil.getReference(crossReference, eClass);
			lookupCrossReference(crossReference, ref, acceptor, filter, proposalFactory);
		}
	}

	protected void lookupCrossReference(CrossReference crossReference,
			EReference reference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor, Predicate<IScopedElement> filter) {
		String ruleName = null;
		if (crossReference.getTerminal() instanceof RuleCall) {
			ruleName = ((RuleCall) crossReference.getTerminal()).getRule().getName();
		}
		lookupCrossReference(contentAssistContext.getCurrentModel(), reference, acceptor, filter,
				getProposalFactory(ruleName, contentAssistContext));
	}
	
	protected void lookupCrossReference(EObject model, EReference reference, ICompletionProposalAcceptor acceptor,
			Predicate<IScopedElement> filter, Function<IScopedElement, ICompletionProposal> proposalFactory) {
		IScope scope = getScopeProvider().getScope(model, reference);
		Iterable<IScopedElement> candidates = scope.getAllContents();
		for (IScopedElement candidate: candidates) {
			if (!acceptor.canAcceptMoreProposals())
				return;
			if (filter.apply(candidate)) {
				acceptor.accept(proposalFactory.apply(candidate));
			}
		}
	}
	
	protected Function<IScopedElement, ICompletionProposal> getProposalFactory(String ruleName, ContentAssistContext contentAssistContext) {
		return new DefaultProposalCreator(contentAssistContext, ruleName);
	}
	
	protected void invokeMethod(String methodName, ICompletionProposalAcceptor acceptor, Object... params) {
		PolymorphicDispatcher<Void> dispatcher = dispatchers.get(methodName);
		if (dispatcher == null) {
			ErrorHandler<Void> errorHandler = NullErrorHandler.get();
			dispatcher = new PolymorphicDispatcher<Void>(methodName, params.length + 1, params.length + 1, Collections.singletonList(this), errorHandler) {
				@Override
				public Class<?> getDefaultClass(int paramIndex) {
					if (paramIndex == 0)
						return EObject.class;
					return super.getDefaultClass(paramIndex);
				}
			};
			dispatchers.put(methodName, dispatcher);
		}
		Object[] paramAsArray = new Object[params.length + 1];
		System.arraycopy(params, 0, paramAsArray, 0, params.length);
		paramAsArray[params.length] = acceptor;
		dispatcher.invoke(paramAsArray);
	}

	public void setScopeProvider(IScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

}
