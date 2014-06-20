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
import org.eclipse.core.runtime.NullProgressMonitor

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class ParallelFileSystemAccess implements IFileSystemAccess, IFileSystemAccessExtension, IFileSystemAccessExtension2, IFileSystemAccessExtension3 {

	Delta delta
	
	String sourceFolder

	IFileCallback fileCallback
	
	IFileSystemAccess delegate

	FileSystemAccessQueue fileSystemAccessQueue

	new(IFileSystemAccess delegate, Delta delta, FileSystemAccessQueue fileSystemAccessQueue, String sourceFolder, IFileCallback fileCallback) {
		this.delta = delta
		this.delegate = delegate
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
