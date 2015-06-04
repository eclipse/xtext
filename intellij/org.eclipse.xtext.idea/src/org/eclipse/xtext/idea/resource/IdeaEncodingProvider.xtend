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

/**
 * 
 */
class IdeaEncodingProvider implements IEncodingProvider {
	
	override getEncoding(URI uri) {
		var file = VirtualFileURIUtil.getVirtualFile(uri)
		while (file == null && uri.segmentCount > 0) {
			val parent = uri.trimSegments(1)
			file = VirtualFileURIUtil.getVirtualFile(parent)
		}
		return file?.charset?.name ?: 'UTF-8'
	}
	
}