/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.util.TextRegionWithLineInformation;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class TraceRegion extends AbstractStatefulTraceRegion {

	public TraceRegion(int myOffset, int myLength, int myLineNumber, int myEndLineNumber, 
			boolean useForDebugging,
			int associatedOffset, int associatedLength, int associatedLineNumber, int associatedEndLineNumber,
			AbstractTraceRegion parent,
			SourceRelativeURI associatedPath) {
		this(myOffset, myLength, myLineNumber, myEndLineNumber, useForDebugging,
				new LocationData(associatedOffset, associatedLength, associatedLineNumber, associatedEndLineNumber, associatedPath), parent);
	}
	
	public TraceRegion(int myOffset, int myLength, int myLineNumber, int myEndLineNumber, boolean useForDebugging, ILocationData locationData, AbstractTraceRegion parent) {
		super(new TextRegionWithLineInformation(myOffset, myLength, myLineNumber, myEndLineNumber), useForDebugging, locationData, parent);
		if (myOffset == myLength && myOffset == 0) {
			throw new IllegalArgumentException();
		}
		if (parent == null) {
			if (locationData.getSrcRelativePath() == null) {
				throw new IllegalArgumentException("associatedPath may not be null");
			}
 		} else {
 			if (parent.getAssociatedSrcRelativePath() == null && locationData.getSrcRelativePath() == null) {
 				throw new IllegalArgumentException("associatedPath may not be null");
 			}
 		}
	}
	
	/**
	 * @deprecated use {link {@link #TraceRegion(int, int, int, int, boolean, Collection, AbstractTraceRegion)} instead.
	 */
	@Deprecated
	public TraceRegion(int myOffset, int myLength, int myLineNumber, int myEndLineNumber, boolean useForDebugging, List<ILocationData> allLocationData, AbstractTraceRegion parent) {
		this(myOffset, myLength, myLineNumber, myEndLineNumber, useForDebugging, (Collection<ILocationData>) allLocationData, parent);
	}
	
	public TraceRegion(int myOffset, int myLength, int myLineNumber, int myEndLineNumber, boolean useForDebugging, Collection<? extends ILocationData> allLocationData, AbstractTraceRegion parent) {
		super(new TextRegionWithLineInformation(myOffset, myLength, myLineNumber, myEndLineNumber), useForDebugging, Lists.newArrayList(allLocationData), parent);
		if (parent == null) {
			for(ILocationData locationData: allLocationData) {
				if (locationData.getSrcRelativePath() == null) {
					throw new IllegalArgumentException("associatedPath may not be null");
				}
			}
 		} else {
 			boolean nullSeen = false;
 			boolean notNullSeen = false;
 			for(ILocationData locationData: allLocationData) {
 				if (locationData.getSrcRelativePath() == null) {
 					nullSeen = true;
 				} else {
 					notNullSeen = true;
 				}
 				if (nullSeen && notNullSeen) {
 					throw new IllegalArgumentException("list of locations is inconsistent");
 				}
 			}
 			if (parent.getAssociatedSrcRelativePath() == null) {
 				if (nullSeen) {
 					throw new IllegalArgumentException("list of locations is inconsistent with parent");
 				}
 			}
 		}
	}

}
