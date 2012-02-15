/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class LocationBasedTraceRegion extends AbstractTraceRegion {
	private final LocationData location;
	private final int offset;
	private final int length;

	public LocationBasedTraceRegion(@Nullable AbstractTraceRegion parent, TreeAppendable delegate, int offset) {
		super(parent);
		this.offset = offset;
		this.location = delegate.getLocationData();
		int length = 0;
		for (Object child : delegate.getChildren()) {
			if (child instanceof String) {
				length += ((String) child).length();
			} else {
				TreeAppendable castedChild = (TreeAppendable) child;
				if (hasVisibleChildren(castedChild)) {
					LocationBasedTraceRegion childRegion = new LocationBasedTraceRegion(this, castedChild, offset
							+ length);
					length += childRegion.getMyLength();
				}
			}
		}
		this.length = length;
	}

	protected boolean hasVisibleChildren(TreeAppendable castedChild) {
		for(Object o: castedChild.getChildren()) {
			if (o instanceof String)
				return true;
			if (hasVisibleChildren((TreeAppendable) o))
				return true;
		}
		return false;
	}

	@Override
	public int getMyLength() {
		return length;
	}

	@Override
	public int getMyOffset() {
		return offset;
	}

	@Override
	public int getAssociatedLength() {
		return location.getSourceLength();
	}

	@Override
	public int getAssociatedOffset() {
		return location.getSourceOffset();
	}

	@Override
	@Nullable
	public URI getAssociatedPath() {
		URI result = location.getSourceURI();
		return result;
	}

	@Override
	@Nullable
	public String getAssociatedProjectName() {
		String result = location.getSourceProject();
		return result;
	}
}