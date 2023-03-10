/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.util;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.CancelIndicator;

@FinalFieldsConstructor
public class CancelIndicatorProgressMonitor implements IProgressMonitor {
  private final CancelIndicator delegate;
  
  private boolean isCanceled;
  
  @Override
  public boolean isCanceled() {
    return isCanceled || this.delegate.isCanceled();
  }
  
  @Override
  public void setCanceled(boolean value) {
    this.isCanceled = value;
  }
  
  @Override
  public void beginTask(String name, int totalWork) {
  }
  
  @Override
  public void setTaskName(String name) {
  }
  
  @Override
  public void subTask(String name) {
  }
  
  @Override
  public void internalWorked(double work) {
  }
  
  @Override
  public void worked(int work) {
  }
  
  @Override
  public void done() {
  }
  
  public CancelIndicatorProgressMonitor(CancelIndicator delegate) {
    this.delegate = delegate;
  }
}
