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
import org.eclipse.core.resources.IWorkspaceRoot;
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

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractTrace implements ITrace {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceRegistry;
	
	@Inject
	private IStorage2UriMapper storage2uriMapper;
	
	@Inject
	private IWorkspaceRoot workspaceRoot;
	
	/**
	 * Returns the root trace region where {@link TraceRegion#getMyOffset()} and
	 * {@link TraceRegion#getMyLength()} return the information for the
	 * resource that this {@link ITrace} is associated with. 
	 * @return the root trace region. May be <code>null</code> if no trace data is available.
	 */
	@Nullable
	protected abstract AbstractTraceRegion getRootTraceRegion();
	
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
				ILocationData locationData = right.getMergedLocationData();
				if (locationData != null)
					return createLocationInResourceFor(locationData, right);
			}
			return null;
		}
		if (right == null || left.equals(right)) {
			ILocationData locationData = left.getMergedLocationData();
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
					ILocationData location = potentialMatch.getMergedLocationData();
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
		URI path = location.getLocation();
		if (path == null)
			path = traceRegion.getAssociatedPath();
		String projectName = location.getProjectName();
		if (projectName == null)
			projectName = traceRegion.getAssociatedProjectName();
		return new OffsetBasedLocationInResource(location.getOffset(), location.getLength(), path, projectName, this);
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
		if (offset < 0)
			// TODO should this be return false;?
			throw new IllegalArgumentException("offset may not be negative");
		int relativeOffset = offset - region.getMyOffset();
		boolean result = relativeOffset >= 0 && (includeRegionEnd ? relativeOffset <= region.getMyLength() : relativeOffset < region.getMyLength());
		return result;
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
			// TODO should this be return false;?
			throw new IllegalArgumentException("offset may not be negative");
		int relativeOffset = offset - regionOffset;
		boolean result = relativeOffset == 0 || (relativeOffset > 0 && (includeRegionEnd ? relativeOffset <= regionLength : relativeOffset < regionLength));
		return result;
	}

	public Iterable<ILocationInResource> getAllAssociatedLocations(ITextRegion region) {
		Iterable<AbstractTraceRegion> allTraceRegions = getAllTraceRegions(region);
		return toLocations(allTraceRegions);
	}
	
	protected Iterable<ILocationInResource> toLocations(Iterable<AbstractTraceRegion> allTraceRegions) {
		List<ILocationInResource> result = Lists.newArrayList();
		for(AbstractTraceRegion region: allTraceRegions) {
			for(ILocationData locationData: region.getAssociatedLocations()) {
				result.add(createLocationInResourceFor(locationData, region));
			}
		}
		return result;
	}

	protected Iterable<AbstractTraceRegion> getAllTraceRegions(ITextRegion region) {
		final AbstractTraceRegion left = findLeafAtLeftOffset(region.getOffset());
		final AbstractTraceRegion right = findLeafAtRightOffset(region.getOffset() + region.getLength());
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

	public Iterable<ILocationInResource> getAllLocations() {
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
	protected Resource getResource(URI toPath, IProject project) {
		IResourceSetProvider resourceSetProvider = getService(toPath, IResourceSetProvider.class);
		if (resourceSetProvider != null) {
			ResourceSet resourceSet = resourceSetProvider.get(project);
			try {
				Resource result = resourceSet.getResource(toPath, true);
				return result;
			} catch(RuntimeException e) {
				// expected
				return null;
			}
		}
		return null;
	}

	protected IStorage findStorage(URI toPath, IProject project) {
		Iterable<Pair<IStorage, IProject>> allStorages = storage2uriMapper.getStorages(toPath);
		for(Pair<IStorage, IProject> storage: allStorages) {
			if (project.equals(storage.getSecond())) {
				return storage.getFirst();
			}
		}
		throw new IllegalStateException("No storage found for given path: " + toPath);
	}
	
	protected IProject findProject(String projectName) {
		IProject result = workspaceRoot.getProject(projectName);
		return result;
	}
	
	@Nullable
	protected LanguageInfo findLanguage(@Nullable URI toPath) {
		return getService(toPath, LanguageInfo.class);
	}
	
	@Nullable
	protected <T> T getService(@Nullable URI toPath, Class<T> type) {
		if (toPath == null)
			return null;
		IResourceServiceProvider serviceProvider = resourceServiceRegistry.getResourceServiceProvider(toPath);
		if (serviceProvider != null) {
			return serviceProvider.get(type);
		}
		return null;
	}

}
