/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureScope extends SimpleScope {
	
	public JvmFeatureScope(IScope parent, final Iterable<IEObjectDescription> descriptions) {
		super(parent,descriptions);
	}

	@Override
	protected Object getShadowingKey(IEObjectDescription description) {
		return ((JvmFeatureDescription)description).getKey();
	}
}
