/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor;
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.xtext.ui.wizard.releng.templates.BuckminsterFilesCreator;
import org.eclipse.xtext.xtext.ui.wizard.releng.templates.BuildScriptCreator;

/**
 * @author dhuebner - Initial contribution and API
 */
public class RelengProjectFactory extends ProjectFactory {
	static final public String BUILD_FILE_NAME = "build.ant";
	private RelengProjectInfo projectInfo;

	@Override
	protected void enhanceProject(final IProject project, final SubMonitor subMonitor, final Shell shell)
			throws CoreException {
		super.enhanceProject(project, subMonitor, shell);
		IProjectFactoryContributor.IFileCreator fileCreator = new IProjectFactoryContributor.IFileCreator() {

			public IFile writeToFile(CharSequence chars, String fileName) {
				return RelengProjectFactory.this.createFile(fileName, project, chars.toString(), subMonitor);
			}

		};
		BuckminsterFilesCreator buckyStuffCreator = new BuckminsterFilesCreator(fileCreator);
		buckyStuffCreator.createBuckminsterFiles(projectInfo);
		createFile(BUILD_FILE_NAME, project, new BuildScriptCreator().createScript(projectInfo).toString(), subMonitor);
	}

	public void setRelengProjectInfo(RelengProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
		setProjectName(projectInfo.getProjectName());
	}
}
