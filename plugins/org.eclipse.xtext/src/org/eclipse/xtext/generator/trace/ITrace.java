/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.util.ITextRegion;

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
	 * @param localRegion the region in the current resource. May not be <code>null</code>.
	 * @return the best associated location or <code>null</code> if none.
	 */
	/* @Nullable */ ILocationInResource getBestAssociatedLocation(ITextRegion localRegion);
	
	/**
	 * Returns all associated {@link ILocationInResource locations} that match the given {@code region}.
	 * @param localRegion the region in the current resource. May not be <code>null</code>.
	 * @return all associated locations. Never <code>null</code>. 
	 */
	Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion localRegion);
	
	/**
	 * Returns all known associated {@link ILocationInResource locations}.
	 * @return all associated locations. Never <code>null</code>. 
	 */
	Iterable<ILocationInResource> getAllAssociatedLocations();
	
	/**
	 * Returns the storage that is associated with this trace.
	 * @return the associated storage. Never <code>null</code>.
	 */
//	IStorage getLocalStorage();
	
//	/**
//	 * Returns all available inverse trace information.
//	 * @return the inverse trace information. Never <code>null</code>.
//	 */
//	Iterable<ITrace> getAllAssociatedTraces();

	/**
	 * Returns the source project. Never <code>null</code>.
	 * @return the source project. Never <code>null</code>.
	 */
	IProject getLocalProject();
	
	/**
	 * Returns the URI of the source resource. Never <code>null</code>.
	 * @return the URI of the source resource. Never <code>null</code>.
	 */
	URI getLocalURI();
	
	/**
	 * Returns the language that is associated with the source resource. Never <code>null</code>.
	 * @return the language that is associated with the source resource. Never <code>null</code>.
	 */
	/* @Nullable */ LanguageInfo getLanguage();
	
//	/**
//	 * Returns the source trace for the given storage or <code>null</code> if none.
//	 * @param associatedStorage the expected target resource. May not be <code>null</code>.
//	 * @return the source trace for the given storage or <code>null</code> if none.
//	 */
//	/* @Nullable */ ITrace getAssociatedTrace(IStorage associatedStorage);

	/**
	 * Returns the best {@link ILocationInResource location} that matches the given
	 * {@code sourceRegion} in the {@code targetResource}.
	 * If the region does not match a single location in the target, the following strategy applies:
	 * <ul>
	 * <li>
	 * 		The merged region of all matching locations in the {@code targetResource}
	 *      is returned. 
	 * </li>
	 * </ul> 
	 * If no location data is available or the {@code sourceRegion} does not yield
	 * a location in {@code targetResource}, returns <code>null</code>.
	 * @param localRegion the region in the current resource. May not be <code>null</code>.
	 * @param associatedStorage the expected target resource. May not be <code>null</code>.
	 * @return the best associated location or <code>null</code> if none.
	 */
	/* @Nullable */ ILocationInResource getBestAssociatedLocation(ITextRegion localRegion, IStorage associatedStorage);
	
	/**
	 * Returns all individual {@link ILocationInResource locations} that match the given {@code sourceRegion}
	 * for the expected {@code targetResource}.
	 * @param localRegion the region in the current resource. May not be <code>null</code>.
	 * @param associatedStorage the expected target resource. May not be <code>null</code>.
	 * @return all associated locations. Never <code>null</code>. 
	 */
	Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion localRegion, IStorage associatedStorage);
	
	/**
	 * Returns all known {@link ILocationInResource locations} that were produced from the associated resource
	 * in the given {@code targetResource}.
	 * @param associatedStorage the expected target resource. May not be <code>null</code>.
	 * @return all locations. Never <code>null</code>. 
	 */
	Iterable<ILocationInResource> getAllAssociatedLocations(IStorage associatedStorage);
	
	interface Internal {
		
		/* @Nullable */
		AbstractTraceRegion getRootTraceRegion();
		
	}
}
