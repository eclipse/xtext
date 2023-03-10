/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.hover;

import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the hover service.
 */
public class HoverResult implements IServiceResult {
	private final String stateId;

	private final String title;

	private final String content;

	public HoverResult(String stateId) {
		this.stateId = stateId;
		this.title = null;
		this.content = null;
	}

	public HoverResult(String stateId, String title, String content) {
		this.stateId = stateId;
		this.title = title;
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		HoverResult other = (HoverResult) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.skipNulls();
		b.add("stateId", this.stateId);
		b.add("title", this.title);
		b.add("content", this.content);
		return b.toString();
	}

	public String getStateId() {
		return stateId;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
}
