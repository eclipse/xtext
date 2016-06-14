/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.labels;

import org.eclipse.xtext.ide.labels.SimpleImageDescription;

/**
 * Describes an image in a platform independent way.
 * Subclasses should implement {@link #equals(Object)} and {@link #hashCode()}.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @noimplement
 * @noextend
 */
@SuppressWarnings("all")
public interface IImageDescription {
  public final static SimpleImageDescription DEFAULT = new SimpleImageDescription("default");
}
