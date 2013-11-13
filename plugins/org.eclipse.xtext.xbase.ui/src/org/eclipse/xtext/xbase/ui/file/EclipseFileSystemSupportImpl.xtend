/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.file

import com.google.inject.Inject
import java.io.InputStream
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport

import static org.eclipse.core.resources.IResource.*

/**
 * A FileSystemSupport implementation which maps to the Eclipse Resources API.
 * 
 * @author Sven Efftinge
 */
class EclipseFileSystemSupportImpl extends AbstractFileSystemSupport {
	
	@Property @Inject IWorkspaceRoot workspaceRoot
	
	@Property @Inject
	extension EclipseOutputConfigurationProvider eclipseOutputConfigurationProvider
	
	protected def getEclipseFile(Path path) {
		workspaceRoot.getFile(new org.eclipse.core.runtime.Path(path.toString))
	}
	
	protected def getEclipseFolder(Path path) {
		workspaceRoot.getFolder(new org.eclipse.core.runtime.Path(path.toString))
	}
	
	protected def findResource(Path path) {
		workspaceRoot.findMember(new org.eclipse.core.runtime.Path(path.toString))
	}
	
	protected def toEclipsePath(Path path) {
		new org.eclipse.core.runtime.Path(path.toString)
	}
	
	protected def getUpdateFlags(IResource it) {
		if (!keepLocalHistory) {
			return FORCE
		}
		return KEEP_HISTORY.bitwiseOr(FORCE)
	}
	
	protected def isKeepLocalHistory(IResource it) {
		project.outputConfigurations.head.keepLocalHistory
	}

	override Iterable<? extends Path> getChildren(Path path) {
		path.eclipseFolder.members.map[new Path(fullPath.toString)]
	}

	override boolean exists(Path path) {
		path.findResource != null
	}

	override boolean isFolder(Path path) {
		path.findResource instanceof IFolder
	}

	override boolean isFile(Path path) {
		path.findResource instanceof IFile
	}

	override long getLastModification(Path path) {
		path.findResource.modificationStamp
	}

	override String getCharset(Path path) {
		if (path.isFile) {
			return path.eclipseFile.charset
		} else if (path.isFolder) {
			return path.eclipseFolder.defaultCharset
		} else {
			return path.parent.getCharset
		}
	}

	override InputStream getContentsAsStream(Path path) {
		path.eclipseFile.contents
	}
	
	override delete(Path path) {
		if (path.exists) {
			path.findResource => [delete(updateFlags, null)]
			return true
		}
		return false
	}
	
	override mkdir(Path path) {
		if (path.exists)
			return false;
		if (!path.parent.exists) {
			path.parent.mkdir
		}
		path.eclipseFolder => [create(updateFlags, true, null)]
		return true;
	}
	
	override setContentsAsStream(Path path, InputStream stream) {
		if (path.exists) {
			path.eclipseFile => [setContents(stream, updateFlags, null)]
		} else {
			path.parent.mkdir
			path.eclipseFile => [create(stream, updateFlags, null)]
		}
	}
	
}