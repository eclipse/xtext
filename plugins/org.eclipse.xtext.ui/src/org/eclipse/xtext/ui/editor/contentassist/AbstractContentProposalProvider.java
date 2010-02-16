/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.naming.IQualifiedNameSupport;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;

/**
 * The default implementation of interface {@link IContentProposalProvider} provided with Xtext.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Heiko Behrens
 * @author Jan K&ouml;hnlein
 */
public abstract class AbstractContentProposalProvider implements IContentProposalProvider, ICompletionProposalFactory {

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
	
	@Inject
	private IContentProposalPriorities priorities;

	@Inject
	private ILabelProvider labelProvider;
	
	@Inject
	private IQualifiedNameSupport qualifiedNameSupport;
	
	@Inject
	private IValueConverterService valueConverter;
	
	@Inject
	private IProposalConflictHelper conflictHelper;
	
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

	public ICompletionProposal createCompletionProposal(String proposal, String displayString, Image image,
			ContentAssistContext contentAssistContext) {
		return createCompletionProposal(proposal, new StyledString(displayString), image, getPriorityHelper().getDefaultPriority(), contentAssistContext.getPrefix(), contentAssistContext);
	}
	
	protected ICompletionProposal createCompletionProposal(String proposal, ContentAssistContext contentAssistContext) {
		return createCompletionProposal(proposal, null, null, getPriorityHelper().getDefaultPriority(), contentAssistContext.getPrefix(), contentAssistContext);
	}
	
	protected ICompletionProposal createCompletionProposal(String proposal, StyledString displayString, Image image,
			ContentAssistContext contentAssistContext) {
		return createCompletionProposal(proposal, displayString, image, getPriorityHelper().getDefaultPriority(), contentAssistContext.getPrefix(), contentAssistContext);
	}
	
	/**
	 * @see #isValidProposal(String, String, ContentAssistContext)
	 * @see #doCreateProposal(String, String, Image, int, ContentAssistContext)
	 */
	protected ICompletionProposal createCompletionProposal(String proposal, StyledString displayString, Image image,
			int priority, String prefix, ContentAssistContext context) {
		if (isValidProposal(proposal, prefix, context)) {
			return doCreateProposal(proposal, displayString, image, priority, context);
		}
		return null;
	}

	protected boolean isValidProposal(String proposal, String prefix, ContentAssistContext context) {
		if (proposal == null)
			return false;
		if (!context.getMatcher().isCandidateMatchingPrefix(proposal, prefix))
			return false;
		if (conflictHelper.existsConflict(proposal, context))
			return false;
		return true;
	}

	protected ConfigurableCompletionProposal doCreateProposal(String proposal, StyledString displayString, Image image,
			int priority, ContentAssistContext context) {
		int replacementOffset = context.getReplaceRegion().getOffset();
		int replacementLength = context.getReplaceRegion().getLength();
		ConfigurableCompletionProposal result = doCreateProposal(proposal, displayString, image, replacementOffset, replacementLength);
		result.setPriority(priority);
		result.setMatcher(context.getMatcher());
		result.setReplaceContextLength(context.getReplaceContextLength());
		return result;
	}

	protected ConfigurableCompletionProposal doCreateProposal(String proposal, StyledString displayString, Image image,
			int replacementOffset, int replacementLength) {
		return new ConfigurableCompletionProposal(proposal, replacementOffset, replacementLength, 
				proposal.length(), image, displayString, null, null);
	}
	
	protected StyledString getKeywordDisplayString(Keyword keyword) {
		return new StyledString(keyword.getValue());
	}
	
	protected StyledString getStyledDisplayString(EObject element, String qualifiedName, String shortName) {
		return new StyledString(getDisplayString(element, qualifiedName, shortName));
	}
	
	protected String getDisplayString(EObject element, String qualifiedName, String shortName) {
		if (qualifiedName == null)
			qualifiedName = shortName;
		if (qualifiedName == null) {
			if (element != null)
				qualifiedName = labelProvider.getText(element);
			else
				return null;
		}
		String delimiter = qualifiedNameSupport.getDelimiter();
		int idx = qualifiedName.lastIndexOf(delimiter);
		if (idx > 0) {
			String lastSegment = qualifiedName.substring(idx + delimiter.length());
			return lastSegment + " - " + qualifiedName;
		} else {
			return qualifiedName;
		}
	}

	public void setValueConverter(IValueConverterService valueConverter) {
		this.valueConverter = valueConverter;
	}

	public IValueConverterService getValueConverter() {
		return valueConverter;
	}
	
	/**
     * Returns the image for the label of the given element.
     *
     * @param element the element for which to provide the label image
     * @return the image used to label the element, or <code>null</code> if there is no image for the given object
     */
	protected Image getImage(EObject eObject) {
		return labelProvider.getImage(eObject);
	}

	public void setConflictHelper(IProposalConflictHelper conflictHelper) {
		this.conflictHelper = conflictHelper;
	}

	public IProposalConflictHelper getConflictHelper() {
		return conflictHelper;
	}

	public void setPriorityHelper(IContentProposalPriorities priorities) {
		this.priorities = priorities;
	}

	public IContentProposalPriorities getPriorityHelper() {
		return priorities;
	}

	public void setQualifiedNameSupport(IQualifiedNameSupport qualifiedNameSupport) {
		this.qualifiedNameSupport = qualifiedNameSupport;
	}

	public IQualifiedNameSupport getQualifiedNameSupport() {
		return qualifiedNameSupport;
	}

	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}
	
}
