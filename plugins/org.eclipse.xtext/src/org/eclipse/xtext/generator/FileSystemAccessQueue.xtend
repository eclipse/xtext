package org.eclipse.xtext.generator

import java.util.concurrent.BlockingQueue
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.xtext.resource.IResourceDescription.Delta

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class FileSystemAccessQueue extends AdapterImpl {

	BlockingQueue<FileSystemAccessRequest> requestQueue

	new(BlockingQueue<FileSystemAccessRequest> requestQueue) {
		this.requestQueue = requestQueue
	}

	def void sendAsync(()=>void procedure) {
		sendAsync(null, procedure)
	}

	def void sendAsync(Delta delta, ()=>void procedure) {
		send(new FileSystemAccessRequest => [ request |
			request.delta = delta
			request.procedure = procedure
		])
	}

	def <T> T send(()=>T function) {
		val request = send(new FileSystemAccessRequest => [ request |
			request.function = function	
		])
		while (!request.completed) {
			Thread.sleep(50)
		}
		if (request.throwable != null) {
			throw request.throwable
		}
		request.result as T
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
	public Delta delta
	public ()=>void procedure
	
	public ()=>Object function
	public volatile boolean completed
	public volatile Throwable throwable
	public volatile Object result 
}
