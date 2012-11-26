/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.validation;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.IPreferencePageContainer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.editor.preferences.PreferenceStoreAccessImpl;
import org.eclipse.xtext.ui.preferences.PropertyAndPreferencePage;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.4
 */
public abstract class AbstractValidatorPreferencePage extends PropertyAndPreferencePage {

	protected PreferenceStoreAccessImpl preferenceStoreAccessImpl;
	protected AbstractValidatorConfigurationBlock validatorConfigurationBlock;
	private String languageName;

	public AbstractValidatorPreferencePage() {
		super();
	}

	@Inject
	public void setLanguageName(@Named(Constants.LANGUAGE_NAME) String languageName) {
		this.languageName = languageName;
	}

	@Inject
	public void setPreferenceStoreAccessImpl(PreferenceStoreAccessImpl preferenceStoreAccessImpl) {
		this.preferenceStoreAccessImpl = preferenceStoreAccessImpl;
	}

	@Override
	protected Control createPreferenceContent(Composite composite, IPreferencePageContainer preferencePageContainer) {
		return validatorConfigurationBlock.createContents(composite);
	}

	@Override
	protected boolean hasProjectSpecificOptions(IProject project) {
		return validatorConfigurationBlock.hasProjectSpecificOptions(project);
	}

	@Override
	protected String getPreferencePageID() {
		return languageName + ".validator.preferencePage";
	}

	@Override
	protected String getPropertyPageID() {
		return languageName + ".validator.propertyPage";
	}

	@Override
	public void dispose() {
		if (validatorConfigurationBlock != null) {
			validatorConfigurationBlock.dispose();
		}
		super.dispose();
	}

	@Override
	protected void enableProjectSpecificSettings(boolean useProjectSpecificSettings) {
		super.enableProjectSpecificSettings(useProjectSpecificSettings);
		if (validatorConfigurationBlock != null) {
			validatorConfigurationBlock.useProjectSpecificSettings(useProjectSpecificSettings);
		}
	}

	@Override
	protected void performDefaults() {
		super.performDefaults();
		if (validatorConfigurationBlock != null) {
			validatorConfigurationBlock.performDefaults();
		}
	}

	@Override
	public boolean performOk() {
		if (validatorConfigurationBlock != null) {
			if (!validatorConfigurationBlock.performOk()) {
				return false;
			}
		}
		return super.performOk();
	}

	@Override
	public void performApply() {
		if (validatorConfigurationBlock != null) {
			validatorConfigurationBlock.performApply();
		}
	}

	@Override
	public void setElement(IAdaptable element) {
		super.setElement(element);
		setDescription(null); // no description for property page
	}

}