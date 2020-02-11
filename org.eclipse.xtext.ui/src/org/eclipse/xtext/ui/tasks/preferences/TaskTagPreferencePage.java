/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.IPreferencePageContainer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.preferences.PropertyAndPreferencePage;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class TaskTagPreferencePage extends PropertyAndPreferencePage {

	@Inject
	private TaskTagConfigurationBlock taskConfigurationBlock;
	private String languageName;
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	public TaskTagPreferencePage() {
		setDescription(PreferencesMessages.TaskTagPreferencePage_description);
		setTitle(PreferencesMessages.TaskTagPreferencePage_title);
	}

	@Inject
	public void setLanguageName(@Named(Constants.LANGUAGE_NAME) String languageName) {
		this.languageName = languageName;
	}

	@Inject
	public void setPreferenceStoreAccess(IPreferenceStoreAccess preferenceStoreAccess) {
		this.preferenceStoreAccess = preferenceStoreAccess;
	}

	@Override
	public void createControl(Composite parent) {
		IWorkbenchPreferenceContainer container = (IWorkbenchPreferenceContainer) getContainer();
		IPreferenceStore preferenceStore = preferenceStoreAccess.getWritablePreferenceStore(getProject());
		taskConfigurationBlock.setProject(getProject());
		taskConfigurationBlock.setPreferenceStore(preferenceStore);
		taskConfigurationBlock.setWorkbenchPreferenceContainer(container);
		taskConfigurationBlock.setStatusChangeListener(getNewStatusChangedListener());
		super.createControl(parent);
	}

	@Override
	protected Control createPreferenceContent(Composite composite, IPreferencePageContainer preferencePageContainer) {
		return taskConfigurationBlock.createContents(composite);
	}

	@Override
	protected boolean hasProjectSpecificOptions(IProject project) {
		return taskConfigurationBlock.hasProjectSpecificOptions(project);
	}

	@Override
	protected String getPreferencePageID() {
		return languageName + ".task.preferencePage";
	}

	@Override
	protected String getPropertyPageID() {
		return languageName + ".task.propertyPage";
	}

	@Override
	public void dispose() {
		if (taskConfigurationBlock != null) {
			taskConfigurationBlock.dispose();
		}
		super.dispose();
	}

	@Override
	protected void enableProjectSpecificSettings(boolean useProjectSpecificSettings) {
		super.enableProjectSpecificSettings(useProjectSpecificSettings);
		if (taskConfigurationBlock != null) {
			taskConfigurationBlock.useProjectSpecificSettings(useProjectSpecificSettings);
		}
	}

	@Override
	protected void performDefaults() {
		super.performDefaults();
		if (taskConfigurationBlock != null) {
			taskConfigurationBlock.performDefaults();
		}
	}

	@Override
	public boolean performOk() {
		if (taskConfigurationBlock != null) {
			if (!taskConfigurationBlock.performOk()) {
				return false;
			}
		}
		return super.performOk();
	}

	@Override
	public void performApply() {
		if (taskConfigurationBlock != null) {
			taskConfigurationBlock.performApply();
		}
	}

	@Override
	public void setElement(IAdaptable element) {
		super.setElement(element);
		setDescription(null);
	}

}
