/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.LocationData;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class AppendableBasedTraceRegion extends AbstractTraceRegion {
	private final List<ILocationData> locations;
	private final int offset;
	private final int length;

	public AppendableBasedTraceRegion(@Nullable AbstractTraceRegion parent, TreeAppendable delegate, int offset) {
		super(parent);
		this.offset = offset;
		if (parent == null) {
			this.locations = Lists.newArrayList(delegate.getLocationData());
		} else {
			URI parentPath = parent.getAssociatedPath();
			if (parentPath == null) {
				this.locations = Lists.newArrayList(delegate.getLocationData());
			} else {
				boolean matches = true;
				for(ILocationData locationData: delegate.getLocationData()) {
					if (!parentPath.equals(locationData.getLocation())) {
						matches = false;
						break;
					}
				}
				if (matches) {
					this.locations = Lists.newArrayList();
					for(ILocationData locationData: delegate.getLocationData()) {
						this.locations.add(new LocationData(locationData.getOffset(), locationData.getLength(), null, null));
					}
				} else {
					this.locations = Lists.newArrayList(delegate.getLocationData());
				}
			}
		}
		int length = 0;
		for (Object child : delegate.getChildren()) {
			if (child instanceof String) {
				length += ((String) child).length();
			} else {
				TreeAppendable castedChild = (TreeAppendable) child;
				if (hasVisibleChildren(castedChild)) {
					AppendableBasedTraceRegion childRegion = new AppendableBasedTraceRegion(this, castedChild, offset
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
	public List<ILocationData> getAssociatedLocations() {
		return locations;
	}
	
}