package org.eclipse.xtext.builder

import java.io.InputStream
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.generator.AbstractFileSystemAccess
import org.eclipse.xtext.generator.FileSystemAccessQueue
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccessExtension
import org.eclipse.xtext.generator.IFileSystemAccessExtension2
import org.eclipse.xtext.generator.IFileSystemAccessExtension3
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.util.RuntimeIOException

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class ParallelFileSystemAccess implements IFileSystemAccess, IFileSystemAccessExtension, IFileSystemAccessExtension2, IFileSystemAccessExtension3 {

	Delta delta
	
	String sourceFolder
	
	IFileSystemAccess delegate
	
	IProgressMonitor progressMonitor

	FileSystemAccessQueue fileSystemAccessQueue

	EclipseResourceFileSystemAccess2.IFileCallback fileCallback

	new(IFileSystemAccess delegate, Delta delta, FileSystemAccessQueue fileSystemAccessQueue, String sourceFolder, EclipseResourceFileSystemAccess2.IFileCallback fileCallback, IProgressMonitor progressMonitor) {
		this.delta = delta
		this.delegate = delegate
		this.fileCallback = fileCallback
		this.sourceFolder = sourceFolder
		this.progressMonitor = progressMonitor
		this.fileSystemAccessQueue = fileSystemAccessQueue
	}
	
	protected def <T> sendAsync((T, IProgressMonitor)=>void procedure) {
		fileSystemAccessQueue.sendAsync(delta.uri) [ |
			if (delegate instanceof EclipseResourceFileSystemAccess2) {
				delegate.postProcessor = fileCallback
			}
			if (sourceFolder != null) {
				if (delegate instanceof AbstractFileSystemAccess) {	
					delegate.currentSource = sourceFolder
				}
			}
			procedure.apply(delegate as T, progressMonitor)
		]
	}

	override deleteFile(String fileName) {
		sendAsync [ IFileSystemAccess access, IProgressMonitor monitor |
			access.deleteFile(fileName)
		]
	}

	override generateFile(String fileName, CharSequence contents) {
		sendAsync [ IFileSystemAccess access, IProgressMonitor monitor |
			access.generateFile(fileName, contents)
		]
	}

	override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		sendAsync [ IFileSystemAccess access, IProgressMonitor monitor |
			access.generateFile(fileName, outputConfigurationName, contents)
		]
	}
	
	override deleteFile(String fileName, String outputConfigurationName) {
		sendAsync [ IFileSystemAccessExtension access, IProgressMonitor monitor |
			access.deleteFile(fileName, outputConfigurationName)
		]
	}
	
	override getURI(String fileName, String outputConfiguration) {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.getURI(fileName, outputConfiguration, new NullProgressMonitor)
		}
		return (delegate as IFileSystemAccessExtension2).getURI(fileName, outputConfiguration)
	}
	
	override getURI(String fileName) {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.getURI(fileName, new NullProgressMonitor)
		}
		return (delegate as IFileSystemAccessExtension2).getURI(fileName)
	}
	
	override generateFile(String fileName, String outputCfgName, InputStream content) throws RuntimeIOException {
		sendAsync [ IFileSystemAccessExtension3 access, IProgressMonitor monitor |
			access.generateFile(fileName, outputCfgName, content)
		]
	}
	
	override generateFile(String fileName, InputStream content) throws RuntimeIOException {
		sendAsync [ IFileSystemAccessExtension3 access, IProgressMonitor monitor |
			access.generateFile(fileName, content)
		]
	}
	
	override readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.readBinaryFile(fileName, outputCfgName, new NullProgressMonitor)
		}
		return (delegate as IFileSystemAccessExtension3).readBinaryFile(fileName, outputCfgName)
	}
	
	override readBinaryFile(String fileName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.readBinaryFile(fileName, new NullProgressMonitor)
		}
		return (delegate as IFileSystemAccessExtension3).readBinaryFile(fileName)
	}
	
	override readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.readTextFile(fileName, outputCfgName, new NullProgressMonitor)
		}
		return (delegate as IFileSystemAccessExtension3).readTextFile(fileName, outputCfgName)
	}
	
	override readTextFile(String fileName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.readTextFile(fileName, new NullProgressMonitor)
		}
		return (delegate as IFileSystemAccessExtension3).readTextFile(fileName)
	}

}
