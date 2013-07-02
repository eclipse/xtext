package org.eclipse.xtend.ide.macro.fsaccess

import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.macro.services.ResourceHandle
import org.eclipse.xtext.parser.IEncodingProvider

abstract class EclipseResourceHandle implements ResourceHandle {

	protected final IPath path

	protected final IProject project

	protected final IEncodingProvider encodingProvider

	new(IProject project, IPath path, IEncodingProvider encodingProvider) {
		this.project = project
		this.path = path;
		this.encodingProvider = encodingProvider
	}

	override exists() {
		project.exists(path)
	}

	override getName() {
		location.lastSegment
	}

	override getPath() {
		location.toString
	}

	def getFile() {
		project.getFile(path)
	}

	def getFolder() {
		project.getFolder(path)
	}

	def getLocation() {
		var resource = project.findMember(path)
		if (resource == null) {
			resource = member
		}
		resource.location.makeAbsolute
	}

	def abstract IResource getMember();

	def getEncoding() {
		encodingProvider.getEncoding(URI.createFileURI(getPath))
	}

}
