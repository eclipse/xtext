/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import com.google.inject.Inject
import java.util.concurrent.Semaphore
import java.util.concurrent.atomic.AtomicInteger
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.service.OperationCanceledManager
import org.eclipse.xtext.util.CancelIndicator

/**
 * Synchronizer object used by the {@link XtextWebDocumentAccess} for managing multithreaded
 * access to a document. It holds the cancelation status and locking information. The lock
 * is not bound to a thread, so it is possible for one thread to call {@link #acquireLock(boolean)}
 * and for another thread to call {@link #releaseLock()}.
 */
class DocumentSynchronizer implements CancelIndicator {
	
	val semaphore = new Semaphore(1, true)
	
    val waitingPriorityJobs = new AtomicInteger

    @Inject OperationCanceledManager operationCanceledManager
    
	@Accessors
    volatile boolean canceled
    
    def acquireLock(boolean priority) {
    	if (priority) {
			waitingPriorityJobs.incrementAndGet()
			canceled = true
		}
		semaphore.acquire()
		if (priority) {
			if (waitingPriorityJobs.decrementAndGet() == 0)
				canceled = false
		} else {
			operationCanceledManager.checkCanceled(this)
		}
    }
    
    def releaseLock() {
    	if (semaphore.availablePermits != 0)
    		throw new IllegalStateException('Cannot release a lock without acquiring it first.')
    	semaphore.release()
    }
    
}