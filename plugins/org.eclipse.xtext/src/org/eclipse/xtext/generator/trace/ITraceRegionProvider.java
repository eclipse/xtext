/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

/**
 * A trace region provider can be used to obtain a new {@link AbstractTraceRegion}.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITraceRegionProvider {

	/**
	 * Returns the a trace region.
	 * @throws TraceNotFoundException if no trace could be found
	 */
	/* @NonNull */ AbstractTraceRegion getTraceRegion() throws TraceNotFoundException;
	
}
