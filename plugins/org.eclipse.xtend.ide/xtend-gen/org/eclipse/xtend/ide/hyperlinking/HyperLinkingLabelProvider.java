/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.hyperlinking;

import com.google.common.base.Objects;
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
    boolean _notEquals = (!Objects.equal(result, null));
    if (_notEquals) {
      return ("Open Declaration - " + result);
    }
    return null;
  }
}
