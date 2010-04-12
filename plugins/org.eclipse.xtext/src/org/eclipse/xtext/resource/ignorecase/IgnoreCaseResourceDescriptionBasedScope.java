/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ResourceDescriptionBasedScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseResourceDescriptionBasedScope extends ResourceDescriptionBasedScope {

	public IgnoreCaseResourceDescriptionBasedScope(IScope parent, IIgnoreCaseResourceDescription description, EClass type) {
		super(parent, description, type);
	}
	
	@Override
	public IEObjectDescription getContentByName(String name) {
		Iterable<IEObjectDescription> objects = getDescription().getExportedObjectsIgnoreCase(getElementType(), name);
		Iterator<IEObjectDescription> iter = objects.iterator();
		if (iter.hasNext()) {
			IEObjectDescription result = iter.next();
			if (!iter.hasNext())
				return result;
		}
		return getOuterScope().getContentByName(name);
	}
	
	@Override
	protected IIgnoreCaseResourceDescription getDescription() {
		return (IIgnoreCaseResourceDescription) super.getDescription();
	}

}
