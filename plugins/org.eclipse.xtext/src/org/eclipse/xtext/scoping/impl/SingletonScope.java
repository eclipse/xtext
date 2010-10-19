/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SingletonScope extends AbstractScope {

	private final Collection<IEObjectDescription> singleDescription;
	private final IScope outer;

	public SingletonScope(IEObjectDescription description) {
		this(description, IScope.NULLSCOPE);
	}
	
	public SingletonScope(IEObjectDescription description, IScope outer) {
		this.singleDescription = Collections.singletonList(description);
		this.outer = outer;
	}
	
	public IScope getOuterScope() {
		return outer;
	}

	@Override
	protected Iterable<IEObjectDescription> internalGetContents() {
		return singleDescription;
	}

}
