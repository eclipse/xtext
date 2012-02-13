/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.util.ITextRegion;

/**
 * Provides read access to the available trace information for generated resources or input resources.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @noextend This interface is not intended to be extended by clients.
 * @since 2.3
 */
@NonNullByDefault
public interface ITraceInformation {
	
	/**
	 * Return the source information for the given derived resource if exactly one source information is present.
	 * @param derivedResource the generated file. May not be <code>null</code>.
	 * @param languageInfo the expected language information. <code>null</code> if all languages should be considered.
	 * @param range the offset information. May be <code>null</code>.
	 * @return the only available source information or <code>null</code> if more than one or no data is available.
	 */
	@Nullable
	ILocationInResource getSingleSourceInformation(IResource derivedResource, @Nullable LanguageInfo languageInfo, @Nullable ITextRegion range);
	
	/**
	 * Return all the source information for the given derived resource.
	 * @param derivedResource the generated file. May not be <code>null</code>.
	 * @param languageInfo the language that the location data should belong to. <code>null</code> if all languages should be considered.
	 * @param range the offset information. May be <code>null</code>.
	 * @return all the associated source data. Never <code>null</code>. An empty iterable if no source data is available.
	 */
	Iterable<ILocationInResource> getAllSourceInformation(IResource derivedResource, @Nullable LanguageInfo languageInfo, @Nullable ITextRegion range);
	
	/**
	 * Returns the trace information to the sources that were used as input for the given derived resource.
	 * May return <code>null</code> if no such data is available for the given storage.
	 * @param derivedResource the resource whose source trace is requested. May not be <code>null</code>.
	 * @return the trace to the source or <code>null</code>.
	 */
	@Nullable ITraceToSource getTraceToSource(IStorage derivedResource);
	
	/**
	 * Returns the trace information to the targets that were generated from the given source.
	 * May return <code>null</code> if no such data is available for the given storage.
	 * @param sourceResource the resource whose target trace is requested. May not be <code>null</code>.
	 * @return the trace to the generation targets or <code>null</code>.
	 */
	@Nullable ITraceToTarget getTraceToTarget(IStorage sourceResource);
	
}