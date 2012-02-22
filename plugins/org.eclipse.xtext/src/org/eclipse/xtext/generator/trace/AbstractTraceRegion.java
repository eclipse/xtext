/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

import com.google.common.collect.Lists;

/**
 * Abstract base class for trace regions. Implements the {@link #equals(Object)}
 * and {@link #hashCode()} contract and delegates some functionality to the parent.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractTraceRegion {

	private AbstractTraceRegion parent;
	private List<AbstractTraceRegion> nestedRegions;

	/**
	 * Creates a new trace region and adds it to the parent if a parent was given.
	 */
	protected AbstractTraceRegion(@Nullable AbstractTraceRegion parent) {
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
	 * Sets the parent (if any) and maintains the {@link #getWritableNestedRegions() nested regions}
	 * of the parent.
	 * @see #setAsChildIn(AbstractTraceRegion)
	 * @param parent the parent or <code>null</code> if none.
	 */
	protected void setParent(@Nullable AbstractTraceRegion parent) {
		this.parent = parent;
		if (parent != null)
			setAsChildIn(parent);
	}

	protected void setAsChildIn(AbstractTraceRegion parent) {
		parent.getWritableNestedRegions().add(this);
	}
	
	/**
	 * Returns the nested trace regions. The list does not necessarily contain all
	 * the regions that will be returned by the {@link #leafIterator()}.
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
	
	/**
	 * Returns an iterator that will only offer leaf trace regions.
	 * If the nested regions have gaps, these will be filled with parent data.
	 * If this region is a leaf, a singleton iterator will be returned.
	 * @return an unmodifiable iterator for all leafs. Never <code>null</code>.
	 */
	public final Iterator<AbstractTraceRegion> leafIterator() {
		if (nestedRegions == null)
			return Collections.<AbstractTraceRegion>singleton(this).iterator();
		return new LeafIterator(this);
	}
	
	public abstract int getMyLength();

	public abstract int getMyOffset();
	
	public abstract int getMyLineNumber();
	
	public abstract int getMyEndLineNumber();
	
	public abstract List<ILocationData> getAssociatedLocations();
	
	/**
	 * Returns the merged location of all associated locations if
	 * they belong to the same resource. Otherwise <code>null</code> is returned.
	 */
	@Nullable
	public ILocationData getMergedLocationData() {
		List<ILocationData> allData = getAssociatedLocations();
		if (allData.size() == 1) {
			return allData.get(0);
		}
		boolean allNull = true;
		URI path = null;
		String projectName = null;
		ITextRegionWithLineInformation region = ITextRegionWithLineInformation.EMPTY_REGION;
		for(ILocationData data: allData) {
			if (path != null) {
				if (!path.equals(data.getLocation())) {
					return null;
				}
			} else {
				if (data.getLocation() == null) {
					if (!allNull)
						throw new IllegalStateException("Iff multiple associated locations are present, the path has to be set");
				} else {
					allNull = false;
					path = data.getLocation();
					projectName = data.getProjectName();
				}
			}
			region = region.merge(new TextRegionWithLineInformation(data.getOffset(), data.getLength(), data.getLineNumber(), data.getEndLineNumber()));
		}
		return new LocationData(region.getOffset(), region.getLength(), region.getLineNumber(), region.getEndLineNumber(), path, projectName);
	}
	
	@Nullable
	public URI getAssociatedPath() {
		ILocationData data = getMergedLocationData();
		if (data != null) {
			URI result = data.getLocation();
			if (result != null) {
				return result;
			}
		}
		if (parent != null && getAssociatedLocations().size() == 1) {
			return parent.getAssociatedPath();
		}
		return null;
	}
	
	@Nullable
	public String getAssociatedProjectName() {
		ILocationData data = getMergedLocationData();
		if (data != null) {
			String result = data.getProjectName();
			if (result != null) {
				return result;
			}
		}
		if (parent != null && getAssociatedLocations().size() == 1) {
			return parent.getAssociatedProjectName();
		}
		return null;
	}
	
	@Nullable
	public AbstractTraceRegion getParent() {
		return parent;
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
		for(int i = 0; i < associatedLocations.size(); i++) {
			if (i != 0)
				result.append("/");
			ILocationData associatedLocation = associatedLocations.get(i);
			result.append(associatedLocation.getOffset()).append(':').append(associatedLocation.getLength());
		}
		result.append("[");
		for(AbstractTraceRegion nested: getNestedRegions()) {
			nextOffset = nested.doAnnotateTrace(input, result, nextOffset);
		}
		if (nextOffset < getMyOffset() + getMyLength()) {
			result.append(input.substring(nextOffset, getMyOffset() + getMyLength()));
			nextOffset = getMyOffset() + getMyLength();
		}
		result.append(']');
		return nextOffset;
	}

	/**
	 * Returns the hash code value for this region.  The hash code
	 * of a trace region <code>r</code> is defined to be: <pre>
	 *       r.getMyOffset() 
	 *     ^ r.getMyLength()
	 *     ^ r.getAssociatedOffset()
	 *     ^ r.getAssociatedLength()
	 *     ^ (r.getParent() == null ? 0 : r.getParent().hashCode())
     * </pre>
	 * This ensures that <tt>r1.equals(r2)</tt> implies that
	 * <tt>r1.hashCode()==r2.hashCode()</tt> for any two {@link AbstractTraceRegion}
	 * <tt>r1</tt> and <tt>r2</tt>, as required by the general
	 * contract of <tt>Object.hashCode</tt>.
	 *
	 * @return the hash code value for this trace region
	 * @see Object#hashCode()
	 * @see Object#equals(Object)
	 * @see #equals(Object)
	 */
	@Override
	public int hashCode() {
		AbstractTraceRegion parent = getParent();
		return getMyOffset() 
		     ^ getMyLength()
		     ^ getAssociatedLocations().hashCode()
		     ^ (parent == null ? 0 : parent.hashCode());
	}

	/**
	 * Compares the specified object with this region for equality. Returns <code>true</code> if the given object is also
	 * an {@link AbstractTraceRegion} and the two regions represent the same data. More formally, two regions <code>r1</code>
	 * and <code>r2</code> are considered to be equal if
	 * 
	 * <pre>
	 *     (r1.getMyOffset() == r2.getMyOffset())
	 *  && (r1.getMyLength() == r2.getMyLength())
	 *  && (r1.getAssociatedOffset() == r2.getAssociatedOffset())
	 *  && (r1.getAssociatedLength() == r2.getAssociatedLength())
	 *  && (r1.getParent()==null ?
	 *      r2.getParent()==null : r1.getParent().equals(r2.getParent()))
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
	public boolean equals(@Nullable Object obj) {
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
			if (parent!= null)
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
		return getClass().getSimpleName() + " [myOffset=" + getMyOffset() + ", myLength=" + getMyLength() + ", associations="
				+ getAssociatedLocations() + ", nestedRegions=" + getNestedRegions() + "]";
	}
	
	
	

}