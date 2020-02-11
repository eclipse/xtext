/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard;

/**
 * A {@link IProjectInfo}, normally created by {@link XtextNewProjectWizard} subclasses,<br>
 * is a kind of data holder for values which were collected from the corresponding Wizard pages.<br>
 * This data should be used in {@link IProjectCreator} to create a proper project<br>
 * 
 * @author Peter Friese - Initial contribution and API
 * @author Dennis Huebner - Javadoc
 */
public interface IProjectInfo {

	/**
	 * Set project name to use when creating the a project.<br>
	 * This name will be used as folder name and as project name in the corresponding .project file.
	 * 
	 * @param projectName
	 *            - projec's name
	 */
	void setProjectName(String projectName);

	/**
	 * The returned name should be used as folder name and<br>
	 * as project name in the corresponding .project file.
	 * 
	 * @return project's name
	 */
	String getProjectName();

}
