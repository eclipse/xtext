/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.labels;

import java.util.List;

import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.common.collect.ImmutableList;

public class DecoratedImageDescription implements IImageDescription {
	private final IImageDescription baseImage;

	private final List<IImageDescription> decorators;

	public DecoratedImageDescription(IImageDescription baseImage, IImageDescription... decorators) {
		this.baseImage = baseImage;
		this.decorators = ImmutableList.<IImageDescription>copyOf(decorators);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baseImage == null) ? 0 : baseImage.hashCode());
		result = prime * result + ((decorators == null) ? 0 : decorators.hashCode());
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
		DecoratedImageDescription other = (DecoratedImageDescription) obj;
		if (baseImage == null) {
			if (other.baseImage != null)
				return false;
		} else if (!baseImage.equals(other.baseImage))
			return false;
		if (decorators == null) {
			if (other.decorators != null)
				return false;
		} else if (!decorators.equals(other.decorators))
			return false;
		return true;
	}

	@Override
	public String toString() {
		ToStringBuilder b = new ToStringBuilder(this);
		b.add("baseImage", baseImage);
		b.add("decorators", decorators);
		return b.toString();
	}

	public IImageDescription getBaseImage() {
		return baseImage;
	}

	public List<IImageDescription> getDecorators() {
		return decorators;
	}
}
