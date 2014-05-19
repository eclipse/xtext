/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.arguments;

import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SuperfluousFeatureCallArgumentSlot extends StandardFeatureCallArgumentSlot {

	protected SuperfluousFeatureCallArgumentSlot(StandardFeatureCallArguments arguments, int idx) {
		super(arguments, idx);
	}
	
	@Override
	public boolean isSuperfluous() {
		return true;
	}

	@Override
	public LightweightTypeReference getDeclaredType() {
		throw new IllegalStateException();
	}

}
