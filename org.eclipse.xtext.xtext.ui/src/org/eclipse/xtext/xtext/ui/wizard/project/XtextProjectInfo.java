/**
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.ui.wizard.project;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

/**
 * Value object class containing all relevant attributes necessary for the creation of new Xtext projects.
 */
public class XtextProjectInfo extends WizardConfiguration implements IProjectInfo {

	private Iterable<IWorkingSet> workingSets;

	private IWorkbench workbench;

	public IWorkbench getWorkbench() {
		return workbench;
	}

	public void setWorkbench(IWorkbench workbench) {
		this.workbench = workbench;
	}

	public Iterable<IWorkingSet> getWorkingSets() {
		return workingSets;
	}

	public void setWorkingSets(Iterable<IWorkingSet> workingSets) {
		this.workingSets = workingSets;
	}

	@Override
	public void setProjectName(String projectName) {
		setBaseName(projectName);
	}

	@Override
	public String getProjectName() {
		return getBaseName();
	}

}
