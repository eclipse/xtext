package org.eclipse.xtext.builder

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2.IFileCallback
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.generator.AbstractFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccessExtension
import org.eclipse.xtext.generator.IFileSystemAccessExtension2
import org.eclipse.xtext.generator.IFileSystemAccessExtension3
import java.io.InputStream
import org.eclipse.xtext.util.RuntimeIOException

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class ParallelFileSystemAccess implements IFileSystemAccess, IFileSystemAccessExtension, IFileSystemAccessExtension2, IFileSystemAccessExtension3 {

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
	
	protected def <T> put((T, IProgressMonitor)=>void procedure) {
		fileSystemAccessQueue.put(delta) [ IFileSystemAccess access, IProgressMonitor monitor |
			if (access instanceof EclipseResourceFileSystemAccess2) {
				access.postProcessor = fileCallback
			}
			if (sourceFolder != null) {
				if (access instanceof AbstractFileSystemAccess) {	
					access.currentSource = sourceFolder
				}
			}
			procedure.apply(access as T, monitor)
		]
	}

	override deleteFile(String fileName) {
		put [ IFileSystemAccess access, IProgressMonitor monitor |
			access.deleteFile(fileName)
		]
	}

	override generateFile(String fileName, CharSequence contents) {
		put [ IFileSystemAccess access, IProgressMonitor monitor |
			access.generateFile(fileName, contents)
		]
	}

	override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		put [ IFileSystemAccess access, IProgressMonitor monitor |
			access.generateFile(fileName, outputConfigurationName, contents)
		]
	}
	
	override deleteFile(String fileName, String outputConfigurationName) {
		put [ IFileSystemAccessExtension access, IProgressMonitor monitor |
			access.deleteFile(fileName, outputConfigurationName)
		]
	}
	
	override getURI(String fileName, String outputConfiguration) {
		// TODO: auto-generated method stub
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getURI(String fileName) {
		// TODO: auto-generated method stub
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override generateFile(String fileName, String outputCfgName, InputStream content) throws RuntimeIOException {
		put [ IFileSystemAccessExtension3 access, IProgressMonitor monitor |
			access.generateFile(fileName, outputCfgName, content)
		]
	}
	
	override generateFile(String fileName, InputStream content) throws RuntimeIOException {
		put [ IFileSystemAccessExtension3 access, IProgressMonitor monitor |
			access.generateFile(fileName, content)
		]
	}
	
	override readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		// TODO: auto-generated method stub
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override readBinaryFile(String fileName) throws RuntimeIOException {
		// TODO: auto-generated method stub
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		// TODO: auto-generated method stub
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override readTextFile(String fileName) throws RuntimeIOException {
		// TODO: auto-generated method stub
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
