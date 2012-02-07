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

import com.google.common.collect.Iterators;

/**
 * Abstract base class for {@link ITraceRegion}. Implements the {@link #equals(Object)}
 * and {@link #hashCode()} contract and delegates some functionality to the parent.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTraceRegion implements ITraceRegion {

	public List<ITraceRegion> getNestedRegions() {
		return Collections.emptyList();
	}
	
	public Iterator<ITraceRegion> leafIterator() {
		return Iterators.<ITraceRegion>singletonIterator(this);
	}
	
	public URI getToPath() {
		ITraceRegion parent = getParent();
		if (parent != null)
			return parent.getToPath();
		return null;
	}
	
	public String getToProjectName() {
		ITraceRegion parent = getParent();
		if (parent != null)
			return parent.getToProjectName();
		return null;
	}

	@Override
	public int hashCode() {
		return getFromOffset() 
		     ^ getFromLength()
		     ^ getToOffset()
		     ^ getToLength()
		     ^ (getParent() == null ? 0 : getParent().hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ITraceRegion))
			return false;
		ITraceRegion other = (ITraceRegion) obj;
		if (getFromLength() != other.getFromLength())
			return false;
		if (getFromOffset() != other.getFromOffset())
			return false;
		if (getToOffset() != other.getToOffset())
			return false;
		if (getToLength() != other.getToLength())
			return false;
		if (other.getParent() == null) {
			if (getParent() != null)
				return false;
			if (!getParent().equals(other.getParent()))
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [fromOffset=" + getFromOffset() + ", fromLength=" + getFromLength() + ", toOffset="
				+ getToOffset() + ", toLength=" + getToLength() + ", parent=" + getParent() + "]";
	}
	
	
	

}