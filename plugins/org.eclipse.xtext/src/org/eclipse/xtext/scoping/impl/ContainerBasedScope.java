/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Predicate;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContainerBasedScope extends AbstractScope {
	
	private final Predicate<IEObjectDescription> filter;
	private final IContainer container;

	public ContainerBasedScope(IScope outer, Predicate<IEObjectDescription> filter, IContainer container) {
		super(outer);
		this.filter = filter;
		this.container = container;
	}
	
	@Override
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		return filter(container.getElements(selector), filter);
	}
	
	protected IContainer getContainer() {
		return container;
	}
	
	protected Predicate<IEObjectDescription> getFilter() {
		return filter;
	}

}