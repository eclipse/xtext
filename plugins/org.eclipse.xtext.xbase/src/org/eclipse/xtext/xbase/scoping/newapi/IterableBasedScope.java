/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.newapi;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IterableBasedScope extends AbstractScope {
	
	protected Set<String> names = null;
	protected Iterable<? extends IEObjectDescription> descriptions;
	
	public IterableBasedScope(Iterable<? extends IEObjectDescription> descriptions, INewScope parent) {
		super(parent);
		this.descriptions = descriptions;
	}
	
	@Override
	protected Iterable<? extends IEObjectDescription> index(Iterable<? extends IEObjectDescription> localElements) {
		HashSet<IEObjectDescription> set = Sets.newHashSet(localElements);
		names = Sets.newHashSet();
		for (IEObjectDescription description : set) {
			names.add(description.getName());
		}
		return set;
	}

	@Override
	protected Iterable<? extends IEObjectDescription> getLocalElements(final ISelector selector) {
		return Iterables.filter(descriptions, new Predicate<IEObjectDescription>(){
			public boolean apply(IEObjectDescription input) {
				return selector.apply(input);
			}});
	}

	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		return names.contains(fromParent.getName());
	}

}
