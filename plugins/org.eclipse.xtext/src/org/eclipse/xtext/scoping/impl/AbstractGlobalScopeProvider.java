/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public abstract class AbstractGlobalScopeProvider implements IGlobalScopeProvider {

	@Inject
	private ResourceDescriptionsProvider provider;

	public IResourceDescriptions getResourceDescriptions(Resource resource) {
		return provider.getResourceDescriptions(resource);
	}

	public void setResourceDescriptionsProvider(ResourceDescriptionsProvider provider) {
		this.provider = provider;
	}
	
	public IScope getScope(Resource context, final EReference reference) {
		return getScope(context,reference,Predicates.<IEObjectDescription>alwaysTrue());
	}
	
	public IScope getScope(Resource context, final EReference reference, Predicate<IEObjectDescription> filter) {
		final Predicate<IEObjectDescription> predicate = filter==null?Predicates.<IEObjectDescription>alwaysTrue():filter;
		return getScope(context, new Predicate<IEObjectDescription>(){
			public boolean apply(IEObjectDescription input) {
				return EcoreUtil2.isAssignableFrom(reference.getEReferenceType(), input.getEClass()) && predicate.apply(input);
			}
		});
	}

	protected IScope getScope(Resource context, Predicate<IEObjectDescription> predicate) {
		return IScope.NULLSCOPE;
	}
}
