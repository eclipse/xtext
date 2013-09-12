/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * An abstract nested feature scope session.
 * Delegates all queries to its parent.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO toString
 * TODO more JavaDoc
 */
@NonNullByDefault
public abstract class AbstractNestedFeatureScopeSession extends AbstractFeatureScopeSession {
	
	private final AbstractFeatureScopeSession parent;
	private final FeatureScopes featureScopes;
	private final ConstructorScopes constructorScopes;
	private final TypeScopes typeScopes;
	private final CommonTypeComputationServices commonServices;
	private int id;

	protected AbstractNestedFeatureScopeSession(AbstractFeatureScopeSession parent) {
		this.parent = parent;
		this.featureScopes = parent.getFeatureScopes();
		this.typeScopes = parent.getTypeScopes();
		this.constructorScopes = parent.getConstructorScopes();
		this.commonServices = parent.getCommonTypeComputationServices();
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
	protected CommonTypeComputationServices getCommonTypeComputationServices() {
		return commonServices;
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
	
	@Nullable
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
	
	public boolean isInstanceContext() {
		return parent.isInstanceContext();
	}
	
	@Override
	protected void addExtensionProviders(List<ExpressionBucket> result) {
		parent.addExtensionProviders(result);
	}
	
	@Override
	protected int getId() {
		return id;
	}
	
	public boolean isVisible(JvmMember member) {
		return parent.isVisible(member);
	}
	
	public boolean isVisible(JvmMember member, @Nullable JvmIdentifiableElement receiverFeature) {
		return parent.isVisible(member, receiverFeature);
	}
	
}
