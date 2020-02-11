/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * Skeleton implementation for feature scope sessions.
 * 
 * It introduces a simple means to identify the nesting level ({@link #getId()}.
 * Requested scopes for other things that features are delegated 
 * to the {@link #getDefaultScopeProvider() default scope provider}.
 * The concrete scope computation is performed by {@link #getFeatureScopes() a utility}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO toString, more JavaDoc
 */
public abstract class AbstractFeatureScopeSession implements IFeatureScopeSession {

	@Override
	public IScope getScope(EObject context, EReference reference, IResolvedTypes types) {
		if (getFeatureScopes().isFeatureCallScope(reference)) {
			return createFeatureCallScope(context, reference, types);
		} else if (getConstructorScopes().isConstructorCallScope(reference)) {
			return createConstructorScope(context, reference, types);
		} else if (getTypeScopes().isTypeScope(reference)) {
			return createTypeScope(context, reference, types);
		} else {
			return getDefaultScopeProvider().getScope(context, reference);
		}
	}
	
	@Override
	public IFeatureScopeSession addTypesToStaticScope(List<? extends JvmType> staticFeatureProviders,
			List<? extends JvmType> extensionProviders) {
		if (staticFeatureProviders.isEmpty() && extensionProviders.isEmpty())
			return this;
		AbstractNestedFeatureScopeSession result = new FeatureScopeSessionWithStaticTypes(this, staticFeatureProviders, extensionProviders, getResolvedFeaturesProvider());
		return result;
	}
	
	@Override
	public IFeatureScopeSession addImports(ITypeImporter.Client importer) {
		return new TypeImporter().process(this, importer);
	}

	protected abstract IResolvedFeatures.Provider getResolvedFeaturesProvider();
	protected abstract FeatureScopes getFeatureScopes();
	protected abstract ConstructorScopes getConstructorScopes();
	protected abstract TypeScopes getTypeScopes();
	protected abstract IScopeProvider getDefaultScopeProvider();
	
	/**
	 * A simple means to identify the session.
	 */
	protected abstract int getId();

	@Override
	public IFeatureScopeSession addToExtensionScope(Map<XExpression, LightweightTypeReference> extensionProviders) {
		if (extensionProviders.isEmpty())
			return this;
		AbstractNestedFeatureScopeSession result = new FeatureScopeSessionWithDynamicExtensions(this, extensionProviders, getResolvedFeaturesProvider());
		return result;
	}
	
	@Override
	public IFeatureScopeSession addNestedTypesToScope(JvmDeclaredType type) {
		return new FeatureScopeSessionWithNestedTypes(this, type);
	}
	
	@Override
	public List<JvmDeclaredType> getEnclosingTypes() {
		return Collections.emptyList();
	}
	
	@Override
	public List<JvmDeclaredType> getNestedTypeDeclarators() {
		return Collections.emptyList();
	}
	
	@Override
	public IFeatureScopeSession getNextCaptureLayer() {
		return null;
	}
	
	@Override
	public IFeatureScopeSession toInstanceContext() {
		return new InstanceFeatureScopeSession(this);
	}
	
	@Override
	public IFeatureScopeSession toConstructorContext() {
		return new ConstructorFeatureScopeSession(this);
	}
	
	@Override
	public IFeatureScopeSession dropLocalElements() {
		return new FeatureScopeSessionWithoutLocalElements(this);
	}
	
	@Override
	public IFeatureScopeSession captureLocalElements() {
		return new FeatureScopeSessionWithCapturedLocalElements(this);
	}

	@Override
	public IFeatureScopeSession addLocalElement(QualifiedName name, JvmIdentifiableElement element, ITypeReferenceOwner owner) {
		IFeatureScopeSession result = addLocalElements(Collections.singletonMap(name, element), owner);
		return result;
	}
	
	@Override
	public IFeatureScopeSession addLocalElements(Map<QualifiedName, JvmIdentifiableElement> elements, ITypeReferenceOwner owner) {
		if (elements.isEmpty())
			return this;
		AbstractNestedFeatureScopeSession result = tryCreateNestedSessionWithVisibilityContext(elements, owner, IFeatureNames.THIS);
		if (result != null)
			return result;
		result = tryCreateNestedSessionWithVisibilityContext(elements, owner, IFeatureNames.SELF);
		if (result != null)
			return result;
		result = new FeatureScopeSessionWithLocalElements(this, elements);
		return result;
	}

	/* @Nullable */
	protected AbstractNestedFeatureScopeSession tryCreateNestedSessionWithVisibilityContext(Map<QualifiedName, JvmIdentifiableElement> elements, ITypeReferenceOwner owner,
			QualifiedName thisName) {
		if (elements.containsKey(thisName)) {
			JvmIdentifiableElement associatedWithThis = elements.get(thisName);
			if (associatedWithThis instanceof JvmType) {
				if (IFeatureNames.SELF.equals(thisName)) {
					IEObjectDescription thisDescription = getLocalElement(IFeatureNames.THIS);
					if (thisDescription != null && thisDescription.getEObjectOrProxy() instanceof JvmDeclaredType) {
						JvmDeclaredType thisType = (JvmDeclaredType) thisDescription.getEObjectOrProxy();
						LightweightTypeReference context = owner.toPlainTypeReference((JvmType) associatedWithThis);
						FeatureScopeSessionWithContext contextSession = new FeatureScopeSessionWithContext(this, context, thisType.getPackageName());
						AbstractNestedFeatureScopeSession result = new FeatureScopeSessionWithLocalElements(contextSession, elements);
						return result;
					}
				}
				LightweightTypeReference context = owner.toPlainTypeReference((JvmType) associatedWithThis);
				FeatureScopeSessionWithContext contextSession = new FeatureScopeSessionWithContext(this, context);
				AbstractNestedFeatureScopeSession result = new FeatureScopeSessionWithLocalElements(contextSession, elements);
				return result;
			}
		}
		return null;
	}

	protected IScope createFeatureCallScope(EObject context, EReference reference, IResolvedTypes resolvedTypes) {
		return getFeatureScopes().createFeatureCallScope(context, reference, this, resolvedTypes);
	}
	
	protected IScope createConstructorScope(EObject context, EReference reference, IResolvedTypes resolvedTypes) {
		return getConstructorScopes().createConstructorScope(context, reference, this, resolvedTypes);
	}
	
	protected IScope createTypeScope(EObject context, EReference reference, IResolvedTypes resolvedTypes) {
		return getTypeScopes().createTypeScope(context, reference, this, resolvedTypes);
	}
	
	@Override
	public List<IEObjectDescription> getLocalElements() {
		List<IEObjectDescription> result = Lists.newArrayListWithCapacity(3);
		addLocalElements(result);
		return result;
	}
	
	/**
	 * @param result the list of all local elements. Shadowing semantics do not have to be applied. 
	 */
	protected void addLocalElements(List<IEObjectDescription> result) {
	}
	
	@Override
	public List<TypeBucket> getStaticallyImportedTypes() {
		return Collections.emptyList();
	}
	
	@Override
	public List<TypeBucket> getStaticallyImportedExtensionTypes() {
		return Collections.emptyList();
	}
	
	@Override
	public List<ExpressionBucket> getExtensionProviders() {
		return Collections.emptyList();
	}
	
	/**
	 * @param result an aggregating parameter that accepts the extension providers.
	 */
	protected void addExtensionProviders(List<ExpressionBucket> result) {
	}
	
}
