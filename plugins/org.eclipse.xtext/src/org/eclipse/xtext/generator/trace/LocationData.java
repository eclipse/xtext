/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.Nullable;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LocationData implements ILocationData {

	private final int offset;
	private final int length;
	private final URI location;
	private final String projectName;
	
	public LocationData(int offset, int length, @Nullable URI location, @Nullable String projectName) {
		if (offset < 0)
			throw new IllegalArgumentException("offset " + offset + " is < 0");
		if (length < 0)
			throw new IllegalArgumentException("length " + length + " is < 0");
		this.offset = offset;
		this.length = length;
		this.location = location;
		this.projectName = projectName;
	}

	public int getOffset() {
		return offset;
	}

	public int getLength() {
		return length;
	}

	@Nullable
	public URI getLocation() {
		return location;
	}

	@Nullable
	public String getProjectName() {
		return projectName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + offset;
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationData other = (LocationData) obj;
		if (length != other.length)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (offset != other.offset)
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocationData [offset=" + offset + ", length=" + length + ", location=" + location + ", projectName="
				+ projectName + "]";
	}
	
}
