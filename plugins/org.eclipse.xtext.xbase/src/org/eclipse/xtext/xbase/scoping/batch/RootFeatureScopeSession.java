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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;

/**
 * The root session. It is save to be used by various child sessions
 * since it will never return something except empty lists.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class RootFeatureScopeSession extends AbstractFeatureScopeSession {

	@Inject
	private FeatureScopes featureScopes;
	
	@Inject
	private ConstructorScopes constructorScopes;
	
	@Inject
	private TypeScopes typeScopes;
	
	@Inject
	private IScopeProvider scopeProvider;

	@Override
	protected FeatureScopes getFeatureScopes() {
		return featureScopes;
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

	@Nullable
	public IEObjectDescription getLocalElement(QualifiedName name) {
		return null;
	}
	
	@Override
	public Collection<IEObjectDescription> getLocalElements() {
		return Collections.emptyList();
	}
	
	@Override
	protected int getId() {
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * By default, all public features are considered to be accessible.
	 */
	public boolean isVisible(JvmFeature feature) {
		return feature.getVisibility() == JvmVisibility.PUBLIC;
	}
	
}
