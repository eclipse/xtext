/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * A trace region provider can be used to add nested trace regions to a given
 * parent or produce a completely new {@link AbstractTraceRegion}.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITraceRegionProvider {

	/**
	 * Returns the given parent after new children have been added or a completely 
	 * new trace region if no parent was provided.
	 */
	@NonNull AbstractTraceRegion getTraceRegion(int relativeOffset, @Nullable AbstractTraceRegion parent);
	
}
