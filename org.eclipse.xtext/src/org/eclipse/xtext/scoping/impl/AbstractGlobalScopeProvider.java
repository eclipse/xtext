/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.scoping.ICaseInsensitivityHelper;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public abstract class AbstractGlobalScopeProvider implements IGlobalScopeProvider {

	@Inject
	private IResourceDescriptionsProvider provider;
	
	@Inject
	private ICaseInsensitivityHelper caseInsensitivityHelper;

	public IResourceDescriptions getResourceDescriptions(Resource resource) {
		return provider.getResourceDescriptions(resource.getResourceSet());
	}

	public void setResourceDescriptionsProvider(ResourceDescriptionsProvider provider) {
		this.provider = provider;
	}
	
	public IScope getScope(Resource resource, final EReference reference) {
		return getScope(resource, reference, null);
	}
	
	@Override
	public IScope getScope(Resource resource, final EReference reference, Predicate<IEObjectDescription> filter) {
		return getScope(resource, isIgnoreCase(reference), reference.getEReferenceType(), filter);
	}

	protected IScope getScope(Resource resource, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> predicate) {
		return IScope.NULLSCOPE;
	}
	
	protected boolean isIgnoreCase(EReference reference) {
		return caseInsensitivityHelper.isIgnoreCase(reference);
	}
	
	public void setCaseInsensitivityHelper(ICaseInsensitivityHelper caseInsensitivityHelper) {
		this.caseInsensitivityHelper = caseInsensitivityHelper;
	}
}
