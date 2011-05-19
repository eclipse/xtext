/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collections;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureScope extends SimpleScope {
	
	private String scopeDescription;

	@SuppressWarnings("unchecked")
	public JvmFeatureScope(IScope parent, String scopeDescription, final Iterable<? extends IValidatedEObjectDescription> descriptions) {
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
	
	@SuppressWarnings("unchecked")
	public Iterable<? extends IValidatedEObjectDescription> getJvmFeatureDescriptions() {
		return (Iterable<? extends IValidatedEObjectDescription>) getAllLocalElements();
	}
	
	@Override
	public String toString() {
		if (scopeDescription!=null)
			return "'"+scopeDescription+"'"+getAllLocalElements() + " -> " + getParent().toString();
		return super.toString();
	}
	
	/*
	 * Specialized to interpret the shadowing key of sugared assignments to make sure
	 * that fields with the very same name shadow properties, e.g. field prop1 has to
	 * shadow all overloaded versions of setProp1(type).
	 */
	@Override
	protected boolean isShadowed(IEObjectDescription fromParent) {
		boolean result = super.isShadowed(fromParent);
		if (result == false) {
			String parentShadowingKey = getShadowingKey(fromParent);
			int assignmentIndicator = parentShadowingKey.indexOf("=(");
			if (assignmentIndicator >= 0) { // sugared assignment
				String shortShadowingKey = parentShadowingKey.substring(0, assignmentIndicator);
				result = shadowingIndex.contains(shortShadowingKey);
			}
		}
		return result;
	}

}
