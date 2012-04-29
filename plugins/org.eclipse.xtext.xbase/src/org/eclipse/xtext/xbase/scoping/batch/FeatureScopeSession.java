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
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureScopeSession extends AbstractFeatureScopeSession {
	
	private final AbstractFeatureScopeSession parent;
	private final FeatureScopeProvider featureScopeProvider;
	private int id;

	public FeatureScopeSession(AbstractFeatureScopeSession parent, FeatureScopeProvider featureScopeProvider) {
		this.parent = parent;
		this.featureScopeProvider = featureScopeProvider;
		this.id = parent.getId() + 1;
	}
	
	@Override
	protected IScopeProvider getScopeProvider() {
		return parent.getScopeProvider();
	}

	@Override
	protected FeatureScopeProvider getFeatureScopeProvider() {
		return featureScopeProvider;
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
	protected int getId() {
		return id;
	}
	
}
