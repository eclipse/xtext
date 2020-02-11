/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.generator.IOutputConfigurationProvider.Delegate;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfiguration.SourceMapping;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.eclipse.xtext.ui.preferences.XtextBuildPreferenceEvaluator;
import org.eclipse.xtext.ui.resource.ProjectByResourceProvider;

import com.google.common.base.Strings;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class EclipseOutputConfigurationProvider extends Delegate {
	public static final String OUTPUT_PREFERENCE_TAG = XtextBuildPreferenceEvaluator.OUTPUT_PREFERENCE_TAG;
	public static final String OUTPUT_NAME = "name";
	public static final String OUTPUT_DESCRIPTION = "description";
	public static final String OUTPUT_DIRECTORY = "directory";
	public static final String OUTPUT_CREATE_DIRECTORY = XtextBuildPreferenceEvaluator.OUTPUT_CREATE_DIRECTORY;
	public static final String OUTPUT_CLEAN_DIRECTORY = XtextBuildPreferenceEvaluator.OUTPUT_CLEAN_DIRECTORY;
	public static final String OUTPUT_OVERRIDE = XtextBuildPreferenceEvaluator.OUTPUT_OVERRIDE;
	public static final String OUTPUT_CLEANUP_DERIVED = XtextBuildPreferenceEvaluator.OUTPUT_CLEANUP_DERIVED;
	public static final String OUTPUT_DERIVED = XtextBuildPreferenceEvaluator.OUTPUT_DERIVED;
	/**
	 * @since 2.5
	 */
	public static final String OUTPUT_KEEP_LOCAL_HISTORY = XtextBuildPreferenceEvaluator.OUTPUT_KEEP_LOCAL_HISTORY;
	/**
	 * @since 2.4
	 */
	public static final String INSTALL_DSL_AS_PRIMARY_SOURCE = "installDslAsPrimarySource";
	
	/**
	 * @since 2.4
	 */
	public static final String HIDE_LOCAL_SYNTHETIC_VARIABLES = "hideLocalSyntheticVariables";
	
	/**
	 * @since 2.6
	 */
	public static final String USE_OUTPUT_PER_SOURCE_FOLDER = "userOutputPerSourceFolder";
	
	/**
	 * @since 2.6
	 */
	public static final String SOURCE_FOLDER_TAG = "sourceFolder";
	
	/**
	 * @since 2.6
	 */
	public static final String IGNORE_SOURCE_FOLDER_TAG = "ignore";
	
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	private EclipseSourceFolderProvider sourceFolderProvider;
	
	@Inject private ProjectByResourceProvider projectProvider;

	public IPreferenceStoreAccess getPreferenceStoreAccess() {
		return preferenceStoreAccess;
	}

	@Inject
	public void setPreferenceStoreAccess(IPreferenceStoreAccess preferenceStoreAccess) {
		this.preferenceStoreAccess = preferenceStoreAccess;
	}
	
	/**
	 * @since 2.6
	 */
	@Inject(optional = true)
	public void setSourceFolderProvider(EclipseSourceFolderProvider sourceFolderProvider) {
		this.sourceFolderProvider = sourceFolderProvider;
	}

	@Inject
	public EclipseOutputConfigurationProvider(IOutputConfigurationProvider delegate) {
		super(delegate);
	}

	@Override
	public Set<OutputConfiguration> getOutputConfigurations(Resource resource) {
		IProject project = projectProvider.getProjectContext(resource);
		return getOutputConfigurations(project);
	}
	
	public Set<OutputConfiguration> getOutputConfigurations(IProject project) {
		IPreferenceStore store = getPreferenceStoreAccess().getContextPreferenceStore(project);
		Set<OutputConfiguration> outputConfigurations = new LinkedHashSet<OutputConfiguration>(getOutputConfigurations().size());
		for (OutputConfiguration output : getOutputConfigurations()) {
			OutputConfiguration configuration = createAndOverlayOutputConfiguration(project, store, output);
			outputConfigurations.add(configuration);
		}
		return outputConfigurations;
	}
	
	/**
	 * @deprecated use {@link #createAndOverlayOutputConfiguration(IProject, IPreferenceStore, OutputConfiguration)}
	 */
	@Deprecated
	protected OutputConfiguration createAndOverlayOutputConfiguration(IPreferenceStore store, OutputConfiguration output) {
		OutputConfiguration result = new OutputConfiguration(output.getName());
		boolean clearOutputDirectory = getBoolean(output, OUTPUT_CLEAN_DIRECTORY, store, output.isCanClearOutputDirectory());
		result.setCanClearOutputDirectory(clearOutputDirectory);
		boolean cleanUpDerivedResources = getBoolean(output, OUTPUT_CLEANUP_DERIVED, store, output.isCleanUpDerivedResources());
		result.setCleanUpDerivedResources(cleanUpDerivedResources);
		boolean createOutputDirectory = getBoolean(output, OUTPUT_CREATE_DIRECTORY, store, output.isCreateOutputDirectory());
		result.setCreateOutputDirectory(createOutputDirectory);
		boolean overrideExistingResources = getBoolean(output, OUTPUT_OVERRIDE, store, output.isOverrideExistingResources());
		result.setOverrideExistingResources(overrideExistingResources);
		boolean setDerivedProperty = getBoolean(output, OUTPUT_DERIVED, store, output.isSetDerivedProperty());
		result.setSetDerivedProperty(setDerivedProperty);
		boolean installDslAsPrimarySource = getBoolean(output, INSTALL_DSL_AS_PRIMARY_SOURCE, store, output.isInstallDslAsPrimarySource());
		result.setInstallDslAsPrimarySource(installDslAsPrimarySource);
		boolean hideSyntheticLocalVariables = getBoolean(output, HIDE_LOCAL_SYNTHETIC_VARIABLES, store, output.isHideSyntheticLocalVariables());
		result.setHideSyntheticLocalVariables(hideSyntheticLocalVariables);
		String description = getString(output, OUTPUT_DESCRIPTION, store, output.getDescription());
		result.setDescription(description);
		String directory = getString(output, OUTPUT_DIRECTORY, store, output.getOutputDirectory());
		result.setOutputDirectory(directory);
		boolean keepLocalHistory = getBoolean(output, OUTPUT_KEEP_LOCAL_HISTORY, store, output.isKeepLocalHistory());
		result.setKeepLocalHistory(keepLocalHistory);
		boolean useOutputPerSourceFolder = getBoolean(output, USE_OUTPUT_PER_SOURCE_FOLDER, store, output.isUseOutputPerSourceFolder());
		result.setUseOutputPerSourceFolder(useOutputPerSourceFolder);
		return result;
	}

	/**
	 * @since 2.6
	 */
	protected OutputConfiguration createAndOverlayOutputConfiguration(IProject project, IPreferenceStore store, OutputConfiguration output) {
		OutputConfiguration result = createAndOverlayOutputConfiguration(store, output);
		if (project != null && sourceFolderProvider != null) {
			for (IContainer sourceContainer : sourceFolderProvider.getSourceFolders(project)) {
				String sourceFolder = toProjectRelativePath(sourceContainer).toString();
				SourceMapping mapping = new SourceMapping(sourceFolder);
				mapping.setOutputDirectory(getOutputForSourceFolder(store, output, sourceFolder));
				mapping.setIgnore(isIgnoreSourceFolder(store, output, sourceFolder));
				result.getSourceMappings().add(mapping);
			}
		}
		return result;
	}
	
	private IPath toProjectRelativePath(IContainer source) {
		return source.getFullPath().makeRelativeTo(source.getProject().getFullPath());
	}

	private boolean getBoolean(OutputConfiguration outputConfiguration, String name, IPreferenceStore preferenceStore,
			Boolean defaultValue) {
		String preferenceKey = getKey(outputConfiguration, name);
		return preferenceStore.contains(preferenceKey) ? preferenceStore.getBoolean(preferenceKey) : defaultValue;
	}

	private String getString(OutputConfiguration outputConfiguration, String name, IPreferenceStore preferenceStore,
			String defaultValue) {
		String preferenceKey = getKey(outputConfiguration, name);
		return preferenceStore.contains(preferenceKey) ? preferenceStore.getString(preferenceKey) : defaultValue;
	}

	private String getKey(OutputConfiguration outputConfiguration, String preferenceName) {
		return OUTPUT_PREFERENCE_TAG + PreferenceConstants.SEPARATOR + outputConfiguration.getName()
				+ PreferenceConstants.SEPARATOR + preferenceName;
	}
	
	private String getOutputForSourceFolder(IPreferenceStore store ,OutputConfiguration outputConfiguration, String sourceFolder) {
		String key = getKey(outputConfiguration, SOURCE_FOLDER_TAG + PreferenceConstants.SEPARATOR + sourceFolder + PreferenceConstants.SEPARATOR + OUTPUT_DIRECTORY);
		return Strings.emptyToNull(store.getString(key));
	}
	
	private boolean isIgnoreSourceFolder(IPreferenceStore store ,OutputConfiguration outputConfiguration, String sourceFolder) {
		String key = getKey(outputConfiguration, SOURCE_FOLDER_TAG + PreferenceConstants.SEPARATOR + sourceFolder + PreferenceConstants.SEPARATOR + IGNORE_SOURCE_FOLDER_TAG);
		return store.contains(key)? store.getBoolean(key): false;
	}

}
