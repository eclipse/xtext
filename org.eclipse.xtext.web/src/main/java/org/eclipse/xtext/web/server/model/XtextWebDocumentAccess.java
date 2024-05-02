/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.model;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

import org.apache.log4j.Logger;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ide.ExecutorServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.InvalidRequestException;
import org.eclipse.xtext.web.server.InvalidRequestException.InvalidDocumentStateException;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Accessor class for documents. Use {@link #readOnly(CancelableUnitOfWork)} to
 * read the content and properties of the document, and
 * {@link #modify(CancelableUnitOfWork, CancelableUnitOfWork)} to modify them.
 * If this accessor has been created with a required state identifier, it will
 * check the actual state identifier of the document before granting access, and
 * throw an exception if it does not match.
 */
public class XtextWebDocumentAccess {

	private static final Logger LOG = Logger.getLogger(XtextWebDocumentAccess.class);

	public static class Factory {
		@Inject
		private Provider<XtextWebDocumentAccess> provider;

		public XtextWebDocumentAccess create(XtextWebDocument document, String requiredStateId,
				boolean skipAsyncWork) {
			XtextWebDocumentAccess docAccess = provider.get();
			docAccess.init(document, requiredStateId, skipAsyncWork);
			docAccess.checkStateId();
			return docAccess;
		}

		public XtextWebDocumentAccess create(XtextWebDocument document, boolean skipAsyncWork) {
			XtextWebDocumentAccess docAccess = provider.get();
			docAccess.init(document, null, skipAsyncWork);
			return docAccess;
		}
	}

	protected static class ReadAccess implements IXtextWebDocument {
		private final XtextWebDocument document;

		@Override
		public void setText(String text) {
			throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
		}

		@Override
		public void updateText(String text, int offset, int replaceLength) {
			throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
		}

		@Override
		public void createNewStateId() {
			throw new UnsupportedOperationException("Cannot modify the document with read-only access.");
		}

		public ReadAccess(XtextWebDocument document) {
			this.document = document;
		}

		public XtextResource getResource() {
			return document.getResource();
		}

		public String getResourceId() {
			return document.getResourceId();
		}

		public String getStateId() {
			return document.getStateId();
		}

		public String getText() {
			return document.getText();
		}

		public boolean isDirty() {
			return document.isDirty();
		}

		public void setDirty(boolean dirty) {
			document.setDirty(dirty);
		}
	}

	private static final String DOCUMENT_LOCK_EXECUTOR = "withDocumentLock";

	@Inject
	private PrecomputedServiceRegistry preComputedServiceRegistry;

	@Inject
	private OperationCanceledManager operationCanceledManager;

	/**
	 * Executor service for runnables that are run when the lock is already acquired
	 */
	private ExecutorService executorService1;

	/**
	 * A second executor service for runnables that aquire the document lock
	 * themselves
	 */
	private ExecutorService executorService2;

	private XtextWebDocument document;

	private String requiredStateId;

	private boolean skipAsyncWork;

	@Inject
	protected void setExecutorServiceProvider(ExecutorServiceProvider executorServiceProvider) {
		executorService1 = executorServiceProvider.get(XtextWebDocumentAccess.DOCUMENT_LOCK_EXECUTOR);
		executorService2 = executorServiceProvider.get();
	}

	protected void init(XtextWebDocument document, String requiredStateId, boolean skipAsyncWork) {
		this.document = document;
		this.requiredStateId = requiredStateId;
		this.skipAsyncWork = skipAsyncWork;
	}

	protected void checkStateId() throws InvalidRequestException.InvalidDocumentStateException {
		if (requiredStateId != null && !Objects.equals(requiredStateId, document.getStateId())) {
			throw new InvalidRequestException.InvalidDocumentStateException(
					"The given state id does not match the current state.");
		}
	}

	/**
	 * Execute the given work unit with read-only access and return its result.
	 */
	public <T extends Object> T readOnly(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		return doAccess(work, false, false, null);
	}

	/**
	 * Execute the given work unit with read-only access and return its result. The
	 * work unit is handled with higher priority, i.e. currently running work units
	 * are canceled if they support cancellation.
	 */
	public <T extends Object> T priorityReadOnly(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		return doAccess(work, true, false, null);
	}

	/**
	 * Execute the given work unit with read and write access and return its result.
	 * The work unit is handled with higher priority, i.e. currently running work
	 * units are canceled if they support cancellation. The second work unit
	 * {@code asynchronousWork} is executed in a separate thread after the first one
	 * has finished. It can be used for background work that should be applied to
	 * the document, but is not relevant for the current service request.
	 */
	public <T extends Object> T modify(CancelableUnitOfWork<T, IXtextWebDocument> work,
			CancelableUnitOfWork<?, IXtextWebDocument> asynchronousWork) {
		return doAccess(work, true, true, asynchronousWork);
	}

	/**
	 * Execute the given work unit with read and write access and return its result.
	 * The work unit is handled with higher priority, i.e. currently running work
	 * units are canceled if they support cancellation.
	 */
	public <T extends Object> T modify(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		return doAccess(work, true, true, null);
	}

	protected <T extends Object> T doAccess(CancelableUnitOfWork<T, IXtextWebDocument> synchronousWork,
			boolean priority, boolean modify, CancelableUnitOfWork<?, IXtextWebDocument> asynchronousWork) {
		try {
			DocumentSynchronizer synchronizer = document.getSynchronizer();
			final IXtextWebDocument documentAccess;
			if (modify) {
				documentAccess = document;
			} else {
				documentAccess = createReadAccess(document);
			}
			boolean currentThreadOwnsLock = true;
			T result = null;
			try {
				synchronizer.acquireLock(priority);
				checkStateId();
				synchronousWork.setCancelIndicator(synchronizer);
				result = synchronousWork.exec(documentAccess);
				requiredStateId = document.getStateId();
				if (!skipAsyncWork && priority && documentAccess != null && !synchronizer.isCanceled()
						&& !Thread.currentThread().isInterrupted()) {
					executorService1.submit(new Runnable() {
						public void run() {
							try {
								if (asynchronousWork != null) {
									asynchronousWork.setCancelIndicator(synchronizer);
									asynchronousWork.exec(documentAccess);
								}
								EcoreUtil2.resolveLazyCrossReferences(documentAccess.getResource(), synchronizer);
							} catch (VirtualMachineError error) {
								throw error;
							} catch (Throwable throwable) {
								if (operationCanceledManager.isOperationCanceledException(throwable)) {
									LOG.trace("Canceling background work.");
								} else {
									LOG.error("Error during background work.", throwable);
								}
							} finally {
								synchronizer.releaseLock();
							}
						}
					});
					currentThreadOwnsLock = false;
					executorService2.submit(new Runnable() {
						public void run() {
							try {
								performPrecomputation(synchronizer);
							} catch (VirtualMachineError error) {
								throw error;
							} catch (InvalidDocumentStateException idse) {
								// The document has changed since we executed our synchronous work - stop
								// precomputation
								return;
							} catch (Throwable throwable) {
								if (operationCanceledManager.isOperationCanceledException(throwable)) {
									LOG.trace("Canceling precomputation.");
								} else {
									LOG.error("Error during precomputation.", throwable);
								}
							}
						}
					});
				}
			} catch (RejectedExecutionException ree) {
				XtextWebDocumentAccess.LOG.error("Failed to start background work.", ree);
			} finally {
				if (currentThreadOwnsLock) {
					synchronizer.releaseLock();
				}
			}
			return result;
		} catch (Exception e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected void performPrecomputation(CancelIndicator cancelIndicator) {
		for (AbstractCachedService<? extends IServiceResult> service : preComputedServiceRegistry
				.getPrecomputedServices()) {
			operationCanceledManager.checkCanceled(cancelIndicator);
			getCachedServiceResult(service, false);
		}
	}

	protected <T extends IServiceResult> T getCachedServiceResult(AbstractCachedService<T> service,
			boolean logCacheMiss) {
		return readOnly(new CancelableUnitOfWork<T, IXtextWebDocument>() {
			@Override
			public T exec(IXtextWebDocument d, CancelIndicator cancelIndicator) throws Exception {
				if (document.getResourceId() != null) {
					return document.getCachedServiceResult(service, cancelIndicator, logCacheMiss);
				} else {
					return service.compute(document, cancelIndicator);
				}
			}
		});
	}

	/**
	 * @since 2.11
	 */
	protected IXtextWebDocument createReadAccess(XtextWebDocument document) {
		return new XtextWebDocumentAccess.ReadAccess(document);
	}

}
