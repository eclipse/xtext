package org.eclipse.xtext.generator

import java.util.concurrent.BlockingQueue
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.util.URI

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class FileSystemAccessQueue extends AdapterImpl {

	BlockingQueue<FileSystemAccessRequest> requestQueue

	new(BlockingQueue<FileSystemAccessRequest> requestQueue) {
		this.requestQueue = requestQueue
	}

	def void sendAsync(URI uri, ()=>void procedure) {
		send(new FileSystemAccessRequest => [ request |
			request.uri = uri
			request.procedure = procedure
		])
	}
	
	protected def send(FileSystemAccessRequest request) {
		var interrupted = false
		try {
			while (true) {
				try {
					requestQueue.put(request)
					return request
				} catch (InterruptedException e) {
					interrupted = true
				}
			}
		} finally {
			if (interrupted) {
				Thread.currentThread.interrupt
			}
		}
	}

}

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class FileSystemAccessRequest {
	public URI uri
	public ()=>void procedure
}
