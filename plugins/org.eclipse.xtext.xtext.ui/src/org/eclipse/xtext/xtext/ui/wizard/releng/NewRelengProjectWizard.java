/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import org.eclipse.xtext.ui.wizard.XtextNewProjectWizard;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class NewRelengProjectWizard extends XtextNewProjectWizard {

	private RelengProjectInfo projectInfo;

	@Inject
	public NewRelengProjectWizard(RelengProjectCreator creator) {
		super(creator);
	}

	@Override
	protected RelengProjectInfo getProjectInfo() {
		return projectInfo;
	}

}
