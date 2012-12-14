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
import org.eclipse.xtext.xbase.ui.validation.XbaseValidationConfigurationBlock;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendValidatorConfigurationBlock extends XbaseValidationConfigurationBlock {

	public static class Factory {
		@Inject
		private MembersInjector<XtendValidatorConfigurationBlock> injector;

		public XtendValidatorConfigurationBlock createValidatorConfigurationBlock(IProject project,
				IPreferenceStore preferenceStore, IWorkbenchPreferenceContainer container) {
			XtendValidatorConfigurationBlock configurationBlock = new XtendValidatorConfigurationBlock(project,
					preferenceStore, container);
			injector.injectMembers(configurationBlock);
			return configurationBlock;
		}
	}

	protected XtendValidatorConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			IWorkbenchPreferenceContainer container) {
		super(project, preferenceStore, container);
	}
}
