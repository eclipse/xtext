/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.model;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import org.apache.log4j.Logger;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.model.AbstractCachedService;
import org.eclipse.xtext.web.server.model.DocumentSynchronizer;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.PrecomputedServiceRegistry;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * Accessor class for documents. Use {@link #readOnly(CancelableUnitOfWork)} to
 * read the content and properties of the document, and
 * {@link #modify(CancelableUnitOfWork, CancelableUnitOfWork)} to modify them.
 * If this accessor has been created with a required state identifier, it will
 * check the actual state identifier of the document before granting access, and
 * throw an exception if it does not match.
 */
@Log
@SuppressWarnings("all")
public class XtextWebDocumentAccess {
  public static class Factory {
    @Inject
    private Provider<XtextWebDocumentAccess> provider;
    
    public XtextWebDocumentAccess create(final XtextWebDocument document, final String requiredStateId, final boolean skipAsyncWork) {
      final XtextWebDocumentAccess docAccess = this.provider.get();
      docAccess.init(document, requiredStateId, skipAsyncWork);
      docAccess.checkStateId();
      return docAccess;
    }
    
    public XtextWebDocumentAccess create(final XtextWebDocument document, final boolean skipAsyncWork) {
      XtextWebDocumentAccess docAccess = this.provider.get();
      docAccess.init(document, null, skipAsyncWork);
      return docAccess;
    }
  }
  
  @FinalFieldsConstructor
  protected static class ReadAccess implements IXtextWebDocument {
    @Delegate
    private final XtextWebDocument document;
    
    @Override
    public void setText(final String text) {
      throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
    }
    
    @Override
    public void updateText(final String text, final int offset, final int replaceLength) {
      throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
    }
    
    @Override
    public void createNewStateId() {
      throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
    }
    
    public ReadAccess(final XtextWebDocument document) {
      super();
      this.document = document;
    }
    
    public XtextResource getResource() {
      return this.document.getResource();
    }
    
    public String getResourceId() {
      return this.document.getResourceId();
    }
    
    public String getText() {
      return this.document.getText();
    }
    
    public String getStateId() {
      return this.document.getStateId();
    }
    
    public boolean isDirty() {
      return this.document.isDirty();
    }
    
    public void setDirty(final boolean dirty) {
      this.document.setDirty(dirty);
    }
  }
  
  @Inject
  private PrecomputedServiceRegistry preComputedServiceRegistry;
  
  /**
   * Executor service for runnables that are run when the lock is already acquired
   */
  @Inject
  @Named("withDocumentLock")
  private ExecutorService executorService1;
  
  /**
   * A second executor service for runnables that aquire the document lock themselves
   */
  @Inject
  private ExecutorService executorService2;
  
  @Inject
  private OperationCanceledManager operationCanceledManager;
  
  private XtextWebDocument document;
  
  private String requiredStateId;
  
  private boolean skipAsyncWork;
  
  protected void init(final XtextWebDocument document, final String requiredStateId, final boolean skipAsyncWork) {
    this.document = document;
    this.requiredStateId = requiredStateId;
    this.skipAsyncWork = skipAsyncWork;
  }
  
  protected void checkStateId() throws InvalidRequestException.InvalidDocumentStateException {
    boolean _and = false;
    if (!(this.requiredStateId != null)) {
      _and = false;
    } else {
      String _stateId = this.document.getStateId();
      boolean _notEquals = (!Objects.equal(this.requiredStateId, _stateId));
      _and = _notEquals;
    }
    if (_and) {
      throw new InvalidRequestException.InvalidDocumentStateException("The given state id does not match the current state.");
    }
  }
  
  /**
   * Execute the given work unit with read-only access and return its result.
   */
  public <T extends Object> T readOnly(final CancelableUnitOfWork<T, IXtextWebDocument> work) {
    return this.<T>doAccess(work, false, false, null);
  }
  
  /**
   * Execute the given work unit with read-only access and return its result.
   * The work unit is handled with higher priority, i.e. currently running
   * work units are canceled if they support cancellation.
   */
  public <T extends Object> T priorityReadOnly(final CancelableUnitOfWork<T, IXtextWebDocument> work) {
    return this.<T>doAccess(work, true, false, null);
  }
  
  /**
   * Execute the given work unit with read and write access and return its
   * result. The work unit is handled with higher priority, i.e. currently
   * running work units are canceled if they support cancellation.
   * The second work unit {@code asynchronousWork} is executed in a separate
   * thread after the first one has finished. It can be used for background
   * work that should be applied to the document, but is not relevant for the
   * current service request.
   */
  public <T extends Object> T modify(final CancelableUnitOfWork<T, IXtextWebDocument> work, final CancelableUnitOfWork<?, IXtextWebDocument> asynchronousWork) {
    return this.<T>doAccess(work, true, true, asynchronousWork);
  }
  
  /**
   * Execute the given work unit with read and write access and return its
   * result. The work unit is handled with higher priority, i.e. currently
   * running work units are canceled if they support cancellation.
   */
  public <T extends Object> T modify(final CancelableUnitOfWork<T, IXtextWebDocument> work) {
    return this.<T>doAccess(work, true, true, null);
  }
  
  protected <T extends Object> T doAccess(final CancelableUnitOfWork<T, IXtextWebDocument> synchronousWork, final boolean priority, final boolean modify, final CancelableUnitOfWork<?, IXtextWebDocument> asynchronousWork) {
    try {
      final DocumentSynchronizer synchronizer = this.document.getSynchronizer();
      IXtextWebDocument _xifexpression = null;
      if (modify) {
        _xifexpression = this.document;
      } else {
        _xifexpression = new XtextWebDocumentAccess.ReadAccess(this.document);
      }
      final IXtextWebDocument documentAccess = _xifexpression;
      boolean currentThreadOwnsLock = true;
      T result = null;
      try {
        synchronizer.acquireLock(priority);
        this.checkStateId();
        synchronousWork.setCancelIndicator(synchronizer);
        T _exec = synchronousWork.exec(documentAccess);
        result = _exec;
        String _stateId = this.document.getStateId();
        this.requiredStateId = _stateId;
        boolean _and = false;
        boolean _and_1 = false;
        if (!(((!this.skipAsyncWork) && priority) && (documentAccess != null))) {
          _and_1 = false;
        } else {
          boolean _isCanceled = synchronizer.isCanceled();
          boolean _not = (!_isCanceled);
          _and_1 = _not;
        }
        if (!_and_1) {
          _and = false;
        } else {
          Thread _currentThread = Thread.currentThread();
          boolean _isInterrupted = _currentThread.isInterrupted();
          boolean _not_1 = (!_isInterrupted);
          _and = _not_1;
        }
        if (_and) {
          final Runnable _function = new Runnable() {
            @Override
            public void run() {
              try {
                if ((asynchronousWork != null)) {
                  asynchronousWork.setCancelIndicator(synchronizer);
                  asynchronousWork.exec(documentAccess);
                }
                XtextResource _resource = documentAccess.getResource();
                EcoreUtil2.resolveLazyCrossReferences(_resource, synchronizer);
              } catch (final Throwable _t) {
                if (_t instanceof VirtualMachineError) {
                  final VirtualMachineError error = (VirtualMachineError)_t;
                  throw error;
                } else if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  boolean _isOperationCanceledException = XtextWebDocumentAccess.this.operationCanceledManager.isOperationCanceledException(throwable);
                  if (_isOperationCanceledException) {
                    XtextWebDocumentAccess.LOG.trace("Canceling background work.");
                  } else {
                    XtextWebDocumentAccess.LOG.error("Error during background work.", throwable);
                  }
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              } finally {
                synchronizer.releaseLock();
              }
            }
          };
          this.executorService1.submit(_function);
          currentThreadOwnsLock = false;
          final Runnable _function_1 = new Runnable() {
            @Override
            public void run() {
              try {
                XtextWebDocumentAccess.this.performPrecomputation(synchronizer);
              } catch (final Throwable _t) {
                if (_t instanceof VirtualMachineError) {
                  final VirtualMachineError error = (VirtualMachineError)_t;
                  throw error;
                } else if (_t instanceof InvalidRequestException.InvalidDocumentStateException) {
                  final InvalidRequestException.InvalidDocumentStateException idse = (InvalidRequestException.InvalidDocumentStateException)_t;
                  return;
                } else if (_t instanceof Throwable) {
                  final Throwable throwable = (Throwable)_t;
                  boolean _isOperationCanceledException = XtextWebDocumentAccess.this.operationCanceledManager.isOperationCanceledException(throwable);
                  if (_isOperationCanceledException) {
                    XtextWebDocumentAccess.LOG.trace("Canceling precomputation.");
                  } else {
                    XtextWebDocumentAccess.LOG.error("Error during precomputation.", throwable);
                  }
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
            }
          };
          this.executorService2.submit(_function_1);
        }
      } catch (final Throwable _t) {
        if (_t instanceof RejectedExecutionException) {
          final RejectedExecutionException ree = (RejectedExecutionException)_t;
          XtextWebDocumentAccess.LOG.error("Failed to start background work.", ree);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      } finally {
        if (currentThreadOwnsLock) {
          synchronizer.releaseLock();
        }
      }
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void performPrecomputation(final CancelIndicator cancelIndicator) {
    Iterable<AbstractCachedService<? extends IServiceResult>> _precomputedServices = this.preComputedServiceRegistry.getPrecomputedServices();
    for (final AbstractCachedService<? extends IServiceResult> service : _precomputedServices) {
      {
        this.operationCanceledManager.checkCanceled(cancelIndicator);
        this.getCachedServiceResult(service, false);
      }
    }
  }
  
  protected <T extends IServiceResult> T getCachedServiceResult(final AbstractCachedService<T> service, final boolean logCacheMiss) {
    final CancelableUnitOfWork<T, IXtextWebDocument> _function = new CancelableUnitOfWork<T, IXtextWebDocument>() {
      @Override
      public T exec(final IXtextWebDocument d, final CancelIndicator cancelIndicator) throws Exception {
        String _resourceId = XtextWebDocumentAccess.this.document.getResourceId();
        boolean _tripleNotEquals = (_resourceId != null);
        if (_tripleNotEquals) {
          return XtextWebDocumentAccess.this.document.<T>getCachedServiceResult(service, cancelIndicator, logCacheMiss);
        } else {
          return service.compute(XtextWebDocumentAccess.this.document, cancelIndicator);
        }
      }
    };
    return this.<T>readOnly(_function);
  }
  
  private final static Logger LOG = Logger.getLogger(XtextWebDocumentAccess.class);
}
