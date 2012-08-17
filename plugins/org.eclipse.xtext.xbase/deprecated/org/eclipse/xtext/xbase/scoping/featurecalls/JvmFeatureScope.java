/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class JvmFeatureScope extends SimpleScope {
	
	private String scopeDescription;

	@SuppressWarnings("unchecked")
	public JvmFeatureScope(IScope parent, String scopeDescription, final Collection<? extends IValidatedEObjectDescription> descriptions) {
		super(parent, (Iterable<IEObjectDescription>)(Iterable<?>)descriptions);
		this.scopeDescription = scopeDescription;
	}
	
	public JvmFeatureScope(IScope parent, String scopeDescription, IValidatedEObjectDescription description) {
		this(parent, scopeDescription, Collections.singleton(description));
	}

	public String getScopeDescription() {
		return scopeDescription;
	}
	
	@Override
	protected String getShadowingKey(IEObjectDescription description) {
		if (description instanceof IValidatedEObjectDescription)
			return ((IValidatedEObjectDescription)description).getKey();
		return String.valueOf(super.getShadowingKey(description));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Iterable<IValidatedEObjectDescription> getJvmFeatureDescriptions() {
		Iterable result = getAllLocalElements();
		return result;
	}
	
	@Override
	public String toString() {
		if (scopeDescription!=null)
			return "'"+scopeDescription+"'"+getAllLocalElements() + " -> " + getParent().toString();
		return super.toString();
	}
	
	
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		final Iterable<IEObjectDescription> localElements = getLocalElementsByName(fromParent.getName());
		return isShadowedBy(fromParent, localElements);
	}

	/*
	 * Specialized to interpret the shadowing key of sugared assignments to make sure
	 * that fields with the very same name shadow properties, e.g. field prop1 has to
	 * shadow all overloaded versions of setProp1(type). Furthermore we want to allow
	 * overwriting the concrete algorithm without the need to fetch the localElements twice.
	 */
	/**
	 * @see JvmFeatureScope#isShadowed(IEObjectDescription)
	 */
	protected boolean isShadowedBy(IEObjectDescription fromParent, final Iterable<IEObjectDescription> localElements) {
		boolean result = false;
		String parentKey = getShadowingKey(fromParent);
		for(IEObjectDescription local: localElements) {
			String localKey = getShadowingKey(local);
			if (parentKey.equals(localKey))
				return true;
		}
		if (result == false) {
			int assignmentIndicator = parentKey.indexOf("=(");
			if (assignmentIndicator >= 0) { // sugared assignment
				String shortShadowingKey = parentKey.substring(0, assignmentIndicator);
				for(IEObjectDescription local: localElements) {
					String localKey = getShadowingKey(local);
					if (shortShadowingKey.equals(localKey))
						return true;
				}
			}
		}
		return result;
	}

}
