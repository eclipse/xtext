/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.labels;

import com.google.inject.ImplementedBy;
import org.eclipse.xtext.ide.labels.EClassImageDescriptionProvider;
import org.eclipse.xtext.ide.labels.IImageDescription;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(EClassImageDescriptionProvider.class)
@SuppressWarnings("all")
public interface IImageDescriptionProvider {
  public abstract IImageDescription getImageDescription(final Object element);
}
