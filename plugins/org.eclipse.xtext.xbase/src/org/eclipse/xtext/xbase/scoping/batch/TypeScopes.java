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
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeScopes extends DelegatingScopes {

	public boolean isTypeScope(EReference reference) {
		return TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(reference.getEReferenceType());
	}

	/**
	 * @param resolvedTypes the currently known resolved types
	 */
	public IScope createTypeScope(EObject context, EReference reference,
			IFeatureScopeSession session, IResolvedTypes resolvedTypes) {
		final IScope delegateScope = getDelegate().getScope(context, reference);
		// TODO visibility information should be attached to the given type descriptions
		return delegateScope;
	}

}
