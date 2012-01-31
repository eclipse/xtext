/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.util.ITextRegion;

/**
 * Represents trace information that is available for a given generated artifact.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface ITraceToSource extends ITrace {

	/**
	 * Returns the storage that is associated with this trace.
	 * @return the associated storage. Never <code>null</code>.
	 */
	IStorage getDerivedResource();
	
	/**
	 * Returns all available inverse trace information.
	 * @return the inverse trace information. Never <code>null</code>.
	 */
	Iterable<ITraceToTarget> getAllSources();
	
	/**
	 * Returns all available inverse trace information that belongs
	 * to the {@code language}.
	 * @param language the language that is expected to produce the output. May not be <code>null</code>.
	 * @return the inverse trace information. Never <code>null</code>.
	 */
	Iterable<ITraceToTarget> getAllSources(LanguageInfo language);
	
	/**
	 * Returns the best {@link ILocationInResource location} that matches the given {@code region}
	 * and {@code language}.
	 * If the region does not match a single location, the following strategy applies:
	 * <ul>
	 * <li>
	 * 		If the region spans multiple matching locations, the first and the last matching location 
	 *      are merged and returned.
	 * </li>
	 * </ul> 
	 * If no location data is available, returns <code>null</code>.
	 * @param region the region in the current resource. May not be <code>null</code>.
	 * @param language the language that is expected to produce the output. May not be <code>null</code>.
	 * @return the best associated location or <code>null</code> if none.
	 */
	ILocationInResource getBestAssociatedLocation(ITextRegion region, LanguageInfo language);
	
	/**
	 * Returns all {@link ILocationInResource locations} that match the given {@code region}
	 * and {@code language}.
	 * @param region the region in the current resource. May not be <code>null</code>.
	 * @param language the language that is expected to produce the output. May not be <code>null</code>.
	 * @return all associated locations. Never <code>null</code>. 
	 */
	Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion region, LanguageInfo language);
	
	/**
	 * Returns all known {@link ILocationInResource locations} that were produced by the given {@code language}.
	 * @param language the language that is expected to produce the output. May not be <code>null</code>.
	 * @return all locations. Never <code>null</code>. 
	 */
	Iterable<ILocationInResource> getAllLocations(LanguageInfo language);
	
}
