/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.codecompletion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * Represents a <b>Switch</b> for the Xtext model's inheritance hierarchy to
 * callback and invoke the completion methods of <code>IProposalProvider</code>
 * implementations to gather and collect <code>ICompletionProposal</code> to be
 * displayed for Content Assist.
 * 
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} instead of
 * typical <code>if (x instanceof y)</code> code blocks.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see IProposalProvider
 * @see org.eclipse.xtext.util.XtextSwitch
 */
public class ProposalProviderInvokerSwitch extends XtextSwitch<List<ICompletionProposal>> {

	private List<ICompletionProposal> completionProposalList = new ArrayList<ICompletionProposal>();

	private final IProposalProvider proposalProvider;

	private final IDocument document;

	private final AbstractNode currentLeafNode;

	private final String prefix;

	private int offset;

	private static final Map<String, Method> methodLookupMap = new HashMap<String, Method>();

	/**
	 * 
	 * @param currentLeafNode
	 *            the last node in the document
	 * @param document
	 *            the document itself
	 * @param offset
	 *            the position in the offset from which CA was triggered
	 * @param prefix
	 *            the prefix normally consisting of the text content of the
	 *            currentLeafNode
	 * @param proposalProvider
	 *            the proposalProvider to callback and invoke
	 */
	public ProposalProviderInvokerSwitch(AbstractNode currentLeafNode, IDocument document, int offset, String prefix,
			IProposalProvider proposalProvider) {
		super();
		this.currentLeafNode = currentLeafNode;
		this.document = document;
		this.offset = offset;
		this.prefix = prefix;
		this.proposalProvider = proposalProvider;
	}

	/**
	 * Collect a list of <code>ICompletionProposal</code> for the given
	 * elementList through callback and reflective invocations to
	 * <code>IProposalProvider</code>
	 * 
	 * @param elementList
	 *            the list of <code>EObject</code> to collect
	 *            <code>ICompletionProposal</code> for
	 * @return a list of matching <code>ICompletionProposal</code>
	 */
	public List<ICompletionProposal> collectCompletionProposalList(List<EObject> elementList) {

		completionProposalList = new ArrayList<ICompletionProposal>();

		for (Iterator<EObject> elementOrRuleIterator = elementList.iterator(); elementOrRuleIterator.hasNext();) {
			EObject abstractElement = elementOrRuleIterator.next();
			doSwitch(abstractElement);
		}

		return completionProposalList;

	}

	@Override
	public List<ICompletionProposal> caseAssignment(Assignment assignment) {
		ParserRule parserRule = GrammarUtil.containingParserRule(assignment);

		EObject model = null == ((CompositeNode) currentLeafNode.eContainer()).getElement() ? currentLeafNode
				.eContainer() : ((CompositeNode) currentLeafNode.eContainer()).getElement();

		Method method = findMethod(proposalProvider.getClass(), "complete"
				+ firstLetterCapitalized(parserRule.getName()) + firstLetterCapitalized(assignment.getFeature()),
				Assignment.class, model.getClass(), String.class, document.getClass(), int.class);

		Collection<? extends ICompletionProposal> assignmentProposalList = null == method ? null : invokeMethod(method,
				proposalProvider, assignment, model, prefix, document, offset);

		if (null != assignmentProposalList) {
			completionProposalList.addAll(assignmentProposalList);
		}

		return null;
	}

	@Override
	public List<ICompletionProposal> caseKeyword(Keyword keyword) {
		completionProposalList.addAll(proposalProvider.completeKeyword(keyword, currentLeafNode, prefix, document,
				offset));
		return null;
	}

	@Override
	public List<ICompletionProposal> caseRuleCall(RuleCall ruleCall) {
		
		EObject model = null == ((CompositeNode) currentLeafNode.eContainer()).getElement() ? currentLeafNode
				.eContainer() : ((CompositeNode) currentLeafNode.eContainer()).getElement();

				
		List<? extends ICompletionProposal> ruleCallProposalList = this.proposalProvider.completeRuleCall(ruleCall,
				model, prefix, document, offset);

		if (null != ruleCallProposalList) {
			completionProposalList.addAll(ruleCallProposalList);
		}

		AbstractRule calledRule = GrammarUtil.calledRule(ruleCall);

		if (calledRule.getType() != null) {

			TypeRef typeRef = calledRule.getType();

			Method method = findMethod(proposalProvider.getClass(), "complete"
					+ firstLetterCapitalized(typeRef.getAlias()) + firstLetterCapitalized(typeRef.getName()),
					RuleCall.class, model.getClass(), String.class, document.getClass(), int.class);

			Collection<? extends ICompletionProposal> proposalList = null == method ? null : invokeMethod(method,
					proposalProvider, ruleCall, model, prefix, document, offset);

			if (null != proposalList) {
				completionProposalList.addAll(proposalList);
			}

		}
		return null;
	}

	private final Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
		Assert.isNotNull(clazz, "Class must not be null");
		Assert.isNotNull(name, "Method name must not be null");
		Method result = methodLookupMap.get(name);
		Class<?> searchType = clazz;
		while (!Object.class.equals(searchType) && searchType != null && null == result) {
			Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				if (name.equals(method.getName())
						&& (paramTypes == null || equalOrAssignableTypes(method.getParameterTypes(), paramTypes))) {
					if (result == null
							|| equalOrAssignableTypes(result.getParameterTypes(), method.getParameterTypes())) {
						result = method;
						methodLookupMap.put(name, method);
					}
				}
			}
			searchType = searchType.getSuperclass();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private final Collection<ICompletionProposal> invokeMethod(Method method, Object target, Object... args) {

		try {
			return (Collection<ICompletionProposal>) method.invoke(target, args);
		}
		catch (Exception ex) {
			handleReflectionException(ex);
		}
		throw new IllegalStateException("huh?");
	}

	private void handleReflectionException(Exception ex) {
		if (ex instanceof NoSuchMethodException) {
			throw new IllegalStateException("Method not found: " + ex.getMessage());
		}
		if (ex instanceof IllegalAccessException) {
			throw new IllegalStateException("Could not access method: " + ex.getMessage());
		}
		if (ex instanceof InvocationTargetException) {
			rethrowRuntimeException(((InvocationTargetException) ex).getTargetException());
		}
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		handleUnexpectedException(ex);
	}

	private void handleUnexpectedException(Throwable ex) {
		IllegalStateException isex = new IllegalStateException("Unexpected exception thrown");
		isex.initCause(ex);
		throw isex;
	}

	private final void rethrowRuntimeException(Throwable ex) {
		if (ex instanceof RuntimeException) {
			throw (RuntimeException) ex;
		}
		if (ex instanceof Error) {
			throw (Error) ex;
		}
		handleUnexpectedException(ex);
	}

	private boolean equalOrAssignableTypes(Class<?>[] a, Class<?>[] a2) {
		if (a == a2) {
			return true;
		}

		if (a == null || a2 == null) {
			return false;
		}

		int length = a.length;

		if (a2.length != length) {
			return false;
		}

		for (int i = 0; i < length; i++) {
			Class<?> o1 = a[i];
			Class<?> o2 = a2[i];

			if (!(o1 == null ? o2 == null : o1.equals(o2) || o1.isAssignableFrom(o2))) {
				return false;
			}
		}
		return true;
	}

	private final String firstLetterCapitalized(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

}
