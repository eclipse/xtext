/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.labels

import org.eclipse.xtend.lib.annotations.Data
import java.util.List
import com.google.common.collect.ImmutableList

/**
 * Describes an image in a platform independent way.
 * Subclasses should implement {@link Object#equals(Object)} and {@link Object#hashCode()}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @noimplement
 * @noextend
 */
interface IImageDescription {
	val DEFAULT = new SimpleImageDescription('default')	
}

@Data
class SimpleImageDescription implements IImageDescription {
	String imageID
}

@Data 
class AlternativeImageDescription implements IImageDescription {
	List<String> imageIDs
	
	new(Iterable<String> imageIDs) {
		this.imageIDs = ImmutableList.copyOf(imageIDs)
	}
}

@Data
class DecoratedImageDescription implements IImageDescription {
	IImageDescription baseImage
	
	List<IImageDescription> decorators	
	
	new(IImageDescription baseImage, IImageDescription... decorators) {
		this.baseImage = baseImage
		this.decorators = ImmutableList.copyOf(decorators)
	}
}