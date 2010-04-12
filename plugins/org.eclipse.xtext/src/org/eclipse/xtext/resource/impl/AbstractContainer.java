/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.ignorecase.IIgnoreCaseContainer;
import org.eclipse.xtext.resource.ignorecase.IIgnoreCaseResourceDescription;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContainer implements IIgnoreCaseContainer {

	public Iterable<IEObjectDescription> findAllEObjects(final EClass type) {
		return Iterables.concat(Iterables.transform(getResourceDescriptions(), new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				return from.getExportedObjects(type);
			}
		}));
	}

	public Iterable<IEObjectDescription> findAllEObjects(final EClass type, final String name) {
		return Iterables.concat(Iterables.transform(getResourceDescriptions(), new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				return from.getExportedObjects(type, name);
			}
		}));
	}
	
	public Iterable<IEObjectDescription> findAllEObjectsIgnoreCase(final EClass type, final String name) {
		return Iterables.concat(Iterables.transform(getResourceDescriptions(), new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				if (from instanceof IIgnoreCaseResourceDescription)
					return ((IIgnoreCaseResourceDescription) from).getExportedObjectsIgnoreCase(type, name);
				return Iterables.filter(from.getExportedObjects(type), new Predicate<IEObjectDescription>() {
					public boolean apply(IEObjectDescription input) {
						return name.equalsIgnoreCase(input.getName());
					}
				});
			}
		}));
	}
	
}
