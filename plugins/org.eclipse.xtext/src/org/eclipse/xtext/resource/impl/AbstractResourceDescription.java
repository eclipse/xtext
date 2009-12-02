/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractResourceDescription implements IResourceDescription {
	
	public Iterable<IEObjectDescription> getExportedObjects(final EClass clazz, final String name) {
		return Iterables.filter(getExportedObjects(), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return (EcoreUtil2.isAssignableFrom(clazz,input.getEClass()))
					&& input.getName().equals(name);
			}
		});
	}

	public Iterable<IEObjectDescription> getExportedObjects(final EClass clazz) {
		return Iterables.filter(getExportedObjects(), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return EcoreUtil2.isAssignableFrom(clazz,input.getEClass());
			}
		});
	}

	public Iterable<IEObjectDescription> getExportedObjectsForEObject(EObject object) {
		final URI uri = EcoreUtil.getURI(object);
		return Iterables.filter(getExportedObjects(), new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return uri.equals(input.getEObjectURI());
			}
		});
	}
}
