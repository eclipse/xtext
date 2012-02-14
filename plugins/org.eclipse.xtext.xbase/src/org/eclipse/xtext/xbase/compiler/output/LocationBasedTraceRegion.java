/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LocationBasedTraceRegion extends AbstractTraceRegion {
	private final LocationData location;
	private final int offset;
	private final int length;

	public LocationBasedTraceRegion(@Nullable AbstractTraceRegion parent, TreeAppendable delegate, int offset) {
		super(parent);
		this.offset = offset;
		this.location = delegate.locationData;
		int length = 0;
		for (Object child : delegate.getChildren()) {
			if (child instanceof String) {
				length += ((String) child).length();
			} else {
				TreeAppendable castedChild = (TreeAppendable) child;
				if (!castedChild.getChildren().isEmpty()) {
					LocationBasedTraceRegion childRegion = new LocationBasedTraceRegion(this, castedChild, offset
							+ length);
					length += childRegion.getFromLength();
				}
			}
		}
		this.length = length;
	}

	@Override
	public int getFromLength() {
		return length;
	}

	@Override
	public int getFromOffset() {
		return offset;
	}

	@Override
	public int getToLength() {
		return location.getSourceLength();
	}

	@Override
	public int getToOffset() {
		return location.getSourceOffset();
	}

	@Override
	@Nullable
	public URI getToPath() {
		URI result = location.getSourceURI();
		if (result == null)
			return super.getToPath();
		return result;
	}

	@Override
	@Nullable
	public String getToProjectName() {
		String result = location.getSourceProject();
		if (result == null)
			return super.getToProjectName();
		return result;
	}
}