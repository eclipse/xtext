/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;
import org.eclipse.xtext.util.PolymorphicDispatcher.WarningErrorHandler;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Christoph Kulla - added support for hover
 */
public abstract class AbstractJavaBasedContentProposalProvider extends AbstractContentProposalProvider {

	private final static Logger log = Logger.getLogger(AbstractJavaBasedContentProposalProvider.class);

	@Inject
	private IEObjectHover hover;
	
	protected class DefaultProposalCreator implements Function<IEObjectDescription, ICompletionProposal> {

		private final ContentAssistContext contentAssistContext;
		private final String ruleName;
		private final IQualifiedNameConverter qualifiedNameConverter;

		/**
		 * @since 2.1
		 */
		public DefaultProposalCreator(ContentAssistContext contentAssistContext, String ruleName,
				IQualifiedNameConverter qualifiedNameConverter) {
			this.contentAssistContext = contentAssistContext;
			this.ruleName = ruleName;
			this.qualifiedNameConverter = qualifiedNameConverter;
		}

		public ICompletionProposal apply(IEObjectDescription candidate) {
			if (candidate == null)
				return null;
			ICompletionProposal result = null;
			String proposal = qualifiedNameConverter.toString(candidate.getName());
			if (ruleName != null) {
				try {
					proposal = getValueConverter().toString(proposal, ruleName);
				} catch (ValueConverterException e) {
					log.debug(e.getMessage(), e);
					return null;
				}
			}
			EObject objectOrProxy = candidate.getEObjectOrProxy();
			StyledString displayString = getStyledDisplayString(candidate);
			Image image = getImage(objectOrProxy);
			result = createCompletionProposal(proposal, displayString, image, contentAssistContext);
			if (result instanceof ConfigurableCompletionProposal) {
				((ConfigurableCompletionProposal) result).setProposalContextResource(contentAssistContext.getResource());
				((ConfigurableCompletionProposal) result).setAdditionalProposalInfo(objectOrProxy);
				((ConfigurableCompletionProposal) result).setHover(hover);
			}
			getPriorityHelper().adjustCrossReferencePriority(result, contentAssistContext.getPrefix());
			return result;
		}

	}

	public static class ReferenceProposalCreator {

		@Inject
		private IScopeProvider scopeProvider;

		public final void lookupCrossReference(EObject model, EReference reference, ICompletionProposalAcceptor acceptor,
				Predicate<IEObjectDescription> filter,
				Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
			if (model != null) {
				IScope scope = getScopeProvider().getScope(model, reference);
				lookupCrossReference(scope, model, reference, acceptor, filter, proposalFactory);
			}
		}
		
		protected Function<IEObjectDescription, ICompletionProposal> getWrappedFactory(
				EObject model, EReference reference,
				Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
			return proposalFactory;
		}

		public void lookupCrossReference(IScope scope, EObject model, EReference reference,
				ICompletionProposalAcceptor acceptor, Predicate<IEObjectDescription> filter,
				Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
			Function<IEObjectDescription, ICompletionProposal> wrappedFactory = getWrappedFactory(model, reference, proposalFactory);
			Iterable<IEObjectDescription> candidates = queryScope(scope, model, reference, filter);
			for (IEObjectDescription candidate : candidates) {
				if (!acceptor.canAcceptMoreProposals())
					return;
				if (filter.apply(candidate)) {
					acceptor.accept(wrappedFactory.apply(candidate));
				}
			}
		}

		public void setScopeProvider(IScopeProvider scopeProvider) {
			this.scopeProvider = scopeProvider;
		}

		public IScopeProvider getScopeProvider() {
			return scopeProvider;
		}
		
		public Iterable<IEObjectDescription> queryScope(IScope scope, EObject model, EReference reference, Predicate<IEObjectDescription> filter) {
			return scope.getAllElements();
		}
	}

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private ReferenceProposalCreator crossReferenceProposalCreator;
	
	private final Map<String, PolymorphicDispatcher<Void>> dispatchers;

	protected AbstractJavaBasedContentProposalProvider() {
		dispatchers = new HashMap<String, PolymorphicDispatcher<Void>>();
	}

	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		ICompletionProposal proposal = createCompletionProposal(keyword.getValue(), getKeywordDisplayString(keyword),
				getImage(keyword), contentAssistContext);
		getPriorityHelper().adjustKeywordPriority(proposal, contentAssistContext.getPrefix());
		acceptor.accept(proposal);
	}

	@Override
	public void completeRuleCall(RuleCall ruleCall, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		AbstractRule calledRule = ruleCall.getRule();
		String methodName = "complete_" + calledRule.getName();
		invokeMethod(methodName, acceptor, contentAssistContext.getCurrentModel(), ruleCall, contentAssistContext);
	}

	@Override
	public void completeAssignment(Assignment assignment, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		ParserRule parserRule = GrammarUtil.containingParserRule(assignment);
		String methodName = "complete" + Strings.toFirstUpper(parserRule.getName()) + "_"
				+ Strings.toFirstUpper(assignment.getFeature());
		invokeMethod(methodName, acceptor, contentAssistContext.getCurrentModel(), assignment, contentAssistContext);
	}

	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(crossReference, contentAssistContext, acceptor,
				Predicates.<IEObjectDescription> alwaysTrue());
	}

	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor, Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
		lookupCrossReference(crossReference, contentAssistContext, acceptor,
				Predicates.<IEObjectDescription> alwaysTrue(), proposalFactory);
	}

	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor, Predicate<IEObjectDescription> filter) {
		ParserRule containingParserRule = GrammarUtil.containingParserRule(crossReference);
		if (!GrammarUtil.isDatatypeRule(containingParserRule)) {
			EReference ref = GrammarUtil.getReference(crossReference);
			lookupCrossReference(crossReference, ref, contentAssistContext, acceptor, filter);
		}
	}

	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor, Predicate<IEObjectDescription> filter,
			Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
		ParserRule containingParserRule = GrammarUtil.containingParserRule(crossReference);
		if (!GrammarUtil.isDatatypeRule(containingParserRule)) {
			EReference ref = GrammarUtil.getReference(crossReference);
			lookupCrossReference(crossReference, ref, acceptor, filter, proposalFactory);
		}
	}

	protected void lookupCrossReference(CrossReference crossReference, EReference reference,
			ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor,
			Predicate<IEObjectDescription> filter) {
		String ruleName = null;
		if (crossReference.getTerminal() instanceof RuleCall) {
			ruleName = ((RuleCall) crossReference.getTerminal()).getRule().getName();
		}
		lookupCrossReference(contentAssistContext.getCurrentModel(), reference, acceptor, filter,
				getProposalFactory(ruleName, contentAssistContext));
	}

	protected void lookupCrossReference(EObject model, EReference reference, ICompletionProposalAcceptor acceptor,
			Predicate<IEObjectDescription> filter, Function<IEObjectDescription, ICompletionProposal> proposalFactory) {
		crossReferenceProposalCreator.lookupCrossReference(model, reference, acceptor, filter, proposalFactory);
	}

	protected Function<IEObjectDescription, ICompletionProposal> getProposalFactory(String ruleName,
			ContentAssistContext contentAssistContext) {
		return new DefaultProposalCreator(contentAssistContext, ruleName, getQualifiedNameConverter());
	}

	private Set<List<Object>> handledArguments;

	@Override
	public void createProposals(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		try {
			handledArguments = Sets.newHashSet();
			super.createProposals(context, acceptor);
		} finally {
			handledArguments = null;
		}
	}

	protected void invokeMethod(String methodName, ICompletionProposalAcceptor acceptor, Object... params) {
		PolymorphicDispatcher<Void> dispatcher = dispatchers.get(methodName);
		if (dispatcher == null) {
			ErrorHandler<Void> errorHandler = WarningErrorHandler.get(log);
			dispatcher = new PolymorphicDispatcher<Void>(methodName, params.length + 1, params.length + 1,
					Collections.singletonList(this), errorHandler) {
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
		if (handledArguments.add(Lists.asList(methodName, paramAsArray))) {
			dispatcher.invoke(paramAsArray);
		}
	}

	public void setScopeProvider(IScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	public void setCrossReferenceProposalCreator(ReferenceProposalCreator crossReferenceProposalCreator) {
		this.crossReferenceProposalCreator = crossReferenceProposalCreator;
	}

	public ReferenceProposalCreator getCrossReferenceProposalCreator() {
		return crossReferenceProposalCreator;
	}
	
	public IEObjectHover getHover() {
		return hover;
	}
	
}
