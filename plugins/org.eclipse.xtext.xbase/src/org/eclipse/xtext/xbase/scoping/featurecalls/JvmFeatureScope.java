/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.xtext.common.types.JvmIdentifyableElement;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureScope extends SimpleScope {
	
	private String scopeDescription;

	public JvmFeatureScope(IScope parent, String scopeDescription, final Iterable<JvmFeatureDescription> descriptions) {
		super(parent, convertToList(descriptions));
		this.scopeDescription = scopeDescription;
	}

	@SuppressWarnings("unchecked")
	protected static Iterable<IEObjectDescription> convertToList(final Iterable<JvmFeatureDescription> descriptions) {
		if (descriptions instanceof List) 
			return (Iterable<IEObjectDescription>)(Iterable<?>)descriptions;
		List<IEObjectDescription> result = newArrayList();
		for (IEObjectDescription desc : descriptions) {
			result.add(desc);
		}
		return result;
	}
	
	public String getScopeDescription() {
		return scopeDescription;
	}

	@Override
	protected Object getShadowingKey(IEObjectDescription description) {
		return ((JvmFeatureDescription)description).getKey();
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<? extends JvmFeatureDescription> getJvmFeatureDescriptions() {
		return (Iterable<? extends JvmFeatureDescription>) getAllLocalElements();
	}
	
	@Override
	public String toString() {
		if (scopeDescription!=null)
			return "'"+scopeDescription+"'"+getAllLocalElements() + " -> " + getParent().toString();
		return super.toString();
	}

	public void setImplicitReceiverOnAllDescriptions(JvmIdentifyableElement implicitReceiver) {
		for (JvmFeatureDescription description : getJvmFeatureDescriptions()) {
			description.setImplicitReceiver(implicitReceiver);
		}
	}
}
