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
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class RenameChange {
	private final String newName;

	private final URI targetURI;

	public RenameChange(String newName, URI targetURI) {
		this.newName = newName;
		this.targetURI = targetURI;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((newName == null) ? 0 : newName.hashCode());
		result = prime * result + ((targetURI == null) ? 0 : targetURI.hashCode());
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
		RenameChange other = (RenameChange) obj;
		if (newName == null) {
			if (other.newName != null)
				return false;
		} else if (!newName.equals(other.newName))
			return false;
		if (targetURI == null) {
			if (other.targetURI != null)
				return false;
		} else if (!targetURI.equals(other.targetURI))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("newName", newName);
		b.add("targetURI", targetURI);
		return b.toString();
	}

	public String getNewName() {
		return newName;
	}

	public URI getTargetURI() {
		return targetURI;
	}
}
