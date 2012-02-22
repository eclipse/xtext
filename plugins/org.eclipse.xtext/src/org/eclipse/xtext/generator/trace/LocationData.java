/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.TextRegionWithLineInformation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LocationData extends TextRegionWithLineInformation implements ILocationData {

	private final URI path;
	private final String projectName;
	
	public LocationData(int offset, int length, int lineNumber, int endLineNumber,  @Nullable URI path, @Nullable String projectName) {
		super(offset, length, lineNumber, endLineNumber);
		this.path = path;
		this.projectName = projectName;
	}
	
	public LocationData(@NonNull ITextRegionWithLineInformation region,  @Nullable URI path, @Nullable String projectName) {
		this(region.getOffset(), region.getLength(), region.getLineNumber(), region.getEndLineNumber(), path, projectName);
	}

	@Nullable
	public URI getPath() {
		return path;
	}

	@Nullable
	public String getProjectName() {
		return projectName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		return result;
	}

	@Override
	public boolean equals(@Nullable Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationData other = (LocationData) obj;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}

	@Override
	@NonNull
	public String toString() {
		return "LocationData [" + super.toString() + "][path=" + path + ", projectName=" + projectName + "]";
	}

}
