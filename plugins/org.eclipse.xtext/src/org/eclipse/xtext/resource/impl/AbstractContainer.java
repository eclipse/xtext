/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContainer implements IContainer {
	
	public boolean isEmpty() {
		return Iterables.isEmpty(getResourceDescriptions());
	}
	
	public Iterable<IEObjectDescription> getExportedObjects() {
		return Iterables.concat(Iterables.transform(getResourceDescriptions(), new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				if (from != null)
					return from.getExportedObjects();
				return Collections.emptyList();
			}
		}));
	}
	
	public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
		return Iterables.concat(Iterables.transform(getResourceDescriptions(), new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				if (from != null)
					return from.getExportedObjectsByType(type);
				return Collections.emptyList();
			}
		}));
	}
	
	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		URI uri = EcoreUtil.getURI(object);
		IResourceDescription description = getResourceDescription(uri);
		if (description == null)
			return Collections.emptyList();
		return description.getExportedObjectsByObject(object);
	}
	
	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName qualifiedName, final boolean ignoreCase) {
		return Iterables.concat(Iterables.transform(getResourceDescriptions(), new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				if (from != null)
					return from.getExportedObjects(type, qualifiedName, ignoreCase);
				return Collections.emptyList();
			}
		}));
	}
	
}
