/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.ITextSegment;
import org.eclipse.xtext.util.Pair;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConflictingRegionsException extends RuntimeException {

	private static final long serialVersionUID = 3957771424755606694L;

	private final Pair<String, ITextSegment>[] regions;

	public ConflictingRegionsException(String message, Pair<String, ITextSegment>... regions) {
		super(message);
		this.regions = regions;
	}

	public ConflictingRegionsException(String message, Throwable cause, Pair<String, ITextSegment>... regions) {
		super(message, cause);
		this.regions = regions;
	}

	@Override
	public String getMessage() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getMessage() + ".\n");
		RegionsWithTitleToString toStr = new RegionsWithTitleToString();
		for (Pair<String, ITextSegment> p : regions)
			toStr.add(p.getFirst(), p.getSecond());
		builder.append(toStr);
		return builder.toString();
	}

	public Pair<String, ITextSegment>[] getRegions() {
		return regions;
	}

}
