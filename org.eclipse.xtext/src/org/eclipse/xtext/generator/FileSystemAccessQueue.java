/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.concurrent.BlockingQueue;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;

import com.google.common.annotations.Beta;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
public class FileSystemAccessQueue extends AdapterImpl {
	private final BlockingQueue<FileSystemAccessRequest> requestQueue;

	private final IProgressMonitor monitor;

	/**
	 * @since 2.8
	 */
	public FileSystemAccessQueue(BlockingQueue<FileSystemAccessRequest> requestQueue, IProgressMonitor monitor) {
		this.requestQueue = requestQueue;
		this.monitor = monitor;
	}

	/**
	 * @since 2.9
	 */
	public void sendAsync(URI uri, Runnable runMe) {
		send(new FileSystemAccessRequest(uri, runMe));
	}

	protected FileSystemAccessRequest send(FileSystemAccessRequest request) {
		if (monitor.isCanceled())
			throw new OperationCanceledException();
		try {
			requestQueue.put(request);
			return request;
		} catch (InterruptedException t) {
			throw new OperationCanceledException();
		}
	}

	/**
	 * @since 2.14
	 */
	@Beta
	public void waitForEmptyQueue() {
		while (!this.requestQueue.isEmpty()) {
			Thread.yield();
		}
	}
}
