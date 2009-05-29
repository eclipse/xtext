/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

import org.apache.log4j.Logger;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DebugCharSequence implements CharSequence {

	private static final Logger log = Logger.getLogger(DebugCharSequence.class);

	private final CharSequence delegate;

	public DebugCharSequence(CharSequence delegate) {
		this.delegate = delegate;
	}

	public char charAt(int index) {
		char result = delegate.charAt(index);
		if (log.isTraceEnabled()) {
			log.trace("charAt(" + index + ") = " + result);
		}
		return result;
	}

	public int length() {
		return delegate.length();
	}

	public CharSequence subSequence(int start, int end) {
		if (log.isTraceEnabled()) {
			log.trace("subSequence(start = " + start + ", end = " + end + ")");
		}
		return new DebugCharSequence(delegate.subSequence(start, end));
	}

	@Override
	public String toString() {
		if (log.isTraceEnabled()) {
			log.trace("toString()");
		}
		return delegate.toString();
	}

}