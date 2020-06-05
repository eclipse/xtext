/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.labels;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

public class AlternativeImageDescription implements IImageDescription {
	private final List<String> imageIDs;

	public AlternativeImageDescription(Iterable<String> imageIDs) {
		this.imageIDs = ImmutableList.copyOf(imageIDs);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageIDs == null) ? 0 : imageIDs.hashCode());
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
		AlternativeImageDescription other = (AlternativeImageDescription) obj;
		if (imageIDs == null) {
			if (other.imageIDs != null)
				return false;
		} else if (!imageIDs.equals(other.imageIDs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("imageIDs", imageIDs);
		return b.toString();
	}

	public List<String> getImageIDs() {
		return imageIDs;
	}
}
