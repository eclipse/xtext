/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.xtext.TypesAwareDefaultGlobalScopeProvider;

/**
 * Shadows directly referrable generated Java elements from the index with inferred JVM model elements. 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * 
 * @deprecated use the {@link TypesAwareDefaultGlobalScopeProvider}. The shadowing is performed by the {@link IJvmTypeProvider}.
 */
@Deprecated
public class JvmGlobalScopeProvider extends TypesAwareDefaultGlobalScopeProvider {

//	@Inject
//	private AbstractTypeScopeProvider typeScopeProvider;
//
//	@Override
//	public IScope getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
//		IScope parentTypeScope = getParentTypeScope(resource, reference, filter, reference.getEReferenceType());
//		return parentTypeScope;
//	}
//
//	protected IScope getParentTypeScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter,
//			EClass referenceType) {
//		IScope parentTypeScope = IScope.NULLSCOPE;
//		if (EcoreUtil2.isAssignableFrom(JVM_TYPE, referenceType) || EcoreUtil2.isAssignableFrom(JVM_CONSTRUCTOR, referenceType)) {
//			parentTypeScope = typeScopeProvider.getScope(resource, reference, filter);
//		}
//		return parentTypeScope;
//	}
	
}
