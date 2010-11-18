/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.ignorecase;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseSimpleScope extends SimpleScope {

	public IgnoreCaseSimpleScope(IScope outer, Iterable<IEObjectDescription> elements) {
		super(outer, elements);
	}
	
	public IgnoreCaseSimpleScope(final Iterable<IEObjectDescription> elements) {
		this(IScope.NULLSCOPE, elements);
	}
	
	@Override
	protected Object getKey(IEObjectDescription description) {
		return description.getName().toLowerCase();
	}
	
}
