/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContainer extends AbstractCompoundSelectable implements IContainer {
	
	@Override
	protected Iterable<IResourceDescription> getSelectables() {
		return getResourceDescriptions();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		URI resourceURI = null;
		if (object.eResource() != null) {
			resourceURI = object.eResource().getURI();
		} else {
			URI uri = EcoreUtil.getURI(object);
			resourceURI = uri.trimFragment();
		}
		IResourceDescription description = getResourceDescription(resourceURI);
		if (description == null)
			return Collections.emptyList();
		return description.getExportedObjectsByObject(object);
	}
	
}
