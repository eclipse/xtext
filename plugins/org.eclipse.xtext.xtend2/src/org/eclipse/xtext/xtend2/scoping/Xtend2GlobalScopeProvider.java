/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * Lets inferred JVM models from index shadow the types scopes.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2GlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	private AbstractTypeScopeProvider typeScopeProvider;

	@Override
	public IScope getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		EClass referenceType = getEReferenceType(resource, reference);
		IScope parentTypeScope = IScope.NULLSCOPE;
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, referenceType)) {
			parentTypeScope = typeScopeProvider.getScope(resource, reference, filter);
		} else 
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_CONSTRUCTOR, referenceType)) {
			parentTypeScope = typeScopeProvider.getScope(resource, reference, filter);
		}
		return super.getScope(parentTypeScope, resource, false, referenceType, filter);
	}

	protected EClass getEReferenceType(Resource resource, EReference reference) {
		return reference.getEReferenceType();
	}

}
