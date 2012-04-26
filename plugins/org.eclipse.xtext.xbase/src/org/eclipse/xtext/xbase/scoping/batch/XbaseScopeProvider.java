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

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseScopeProvider extends XtypeScopeProvider {

	@Inject
	private TypeScopeProvider typeScopeProvider;
	
	@Inject
	private ConstructorScopeProvider constructorScopeProvider;
	
	@Inject
	private FeatureScopeProvider featureScopeProvider;

	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (isFeatureCallScope(reference)) {
			IScope parent = IScope.NULLSCOPE;
			return featureScopeProvider.createFeatureCallScope(parent, context, reference);
		}
		if (isConstructorCallScope(reference)) {
			IScope scope = super.getScope(context, reference);
			return constructorScopeProvider.createConstructorCallScope(scope /*, context, reference */);
		}
		if (isTypeScope(reference)) {
			IScope parent = super.getScope(context, reference);
			return typeScopeProvider.createTypeScope(parent, context, reference);
		}
		return super.getScope(context, reference);
	}

	protected boolean isTypeScope(EReference reference) {
		return TypesPackage.Literals.JVM_TYPE.isSuperTypeOf(reference.getEReferenceType());
	}

	protected boolean isConstructorCallScope(EReference reference) {
		return reference.getEReferenceType() == TypesPackage.Literals.JVM_CONSTRUCTOR;
	}

	public boolean isFeatureCallScope(EReference reference) {
		return featureScopeProvider.isFeatureCallScope(reference);
	}
	
}
