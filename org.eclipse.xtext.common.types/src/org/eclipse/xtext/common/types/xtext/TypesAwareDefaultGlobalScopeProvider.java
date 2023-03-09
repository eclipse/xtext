/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * TypesAwareDefaultGlobalScopeProvider for the common case
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class TypesAwareDefaultGlobalScopeProvider extends DefaultGlobalScopeProvider {
	
	@Inject
	private AbstractTypeScopeProvider typeScopeProvider;

	@Override
	public IScope getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		EClass referenceType = getEReferenceType(resource, reference);
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, referenceType)) {
			return typeScopeProvider.getScope(resource, reference, filter);
		}
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_CONSTRUCTOR, referenceType)) {
			return typeScopeProvider.getScope(resource, reference, filter);
		}
		return super.getScope(resource, reference, filter);
	}

	protected EClass getEReferenceType(Resource resource, EReference reference) {
		return reference.getEReferenceType();
	}
	
}
