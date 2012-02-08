/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractStatefulTraceRegion extends AbstractTraceRegion {

	private final int fromOffset;
	private final int fromLength;
	private final int toOffset;
	private final int toLength;

	protected AbstractStatefulTraceRegion(int fromOffset, int fromLength, int toOffset, int toLength, AbstractTraceRegion parent) {
		super(parent);
		if (fromOffset < 0)
			throw new IllegalArgumentException("fromOffset " + fromOffset + " is < 0");
		if (fromLength < 0)
			throw new IllegalArgumentException("fromLength " + fromLength + " is < 0");
		if (toOffset < 0)
			throw new IllegalArgumentException("toOffset " + toOffset + " is < 0");
		if (toLength < 0)
			throw new IllegalArgumentException("toLength " + toLength + " is < 0");
		this.fromOffset = fromOffset;
		this.fromLength = fromLength;
		this.toOffset = toOffset;
		this.toLength = toLength;
	}

	@Override
	public int getFromLength() {
		return fromLength;
	}

	@Override
	public int getFromOffset() {
		return fromOffset;
	}

	@Override
	public int getToLength() {
		return toLength;
	}

	@Override
	public int getToOffset() {
		return toOffset;
	}
	
}
