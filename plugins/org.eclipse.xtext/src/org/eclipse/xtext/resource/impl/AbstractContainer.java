/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;

import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Function;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContainer implements IContainer {
	
	public Iterable<IEObjectDescription> getElements(final ISelector selector) {
		return concat(transform(getResourceDescriptions(),new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				return from.getExportedObjects(selector);
			}
		}));
	}
	
	public IEObjectDescription getSingleElement(ISelector selector) {
		Iterator<IEObjectDescription> iterator = getElements(selector).iterator();
		return iterator.hasNext() ? iterator.next() : null;
	}
	
}
