/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Set;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Function;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SimpleScope extends AbstractScope implements Function<IEObjectDescription, IEObjectDescription> {
	
	protected Iterable<IEObjectDescription> descriptions;
	
	public SimpleScope(IScope parent, Iterable<IEObjectDescription> descriptions) {
		super(parent);
		this.descriptions = descriptions;
	}
	public SimpleScope(Iterable<IEObjectDescription> descriptions) {
		this(IScope.NULLSCOPE,descriptions);
	}
	
	protected Set<Object> shadowingIndex = null;
	
	@Override
	protected Iterable<IEObjectDescription> trackKeys(Iterable<IEObjectDescription> localElements) {
		shadowingIndex = Sets.newHashSet();
		return transform(localElements, this);
	}
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		boolean filtered = shadowingIndex.contains(getKey(fromParent));
		return filtered;
	}

	@Override
	public Iterable<IEObjectDescription> getLocalElements(final ISelector selector) {
		return selector.applySelector(descriptions);
	}
	
	public IEObjectDescription apply(IEObjectDescription from) {
		shadowingIndex.add(getKey(from));
		return from;
	}


}
