/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SimpleScope extends AbstractScope {
	
	private final IScope outer;

	private final Iterable<IEObjectDescription> elements;

	public SimpleScope(final IScope outer, final Iterable<IEObjectDescription> elements) {
		this.outer = outer;
		this.elements = elements;
	}
	
	public SimpleScope(final Iterable<IEObjectDescription> elements) {
		this(IScope.NULLSCOPE, elements);
	}

	public IScope getOuterScope() {
		return outer;
	}

	@Override
	public Iterable<IEObjectDescription> internalGetContents() {
		return elements;
	}

}
