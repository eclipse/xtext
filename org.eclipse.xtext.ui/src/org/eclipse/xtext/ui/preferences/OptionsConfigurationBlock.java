/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 
 *******************************************************************************/
package org.eclipse.xtext.ui.preferences;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.ui.editor.preferences.PreferenceStoreAccessImpl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * Initially copied from jdt's OptionsConfigurationBlock
 * 
 * @author Michael Clay
 * @since 2.1
 */
public abstract class OptionsConfigurationBlock {
	@Inject
	AbstractUIPlugin uiPlugin;

	@Inject
	protected PreferenceStoreAccessImpl preferenceStoreAccessImpl;

	@Inject
	private IBuildPreferenceEvaluator buildPreferenceEvaluator;

	private static final String IS_PROJECT_SPECIFIC = "is_project_specific"; //$NON-NLS-1$
	private static final String SETTINGS_EXPANDED = "expanded"; //$NON-NLS-1$
	private static final String REBUILD_COUNT_KEY = "preferences_build_requested"; //$NON-NLS-1$

	protected static class ControlData {
		private String key;
		private String[] values;

		public ControlData(String key, String[] values) {
			this.key = key;
			this.values = values;
		}

		public String getKey() {
			return key;
		}

		public String getValue(boolean selection) {
			int index = selection ? 0 : 1;
			return values[index];
		}

		public String getValue(int index) {
			return values[index];
		}

		public int getSelection(String value) {
			if (value != null) {
				for (int i = 0; i < values.length; i++) {
					if (value.equals(values[i])) {
						return i;
					}
				}
			}
			return values.length - 1; // assume the last option is the least severe
		}
	}

	public static final class BuildJob extends Job {
		private final IProject project;

		public BuildJob(String name, IProject project) {
			super(name);
			this.project = project;
		}

		public boolean isCoveredBy(BuildJob other) {
			if (other.project == null) {
				return true;
			}
			return project != null && project.equals(other.project);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			synchronized (getClass()) {
				if (monitor.isCanceled()) {
					return Status.CANCEL_STATUS;
				}
				Job[] buildJobs = Job.getJobManager().find(ResourcesPlugin.FAMILY_MANUAL_BUILD);
				for (int i = 0; i < buildJobs.length; i++) {
					if (buildJobs[i] != this && buildJobs[i] instanceof BuildJob) {
						BuildJob job = (BuildJob) buildJobs[i];
						if (job.isCoveredBy(this)) {
							buildJobs[i].cancel();
						}
					}
				}
			}
			try {
				if (project != null) {
					monitor.beginTask(String.format(
							Messages.BuilderConfigurationBlock_BuildJob_TitleBuildProject_TaskName,
							TextProcessor.process(project.getName(), ":.")), //$NON-NLS-2$ //$NON-NLS-1$ //$NON-NLS-1$
							2);
					project.build(IncrementalProjectBuilder.FULL_BUILD, SubMonitor.convert(monitor, 1));
					ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.INCREMENTAL_BUILD,
							SubMonitor.convert(monitor, 1));
				} else {
					monitor.beginTask(Messages.BuilderConfigurationBlock_BuildJob_TitleBuildAll_TaskName, 2);
					ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD,
							SubMonitor.convert(monitor, 2));
				}
			} catch (CoreException e) {
				return e.getStatus();
			} catch (OperationCanceledException e) {
				return Status.CANCEL_STATUS;
			} finally {
				monitor.done();
			}
			return Status.OK_STATUS;
		}

		@Override
		public boolean belongsTo(Object family) {
			return ResourcesPlugin.FAMILY_MANUAL_BUILD == family;
		}
	}

	protected final List<Button> checkBoxes = Lists.newArrayList();
	protected final List<Text> textBoxes = Lists.newArrayList();
	protected final List<Combo> comboBoxes = Lists.newArrayList();
	protected final Map<Control, Label> labels = Maps.newHashMap();
	protected final List<ExpandableComposite> expandedComposites = Lists.newArrayList();
	private SelectionListener selectionListener;
	private ModifyListener textModifyListener;
	protected IStatusChangeListener statusChangeListener;
	protected IProject project;
	protected String[] keys;
	private Shell shell;
	private Map<String, String> disabledProjectSettings;
	private Map<String, String> originalSettings = Collections.emptyMap();
	private int rebuildCount;
	private IPreferenceStore preferenceStore;
	private IWorkbenchPreferenceContainer workbenchPreferenceContainer;

	private List<String> keysToRegister = Lists.newArrayList();

	public IProject getProject() {
		return project;
	}

	public void setStatusChangeListener(IStatusChangeListener fContext) {
		this.statusChangeListener = fContext;
	}

	public OptionsConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			IWorkbenchPreferenceContainer container) {
		this.project = project;
		this.keys = new String[] {};
		this.setPreferenceStore(preferenceStore);
		this.workbenchPreferenceContainer = container;
	}

	public OptionsConfigurationBlock() {
		this.keys = new String[] {};
	}

	public void setWorkbenchPreferenceContainer(IWorkbenchPreferenceContainer workbenchPreferenceContainer) {
		this.workbenchPreferenceContainer = workbenchPreferenceContainer;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		this.preferenceStore = preferenceStore;
		this.rebuildCount = getRebuildCount();
	}

	private void updateDisabledProjSettings(IProject project, IPreferenceStore preferenceStore, String[] allKeys) {
		if (project == null || hasProjectSpecificOptions(project)) {
			disabledProjectSettings = null;
		} else {
			disabledProjectSettings = Maps.newHashMap();
			for (String key : allKeys) {
				disabledProjectSettings.put(key, preferenceStore.getString(key));
			}
		}
	}

	public boolean hasProjectSpecificOptions(IProject project) {
		IPreferenceStore ps = preferenceStore;
		if (project != getProject()) {
			ps = preferenceStoreAccessImpl.getWritablePreferenceStore(project);
		}
		// backward compatibility
		boolean oldSettingsUsed = ps.getBoolean(IS_PROJECT_SPECIFIC);
		boolean newSettingsValue = ps.getBoolean(getIsProjectSpecificPropertyKey(getPropertyPrefix()));
		if (oldSettingsUsed) {
			if (!newSettingsValue) {
				ps.setValue(getIsProjectSpecificPropertyKey(getPropertyPrefix()), true);
				return true;
			}
		}
		return newSettingsValue;
	}

	protected void setShell(Shell shell) {
		this.shell = shell;
	}

	protected Shell getShell() {
		return shell;
	}

	public final Control createContents(Composite parent) {
		Control content = doCreateContents(parent);
		collectRegistredKeys();
		updateDisabledProjSettings(project, preferenceStore, keys);
		captureOriginalSettings(keys);
		return content;
	}

	protected abstract Control doCreateContents(Composite parent);

	protected Button addCheckBox(Composite parent, String label, String key, String[] values, int indent) {
		ControlData data = new ControlData(key, values);
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd.horizontalSpan = 3;
		gd.horizontalIndent = indent;
		return addCheckboxWithData(parent, label, data, gd);
	}

	protected Button addCheckboxWithData(Composite parent, String label, ControlData data, GridData gd) {
		Button checkBox = new Button(parent, SWT.CHECK);
		checkBox.setFont(JFaceResources.getDialogFont());
		checkBox.setText(label);
		checkBox.setData(data);
		checkBox.setLayoutData(gd);
		checkBox.addSelectionListener(getSelectionListener());
		makeScrollableCompositeAware(checkBox);
		updateCheckBox(checkBox);
		checkBoxes.add(checkBox);
		return checkBox;
	}

	protected Text addTextField(Composite parent, String label, String key, int indent, int widthHint) {
		Label labelControl = new Label(parent, SWT.WRAP);
		labelControl.setText(label);
		labelControl.setFont(JFaceResources.getDialogFont());
		GridData labelLayoutData = new GridData();
		labelLayoutData.horizontalIndent = indent;
		labelControl.setLayoutData(labelLayoutData);
		Text textBox = new Text(parent, SWT.BORDER | SWT.SINGLE);
		textBox.setData(key);
		makeScrollableCompositeAware(textBox);
		labels.put(textBox, labelControl);
		updateText(textBox);
		textBox.addModifyListener(getTextModifyListener());

		GridData textLayoutData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
		if (widthHint != 0) {
			textLayoutData.widthHint = widthHint;
		}
		textBox.setLayoutData(textLayoutData);
		textBoxes.add(textBox);
		return textBox;
	}

	protected Combo addComboBox(Composite parent, String label, String key, int indent, String[] values,
			String[] valueLabels) {
		GridData gd = new GridData(GridData.FILL, GridData.CENTER, true, false, 2, 1);
		gd.horizontalIndent = indent;

		Label labelControl = new Label(parent, SWT.LEFT);
		labelControl.setFont(JFaceResources.getDialogFont());
		labelControl.setText(label);
		labelControl.setLayoutData(gd);

		Combo comboBox = newComboControl(parent, key, values, valueLabels);
		comboBox.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));

		labels.put(comboBox, labelControl);

		return comboBox;
	}

	protected Combo newComboControl(Composite composite, String key, String[] values, String[] valueLabels) {
		ControlData data = new ControlData(key, values);

		Combo comboBox = new Combo(composite, SWT.READ_ONLY);
		comboBox.setItems(valueLabels);
		comboBox.setData(data);
		comboBox.addSelectionListener(getSelectionListener());
		comboBox.setFont(JFaceResources.getDialogFont());
		comboBox.setVisibleItemCount(30);

		makeScrollableCompositeAware(comboBox);

		updateCombo(comboBox);

		comboBoxes.add(comboBox);
		return comboBox;
	}

	private ScrolledPageContent getParentScrolledComposite(Control control) {
		Control parent = control.getParent();
		while (!(parent instanceof ScrolledPageContent) && parent != null) {
			parent = parent.getParent();
		}
		if (parent instanceof ScrolledPageContent) {
			return (ScrolledPageContent) parent;
		}
		return null;
	}

	private void makeScrollableCompositeAware(Control control) {
		ScrolledPageContent parentScrolledComposite = getParentScrolledComposite(control);
		if (parentScrolledComposite != null) {
			parentScrolledComposite.adaptChild(control);
		}
	}

	protected ExpandableComposite createStyleSection(Composite parent, String label, int nColumns) {
		ExpandableComposite excomposite = new ExpandableComposite(parent, SWT.NONE, ExpandableComposite.TWISTIE
				| ExpandableComposite.CLIENT_INDENT);
		excomposite.setText(label);
		excomposite.setExpanded(false);
		excomposite.setFont(JFaceResources.getFontRegistry().getBold(JFaceResources.DIALOG_FONT));
		excomposite.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false, nColumns, 1));
		excomposite.addExpansionListener(new ExpansionAdapter() {
			@Override
			public void expansionStateChanged(ExpansionEvent e) {
				expandedStateChanged((ExpandableComposite) e.getSource());
			}
		});
		expandedComposites.add(excomposite);
		makeScrollableCompositeAware(excomposite);
		return excomposite;
	}

	protected final void expandedStateChanged(ExpandableComposite expandable) {
		ScrolledPageContent parentScrolledComposite = getParentScrolledComposite(expandable);
		if (parentScrolledComposite != null) {
			parentScrolledComposite.reflow(true);
		}
	}

	protected void restoreSectionExpansionStates(IDialogSettings settings) {
		for (int i = 0; i < expandedComposites.size(); i++) {
			ExpandableComposite excomposite = expandedComposites.get(i);
			if (settings == null) {
				excomposite.setExpanded(i == 0); // only expand the first node by default
			} else {
				excomposite.setExpanded(settings.getBoolean(SETTINGS_EXPANDED + String.valueOf(i)));
			}
		}
	}

	protected void storeSectionExpansionStates(IDialogSettings settings) {
		for (int i = 0; i < expandedComposites.size(); i++) {
			ExpandableComposite curr = expandedComposites.get(i);
			settings.put(SETTINGS_EXPANDED + String.valueOf(i), curr.isExpanded());
		}
	}

	protected SelectionListener getSelectionListener() {
		if (selectionListener == null) {
			selectionListener = new SelectionListener() {
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}

				@Override
				public void widgetSelected(SelectionEvent e) {
					controlChanged(e.widget);
				}
			};
		}
		return selectionListener;
	}

	protected ModifyListener getTextModifyListener() {
		if (textModifyListener == null) {
			textModifyListener = new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					textChanged((Text) e.widget);
				}
			};
		}
		return textModifyListener;
	}

	protected void controlChanged(Widget widget) {
		ControlData data = (ControlData) widget.getData();
		String newValue = null;
		if (widget instanceof Button) {
			newValue = data.getValue(((Button) widget).getSelection());
		} else if (widget instanceof Combo) {
			newValue = data.getValue(((Combo) widget).getSelectionIndex());
		} else {
			return;
		}
		String oldValue = setValue(data.getKey(), newValue);
		validateSettings(data.getKey(), oldValue, newValue);
	}

	protected void textChanged(Text textControl) {
		String key = (String) textControl.getData();
		String number = textControl.getText();
		String oldValue = setValue(key, number);
		validateSettings(key, oldValue, number);
	}

	protected String getValue(String key) {
		if (disabledProjectSettings != null) {
			return disabledProjectSettings.get(key);
		}
		return preferenceStore.getString(key);
	}

	protected String setValue(String key, String value) {
		if (disabledProjectSettings != null) {
			return disabledProjectSettings.put(key, value);
		}
		String oldValue = getValue(key);
		preferenceStore.putValue(key, value);
		return oldValue;
	}

	protected String setToDefault(String key) {
		String value = preferenceStore.getDefaultString(key);
		if (disabledProjectSettings != null) {
			return disabledProjectSettings.put(key, value);
		}
		String oldValue = getValue(key);
		preferenceStore.setValue(key, value);
		return oldValue;
	}

	public void useProjectSpecificSettings(boolean enable) {
		boolean hasProjectSpecificOption = disabledProjectSettings == null;
		if (enable != hasProjectSpecificOption && project != null) {
			if (enable) {
				for (int i = 0; i < keys.length; i++) {
					String curr = keys[i];
					String val = disabledProjectSettings.get(curr);
					preferenceStore.putValue(curr, val);
				}
				disabledProjectSettings = null;
				updateControls();
				validateSettings(null, null, null);
				preferenceStore.setValue(getIsProjectSpecificPropertyKey(getPropertyPrefix()), true);
			} else {
				disabledProjectSettings = Maps.newHashMap();
				for (int i = 0; i < keys.length; i++) {
					String curr = keys[i];
					String oldSetting = preferenceStore.getString(curr);
					disabledProjectSettings.put(curr, oldSetting);
					preferenceStore.setToDefault(curr);
				}
				preferenceStore.setToDefault(getIsProjectSpecificPropertyKey(getPropertyPrefix()));
				//backward compatibility
				preferenceStore.setToDefault(IS_PROJECT_SPECIFIC);
			}
		}
	}

	public boolean performOk() {
		return processChanges(workbenchPreferenceContainer);
	}

	public boolean performApply() {
		return processChanges(workbenchPreferenceContainer);
	}

	private int getRebuildCount() {
		return preferenceStore.getDefaultInt(REBUILD_COUNT_KEY);
	}

	private void incrementRebuildCount() {
		preferenceStore.setDefault(REBUILD_COUNT_KEY, getRebuildCount() + 1);
	}

	protected boolean processChanges(IWorkbenchPreferenceContainer container) {
		boolean needsBuild = buildPreferenceEvaluator.isAffectingBuild(getPreferenceChanges());
		boolean doBuild = false;
		if (needsBuild) {
			int count = getRebuildCount();
			if (count > rebuildCount) {
				needsBuild = false;
				rebuildCount = count;
			}
		}
		if (needsBuild) {
			String[] strings = getFullBuildDialogStrings(project == null);
			if (strings != null) {
				MessageDialog dialog = new MessageDialog(shell, strings[0], null, strings[1], MessageDialog.QUESTION,
						new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL,
								IDialogConstants.CANCEL_LABEL }, 2);
				int res = dialog.open();
				if (res == 0) {
					doBuild = true;
				} else if (res != 1) {
					return false;
				}
			}
		}
		savePreferences();
		if (container != null) {
			if (doBuild) {
				incrementRebuildCount();
				container.registerUpdateJob(getBuildJob(getProject()));
			}
		} else {
			if (doBuild) {
				getBuildJob(getProject()).schedule();
			}
		}
		captureOriginalSettings(keys);
		return true;
	}

	protected void savePreferences() {
		try {
			if (preferenceStore instanceof IPersistentPreferenceStore) {
				((IPersistentPreferenceStore) preferenceStore).save();
			}
		} catch (IOException e) {
			logError("Unexpected internal error: ", e); //$NON-NLS-1$
		}
	}

	private void logError(String text, IOException e) {
		IStatus status = new Status(IStatus.ERROR, uiPlugin.getBundle().getSymbolicName(), text, e);
		uiPlugin.getLog().log(status);
	}

	public Map<String, ValueDifference<String>> getPreferenceChanges() {
		Map<String, String> currentSettings = Maps.newHashMapWithExpectedSize(keys.length);
		for (String key : keys) {
			currentSettings.put(key, preferenceStore.getString(key));
		}
		MapDifference<String, String> mapDifference = Maps.difference(currentSettings, originalSettings);
		Map<String, ValueDifference<String>> entriesDiffering = mapDifference.entriesDiffering();
		return entriesDiffering;
	}

	protected abstract Job getBuildJob(IProject project);

	protected abstract String[] getFullBuildDialogStrings(boolean workspaceSettings);

	public void performDefaults() {
		for (int i = 0; i < keys.length; i++) {
			String curr = keys[i];
			setToDefault(curr);
		}
		updateControls();
		validateSettings(null, null, null);
	}

	public void dispose() {
	}

	protected void updateControls() {
		for (int i = comboBoxes.size() - 1; i >= 0; i--) {
			updateCombo(comboBoxes.get(i));
		}
		for (int i = checkBoxes.size() - 1; i >= 0; i--) {
			updateCheckBox(checkBoxes.get(i));
		}
		for (int i = textBoxes.size() - 1; i >= 0; i--) {
			updateText(textBoxes.get(i));
		}
	}

	protected void collectRegistredKeys() {
		List<String> collectedKeys = Lists.newArrayList();
		for (Combo combo : comboBoxes) {
			ControlData data = (ControlData) combo.getData();
			collectedKeys.add(data.getKey());
		}
		for (Button button : checkBoxes) {
			ControlData data = (ControlData) button.getData();
			collectedKeys.add(data.getKey());
		}
		for (Text textField : textBoxes) {
			collectedKeys.add((String) textField.getData());
		}
		collectedKeys.addAll(keysToRegister);
		this.keys = Iterables.toArray(collectedKeys, String.class);
	}

	protected void updateCombo(Combo curr) {
		ControlData data = (ControlData) curr.getData();
		String currValue = getValue(data.getKey());
		int selection = data.getSelection(currValue);
		curr.select(selection);
	}

	protected void updateCheckBox(Button curr) {
		ControlData data = (ControlData) curr.getData();
		curr.setSelection(checkBoxValue(data));
	}

	private boolean checkBoxValue(ControlData data) {
		String currValue = getValue(data.getKey());
		boolean selection = data.getSelection(currValue) == 0;
		return selection;
	}

	protected void updateText(Text curr) {
		String key = (String) curr.getData();
		String currValue = getValue(key);
		if (currValue != null) {
			curr.setText(currValue);
		}
	}

	protected abstract void validateSettings(String changedKey, String oldValue, String newValue);

	private void captureOriginalSettings(String[] keys) {
		originalSettings = Maps.newHashMapWithExpectedSize(keys.length);
		for (String key : keys) {
			originalSettings.put(key, preferenceStore.getString(key));
		}
	}

	protected void registerKey(String key) {
		keysToRegister.add(key);
	}

	public abstract String getPropertyPrefix();

	public String getIsProjectSpecificPropertyKey(String propertyPrefix) {
		String key = IS_PROJECT_SPECIFIC;
		if (propertyPrefix != null) {
			key = isProjectSpecificPropertyKey(propertyPrefix);
		} else {
			logError("Project specific key is not qualified", null);
		}
		return key;
	}

	public static String isProjectSpecificPropertyKey(String propertyPrefix) {
		return propertyPrefix + "." + IS_PROJECT_SPECIFIC;
	}
}
