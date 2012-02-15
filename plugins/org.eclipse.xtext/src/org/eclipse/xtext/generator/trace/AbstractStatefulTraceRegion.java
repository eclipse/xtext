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

	private final int myOffset;
	private final int myLength;
	private final int associatedOffset;
	private final int associatedLength;

	protected AbstractStatefulTraceRegion(int myOffset, int myLength, int associatedOffset, int associatedLength, AbstractTraceRegion parent) {
		super(parent);
		if (myOffset < 0)
			throw new IllegalArgumentException("myOffset " + myOffset + " is < 0");
		if (myLength < 0)
			throw new IllegalArgumentException("myLength " + myLength + " is < 0");
		if (associatedOffset < 0)
			throw new IllegalArgumentException("associatedOffset " + associatedOffset + " is < 0");
		if (associatedLength < 0)
			throw new IllegalArgumentException("associatedLength " + associatedLength + " is < 0");
		this.myOffset = myOffset;
		this.myLength = myLength;
		this.associatedOffset = associatedOffset;
		this.associatedLength = associatedLength;
		if (!isConsistentWithParent()) {
			throw new IllegalArgumentException("Produced region is inconsisten with parent, this: " + this + ", parent: " + parent);
		}
	}
	
	@Override
	public int getMyLength() {
		return myLength;
	}

	@Override
	public int getMyOffset() {
		return myOffset;
	}

	@Override
	public int getAssociatedLength() {
		return associatedLength;
	}

	@Override
	public int getAssociatedOffset() {
		return associatedOffset;
	}
	
}
