package org.eclipse.xtext.generator

import java.util.concurrent.BlockingQueue
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@FinalFieldsConstructor
class FileSystemAccessQueue extends AdapterImpl {

	val BlockingQueue<FileSystemAccessRequest> requestQueue
	val IProgressMonitor monitor
	
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
@FinalFieldsConstructor
@Accessors
class FileSystemAccessRequest {
	val URI uri
	val ()=>void procedure
}
