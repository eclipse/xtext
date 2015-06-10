/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.VirtualFileManager
import org.eclipse.emf.common.util.URI

/**
 * Utilities to bridge URIs and VirtualFiles
 */
class VirtualFileURIUtil {
	
	/**
	 * @return an EMF URI for a virtual file
	 */
	def static URI getURI(VirtualFile file) {
		if (file.isDirectory) {
			return URI.createURI(file.url+"/")	
		}
		return URI.createURI(file.url)
	}
	
	/**
	 * Returns a VirtualFile for the given EMF URI, or <code>null</code> if no VirtualFile exists.
	 * Note that a non-existing VirtualFile could be returned as well.
	 * 
	 * @return a VirtualFile for the given EMF URI, or <code>null</code> if no VirtualFile exists.
	 */
	def static VirtualFile getVirtualFile(URI uri) {
		return VirtualFileManager.getInstance().findFileByUrl(uri.toString)
	}
	
	/**
	 * Will return a VirtualFile and create one if it doesn't already exist.
	 * This method will also create all parent folders when needed.
	 */
	def static VirtualFile getOrCreateVirtualFile(URI uri) {
		return getOrCreateFile(uri, false)
	}
	
	private def static VirtualFile getOrCreateFile(URI uri, boolean isDirectory) {
		val file = getVirtualFile(uri)
		if (file != null) {
			return file
		}
		val parent = getOrCreateFile(uri.trimSegments(1), true)
		if (isDirectory) {
			return parent.createChildDirectory(null, uri.lastSegment)
		} else {
			return parent.createChildData(null, uri.lastSegment)
		}
	}
		
}