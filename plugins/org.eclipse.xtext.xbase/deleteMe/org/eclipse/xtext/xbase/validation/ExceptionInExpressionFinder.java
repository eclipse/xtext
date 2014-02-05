/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.validation;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * 
 * TODO this should be a service of the type provider
 */
@SuppressWarnings("deprecation")
public class ExceptionInExpressionFinder {
	
	@Inject
	private ITypeProvider typeProvider;

	public List<EObject> findChildrenThrowingException(EObject rootExpression, JvmTypeReference thrownException) {
		final List<EObject> result = newArrayList();
		findChildrenThrowingException(rootExpression, thrownException, new IAcceptor<EObject>() {
			public void accept(EObject t) {
				result.add(t);
			}
		});
		return result;
	}

	protected void findChildrenThrowingException(EObject rootExpression, JvmTypeReference thrownException,
			IAcceptor<EObject> acceptor) {
		boolean exceptionSeenInChildren = false;
		for(EObject element: rootExpression.eContents()) {
			if (element instanceof XExpression) {
				if(contains(typeProvider.getThrownExceptionTypes((XExpression)element),thrownException)) {
					exceptionSeenInChildren = true;
					findChildrenThrowingException(element, thrownException, acceptor);
				}
			} else if(element instanceof JvmIdentifiableElement) {
				if(contains(typeProvider.getThrownExceptionForIdentifiable((JvmIdentifiableElement)element),thrownException)) {
					exceptionSeenInChildren = true;
					findChildrenThrowingException(element, thrownException, acceptor);
				}
			}
		}
		if(!exceptionSeenInChildren)
			acceptor.accept(rootExpression);
	}
}
