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
import org.eclipse.xtext.util.PolymorphicDispatcher.NullErrorHandler;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * Invokes methods on the {@link #polymorphicTargetObject} reflectively.
 * 
 * At first it looks for methods of the following signature:
 * <code>
 * IScope scope_[EClassName]_[EReferenceName](MyType context, EReference ref)</p>
 * </code>
 * 
 * That is if {@link #getScope(EObject, EReference)} is called where EReference is e.g. Property.type and
 * the ctx is an instance of Property, than the corresponding signature could be:</p> <code>
 * IScope scope_Property_type(Property prop, EReference ref)</p>
 * </code>
 * 
 * If there is no method with the given name and a first parameter type which is compatible to the actual context
 * object, the implementation invokes {@link #getPredicate(EObject, EReference)} for the eContainer of the context
 * EObject. For instance of a Property resides in an Entity the {@link #getScope(EObject, EReference)} would be called
 * for the containing Entity. This is done as long as there is an eContainer. <br/>
 * If after walking up the containment hierarchy no suitable scoping declaration has been found, the implementation
 * falls back to invoke methods with the following signature (computed by {@link #getPredicate(EObject, EClass)}):</p>
 * <code>
 * IScope scope_[EClassName](MyType context, EReference ref)</p>
 * </code>
 * 
 * For instance if a scope provider is asked to return all Entities which are visible from a certain Property, it looks
 * for a method like this:</p> <code>
 * IScope scope_Entity(Reference ref, EReference ref)</p>
 * </code> Again the first parameter can also be any super type of the actual type and the
 * implementation walks up the containment hierarchy again.</p>
 * 
 * If still no method could be found <code>null</code> is returned
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class DeclarativeScopeProvider extends AbstractScopeProvider {
	
	private final Logger log = Logger.getLogger(getClass());

	private static final NullErrorHandler<IScope> ERROR_HANDLER = new PolymorphicDispatcher.NullErrorHandler<IScope>();

	private Object polymorphicTargetObject = this;

	protected Object getPolymorphicTargetObject() {
		return polymorphicTargetObject;
	}

	public DeclarativeScopeProvider() {
	}

	@Inject
	public DeclarativeScopeProvider(IScopeProvider polymorphicTargetObject) {
		this.polymorphicTargetObject = polymorphicTargetObject;
	}

	public DeclarativeScopeProvider(Object polymorphicTargetObject) {
		this.polymorphicTargetObject = polymorphicTargetObject;
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
		IScope scope = polymorphicFindScopeForReferenceName(context, reference);
		if (scope != null)
			return scope;
		return polymorphicFindScopeForClassName(context, reference);
	}

	protected IScope polymorphicFindScopeForClassName(EObject context, EReference reference) {
		IScope scope = null;
		PolymorphicDispatcher<IScope> dispatcher = new PolymorphicDispatcher<IScope>(Collections
				.singletonList(getPolymorphicTargetObject()), getPredicate(context, reference.getEReferenceType()),
				ERROR_HANDLER);
		EObject current = context;
		while (scope == null && current != null) {
			scope = dispatcher.invoke(current, reference);
			current = current.eContainer();
		}
		current = context;
		while (scope == null && current != null) {
			scope = dispatcher.invoke(current, reference.getEReferenceType());
			if (scope!=null)
				log.warn("scope_<EClass>(EObject,EClass) is deprecated. Use scope_<EClass>(EObject,EReference) instead.");
			current = current.eContainer();
		}
		return scope;
	}

	protected IScope polymorphicFindScopeForReferenceName(EObject context, EReference reference) {
		Predicate<Method> predicate = getPredicate(context, reference);
		PolymorphicDispatcher<IScope> dispatcher = new PolymorphicDispatcher<IScope>(Collections
				.singletonList(getPolymorphicTargetObject()), predicate, ERROR_HANDLER);
		EObject current = context;
		IScope scope = null;
		while (scope == null && current != null) {
			scope = dispatcher.invoke(current, reference);
			current = current.eContainer();
		}
		return scope;
	}

}
