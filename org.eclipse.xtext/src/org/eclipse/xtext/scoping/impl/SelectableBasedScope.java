/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SelectableBasedScope extends AbstractScope {
	
	public static IScope createScope(IScope outer, ISelectable selectable, EClass type, boolean ignoreCase) {
		return createScope(outer, selectable, null, type, ignoreCase);
	}
	
	public static IScope createScope(IScope outer, ISelectable selectable, Predicate<IEObjectDescription> filter, EClass type, boolean ignoreCase) {
		if (selectable == null || selectable.isEmpty())
			return outer;
		return new SelectableBasedScope(outer, selectable, filter, type, ignoreCase);
	}
	
	private final Predicate<IEObjectDescription> filter;
	private final ISelectable selectable;
	private final EClass type;

	protected SelectableBasedScope(IScope outer, ISelectable selectable, Predicate<IEObjectDescription> filter, EClass type, boolean ignoreCase) {
		super(outer, ignoreCase);
		this.filter = filter;
		this.selectable = selectable;
		this.type = type;
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
		Iterable<IEObjectDescription> unfiltered = selectable.getExportedObjects(type, name, isIgnoreCase());
		return filterLocalElements(unfiltered);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		Iterable<IEObjectDescription> unfiltered = selectable.getExportedObjectsByType(type);
		return filterLocalElements(unfiltered);
	}
	
	protected ISelectable getSelectable() {
		return selectable;
	}
	
	protected Predicate<IEObjectDescription> getFilter() {
		return filter;
	}
	
	protected Iterable<IEObjectDescription> filterLocalElements(Iterable<IEObjectDescription> unfiltered) {
		if (filter != null) {
			Iterable<IEObjectDescription> result = Iterables.filter(unfiltered, filter);
			return result;
		}
		return unfiltered;
	}

}