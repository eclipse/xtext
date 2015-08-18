/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build

import com.intellij.openapi.vfs.VirtualFile
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Data

import static extension org.eclipse.xtext.idea.resource.VirtualFileURIUtil.*

/**
 * @author koehnlein - Initial contribution and API
 */
@Data
class BuildEvent {

	Type type
	val Map<URI, VirtualFile> filesByURI

	new(Type type, VirtualFile ... files) {
		this.type = type
		filesByURI = newLinkedHashMap
		for (file : files)
			filesByURI.put(file.URI, file)
	}
	
	def getURIs() {
		filesByURI.keySet
	}
	
	def getFile(URI uri) {
		filesByURI.get(uri)
	}

	enum Type {
		DELETED,
		MODIFIED,
		ADDED
	}
}