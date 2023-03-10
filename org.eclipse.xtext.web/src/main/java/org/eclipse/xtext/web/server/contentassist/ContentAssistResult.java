/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the content assist service.
 */
public class ContentAssistResult implements IServiceResult {
	private final String stateId;

	private final List<ContentAssistEntry> entries = new ArrayList<>();

	public ContentAssistResult(String stateId) {
		this.stateId = stateId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((entries == null) ? 0 : entries.hashCode());
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
		ContentAssistResult other = (ContentAssistResult) obj;
		if (entries == null) {
			if (other.entries != null)
				return false;
		} else if (!entries.equals(other.entries))
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
		b.skipNulls();
		b.add("stateId", this.stateId);
		b.add("entries", this.entries);
		return b.toString();
	}

	public String getStateId() {
		return stateId;
	}

	public List<ContentAssistEntry> getEntries() {
		return entries;
	}
}
