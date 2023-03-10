/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the validation service.
 */
public class ValidationResult implements IServiceResult {
	public static class Issue {
		private final String description;

		private final String severity;

		/**
		 * One based, the first line has the number 1.
		 */
		private final Integer line;

		/**
		 * One based, the first column in a line has the number 1.
		 */
		private final Integer column;

		/**
		 * Zero based, the first char in a document has the offset 0.
		 */
		private final Integer offset;

		private final Integer length;

		public Issue(String description, String severity, Integer line, Integer column, Integer offset,
				Integer length) {
			this.description = description;
			this.severity = severity;
			this.line = line;
			this.column = column;
			this.offset = offset;
			this.length = length;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
			result = prime * result + ((this.severity == null) ? 0 : this.severity.hashCode());
			result = prime * result + ((this.line == null) ? 0 : this.line.hashCode());
			result = prime * result + ((this.column == null) ? 0 : this.column.hashCode());
			result = prime * result + ((this.offset == null) ? 0 : this.offset.hashCode());
			return prime * result + ((this.length == null) ? 0 : this.length.hashCode());
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ValidationResult.Issue other = (ValidationResult.Issue) obj;
			if (this.description == null) {
				if (other.description != null)
					return false;
			} else if (!this.description.equals(other.description))
				return false;
			if (this.severity == null) {
				if (other.severity != null)
					return false;
			} else if (!this.severity.equals(other.severity))
				return false;
			if (this.line == null) {
				if (other.line != null)
					return false;
			} else if (!this.line.equals(other.line))
				return false;
			if (this.column == null) {
				if (other.column != null)
					return false;
			} else if (!this.column.equals(other.column))
				return false;
			if (this.offset == null) {
				if (other.offset != null)
					return false;
			} else if (!this.offset.equals(other.offset))
				return false;
			if (this.length == null) {
				if (other.length != null)
					return false;
			} else if (!this.length.equals(other.length))
				return false;
			return true;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.skipNulls();
			b.add("description", this.description);
			b.add("severity", this.severity);
			b.add("line", this.line);
			b.add("column", this.column);
			b.add("offset", this.offset);
			b.add("length", this.length);
			return b.toString();
		}

		public String getDescription() {
			return description;
		}

		public String getSeverity() {
			return severity;
		}

		public Integer getLine() {
			return line;
		}

		public Integer getColumn() {
			return column;
		}

		public Integer getOffset() {
			return offset;
		}

		public Integer getLength() {
			return length;
		}
	}

	private final List<ValidationResult.Issue> issues = new ArrayList<>();

	@Override
	public int hashCode() {
		return 31 * 1 + ((this.issues == null) ? 0 : this.issues.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValidationResult other = (ValidationResult) obj;
		if (this.issues == null) {
			if (other.issues != null)
				return false;
		} else if (!this.issues.equals(other.issues))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("issues", this.issues);
		return b.toString();
	}

	public List<ValidationResult.Issue> getIssues() {
		return issues;
	}
}
