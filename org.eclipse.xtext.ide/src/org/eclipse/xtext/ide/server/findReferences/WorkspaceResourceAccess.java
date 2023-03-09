/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server.findReferences;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
public class WorkspaceResourceAccess implements IReferenceFinder.IResourceAccess {

	private final WorkspaceManager workspaceManager;

	/**
	 * @param workspaceManager
	 *            the workspace manager
	 */
	public WorkspaceResourceAccess(WorkspaceManager workspaceManager) {
		this.workspaceManager = workspaceManager;
	}

	@Override
	public <R> R readOnly(URI targetURI, IUnitOfWork<R, ResourceSet> work) {
		return workspaceManager.doRead(targetURI, (document, resource) -> {
			if (resource == null) {
				return null;
			}
			try {
				return work.exec(resource.getResourceSet());
			} catch (Exception e) {
				return Exceptions.throwUncheckedException(e);
			}
		});
	}

}
