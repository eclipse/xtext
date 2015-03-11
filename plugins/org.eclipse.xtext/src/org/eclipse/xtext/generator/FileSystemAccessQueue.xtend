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
	
	def void sendAsync(URI uri, ()=>void procedure) {
		send(new FileSystemAccessRequest(uri, procedure))
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

}

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class FileSystemAccessRequest {
	val URI uri
	val ()=>void procedure
	
	/**
	 * @since 2.8
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
	 * @since 2.8
	 */
	@Pure
	def getProcedure() {
		return procedure
	}
}
