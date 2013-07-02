package org.eclipse.xtend.ide.macro.fsaccess

import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.IPath
import org.eclipse.xtend.lib.macro.services.ResourceHandle

abstract class EclipseResouceHandle implements ResourceHandle {

	protected final IPath path

	protected final IProject project

	new(IProject project, IPath path) {
		this.project = project
		this.path = path;
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

}
