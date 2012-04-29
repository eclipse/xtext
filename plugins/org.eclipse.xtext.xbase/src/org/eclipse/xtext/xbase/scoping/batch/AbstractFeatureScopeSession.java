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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractFeatureScopeSession implements IFeatureScopeSession {

	public IScope getScope(XExpression expression, EReference reference, IResolvedTypes types) {
		if (getFeatureScopeProvider().isFeatureCallScope(reference)) {
			return createFeatureCallScope(expression, reference, types);
		} else {
			return getScopeProvider().getScope(expression, reference);
		}
	}
	
	public IFeatureScopeSession addTypesToStaticScope(List<JvmType> staticFeatureProviders,
			List<JvmType> extensionProviders) {
		if (staticFeatureProviders.isEmpty() && extensionProviders.isEmpty())
			return this;
		FeatureScopeSession result = new FeatureScopeSessionWithStaticTypes(this, getFeatureScopeProvider(), staticFeatureProviders, extensionProviders);
		return result;
	}

	protected abstract FeatureScopeProvider getFeatureScopeProvider();
	protected abstract IScopeProvider getScopeProvider();
	protected abstract int getId();

	public IFeatureScopeSession addToExtensionScope(JvmIdentifiableElement baseElement, List<XExpression> extensionProviders) {
		if (extensionProviders.isEmpty())
			return this;
		FeatureScopeSession result = new FeatureScopeSessionWithDynamicExtensions(this, getFeatureScopeProvider(), baseElement, extensionProviders);
		return result;
	}

	public IFeatureScopeSession addLocalElement(QualifiedName name, JvmIdentifiableElement element) {
		IFeatureScopeSession result = addLocalElements(Collections.singletonMap(name, element));
		return result;
	}
	
	public IFeatureScopeSession addLocalElements(Map<QualifiedName, JvmIdentifiableElement> elements) {
		if (elements.isEmpty())
			return this;
		FeatureScopeSession result = new FeatureScopeSessionWithLocalElements(this, getFeatureScopeProvider(), elements);
		return result;
	}

	public IScope createFeatureCallScope(EObject context, EReference reference, IResolvedTypes resolvedTypes) {
		return getFeatureScopeProvider().createFeatureCallScope(context, reference, this, resolvedTypes);
	}
	
	public Collection<IEObjectDescription> getLocalElements() {
		List<IEObjectDescription> result = Lists.newArrayList();
		addLocalElements(result);
		return result;
	}

	/**
	 * @param result the list of all local elements. Shadowing semantics does not have to be applied. 
	 */
	protected void addLocalElements(List<IEObjectDescription> result) {
	}
	
	public List<TypeBucket> getStaticallyImportedTypes() {
		return Collections.emptyList();
	}
	
	public List<TypeBucket> getStaticallyImportedExtensionTypes() {
		return Collections.emptyList();
	}
	
	public IFeatureScopeSession recursiveInitialize(EObject context) {
		return this;
	}
	
}
