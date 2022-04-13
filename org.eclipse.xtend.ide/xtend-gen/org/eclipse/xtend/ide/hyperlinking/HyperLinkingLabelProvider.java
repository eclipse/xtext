/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.hyperlinking;

import com.google.inject.Inject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtend.ide.labeling.XtendLabelProvider;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class HyperLinkingLabelProvider extends XtendLabelProvider {
  @Inject
  public HyperLinkingLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }

  @Override
  public String getText(final Object element) {
    final String result = super.getText(element);
    if ((result != null)) {
      return ("Open Declaration - " + result);
    }
    return null;
  }
}
