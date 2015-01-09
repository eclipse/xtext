/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.presentation;

import com.google.inject.ImplementedBy;
import com.intellij.navigation.ItemPresentation;
import org.eclipse.xtext.idea.presentation.DefaultItemPresentationProvider;

/**
 * @author kosyakov - Initial contribution and API
 */
@ImplementedBy(DefaultItemPresentationProvider.class)
@SuppressWarnings("all")
public interface ItemPresentationProvider {
  public abstract ItemPresentation getItemPresentation(final Object element);
}
