/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.IPreferencePageContainer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class BuilderPreferencePage extends PropertyAndPreferencePage {
	private BuilderConfigurationBlock builderConfigurationBlock;
	private EclipseOutputConfigurationProvider configurationProvider;
	private WorkingCopyPreferencesAccess.Factory workingCopyPreferencesAccessFactory;
	private String languageName;

	@Inject
	public void setLanguageName(@Named(Constants.LANGUAGE_NAME) String languageName) {
		this.languageName = languageName;
	}

	@Inject
	public void setConfigurationProvider(EclipseOutputConfigurationProvider configurationProvider) {
		this.configurationProvider = configurationProvider;
	}

	@Inject
	public void setWorkingCopyPreferencesAccessFactory(
			WorkingCopyPreferencesAccess.Factory workingCopyPreferencesAccessFactory) {
		this.workingCopyPreferencesAccessFactory = workingCopyPreferencesAccessFactory;
	}

	@Override
	public void createControl(Composite parent) {
		WorkingCopyPreferencesAccess workingCopyPreferencesAccess = workingCopyPreferencesAccessFactory.create(
				getProject(), getWorkingCopyManager());
		IWorkbenchPreferenceContainer container = (IWorkbenchPreferenceContainer) getContainer();
		builderConfigurationBlock = new BuilderConfigurationBlock(getProject(), workingCopyPreferencesAccess,
				configurationProvider, container);
		builderConfigurationBlock.setStatusChangeListener(getNewStatusChangedListener());
		super.createControl(parent);
	}

	@Override
	protected Control createPreferenceContent(Composite composite, IPreferencePageContainer preferencePageContainer) {
		return builderConfigurationBlock.createContents(composite);
	}

	@Override
	protected boolean hasProjectSpecificOptions(IProject project) {
		return builderConfigurationBlock.hasProjectSpecificOptions(project);
	}

	@Override
	protected String getPreferencePageID() {
		return languageName + ".builder.preferencePage";
	}

	@Override
	protected String getPropertyPageID() {
		return languageName + ".builder.propertyPage";
	}

	@Override
	public void dispose() {
		if (builderConfigurationBlock != null) {
			builderConfigurationBlock.dispose();
		}
		super.dispose();
	}

	@Override
	protected void enableProjectSpecificSettings(boolean useProjectSpecificSettings) {
		super.enableProjectSpecificSettings(useProjectSpecificSettings);
		if (builderConfigurationBlock != null) {
			builderConfigurationBlock.useProjectSpecificSettings(useProjectSpecificSettings);
		}
	}

	@Override
	protected void performDefaults() {
		super.performDefaults();
		if (builderConfigurationBlock != null) {
			builderConfigurationBlock.performDefaults();
		}
	}

	@Override
	public boolean performOk() {
		if (builderConfigurationBlock != null && !builderConfigurationBlock.performOk()) {
			return false;
		}
		return super.performOk();
	}

	@Override
	public void performApply() {
		if (builderConfigurationBlock != null) {
			builderConfigurationBlock.performApply();
		}
	}

	@Override
	public void setElement(IAdaptable element) {
		super.setElement(element);
		setDescription(null); // no description for property page
	}

}
