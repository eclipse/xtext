/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;

import com.google.inject.Inject;

/**
 * A declarative scope provider allowing to specify
 * scoping by declaration of methods of the following signature
 * 
 * IScope scope_[ReturnTypeName](MyType context, EReference reference)
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractDeclarativeScopeProvider extends AbstractScopeProvider {
	private final static Logger log = Logger.getLogger(AbstractDeclarativeScopeProvider.class);
	
	private final ErrorHandler<IScope> handler = new ErrorHandler<IScope>() {
		public IScope handle(Object[] params, Throwable throwable) {
			EObject object = (EObject) params[0];
			EReference reference = (EReference) params[1];
			if (object.eContainer()==null) {
				if (log.isInfoEnabled())
					log.info(throwable.getMessage());
				return genericFallBack.getScope(object, reference);
			}
			return AbstractDeclarativeScopeProvider.this.getScope(object.eContainer(), reference);
		}};
		
	
	private IScopeProvider genericFallBack;
	
	@Inject
	public void setGenericFallBack(DefaultScopeProvider defaultScopeProvider) {
		this.genericFallBack = defaultScopeProvider;
	}

	public final IScope getScope(EObject context, EReference reference) {
		String methodName = "scope_"+reference.getEType().getName();
		final PolymorphicDispatcher<IScope> scope = new PolymorphicDispatcher<IScope>(methodName, 2, 2, Collections.singletonList(this), handler);
		return scope.invoke(context, reference);
	}
	
	public final IScope getScope(EObject context, EClass type) {
		String methodName = "scope_"+type.getName();
		final PolymorphicDispatcher<IScope> scope = new PolymorphicDispatcher<IScope>(methodName, 2, 2, Collections.singletonList(this), handler);
		return scope.invoke(context, type);
	}

}
