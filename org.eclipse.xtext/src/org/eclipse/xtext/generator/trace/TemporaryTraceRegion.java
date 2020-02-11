/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.List;

import org.eclipse.xtext.util.TextRegionWithLineInformation;

/**
 * A trace region that will not be added to the child list of the given parent.
 * It is used to create temporary leaf regions when a parent is asked for its children. 
 */
public class TemporaryTraceRegion extends AbstractStatefulTraceRegion {
	public TemporaryTraceRegion(int myOffset, int myLength, int myLineNumber, int myEndLineNumber, boolean useForDebugging, List<ILocationData> locations,
			AbstractTraceRegion parent) {
		super(new TextRegionWithLineInformation(myOffset, myLength, myLineNumber, myEndLineNumber), useForDebugging, locations, parent);
	}

	@Override
	protected void setAsChildIn(AbstractTraceRegion parent) {
		// we don't want to add temporary regions to the parent's child list
	}
}