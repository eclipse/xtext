/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.parser.IEncodingProvider
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.vfs.VirtualFileManager
import com.intellij.openapi.vfs.encoding.EncodingRegistry

import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*
import com.intellij.openapi.vfs.VirtualFile

/**
 * 
 */
class IdeaEncodingProvider implements IEncodingProvider {
	
	override getEncoding(URI uri) {
		val fileManager = ApplicationManager.getApplication().getComponent(VirtualFileManager);
		// fall back when no file manager exists (parsing tests)
		if (fileManager == null)
			return new IEncodingProvider.Runtime().getEncoding(uri)

		return uri.charset?.name ?: 'UTF-8'
	}
	
	protected def getCharset(URI uri) {
		uri.findVirtualFile?.charset ?: EncodingRegistry.instance.defaultCharset
	}
	
	protected def VirtualFile findVirtualFile(URI uri) {
		if (uri === null)
			return null
			
		val file = uri.virtualFile
		if (file !== null)
			return file
		
		if (uri.segmentCount == 0)
			return null
			
		uri.trimSegments(1).findVirtualFile
	}
	
}