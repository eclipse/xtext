/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringHiddenRegion extends AbstractHiddenRegion {

	private boolean undefined = true;

	protected StringHiddenRegion(ITextRegionAccess access) {
		super(access);
	}

	@Override
	public boolean isUndefined() {
		return undefined;
	}

	protected void setUndefined(boolean undefined) {
		this.undefined = undefined;
	}

}
