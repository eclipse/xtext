/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.xtext.builder.DerivedResourceCleanerJob;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.osgi.service.prefs.Preferences;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
@Singleton
public class BuilderPreferenceAccess {
	/**
	 * Name of a preference for configuring whether the builder participant is enabled or not.
	 */
	public static final String PREF_AUTO_BUILDING = "autobuilding"; //$NON-NLS-1$

	public static class Initializer implements IPreferenceStoreInitializer {
		private ChangeListener changeListener;
		private OutputConfigurationProvider outputConfigurationProvider;

		public OutputConfigurationProvider getOutputConfigurationProvider() {
			return outputConfigurationProvider;
		}

		@Inject
		public void setOutputConfigurationProvider(OutputConfigurationProvider outputConfigurationProvider) {
			this.outputConfigurationProvider = outputConfigurationProvider;
		}

		public ChangeListener getChangeListener() {
			return changeListener;
		}

		@Inject
		public void setChangeListener(ChangeListener changeListener) {
			this.changeListener = changeListener;
		}

		public void initialize(IPreferenceStoreAccess preferenceStoreAccess) {
			IPreferenceStore store = preferenceStoreAccess.getWritablePreferenceStore();
			intializeBuilderPreferences(store);
			initializeOutputPreferences(store);
			store.addPropertyChangeListener(getChangeListener());
		}

		private void intializeBuilderPreferences(IPreferenceStore store) {
			store.setDefault(PREF_AUTO_BUILDING, true);
		}

		private void initializeOutputPreferences(IPreferenceStore store) {
			for (OutputConfiguration configuration : outputConfigurationProvider.getOutputConfigurations()) {
				store.setDefault(getKey(configuration, OUTPUT_NAME), configuration.getName());
				store.setDefault(getKey(configuration, OUTPUT_DESCRIPTION), configuration.getDescription());
				store.setDefault(getKey(configuration, OUTPUT_DERIVED), configuration.isSetDerivedProperty());
				store.setDefault(getKey(configuration, OUTPUT_DIRECTORY), configuration.getOutputDirectory());
				store.setDefault(getKey(configuration, OUTPUT_CREATE_DIRECTORY),
						configuration.isCreateOutputDirectory());
				store.setDefault(getKey(configuration, OUTPUT_CLEAN_DIRECTORY),
						configuration.isCanClearOutputDirectory());
				store.setDefault(getKey(configuration, OUTPUT_OVERRIDE), configuration.isOverrideExistingResources());
				store.setDefault(getKey(configuration, OUTPUT_CLEANUP_DERIVED),
						configuration.isCleanUpDerivedResources());
			}
		}

	}

	public static String getKey(OutputConfiguration outputConfiguration, String preferenceName) {
		return OUTPUT_PREFERENCE_TAG + PreferenceConstants.SEPARATOR + outputConfiguration.getName()
				+ PreferenceConstants.SEPARATOR + preferenceName;
	}

	public static class ChangeListener implements IPropertyChangeListener, IPreferenceChangeListener {

		@Inject
		private Provider<DerivedResourceCleanerJob> cleanerProvider;
		
		@Inject
		private IWorkspace workspace;
		
		public ChangeListener() {
//			new Exception("New ChangeListener").printStackTrace();
		}

		public void propertyChange(PropertyChangeEvent event) {
			if (isOutputDirectoryKey(event.getProperty())) {
				String oldValue = (String) event.getOldValue();
				scheduleCleanerJob(null, oldValue);
			}
		}

		public void preferenceChange(PreferenceChangeEvent preferenceChangeEvent) {
			if (isOutputDirectoryKey(preferenceChangeEvent.getKey())) {
				Preferences node = preferenceChangeEvent.getNode();
				IProject project = null;
				// TODO: this is a hack
				if (node.absolutePath().startsWith("/project/")) {
					String projectName = node.parent().name();
					project = workspace.getRoot().getProject(projectName);
				}
				String oldValue = (String) preferenceChangeEvent.getOldValue();
				scheduleCleanerJob(project, oldValue);
			}
		}

		private void scheduleCleanerJob(IProject project, String folderNameToClean) {
			DerivedResourceCleanerJob cleaner = cleanerProvider.get();
			cleaner.setUser(true);
			cleaner.initialize(project, folderNameToClean);
			cleaner.schedule();
		}

		private boolean isOutputDirectoryKey(String key) {
			return key.matches("^" + OUTPUT_PREFERENCE_TAG + "\\.\\w+\\." + OUTPUT_DIRECTORY + "$");
		}
	}

	private IPreferenceStoreAccess preferenceStoreAccess;

	@Inject
	public void setPreferenceStoreAccess(IPreferenceStoreAccess preferenceStoreAccess) {
		this.preferenceStoreAccess = preferenceStoreAccess;
	}

	public boolean isAutoBuildEnabled(Object context) {
		IPreferenceStore preferenceStore = preferenceStoreAccess.getContextPreferenceStore(context);
		return preferenceStore.contains(PREF_AUTO_BUILDING) ? preferenceStore.getBoolean(PREF_AUTO_BUILDING) : true;
	}
	
	public void setAutoBuildEnabled(Object context, boolean enabled) {
		IPreferenceStore preferenceStore = preferenceStoreAccess.getWritablePreferenceStore(context);
		preferenceStore.setValue(PREF_AUTO_BUILDING, enabled);
	}

}
