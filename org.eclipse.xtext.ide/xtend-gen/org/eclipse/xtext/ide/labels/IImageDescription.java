/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.labels;

import org.eclipse.xtext.ide.labels.SimpleImageDescription;

/**
 * Describes an image in a platform independent way.
 * Subclasses should implement {@link Object#equals(Object)} and {@link Object#hashCode()}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @noimplement
 * @noextend
 */
@SuppressWarnings("all")
public interface IImageDescription {
  static final SimpleImageDescription DEFAULT = new SimpleImageDescription("default");
}
