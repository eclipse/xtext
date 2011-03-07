/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import static org.eclipse.xtext.common.types.TypesPackage.Literals.*;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScopeProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * Shadows directly referrable generated Java elements from the index with inferred JVM model elements. 
 *  
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmGlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	private AbstractTypeScopeProvider typeScopeProvider;

	@Override
	public IScope getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		IScope parentTypeScope = getParentTypeScope(resource, reference, filter, reference.getEReferenceType());
		return super.getScope(parentTypeScope, resource, false, reference.getEReferenceType(), filter);
	}

	protected IScope getParentTypeScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter,
			EClass referenceType) {
		IScope parentTypeScope = IScope.NULLSCOPE;
		if (EcoreUtil2.isAssignableFrom(JVM_TYPE, referenceType) || EcoreUtil2.isAssignableFrom(JVM_CONSTRUCTOR, referenceType)) {
			parentTypeScope = typeScopeProvider.getScope(resource, reference, filter);
		}
		return parentTypeScope;
	}
}
