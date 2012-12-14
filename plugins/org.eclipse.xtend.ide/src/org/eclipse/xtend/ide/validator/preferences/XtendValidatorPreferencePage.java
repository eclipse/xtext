/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;
import org.eclipse.xtext.ui.validation.AbstractValidatorPreferencePage;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendValidatorPreferencePage extends AbstractValidatorPreferencePage {

	@Inject
	private XtendValidatorConfigurationBlock.Factory configurationBlockFactory;

	@Override
	protected OptionsConfigurationBlock createConfigurationBlock(IProject iProject,
			IPreferenceStore preferenceStore, IWorkbenchPreferenceContainer container) {
		return configurationBlockFactory.createValidatorConfigurationBlock(getProject(), preferenceStore, container);
	}

}
