/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractCompoundSelectable implements ISelectable {

	@Override
	public boolean isEmpty() {
		return Iterables.isEmpty(getSelectables());
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		return Iterables.concat(Iterables.transform(getSelectables(), new Function<ISelectable, Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> apply(ISelectable from) {
				if (from != null)
					return from.getExportedObjects();
				return Collections.emptyList();
			}
		}));
	}
	
	protected abstract Iterable<? extends ISelectable> getSelectables();

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
		return Iterables.concat(Iterables.transform(getSelectables(), new Function<ISelectable, Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> apply(ISelectable from) {
				if (from != null)
					return from.getExportedObjectsByType(type);
				return Collections.emptyList();
			}
		}));
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(final EObject object) {
		return Iterables.concat(Iterables.transform(getSelectables(), new Function<ISelectable, Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> apply(ISelectable from) {
				if (from != null)
					return from.getExportedObjectsByObject(object);
				return Collections.emptyList();
			}
		}));
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName qualifiedName, final boolean ignoreCase) {
		return Iterables.concat(Iterables.transform(getSelectables(), new Function<ISelectable, Iterable<IEObjectDescription>>() {
			@Override
			public Iterable<IEObjectDescription> apply(ISelectable from) {
				if (from != null)
					return from.getExportedObjects(type, qualifiedName, ignoreCase);
				return Collections.emptyList();
			}
		}));
	}

	
}
