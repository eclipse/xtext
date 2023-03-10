/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.IPreferencePageContainer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.builder.DerivedResourceCleanerJob;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.ui.preferences.PropertyAndPreferencePage;

import com.google.common.collect.MapDifference.ValueDifference;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class BuilderPreferencePage extends PropertyAndPreferencePage {
	
	@Inject
	private BuilderConfigurationBlock builderConfigurationBlock;
	
	private String languageName;
	private Provider<DerivedResourceCleanerJob> cleanerProvider;

	@Inject
	public void setCleanerProvider(Provider<DerivedResourceCleanerJob> cleanerProvider) {
		this.cleanerProvider = cleanerProvider;
	}

	@Inject
	public void setLanguageName(@Named(Constants.LANGUAGE_NAME) String languageName) {
		this.languageName = languageName;
	}

	@Override
	public void createControl(Composite parent) {
		IWorkbenchPreferenceContainer container = (IWorkbenchPreferenceContainer) getContainer();
		builderConfigurationBlock.setProject(getProject());
		builderConfigurationBlock.setWorkbenchPreferenceContainer(container);
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
		return languageName + ".compiler.preferencePage";
	}

	@Override
	protected String getPropertyPageID() {
		return languageName + ".compiler.propertyPage";
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
		if (builderConfigurationBlock != null) {
			scheduleCleanerJobIfNecessary(getContainer());
			if (!builderConfigurationBlock.performOk()) {
				return false;
			}
		}
		return super.performOk();
	}

	@Override
	public void performApply() {
		if (builderConfigurationBlock != null) {
			scheduleCleanerJobIfNecessary(null);
			builderConfigurationBlock.performApply();
		}
	}

	@Override
	public void setElement(IAdaptable element) {
		super.setElement(element);
		setDescription(null); // no description for property page
	}

	private void scheduleCleanerJobIfNecessary(IPreferencePageContainer preferencePageContainer) {
		Map<String, ValueDifference<String>> changes = builderConfigurationBlock.getPreferenceChanges();
		for (String key : changes.keySet()) {
			if (key.matches("^" + EclipseOutputConfigurationProvider.OUTPUT_PREFERENCE_TAG + "\\.\\w+\\."
					+ EclipseOutputConfigurationProvider.OUTPUT_DIRECTORY + "$")) {
				ValueDifference<String> difference = changes.get(key);
				scheduleCleanerJob(preferencePageContainer, difference.rightValue());
			}
		}
	}

	private void scheduleCleanerJob(IPreferencePageContainer preferencePageContainer, String folderNameToClean) {
		DerivedResourceCleanerJob derivedResourceCleanerJob = cleanerProvider.get();
		derivedResourceCleanerJob.setUser(true);
		derivedResourceCleanerJob.initialize(getProject(), folderNameToClean);
		if (preferencePageContainer != null) {
			IWorkbenchPreferenceContainer container = (IWorkbenchPreferenceContainer) getContainer();
			container.registerUpdateJob(derivedResourceCleanerJob);
		} else {
			derivedResourceCleanerJob.schedule();
		}
	}

}
