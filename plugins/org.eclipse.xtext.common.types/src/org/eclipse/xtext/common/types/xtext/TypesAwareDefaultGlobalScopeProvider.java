/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * TypesAwareDefaultGlobalScopeProvider for the common case
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypesAwareDefaultGlobalScopeProvider extends DefaultGlobalScopeProvider {
	
	@Inject
	private AbstractTypeScopeProvider typeScopeProvider;

	@Override
	public IScope getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		EClass referenceType = getEReferenceType(resource, reference);
		if (TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(referenceType)) {
			return typeScopeProvider.getScope(resource, reference, filter);
		}
		if (TypesPackage.Literals.JVM_CONSTRUCTOR.isSuperTypeOf(referenceType)) {
			return typeScopeProvider.getScope(resource, reference, filter);
		}
		return super.getScope(resource, reference, filter);
	}

	protected EClass getEReferenceType(Resource resource, EReference reference) {
		return reference.getEReferenceType();
	}
	
}
