/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DelegatingScopeProvider;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseBatchScopeProvider extends DelegatingScopeProvider implements IBatchScopeProvider {

	@Inject
	private IFeatureScopeSession rootSession;
	
	@Inject
	private ImplicitlyImportedTypes implicitlyImportedTypes;
	
	@Inject
	private FeatureScopes featureScopeProvider;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		if (isFeatureCallScope(reference)) {
			// TODO use a valid instance of resolved types
			IFeatureScopeSession session = newSession(context.eResource());
			return session.getScope(context, reference, IResolvedTypes.NULL);
		}
		return delegateGetScope(context, reference);
	}
	
	public IFeatureScopeSession newSession(Resource context) {
		List<JvmType> literalClasses = implicitlyImportedTypes.getStaticImportClasses(context);
		List<JvmType> extensionClasses = implicitlyImportedTypes.getExtensionClasses(context);
		return rootSession.addTypesToStaticScope(literalClasses, extensionClasses);
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

	public boolean isBatchScopeable(EReference reference) {
		return isConstructorCallScope(reference) || isFeatureCallScope(reference);
	}

}
