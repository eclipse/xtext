/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.builder.internal.Activator;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;
import org.eclipse.xtext.ui.preferences.ScrolledPageContent;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class BuilderConfigurationBlock extends OptionsConfigurationBlock {
	private static final String SETTINGS_SECTION_NAME = "BuilderConfigurationBlock"; //$NON-NLS-1$

	private EclipseOutputConfigurationProvider configurationProvider;

	public BuilderConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			EclipseOutputConfigurationProvider configurationProvider, IWorkbenchPreferenceContainer container) {
		super(project, preferenceStore, container);
		this.configurationProvider = configurationProvider;
	}

//	private static String[] getKeys(IProject project, EclipseOutputConfigurationProvider configurationProvider) {
//		Set<String> keys = Sets.newHashSet(BuilderPreferenceAccess.PREF_AUTO_BUILDING, OptionsConfigurationBlock.IS_PROJECT_SPECIFIC);
//		Set<OutputConfiguration> outputConfigurations = configurationProvider.getOutputConfigurations(project);
//		for (OutputConfiguration outputConfiguration : outputConfigurations) {
//			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
//					EclipseOutputConfigurationProvider.OUTPUT_DIRECTORY));
//			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
//					EclipseOutputConfigurationProvider.OUTPUT_CREATE_DIRECTORY));
//			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
//					EclipseOutputConfigurationProvider.OUTPUT_CLEAN_DIRECTORY));
//			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
//					EclipseOutputConfigurationProvider.OUTPUT_OVERRIDE));
//			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
//					EclipseOutputConfigurationProvider.OUTPUT_DERIVED));
//			keys.add(BuilderPreferenceAccess.getKey(outputConfiguration,
//					EclipseOutputConfigurationProvider.OUTPUT_CLEANUP_DERIVED));
//		}
//		return keys.toArray(new String[] {});
//	}

	@Override
	protected Control doCreateContents(Composite parent) {
		PixelConverter pixelConverter = new PixelConverter(parent);
		setShell(parent.getShell());
		Composite mainComp = new Composite(parent, SWT.NONE);
		mainComp.setFont(parent.getFont());
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		mainComp.setLayout(layout);
		Composite othersComposite = createBuildPathTabContent(mainComp);
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.heightHint = pixelConverter.convertHeightInCharsToPixels(20);
		othersComposite.setLayoutData(gridData);
		validateSettings(null, null, null);
		return mainComp;
	}

	private Composite createBuildPathTabContent(Composite parent) {
		String[] trueFalseValues = new String[] { IPreferenceStore.TRUE, IPreferenceStore.FALSE };
		int columns = 3;
		final ScrolledPageContent pageContent = new ScrolledPageContent(parent);
		GridLayout layout = new GridLayout();
		layout.numColumns = columns;
		layout.marginHeight = 0;
		layout.marginWidth = 0;

		Composite composite = pageContent.getBody();
		composite.setLayout(layout);
		String label = Messages.BuilderConfigurationBlock_GeneralSection_Label;
		ExpandableComposite excomposite = createStyleSection(composite, label, columns);

		Composite othersComposite = new Composite(excomposite, SWT.NONE);
		excomposite.setClient(othersComposite);
		othersComposite.setLayout(new GridLayout(columns, false));

		addCheckBox(othersComposite, Messages.BuilderPreferencePage_GenerateAuto,
				BuilderPreferenceAccess.PREF_AUTO_BUILDING, trueFalseValues, 0);

		Set<OutputConfiguration> outputConfigurations = configurationProvider.getOutputConfigurations(getProject());

		for (OutputConfiguration outputConfiguration : outputConfigurations) {
			label = outputConfiguration.getDescription();
			excomposite = createStyleSection(composite, label, columns);
			othersComposite = new Composite(excomposite, SWT.NONE);
			excomposite.setClient(othersComposite);
			othersComposite.setLayout(new GridLayout(columns, false));
			addTextField(othersComposite, Messages.OutputConfigurationPage_Directory,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_DIRECTORY), 0, 200);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_CreateDirectory,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_CREATE_DIRECTORY), trueFalseValues, 0);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_OverrideExistingResources,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_OVERRIDE), trueFalseValues, 0);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_CreatesDerivedResources,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_DERIVED), trueFalseValues, 0);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_CleanupDerivedResources,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_CLEANUP_DERIVED), trueFalseValues, 0);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_CleanDirectory,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_CLEAN_DIRECTORY), trueFalseValues, 0);
			final Button installAsPrimaryButton = addCheckBox(othersComposite, Messages.BuilderConfigurationBlock_InstallDslAsPrimarySource,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.INSTALL_DSL_AS_PRIMARY_SOURCE), trueFalseValues, 0);
			final Button hideLocalButton = addCheckBox(othersComposite, Messages.BuilderConfigurationBlock_hideSyntheticLocalVariables,
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.HIDE_LOCAL_SYNTHETIC_VARIABLES), trueFalseValues, 0);
			hideLocalButton.setEnabled(installAsPrimaryButton.getSelection());
			installAsPrimaryButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					hideLocalButton.setEnabled(installAsPrimaryButton.getSelection());
				}
			});
			GridData hideLocalButtonData = new GridData();
			hideLocalButtonData.horizontalIndent = 32;
			hideLocalButton.setLayoutData(hideLocalButtonData);
			addCheckBox(othersComposite, Messages.OutputConfigurationPage_KeepLocalHistory, 
					BuilderPreferenceAccess.getKey(outputConfiguration,
							EclipseOutputConfigurationProvider.OUTPUT_KEEP_LOCAL_HISTORY), trueFalseValues, 0);
		}
		registerKey(OptionsConfigurationBlock.IS_PROJECT_SPECIFIC);
		IDialogSettings section = Activator.getDefault().getDialogSettings().getSection(SETTINGS_SECTION_NAME);
		restoreSectionExpansionStates(section);
		return pageContent;
	}

	@Override
	protected void validateSettings(String changedKey, String oldValue, String newValue) {
	}

	@Override
	public void dispose() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings().addNewSection(SETTINGS_SECTION_NAME);
		storeSectionExpansionStates(settings);
		super.dispose();
	}

	@Override
	protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
		String title = Messages.BuilderConfigurationBlock_SettingsChanged_Title;
		String message;
		if (workspaceSettings) {
			message = Messages.BuilderConfigurationBlock_SettingsChanged_WorkspaceBuild;
		} else {
			message = Messages.BuilderConfigurationBlock_SettingsChanged_ProjectBuild;
		}
		return new String[] { title, message };
	}

	@Override
	protected Job getBuildJob(IProject project) {
		Job buildJob = new OptionsConfigurationBlock.BuildJob(Messages.BuilderConfigurationBlock_BuildJob_Title0, project);
		buildJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
		buildJob.setUser(true);
		return buildJob;
	}

}
