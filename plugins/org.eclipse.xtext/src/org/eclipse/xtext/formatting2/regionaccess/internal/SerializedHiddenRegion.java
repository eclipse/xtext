/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializedHiddenRegion extends AbstractHiddenRegion {

	private boolean undefined = true;

	protected SerializedHiddenRegion(ITextRegionAccess tokenAccess) {
		super(tokenAccess);
	}

	@Override
	public boolean isUndefined() {
		return undefined;
	}

	void setUndefined(boolean undefined) {
		this.undefined = undefined;
	}

}
