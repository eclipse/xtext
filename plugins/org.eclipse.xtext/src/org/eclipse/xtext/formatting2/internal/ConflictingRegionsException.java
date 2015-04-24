/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import java.util.Collection;

import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.debug.TextRegionsWithTitleToString;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.util.Exceptions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConflictingRegionsException extends RuntimeException {

	private static final long serialVersionUID = 3957771424755606694L;

	private final Collection<Trace> traces;

	public ConflictingRegionsException(String message, Collection<Trace> traces) {
		this(message, null, traces);
	}

	public ConflictingRegionsException(String message, Throwable cause, Collection<Trace> traces) {
		super(message, cause);
		this.traces = traces;
		for (Trace trace : traces)
			Exceptions.addSuppressed(this, trace);
	}

	@Override
	public String getMessage() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.getMessage() + ".\n");
		TextRegionsWithTitleToString toStr = new TextRegionsWithTitleToString();
		for (Trace trace : traces) {
			Object object = trace.getObject();
			if (object instanceof ITextReplacer)
				toStr.add(trace.getMessage(), ((ITextReplacer) object).getRegion());
			if (object instanceof ITextSegment)
				toStr.add(trace.getMessage(), (ITextSegment) object);
		}
		builder.append(toStr);
		return builder.toString();
	}

	public Collection<Trace> getTraces() {
		return traces;
	}
}
