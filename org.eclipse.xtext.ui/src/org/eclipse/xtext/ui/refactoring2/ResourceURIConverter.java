/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.refactoring2;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

/**
 * Converts platform resource URIs to IResources and back.
 * 
 * As opposed to the common {@link IStorage2UriMapper} it also works with folders and non-existing files.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
public class ResourceURIConverter {

	@Inject(optional = true)
	private IWorkspace workspace;

	public URI toURI(IResource file) {
		return toURI(file.getFullPath());
	}

	public URI toURI(IPath path) {
		return URI.createPlatformResourceURI(path.toString(), true);
	}

	public IFile toFile(URI uri) {
		IWorkspaceRoot root = workspace.getRoot();
		return root.getFile(new Path(uri.toPlatformString(true)));
	}

	public IFolder toFolder(URI uri) {
		IWorkspaceRoot root = workspace.getRoot();
		return root.getFolder(new Path(uri.toPlatformString(true)));
	}
}
