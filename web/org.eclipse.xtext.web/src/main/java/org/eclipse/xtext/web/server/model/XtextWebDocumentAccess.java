/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

import org.apache.log4j.Logger;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.web.server.InvalidRequestException.InvalidDocumentStateException;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

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

	private final ReadAccess readOnlyAccess = new ReadAccess();

	private final ModifyAccess modifyAccess = new ModifyAccess();

	@Inject
	private PrecomputedServiceRegistry preComputedServiceRegistry;
	
    /**
     * Executor service for runnables that are run when the lock is already acquired 
     */
    @Inject @Named("withDocumentLock")
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

	public static class Factory {

		@Inject
		private Provider<XtextWebDocumentAccess> provider;

		public XtextWebDocumentAccess create(XtextWebDocument document, String requiredStateId, boolean skipAsyncWork) {
			XtextWebDocumentAccess access = provider.get();
			access.init(document, requiredStateId, skipAsyncWork);
			access.checkStateId();
			return access;
		}

		public XtextWebDocumentAccess create(XtextWebDocument document, boolean skipAsyncWork) {
			XtextWebDocumentAccess access = provider.get();
			access.init(document, null, skipAsyncWork);
			return access;
		}
	}

	protected void init(XtextWebDocument document, String requiredStateId, boolean skipAsyncWork) {
		this.document = document;
		this.requiredStateId = requiredStateId;
		this.skipAsyncWork = skipAsyncWork;
	}

	protected void checkStateId() throws InvalidDocumentStateException {
		if (requiredStateId != null && !requiredStateId.equals(document.getStateId())) {
			throw new InvalidDocumentStateException("The given state id does not match the current state.");
		}
	}

	/**
	 * Execute the given work unit with read-only access and return its result.
	 */
	public <T> T readOnly(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		return doAccess(work, false, false, null);
	}

	/**
	 * Execute the given work unit with read-only access and return its result.
	 * The work unit is handled with higher priority, i.e. currently running
	 * work units are canceled if they support cancelation. 
	 */
	public <T> T priorityReadOnly(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		return doAccess(work, true, false, null);
	}

	/**
	 * Execute the given work unit with read and write access and return its
	 * result. The work unit is handled with higher priority, i.e. currently
	 * running work units are canceled if they support cancelation.
	 * 
	 * The second work unit {@code asynchronousWork} is executed in a separate
	 * thread after the first one has finished. It can be used for background
	 * work that should be applied to the document, but is not relevant for the
	 * current service request.
	 */
	public <T> T modify(CancelableUnitOfWork<T, IXtextWebDocument> work,
			CancelableUnitOfWork<?, IXtextWebDocument> asynchronousWork) {
		return doAccess(work, true, true, asynchronousWork);
	}

	/**
	 * Execute the given work unit with read and write access and return its
	 * result. The work unit is handled with higher priority, i.e. currently
	 * running work units are canceled if they support cancelation.
	 */
	public <T> T modify(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		return doAccess(work, true, true, null);
	}

	protected <T> T doAccess(CancelableUnitOfWork<T, IXtextWebDocument> synchronousWork, boolean priority,
			boolean modify, final CancelableUnitOfWork<?, IXtextWebDocument> asynchronousWork) {
		final DocumentSynchronizer synchronizer = document.getSynchronizer();
		IXtextWebDocument documentAccess = null;
		try {
			synchronizer.acquireLock(priority);
			checkStateId();
			synchronousWork.setCancelIndicator(synchronizer);
			if (modify)
				documentAccess = modifyAccess;
			else
				documentAccess = readOnlyAccess;
			return synchronousWork.exec(documentAccess);
		} catch (Exception exception) {
			Exceptions.sneakyThrow(exception);
			return null;
		} finally {
			if (skipAsyncWork || !priority || documentAccess == null || synchronizer.isCanceled()
					|| Thread.currentThread().isInterrupted()) {
				synchronizer.releaseLock();
			} else {
				requiredStateId = document.getStateId();
				if (asynchronousWork != null) 
					asynchronousWork.setCancelIndicator(synchronizer);
				final IXtextWebDocument asyncAccess = documentAccess;
				try {
					executorService1.submit(new Runnable() {
						@Override
						public void run() {
							try {
								if (asynchronousWork != null) 
									asynchronousWork.exec(asyncAccess);
								EcoreUtil2.resolveLazyCrossReferences(asyncAccess.getResource(), synchronizer);
							} catch (VirtualMachineError error) {
								throw error;
							} catch (Throwable throwable) {
								if (operationCanceledManager.isOperationCanceledException(throwable)) {
									LOG.trace("Canceling background process.");
								} else {
									LOG.error("Error during asynchronous service processing.", throwable);
								}
							} finally {
								synchronizer.releaseLock();
							}
						}
					});
				} catch (RejectedExecutionException ree) {
					synchronizer.releaseLock();
					LOG.error("Failed to start background work.", ree);
				}
				if (!synchronizer.isCanceled() && !Thread.currentThread().isInterrupted()) {
					executorService2.submit(new Runnable() {
						@Override
						public void run() {
							performPrecomputation();
						}
					});
				}
			}
		}
	}

	protected void performPrecomputation() {
		for (AbstractPrecomputedService<?> service: preComputedServiceRegistry.getPrecomputedServices()) {
			getCachedResult(service, false);
		}
	}

	protected <T extends IServiceResult> T getCachedResult(final AbstractPrecomputedService<T> service, final boolean logCacheMiss) {
		return readOnly(new CancelableUnitOfWork<T, IXtextWebDocument>() {
			public T exec(IXtextWebDocument d, CancelIndicator cancelIndicator) throws Exception {
				if (document.getResourceId() != null)
					return document.getCachedServiceResult(service, cancelIndicator, logCacheMiss);
				else
					return service.compute(document, cancelIndicator);
			};
		});
	}

	protected class ReadAccess implements IXtextWebDocument {
		@Override
		public XtextResource getResource() {
			return document.getResource();
		}

		@Override
		public String getResourceId() {
			return document.getResourceId();
		}

		@Override
		public String getText() {
			return document.getText();
		}

		@Override
		public String getStateId() {
			return document.getStateId();
		}

		@Override
		public boolean isDirty() {
			return document.isDirty();
		}

		@Override
		public void setDirty(boolean dirty) {
			document.setDirty(dirty);
		}

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

	}

	protected class ModifyAccess extends ReadAccess {
		@Override
		public void setText(String text) {
			document.setText(text);
		}

		@Override
		public void updateText(String text, int offset, int replaceLength) {
			document.updateText(text, offset, replaceLength);
		}

		@Override
		public void createNewStateId() {
			document.createNewStateId();
		}
	}

}