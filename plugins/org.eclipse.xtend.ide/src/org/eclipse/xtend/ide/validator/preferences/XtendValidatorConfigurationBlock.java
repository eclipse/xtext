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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.IssueCodes;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author dhuebner - Initial contribution and API
 */
public class XtendValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {

	protected XtendValidatorConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			IWorkbenchPreferenceContainer container, IssueCodes issueCodes) {
		super(project, preferenceStore, container, issueCodes);
	}

	public static class Factory {
		@Inject
		private MembersInjector<XtendValidatorConfigurationBlock> injector;

		public XtendValidatorConfigurationBlock createValidatorConfigurationBlock(IProject project,
				IPreferenceStore preferenceStore, IWorkbenchPreferenceContainer container, IssueCodes issueCodes) {
			XtendValidatorConfigurationBlock configurationBlock = new XtendValidatorConfigurationBlock(project,
					preferenceStore, container, issueCodes);
			injector.injectMembers(configurationBlock);
			return configurationBlock;
		}
	}

	@Override
	protected void fillSettingsPage(IssueCodes issueCodes, Composite composite, int nColumns, int defaultIndent) {

		Composite inner = createSection("Deprecated and restricted API", composite, nColumns);
//		addComboBox(issueCodes.forbiddenReference, "Forbidden reference:", inner, defaultIndent);

	}

}
