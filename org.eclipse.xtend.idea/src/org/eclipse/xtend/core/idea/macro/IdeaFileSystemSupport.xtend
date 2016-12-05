/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.macro

import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.macro.AbstractFileSystemSupport
import org.eclipse.xtend.lib.macro.file.Path
import org.eclipse.xtext.idea.resource.IdeaResourceSetProvider.VirtualFileBasedUriHandler

class IdeaFileSystemSupport extends AbstractFileSystemSupport {
	
	override getChildren(URI uri, Path path) {
		val handler = VirtualFileBasedUriHandler.find(context)
		if (handler === null)
			return emptyList

		return handler.getChildren(uri).map[getPath(uri, path)].filterNull
	}

}
