package org.eclipse.xtend.ide.macro.fsaccess

import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IPath
import org.eclipse.xtend.lib.macro.services.FolderHandle
import org.eclipse.xtext.parser.IEncodingProvider

class EclipseFolderHandle extends EclipseResourceHandle implements FolderHandle {

	new(IProject project, IPath path, IEncodingProvider encodingProvider) {
		super(project, path, encodingProvider)
	}

	override getFile(String path) {
		val filePath = this.path.append(path)
		val folder = project.getFolder(filePath)
		if (folder.exists) {
			throw new IllegalStateException(
				'''Given path is an existed folder (not a file): '«folder.location.makeAbsolute»'.''')
		}
		new EclipseFileHandle(project, filePath, encodingProvider)
	}

	override getFolder(String path) {
		val filePath = this.path.append(path)
		val file = project.getFile(filePath)
		if (file.exists) {
			throw new IllegalStateException(
				'''Given path is an existed file (not a folder): '«file.location.makeAbsolute»'.''')
		}
		new EclipseFolderHandle(project, filePath, encodingProvider)
	}

	override getMember() {
		folder
	}

}
