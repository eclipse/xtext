/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
