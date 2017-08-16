/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.participant

import com.google.inject.Inject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IWorkspace
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.ui.resource.IStorage2UriMapper

/**
 * Converts platform resource URIs to IResources and back.
 * 
 * As opposed to the common {@link IStorage2UriMapper} it also works with folders and non-existing files.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
class ResourceURIConverter {
	
	@Inject(optional = true) IWorkspace workspace
	
	def URI toURI(IResource file) {
		toURI(file.fullPath) 
	}
	
	def toURI(IPath path) {
		URI.createPlatformResourceURI(path.toString, true) 
	}
	
	def toFile(URI uri) {
		workspace.root.getFile(new Path(uri.toPlatformString(true)))
	}

	def toFolder(URI uri) {
		workspace.root.getFolder(new Path(uri.toPlatformString(true)))
	}	
}