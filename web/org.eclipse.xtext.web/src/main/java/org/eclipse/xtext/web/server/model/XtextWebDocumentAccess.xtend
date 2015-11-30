/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.name.Named
import java.util.concurrent.ExecutorService
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.web.server.IServiceResult
import org.eclipse.xtext.web.server.InvalidRequestException.InvalidDocumentStateException
import java.util.concurrent.RejectedExecutionException

/** 
 * Accessor class for documents. Use {@link #readOnly(CancelableUnitOfWork)} to
 * read the content and properties of the document, and
 * {@link #modify(CancelableUnitOfWork, CancelableUnitOfWork)} to modify them.
 * If this accessor has been created with a required state identifier, it will
 * check the actual state identifier of the document before granting access, and
 * throw an exception if it does not match.
 */
@Log class XtextWebDocumentAccess {

	@Inject PrecomputedServiceRegistry preComputedServiceRegistry
	/** 
	 * Executor service for runnables that are run when the lock is already acquired 
	 */
	@Inject @Named('withDocumentLock') ExecutorService executorService1
	/** 
	 * A second executor service for runnables that aquire the document lock themselves 
	 */
	@Inject ExecutorService executorService2
	@Inject OperationCanceledManager operationCanceledManager

	XtextWebDocument document

	String requiredStateId
	boolean skipAsyncWork

	static class Factory {

		@Inject Provider<XtextWebDocumentAccess> provider

		def XtextWebDocumentAccess create(XtextWebDocument document, String requiredStateId, boolean skipAsyncWork) {
			val docAccess = provider.get
			docAccess.init(document, requiredStateId, skipAsyncWork)
			docAccess.checkStateId()
			return docAccess
		}

		def XtextWebDocumentAccess create(XtextWebDocument document, boolean skipAsyncWork) {
			var docAccess = provider.get
			docAccess.init(document, null, skipAsyncWork)
			return docAccess
		}

	}

	protected def void init(XtextWebDocument document, String requiredStateId, boolean skipAsyncWork) {
		this.document = document
		this.requiredStateId = requiredStateId
		this.skipAsyncWork = skipAsyncWork
	}

	protected def void checkStateId() throws InvalidDocumentStateException {
		if (requiredStateId !== null && requiredStateId != document.stateId) {
			throw new InvalidDocumentStateException('The given state id does not match the current state.')
		}
	}

	/** 
	 * Execute the given work unit with read-only access and return its result.
	 */
	def <T> T readOnly(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		return doAccess(work, false, false, null)
	}

	/** 
	 * Execute the given work unit with read-only access and return its result.
	 * The work unit is handled with higher priority, i.e. currently running
	 * work units are canceled if they support cancellation. 
	 */
	def <T> T priorityReadOnly(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		return doAccess(work, true, false, null)
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
	def <T> T modify(CancelableUnitOfWork<T, IXtextWebDocument> work,
			CancelableUnitOfWork<?, IXtextWebDocument> asynchronousWork) {
		return doAccess(work, true, true, asynchronousWork)
	}

	/** 
	 * Execute the given work unit with read and write access and return its
	 * result. The work unit is handled with higher priority, i.e. currently
	 * running work units are canceled if they support cancellation.
	 */
	def <T> T modify(CancelableUnitOfWork<T, IXtextWebDocument> work) {
		return doAccess(work, true, true, null)
	}

	protected def <T> T doAccess(CancelableUnitOfWork<T, IXtextWebDocument> synchronousWork, boolean priority,
			boolean modify, CancelableUnitOfWork<?, IXtextWebDocument> asynchronousWork) {
		val synchronizer = document.synchronizer
		val documentAccess = if (modify) document else new ReadAccess(document)
		var currentThreadOwnsLock = true
		var T result
		try {
			// Acquire the lock and execute the main unit of work
			synchronizer.acquireLock(priority)
			checkStateId()
			synchronousWork.cancelIndicator = synchronizer
			result = synchronousWork.exec(documentAccess)
			requiredStateId = document.stateId
			
			if (!skipAsyncWork && priority && documentAccess !== null && !synchronizer.canceled
					&& !Thread.currentThread.interrupted) {
				
				// Start a thread for background work and pass the lock to this new thread
				executorService1.submit([
					try {
						if (asynchronousWork !== null) {
							asynchronousWork.cancelIndicator = synchronizer
							asynchronousWork.exec(documentAccess)
						}
						EcoreUtil2.resolveLazyCrossReferences(documentAccess.resource, synchronizer)
					} catch (VirtualMachineError error) {
						throw error
					} catch (Throwable throwable) {
						if (operationCanceledManager.isOperationCanceledException(throwable)) {
							LOG.trace('Canceling background work.')
						} else {
							LOG.error('Error during background work.', throwable)
						}
					} finally {
						synchronizer.releaseLock()
					}
				] as Runnable)
				currentThreadOwnsLock = false
				
				// Start another thread for precomputation
				executorService2.submit([
					try {
						performPrecomputation(synchronizer)
					} catch (VirtualMachineError error) {
						throw error
					} catch (InvalidDocumentStateException idse) {
						// The document has changed since we executed our synchronous work - stop precomputation
						return
					} catch (Throwable throwable) {
						if (operationCanceledManager.isOperationCanceledException(throwable)) {
							LOG.trace('Canceling precomputation.')
						} else {
							LOG.error('Error during precomputation.', throwable)
						}
					}
				] as Runnable)
				
			}
		} catch (RejectedExecutionException ree) {
			LOG.error('Failed to start background work.', ree)
		} finally {
			if (currentThreadOwnsLock)
				synchronizer.releaseLock()
		}
		return result
	}

	protected def void performPrecomputation(CancelIndicator cancelIndicator) {
		for (service : preComputedServiceRegistry.getPrecomputedServices()) {
			operationCanceledManager.checkCanceled(cancelIndicator)
			getCachedServiceResult(service, false)
		}
	}

	protected def <T extends IServiceResult> T getCachedServiceResult(AbstractCachedService<T> service, boolean logCacheMiss) {
		return readOnly [d, cancelIndicator |
			if (document.resourceId !== null) 
				return document.getCachedServiceResult(service, cancelIndicator, logCacheMiss) 
			else 
				return service.compute(document, cancelIndicator)
		]
	}

	@FinalFieldsConstructor protected static class ReadAccess implements IXtextWebDocument {

		@Delegate val XtextWebDocument document

		override void setText(String text) {
			throw new UnsupportedOperationException('Cannot modify the document with read-only access.')
		}

		override void updateText(String text, int offset, int replaceLength) {
			throw new UnsupportedOperationException('Cannot modify the document with read-only access.')
		}

		override void createNewStateId() {
			throw new UnsupportedOperationException('Cannot modify the document with read-only access.')
		}
	}

}