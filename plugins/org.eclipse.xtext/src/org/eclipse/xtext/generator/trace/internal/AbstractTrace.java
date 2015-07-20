/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForURIProvider;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.TraceNotFoundException;
import org.eclipse.xtext.generator.trace.TraceRegion;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.workspace.IProjectConfig;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTrace implements ITrace {

	protected class TraceRegionsByURI implements Iterable<AbstractTraceRegion> {
		private final Iterable<? extends AbstractTraceRegion> allTraceRegions;
		private final URI uri;
		private final IProjectConfig projectConfig;

		public TraceRegionsByURI(Iterable<? extends AbstractTraceRegion> allTraceRegions, URI uri, IProjectConfig projectConfig) {
			this.allTraceRegions = allTraceRegions;
			this.uri = uri;
			this.projectConfig = projectConfig;
		}

		@Override
		public Iterator<AbstractTraceRegion> iterator() {
			Iterator<? extends AbstractTraceRegion> result = allTraceRegions.iterator();
			Iterator<AbstractTraceRegion> languageSpecificWithDuplicates = Iterators.transform(result, new Function<AbstractTraceRegion, AbstractTraceRegion>() {
				/* @Nullable */
				@Override
				public AbstractTraceRegion apply(/* @Nullable */ AbstractTraceRegion input) {
					return findParentByURI(input, uri, projectConfig);
				}
			});
			Iterator<AbstractTraceRegion> withoutDuplicates = Iterators.filter(languageSpecificWithDuplicates, new Predicate<AbstractTraceRegion>() {
				private AbstractTraceRegion previous = null;
				@Override
				public boolean apply(/* @Nullable */ AbstractTraceRegion input) {
					if (input == null || input.equals(previous))
						return false;
					previous = input;
					return true;
				}
			});
			return withoutDuplicates;
		}
	}
	
	@Inject
	private IResourceServiceProvider.Registry resourceServiceRegistry;
	
	@Inject
	private ITraceForURIProvider traceProvider;
	
	private AbstractTraceRegion rootTraceRegion;
	
	private ITraceRegionProvider traceRegionProvider;
	
	private boolean isTraceToSource;
	
	/**
	 * Returns the root trace region where {@link TraceRegion#getMyOffset()} and
	 * {@link TraceRegion#getMyLength()} return the information for the
	 * resource that this {@link ITrace} is associated with. 
	 * @return the root trace region. May be <code>null</code> if no trace data is available.
	 */
	/* @Nullable */
	public final AbstractTraceRegion getRootTraceRegion() {
		if (rootTraceRegion == null) {
			rootTraceRegion = doGetRootTraceRegion();
		}
		return rootTraceRegion;
	}
	
	@Override
	public boolean hasTraceData() {
		return getRootTraceRegion() != null;
	}
	
	public void setTraceToSource(boolean isTraceToSource) {
		this.isTraceToSource = isTraceToSource;
	}
	
	public boolean isTraceToSource() {
		return isTraceToSource;
	}
	
	public boolean isTraceToTarget() {
		return !isTraceToSource;
	}
	
	/* @Nullable */
	protected AbstractTraceRegion doGetRootTraceRegion() {
		try {
			return traceRegionProvider.getTraceRegion();
		} catch (TraceNotFoundException noTraceFound) {
			return null;
		}
	}

	protected void setTraceRegionProvider(ITraceRegionProvider traceRegionProvider) {
		this.traceRegionProvider = traceRegionProvider;
	}

	protected ITraceRegionProvider getTraceRegionProvider() {
		return traceRegionProvider;
	}

	/* @Nullable */
	@Override
	public ILocationInResource getBestAssociatedLocation(ITextRegion region) {
		AbstractTraceRegion right = findTraceRegionAtRightOffset(region.getOffset() + region.getLength());
		if (right != null && encloses(right, region.getOffset(), true)) {
			if (right.getMyOffset() + right.getMyLength() == region.getOffset() + region.getLength())
				return getMergedLocationInResource(right);
		}
		
		AbstractTraceRegion left = findTraceRegionAtLeftOffset(region.getOffset());
		return mergeRegions(left, right);
	}

	/* @Nullable */
	protected ILocationInResource mergeRegions(/* @Nullable */ AbstractTraceRegion left, /* @Nullable */ AbstractTraceRegion right) {
		if (left == null) {
			if (right != null) {
				return getMergedLocationInResource(right);
			}
			return null;
		}
		if (right == null || left.equals(right)) {
			return getMergedLocationInResource(left);
		} else {
			URI leftToPath = left.getAssociatedPath();
			URI rightToPath = right.getAssociatedPath();
			if (leftToPath != null && leftToPath.equals(rightToPath) || leftToPath == rightToPath) {
				ITextRegionWithLineInformation leftRegion = left.getMyRegion();
				ITextRegionWithLineInformation rightRegion = right.getMyRegion();
				if (leftRegion.contains(rightRegion)) {
					return getMergedLocationInResource(left);
				} else if (rightRegion.contains(leftRegion)) {
					return getMergedLocationInResource(right);
				} else {
					AbstractTraceRegion parent = left.getParent();
					AbstractTraceRegion leftChild = left;
					while(parent != null) {
						if (parent.getMyRegion().contains(rightRegion)) {
							break;
						}
						leftChild = parent;
						parent = parent.getParent();
					}
					if (parent != null) {
						AbstractTraceRegion rightChild = right;
						while(!parent.equals(rightChild.getParent())) {
							rightChild = rightChild.getParent();
							if (rightChild == null) {
								return getMergedLocationInResource(leftChild);
							}
						}
						URI path = leftToPath;
						if (path == null) {
							path = leftChild.getAssociatedPath();
						}
						ITextRegionWithLineInformation merged = parent.getMergedAssociatedLocation();
						if (merged != null) {
							return createLocationInResource(merged, path);
						}
					}
				}
			}
		} 
		// TODO the remaining cases have yet to be implemented
		return null;
	}

	protected ILocationInResource createLocationInResource(ITextRegionWithLineInformation region, URI srcRelativePath) {
		return new LocationInResource(region.getOffset(), region.getLength(), region.getLineNumber(), region.getEndLineNumber(), srcRelativePath, this);
	}

	/* @Nullable */
	protected ILocationInResource getMergedLocationInResource(AbstractTraceRegion region) {
		ILocationData locationData = region.getMergedAssociatedLocation();
		if (locationData != null)
			return createLocationInResourceFor(locationData, region);
		return null;
	}

	/**
	 * Creates a new location for a target resource that matches the given {@code location}.
	 * @param location the location
	 * @return the location in resource, <code>null</code> detecting a path fails.
	 */
	/* @Nullable */
	protected ILocationInResource createLocationInResourceFor(ILocationData location, AbstractTraceRegion traceRegion) {
		URI path = location.getPath();
		if (path == null)
			path = traceRegion.getAssociatedPath();
		if (path == null)
			return null;
		return createLocationInResource(location, path);
	}
	
	protected URI resolvePath(URI path) {
		return path;
	}
	
	/* @Nullable */
	public AbstractTraceRegion findTraceRegionAtRightOffset(int offset) {
		return findTraceRegionAt(offset, true);
	}

	/* @Nullable */
	protected AbstractTraceRegion findTraceRegionAt(int offset, boolean includeRegionEnd) {
		AbstractTraceRegion candidate = getRootTraceRegion();
		if (candidate == null || !encloses(candidate, offset, includeRegionEnd)) {
			// we have an inconsistent state - no candidate matches
			return null;
		}
		outer: while(candidate != null) {
			// TODO binary search?
			List<? extends AbstractTraceRegion> children = candidate.getNestedRegions();
			if (children.isEmpty()) {
				return candidate;
			}
			for(AbstractTraceRegion child: children) {
				if (encloses(child, offset, includeRegionEnd)) {
					candidate = child;
					continue outer;
				} else {
					if (child.getMyOffset() > offset) {
						return candidate;
					}
				}
			}
			return candidate;
		}
		return null;
	}

	/* @Nullable */
	public AbstractTraceRegion findTraceRegionAtLeftOffset(int offset) {
		return findTraceRegionAt(offset, false);
	}
	
	/**
	 * Calculate whether the given {@code region} encloses the offset.
	 * @param region the region to be checked. May not be <code>null</code>.
	 * @param offset the offset that should be enclosed by the region.
	 * @param includeRegionEnd whether a region is enclosing the offset if it ends at that location.
	 * @return <code>true</true> if the given region encloses the offset.
	 */
	public boolean encloses(AbstractTraceRegion region, int offset, boolean includeRegionEnd) {
		return encloses(region.getMyOffset(), region.getMyLength(), offset, includeRegionEnd);
	}
	
	/**
	 * Calculate whether the given {@code region} encloses the offset.
	 * @param regionOffset the start of the region that should be checked.
	 * @param regionLength the length of the region that should be checked.
	 * @param offset the offset that should be enclosed by the region.
	 * @param includeRegionEnd whether a region is enclosing the offset if it ends at that location.
	 * @return <code>true</true> if the given region encloses the offset.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public boolean encloses(int regionOffset, int regionLength, int offset, boolean includeRegionEnd) {
		if (offset < 0)
			// TODO should this be "return false;" instead?
			throw new IllegalArgumentException("offset may not be negative");
		int relativeOffset = offset - regionOffset;
		boolean result = relativeOffset == 0 || (relativeOffset > 0 && (includeRegionEnd ? relativeOffset <= regionLength : relativeOffset < regionLength));
		return result;
	}

	@Override
	public Iterable<? extends ILocationInResource> getAllAssociatedLocations(ITextRegion localRegion) {
		Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions(localRegion);
		return toLocations(allTraceRegions);
	}
	
	@Override
	public ILocationInResource getBestAssociatedLocation(ITextRegion localRegion, URI uri) {
		IProjectConfig projectConfig = getLocalProjectConfig();
		AbstractTraceRegion left = findTraceRegionAtLeftOffset(localRegion.getOffset());
		left = findParentByURI(left, uri, projectConfig);
		AbstractTraceRegion right = findTraceRegionAtRightOffset(localRegion.getOffset() + localRegion.getLength());
		right = findParentByURI(right, uri, projectConfig);
		return mergeRegions(left, right);
	}
	
	protected boolean isAssociatedWith(AbstractTraceRegion region, URI uri, IProjectConfig project) {
		ITraceURIConverter traceURIConverter = getService(uri, ITraceURIConverter.class);
		if (traceURIConverter == null) {
			traceURIConverter = getService(getLocalURI(), ITraceURIConverter.class);
		}
		URI convertedUri = traceURIConverter.getURIForTrace(project, uri);
		return convertedUri.equals(region.getAssociatedPath());
	}
	
	/* @Nullable */
	protected AbstractTraceRegion findParentByURI(/* @Nullable */ AbstractTraceRegion region, URI uri, IProjectConfig project) {
		while(region != null && !isAssociatedWith(region, uri, project)) {
			region = region.getParent();
		}
		return region;
	}
	
	@Override
	public Iterable<? extends ILocationInResource> getAllAssociatedLocations(ITextRegion localRegion, URI uri) {
		final Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions(localRegion);
		Iterable<AbstractTraceRegion> filteredByURI = new TraceRegionsByURI(allTraceRegions, uri, getLocalProjectConfig());
		return toLocations(filteredByURI);
	}
	
	@Override
	public Iterable<? extends ILocationInResource> getAllAssociatedLocations(URI uri) {
		final Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions();
		Iterable<AbstractTraceRegion> filteredByURI = new TraceRegionsByURI(allTraceRegions, uri, getLocalProjectConfig());
		return toLocations(filteredByURI);
	}
	
	/* @Nullable */
	@Override
	public LanguageInfo getLanguage() {
		return findLanguage(getLocalURI());
	}
	
	@Override
	public abstract URI getLocalURI();

	@Override
	public abstract IProjectConfig getLocalProjectConfig();
	
	protected Iterable<? extends ILocationInResource> toLocations(final Iterable<AbstractTraceRegion> allTraceRegions) {
		return new Iterable<ILocationInResource>() {

			@Override
			public Iterator<ILocationInResource> iterator() {
				return new AbstractIterator<ILocationInResource>() {

					private Iterator<AbstractTraceRegion> delegate = allTraceRegions.iterator();
					private AbstractTraceRegion region;
					private Iterator<ILocationData> locationDelegate;
					
					@Override
					protected ILocationInResource computeNext() {
						while(true) {
							if (locationDelegate == null || !locationDelegate.hasNext()) {
								if (delegate.hasNext()) {
									region = delegate.next();
									locationDelegate = region.getAssociatedLocations().iterator();
									if (!locationDelegate.hasNext()) {
										continue;
									}
								}
							}
							if (locationDelegate != null && locationDelegate.hasNext()) {
								ILocationData locationData = locationDelegate.next();
								ILocationInResource result = createLocationInResourceFor(locationData, region);
								if (result != null) {
									return result;
								}
								continue;
							}
							return endOfData();
						}
					}
				};
			}
			
		};
	}

	protected Iterable<AbstractTraceRegion> getAllTraceRegions(final ITextRegion localRegion) {
		final AbstractTraceRegion left = findTraceRegionAtLeftOffset(localRegion.getOffset());
		final int end = localRegion.getOffset() + localRegion.getLength();
		if (left == null) {
			return Collections.emptyList();
		}
		return new Iterable<AbstractTraceRegion>() {

			@Override
			public Iterator<AbstractTraceRegion> iterator() {
				AbstractTraceRegion root = getRootTraceRegion();
				if (root == null)
					return ImmutableSet.<AbstractTraceRegion>of().iterator();
				final Iterator<AbstractTraceRegion> allLeafs = root.leafIterator();
				Iterator<AbstractTraceRegion> result = new AbstractIterator<AbstractTraceRegion>() {
					
					AbstractTraceRegion first;
					{
						while(first == null && allLeafs.hasNext()) {
							AbstractTraceRegion next = allLeafs.next();
							if (next.getMyOffset() == left.getMyOffset()) {
								this.first = next;
								break;
							}
						}
					}
					
					@Override
					protected AbstractTraceRegion computeNext() {
						if (first != null) {
							AbstractTraceRegion result = first;
							first = null;
							return result;
						}
						if (!allLeafs.hasNext())
							return endOfData();
						AbstractTraceRegion candidate = allLeafs.next();
						if (candidate.getMyOffset() >= end) {
							return endOfData();
						}
						return candidate;
					}
				};
				return result;
			}
			
		};
	}

	@Override
	public Iterable<? extends ILocationInResource> getAllAssociatedLocations() {
		Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions();
		return toLocations(allTraceRegions);		
	}
	
	protected Iterable<AbstractTraceRegion> getAllTraceRegions() {
		return new Iterable<AbstractTraceRegion>() {
			@Override
			public Iterator<AbstractTraceRegion> iterator() {
				AbstractTraceRegion root = getRootTraceRegion();
				if (root == null)
					return ImmutableSet.<AbstractTraceRegion>of().iterator();
				final Iterator<AbstractTraceRegion> result = root.leafIterator();
				return result;
			}
		};
	}
	
	protected static class TraceAccess implements Function<URI, ITrace> {

		private boolean traceToSource;
		private ITraceForURIProvider traceProvider;

		public TraceAccess(boolean traceToSource, ITraceForURIProvider traceProvider) {
			this.traceToSource = traceToSource;
			this.traceProvider = traceProvider;

		}

		@Override
		public ITrace apply(URI absoluteURI) {
			if (traceToSource) {
				return traceProvider.getTraceToSource(absoluteURI);
			} else {
				return traceProvider.getTraceToTarget(absoluteURI);
			}
		}

	}
	
	@Override
	public Iterable<? extends ITrace> getAllInverseTraces() {
		Map<URI, List<AbstractTraceRegion>> inverted = getRootTraceRegion().invertAll(getLocalURI());
		return Iterables.transform(inverted.keySet(), new TraceAccess(isTraceToTarget(), traceProvider));
	}
	
	@Override
	public ITrace getInverseTrace(URI uri) {
		List<AbstractTraceRegion> result = getRootTraceRegion().invertFor(uri, getLocalURI());
		if (result.isEmpty()) {
			return null;
		}
		return new TraceAccess(isTraceToTarget(), traceProvider).apply(uri);
	}

//	/* @Nullable */
//	protected Resource getResource(URI uri, IProject project) {
//		IResourceSetProvider resourceSetProvider = getService(uri, IResourceSetProvider.class);
//		if (resourceSetProvider != null) {
//			ResourceSet resourceSet = resourceSetProvider.get(project);
//			try {
//				Resource result = resourceSet.getResource(uri, true);
//				return result;
//			} catch(RuntimeException e) {
//				// expected
//				return null;
//			}
//		}
//		return null;
//	}

//	protected abstract IStorage findStorage(URI uri, IProject project);
	
	protected abstract InputStream getContents(URI uri, IProjectConfig projectConfig) throws IOException;
	
//	protected IProject findProject(String projectName) {
//		IProject result = workspace.getRoot().getProject(projectName);
//		return result;
//	}
	
//	protected IWorkspace getWorkspace() {
//		return workspace;
//	}
	
	/* @Nullable */
	protected LanguageInfo findLanguage(/* @Nullable */ URI uri) {
		return getService(uri, LanguageInfo.class);
	}
	
	/* @Nullable */
	protected <T> T getService(/* @Nullable */ URI uri, Class<T> type) {
		if (uri == null)
			return null;
		IResourceServiceProvider serviceProvider = resourceServiceRegistry.getResourceServiceProvider(uri);
		if (serviceProvider != null) {
			return serviceProvider.get(type);
		}
		return null;
	}

}
