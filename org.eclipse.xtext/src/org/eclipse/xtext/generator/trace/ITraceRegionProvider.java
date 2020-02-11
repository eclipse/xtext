/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

/**
 * A trace region provider can be used to obtain a new {@link AbstractTraceRegion}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITraceRegionProvider {

	/**
	 * Returns the a trace region.
	 * 
	 * @throws TraceNotFoundException if no trace could be found
	 */
	AbstractTraceRegion getTraceRegion() throws TraceNotFoundException;
	
}
