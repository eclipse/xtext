/*******************************************************************************
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import org.eclipse.xtext.ui.wizard.IProjectInfo;

/**
 * Project creator that creates all projects as configured through a selected template.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public class DefaultTemplateProjectCreator extends WorkspaceModifyOperation implements IProjectCreator, IProjectGenerator {

	private IProjectInfo projectInfo;
	private final List<ProjectFactory> projectFactories = new ArrayList<>();

	@Override
	public IFile getResult() {
		return null;
	}

	@Override
	public void setProjectInfo(IProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

	protected IProjectInfo getProjectInfo() {
		return projectInfo;
	}

	@Override
	public void generate(ProjectFactory project) {
		projectFactories.add(project);
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, projectFactories.size());
		try {
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			for (ProjectFactory projectFactory : projectFactories) {
				projectFactory.setWorkbench(workbench);
				projectFactory.setWorkspace(workspace);
				projectFactory.createProject(subMonitor, null);
				subMonitor.worked(1);
			}
		} finally {
			subMonitor.done();
		}
	}

}
