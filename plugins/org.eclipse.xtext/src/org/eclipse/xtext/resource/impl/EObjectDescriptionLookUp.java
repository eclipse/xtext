/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EObjectDescriptionLookUp {
	
	private volatile Multimap<String, IEObjectDescription> nameToObjects;
	
	private volatile List<IEObjectDescription> allDescriptions;

	public EObjectDescriptionLookUp(List<IEObjectDescription> allDescriptions) {
		setExportedObjects(allDescriptions);
	}
	
	public Iterable<IEObjectDescription> getExportedObjects(final EClass clazz, final String name) {
		if (allDescriptions.isEmpty())
			return Iterables.emptyIterable();
		if (getNameToObjects().containsKey(name))
			return Iterables.filter(getNameToObjects().get(name), new Predicate<IEObjectDescription>() {
				public boolean apply(IEObjectDescription input) {
					return EcoreUtil2.isAssignableFrom(clazz,input.getEClass());
				}
			});
		else
			return Iterables.emptyIterable();
	}

	public Iterable<IEObjectDescription> getExportedObjects(final EClass clazz) {
		if (allDescriptions.isEmpty())
			return Iterables.emptyIterable();
		return Iterables.filter(allDescriptions, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return EcoreUtil2.isAssignableFrom(clazz,input.getEClass());
			}
		});
	}

	public Iterable<IEObjectDescription> getExportedObjectsForEObject(EObject object) {
		if (allDescriptions.isEmpty())
			return Iterables.emptyIterable();
		final URI uri = EcoreUtil.getURI(object);
		return Iterables.filter(allDescriptions, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return uri.equals(input.getEObjectURI());
			}
		});
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		return allDescriptions;
	}

	public void setExportedObjects(List<IEObjectDescription> allDescriptions) {
		synchronized (this) {
			this.allDescriptions = allDescriptions;
			this.nameToObjects = null;			
		}
	}

	protected Multimap<String, IEObjectDescription> getNameToObjects() {
		if (nameToObjects == null) {
			synchronized (this) {
				if (nameToObjects == null) {
					this.nameToObjects = Multimaps.unmodifiableMultimap(Multimaps.index(allDescriptions, new Function<IEObjectDescription, String>() {
						public String apply(IEObjectDescription from) {
							return from.getName();
						}
					}));
				}
			}
		}
		return nameToObjects;
	}
}
