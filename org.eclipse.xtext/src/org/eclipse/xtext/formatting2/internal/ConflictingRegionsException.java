/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.Collection;

import org.eclipse.xtext.formatting2.debug.TextRegionsWithTitleToString;
import org.eclipse.xtext.util.Exceptions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConflictingRegionsException extends RuntimeException {

	private static final long serialVersionUID = 3957771424755606694L;

	private final Collection<RegionTrace> traces;

	public ConflictingRegionsException(String message, Collection<RegionTrace> traces) {
		this(message, null, traces);
	}

	public ConflictingRegionsException(String message, Throwable cause, Collection<RegionTrace> traces) {
		super(message, cause);
		this.traces = traces;
		for (RegionTrace trace : traces)
			Exceptions.addSuppressed(this, trace);
	}

	@Override
	public String getMessage() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getMessage() + ".\n");
		TextRegionsWithTitleToString toStr = new TextRegionsWithTitleToString();
		for (RegionTrace trace : traces)
			toStr.add(trace.getMessage(), trace.getRegion());
		builder.append(toStr);
		return builder.toString();
	}

	public Collection<RegionTrace> getTraces() {
		return traces;
	}
}
