/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.generator.trace.ITraceToSource;
import org.eclipse.xtext.generator.trace.ITraceToTarget;
import org.eclipse.xtext.util.ITextRegion;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class FileBasedTraceInformation implements ITraceInformation {

	public static final String TRACE_FILE_EXTENSION = "_trace";

	@Inject
	private Provider<FileBasedTraceToSource> traceToSourceProvider;
	
	public ILocationInResource getSingleSourceInformation(IResource derivedResource, LanguageInfo languageInfo,
			ITextRegion range) {
		if (derivedResource instanceof IStorage) {
			ITraceToSource traceToSource = getTraceToSource((IStorage) derivedResource);
			if (traceToSource != null) {
				if (range == null) {
					return null;
				} else {
					if (languageInfo == null) {
						return traceToSource.getBestAssociatedLocation(range, languageInfo);
					} else {
						return traceToSource.getBestAssociatedLocation(range);
					}
				}				
			}
		}
		return null;
	}

	public Iterable<ILocationInResource> getAllSourceInformation(IResource derivedResource, LanguageInfo languageInfo,
			ITextRegion range) {
		if (derivedResource instanceof IStorage) {
			ITraceToSource traceToSource = getTraceToSource((IStorage) derivedResource);
			if (traceToSource != null) {
				if (range == null) {
					if (languageInfo != null) {
						return traceToSource.getAllLocations(languageInfo);
					} else {
						return traceToSource.getAllLocations();
					}
				} else {
					if (languageInfo == null) {
						return traceToSource.getAllAssociatedLocations(range);
					} else {
						return traceToSource.getAllAssociatedLocations(range, languageInfo);
					}
				}				
			}
		}
		return null;
	}

	public ITraceToSource getTraceToSource(IStorage derivedResource) {
		FileBasedTraceToSource result = traceToSourceProvider.get();
		result.setResource(derivedResource);
		return result;
	}

	public ITraceToTarget getTraceToTarget(IStorage sourceResource) {
		return null;
	}

}
