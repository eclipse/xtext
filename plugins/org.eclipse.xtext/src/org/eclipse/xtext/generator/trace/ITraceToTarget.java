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
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.util.ITextRegion;

/**
 * The target trace allows to find the generated artifacts for
 * a given source resource.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 */
@NonNullByDefault
public interface ITraceToTarget extends ITrace {

	/**
	 * Returns the source resource. Never <code>null</code>.
	 * @return the source resource. Never <code>null</code>.
	 */
	IStorage getSource();
	
	/**
	 * Returns the source project. Never <code>null</code>.
	 * @return the source project. Never <code>null</code>.
	 */
	IProject getSourceProject();
	
	/**
	 * Returns the URI of the source resource. Never <code>null</code>.
	 * @return the URI of the source resource. Never <code>null</code>.
	 */
	URI getSourceURI();
	
	/**
	 * Returns the language that is associated with the source resource. Never <code>null</code>.
	 * @return the language that is associated with the source resource. Never <code>null</code>.
	 */
	LanguageInfo getLanguage();
	
	/**
	 * Returns all known targets for the associated source resource.
	 * @return all known targets. Never <code>null</code>.
	 */
	Iterable<ITraceToSource> getAllTargets();
	
	/**
	 * Returns the source trace for the given storage or <code>null</code> if none.
	 * @param targetResource the expected target resource. May not be <code>null</code>.
	 * @return the source trace for the given storage or <code>null</code> if none.
	 */
	@Nullable ITraceToSource getTarget(IStorage targetResource);

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
	 * @param sourceRegion the region in the current resource. May not be <code>null</code>.
	 * @param targetResource the expected target resource. May not be <code>null</code>.
	 * @return the best associated location or <code>null</code> if none.
	 */
	@Nullable ILocationInResource getBestAssociatedLocation(ITextRegion sourceRegion, IStorage targetResource);
	
	/**
	 * Returns all individual {@link ILocationInResource locations} that match the given {@code sourceRegion}
	 * for the expected {@code targetResource}.
	 * @param sourceRegion the region in the current resource. May not be <code>null</code>.
	 * @param targetResource the expected target resource. May not be <code>null</code>.
	 * @return all associated locations. Never <code>null</code>. 
	 */
	Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion sourceRegion, IStorage targetResource);
	
	/**
	 * Returns all known {@link ILocationInResource locations} that were produced from the associated resource
	 * in the given {@code targetResource}.
	 * @param targetResource the expected target resource. May not be <code>null</code>.
	 * @return all locations. Never <code>null</code>. 
	 */
	Iterable<ILocationInResource> getAllLocations(IStorage targetResource);
	
}
