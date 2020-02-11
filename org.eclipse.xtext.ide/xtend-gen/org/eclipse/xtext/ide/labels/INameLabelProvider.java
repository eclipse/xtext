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
import org.eclipse.xtext.ide.labels.SimpleNameLabelProvider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(SimpleNameLabelProvider.class)
@SuppressWarnings("all")
public interface INameLabelProvider {
  String getNameLabel(final Object element);
}
