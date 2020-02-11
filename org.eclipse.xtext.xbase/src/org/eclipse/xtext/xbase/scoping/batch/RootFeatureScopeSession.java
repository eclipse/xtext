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

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;

import com.google.inject.Inject;

/**
 * The root session. It is save to be used by various child sessions
 * since it will never return something except empty lists.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RootFeatureScopeSession extends AbstractFeatureScopeSession {

	@Inject
	private FeatureScopes featureScopes;
	
	@Inject
	private ConstructorScopes constructorScopes;
	
	@Inject
	private IResolvedFeatures.Provider resolvedFeaturesProvider;
	
	@Inject
	private TypeScopes typeScopes;
	
	@Inject
	private IScopeProvider scopeProvider;
	
	@Inject
	private IVisibilityHelper visibilityHelper;

	@Override
	protected FeatureScopes getFeatureScopes() {
		return featureScopes;
	}
	
	@Override
	protected IResolvedFeatures.Provider getResolvedFeaturesProvider() {
		return resolvedFeaturesProvider;
	}
	
	@Override
	protected TypeScopes getTypeScopes() {
		return typeScopes;
	}
	
	@Override
	protected ConstructorScopes getConstructorScopes() {
		return constructorScopes;
	}
	
	@Override
	protected IScopeProvider getDefaultScopeProvider() {
		return scopeProvider;
	}

	/* @Nullable */
	@Override
	public IEObjectDescription getLocalElement(QualifiedName name) {
		return null;
	}
	
	@Override
	public List<IEObjectDescription> getLocalElements() {
		return Collections.emptyList();
	}
	
	@Override
	protected int getId() {
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * By default, a session is not an instance context.
	 */
	@Override
	public boolean isInstanceContext() {
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * By default, a session is not a constructor context.
	 */
	@Override
	public boolean isConstructorContext() {
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * By default, all public features are considered to be accessible.
	 */
	@Override
	public boolean isVisible(JvmMember member) {
		return visibilityHelper.isVisible(member);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * By default, all public features are considered to be accessible.
	 */
	@Override
	public boolean isVisible(JvmMember member, /* @Nullable */ LightweightTypeReference receiverType, /* @Nullable */ JvmIdentifiableElement receiverFeature) {
		return visibilityHelper.isVisible(member);
	}
	
}
