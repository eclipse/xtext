/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RegionTrace extends RuntimeException {

	private static final long serialVersionUID = -6420580169021980120L;

	private final ITextSegment region;

	public RegionTrace(String message, ITextSegment region) {
		super(message);
		this.region = region;
	}

	public ITextSegment getRegion() {
		return region;
	}

}
