/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DebugTraceBasedRegion extends AbstractTraceRegion {

	private final DebugTraceRegion delegate;

	protected DebugTraceBasedRegion(AbstractTraceRegion parent, DebugTraceRegion delegate) {
		super(parent);
		this.delegate = delegate;
		for (DebugTraceRegion child : delegate.getNestedRegions())
			new DebugTraceBasedRegion(this, child);
	}

	private LocationData convert(DebugLocationData data) {
		SourceRelativeURI uri = data.getPath() != null ? new SourceRelativeURI(data.getPath()) : null;
		return new LocationData(data.getOffset(), data.getLength(), data.getLineNumber(), data.getEndLineNumber(), uri);
	}

	@Override
	public List<ILocationData> getAssociatedLocations() {
		List<ILocationData> result = Lists.newArrayListWithCapacity(delegate.getAssociations().size());
		for (DebugLocationData data : delegate.getAssociations())
			result.add(convert(data));
		return result;
	}

	@Override
	public SourceRelativeURI getAssociatedSrcRelativePath() {
		SourceRelativeURI path = super.getAssociatedSrcRelativePath();
		if (path != null)
			return path;
		return getAssociatedSrcRelativePath(delegate);
	}

	protected SourceRelativeURI getAssociatedSrcRelativePath(DebugTraceRegion region) {
		for (DebugLocationData associated : region.getAssociations()) {
			URI uri = associated.getPath();
			if (uri != null)
				return new SourceRelativeURI(uri);
		}
		EObject container = region.eContainer();
		if (container instanceof DebugTraceRegion)
			return getAssociatedSrcRelativePath((DebugTraceRegion) container);
		return null;
	}

	@Override
	public int getMyEndLineNumber() {
		return delegate.getMyEndLineNumber();
	}

	@Override
	public int getMyLength() {
		return delegate.getMyLength();
	}

	@Override
	public int getMyLineNumber() {
		return delegate.getMyLineNumber();
	}

	@Override
	public int getMyOffset() {
		return delegate.getMyOffset();
	}

	@Override
	public boolean isUseForDebugging() {
		return delegate.isUseForDebugging();
	}

}
