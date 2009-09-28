/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.xtext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.access.ITypeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeScopeProvider extends AbstractScopeProvider {

	public IScope getScope(EObject context, EReference reference) {
		if (context.eResource() == null)
			throw new IllegalStateException("context must be contained in a resource");
		ResourceSet resourceSet = context.eResource().getResourceSet();
		if (resourceSet == null)
			throw new IllegalStateException("context must be contained in a resource set");
		EClass referenceType = reference.getEReferenceType();
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.TYPE, referenceType)) {
			ITypeProvider typeProvider = getTypeProviderFactory().findTypeProvider(resourceSet);
			if (typeProvider == null)
				typeProvider = getTypeProviderFactory().createTypeProvider(resourceSet);
			return createTypeScope(typeProvider);
		} else {
			return IScope.NULLSCOPE;
		}
	}

	public abstract AbstractTypeScope createTypeScope(ITypeProvider typeProvider);

	public abstract ITypeProvider.Factory getTypeProviderFactory();

}
