/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.syntaxcoloring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the highlighting service.
 */
public class HighlightingResult implements IServiceResult {
	public static class Region {
		private final int offset;

		private final int length;

		private final String[] styleClasses;

		public Region(int offset, int length, String[] styleClasses) {
			this.offset = offset;
			this.length = length;
			this.styleClasses = styleClasses;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.offset;
			result = prime * result + this.length;
			return prime * result + ((this.styleClasses == null) ? 0 : Arrays.deepHashCode(this.styleClasses));
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			HighlightingResult.Region other = (HighlightingResult.Region) obj;
			if (other.offset != this.offset)
				return false;
			if (other.length != this.length)
				return false;
			if (this.styleClasses == null) {
				if (other.styleClasses != null)
					return false;
			} else if (!Arrays.deepEquals(this.styleClasses, other.styleClasses))
				return false;
			return true;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.singleLine();
			b.add("offset", this.offset);
			b.add("length", this.length);
			b.add("styleClasses", this.styleClasses);
			return b.toString();
		}

		public int getOffset() {
			return offset;
		}

		public int getLength() {
			return length;
		}

		public String[] getStyleClasses() {
			return styleClasses;
		}
	}

	private final List<HighlightingResult.Region> regions = new ArrayList<>();

	@Override
	public int hashCode() {
		return 31 * 1 + ((this.regions == null) ? 0 : this.regions.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HighlightingResult other = (HighlightingResult) obj;
		if (this.regions == null) {
			if (other.regions != null)
				return false;
		} else if (!this.regions.equals(other.regions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("regions", this.regions);
		return b.toString();
	}

	public List<HighlightingResult.Region> getRegions() {
		return regions;
	}
}
