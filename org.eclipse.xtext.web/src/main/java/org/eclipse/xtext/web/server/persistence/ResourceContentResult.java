/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.persistence;

import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by load and revert services.
 */
public class ResourceContentResult implements IServiceResult {
	private final String fullText;

	private final String stateId;

	private final boolean dirty;

	public ResourceContentResult(String fullText, String stateId, boolean dirty) {
		this.fullText = fullText;
		this.stateId = stateId;
		this.dirty = dirty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (dirty ? 1231 : 1237);
		result = prime * result + ((fullText == null) ? 0 : fullText.hashCode());
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
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
		ResourceContentResult other = (ResourceContentResult) obj;
		if (dirty != other.dirty)
			return false;
		if (fullText == null) {
			if (other.fullText != null)
				return false;
		} else if (!fullText.equals(other.fullText))
			return false;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("fullText", this.fullText);
		b.add("stateId", this.stateId);
		b.add("dirty", this.dirty);
		return b.toString();
	}

	public String getFullText() {
		return fullText;
	}

	public String getStateId() {
		return stateId;
	}

	public boolean isDirty() {
		return dirty;
	}
}
