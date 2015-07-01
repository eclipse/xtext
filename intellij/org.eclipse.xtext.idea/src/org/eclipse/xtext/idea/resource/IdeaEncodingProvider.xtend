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

/**
 * 
 */
class IdeaEncodingProvider implements IEncodingProvider {
	
	override getEncoding(URI uri) {
		val fileManager = ApplicationManager.getApplication().getComponent(VirtualFileManager);
		// fall back when no file manager exists (parsing tests)
		if (fileManager == null) {
			return new IEncodingProvider.Runtime().getEncoding(uri)
		}
		var file = VirtualFileURIUtil.getVirtualFile(uri)
		var parent = uri
		while (file == null && parent.segmentCount > 0) {
			parent = parent.trimSegments(1)
			file = VirtualFileURIUtil.getVirtualFile(parent)
		}
		return file?.charset?.name ?: 'UTF-8'
	}
	
}