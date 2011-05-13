/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.builder;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FolderUtil {

	public void clearFolder(final IFolder folder, final SubMonitor progress) throws CoreException {
		if (folder.exists()) {
			for (IResource resource : folder.members())
				resource.delete(IResource.KEEP_HISTORY, progress);
		}
	}

	public void removeEmptySubFolders(final IFolder folder, final SubMonitor progress) throws CoreException {
		if (folder.exists()) {
			for (IResource resource : folder.members()) {
				if (resource instanceof IFolder) {
					removeEmptySubFolders((IFolder) resource, progress);
					if (((IFolder) resource).members().length == 0)
						resource.delete(IResource.KEEP_HISTORY, progress);
				}
			}
		}
	}

	public void createParentFolders(IResource resource, SubMonitor progress) throws CoreException {
		IContainer parent = resource.getParent();
		if (parent instanceof IFolder) {
			IFolder folder = (IFolder) parent;
			if (!folder.exists()) {
				createParentFolders(folder, progress);
				folder.create(true, true, progress);
			}
		}
	}
}
