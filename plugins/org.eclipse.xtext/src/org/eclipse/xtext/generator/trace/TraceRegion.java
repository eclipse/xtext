/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;

import com.google.common.collect.ImmutableList;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@NonNullByDefault
public class TraceRegion extends AbstractStatefulTraceRegion {

	public TraceRegion(int myOffset, int myLength, int associatedOffset, int associatedLength, 
			@Nullable AbstractTraceRegion parent, @Nullable URI associatedPath, @Nullable String associatedProject) {
		this(myOffset, myLength, new LocationData(associatedOffset, associatedLength, associatedPath, associatedProject), parent);
	}
	
	public TraceRegion(int myOffset, int myLength, ILocationData locationData, @Nullable AbstractTraceRegion parent) {
		super(myOffset, myLength, locationData, parent);
		if (parent == null) {
			if (locationData.getLocation() == null) {
				throw new IllegalArgumentException("associatedPath may not be null");
			}
			if (locationData.getProjectName() == null) {
				throw new IllegalArgumentException("associatedProjectName may not be null");
			}
 		} else {
 			if (parent.getAssociatedPath() == null && locationData.getLocation() == null) {
 				throw new IllegalArgumentException("associatedPath may not be null");
 			}
 			if (parent.getAssociatedProjectName() == null && locationData.getProjectName() == null) {
				throw new IllegalArgumentException("associatedProjectName may not be null");
			}
 		}
	}
	
	public TraceRegion(int myOffset, int myLength, List<ILocationData> allLocationData, @Nullable AbstractTraceRegion parent) {
		super(myOffset, myLength, ImmutableList.copyOf(allLocationData), parent);
		if (parent == null) {
			for(ILocationData locationData: allLocationData) {
				if (locationData.getLocation() == null) {
					throw new IllegalArgumentException("associatedPath may not be null");
				}
				if (locationData.getProjectName() == null) {
					throw new IllegalArgumentException("associatedProjectName may not be null");
				}
			}
 		} else {
 			boolean nullSeen = false;
 			boolean notNullSeen = false;
 			for(ILocationData locationData: allLocationData) {
 				if (locationData.getLocation() == null) {
 					nullSeen = true;
 				} else {
 					notNullSeen = true;
 				}
 				if (nullSeen && notNullSeen) {
 					throw new IllegalArgumentException("list of locations is inconsistent");
 				}
 			}
 			if (parent.getAssociatedPath() == null) {
 				if (nullSeen) {
 					throw new IllegalArgumentException("list of locations is inconsistent with parent");
 				}
 			}
 		}
	}

}
