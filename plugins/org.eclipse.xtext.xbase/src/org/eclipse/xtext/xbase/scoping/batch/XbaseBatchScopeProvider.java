/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.IDelegatingScopeProvider;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseBatchScopeProvider implements IBatchScopeProvider , IDelegatingScopeProvider  {

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
	
	@Inject
	private IImportsConfiguration importsConfig;
	
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
		if (context == null || context.eResource() == null || context.eResource().getResourceSet() == null) {
			return IScope.NULLSCOPE;
		}
		if (isFeatureCallScope(reference)) {
			IExpressionScope expressionScope = typeResolver.resolveTypes(context).getExpressionScope(context, reference, IExpressionScope.Anchor.BEFORE);
			return expressionScope.getFeatureScope();
		}
		return delegateGetScope(context, reference);
	}
	
	public IFeatureScopeSession newSession(Resource context) {
		List<JvmType> literalClasses = implicitlyImportedTypes.getStaticImportClasses(context);
		List<JvmType> extensionClasses = implicitlyImportedTypes.getExtensionClasses(context);
		IFeatureScopeSession result = rootSession.addTypesToStaticScope(literalClasses, extensionClasses);
		if (context.getContents().isEmpty() || !(context instanceof XtextResource))
			return result;
		XImportSection importSection = importsConfig.getImportSection((XtextResource) context);
		if(importSection != null) {
			List<XImportDeclaration> imports = importSection.getImportDeclarations();
			List<JvmType> staticFeatureProviders = Lists.newArrayListWithCapacity(imports.size() / 2);
			List<JvmType> staticExtensionFeatureProviders = Lists.newArrayListWithCapacity(imports.size() / 2);
			List<JvmType> bogusStaticExtensionFeatureProviders = Lists.newArrayListWithCapacity(imports.size() / 2);
			for(XImportDeclaration _import: imports) {
				if (_import.isWildcard() && _import.isStatic()) {
					if (_import.isExtension()) {
						staticExtensionFeatureProviders.add(_import.getImportedType());
						bogusStaticExtensionFeatureProviders.add(_import.getImportedType());
					} else {
						staticFeatureProviders.add(_import.getImportedType());
					}
				}
			}
			if (!bogusStaticExtensionFeatureProviders.isEmpty()) {
				result = result.addTypesToStaticScope(bogusStaticExtensionFeatureProviders, Collections.<JvmType>emptyList());
			}
			if (!staticFeatureProviders.isEmpty() || !staticExtensionFeatureProviders.isEmpty()) {
				result = result.addTypesToStaticScope(staticFeatureProviders, staticExtensionFeatureProviders);
			}
		}
		return result;
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
