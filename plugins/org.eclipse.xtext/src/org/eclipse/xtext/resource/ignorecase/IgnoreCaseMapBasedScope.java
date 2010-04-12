/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import java.util.Map;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.MapBasedScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseMapBasedScope extends MapBasedScope {

	public IgnoreCaseMapBasedScope(IScope parent, Map<String, IEObjectDescription> descriptions) {
		super(parent, descriptions);
	}
	
	@Override
	protected IEObjectDescription getContentByNameImpl(String name) {
		return super.getContentByNameImpl(name.toLowerCase());
	}

}
