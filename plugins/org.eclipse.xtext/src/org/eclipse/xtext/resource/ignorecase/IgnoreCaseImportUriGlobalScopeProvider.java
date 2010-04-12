/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseImportUriGlobalScopeProvider extends ImportUriGlobalScopeProvider {

	@Override
	protected IScope createLazyResourceScope(IScope parent, URI uri, IResourceDescriptions descriptions,
			EReference reference) {
		IResourceDescription description = descriptions.getResourceDescription(uri);
		if (description == null)
			return parent;
		if (description instanceof IIgnoreCaseResourceDescription)
			return new IgnoreCaseResourceDescriptionBasedScope(parent, (IIgnoreCaseResourceDescription) description, reference.getEReferenceType());
		return super.createLazyResourceScope(parent, uri, descriptions, reference);
	}
	
}
