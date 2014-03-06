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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.IDelegatingScopeProvider;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

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
			IExpressionScope.Anchor anchor = IExpressionScope.Anchor.BEFORE;
			if (context instanceof XAbstractFeatureCall) {
				EObject proxyOrResolved = (EObject) context.eGet(reference, false);
				if (proxyOrResolved != null && !proxyOrResolved.eIsProxy()) {
					XExpression receiver = ((XAbstractFeatureCall) context).getActualReceiver();
					if (receiver == null && context instanceof XMemberFeatureCall) {
						receiver = ((XMemberFeatureCall) context).getMemberCallTarget();
					}
					if (receiver != null) {
						anchor = IExpressionScope.Anchor.RECEIVER;
						context = receiver;
					}
				} else if (context instanceof XBinaryOperation) {
					context = ((XBinaryOperation) context).getLeftOperand();
					anchor = IExpressionScope.Anchor.RECEIVER;
				}
			}
			IExpressionScope expressionScope = typeResolver.resolveTypes(context).getExpressionScope(context, anchor);
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
		final XImportSection importSection = importsConfig.getImportSection((XtextResource) context);
		if(importSection != null) {
			result = result.addImports(new ITypeImporter.Client() {

				public void doAddImports(ITypeImporter importer) {
					List<XImportDeclaration> imports = importSection.getImportDeclarations();
					for(XImportDeclaration _import: imports) {
						if (_import.isWildcard() && _import.isStatic()) {
							if (_import.isExtension()) {
								importer.importStaticExtension(_import.getImportedType(), false);
							} else {
								importer.importStatic(_import.getImportedType());
							}
						}
					}
				}
				
			});
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
