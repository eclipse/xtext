/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.codecompletion.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.ui.common.editor.codecompletion.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.codecompletion.IProposalProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * Represents a <b>Switch</b> for the Xtext model's inheritance hierarchy to
 * callback and invoke the proposal completion methods of interface <code>IProposalProvider</code>
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
	
	private List<TemplateContextType> templateContextTypeList = new ArrayList<TemplateContextType>();

	private final IProposalProvider proposalProvider;

	private IContentAssistContext contentAssistContext;

	private static final Map<String, Method> methodLookupMap = new HashMap<String, Method>();
	

	/**
	 * @return the templateContextTypeList
	 */
	public List<TemplateContextType> getTemplateContextTypeList() {
		return templateContextTypeList;
	}

	/**
	 * 
	 * @param contentAssistContext the actual contentAssistContext
	 *            
	 * @param proposalProvider
	 *            the proposalProvider to callback and invoke
	 */
	public ProposalProviderInvokerSwitch(IContentAssistContext contentAssistContext, IProposalProvider proposalProvider) {
		this.contentAssistContext = contentAssistContext;
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
	public List<ICompletionProposal> collectCompletionProposalList(List<AbstractElement> elementList) {

		completionProposalList = new ArrayList<ICompletionProposal>();

		for (Iterator<AbstractElement> elementOrRuleIterator = elementList.iterator(); elementOrRuleIterator.hasNext();) {
			EObject abstractElement = elementOrRuleIterator.next();
			doSwitch(abstractElement);
		}

		return completionProposalList;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ICompletionProposal> caseAssignment(Assignment assignment) {
		
		ParserRule parserRule = GrammarUtil.containingParserRule(assignment);

		invokeProposalProvider(
				"complete"+ firstLetterCapitalized(parserRule.getName()) + firstLetterCapitalized(assignment.getFeature()), 
				Arrays.asList(Assignment.class, IContentAssistContext.class), 
				Arrays.asList(assignment, this.contentAssistContext));
		
		return null;
	}

	
	
	
	@Override
	public List<ICompletionProposal> caseKeyword(Keyword keyword) {

		nullSafeAddAll(completionProposalList, proposalProvider.completeKeyword(keyword, this.contentAssistContext));

		TemplateContextType contextType = this.proposalProvider.getTemplateContextType(keyword,
				this.contentAssistContext);

		if (null != contextType) {
			this.templateContextTypeList.add(contextType);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ICompletionProposal> caseRuleCall(RuleCall ruleCall) {

		nullSafeAddAll(completionProposalList, this.proposalProvider.completeRuleCall(ruleCall,
				this.contentAssistContext));

		TemplateContextType contextType = this.proposalProvider.getTemplateContextType(ruleCall,
				this.contentAssistContext);

		if (null != contextType) {
			this.templateContextTypeList.add(contextType);
		}

		AbstractRule calledRule = ruleCall.getRule();

		if (calledRule.getType() != null) {

			TypeRef typeRef = calledRule.getType();

			invokeProposalProvider(
					"complete"+ firstLetterCapitalized(typeRef.getMetamodel().getAlias())+ firstLetterCapitalized(typeRef.getType().getName()), 
					Arrays.asList(RuleCall.class, this.contentAssistContext.getModel() == null ? EObject.class : this.contentAssistContext.getModel().getClass(),IContentAssistContext.class), 
					Arrays.asList(ruleCall, this.contentAssistContext.getModel(),this.contentAssistContext));
		}
		return null;
	}

	private void invokeProposalProvider(String methodName,List<Class<?>> parameterTypes,List<?> parameterValues) {
		
		Method method = findMethod(proposalProvider.getClass(),methodName,parameterTypes.toArray(new Class[]{}));

		Collection<? extends ICompletionProposal> assignmentProposalList = null == method ? null : invokeMethod(method,
				proposalProvider, parameterValues.toArray(new Object[]{}));

		nullSafeAddAll(completionProposalList, assignmentProposalList);
		
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
		return Strings.toFirstUpper(name);
	}

	private void nullSafeAddAll(List<ICompletionProposal> source, Collection<? extends ICompletionProposal> list) {
		if (null != list) {
			source.addAll(list);
		}
	}

}
