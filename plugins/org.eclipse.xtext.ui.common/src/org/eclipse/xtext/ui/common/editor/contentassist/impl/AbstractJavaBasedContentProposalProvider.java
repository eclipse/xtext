/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;
import org.eclipse.xtext.util.PolymorphicDispatcher.NullErrorHandler;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractJavaBasedContentProposalProvider extends AbstractContentProposalProvider {
	
	protected final static Logger logger = Logger.getLogger(AbstractJavaBasedContentProposalProvider.class);
	
	@Inject
	protected IScopeProvider scopeProvider;
	
	@Inject
	protected ILabelProvider labelProvider;
	
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
		acceptor.accept(createCompletionProposal(keyword, keyword.getValue(), contentAssistContext));
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

	/**
	 * @see #createCompletionProposal(AbstractElement, String, IContentAssistContext, Image)
	 */
	protected ICompletionProposal createCompletionProposal(IScopedElement element, ContentAssistContext contentAssistContext) {
		return createCompletionProposal(element.element(), element.name(), contentAssistContext);
	}

	/**
	 * @see #createCompletionProposal(AbstractElement, String, IContentAssistContext, Image)
	 */
	protected ICompletionProposal createCompletionProposal(EObject element, String name, ContentAssistContext contentAssistContext) {
		return createCompletionProposal(name, name, getImage(element), contentAssistContext);
	}
	
	/**
	 * @see #createCompletionProposal(AbstractElement, String, IContentAssistContext, Image)
	 */
	protected ICompletionProposal createCompletionProposal(EObject element, String name, String displayName, ContentAssistContext contentAssistContext) {
		return createCompletionProposal(name, displayName, getImage(element), contentAssistContext);
	}
	
	/**
	 * @see #createCompletionProposal(AbstractElement, String, IContentAssistContext, Image)
	 */
	protected ICompletionProposal createCompletionProposal(IScopedElement element, String prefix, ContentAssistContext contentAssistContext) {
		return createCompletionProposal(element.element(), element.name(), element.name(), prefix, contentAssistContext);
	}

	/**
	 * @see #createCompletionProposal(AbstractElement, String, IContentAssistContext, Image)
	 */
	protected ICompletionProposal createCompletionProposal(EObject element, String name, String displayName, String prefix, ContentAssistContext contentAssistContext) {
		return createCompletionProposal(name, displayName, getImage(element), prefix, contentAssistContext);
	}
	
	/**
	 * @see #createCompletionProposal(AbstractElement, String, IContentAssistContext, Image)
	 */
	protected ICompletionProposal createCompletionProposal(String name, ContentAssistContext contentAssistContext) {
		return createCompletionProposal(name, name, null, 100, contentAssistContext.getPrefix(), contentAssistContext);
	}
	
	/**
	 * @see #createCompletionProposal(AbstractElement, String, IContentAssistContext, Image)
	 */
	protected ICompletionProposal createCompletionProposal(String name, Image image, ContentAssistContext contentAssistContext) {
		return createCompletionProposal(name, name, image, 100, contentAssistContext.getPrefix(), contentAssistContext);
	}
	
	/**
	 * @see #createCompletionProposal(AbstractElement, String, IContentAssistContext, Image)
	 */
	protected ICompletionProposal createCompletionProposal(String name, String displayString, Image image,
			ContentAssistContext contentAssistContext) {
		return createCompletionProposal(name, displayString, image, 100, contentAssistContext.getPrefix(), contentAssistContext);
	}
	
	/**
	 * @see #createCompletionProposal(AbstractElement, String, IContentAssistContext, Image)
	 */
	protected ICompletionProposal createCompletionProposal(String name, String displayString, Image image,
			String prefix, ContentAssistContext contentAssistContext) {
		return createCompletionProposal(name, displayString, image, 100, prefix, contentAssistContext);
	}
	
	/**
	 * @param abstractElement the {@link AbstractElement} which is used to create the proposals
	 * @param displayString the string that is already entered by the user prior to requesting content assist
	 * @param contentAssistContext the commonly used set of attributes related to the current content assist request
	 * @param image the {@link Image} for the {@link ICompletionProposal}
	 * @return a new <code>XtextCompletionProposal</code> for the given text and offset.
	 */
	protected ICompletionProposal createCompletionProposal(String name, String displayString, Image image,
			int priority, String prefix, ContentAssistContext context) {
		int replacementOffset = context.getReplaceRegion().getOffset();
		int replacementLength = context.getReplaceRegion().getLength();
		return createCompletionProposal(name, displayString, image, replacementOffset, replacementLength, prefix, context);
	}

	protected ICompletionProposal createCompletionProposal(String name, String displayString, Image image,
			int replacementOffset, int replacementLength, String prefix, ContentAssistContext context) {
		if (context.getMatcher().isCandidateMatchingPrefix(name, prefix))
			return doCreateProposal(name, displayString, image, replacementOffset, replacementLength, context);
		return null;
	}

	protected ConfigurableCompletionProposal doCreateProposal(String name, String displayString, Image image,
			int replacementOffset, int replacementLength, ContentAssistContext context) {
		ConfigurableCompletionProposal result = new ConfigurableCompletionProposal(name, replacementOffset, replacementLength, name.length(), image, displayString, null, null);
		result.setMatcher(context.getMatcher());
		return result;
	}
	
	/**
	 * Concrete subclasses can override this to provide custom lookup behavior
	 * for <code>CrossReference</code>. This implementation delegates to the
	 * injected LinkingService
	 *
	 * @return a list of <code>ICompletionProposal</code> matching the given
	 *         assignment
	 */
	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		if (scopeProvider != null) {
			ParserRule containingParserRule = GrammarUtil.containingParserRule(crossReference);
			if (!GrammarUtil.isDatatypeRule(containingParserRule)) {
				EClass eClass = (EClass) containingParserRule.getType().getClassifier();
				EReference ref = GrammarUtil.getReference(crossReference, eClass);
				IScope scope = scopeProvider.getScope(contentAssistContext.getCurrentModel(), ref);
				Iterable<IScopedElement> candidates = scope.getAllContents();
				for (IScopedElement candidate: candidates) {
					if (!acceptor.canAcceptMoreProposals())
						return;
					acceptor.accept(createCompletionProposal(candidate,	contentAssistContext));
				}
			}
		}
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

}
