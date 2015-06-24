package org.eclipse.xtext.web.server.util;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.CancelIndicator;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class CancelIndicatorProgressMonitor implements IProgressMonitor {
  private final CancelIndicator delegate;
  
  private boolean isCanceled;
  
  @Override
  public void beginTask(final String name, final int totalWork) {
  }
  
  @Override
  public void done() {
  }
  
  @Override
  public void internalWorked(final double work) {
  }
  
  @Override
  public boolean isCanceled() {
    boolean _or = false;
    if (this.isCanceled) {
      _or = true;
    } else {
      boolean _isCanceled = this.delegate.isCanceled();
      _or = _isCanceled;
    }
    return _or;
  }
  
  @Override
  public void setCanceled(final boolean value) {
    this.isCanceled = value;
  }
  
  @Override
  public void setTaskName(final String name) {
  }
  
  @Override
  public void subTask(final String name) {
  }
  
  @Override
  public void worked(final int work) {
  }
  
  public CancelIndicatorProgressMonitor(final CancelIndicator delegate) {
    super();
    this.delegate = delegate;
  }
}
