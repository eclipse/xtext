/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SimpleLocalScopeProvider extends AbstractGlobalScopeDelegatingScopeProvider {

	public IScope getScope(EObject context, final EReference reference) {
		final IResourceDescription resourceDescription = getResourceDescription(context.eResource());
		if (resourceDescription == null) {
			return getGlobalScope(context, reference);
		}
		return new ResourceDescriptionBasedScope(getGlobalScope(context, reference), resourceDescription, reference.getEReferenceType());
	}

}
