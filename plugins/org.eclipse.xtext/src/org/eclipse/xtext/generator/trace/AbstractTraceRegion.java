/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

/**
 * Abstract base class for trace regions. Implements the {@link #equals(Object)} and {@link #hashCode()} contract and
 * delegates some functionality to the parent.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTraceRegion {

	private AbstractTraceRegion parent;
	private List<AbstractTraceRegion> nestedRegions;

	/**
	 * Creates a new trace region and adds it to the parent if a parent was given.
	 */
	protected AbstractTraceRegion(AbstractTraceRegion parent) {
		setParent(parent);
	}

	protected boolean isConsistentWithParent() {
		AbstractTraceRegion parent = getParent();
		if (parent == null)
			return true;
		if (parent.getMyOffset() > getMyOffset())
			return false;
		if (parent.getMyOffset() + parent.getMyLength() < getMyOffset() + getMyLength())
			return false;
		if (parent.getMyLineNumber() > getMyLineNumber())
			return false;
		if (parent.getMyEndLineNumber() < getMyEndLineNumber())
			return false;
		List<AbstractTraceRegion> siblings = parent.getNestedRegions();
		if (siblings.size() >= 2 && siblings.get(siblings.size() - 1) == this) {
			AbstractTraceRegion prev = siblings.get(siblings.size() - 2);
			if (prev.getMyEndLineNumber() > getMyLineNumber()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Sets the parent (if any) and maintains the {@link #getWritableNestedRegions() nested regions} of the parent.
	 * 
	 * @see #setAsChildIn(AbstractTraceRegion)
	 * @param parent
	 *            the parent or <code>null</code> if none.
	 */
	public void setParent(AbstractTraceRegion parent) {
		this.parent = parent;
		if (parent != null)
			setAsChildIn(parent);
	}

	protected void setAsChildIn(AbstractTraceRegion parent) {
		parent.getWritableNestedRegions().add(this);
	}

	/**
	 * Returns the nested trace regions. The list does not necessarily contain all the regions that will be returned by
	 * the {@link #leafIterator()}.
	 * 
	 * @return the list of directly nested regions.
	 */
	public final List<AbstractTraceRegion> getNestedRegions() {
		if (nestedRegions == null)
			return Collections.emptyList();
		return Collections.unmodifiableList(nestedRegions);
	}

	protected final List<AbstractTraceRegion> getWritableNestedRegions() {
		if (nestedRegions == null)
			nestedRegions = Lists.newArrayListWithCapacity(4);
		return nestedRegions;
	}

	public List<AbstractTraceRegion> invertFor(SourceRelativeURI expectedAssociatedPath, SourceRelativeURI myPath) {
		Map<SourceRelativeURI, List<Pair<ILocationData, AbstractTraceRegion>>> matchingLocations = collectMatchingLocations(
				expectedAssociatedPath);
		List<Pair<ILocationData, AbstractTraceRegion>> expectedMatchingLocations = matchingLocations
				.get(expectedAssociatedPath);
		if (expectedMatchingLocations == null)
			return Collections.emptyList();
		inplaceSortByOffset(expectedMatchingLocations);
		List<AbstractTraceRegion> result = toInvertedTraceRegions(expectedMatchingLocations, myPath);
		return result;
	}

	public Map<SourceRelativeURI, List<AbstractTraceRegion>> invertAll(SourceRelativeURI myPath) {
		Map<SourceRelativeURI, List<Pair<ILocationData, AbstractTraceRegion>>> matchingLocations = collectMatchingLocations(
				null);
		Map<SourceRelativeURI, List<AbstractTraceRegion>> result = Maps
				.newHashMapWithExpectedSize(matchingLocations.size());
		for (SourceRelativeURI uri : matchingLocations.keySet()) {
			List<Pair<ILocationData, AbstractTraceRegion>> expectedMatchingLocations = matchingLocations.get(uri);
			if (expectedMatchingLocations != null) {
				inplaceSortByOffset(expectedMatchingLocations);
				List<AbstractTraceRegion> resultPerURI = toInvertedTraceRegions(expectedMatchingLocations, myPath);
				result.put(uri, resultPerURI);
			}
		}
		return result;
	}

	protected Map<SourceRelativeURI, List<Pair<ILocationData, AbstractTraceRegion>>> collectMatchingLocations(
			SourceRelativeURI expectedAssociatedPath) {
		Map<SourceRelativeURI, List<Pair<ILocationData, AbstractTraceRegion>>> result = Maps
				.newHashMapWithExpectedSize(2);
		Iterator<AbstractTraceRegion> treeIterator = treeIterator();
		while (treeIterator.hasNext()) {
			AbstractTraceRegion next = treeIterator.next();
			SourceRelativeURI associatedPath = next.getAssociatedSrcRelativePath();
			List<Pair<ILocationData, AbstractTraceRegion>> matchingLocations = getCollectingList(associatedPath,
					expectedAssociatedPath, result);
			for (ILocationData locationData : next.getAssociatedLocations()) {
				if (associatedPath == null) {
					matchingLocations = getCollectingList(locationData.getSrcRelativePath(), expectedAssociatedPath, result);
				}
				if (matchingLocations != null) {
					matchingLocations.add(Tuples.create(locationData, next));
				}
			}
		}
		return result;
	}

	protected List<Pair<ILocationData, AbstractTraceRegion>> getCollectingList(SourceRelativeURI associatedPath,
			SourceRelativeURI expectedAssociatedPath,
			Map<SourceRelativeURI, List<Pair<ILocationData, AbstractTraceRegion>>> listsPerURI) {
		List<Pair<ILocationData, AbstractTraceRegion>> result = null;
		if (associatedPath != null
				&& (expectedAssociatedPath == null || associatedPath.equals(expectedAssociatedPath))) {
			result = listsPerURI.get(associatedPath);
			if (result == null) {
				result = Lists.newArrayList();
				listsPerURI.put(associatedPath, result);
			}
		}
		return result;
	}

	public TreeIterator<AbstractTraceRegion> treeIterator() {
		TreeIterator<AbstractTraceRegion> treeIterator = new AbstractTreeIterator<AbstractTraceRegion>(this) {
			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<? extends AbstractTraceRegion> getChildren(Object object) {
				if (object == null)
					return ImmutableSet.<AbstractTraceRegion> of().iterator();
				AbstractTraceRegion casted = (AbstractTraceRegion) object;
				return casted.getNestedRegions().iterator();
			}

			/**
			 * @throws UnsupportedOperationException
			 *             always
			 */
			@Override
			public void remove() {
				throw new UnsupportedOperationException("remove is not supported");
			}
		};
		return treeIterator;
	}

	protected void inplaceSortByOffset(List<Pair<ILocationData, AbstractTraceRegion>> locations) {
		Collections.sort(locations, new Comparator<Pair<ILocationData, AbstractTraceRegion>>() {
			@Override
			public int compare(Pair<ILocationData, AbstractTraceRegion> o1,
					Pair<ILocationData, AbstractTraceRegion> o2) {
				if (o1 == null || o2 == null)
					throw new IllegalArgumentException("o1 == null || o2 == null");
				ILocationData loc1 = o1.getFirst();
				ILocationData loc2 = o2.getFirst();
				int result = Ints.compare(loc1.getOffset(), loc2.getOffset());
				if (result == 0) {
					result = Ints.compare(loc2.getLength(), loc1.getLength());
				}
				return result;
			}
		});
	}

	/**
	 * Produces trees from a sorted list of locations. If the locations overlap, they'll be splitted automatically to
	 * fulfill the contract of invariant of trace regions.
	 */
	protected List<AbstractTraceRegion> toInvertedTraceRegions(List<Pair<ILocationData, AbstractTraceRegion>> locations,
			SourceRelativeURI myPath) {
		List<AbstractTraceRegion> result = Lists.newArrayListWithCapacity(2);
		TraceRegion current = null;
		int currentEndOffset = 0;
		outer: for (int i = 0; i < locations.size(); i++) { // avoid concurrent modification exceptions
			Pair<ILocationData, AbstractTraceRegion> nextPair = locations.get(i);
			ILocationData nextLocation = nextPair.getFirst();
			AbstractTraceRegion nextRegion = nextPair.getSecond();
			if (current != null) {
				// equal region - add mapped location
				if (current.getMyOffset() == nextLocation.getOffset()
						&& current.getMyLength() == nextLocation.getLength()) {
					List<ILocationData> writableLocations = current.getWritableAssociatedLocations();
					ILocationData newData = createLocationData(nextRegion, myPath);
					if (!writableLocations.contains(newData))
						writableLocations.add(newData);
					continue outer;
				} else {
					// walk upwards if necessary
					while (current != null && currentEndOffset <= nextLocation.getOffset()) {
						current = (TraceRegion) current.getParent();
						if (current != null)
							currentEndOffset = current.getMyOffset() + current.getMyLength();
						else
							currentEndOffset = 0;
					}
				}
			}
			if (current != null) {
				int nextOffset = nextLocation.getOffset();
				if (nextOffset + nextLocation.getLength() <= currentEndOffset) {
					current = new TraceRegion(nextOffset, nextLocation.getLength(), nextLocation.getLineNumber(),
							nextLocation.getEndLineNumber(), true, createLocationData(nextRegion, myPath), current);
					currentEndOffset = nextLocation.getOffset() + nextLocation.getLength();
				} else {
					int nextLength = currentEndOffset - nextOffset;
					int nextEndLine = current.getMyEndLineNumber();
					int splittedLength = nextLocation.getLength() - nextLength;
					int splittedBeginLine = nextEndLine;
					ILocationData splitted = new LocationData(currentEndOffset, splittedLength, splittedBeginLine,
							nextLocation.getEndLineNumber(), nextLocation.getSrcRelativePath());
					for (int j = i + 1; j < locations.size() && splitted != null; j++) {
						ILocationData shiftMe = locations.get(j).getFirst();
						if (splitted.getOffset() == shiftMe.getOffset()) {
							if (splitted.getLength() > shiftMe.getLength()) {
								locations.add(j, Tuples.create(splitted, nextRegion));
								splitted = null;
							}
						} else if (splitted.getOffset() < shiftMe.getOffset()) {
							locations.add(j, Tuples.create(splitted, nextRegion));
							splitted = null;
						}
					}
					if (splitted != null) {
						locations.add(Tuples.create(splitted, nextRegion));
					}
					current = new TraceRegion(nextOffset, nextLength, nextLocation.getLineNumber(), splittedBeginLine,
							true, createLocationData(nextRegion, myPath), current);
					currentEndOffset = nextOffset + nextLength;
				}
			} else {
				current = new TraceRegion(nextLocation.getOffset(), nextLocation.getLength(),
						nextLocation.getLineNumber(), nextLocation.getEndLineNumber(),
						true, createLocationData(nextRegion, myPath), null);
				currentEndOffset = nextLocation.getOffset() + nextLocation.getLength();
				result.add(current);
			}
		}
		return result;
	}

	public static AbstractTraceRegion mergedFrom(List<AbstractTraceRegion> regions) {
		return new TraceRegionMerger().mergeTraceRegions(regions);
	}

	public LocationData createLocationData(AbstractTraceRegion region, SourceRelativeURI myPath) {
		return new LocationData(region.getMyOffset(), region.getMyLength(), region.getMyLineNumber(),
				region.getMyEndLineNumber(), myPath);
	}

	/**
	 * Returns an iterator that will only offer leaf trace regions. If the nested regions have gaps, these will be
	 * filled with parent data. If this region is a leaf, a singleton iterator will be returned.
	 * 
	 * @return an unmodifiable iterator for all leafs. Never <code>null</code>.
	 */
	public final Iterator<AbstractTraceRegion> leafIterator() {
		if (nestedRegions == null)
			return Collections.<AbstractTraceRegion> singleton(this).iterator();
		return new LeafIterator(this);
	}

	public abstract int getMyLength();

	public abstract int getMyOffset();

	public abstract int getMyLineNumber();

	public abstract int getMyEndLineNumber();

	public ITextRegionWithLineInformation getMyRegion() {
		return new TextRegionWithLineInformation(getMyOffset(), getMyLength(), getMyLineNumber(), getMyEndLineNumber());
	}

	public abstract List<ILocationData> getAssociatedLocations();

	/**
	 * Returns the merged location of all associated locations if they belong to the same resource. Otherwise
	 * <code>null</code> is returned.
	 */
	public ILocationData getMergedAssociatedLocation() {
		List<ILocationData> allData = getAssociatedLocations();
		if (allData.isEmpty()) {
			return null;
		}
		if (allData.size() == 1) {
			return allData.get(0);
		}
		boolean allNull = true;
		SourceRelativeURI path = null;
		ITextRegionWithLineInformation region = ITextRegionWithLineInformation.EMPTY_REGION;
		for (ILocationData data : allData) {
			if (path != null) {
				if (!path.equals(data.getSrcRelativePath())) {
					return null;
				}
			} else {
				if (data.getSrcRelativePath() == null) {
					if (!allNull)
						throw new IllegalStateException(
								"Iff multiple associated locations are present, the path has to be set");
				} else {
					allNull = false;
					path = data.getSrcRelativePath();
				}
			}
			region = region.merge(new TextRegionWithLineInformation(data.getOffset(), data.getLength(),
					data.getLineNumber(), data.getEndLineNumber()));
		}
		return new LocationData(region.getOffset(), region.getLength(), region.getLineNumber(),
				region.getEndLineNumber(), path);
	}

	public SourceRelativeURI getAssociatedSrcRelativePath() {
		ILocationData data = getMergedAssociatedLocation();
		if (data != null) {
			SourceRelativeURI result = data.getSrcRelativePath();
			if (result != null) {
				return result;
			}
		}
		if (parent == null)
			return null;
		boolean uriSeen = false;
		for (ILocationData associated : getAssociatedLocations())
			if (associated.getSrcRelativePath() != null) {
				if (!uriSeen)
					uriSeen = true;
				else
					return null;
			}
		return parent.getAssociatedSrcRelativePath();
	}

	public AbstractTraceRegion getParent() {
		return parent;
	}
	
	public AbstractTraceRegion getRoot() {
		if (parent != null)
			return parent.getRoot();
		return this;
	}

	public String getAnnotatedString(String input) {
		StringBuilder result = new StringBuilder(input.length() * 3);
		int nextOffset = doAnnotateTrace(input, result, 0);
		if (nextOffset < input.length()) {
			result.append(input.substring(nextOffset));
		}
		return result.toString();
	}

	private int doAnnotateTrace(String input, StringBuilder result, int nextOffset) {
		if (nextOffset < getMyOffset()) {
			result.append(input.substring(nextOffset, getMyOffset()));
			nextOffset = getMyOffset();
		}
		result.append('<');
		List<ILocationData> associatedLocations = getAssociatedLocations();
		for (int i = 0; i < associatedLocations.size(); i++) {
			if (i != 0)
				result.append("/");
			ILocationData associatedLocation = associatedLocations.get(i);
			result.append(associatedLocation.getOffset()).append(':').append(associatedLocation.getLength());
		}
		result.append("[");
		for (AbstractTraceRegion nested : getNestedRegions()) {
			nextOffset = nested.doAnnotateTrace(input, result, nextOffset);
		}
		if (nextOffset < getMyOffset() + getMyLength()) {
			result.append(input.substring(nextOffset, getMyOffset() + getMyLength()));
			nextOffset = getMyOffset() + getMyLength();
		}
		result.append(']');
		return nextOffset;
	}

	public abstract boolean isUseForDebugging();

	/**
	 * Returns the hash code value for this region. The hash code of a trace region <code>r</code> is defined to be:
	 * 
	 * <pre>
	 * r.getMyOffset() ^ r.getMyLength() ^ r.getAssociatedOffset() ^ r.getAssociatedLength()
	 * 		^ (r.getParent() == null ? 0 : r.getParent().hashCode())
	 * </pre>
	 * 
	 * This ensures that <tt>r1.equals(r2)</tt> implies that <tt>r1.hashCode()==r2.hashCode()</tt> for any two
	 * {@link AbstractTraceRegion} <tt>r1</tt> and <tt>r2</tt>, as required by the general contract of
	 * <tt>Object.hashCode</tt>.
	 *
	 * @return the hash code value for this trace region
	 * @see Object#hashCode()
	 * @see Object#equals(Object)
	 * @see #equals(Object)
	 */
	@Override
	public int hashCode() {
		AbstractTraceRegion parent = getParent();
		return getMyOffset() ^ getMyLength() ^ getAssociatedLocations().hashCode()
				^ (parent == null ? 0 : parent.hashCode());
	}

	/**
	 * Compares the specified object with this region for equality. Returns <code>true</code> if the given object is
	 * also an {@link AbstractTraceRegion} and the two regions represent the same data. More formally, two regions
	 * <code>r1</code> and <code>r2</code> are considered to be equal if
	 * 
	 * <pre>
	 * (r1.getMyOffset() == r2.getMyOffset()) && (r1.getMyLength() == r2.getMyLength())
	 * 		&& (r1.getAssociatedOffset() == r2.getAssociatedOffset())
	 * 		&& (r1.getAssociatedLength() == r2.getAssociatedLength())
	 * 		&& (r1.getParent() == null ? r2.getParent() == null : r1.getParent().equals(r2.getParent()))
	 * </pre>
	 * 
	 * This ensures that the {@link #equals(Object)} method works properly across different implementations of the
	 * {@link AbstractTraceRegion} interface.
	 * 
	 * @param obj
	 *            object to be compared for equality with this trace region
	 * @return <tt>true</tt> if the specified object is equal to this trace region
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractTraceRegion))
			return false;
		AbstractTraceRegion other = (AbstractTraceRegion) obj;
		if (getMyLength() != other.getMyLength())
			return false;
		if (getMyOffset() != other.getMyOffset())
			return false;
		if (!getAssociatedLocations().equals(other.getAssociatedLocations()))
			return false;
		AbstractTraceRegion otherParent = other.getParent();
		AbstractTraceRegion parent = getParent();
		if (otherParent == null) {
			if (parent != null)
				return false;
		} else {
			if (parent == null)
				return false;
			if (!parent.equals(otherParent))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		List<AbstractTraceRegion> nested = getNestedRegions();
		String nestedText;
		if (nested.isEmpty())
			nestedText = "";
		else
			nestedText = " nestedRegions={\n  " + Joiner.on("\n").join(nested).replace("\n", "\n  ") + "\n}";
		List<ILocationData> associated = getAssociatedLocations();
		String associatedText;
		if (associated.isEmpty())
			associatedText = "";
		else
			associatedText = " associations={\n  " + Joiner.on("\n").join(associated).replace("\n", "\n  ") + "\n}";
		return getClass().getSimpleName() + " [myOffset=" + getMyOffset() + ", myLength=" + getMyLength() + "]"
				+ associatedText + nestedText;
	}

}