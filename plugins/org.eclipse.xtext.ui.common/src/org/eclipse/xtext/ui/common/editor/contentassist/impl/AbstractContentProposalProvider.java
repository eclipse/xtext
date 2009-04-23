/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.core.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

/**
 * The default implementation of interface {@link IContentProposalProvider} provided with Xtext.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Heiko Behrens
 * @author Jan K&ouml;hnlein
 */
public abstract class AbstractContentProposalProvider implements IContentProposalProvider {

	public class DefaultContentAssistProcessorSwitch extends XtextSwitch<Boolean> {

		private final ContentAssistContext context;
		private final ICompletionProposalAcceptor acceptor;

		public DefaultContentAssistProcessorSwitch(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			this.context = context;
			this.acceptor = acceptor;
		}

		@Override
		public Boolean defaultCase(EObject object) {
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseKeyword(Keyword object) {
			completeKeyword(object, context, acceptor);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseRuleCall(RuleCall object) {
			completeRuleCall(object, context, acceptor);
			return Boolean.TRUE;
		}

		@Override
		public Boolean caseAssignment(Assignment object) {
			completeAssignment(object, context, acceptor);
			return Boolean.TRUE;
		}
	}

	public static class NullSafeCompletionProposalAcceptor extends ICompletionProposalAcceptor.Delegate {

		public NullSafeCompletionProposalAcceptor(ICompletionProposalAcceptor delegate) {
			super();
			setDelegate(delegate);
		}

		@Override
		public void accept(ICompletionProposal proposal) {
			if (proposal != null)
				super.accept(proposal);
		}
	}

	public void createProposals(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		ICompletionProposalAcceptor nullSafe = new NullSafeCompletionProposalAcceptor(acceptor);
		DefaultContentAssistProcessorSwitch selector = new DefaultContentAssistProcessorSwitch(context, nullSafe);
		for (AbstractElement element : context.getFirstSetGrammarElements()) {
			selector.doSwitch(element);
		}
	}

	public abstract void completeKeyword(Keyword object, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor);

	public abstract void completeRuleCall(RuleCall object, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor);

	public abstract void completeAssignment(Assignment object, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor);

	public DefaultContentAssistProcessorSwitch createSelector(ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		return new DefaultContentAssistProcessorSwitch(context, acceptor);
	}

	public static class FilteringCompletionProposalAcceptor extends ICompletionProposalAcceptor.Delegate {

		private final Predicate<ICompletionProposal> filter;

		public FilteringCompletionProposalAcceptor(ICompletionProposalAcceptor delegate, Predicate<ICompletionProposal> filter) {
			super();
			this.filter = filter;
			setDelegate(delegate);
		}
		
		@Override
		public void accept(ICompletionProposal proposal) {
			if (filter.apply(proposal))
				super.accept(proposal);
		}
		
	}
	
	public static class ModifyingCompletionProposalAcceptor extends ICompletionProposalAcceptor.Delegate {
		private final Function<ICompletionProposal, ICompletionProposal> modifier;

		public ModifyingCompletionProposalAcceptor(ICompletionProposalAcceptor delegate, Function<ICompletionProposal, ICompletionProposal> modifier) {
			super();
			this.modifier = modifier;
			setDelegate(delegate);
		}
		
		@Override
		public void accept(ICompletionProposal proposal) {
			if (proposal != null)
				super.accept(modifier.apply(proposal));
		}
	}
	
	public ICompletionProposalAcceptor filter(ICompletionProposalAcceptor acceptor, Predicate<ICompletionProposal> filter) {
		return new FilteringCompletionProposalAcceptor(acceptor, Predicates.and(Predicates.notNull(), filter));
	}
	
	public ICompletionProposalAcceptor modify(ICompletionProposalAcceptor acceptor, Function<ICompletionProposal, ICompletionProposal> modifier) {
		return new ModifyingCompletionProposalAcceptor(acceptor, modifier);
	}
}
