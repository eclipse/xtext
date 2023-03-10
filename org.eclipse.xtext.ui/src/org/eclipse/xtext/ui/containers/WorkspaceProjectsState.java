/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.containers;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class WorkspaceProjectsState extends AbstractAllContainersState {

	@Inject
	private WorkspaceProjectsStateHelper helper;
	
	@Override
	protected String doInitHandle(URI uri) {
		return helper.initHandle(uri);
	}

	@Override
	protected Collection<URI> doInitContainedURIs(String containerHandle) {
		return helper.initContainedURIs(containerHandle);
	}
	
	@Override
	protected List<String> doInitVisibleHandles(String handle) {
		return helper.initVisibleHandles(handle);
	}
	
	public WorkspaceProjectsStateHelper getHelper() {
		return helper;
	}
	
	public void setHelper(WorkspaceProjectsStateHelper helper) {
		this.helper = helper;
	}

}
