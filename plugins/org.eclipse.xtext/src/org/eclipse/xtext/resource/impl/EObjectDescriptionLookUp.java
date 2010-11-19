/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class EObjectDescriptionLookUp {
	
	private volatile Multimap<QualifiedName, IEObjectDescription> nameToObjects;
	
	private volatile List<IEObjectDescription> allDescriptions;

	public EObjectDescriptionLookUp(List<IEObjectDescription> allDescriptions) {
		setExportedObjects(allDescriptions);
	}
	
	public Iterable<IEObjectDescription> getExportedObjects(ISelector selector) {
		if (allDescriptions.isEmpty())
			return Collections.emptyList();
		if (selector instanceof ISelector.SelectByName) {
			final QualifiedName qualifiedName = ((ISelector.SelectByName) selector).getName().toLowerCase();
			if (getNameToObjects().containsKey(qualifiedName))
				return selector.applySelector(getNameToObjects().get(qualifiedName));
			else
				return Collections.emptyList();
		}
		return selector.applySelector(getExportedObjects());
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

	protected Multimap<QualifiedName, IEObjectDescription> getNameToObjects() {
		if (nameToObjects == null) {
			synchronized (this) {
				if (nameToObjects == null) {
					this.nameToObjects  = Multimaps.index(allDescriptions, new Function<IEObjectDescription, QualifiedName>() {
						public QualifiedName apply(IEObjectDescription from) {
							return from.getName().toLowerCase();
						}
					});
				}
			}
		}
		return nameToObjects;
	}
}
