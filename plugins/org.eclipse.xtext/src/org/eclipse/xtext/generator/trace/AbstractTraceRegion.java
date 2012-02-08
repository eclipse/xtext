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

	protected AbstractTraceRegion(@Nullable AbstractTraceRegion parent) {
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
	
	public abstract int getFromLength();

	public abstract int getFromOffset();

	public abstract int getToLength();

	public abstract int getToOffset();
	
	@Nullable
	public AbstractTraceRegion getParent() {
		return parent;
	}
	
	@Nullable
	public URI getToPath() {
		AbstractTraceRegion parent = getParent();
		if (parent != null)
			return parent.getToPath();
		return null;
	}
	
	@Nullable
	public String getToProjectName() {
		AbstractTraceRegion parent = getParent();
		if (parent != null)
			return parent.getToProjectName();
		return null;
	}
	
	public String getAnnotateString(String input) {
		StringBuilder result = new StringBuilder(input.length() * 3);
		int nextOffset = doAnnotateTrace(input, result, 0);
		if (nextOffset < input.length()) {
			result.append(input.substring(nextOffset));
		}
		return result.toString();
	}
	
	private int doAnnotateTrace(String input, StringBuilder result, int nextOffset) {
		if (nextOffset < getFromOffset()) {
			result.append(input.substring(nextOffset, getFromOffset()));
			nextOffset = getFromOffset();
		}
		result.append('<').append(getToOffset()).append(':').append(getToLength()).append("[");
		for(AbstractTraceRegion nested: getNestedRegions()) {
			nextOffset = nested.doAnnotateTrace(input, result, nextOffset);
		}
		if (nextOffset < getFromOffset() + getFromLength()) {
			result.append(input.substring(nextOffset, getFromOffset() + getFromLength()));
			nextOffset = getFromOffset() + getFromLength();
		}
		result.append(']');
		return nextOffset;
	}

	/**
	 * Returns the hash code value for this region.  The hash code
	 * of a trace region <code>r</code> is defined to be: <pre>
	 *       r.getFromOffset() 
	 *     ^ r.getFromLength()
	 *     ^ r.getToOffset()
	 *     ^ r.getToLength()
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
		return getFromOffset() 
		     ^ getFromLength()
		     ^ getToOffset()
		     ^ getToLength()
		     ^ (parent == null ? 0 : parent.hashCode());
	}

	/**
	 * Compares the specified object with this region for equality. Returns <code>true</code> if the given object is also
	 * an {@link AbstractTraceRegion} and the two regions represent the same data. More formally, two regions <code>r1</code>
	 * and <code>r2</code> are considered to be equal if
	 * 
	 * <pre>
	 *     (r1.getFromOffset() == r2.getFromOffset())
	 *  && (r1.getFromLength() == r2.getFromLength())
	 *  && (r1.getToOffset() == r2.getToOffset())
	 *  && (r1.getToLength() == r2.getToLength())
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
		if (getFromLength() != other.getFromLength())
			return false;
		if (getFromOffset() != other.getFromOffset())
			return false;
		if (getToOffset() != other.getToOffset())
			return false;
		if (getToLength() != other.getToLength())
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
		return getClass().getSimpleName() + " [fromOffset=" + getFromOffset() + ", fromLength=" + getFromLength() + ", toOffset="
				+ getToOffset() + ", toLength=" + getToLength() + ", nestedRegions=" + getNestedRegions() + "]";
	}
	
	
	

}