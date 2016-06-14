/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtext.generator.trace.AbstractStatefulTraceRegion;
import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RootTraceRegionForTesting extends AbstractStatefulTraceRegion {

	public RootTraceRegionForTesting(ITextRegionWithLineInformation myLocation, ITextRegionWithLineInformation association) {
		super(myLocation, true, new LocationData(association, new SourceRelativeURI("uri")), null);
	}
	
}
