/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project

import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkingSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.wizard.WizardConfiguration
import org.eclipse.xtext.ui.wizard.IProjectInfo

/**
 * Simple value object class containing all relevant attributes necessary for the creation of new Xtext projects.
 */
@Accessors
class XtextProjectInfo extends WizardConfiguration implements IProjectInfo {
	Iterable<IWorkingSet> workingSets
	IWorkbench workbench
	
	override getProjectName() {
		baseName
	}
	
	override setProjectName(String projectName) {
		baseName = projectName
	}
	
}
