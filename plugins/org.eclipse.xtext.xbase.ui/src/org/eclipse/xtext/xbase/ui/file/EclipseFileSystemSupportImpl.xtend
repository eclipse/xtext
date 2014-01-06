/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.file

import com.google.common.base.Preconditions
import com.google.inject.Inject
import java.io.InputStream
import java.net.URI
import java.util.List
import org.eclipse.core.filesystem.URIUtil
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport

/**
 * A FileSystemSupport implementation which maps to the Eclipse Resources API.
 * 
 * @author Sven Efftinge
 */
class EclipseFileSystemSupportImpl extends AbstractFileSystemSupport {
	
	@Property @Inject IWorkspaceRoot workspaceRoot
	
	protected def getEclipseFile(Path path) {
		workspaceRoot.getFile(new org.eclipse.core.runtime.Path(path.toString))
	}
	
	protected def getEclipseFolder(Path path) {
		workspaceRoot.getFolder(new org.eclipse.core.runtime.Path(path.toString))
	}
	
	protected def IContainer getEclipseContainer(Path path) {
		Preconditions.checkState(path.absolute, '''The given path has to be absolute: '«path»'.''')
		switch segments : path.segments {
			case segments.size == 0: {
				workspaceRoot
			}
			case segments.size == 1: {
				workspaceRoot.getProject(path.segments.head)	
			}
			default: {
				workspaceRoot.getFolder(new org.eclipse.core.runtime.Path(path.toString))
			}
		}
	}
	
	protected def findResource(Path path) {
		workspaceRoot.findMember(new org.eclipse.core.runtime.Path(path.toString))
	}
	
	protected def toEclipsePath(Path path) {
		new org.eclipse.core.runtime.Path(path.toString)
	}

	override Iterable<? extends Path> getChildren(Path path) {
		val container = path.eclipseContainer
		if (!container.exists) {
			return emptyList
		}
		try {
			container.members.map[new Path(fullPath.toString)]
		} catch (CoreException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}

	override boolean exists(Path path) {
		path.findResource != null
	}

	override boolean isFolder(Path path) {
		path.findResource instanceof IContainer
	}

	override boolean isFile(Path path) {
		path.findResource instanceof IFile
	}

	override long getLastModification(Path path) {
		val resource = path.findResource
		if (resource == null) {
			return 0L
		}
		resource.modificationStamp
	}

	override String getCharset(Path path) {
		try {
			if (path.isFile) {
				return path.eclipseFile.charset
			} else if (path.isFolder) {
				return path.eclipseContainer.defaultCharset
			} else {
				return path.parent.getCharset
			}
		} catch (CoreException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}

	override InputStream getContentsAsStream(Path path) {
		try {
			path.eclipseFile.contents
		} catch (CoreException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}
	
	override delete(Path path) {
		try {
			if (path.exists) {
				path.findResource.delete(true, null)
				return true
			}
			return false
		} catch (CoreException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}
	
	override mkdir(Path path) {
		if (path.exists)
			return false;
		if (!path.parent.exists) {
			path.parent.mkdir
		}
		try {
			switch container : path.eclipseContainer {
				IFolder: {
						container.create(true, true, null)
					true
				}
				IProject: {
					container.create(null)
					true
				}
				default: 
					false
			}
		} catch (CoreException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}
	
	override setContentsAsStream(Path path, InputStream stream) {
		try {
			if (path.exists) {
				path.eclipseFile.setContents(stream, true, true, null)
			} else {
				path.parent.mkdir
				path.eclipseFile.create(stream, true, null)
			}
		} catch (CoreException exc) {
			throw new IllegalArgumentException(exc.message, exc)
		}
	}
	
	override toURI(Path path) {
		toURI(path, newArrayList)
	}
	
	protected def URI toURI(Path path, List<String> trailingSegments) {
		val resource = path.findResource
		if (resource == null) {
			trailingSegments += path.lastSegment
			return toURI(path.parent, trailingSegments)
		}
		URIUtil.toURI(trailingSegments.reverse.fold(resource.location)[location, segment|location.append(segment)])
	}
	
	override getPath(Resource res) {
		if (!res.URI.platform) {
			throw new IllegalStateException("Expecting platform URI but was : " + res.URI)
		}
		return new Path(res.URI.toPlatformString(false))
	}
	
}