/*******************************************************************************
 * Copyright (c) 2017, 2021 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.ui.util.TextFileContributor;
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;

/**
 * A template definition for a project, used by the new project wizard. Defines the UI (label, description, icon, variables) on how to
 * present the template to the user. The {@link TemplateVariable}'s can be used to configure the {@link ProjectFactory}'s added inside
 * {@link AbstractProjectTemplate#generateProjects(IProjectGenerator)}.
 * 
 * Instances of this class are generated from classes annotated with {@link ProjectTemplate}.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public abstract class AbstractProjectTemplate extends AbstractTemplate {

	private IExtendedProjectInfo projectInfo;

	/**
	 * Subclasses have to override. Generate all the projects to be created when the wizard is finished.
	 * 
	 * @param generator
	 *            The generator to supply {@link org.eclipse.xtext.ui.util.ProjectFactory}'s to create projects from.
	 */
	public abstract void generateProjects(IProjectGenerator generator);

	protected ProjectFactory addFile(ProjectFactory project, CharSequence fileName, CharSequence contents) {
		project.addContributor(new TextFileContributor(fileName, contents));
		return project;
	}

	protected IExtendedProjectInfo getProjectInfo() {
		return projectInfo;
	}

	/**
	 * @since 2.25
	 */
	protected void setProjectInfo(IExtendedProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

}
