/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.labels;

import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

public class SimpleImageDescription implements IImageDescription {
	private final String imageID;

	public SimpleImageDescription(String imageID) {
		this.imageID = imageID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageID == null) ? 0 : imageID.hashCode());
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
		SimpleImageDescription other = (SimpleImageDescription) obj;
		if (imageID == null) {
			if (other.imageID != null)
				return false;
		} else if (!imageID.equals(other.imageID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("imageID", imageID);
		return b.toString();
	}

	public String getImageID() {
		return imageID;
	}
}
