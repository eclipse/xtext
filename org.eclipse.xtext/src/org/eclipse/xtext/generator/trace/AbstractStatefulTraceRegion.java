/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.util.ITextRegionWithLineInformation;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractStatefulTraceRegion extends AbstractTraceRegion {

	private final ITextRegionWithLineInformation myRegion;
	private final List<ILocationData> associatedLocations;
	private final boolean useForDebugging;

	protected AbstractStatefulTraceRegion(ITextRegionWithLineInformation myRegion, boolean useForDebugging, ILocationData associatedLocation, AbstractTraceRegion parent) {
		this(myRegion, useForDebugging, Lists.newArrayList(associatedLocation), parent);
	}
	
	protected AbstractStatefulTraceRegion(ITextRegionWithLineInformation myRegion, boolean useForDebugging, List<ILocationData> associatedLocations, AbstractTraceRegion parent) {
		super(parent);
		this.myRegion = myRegion;
		this.useForDebugging = useForDebugging;
		this.associatedLocations = associatedLocations;
		if (!isConsistentWithParent()) {
			throw new IllegalArgumentException("Produced region is inconsistent with parent, this: " + this + ", parent: " + parent);
		}
	}
	
	@Override
	public int getMyLength() {
		return myRegion.getLength();
	}

	@Override
	public int getMyOffset() {
		return myRegion.getOffset();
	}
	
	@Override
	public int getMyEndLineNumber() {
		return myRegion.getEndLineNumber();
	}
	
	@Override
	public int getMyLineNumber() {
		return myRegion.getLineNumber();
	}
	
	@Override
	public ITextRegionWithLineInformation getMyRegion() {
		return myRegion;
	}
	
	@Override
	public boolean isUseForDebugging() {
		return useForDebugging;
	}

	@Override
	public List<ILocationData> getAssociatedLocations() {
		return Collections.unmodifiableList(associatedLocations);
	}
	
	protected List<ILocationData> getWritableAssociatedLocations() {
		return associatedLocations;
	}
	
}
