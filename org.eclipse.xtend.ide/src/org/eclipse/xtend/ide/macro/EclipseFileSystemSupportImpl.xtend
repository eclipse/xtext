/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.macro

import com.google.inject.Inject
import java.util.List
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.macro.file.Path

import static extension org.eclipse.core.filesystem.URIUtil.*

/**
 * A FileSystemSupport implementation which maps to the Eclipse Resources API.
 * 
 * @author Sven Efftinge
 */
class EclipseFileSystemSupportImpl extends AbstractFileSystemSupport {

	@Accessors @Inject IWorkspaceRoot workspaceRoot

	override getChildren(URI uri, Path path) {
		val resource = uri.findMember
		if (resource instanceof IContainer)
			try {
				return resource.members.map[new Path(fullPath.toString)]
			} catch (CoreException exc) {
				throw new IllegalArgumentException(exc.message, exc)
			}

		return emptyList
	}
	
	override toURI(URI uri) {
		uri.toURI(newArrayList)
	}

	protected def java.net.URI toURI(URI uri, List<String> trailingSegments) {
		val resource = uri.findMember
		if (resource === null) {
			trailingSegments += uri.lastSegment
			return toURI(uri.trimSegments(1), trailingSegments)
		}
		trailingSegments.reverse.fold(resource.location)[$0.append($1)].toURI
	}
	
	protected def findMember(URI uri) {
		val platformResourcePath = uri.toPlatformString(true)
		workspaceRoot.findMember(new org.eclipse.core.runtime.Path(platformResourcePath))
	}

}
