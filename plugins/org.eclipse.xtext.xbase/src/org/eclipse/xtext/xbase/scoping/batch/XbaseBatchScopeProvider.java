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
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/*
 * The delegating scope provider is explicitly not implemented since we'd run into infinite recursion.
 * A resource would always be affected by the changes in the Java types that it produces. Therefore
 * we cannot extend the DelegatingScopeProvider
 */
/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseBatchScopeProvider implements IBatchScopeProvider /* , IDelegatingScopeProvider */  {

	@Inject
	private IFeatureScopeSession rootSession;
	
	@Inject
	private ImplicitlyImportedTypes implicitlyImportedTypes;
	
	@Inject
	private FeatureScopes featureScopes;
	
	@Inject
	@Named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)
	private IScopeProvider delegate;
	
	@Inject
	private IBatchTypeResolver typeResolver;
	
	protected IScope delegateGetScope(EObject context, EReference reference) {
		return getDelegate().getScope(context, reference);
	}

	public void setDelegate(IScopeProvider delegate) {
		this.delegate = delegate;
	}

	public IScopeProvider getDelegate() {
		return delegate;
	}
	
	public IScope getScope(EObject context, EReference reference) {
		if (isFeatureCallScope(reference)) {
			if (context instanceof XAbstractFeatureCall) {
				IScope result = typeResolver.getFeatureScope((XAbstractFeatureCall) context);
				return result;
			}
			return IScope.NULLSCOPE;
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
		return featureScopes.isFeatureCallScope(reference);
	}
	
	protected FeatureScopes getFeatureScopes() {
		return featureScopes;
	}

	public boolean isBatchScopeable(EReference reference) {
		return isConstructorCallScope(reference) || isFeatureCallScope(reference);
	}

}
