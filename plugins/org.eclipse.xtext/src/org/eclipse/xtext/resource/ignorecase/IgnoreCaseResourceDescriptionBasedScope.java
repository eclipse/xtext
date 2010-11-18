/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.impl.ResourceDescriptionBasedScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseResourceDescriptionBasedScope extends ResourceDescriptionBasedScope {

	public IgnoreCaseResourceDescriptionBasedScope(IScope parent, IIgnoreCaseResourceDescription description, EClass type) {
		super(parent, description, type);
	}
	

	@Override
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		if (selector instanceof ISelector.SelectByName) {
			QualifiedName name = ((ISelector.SelectByName) selector).getName();
			final Iterable<IEObjectDescription> exportedObjects = getDescription().getExportedObjectsIgnoreCase(getElementType(), name);
			return selector.applySelector(exportedObjects);
		} 
		return super.getLocalElements(selector);
	}
	
	@Override
	protected IIgnoreCaseResourceDescription getDescription() {
		return (IIgnoreCaseResourceDescription) super.getDescription();
	}

}
