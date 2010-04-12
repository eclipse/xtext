/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Map;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MapBasedScope extends AbstractScope {

	private IScope parent;
	private Map<String,IEObjectDescription> descriptions;
	
	public MapBasedScope(IScope parent, Map<String, IEObjectDescription> descriptions) {
		this.parent = parent;
		this.descriptions = descriptions;
	}

	@Override
	protected Iterable<IEObjectDescription> internalGetContents() {
		return descriptions.values();
	}

	@Override
	public IEObjectDescription getContentByName(String name) {
		IEObjectDescription ieObjectDescription = getContentByNameImpl(name);
		return ieObjectDescription!=null?ieObjectDescription:parent.getContentByName(name);
	}

	protected IEObjectDescription getContentByNameImpl(String name) {
		return descriptions.get(name);
	}

	public IScope getOuterScope() {
		return parent;
	}

	@Override
	public String toString() {
		return "contains "+descriptions.size()+" elements";
	}

}
