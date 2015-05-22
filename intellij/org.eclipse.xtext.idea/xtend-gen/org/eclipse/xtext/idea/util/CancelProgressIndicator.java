/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.util;

import com.intellij.openapi.progress.ProgressIndicatorProvider;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class CancelProgressIndicator implements CancelIndicator {
  @Override
  public boolean isCanceled() {
    boolean _xblockexpression = false;
    {
      ProgressIndicatorProvider.checkCanceled();
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
}
