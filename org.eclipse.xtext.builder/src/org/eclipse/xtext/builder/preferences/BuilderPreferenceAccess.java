/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfiguration.SourceMapping;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;

import com.google.common.base.Strings;
import com.google.inject.Inject;
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
		private IOutputConfigurationProvider outputConfigurationProvider;

		public IOutputConfigurationProvider getOutputConfigurationProvider() {
			return outputConfigurationProvider;
		}

		@Inject
		public void setOutputConfigurationProvider(IOutputConfigurationProvider outputConfigurationProvider) {
			this.outputConfigurationProvider = outputConfigurationProvider;
		}

		@Override
		public void initialize(IPreferenceStoreAccess preferenceStoreAccess) {
			IPreferenceStore store = preferenceStoreAccess.getWritablePreferenceStore();
			initializeBuilderPreferences(store);
			for (OutputConfiguration configuration : outputConfigurationProvider.getOutputConfigurations()) {
				initializeOutputPreferences(store, configuration);
			}
		}

		protected void initializeBuilderPreferences(IPreferenceStore store) {
			store.setDefault(PREF_AUTO_BUILDING, true);
		}

		protected void initializeOutputPreferences(IPreferenceStore store, OutputConfiguration configuration) {
			store.setDefault(getKey(configuration, OUTPUT_NAME), configuration.getName());
			store.setDefault(getKey(configuration, OUTPUT_DESCRIPTION), configuration.getDescription());
			store.setDefault(getKey(configuration, OUTPUT_DERIVED), configuration.isSetDerivedProperty());
			store.setDefault(getKey(configuration, OUTPUT_DIRECTORY), configuration.getOutputDirectory());
			store.setDefault(getKey(configuration, OUTPUT_CREATE_DIRECTORY), configuration.isCreateOutputDirectory());
			store.setDefault(getKey(configuration, OUTPUT_CLEAN_DIRECTORY), configuration.isCanClearOutputDirectory());
			store.setDefault(getKey(configuration, OUTPUT_OVERRIDE), configuration.isOverrideExistingResources());
			store.setDefault(getKey(configuration, OUTPUT_CLEANUP_DERIVED), configuration.isCleanUpDerivedResources());
			store.setDefault(getKey(configuration, INSTALL_DSL_AS_PRIMARY_SOURCE), configuration.isInstallDslAsPrimarySource());
			store.setDefault(getKey(configuration, HIDE_LOCAL_SYNTHETIC_VARIABLES), configuration.isHideSyntheticLocalVariables());
			store.setDefault(getKey(configuration, OUTPUT_KEEP_LOCAL_HISTORY), configuration.isKeepLocalHistory());
			
			for (SourceMapping sourceMapping : configuration.getSourceMappings()) {
				store.setDefault(getOutputForSourceFolderKey(configuration, sourceMapping.getSourceFolder()), Strings.nullToEmpty(sourceMapping.getOutputDirectory()));
				store.setDefault(getIgnoreSourceFolderKey(configuration, sourceMapping.getSourceFolder()), sourceMapping.isIgnore());
			}
		}

	}

	public static String getKey(OutputConfiguration outputConfiguration, String preferenceName) {
		return OUTPUT_PREFERENCE_TAG + PreferenceConstants.SEPARATOR + outputConfiguration.getName()
				+ PreferenceConstants.SEPARATOR + preferenceName;
	}
	
	public static String getOutputForSourceFolderKey(OutputConfiguration outputConfiguration, String sourceFolder) {
		return getKey(outputConfiguration, SOURCE_FOLDER_TAG + PreferenceConstants.SEPARATOR + sourceFolder + PreferenceConstants.SEPARATOR + OUTPUT_DIRECTORY);
	}
	
	public static String getIgnoreSourceFolderKey(OutputConfiguration outputConfiguration, String sourceFolder) {
		return getKey(outputConfiguration, SOURCE_FOLDER_TAG + PreferenceConstants.SEPARATOR + sourceFolder + PreferenceConstants.SEPARATOR + IGNORE_SOURCE_FOLDER_TAG);
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
