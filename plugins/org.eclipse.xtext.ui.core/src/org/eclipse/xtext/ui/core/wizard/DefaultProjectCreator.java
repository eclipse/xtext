/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DefaultProjectCreator extends WorkspaceModifyOperation implements IProjectCreator {
	
	private IFile result;
	private IProjectInfo projectInfo;

	public IFile getResult() {
		return result;
	}
	
	protected void setResult(IFile result) {
		this.result = result;
	}
	
	public void setProjectInfo(IProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	
	protected IProjectInfo getProjectInfo() {
		return projectInfo;
	}
	
	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
			InterruptedException {

	}

	protected String getEncoding() throws CoreException {
		return ResourcesPlugin.getWorkspace().getRoot().getDefaultCharset();
	}

}
