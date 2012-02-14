/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LocationData {

	private URI sourceURI;
	private String sourceProject;
	private int sourceOffset;
	private int sourceLength;

	public LocationData(ILocationInFileProvider locationProvider, EObject source) {
		ITextRegion textRegion = locationProvider.getSignificantTextRegion(source);
		URI uri = source.eResource().getURI();
		setData(uri, null, textRegion.getOffset(), textRegion.getLength());
	}

	protected void setData(URI sourceURI, @Nullable String sourceProject, int sourceOffset, int sourceLength) {
		this.sourceURI = sourceURI;
		if (sourceProject != null) {
			this.sourceProject = sourceProject;
		} else {
			if (!sourceURI.isPlatformResource()) {
				this.sourceProject = "<unknown>";
			} else {
				this.sourceProject = sourceURI.segment(1);
			}
		}
		this.sourceOffset = sourceOffset;
		this.sourceLength = sourceLength;
	}

	public int getSourceLength() {
		return sourceLength;
	}

	public int getSourceOffset() {
		return sourceOffset;
	}

	public String getSourceProject() {
		return sourceProject;
	}

	public URI getSourceURI() {
		return sourceURI;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sourceLength;
		result = prime * result + sourceOffset;
		result = prime * result + ((sourceProject == null) ? 0 : sourceProject.hashCode());
		result = prime * result + ((sourceURI == null) ? 0 : sourceURI.hashCode());
		return result;
	}

	@Override
	public boolean equals(@Nullable Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationData other = (LocationData) obj;
		if (sourceLength != other.sourceLength)
			return false;
		if (sourceOffset != other.sourceOffset)
			return false;
		if (sourceProject == null) {
			if (other.sourceProject != null)
				return false;
		} else if (!sourceProject.equals(other.sourceProject))
			return false;
		if (sourceURI == null) {
			if (other.sourceURI != null)
				return false;
		} else if (!sourceURI.equals(other.sourceURI))
			return false;
		return true;
	}

}