/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.containers;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.xtext.ui.XtextProjectHelper;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
public abstract class AbstractProjectsStateHelper extends AbstractStorage2UriMapperClient {

	@Inject
	private IWorkspace workspace;
	
	protected IWorkspaceRoot getWorkspaceRoot() {
		return workspace.getRoot();
	}
	
	public void setWorkspace(IWorkspace workspace) {
		this.workspace = workspace;
	}
	
	protected boolean isAccessibleXtextProject(IProject p) {
		return p != null && XtextProjectHelper.hasNature(p) && XtextProjectHelper.hasBuilder(p);
	}
	
}
