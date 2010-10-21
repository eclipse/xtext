/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.scoping.newapi.INewScope;
import org.eclipse.xtext.xbase.scoping.newapi.IterableBasedScope;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureDescriptionContainingScope extends IterableBasedScope {

	public JvmFeatureDescriptionContainingScope(Iterable<? extends IEObjectDescription> descriptions, INewScope parent) {
		super(descriptions, parent);
	}

	@Override
	protected Object getShadowingIndexElement(IEObjectDescription description) {
		if (description instanceof JvmFeatureDescription) {
			return ((JvmFeatureDescription) description).getShadowingString();
		}
		return super.getShadowingIndexElement(description);
	}
}
