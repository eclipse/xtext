/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Set;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class SimpleScope extends AbstractScope {
	
	private final Iterable<IEObjectDescription> descriptions;
	
	protected Set<Object> shadowingIndex;
	
	public SimpleScope(IScope parent, Iterable<IEObjectDescription> descriptions, boolean ignoreCase) {
		super(parent, ignoreCase);
		if (descriptions == null)
			throw new IllegalArgumentException("descriptions may not be null");
		this.descriptions = descriptions;
	}
	
	public SimpleScope(IScope parent, Iterable<IEObjectDescription> descriptions) {
		this(parent, descriptions, false);
	}
	
	public SimpleScope(Iterable<IEObjectDescription> descriptions, boolean ignoreCase) {
		this(IScope.NULLSCOPE, descriptions, ignoreCase);
	}
	
	public SimpleScope(Iterable<IEObjectDescription> descriptions) {
		this(IScope.NULLSCOPE, descriptions, false);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return descriptions;
	}
	
	/**
	 * @return the key of the given description, which makes it shadowing others
	 */
	protected Object getShadowingKey(IEObjectDescription description) {
		if (isIgnoreCase())
			return description.getName().toLowerCase();
		return description.getName();
	}
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		if (shadowingIndex == null) {
			shadowingIndex = Sets.newHashSet();
			for(IEObjectDescription local: getAllLocalElements()) {
				shadowingIndex.add(getShadowingKey(local));
			}
		}
		boolean result = shadowingIndex.contains(getShadowingKey(fromParent));
		return result;
	}

}
