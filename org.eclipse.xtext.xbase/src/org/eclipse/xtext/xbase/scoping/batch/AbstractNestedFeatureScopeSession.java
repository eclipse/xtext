/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * An abstract nested feature scope session.
 * Delegates all queries to its parent.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO toString
 * TODO more JavaDoc
 */
public abstract class AbstractNestedFeatureScopeSession extends AbstractFeatureScopeSession {
	
	private final AbstractFeatureScopeSession parent;
	private final FeatureScopes featureScopes;
	private final ConstructorScopes constructorScopes;
	private final TypeScopes typeScopes;
	private final IResolvedFeatures.Provider resolvedFeaturesProvider;
	private final int id;

	protected AbstractNestedFeatureScopeSession(AbstractFeatureScopeSession parent) {
		this.parent = parent;
		this.featureScopes = parent.getFeatureScopes();
		this.typeScopes = parent.getTypeScopes();
		this.constructorScopes = parent.getConstructorScopes();
		this.resolvedFeaturesProvider = parent.getResolvedFeaturesProvider();
		this.id = parent.getId() + 1;
	}
	
	@Override
	protected IScopeProvider getDefaultScopeProvider() {
		return parent.getDefaultScopeProvider();
	}

	@Override
	protected FeatureScopes getFeatureScopes() {
		return featureScopes;
	}
	
	@Override
	protected IResolvedFeatures.Provider getResolvedFeaturesProvider() {
		return resolvedFeaturesProvider;
	}
	
	@Override
	protected ConstructorScopes getConstructorScopes() {
		return constructorScopes;
	}
	
	@Override
	protected TypeScopes getTypeScopes() {
		return typeScopes;
	}
	
	protected AbstractFeatureScopeSession getParent() {
		return parent;
	}
	
	@Override
	public IFeatureScopeSession getNextCaptureLayer() {
		return parent.getNextCaptureLayer();
	}
	
	@Override
	public List<JvmDeclaredType> getEnclosingTypes() {
		return parent.getEnclosingTypes();
	}
	
	@Override
	public List<JvmDeclaredType> getNestedTypeDeclarators() {
		return parent.getNestedTypeDeclarators();
	}
	
	/* @Nullable */
	@Override
	public IEObjectDescription getLocalElement(QualifiedName name) {
		return parent.getLocalElement(name);
	}
	
	@Override
	protected void addLocalElements(List<IEObjectDescription> result) {
		parent.addLocalElements(result);
	}
	
	@Override
	public List<TypeBucket> getStaticallyImportedTypes() {
		return parent.getStaticallyImportedTypes();
	}
	
	@Override
	public List<TypeBucket> getStaticallyImportedExtensionTypes() {
		return parent.getStaticallyImportedExtensionTypes();
	}
	
	@Override
	public List<ExpressionBucket> getExtensionProviders() {
		return parent.getExtensionProviders();
	}
	
	@Override
	public boolean isInstanceContext() {
		return parent.isInstanceContext();
	}
	
	@Override
	public boolean isConstructorContext() {
		return parent.isConstructorContext();
	}
	
	@Override
	protected void addExtensionProviders(List<ExpressionBucket> result) {
		parent.addExtensionProviders(result);
	}
	
	@Override
	protected int getId() {
		return id;
	}
	
	@Override
	public boolean isVisible(JvmMember member) {
		return parent.isVisible(member);
	}
	
	@Override
	public boolean isVisible(JvmMember member, /* @Nullable */ LightweightTypeReference receiverType, /* @Nullable */ JvmIdentifiableElement receiverFeature) {
		return parent.isVisible(member, receiverType, receiverFeature);
	}
	
}
