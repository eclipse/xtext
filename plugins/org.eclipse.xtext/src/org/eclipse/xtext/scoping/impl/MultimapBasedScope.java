/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.collect.Multimap;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * A scope implemented using a {@link Multimap}. 
 * 
 * This implementation assumes, that the keys of the {@link Multimap} are the keys of the contained {@link org.eclipse.xtext.resource.EObjectDescription}s
 * as well as the name.
 * 
 * When looking up elements using {@link ISelector.SelectByName} this implementation looks up the the elements from the map, hence are much 
 * more efficient for many {@link IEObjectDescription}s.  
 * 
 */
public class MultimapBasedScope extends AbstractScope {

	private Multimap<QualifiedName, IEObjectDescription> elements;

	public MultimapBasedScope(IScope parent, Multimap<QualifiedName, IEObjectDescription> elements) {
		super(parent);
		this.elements = elements;
	}

	@Override
	public Iterable<IEObjectDescription> getLocalElements(ISelector selector) {
		if (selector instanceof ISelector.SelectByName) {
			QualifiedName name = ((ISelector.SelectByName) selector).getName().toLowerCase();
			if (elements.containsKey(name)) {
				return selector.applySelector(elements.get(name));
			} else {
				return Collections.emptySet();
			}
		}
		return selector.applySelector(elements.values());
	}
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		final QualifiedName lowerCase = fromParent.getName().toLowerCase();
		if (elements.containsKey(lowerCase)) {
			Collection<IEObjectDescription> shadowing = elements.get(lowerCase);
			for (IEObjectDescription ieObjectDescription : shadowing) {
				if (ieObjectDescription.getName().equals(fromParent.getName()))
					return true;
			}
		}
		return false;
	}
	
}
