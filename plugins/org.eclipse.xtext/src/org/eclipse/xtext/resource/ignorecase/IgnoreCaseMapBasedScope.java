/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MultimapBasedScope;

import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * it is assumed, that the keys of the given map are all lower case qualifiedNames.
 * 
 */
public class IgnoreCaseMapBasedScope extends MultimapBasedScope {

	public IgnoreCaseMapBasedScope(IScope parent, Multimap<QualifiedName, IEObjectDescription> descriptions) {
		super(parent, descriptions);
	}
	
	@Override
	protected Object getKey(IEObjectDescription description) {
		return description.getName().toLowerCase();
	}

}
