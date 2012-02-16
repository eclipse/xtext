/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractStatefulTraceRegion extends AbstractTraceRegion {

	private final int myOffset;
	private final int myLength;
	private final List<ILocationData> associatedLocations;

	protected AbstractStatefulTraceRegion(int myOffset, int myLength, ILocationData associatedLocation, @Nullable AbstractTraceRegion parent) {
		super(parent);
		if (myOffset < 0)
			throw new IllegalArgumentException("myOffset " + myOffset + " is < 0");
		if (myLength < 0)
			throw new IllegalArgumentException("myLength " + myLength + " is < 0");
		this.myOffset = myOffset;
		this.myLength = myLength;
		this.associatedLocations = Collections.singletonList(associatedLocation);
		if (!isConsistentWithParent()) {
			throw new IllegalArgumentException("Produced region is inconsisten with parent, this: " + this + ", parent: " + parent);
		}
	}
	
	protected AbstractStatefulTraceRegion(int myOffset, int myLength, List<ILocationData> associatedLocations, @Nullable AbstractTraceRegion parent) {
		super(parent);
		if (myOffset < 0)
			throw new IllegalArgumentException("myOffset " + myOffset + " is < 0");
		if (myLength < 0)
			throw new IllegalArgumentException("myLength " + myLength + " is < 0");
		if (associatedLocations.isEmpty())
			throw new IllegalArgumentException("associatedLocations may not be empty");
		this.myOffset = myOffset;
		this.myLength = myLength;
		this.associatedLocations = associatedLocations;
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
	public List<ILocationData> getAssociatedLocations() {
		return Collections.unmodifiableList(associatedLocations);
	}
	
}
