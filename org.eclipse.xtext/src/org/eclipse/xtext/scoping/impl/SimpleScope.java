/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class SimpleScope extends AbstractScope {
	
	private final Iterable<IEObjectDescription> descriptions;
	
	protected Set<Object> shadowingIndex;
	
	public SimpleScope(IScope parent, Iterable<IEObjectDescription> descriptions, boolean ignoreCase) {
		super(parent, ignoreCase);
		if (descriptions == null)
			throw new IllegalArgumentException("descriptions may not be null");
		this.descriptions = descriptions;
	}
	
	public SimpleScope(IScope parent, Iterable<IEObjectDescription> descriptions) {
		this(parent, descriptions, false);
	}
	
	public SimpleScope(Iterable<IEObjectDescription> descriptions, boolean ignoreCase) {
		this(IScope.NULLSCOPE, descriptions, ignoreCase);
	}
	
	public SimpleScope(Iterable<IEObjectDescription> descriptions) {
		this(IScope.NULLSCOPE, descriptions, false);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return descriptions;
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByEObject(final EObject object, final URI uri) {
		Iterable<IEObjectDescription> localElements = getAllLocalElements();
		Iterable<IEObjectDescription> result = Iterables.filter(localElements, new Predicate<IEObjectDescription>() {
			@Override
			public boolean apply(IEObjectDescription input) {
				if (input.getEObjectOrProxy() == object)
					return canBeFoundByNameAndShadowingKey(input);
				if (uri.equals(input.getEObjectURI())) {
					return canBeFoundByNameAndShadowingKey(input);
				}
				return false;
			}
			
			public boolean canBeFoundByNameAndShadowingKey(IEObjectDescription input) {
				Iterable<IEObjectDescription> lookUp = getLocalElementsByName(input.getName());
				Object myShadowingKey = getShadowingKey(input);
				for(IEObjectDescription other: lookUp) {
					if (myShadowingKey.equals(getShadowingKey(other))) {
						if (other == input)
							return true;
						if (other.getEObjectOrProxy() == object)
							return true;
						if (uri.equals(other.getEObjectURI()))
							return true;
						return false;
					}
				}
				return false;
			}
		});
		return result;
	}
	
	/**
	 * @return the key of the given description, which makes it shadowing others
	 */
	protected Object getShadowingKey(IEObjectDescription description) {
		if (isIgnoreCase())
			return description.getName().toLowerCase();
		return description.getName();
	}
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		if (shadowingIndex == null) {
			shadowingIndex = Sets.newHashSet();
			for(IEObjectDescription local: getAllLocalElements()) {
				shadowingIndex.add(getShadowingKey(local));
			}
		}
		boolean result = shadowingIndex.contains(getShadowingKey(fromParent));
		return result;
	}

}
