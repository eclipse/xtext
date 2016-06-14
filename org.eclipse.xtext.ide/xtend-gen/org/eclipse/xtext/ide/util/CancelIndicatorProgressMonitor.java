/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.util;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class CancelIndicatorProgressMonitor implements IProgressMonitor {
  private final CancelIndicator delegate;
  
  private boolean canceled;
  
  @Override
  public boolean isCanceled() {
    return (this.canceled || this.delegate.isCanceled());
  }
  
  @Override
  public void setCanceled(final boolean value) {
    this.canceled = value;
  }
  
  @Override
  public void beginTask(final String name, final int totalWork) {
  }
  
  @Override
  public void setTaskName(final String name) {
  }
  
  @Override
  public void subTask(final String name) {
  }
  
  @Override
  public void internalWorked(final double work) {
  }
  
  @Override
  public void worked(final int work) {
  }
  
  @Override
  public void done() {
  }
  
  public CancelIndicatorProgressMonitor(final CancelIndicator delegate) {
    super();
    this.delegate = delegate;
  }
}
