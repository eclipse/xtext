package org.eclipse.xtext.builder

import java.util.concurrent.BlockingQueue
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.resource.IResourceDescription.Delta

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class FileSystemAccessQueue {

	BlockingQueue<FileSystemAccessRequest> requestQueue

	new(BlockingQueue<FileSystemAccessRequest> requestQueue) {
		this.requestQueue = requestQueue
	}

	def void put(Delta delta, (IFileSystemAccess, IProgressMonitor)=>void procedure) {
		var interrupted = false
		try {
			while (true) {
				try {
					requestQueue.put(new FileSystemAccessRequest => [ request |
						request.delta = delta
						request.procedure = procedure
					])
					return
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
	public (IFileSystemAccess, IProgressMonitor)=>void procedure
}