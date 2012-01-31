/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ITraceRegion {

	/**
	 * Returns an iterator that will only offer leaf trace regions.
	 * If the nested regions have gaps, these will be filled with parent data.
	 * If this region is a leaf, a singleton iterator will be returned.
	 * @return an unmodifiable iterator for all leafs. Never <code>null</code>.
	 */
	Iterator<ITraceRegion> leafIterator();

	int getFromLength();

	int getFromOffset();

	int getToLength();

	int getToOffset();

	URI getToPath();

	List<TraceRegion> getNestedRegions();

	ITraceRegion getParent();

	String getToProjectName();

	/**
	 * Compares the specified object with this region for equality. Returns <code>true</code> if the given object is also
	 * an {@link ITraceRegion} and the two regions represent the same data. More formally, two regions <code>r1</code>
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
	 * {@link ITraceRegion} interface.
	 * 
	 * @param obj
	 *            object to be compared for equality with this trace region
	 * @return <tt>true</tt> if the specified object is equal to this trace region
	 */
	@Override
	boolean equals(Object obj);
	
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
	 * <tt>r1.hashCode()==r2.hashCode()</tt> for any two {@link ITraceRegion}
	 * <tt>r1</tt> and <tt>r2</tt>, as required by the general
	 * contract of <tt>Object.hashCode</tt>.
	 *
	 * @return the hash code value for this trace region
	 * @see Object#hashCode()
	 * @see Object#equals(Object)
	 * @see #equals(Object)
	 */
	@Override
	int hashCode();
}