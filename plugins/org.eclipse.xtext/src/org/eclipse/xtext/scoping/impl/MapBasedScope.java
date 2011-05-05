/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * A scope implemented using a {@link Map} used for efficient lookup of ordinary named 
 * {@link org.eclipse.xtext.resource.EObjectDescription EObjectDescriptions}. 
 * 
 * This implementation assumes, that the keys of the {@link Map} correspond to the keys of the contained {@link org.eclipse.xtext.resource.EObjectDescription}.
 * Additionally it assumes, that those keys are equal to <code>description.getName().toLowerCase()</code>.
 * 
 * When looking up elements using {@link ISelector.SelectByName} this implementation looks up the the elements from the map, hence are much 
 * more efficient for many {@link IEObjectDescription}s.  
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class MapBasedScope extends AbstractScope {

	public static IScope createScope(IScope parent, Iterable<IEObjectDescription> descriptions, boolean ignoreCase) {
		Map<QualifiedName, IEObjectDescription> map = null;
		for(IEObjectDescription description: descriptions) {
			if (map == null)
				map = new LinkedHashMap<QualifiedName, IEObjectDescription>(4);
			QualifiedName name = ignoreCase ? description.getName().toLowerCase() : description.getName();
			IEObjectDescription previous = map.put(name, description);
			// we are optimistic that no duplicate names are used
			// however, if the name was already used, the first one should win
			if (previous != null) {
				map.put(name, previous);
			}
		}
		if (map == null || map.isEmpty()) {
			return parent;
		}
		return new MapBasedScope(parent, map, ignoreCase);
	}
	
	public static IScope createScope(IScope parent, Iterable<IEObjectDescription> descriptions) {
		return createScope(parent, descriptions, false);
	}
	
	private Map<QualifiedName, IEObjectDescription> elements;

	protected MapBasedScope(IScope parent, Map<QualifiedName, IEObjectDescription> elements, boolean ignoreCase) {
		super(parent, ignoreCase);
		this.elements = elements;
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return elements.values();
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		IEObjectDescription result = null;
		if (isIgnoreCase()) {
			result = elements.get(name.toLowerCase());
		} else {
			result = elements.get(name);
		}
		if (result == null)
			return Collections.emptyList();
		return Collections.singleton(result);
	}

	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		if (isIgnoreCase()) {
			boolean result = elements.containsKey(fromParent.getName().toLowerCase());
			return result;
		} else {
			boolean result = elements.containsKey(fromParent.getName());
			return result;
		}
	}
}
