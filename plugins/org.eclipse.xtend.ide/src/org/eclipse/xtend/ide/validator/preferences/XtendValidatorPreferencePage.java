/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.ui.validation.AbstractValidatorPreferencePage;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendValidatorPreferencePage extends AbstractValidatorPreferencePage {

	@Inject
	private XtendValidatorConfigurationBlock.Factory configurationBlockFactory;

	@Override
	public void createControl(Composite parent) {
		IWorkbenchPreferenceContainer container = (IWorkbenchPreferenceContainer) getContainer();
		IPreferenceStore preferenceStore = preferenceStoreAccessImpl.getWritablePreferenceStore(getProject());
		validatorConfigurationBlock = configurationBlockFactory.createValidatorConfigurationBlock(getProject(),
				preferenceStore, container);
		validatorConfigurationBlock.setStatusChangeListener(getNewStatusChangedListener());
		super.createControl(parent);
	}

}
