package org.eclipse.xtend.ide.macro.fsaccess

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.jdt.core.IClasspathEntry
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.macro.fsaccess.AbstractFileSystemAccessImpl
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.parser.IEncodingProvider
import org.eclipse.xtext.ui.resource.IStorage2UriMapper

class EclipseFileSystemAccessImpl extends AbstractFileSystemAccessImpl {

	@Inject
	private IStorage2UriMapper mapper

	@Inject
	private IEncodingProvider encodingProvider

	@Inject
	private IJavaProjectProvider javaProjectProvider

	@Inject
	private EclipseOutputConfigurationProvider outputConfigurationProvider

	override doGetSourceFolder(CompilationUnitImpl it) {
		val file = file
		if (file == null) {
			return null
		}
		val sourcePath = sourcePath
		if (sourcePath == null) {
			return null
		}
		new EclipseFolderHandle(file.project, sourcePath, encodingProvider)
	}

	override doGetRootFolder(CompilationUnitImpl it) {
		val file = file
		if (file == null) {
			return null
		}
		new EclipseFolderHandle(file.project, file.project.projectRelativePath, encodingProvider)
	}

	override doGetTargetFolder(CompilationUnitImpl it) {
		val file = file
		if (file == null) {
			return null
		}
		val directory = file.outputConfig.outputDirectory;
		val path = sourcePath.append("../" + directory);
		new EclipseFolderHandle(file.project, path, encodingProvider)
	}

	def getSourcePath(CompilationUnitImpl it) {
		val filePath = file?.fullPath
		if (filePath == null) {
			return null
		}
		javaProject.getResolvedClasspath(true).filter [
			entryKind == IClasspathEntry.CPE_SOURCE && path.isPrefixOf(filePath)
		].head?.path?.removeFirstSegments(1)
	}

	def getOutputConfig(IFile it) {
		outputConfigurationProvider.getOutputConfigurations(project).head
	}

	def getFile(CompilationUnitImpl it) {
		storages.map[first].filter(IFile).head
	}

	def getStorages(CompilationUnitImpl it) {
		mapper.getStorages(getXtendFile.eResource.getURI)
	}

	def getJavaProject(CompilationUnitImpl it) {
		javaProjectProvider.getJavaProject(xtendFile.eResource.resourceSet)
	}

}
