/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.inject.Inject;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Synchronizer object used by the {@link XtextWebDocumentAccess} for managing multithreaded
 * access to a document. It holds the cancelation status and locking information. The lock
 * is not bound to a thread, so it is possible for one thread to call {@link #acquireLock(boolean)}
 * and for another thread to call {@link #releaseLock()}.
 */
@SuppressWarnings("all")
public class DocumentSynchronizer implements CancelIndicator {
  private final Semaphore semaphore = new Semaphore(1, true);
  
  private final AtomicInteger waitingPriorityJobs = new AtomicInteger();
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  @Accessors
  private volatile boolean canceled;
  
  public Boolean acquireLock(final boolean priority) {
    try {
      boolean _xblockexpression = false;
      {
        if (priority) {
          this.waitingPriorityJobs.incrementAndGet();
          this.canceled = true;
        }
        this.semaphore.acquire();
        boolean _xifexpression = false;
        if (priority) {
          boolean _xifexpression_1 = false;
          int _decrementAndGet = this.waitingPriorityJobs.decrementAndGet();
          boolean _equals = (_decrementAndGet == 0);
          if (_equals) {
            _xifexpression_1 = this.canceled = false;
          }
          _xifexpression = _xifexpression_1;
        } else {
          this.operationCanceledManager.checkCanceled(this);
        }
        _xblockexpression = _xifexpression;
      }
      return Boolean.valueOf(_xblockexpression);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void releaseLock() {
    int _availablePermits = this.semaphore.availablePermits();
    boolean _notEquals = (_availablePermits != 0);
    if (_notEquals) {
      throw new IllegalStateException("Cannot release a lock without acquiring it first.");
    }
    this.semaphore.release();
  }
  
  @Pure
  public boolean isCanceled() {
    return this.canceled;
  }
  
  public void setCanceled(final boolean canceled) {
    this.canceled = canceled;
  }
}
