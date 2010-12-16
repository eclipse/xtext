/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureScope extends SimpleScope {
	
	private Iterable<JvmFeatureDescription> jvmFeatureDescriptions;
	private String scopeDescription;

	@SuppressWarnings("unchecked")
	public JvmFeatureScope(IScope parent, String scopeDescription, final Iterable<JvmFeatureDescription> descriptions) {
		super(parent, (Iterable<IEObjectDescription>)(Iterable<?>)descriptions);
		this.jvmFeatureDescriptions = descriptions;
		this.scopeDescription = scopeDescription;
	}
	
	public void setParent(IScope parent) {
		this.parent = parent;
	}
	
	public String getScopeDescription() {
		return scopeDescription;
	}

	@Override
	protected Object getShadowingKey(IEObjectDescription description) {
		return ((JvmFeatureDescription)description).getKey();
	}
	
	public Iterable<JvmFeatureDescription> getJvmFeatureDescriptions() {
		return jvmFeatureDescriptions;
	}
	
	@Override
	public String toString() {
		if (scopeDescription!=null)
			return "'"+scopeDescription+"'"+getLocalElements(ISelector.SELECT_ALL) + " -> " + getParent().toString();
		return super.toString();
	}
}
