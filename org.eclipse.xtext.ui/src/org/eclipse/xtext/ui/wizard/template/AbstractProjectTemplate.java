/*******************************************************************************
 * Copyright (c) 2017, 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.ui.util.TextFileContributor;
import org.eclipse.xtext.ui.wizard.IExtendedProjectInfo;

import com.google.common.annotations.Beta;

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
@Beta
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

	void setProjectInfo(IExtendedProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

}
