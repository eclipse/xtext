/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

/**
 * Encapsulates the creation of constructor scopes.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConstructorScopes extends DelegatingScopes {

	public static final int CONSTRUCTOR_BUCKET = 1;
	
	/**
	 * Creates the constructor scope for {@link XConstructorCall}.
	 * The scope will likely contain descriptions for {@link JvmConstructor constructors}.
	 * If there is not constructor declared, it may contain {@link JvmType types}.
	 * 
	 * @param session the currently available visibilityHelper data
	 * @param reference the reference that will hold the resolved constructor
	 * @param resolvedTypes the currently known resolved types
	 */
	public IScope createConstructorScope(EObject context, EReference reference, IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		if (!(context instanceof XConstructorCall)) {
			return IScope.NULLSCOPE;
		}
		/*
		 * We use a type scope here in order to provide better feedback for users,
		 * e.g. if the constructor call refers to an interface or a primitive.
		 */
		final IScope delegateScope = getDelegate().getScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE);
		IScope result = new ConstructorTypeScopeWrapper(context, session, delegateScope);
		return result;
	}
	
	public boolean isConstructorCallScope(EReference reference) {
		return reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
	}
	
}
