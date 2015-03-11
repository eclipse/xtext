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
import org.eclipse.xtext.util.TextRegionWithLineInformation;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class TraceRegion extends AbstractStatefulTraceRegion {

	public TraceRegion(int myOffset, int myLength, int myLineNumber, int myEndLineNumber, 
			int associatedOffset, int associatedLength, int associatedLineNumber, int associatedEndLineNumber, 
			/* @Nullable */ AbstractTraceRegion parent, /* @Nullable */ URI associatedPath) {
		this(myOffset, myLength, myLineNumber, myEndLineNumber, 
				new LocationData(associatedOffset, associatedLength, associatedLineNumber, associatedEndLineNumber, associatedPath), parent);
	}
	
	public TraceRegion(int myOffset, int myLength, int myLineNumber, int myEndLineNumber, ILocationData locationData, /* @Nullable */ AbstractTraceRegion parent) {
		super(new TextRegionWithLineInformation(myOffset, myLength, myLineNumber, myEndLineNumber), locationData, parent);
		if (myOffset == myLength && myOffset == 0) {
			throw new IllegalArgumentException();
		}
		if (parent == null) {
			if (locationData.getPath() == null) {
				throw new IllegalArgumentException("associatedPath may not be null");
			}
 		} else {
 			if (parent.getAssociatedPath() == null && locationData.getPath() == null) {
 				throw new IllegalArgumentException("associatedPath may not be null");
 			}
 		}
	}
	
	public TraceRegion(int myOffset, int myLength, int myLineNumber, int myEndLineNumber, List<ILocationData> allLocationData, /* @Nullable */ AbstractTraceRegion parent) {
		super(new TextRegionWithLineInformation(myOffset, myLength, myLineNumber, myEndLineNumber), Lists.newArrayList(allLocationData), parent);
		if (parent == null) {
			for(ILocationData locationData: allLocationData) {
				if (locationData.getPath() == null) {
					throw new IllegalArgumentException("associatedPath may not be null");
				}
			}
 		} else {
 			boolean nullSeen = false;
 			boolean notNullSeen = false;
 			for(ILocationData locationData: allLocationData) {
 				if (locationData.getPath() == null) {
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
