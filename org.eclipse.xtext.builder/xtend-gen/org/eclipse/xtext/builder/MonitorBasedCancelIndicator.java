/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @noreference
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class MonitorBasedCancelIndicator implements CancelIndicator {
  private final IProgressMonitor monitor;
  
  @Override
  public boolean isCanceled() {
    return this.monitor.isCanceled();
  }
  
  public MonitorBasedCancelIndicator(final IProgressMonitor monitor) {
    super();
    this.monitor = monitor;
  }
}
