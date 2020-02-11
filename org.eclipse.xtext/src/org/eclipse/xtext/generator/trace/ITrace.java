/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.workspace.IProjectConfig;

/**
 * The trace provides a way to work with tracing information of a code generator.
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
public interface ITrace {

	/**
	 * Returns the best associated {@link ILocationInResource location} that matches the given {@code region}.
	 * If the region does not match a single location, the following strategy applies:
	 * <ul>
	 * <li>
	 * 		If the region spans multiple locations where the first and the last location belong
	 * 		to the same resource, the merged location is returned.
	 * </li>
	 * <li>
	 * 		If the region spans multiple locations that belong to different resources, the longest
	 *      prefix location for a single resource is returned.
	 * </li>
	 * <li>
	 * 		If the region spans multiple overlapping locations that belong to different resources,
	 *      <code>null</code> is returned.
	 * </li>
	 * </ul> 
	 * If no location data is available, returns <code>null</code>.
	 * 
	 * @param localRegion
	 *            the region in the current resource. May not be <code>null</code>.
	 * @return the best associated location or <code>null</code> if none.
	 */
	ILocationInResource getBestAssociatedLocation(ITextRegion localRegion);
	
	/**
	 * Returns all associated {@link ILocationInResource locations} that match the given {@code region}.
	 * 
	 * @param localRegion
	 *            the region in the current resource. May not be <code>null</code>.
	 * @return all associated locations. Never <code>null</code>.
	 */
	Iterable<? extends ILocationInResource> getAllAssociatedLocations(ITextRegion localRegion);
	
	/**
	 * Returns all known associated {@link ILocationInResource locations}.
	 * 
	 * @return all associated locations. Never <code>null</code>. 
	 */
	Iterable<? extends ILocationInResource> getAllAssociatedLocations();
	
	/**
	 * Returns the local project. Never <code>null</code>.
	 * 
	 * @return the local project. Never <code>null</code>.
	 */
	IProjectConfig getLocalProjectConfig();
	
	/**
	 * Returns the absolute URI of the local resource. Never <code>null</code>.
	 * 
	 * @return the absolute URI of the local resource. Never <code>null</code>.
	 */
	AbsoluteURI getLocalURI();
	
	/**
	 * Returns the relative URI of the local resource. Never <code>null</code>.
	 * 
	 * In other words: returns the URI as it would be relative to the class path
	 * after the resource was packaged. If the resource resides in a source folder
	 * of a java project, it'll return the URI relative to the source folder itself.
	 * Otherwise relative to the project root.
	 * 
	 * @return the relative URI of the local resource. Never <code>null</code>.
	 */
	SourceRelativeURI getSrcRelativeLocalURI();
	
	/**
	 * Returns the language that is associated with the local resource. May be <code>null</code>
	 * if the artifact does not have an associated Xtext language, e.g. for html or java files.
	 * 
	 * @return the language that is associated with the local resource. May be <code>null</code>.
	 */
	LanguageInfo getLocalLanguage();
	
	/**
	 * Returns the best {@link ILocationInResource location} that matches the given
	 * {@code localRegion} in the {@code absoluteTargetResource}.
	 * If the region does not match a single location in the target, the following strategy applies:
	 * <ul>
	 * <li>
	 * 		The merged region of all matching locations in the {@code targetResource}
	 *      is returned. 
	 * </li>
	 * </ul> 
	 * If no location data is available or the {@code localRegion} does not yield
	 * a location in {@code absoluteTargetResource}, returns <code>null</code>.
	 * 
	 * @param localRegion
	 *            the region in the current resource. May not be <code>null</code>.
	 * @param absoluteTargetResource
	 *            the expected target resource. May not be <code>null</code>.
	 * @return the best associated location or <code>null</code> if none.
	 */
	ILocationInResource getBestAssociatedLocation(ITextRegion localRegion, AbsoluteURI absoluteTargetResource);
	
	/**
	 * Returns all individual {@link ILocationInResource locations} that match the given {@code localRegion}
	 * for the expected {@code absoluteTargetResource}.
	 * 
	 * @param localRegion
	 *            the region in the current resource. May not be <code>null</code>.
	 * @param absoluteTargetResource
	 *            the expected target resource. May not be <code>null</code>.
	 * @return all associated locations. Never <code>null</code>. 
	 */
	Iterable<? extends ILocationInResource> getAllAssociatedLocations(ITextRegion localRegion, AbsoluteURI absoluteTargetResource);
	
	/**
	 * Returns all known {@link ILocationInResource locations} that were produced from the associated resource in the
	 * given {@code absoluteTargetResource}.
	 * 
	 * @param absoluteTargetResource
	 *            the expected target resource. May not be <code>null</code>.
	 * @return all locations. Never <code>null</code>.
	 */
	Iterable<? extends ILocationInResource> getAllAssociatedLocations(AbsoluteURI absoluteTargetResource);
	
	/**
	 * Returns true if the trace is not empty and can provide at leat one location.
	 */
	boolean hasTraceData();
	
}
