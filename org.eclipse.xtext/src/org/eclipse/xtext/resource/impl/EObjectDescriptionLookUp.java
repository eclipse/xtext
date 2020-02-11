/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class EObjectDescriptionLookUp implements ISelectable {
	
	private volatile Map<QualifiedName, List<IEObjectDescription>> nameToObjects;
	
	private volatile List<IEObjectDescription> allDescriptions;

	public EObjectDescriptionLookUp(List<IEObjectDescription> allDescriptions) {
		setExportedObjects(allDescriptions);
	}
	
	@Override
	public boolean isEmpty() {
		return allDescriptions.isEmpty();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
		if (allDescriptions.isEmpty())
			return Collections.emptyList();
		return Iterables.filter(allDescriptions, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				return EcoreUtil2.isAssignableFrom(type, input.getEClass());
			}
		});
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		if (allDescriptions.isEmpty())
			return Collections.emptyList();
		final URI uri = EcoreUtil2.getPlatformResourceOrNormalizedURI(object);
		return Iterables.filter(allDescriptions, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				if (input.getEObjectOrProxy() == object)
					return true;
				if (uri.equals(input.getEObjectURI())) {
					return true;
				}
				return false;
			}
		});
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name, boolean ignoreCase) {
		if (allDescriptions.isEmpty())
			return Collections.emptyList();
		QualifiedName lowerCase = name.toLowerCase();
		List<IEObjectDescription> values = getNameToObjects().get(lowerCase);
		if (values == null)
			return Collections.emptyList();
		Predicate<IEObjectDescription> predicate = ignoreCase 
			?	new Predicate<IEObjectDescription>() {
					@Override
					public boolean apply(IEObjectDescription input) {
						return EcoreUtil2.isAssignableFrom(type, input.getEClass());
					}
				}
			:	new Predicate<IEObjectDescription>() {
				@Override
				public boolean apply(IEObjectDescription input) {
					return name.equals(input.getName()) && EcoreUtil2.isAssignableFrom(type, input.getEClass());
				}
			};
		return Iterables.filter(values, predicate);
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		return allDescriptions;
	}

	public void setExportedObjects(List<IEObjectDescription> allDescriptions) {
		synchronized (this) {
			this.allDescriptions = allDescriptions;
			this.nameToObjects = null;			
		}
	}

	protected Map<QualifiedName, List<IEObjectDescription>> getNameToObjects() {
		if (nameToObjects == null) {
			synchronized (this) {
				if (nameToObjects == null) {
					Map<QualifiedName, List<IEObjectDescription>> nameToObjects = Maps.newHashMapWithExpectedSize(allDescriptions.size());
					if (allDescriptions instanceof RandomAccess) {
						for(int i = 0; i < allDescriptions.size(); i++) {
							IEObjectDescription description = allDescriptions.get(i);
							putIntoMap(nameToObjects, description);
						}
					} else {
						for(IEObjectDescription description: allDescriptions) {
							putIntoMap(nameToObjects, description);
						}
					}
					this.nameToObjects = nameToObjects; 
				}
			}
		}
		return this.nameToObjects;
	}

	protected void putIntoMap(Map<QualifiedName, List<IEObjectDescription>> nameToObjects,
			IEObjectDescription description) {
		QualifiedName indexKey = description.getName().toLowerCase();
		List<IEObjectDescription> values = nameToObjects.get(indexKey);
		if (values == null) {
			values = Lists.newArrayListWithExpectedSize(2);
			nameToObjects.put(indexKey, values);
		}
		values.add(description);
	}

}
