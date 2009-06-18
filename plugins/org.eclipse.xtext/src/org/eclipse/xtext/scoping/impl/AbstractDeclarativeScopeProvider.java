/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.lang.reflect.Method;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * A declarative scope provider which allows to specify scoping by declaration
 * of methods of the following signature
 * <p/>
 * <code>
 * IScope scope_[EReferenceName](MyType context, EReference reference) </br>
 * IScope scope_[EClassName](MyType context, EClass clazz)
 * </code>
 * </p>
 * 
 * That is if the scope provider is asked by
 * {@link #getScope(EObject, EReference)} where EReference is e.g. Property.type
 * and the ctx is an instance of Property, than the corresponding signature
 * could be:</p> <code>
 * IScope scope_Property_type(Property prop, EReference ref)</p>
 * </code>
 * 
 * If there is no method with the given name and a first parameter type which is
 * compatible to the actual context object, the implementation invokes
 * {@link #getPredicate(EObject, EReference)} for the eContainer of the context
 * EObject. For instance of a Property resides in an Entity the
 * {@link #getScope(EObject, EReference)} would be called for the containing
 * Entity. This is done as long as there is an eContainer. <br/>
 * If after walking up the containment hierarchy no suitable scoping declaration
 * has been found, the implementation falls back to invoke getScope(ctx,
 * (EClass) ref.getEType()) i.e. calling {@link #getScope(EObject, EClass)}. For
 * {@link #getScope(EObject, EClass)} this implementation looks for methods with
 * the following signature:</p> <code>
 * IScope scope_[EClassName](MyType context, EClass clazz)</p>
 * </code>
 * 
 * For instance if a scope provider is asked to return all Entities which are
 * visible from a certain Property, it looks for a methode like this:</p> <code>
 * IScope scope_Entity(Reference ref, EClass clazz)</p>
 * </code>
 * Again the first parameter can also be any super type of the actual type and
 * the implementation walks up the containment hierarchy again.</p>
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractDeclarativeScopeProvider extends AbstractScopeProvider {

	private final static Logger log = Logger.getLogger(AbstractDeclarativeScopeProvider.class);

	private final ErrorHandler<IScope> refErrorHandler = new ErrorHandler<IScope>() {
		public IScope handle(Object[] params, Throwable throwable) {
			EObject object = (EObject) params[0];
			EReference reference = (EReference) params[1];
			// ask the container
			if (object.eContainer() != null) {
				return AbstractDeclarativeScopeProvider.this.internalGetScope(object.eContainer(), reference);
			}
			return null;
		}
	};

	private final ErrorHandler<IScope> typeErrorHandler = new ErrorHandler<IScope>() {
		public IScope handle(Object[] params, Throwable throwable) {
			EObject object = (EObject) params[0];
			EClass type = (EClass) params[1];
			if (object.eContainer() == null) {
				if (log.isTraceEnabled())
					log.trace(throwable.getMessage());
				return AbstractDeclarativeScopeProvider.this.getGenericFallBack().getScope(object, type);
			}
			return AbstractDeclarativeScopeProvider.this.getScope(object.eContainer(), type);
		}
	};

	private IScopeProvider genericFallBack = new IScopeProvider() {

		public IScope getScope(EObject context, EClass type) {
			return IScope.NULLSCOPE;
		}

		public IScope getScope(EObject context, EReference reference) {
			return IScope.NULLSCOPE;
		}
	};;

	@Inject(optional = true)
	public void setGenericFallBack(DefaultScopeProvider defaultScopeProvider) {
		this.genericFallBack = defaultScopeProvider;
	}
	
	public IScopeProvider getGenericFallBack() {
		return genericFallBack;
	}

	protected Predicate<Method> getPredicate(EObject context, EClass type) {
		String methodName = "scope_" + type.getName();
		return PolymorphicDispatcher.Predicates.forName(methodName, 2);
	}

	protected Predicate<Method> getPredicate(EObject context, EReference reference) {
		String methodName = "scope_" + reference.getEContainingClass().getName() + "_" + reference.getName();
		return PolymorphicDispatcher.Predicates.forName(methodName, 2);
	}

	public IScope getScope(EObject context, EReference reference) {
		IScope scope = internalGetScope(context, reference);
		if (scope == null)
			return getScope(context, (EClass) reference.getEType());
		return scope;
	}

	private IScope internalGetScope(EObject context, EReference reference) {
		final Predicate<Method> predicate = getPredicate(context, reference);
		final PolymorphicDispatcher<IScope> scope = new PolymorphicDispatcher<IScope>(Collections.singletonList(this), predicate,
				refErrorHandler);
		return scope.invoke(context, reference);
	}

	public IScope getScope(EObject context, EClass type) {
		final Predicate<Method> predicate = getPredicate(context, type);
		final PolymorphicDispatcher<IScope> scope = new PolymorphicDispatcher<IScope>(Collections.singletonList(this), predicate,
				typeErrorHandler);
		return scope.invoke(context, type);
	}

}
