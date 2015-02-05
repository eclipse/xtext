package org.eclipse.xtext.idea.generator

import java.io.File
import java.io.IOException
import java.io.InputStream
import java.util.Arrays
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.idea.build.incremental.IdeaBuildData
import org.eclipse.xtext.util.RuntimeIOException
import org.jetbrains.jps.incremental.FSOperations
import org.jetbrains.jps.model.java.JavaSourceRootType

class FileSystemAccessDelegate extends JavaIoFileSystemAccess {

	@Delegate
	JavaIoFileSystemAccess delegate

	IdeaBuildData buildData

	new(JavaIoFileSystemAccess delegate, IdeaBuildData buildData) {
		this.delegate = delegate
		this.buildData = buildData
		outputPath = buildData.baseDir + '/src-gen'
	}
	
	override void generateFile(String fileName, String outputConfigName,
		CharSequence contents) throws RuntimeIOException {
		delegate.generateFile(fileName, outputConfigName, contents)
		markDirty(fileName, outputConfigName)
	}
	
	override generateFile(String fileName, CharSequence contents) {
		super.generateFile(fileName, contents)
		markDirty(fileName, DEFAULT_OUTPUT)
	}

	override generateFile(String fileName, InputStream content) {
		super.generateFile(fileName, content)
		markDirty(fileName, DEFAULT_OUTPUT)
	}
	
	override generateFile(String fileName, String outputConfigName, InputStream content) throws RuntimeIOException {
		super.generateFile(fileName, outputConfigName, content)
		markDirty(fileName, outputConfigName)
	}

	override protected generateTrace(String generatedFile, String outputConfigName, CharSequence contents) {
		super.generateTrace(generatedFile, outputConfigName, contents)
		
	}
	
	@Override override void deleteFile(String fileName, String outputConfiguration) {
		delegate.deleteFile(fileName, outputConfiguration)
		markDeleted(fileName, outputConfiguration)
	}

	override deleteFile(String fileName) {
		super.deleteFile(fileName)
		markDeleted(fileName, DEFAULT_OUTPUT)
	}
	
	def protected void registerOutputFile(File file, String outputConfigName) {
		var String outlet = getPathes().get(outputConfigName)
		try {
			buildData.outputConsumer.registerOutputFile(
				buildData.chunk.representativeTarget, file, Arrays.asList(outlet)
			)
		} catch (IOException e) {
			throw new RuntimeException(e)
		}
	}

	/** 
	 * mark dirty to re-compile
	 * @param file
	 */
	def protected void markDirty(String fileName, String outputConfigName) {
		try {
			createSourceRoot(fileName, outputConfigName)
			var File file = getFile(fileName, outputConfigName)
			refresh(file.getPath())
			FSOperations.markDirty(buildData.context, file)
		} catch (IOException e) {
			throw new RuntimeException(e)
		}

	}
	
	protected def createSourceRoot(String fileName, String outputConfigName) {
		val outletUrl = getURI(fileName, outputConfigName).toString
		if(!buildData.module.getSourceRoots(JavaSourceRootType.SOURCE).exists[url == outletUrl])
			buildData.module.addSourceRoot(outletUrl, JavaSourceRootType.SOURCE)
	}

	/** 
	 * mark deleted
	 * @param file
	 */
	def protected void markDeleted(String fileName, String outputConfiguration) {
		try {
			var File file = getFile(fileName, outputConfiguration)
			refresh(file.getPath())
			FSOperations.markDeleted(buildData.context, file)
		} catch (IOException e) {
			throw new RuntimeException(e)
		}

	}

	/** 
	 * refresh virtual file in IDEA
	 * @param file
	 */
	def protected void refresh(String path) {
		buildData.refreshComponent.refresh(path)
	}
}