/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.reconciler;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.7
 */
@SuppressWarnings("all")
public class CancelIndicatorBasedProgressMonitor implements IProgressMonitor {
  @Delegate
  private final IProgressMonitor doDelegate = new NullProgressMonitor();
  
  private final CancelIndicator cancelIndicator;
  
  @FinalFieldsConstructor
  public CancelIndicatorBasedProgressMonitor(final CancelIndicator cancelIndicator) {
    super();
    this.cancelIndicator = cancelIndicator;
  }
  
  @Override
  public boolean isCanceled() {
    return this.cancelIndicator.isCanceled();
  }
  
  public void beginTask(final String name, final int totalWork) {
    this.doDelegate.beginTask(name, totalWork);
  }
  
  public void done() {
    this.doDelegate.done();
  }
  
  public void internalWorked(final double work) {
    this.doDelegate.internalWorked(work);
  }
  
  public void setCanceled(final boolean value) {
    this.doDelegate.setCanceled(value);
  }
  
  public void setTaskName(final String name) {
    this.doDelegate.setTaskName(name);
  }
  
  public void subTask(final String name) {
    this.doDelegate.subTask(name);
  }
  
  public void worked(final int work) {
    this.doDelegate.worked(work);
  }
}
