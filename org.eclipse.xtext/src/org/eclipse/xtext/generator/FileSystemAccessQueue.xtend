package org.eclipse.xtext.generator

import java.util.concurrent.BlockingQueue
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class FileSystemAccessQueue extends AdapterImpl {

	val BlockingQueue<FileSystemAccessRequest> requestQueue
	val IProgressMonitor monitor
	
	/**
	 * @since 2.8
	 */
	@FinalFieldsConstructor
	new() {}
	
	/**
	 * @since 2.9
	 */
	def void sendAsync(URI uri, Runnable runMe) {
		send(new FileSystemAccessRequest(uri, runMe))
	}
	
	protected def send(FileSystemAccessRequest request) {
		try {
			if (monitor.isCanceled) {
				throw new OperationCanceledException
			}
			requestQueue.put(request)
			return request
		} catch (InterruptedException e) {
			throw new OperationCanceledException
		}
	}
	
	/**
	 * @since 2.14
	 * @beta
	 */
	def void waitForEmptyQueue() {
		while (!requestQueue.isEmpty) {
			Thread.yield
		}
	}

}

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class FileSystemAccessRequest implements Runnable {
	val URI uri
	val Runnable runMe
	
	/**
	 * @since 2.9
	 */
	@FinalFieldsConstructor
	new() {}
	
	/**
	 * @since 2.8
	 */
	@Pure
	def getUri() {
		return uri
	}
	
	/**
	 * @since 2.9
	 */
	override run() {
		runMe.run
	}
	
}
