/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
  IImageDescription getImageDescription(final Object element);
}
