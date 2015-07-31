/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.internal;

import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IPlatformSpecificTrace<
		PlatformResource,
		PlatformProject,
		Location extends IPlatformSpecificLocation<PlatformResource, PlatformProject>,
		Trace extends IPlatformSpecificTrace<PlatformResource, PlatformProject, Location, Trace>> extends ITrace {

	/**
	 * Returns the source project. Never <code>null</code>.
	 * @return the source project. Never <code>null</code>.
	 */
	PlatformProject getLocalProject();
	
	/**
	 * Returns the storage that is associated with this trace.
	 * @return the associated storage. Never <code>null</code>.
	 */
	PlatformResource getLocalStorage();

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
	/* @Nullable */ Location getBestAssociatedLocation(ITextRegion localRegion, PlatformResource associatedStorage);
	
	/**
	 * Returns all individual {@link ILocationInResource locations} that match the given {@code sourceRegion}
	 * for the expected {@code targetResource}.
	 * @param localRegion the region in the current resource. May not be <code>null</code>.
	 * @param associatedStorage the expected target resource. May not be <code>null</code>.
	 * @return all associated locations. Never <code>null</code>. 
	 */
	Iterable<? extends Location> getAllAssociatedLocations(ITextRegion localRegion, PlatformResource associatedStorage);
	
	/**
	 * Returns all known {@link ILocationInResource locations} that were produced from the associated resource
	 * in the given {@code targetResource}.
	 * @param associatedStorage the expected target resource. May not be <code>null</code>.
	 * @return all locations. Never <code>null</code>. 
	 */
	Iterable<? extends Location> getAllAssociatedLocations(PlatformResource associatedStorage);

	@Override
	Location getBestAssociatedLocation(ITextRegion localRegion);

	@Override
	Iterable<? extends Location> getAllAssociatedLocations(ITextRegion localRegion);

	@Override
	Iterable<? extends Location> getAllAssociatedLocations();

	@Override
	Iterable<? extends Trace> getAllInverseTraces();

	@Override
	Trace getInverseTrace(AbsoluteURI uri);

	@Override
	Location getBestAssociatedLocation(ITextRegion localRegion, AbsoluteURI uri);

	@Override
	Iterable<? extends Location> getAllAssociatedLocations(ITextRegion localRegion, AbsoluteURI uri);

	@Override
	Iterable<? extends Location> getAllAssociatedLocations(AbsoluteURI uri);


	
}
