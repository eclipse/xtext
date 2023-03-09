/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

/**
 * A scope implemented using a {@link Multimap}. 
 * 
 * This implementation assumes, that the keys of the {@link Multimap} are the keys of the contained {@link org.eclipse.xtext.resource.EObjectDescription}s
 * as well as the name.
 * 
 * When looking up elements using {@link #getElements(QualifiedName)} this implementation looks up the elements from the map, hence are much 
 * more efficient for many {@link IEObjectDescription}s.
 *   
 * @author Sven Efftinge - Initial contribution and API 
 * @author Sebastian Zarnekow
 */
public class MultimapBasedScope extends AbstractScope {

	public static IScope createScope(IScope parent, Iterable<IEObjectDescription> descriptions, boolean ignoreCase) {
		Multimap<QualifiedName, IEObjectDescription> map = null;
		for(IEObjectDescription description: descriptions) {
			if (map == null)
				map = LinkedHashMultimap.create(5,2);
			if (ignoreCase)
				map.put(description.getName().toLowerCase(), description);
			else
				map.put(description.getName(), description);
		}
		if (map == null || map.isEmpty()) {
			return parent;
		}
		return new MultimapBasedScope(parent, map, ignoreCase);
	}
	
	private Multimap<QualifiedName, IEObjectDescription> elements;

	protected MultimapBasedScope(IScope parent, Multimap<QualifiedName, IEObjectDescription> elements, boolean ignoreCase) {
		super(parent, ignoreCase);
		this.elements = elements;
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return elements.values();
	}

	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		QualifiedName query = name;
		if (isIgnoreCase()) {
			query = name.toLowerCase();
		}
		if (elements.containsKey(query)) {
			Collection<IEObjectDescription> result = elements.get(query);
			return result;
		}
		return Collections.emptyList();
	}
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		QualifiedName name = fromParent.getName();
		if (isIgnoreCase()) {
			name = name.toLowerCase();
		}
		boolean result = elements.containsKey(name);
		return result;
	}

//	public Multimap<QualifiedName, IEObjectDescription> getMap() {
//		return elements;
//	}
	
}
