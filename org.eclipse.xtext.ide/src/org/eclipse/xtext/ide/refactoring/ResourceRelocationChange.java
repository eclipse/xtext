/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.refactoring;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * URIs can also refer to folders and non-Xtext resources.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class ResourceRelocationChange {
	private final URI fromURI;

	private final URI toURI;

	private final boolean isFile;

	public ResourceRelocationChange(URI fromURI, URI toURI, boolean isFile) {
		this.fromURI = fromURI;
		this.toURI = toURI;
		this.isFile = isFile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromURI == null) ? 0 : fromURI.hashCode());
		result = prime * result + (isFile ? 1231 : 1237);
		result = prime * result + ((toURI == null) ? 0 : toURI.hashCode());
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
		ResourceRelocationChange other = (ResourceRelocationChange) obj;
		if (fromURI == null) {
			if (other.fromURI != null)
				return false;
		} else if (!fromURI.equals(other.fromURI))
			return false;
		if (isFile != other.isFile)
			return false;
		if (toURI == null) {
			if (other.toURI != null)
				return false;
		} else if (!toURI.equals(other.toURI))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("fromURI", fromURI);
		b.add("toURI", toURI);
		b.add("isFile", isFile);
		return b.toString();
	}

	public URI getFromURI() {
		return fromURI;
	}

	public URI getToURI() {
		return toURI;
	}

	public boolean isFile() {
		return isFile;
	}
}
