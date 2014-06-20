package org.eclipse.xtext.builder

import java.util.concurrent.BlockingQueue
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.xbase.lib.Pair

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class FileSystemAccessQueue {

	BlockingQueue<Pair<Delta, (IFileSystemAccess, IProgressMonitor)=>void>> requestQueue

	new(BlockingQueue<Pair<Delta, (IFileSystemAccess, IProgressMonitor)=>void>> requestQueue) {
		this.requestQueue = requestQueue
	}

	def void put(Delta delta, (IFileSystemAccess, IProgressMonitor)=>void procedure) {
		var interrupted = false
		try {
			while (true) {
				try {
					requestQueue.put(delta -> procedure)
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
