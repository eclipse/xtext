/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.model;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.service.OperationCanceledManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Exceptions;

import com.google.inject.Inject;

/**
 * Synchronizer object used by the {@link XtextWebDocumentAccess} for managing
 * multithreaded access to a document. It holds the cancelation status and
 * locking information. The lock is not bound to a thread, so it is possible for
 * one thread to call {@link #acquireLock(boolean)} and for another thread to
 * call {@link #releaseLock()}.
 */
public class DocumentSynchronizer implements CancelIndicator {
	private final Semaphore semaphore = new Semaphore(1, true);

	private final AtomicInteger waitingPriorityJobs = new AtomicInteger();

	@Inject
	private OperationCanceledManager operationCanceledManager;

	@Accessors
	private volatile boolean canceled;

	public Boolean acquireLock(boolean priority) {
		try {
			if (priority) {
				waitingPriorityJobs.incrementAndGet();
				canceled = true;
			}
			semaphore.acquire();
			if (priority) {
				if (waitingPriorityJobs.decrementAndGet() == 0) {
					return this.canceled = false;
				}
				return false;
			} else {
				this.operationCanceledManager.checkCanceled(this);
			}
			return false;
		} catch (InterruptedException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	public void releaseLock() {
		if (semaphore.availablePermits() != 0) {
			throw new IllegalStateException("Cannot release a lock without acquiring it first.");
		}
		semaphore.release();
	}

	public boolean isCanceled() {
		return canceled;
	}

	public void setCanceled(boolean canceled) {
		this.canceled = canceled;
	}
}
