/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class TraceRegion extends AbstractStatefulTraceRegion {

	protected final URI toPath;
	protected final ITraceRegion parent;
	protected List<ITraceRegion> nestedRegions;
	protected final String toProjectName;
	
	public TraceRegion(int fromOffset, int fromLength, int toOffset, int toLength, ITraceRegion parent, URI toPath, String toProjectName) {
		super(fromOffset, fromLength, toOffset, toLength);
		this.parent = parent;
		this.toPath = toPath;
		this.toProjectName = toProjectName;
		if (parent instanceof TraceRegion) {
			TraceRegion castedParent = (TraceRegion) parent;
			if (castedParent.nestedRegions == null) {
				castedParent.nestedRegions = Lists.newArrayListWithCapacity(4);
			}
			castedParent.nestedRegions.add(this);
		} else {
			if (toPath == null) {
				throw new IllegalArgumentException("toPath may not be null");
			}
			if (toProjectName == null) {
				throw new IllegalArgumentException("toProjectName may not be null");
			}
		}
	}

	@Override
	public Iterator<ITraceRegion> leafIterator() {
		if (nestedRegions == null)
			return Collections.<ITraceRegion>singleton(this).iterator();
		return new LeafIterator(this);
	}
	
	@Override
	public URI getToPath() {
		if (toPath == null && parent != null)
			return parent.getToPath();
		return toPath;
	}
	
	@Override
	public List<ITraceRegion> getNestedRegions() {
		if (nestedRegions != null)
			return Collections.unmodifiableList(nestedRegions);
		return Collections.emptyList();
	}
	
	public ITraceRegion getParent() {
		return parent;
	}
	
	@Override
	public String getToProjectName() {
		if (toProjectName == null && parent != null)
			return parent.getToProjectName();
		return toProjectName;
	}
	
}
