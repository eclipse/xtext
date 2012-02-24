/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.TraceRegion;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractTrace implements ITrace, ITrace.Internal {

	protected class TraceRegionsByURI implements Iterable<AbstractTraceRegion> {
		private final Iterable<AbstractTraceRegion> allTraceRegions;
		private final URI uri;

		protected TraceRegionsByURI(Iterable<AbstractTraceRegion> allTraceRegions, URI uri) {
			this.allTraceRegions = allTraceRegions;
			this.uri = uri;
		}

		public Iterator<AbstractTraceRegion> iterator() {
			Iterator<AbstractTraceRegion> result = allTraceRegions.iterator();
			Iterator<AbstractTraceRegion> languageSpecificWithDuplicates = Iterators.transform(result, new Function<AbstractTraceRegion, AbstractTraceRegion>() {
				@Nullable
				public AbstractTraceRegion apply(@Nullable AbstractTraceRegion input) {
					return findParentByURI(input, uri);
				}
			});
			Iterator<AbstractTraceRegion> withoutDuplicates = Iterators.filter(languageSpecificWithDuplicates, new Predicate<AbstractTraceRegion>() {
				private AbstractTraceRegion previous = null;
				public boolean apply(@Nullable AbstractTraceRegion input) {
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
	private IStorage2UriMapper storage2uriMapper;
	
	@Inject
	private IWorkspace workspace;
	
	private AbstractTraceRegion rootTraceRegion;
	
	/**
	 * Returns the root trace region where {@link TraceRegion#getMyOffset()} and
	 * {@link TraceRegion#getMyLength()} return the information for the
	 * resource that this {@link ITrace} is associated with. 
	 * @return the root trace region. May be <code>null</code> if no trace data is available.
	 */
	@Nullable
	public final AbstractTraceRegion getRootTraceRegion() {
		if (rootTraceRegion == null) {
			rootTraceRegion = doGetRootTraceRegion();
		}
		return rootTraceRegion;
	}
	
	@Nullable
	protected abstract AbstractTraceRegion doGetRootTraceRegion();

	@Nullable
	public ILocationInResource getBestAssociatedLocation(ITextRegion region) {
		AbstractTraceRegion left = findLeafAtLeftOffset(region.getOffset());
		AbstractTraceRegion right = findLeafAtRightOffset(region.getOffset() + region.getLength());
		return mergeRegions(left, right);
	}

	@Nullable
	protected ILocationInResource mergeRegions(@Nullable AbstractTraceRegion left, @Nullable AbstractTraceRegion right) {
		if (left == null) {
			if (right != null) {
				ILocationData locationData = right.getMergedAssociatedLocation();
				if (locationData != null)
					return createLocationInResourceFor(locationData, right);
			}
			return null;
		}
		if (right == null || left.equals(right)) {
			ILocationData locationData = left.getMergedAssociatedLocation();
			if (locationData != null)
				return createLocationInResourceFor(locationData, left);
			return null;
		} else {
			URI leftToPath = left.getAssociatedPath();
			URI rightToPath = right.getAssociatedPath();
			if (leftToPath != null && leftToPath.equals(rightToPath) || leftToPath == rightToPath) {
				Set<AbstractTraceRegion> parents = Sets.newHashSet();
				AbstractTraceRegion candidate = left;
				while(candidate != null) {
					URI candidatePath = candidate.getAssociatedPath();
					if (leftToPath != null && leftToPath.equals(candidatePath) || leftToPath == candidatePath) 
						parents.add(candidate);
					candidate = candidate.getParent();
				}
				AbstractTraceRegion potentialMatch = right;
				while(potentialMatch != null && !parents.contains(potentialMatch)) {
					potentialMatch = potentialMatch.getParent();
				}
				if (potentialMatch != null) {
					ILocationData location = potentialMatch.getMergedAssociatedLocation();
					if (location != null)
						return createLocationInResourceFor(location, left);
				}
				return null;
			}
		} 
		// TODO the remaining cases have yet to be implemented
		throw new IllegalStateException("TODO the remaining cases have yet to be implemented");
	}

	/**
	 * Creates a new location for a target resource that matches the given {@code location}.
	 * @param location the location
	 * @return the location in resource. Never <code>null</code>.
	 */
	protected ILocationInResource createLocationInResourceFor(ILocationData location, AbstractTraceRegion traceRegion) {
		URI path = location.getPath();
		if (path == null)
			path = traceRegion.getAssociatedPath();
		String projectName = location.getProjectName();
		if (projectName == null)
			projectName = traceRegion.getAssociatedProjectName();
		return new OffsetBasedLocationInResource(location.getOffset(), location.getLength(), location.getLineNumber(), location.getEndLineNumber(), path, projectName, this);
	}
	
	@Nullable
	public AbstractTraceRegion findLeafAtRightOffset(int offset) {
		return findLeafNodeAt(offset, true);
	}

	@Nullable
	protected AbstractTraceRegion findLeafNodeAt(int offset, boolean left) {
		AbstractTraceRegion candidate = getRootTraceRegion();
		if (candidate == null || !encloses(candidate, offset, left)) {
			// we have an inconsistent state - no candidate matches
			return null;
		}
		outer: while(candidate != null) {
			List<? extends AbstractTraceRegion> children = candidate.getNestedRegions();
			if (children.isEmpty()) {
				return candidate;
			}
			for(AbstractTraceRegion child: children) {
				if (encloses(child, offset, left)) {
					candidate = child;
					continue outer;
				} else {
					if (child.getMyOffset() > offset)
						return candidate;
				}
			}
			return candidate;
		}
		return null;
	}

	@Nullable
	public AbstractTraceRegion findLeafAtLeftOffset(int offset) {
		return findLeafNodeAt(offset, false);
	}
	
	/**
	 * Calculate whether the given {@code region} encloses the offset.
	 * @param region the region to be checked. May not be <code>null</code>.
	 * @param offset the offset that should be enclosed by the region.
	 * @param includeRegionEnd whether a region is enclosing the offset if it ends at that location.
	 * @return <code>true</true> if the given region encloses the offset.
	 */
	public boolean encloses(AbstractTraceRegion region, int offset, boolean includeRegionEnd) {
//		if (offset < 0)
//			// TODO should this be "return false;" instead?
//			throw new IllegalArgumentException("offset may not be negative");
//		int relativeOffset = offset - region.getMyOffset();
//		boolean result = relativeOffset >= 0 && (includeRegionEnd ? relativeOffset <= region.getMyLength() : relativeOffset < region.getMyLength());
//		return result;
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

	public Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion localRegion) {
		Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions(localRegion);
		return toLocations(allTraceRegions);
	}
	
	@Nullable
	public ILocationInResource getBestAssociatedLocation(ITextRegion region, IStorage storage) {
		URI uri = storage2uriMapper.getUri(storage);
		AbstractTraceRegion left = findLeafAtLeftOffset(region.getOffset());
		left = findParentByURI(left, uri);
		AbstractTraceRegion right = findLeafAtRightOffset(region.getOffset() + region.getLength());
		right = findParentByURI(left, uri);
		return mergeRegions(left, right);
	}
	
	protected boolean isAssociatedWith(AbstractTraceRegion region, URI uri) {
		if (uri.equals(region.getAssociatedPath()))
			return true;
		return false;
	}
	
	@Nullable
	protected AbstractTraceRegion findParentByURI(@Nullable AbstractTraceRegion region, URI uri) {
		while(region != null && !isAssociatedWith(region, uri)) {
			region = region.getParent();
		}
		return region;
	}

	public Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion region, IStorage storage) {
		URI uri = storage2uriMapper.getUri(storage);
		final Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions(region);
		Iterable<AbstractTraceRegion> filteredByURI = new TraceRegionsByURI(allTraceRegions, uri);
		return toLocations(filteredByURI);
	}

	public Iterable<ILocationInResource> getAllAssociatedLocations(IStorage storage) {
		URI uri = storage2uriMapper.getUri(storage);
		final Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions();
		Iterable<AbstractTraceRegion> filteredByURI = new TraceRegionsByURI(allTraceRegions, uri);
		return toLocations(filteredByURI);
	}
	
	@Nullable
	public LanguageInfo getLanguage() {
		return findLanguage(getLocalURI());
	}
	
	public URI getLocalURI() {
		final URI uri = storage2uriMapper.getUri(getLocalStorage());
		if (uri != null) {
			return uri;
		}
		return URI.createURI(getLocalStorage().getFullPath().toPortableString());
	}
	
	public abstract IProject getLocalProject();
	
	public abstract IStorage getLocalStorage();
	
	protected Iterable<ILocationInResource> toLocations(Iterable<AbstractTraceRegion> allTraceRegions) {
		List<ILocationInResource> result = Lists.newArrayList();
		for(AbstractTraceRegion region: allTraceRegions) {
			for(ILocationData locationData: region.getAssociatedLocations()) {
				result.add(createLocationInResourceFor(locationData, region));
			}
		}
		return result;
	}

	protected Iterable<AbstractTraceRegion> getAllTraceRegions(ITextRegion localRegion) {
		final AbstractTraceRegion left = findLeafAtLeftOffset(localRegion.getOffset());
		final AbstractTraceRegion right = findLeafAtRightOffset(localRegion.getOffset() + localRegion.getLength());
		if (left == null || right == null) {
			return Collections.emptyList();
		}
		return new Iterable<AbstractTraceRegion>() {

			public Iterator<AbstractTraceRegion> iterator() {
				AbstractTraceRegion root = getRootTraceRegion();
				if (root == null)
					return Iterators.emptyIterator();
				final Iterator<AbstractTraceRegion> allLeafs = root.leafIterator();
				Iterator<AbstractTraceRegion> result = new AbstractIterator<AbstractTraceRegion>() {
					
					AbstractTraceRegion first;
					{
						while(allLeafs.hasNext()) {
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
						if (candidate.getMyOffset() >= right.getMyOffset() + right.getMyLength()) {
							return endOfData();
						}
						return candidate;
					}
				};
				return result;
			}
			
		};
	}

	public Iterable<ILocationInResource> getAllAssociatedLocations() {
		Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions();
		return toLocations(allTraceRegions);		
	}
	
	protected Iterable<AbstractTraceRegion> getAllTraceRegions() {
		return new Iterable<AbstractTraceRegion>() {
			public Iterator<AbstractTraceRegion> iterator() {
				AbstractTraceRegion root = getRootTraceRegion();
				if (root == null)
					return Iterators.emptyIterator();
				final Iterator<AbstractTraceRegion> result = root.leafIterator();
				return result;
			}
		};
	}

	@Nullable
	protected Resource getResource(URI uri, IProject project) {
		IResourceSetProvider resourceSetProvider = getService(uri, IResourceSetProvider.class);
		if (resourceSetProvider != null) {
			ResourceSet resourceSet = resourceSetProvider.get(project);
			try {
				Resource result = resourceSet.getResource(uri, true);
				return result;
			} catch(RuntimeException e) {
				// expected
				return null;
			}
		}
		return null;
	}

	protected IStorage findStorage(URI uri, IProject project) {
		Iterable<Pair<IStorage, IProject>> allStorages = storage2uriMapper.getStorages(uri);
		for(Pair<IStorage, IProject> storage: allStorages) {
			if (project.equals(storage.getSecond())) {
				return storage.getFirst();
			}
		}
		throw new IllegalStateException("No storage found for given path: " + uri);
	}
	
	protected IProject findProject(String projectName) {
		IProject result = workspace.getRoot().getProject(projectName);
		return result;
	}
	
	@Nullable
	protected LanguageInfo findLanguage(@Nullable URI uri) {
		return getService(uri, LanguageInfo.class);
	}
	
	@Nullable
	protected <T> T getService(@Nullable URI uri, Class<T> type) {
		if (uri == null)
			return null;
		IResourceServiceProvider serviceProvider = resourceServiceRegistry.getResourceServiceProvider(uri);
		if (serviceProvider != null) {
			return serviceProvider.get(type);
		}
		return null;
	}

}
