package org.eclipse.xtext.builder

import java.io.InputStream
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.generator.AbstractFileSystemAccess
import org.eclipse.xtext.generator.FileSystemAccessQueue
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.util.RuntimeIOException
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
class ParallelFileSystemAccess implements IFileSystemAccess2 {

	val IFileSystemAccess2 delegate
	
	val Delta delta
	
	val FileSystemAccessQueue fileSystemAccessQueue
	
	val String sourceFolder
	
	val EclipseResourceFileSystemAccess2.IFileCallback fileCallback
	
	/**
	 * @since 2.9
	 */
	@FinalFieldsConstructor
	new() {}

	protected def sendAsync((IFileSystemAccess2)=>void procedure) {
		fileSystemAccessQueue.sendAsync(delta.uri) [ |
			if (delegate instanceof EclipseResourceFileSystemAccess2) {
				delegate.postProcessor = fileCallback
			}
			if (sourceFolder != null) {
				if (delegate instanceof AbstractFileSystemAccess) {	
					delegate.currentSource = sourceFolder
				}
			}
			procedure.apply(delegate)
		]
	}

	override deleteFile(String fileName) {
		sendAsync [ 
			deleteFile(fileName)
		]
	}

	override generateFile(String fileName, CharSequence contents) {
		sendAsync [ 
			generateFile(fileName, contents)
		]
	}

	override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		sendAsync [ 
			generateFile(fileName, outputConfigurationName, contents)
		]
	}
	
	override deleteFile(String fileName, String outputConfigurationName) {
		sendAsync [ 
			deleteFile(fileName, outputConfigurationName)
		]
	}
	
	override getURI(String path, String outputConfiguration) {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.getURI(path, outputConfiguration, new NullProgressMonitor)
		}
		return delegate.getURI(path, outputConfiguration)
	}
	
	override getURI(String path) {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.getURI(path, new NullProgressMonitor)
		}
		return delegate.getURI(path)
	}
	
	override generateFile(String fileName, String outputCfgName, InputStream content) throws RuntimeIOException {
		sendAsync [ 
			generateFile(fileName, outputCfgName, content)
		]
	}
	
	override generateFile(String fileName, InputStream content) throws RuntimeIOException {
		sendAsync [ 
			generateFile(fileName, content)
		]
	}
	
	override readBinaryFile(String fileName, String outputCfgName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.readBinaryFile(fileName, outputCfgName, new NullProgressMonitor)
		}
		return delegate.readBinaryFile(fileName, outputCfgName)
	}
	
	override readBinaryFile(String fileName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.readBinaryFile(fileName, new NullProgressMonitor)
		}
		return delegate.readBinaryFile(fileName)
	}
	
	override readTextFile(String fileName, String outputCfgName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.readTextFile(fileName, outputCfgName, new NullProgressMonitor)
		}
		return delegate.readTextFile(fileName, outputCfgName)
	}
	
	override readTextFile(String fileName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.readTextFile(fileName, new NullProgressMonitor)
		}
		return delegate.readTextFile(fileName)
	}

	/**
	 * @since 2.9
	 */
	override isFile(String path, String outputConfigurationName) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.isFile(path, outputConfigurationName, new NullProgressMonitor)
		}
		return delegate.isFile(path, outputConfigurationName)
	}
	
	/**
	 * @since 2.9
	 */
	override isFile(String path) throws RuntimeIOException {
		if (delegate instanceof EclipseResourceFileSystemAccess2) {
			return delegate.isFile(path, new NullProgressMonitor)
		}
		return delegate.isFile(path)
	}

}
