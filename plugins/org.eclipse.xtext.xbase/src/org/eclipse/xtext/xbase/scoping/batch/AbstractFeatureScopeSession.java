/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

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
@NonNullByDefault
public abstract class AbstractFeatureScopeSession implements IFeatureScopeSession {

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
	
	public IFeatureScopeSession addTypesToStaticScope(List<JvmType> staticFeatureProviders,
			List<JvmType> extensionProviders) {
		if (staticFeatureProviders.isEmpty() && extensionProviders.isEmpty())
			return this;
		AbstractNestedFeatureScopeSession result = new FeatureScopeSessionWithStaticTypes(this, staticFeatureProviders, extensionProviders);
		return result;
	}

	protected abstract FeatureScopes getFeatureScopes();
	protected abstract ConstructorScopes getConstructorScopes();
	protected abstract TypeScopes getTypeScopes();
	protected abstract IScopeProvider getDefaultScopeProvider();
	
	/**
	 * A simple means to identify the session.
	 */
	protected abstract int getId();

	public IFeatureScopeSession addToExtensionScope(List<XExpression> extensionProviders) {
		if (extensionProviders.isEmpty())
			return this;
		AbstractNestedFeatureScopeSession result = new FeatureScopeSessionWithDynamicExtensions(this, extensionProviders);
		return result;
	}

	public IFeatureScopeSession addLocalElement(QualifiedName name, JvmIdentifiableElement element) {
		IFeatureScopeSession result = addLocalElements(Collections.singletonMap(name, element));
		return result;
	}
	
	public IFeatureScopeSession addLocalElements(Map<QualifiedName, JvmIdentifiableElement> elements) {
		if (elements.isEmpty())
			return this;
		if (elements.containsKey(IFeatureNames.THIS)) {
			JvmIdentifiableElement associatedWithThis = elements.get(IFeatureNames.THIS);
			if (associatedWithThis instanceof JvmType) {
				FeatureScopeSessionWithContext contextSession = new FeatureScopeSessionWithContext(this, (JvmType) associatedWithThis);
				AbstractNestedFeatureScopeSession result = new FeatureScopeSessionWithLocalElements(contextSession, elements);
				return result;
			}
		}
		AbstractNestedFeatureScopeSession result = new FeatureScopeSessionWithLocalElements(this, elements);
		return result;
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
	
	public Collection<IEObjectDescription> getLocalElements() {
		List<IEObjectDescription> result = Lists.newArrayList();
		addLocalElements(result);
		return result;
	}

	/**
	 * @param result the list of all local elements. Shadowing semantics do not have to be applied. 
	 */
	protected void addLocalElements(List<IEObjectDescription> result) {
	}
	
	public List<TypeBucket> getStaticallyImportedTypes() {
		return Collections.emptyList();
	}
	
	public List<TypeBucket> getStaticallyImportedExtensionTypes() {
		return Collections.emptyList();
	}
	
}
