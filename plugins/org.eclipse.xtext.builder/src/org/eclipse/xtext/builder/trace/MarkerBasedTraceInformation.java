/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.util.Arrays;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITraceInformation;
import org.eclipse.xtext.generator.trace.ITraceToSource;
import org.eclipse.xtext.generator.trace.ITraceToTarget;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class MarkerBasedTraceInformation implements ITraceInformation {

	private static final Logger logger = Logger.getLogger(MarkerBasedTraceInformation.class);
	
	@Inject
	private IDerivedResourceMarkers derivedResourceMarkers;

	@Inject
	private IStorage2UriMapper storage2UriMapper;
	
	@Inject
	private Provider<LocationInResource> locationProvider;
	
	@Nullable
	public ILocationInResource getSingleSourceInformation(IResource derivedResource, @Nullable LanguageInfo languageInfo, @Nullable ITextRegion range) {
		try {
			if (derivedResource instanceof IFile) {
				// TODO consider the range if there are more markers than 1
				IFile derivedFile = (IFile) derivedResource;
				IMarker[] markers = derivedResourceMarkers.findDerivedResourceMarkers(derivedFile);
				if (markers.length != 1) {
					return null;
				}
				IMarker marker = markers[0];
				String source = derivedResourceMarkers.getSource(marker);
				if (source != null) {
					URI sourceResourceURI = URI.createURI(source);
					Iterable<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(sourceResourceURI);
					// prefer same project as generated resource
					for(Pair<IStorage, IProject> storage2Project: storages) {
						if (derivedFile.getProject().equals(storage2Project.getSecond())) {
							LocationInResource result = locationProvider.get();
							result.init(sourceResourceURI, storage2Project.getFirst(), storage2Project.getSecond());
							if (languageInfo == null || languageInfo.equals(result.getLanguage())) {
								return result;
							}
						}
					}
					// we are fine with arbitrary projects
					for(Pair<IStorage, IProject> storage2Project: storages) {
						if (!derivedFile.getProject().equals(storage2Project.getSecond())) {
							LocationInResource result = locationProvider.get();
							result.init(sourceResourceURI, storage2Project.getFirst(), storage2Project.getSecond());
							if (languageInfo == null || languageInfo.equals(result.getLanguage())) {
								return result;
							}
						}
					}
				}
			}
		} catch(CoreException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
		return null;
	}

	public Iterable<ILocationInResource> getAllSourceInformation(IResource derivedResource, final @Nullable LanguageInfo languageInfo, @Nullable ITextRegion range) {
		try {
			if (derivedResource instanceof IFile) {
				// TODO consider the range
				IFile derivedFile = (IFile) derivedResource;
				IMarker[] markers = derivedResourceMarkers.findDerivedResourceMarkers(derivedFile);
				if (markers.length == 0)
					return Collections.emptyList();
				Iterable<Iterable<ILocationInResource>> allLocations = Iterables.transform(Arrays.asList(markers), new Function<IMarker, Iterable<ILocationInResource>>() {
					public Iterable<ILocationInResource> apply(@Nullable IMarker marker) {
						if (marker == null)
							throw new IllegalArgumentException("marker may not be null");
						String source = derivedResourceMarkers.getSource(marker);
						if (source != null) {
							final URI sourceResourceURI = URI.createURI(source);
							Iterable<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(sourceResourceURI);
							return Iterables.transform(storages, new Function<Pair<IStorage, IProject>, ILocationInResource>() {
								@Nullable
								public ILocationInResource apply(@Nullable Pair<IStorage, IProject> input) {
									if (input == null)
										throw new IllegalArgumentException("input may not be null");
									LocationInResource result = locationProvider.get();
									result.init(sourceResourceURI, input.getFirst(), input.getSecond());
									if (languageInfo == null || languageInfo.equals(result.getLanguage())) {
										return result;
									}
									return null;
								}
							});
						}
						return Collections.emptyList();
					}
				});
				Iterable<ILocationInResource> result = Iterables.filter(Iterables.concat(allLocations), Predicates.notNull());
				return result;
			}
		} catch(CoreException e) {
			logger.error(e.getMessage(), e);
		}
		return Collections.emptyList();
	}

	public ITraceToSource getTraceToSource(final IStorage derivedResource) {
		return new ITraceToSource() {
			
			@Nullable
			public ILocationInResource getBestAssociatedLocation(ITextRegion region) {
				if (derivedResource instanceof IResource)
					return getSingleSourceInformation((IResource) derivedResource, null, region);
				return null;
			}
			
			@Nullable
			public ILocationInResource getBestAssociatedLocation(ITextRegion region, LanguageInfo language) {
				if (derivedResource instanceof IResource)
					return getSingleSourceInformation((IResource) derivedResource, language, region);
				return null;
			}
			
			public Iterable<ILocationInResource> getAllLocations() {
				if (derivedResource instanceof IResource)
					return getAllSourceInformation((IResource) derivedResource, null, null);
				return Collections.emptyList();
			}
			
			public Iterable<ILocationInResource> getAllLocations(LanguageInfo language) {
				if (derivedResource instanceof IResource)
					return getAllSourceInformation((IResource) derivedResource, language, null);
				return Collections.emptyList();
			}
			
			public Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion region) {
				if (derivedResource instanceof IResource)
					return getAllSourceInformation((IResource) derivedResource, null, region);
				return Collections.emptyList();
			}
			
			public Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion region, LanguageInfo language) {
				if (derivedResource instanceof IResource)
					return getAllSourceInformation((IResource) derivedResource, language, region);
				return Collections.emptyList();
			}
			
			public IStorage getDerivedResource() {
				return derivedResource;
			}
			
			public Iterable<ITraceToTarget> getAllSources() {
				logger.info("MarkerBasedTraceInformation does not support trace to target");
				return Collections.emptyList();
			}
			
			public Iterable<ITraceToTarget> getAllSources(LanguageInfo language) {
				logger.info("MarkerBasedTraceInformation does not support trace to target");
				return Collections.emptyList();
			}
		};
	}
	
	@Nullable
	public ITraceToTarget getTraceToTarget(IStorage sourceResource) {
		logger.info("MarkerBasedTraceInformation does not support trace to target");
		return null;
	}

}
