/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Stefan Oehme - Initial contribution and API
 * @since 2.6
 */
public class Task {
	private TaskTag tag;

	private String description;

	private int lineNumber;

	private int offset;

	public String getFullText() {
		return tag.getName() + description;
	}

	public int getTotalLength() {
		return getFullText().length();
	}

	public int getTagLength() {
		return tag.length();
	}

	public TaskTag getTag() {
		return tag;
	}

	public void setTag(TaskTag tag) {
		this.tag = tag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Task other = (Task) obj;
		if (tag == null) {
			if (other.tag != null) {
				return false;
			}
		} else if (!tag.equals(other.tag)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (other.lineNumber != lineNumber) {
			return false;
		}
		if (other.offset != offset) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (tag == null ? 0 : tag.hashCode());
		result = prime * result + (description == null ? 0 : description.hashCode());
		result = prime * result + lineNumber;
		return prime * result + offset;
	}
	
	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("tag", getTag());
		b.add("description", getDescription());
		b.add("lineNumber", getLineNumber());
		b.add("offset", getOffset());
		return super.toString();
	}
}
