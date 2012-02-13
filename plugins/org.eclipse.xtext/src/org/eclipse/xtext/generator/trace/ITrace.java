/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.util.ITextRegion;

/**
 * The trace provides a way to work with tracing information of a code generator.
 * @see ITraceToSource
 * @see ITraceToTarget
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
@NonNullByDefault
public interface ITrace {

	/**
	 * Returns the best {@link ILocationInResource location} that matches the given {@code region}.
	 * If the region does not match a single location, the following strategy applies:
	 * <ul>
	 * <li>
	 * 		If the region spans multiple locations where the first and the last location belong
	 * 		to the same resources, the merged location is returned.
	 * </li>
	 * <li>
	 * 		If the region spans multiple locations that belong to different resources, the longest
	 *      prefix location for a single resources is returned.
	 * </li>
	 * <li>
	 * 		If the region spans multiple overlapping locations that belong to different resources,
	 *      <code>null</code> is returned.
	 * </li>
	 * </ul> 
	 * If no location data is available, returns <code>null</code>.
	 * @param region the region in the current resource. May not be <code>null</code>.
	 * @return the best associated location or <code>null</code> if none.
	 */
	@Nullable ILocationInResource getBestAssociatedLocation(ITextRegion region);
	
	/**
	 * Returns all {@link ILocationInResource locations} that match the given {@code region}.
	 * @param region the region in the current resource. May not be <code>null</code>.
	 * @return all associated locations. Never <code>null</code>. 
	 */
	Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion region);
	
	/**
	 * Returns all known {@link ILocationInResource locations}.
	 * @return all locations. Never <code>null</code>. 
	 */
	Iterable<ILocationInResource> getAllLocations();
	
}
