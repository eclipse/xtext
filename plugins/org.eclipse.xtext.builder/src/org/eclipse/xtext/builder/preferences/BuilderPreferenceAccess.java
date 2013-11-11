/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;

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

		public void initialize(IPreferenceStoreAccess preferenceStoreAccess) {
			IPreferenceStore store = preferenceStoreAccess.getWritablePreferenceStore();
			intializeBuilderPreferences(store);
			initializeOutputPreferences(store);
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
				store.setDefault(getKey(configuration, OUTPUT_CREATE_DIRECTORY), configuration.isCreateOutputDirectory());
				store.setDefault(getKey(configuration, OUTPUT_CLEAN_DIRECTORY), configuration.isCanClearOutputDirectory());
				store.setDefault(getKey(configuration, OUTPUT_OVERRIDE), configuration.isOverrideExistingResources());
				store.setDefault(getKey(configuration, OUTPUT_CLEANUP_DERIVED), configuration.isCleanUpDerivedResources());
				store.setDefault(getKey(configuration, INSTALL_DSL_AS_PRIMARY_SOURCE), configuration.isInstallDslAsPrimarySource());
				store.setDefault(getKey(configuration, HIDE_LOCAL_SYNTHETIC_VARIABLES), configuration.isHideSyntheticLocalVariables());
				store.setDefault(getKey(configuration, OUTPUT_KEEP_LOCAL_HISTORY), configuration.isKeepLocalHistory());
			}
		}

	}

	public static String getKey(OutputConfiguration outputConfiguration, String preferenceName) {
		return OUTPUT_PREFERENCE_TAG + PreferenceConstants.SEPARATOR + outputConfiguration.getName()
				+ PreferenceConstants.SEPARATOR + preferenceName;
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
