/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.lang.reflect.Method;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * A declarative scope provider allowing to specify
 * scoping by declaration of methods of the following signature
 * 
 * IScope scope_[ReturnTypeName](MyRootType rootModel, MyType context, EReference reference)
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractDeclarativeScopeProvider extends AbstractScopeProvider {

	private final static Logger log = Logger.getLogger(AbstractDeclarativeScopeProvider.class);
	
	private final ErrorHandler<IScope> refErrorHandler = new ErrorHandler<IScope>() {
		public IScope handle(Object[] params, Throwable throwable) {
			EObject rootModel = (EObject) params[0];
			EObject context = (EObject) params[1];
			EReference reference = (EReference) params[2];
			if (context.eContainer()==null) {
				if (log.isTraceEnabled())
					log.trace(throwable.getMessage());
				return genericFallBack.getScope(rootModel, context, reference);
			}
			return AbstractDeclarativeScopeProvider.this.getScope(rootModel, context.eContainer(), reference);
		}};
		
	private final ErrorHandler<IScope> typeErrorHandler = new ErrorHandler<IScope>() {
		public IScope handle(Object[] params, Throwable throwable) {
			EObject rootModel = (EObject) params[0];
			EObject context = (EObject) params[1];
			EClass type = (EClass) params[2];
			if (context.eContainer()==null) {
				if (log.isTraceEnabled())
					log.trace(throwable.getMessage());
				return genericFallBack.getScope(rootModel, context, type);
			}
			return AbstractDeclarativeScopeProvider.this.getScope(rootModel, context.eContainer(), type);
		}};
		
	
	private IScopeProvider genericFallBack;
	
	@Inject
	public void setGenericFallBack(DefaultScopeProvider defaultScopeProvider) {
		this.genericFallBack = defaultScopeProvider;
	}
	
	protected Predicate<Method> getPredicate(EObject rootModel, EObject context, EClass type) {
		String methodName = "scope_"+type.getName();
		return PolymorphicDispatcher.Predicates.forName(methodName, 3);
	}
	
	protected Predicate<Method> getPredicate(EObject rootModel, EObject context, EReference reference) {
		return getPredicate(rootModel, context, reference.getEReferenceType());
	}

	public IScope getScope(EObject rootModel, EObject context, EReference reference) {
		final Predicate<Method> predicate = getPredicate(rootModel, context, reference);
		final PolymorphicDispatcher<IScope> scope = new PolymorphicDispatcher<IScope>(Collections.singletonList(this), predicate, refErrorHandler);
		return scope.invoke(rootModel, context, reference);
	}
	
	public IScope getScope(EObject rootModel, EObject context, EClass type) {
		final Predicate<Method> predicate = getPredicate(rootModel, context, type);
		final PolymorphicDispatcher<IScope> scope = new PolymorphicDispatcher<IScope>(Collections.singletonList(this), predicate, typeErrorHandler);
		return scope.invoke(rootModel, context, type);
	}

}
