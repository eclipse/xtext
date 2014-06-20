package org.eclipse.xtext.builder

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2.IFileCallback
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.generator.AbstractFileSystemAccess

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class ParallelFileSystemAccess implements IFileSystemAccess {

	Delta delta
	
	String sourceFolder

	IFileCallback fileCallback

	FileSystemAccessQueue fileSystemAccessQueue

	new(Delta delta, FileSystemAccessQueue fileSystemAccessQueue, String sourceFolder, IFileCallback fileCallback) {
		this.delta = delta;
		this.fileCallback = fileCallback
		this.sourceFolder = sourceFolder
		this.fileSystemAccessQueue = fileSystemAccessQueue
	}

	override deleteFile(String fileName) {
		fileSystemAccessQueue.put(delta) [ IFileSystemAccess access, IProgressMonitor monitor |
			switch access {
				EclipseResourceFileSystemAccess2: {
					access.currentSource = sourceFolder
				}
			}
			if (sourceFolder != null) {
				switch access {
					AbstractFileSystemAccess: {
						access.currentSource = sourceFolder
					}
				}
			}
			access.deleteFile(fileName)
		]
	}

	override generateFile(String fileName, CharSequence contents) {
		fileSystemAccessQueue.put(delta) [ IFileSystemAccess access, IProgressMonitor monitor |
			switch access {
				EclipseResourceFileSystemAccess2: {
					access.postProcessor = fileCallback
				}
			}
			if (sourceFolder != null) {
				switch access {
					AbstractFileSystemAccess: {
						access.currentSource = sourceFolder
					}
				}
			}
			access.generateFile(fileName, contents)
		]
	}

	override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		fileSystemAccessQueue.put(delta) [ IFileSystemAccess access, IProgressMonitor monitor |
			switch access {
				EclipseResourceFileSystemAccess2: {
					access.postProcessor = fileCallback
				}
			}
			if (sourceFolder != null) {
				switch access {
					AbstractFileSystemAccess: {
						access.currentSource = sourceFolder
					}
				}
			}
			access.generateFile(fileName, outputConfigurationName, contents)
		]
	}

}
