/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPersistentPreferenceStore;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
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
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.builder.internal.Activator;
import org.eclipse.xtext.validation.IssueCode;

import com.google.common.collect.Lists;
import com.google.common.collect.MapDifference;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.collect.Maps;

/**
 * Initially copied from jdt's OptionsConfigurationBlock
 * 
 * @author Michael Clay
 * @since 2.1
 */
public abstract class OptionsConfigurationBlock {

	public static final String IS_PROJECT_SPECIFIC = "is_project_specific"; //$NON-NLS-1$
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

	protected final List<Button> checkBoxes = Lists.newArrayList();
	protected final List<Text> textBoxes = Lists.newArrayList();
	protected final List<Combo> comboBoxes = Lists.newArrayList();
	protected final Map<Control, Label> labels = Maps.newHashMap();
	protected final List<ExpandableComposite> expandedComposites = Lists.newArrayList();
	private SelectionListener selectionListener;
	private ModifyListener textModifyListener;
	protected IStatusChangeListener statusChangeListener;
	protected final IProject project;
	protected final String[] keys;
	private Shell shell;
	private Map<String, String> disabledProjectSettings;
	private Map<String, String> originalSettings;
	private int rebuildCount;
	private IPreferenceStore preferenceStore;
	private IWorkbenchPreferenceContainer workbenchPreferenceContainer;

	public IProject getProject() {
		return project;
	}

	public void setStatusChangeListener(IStatusChangeListener fContext) {
		this.statusChangeListener = fContext;
	}

	public OptionsConfigurationBlock(IProject project, String[] allKeys, IPreferenceStore preferenceStore,
			IWorkbenchPreferenceContainer container) {
		this.project = project;
		this.keys = allKeys;
		this.preferenceStore = preferenceStore;
		this.rebuildCount = getRebuildCount();
		this.workbenchPreferenceContainer = container;
		if (project == null || hasProjectSpecificOptions(project)) {
			disabledProjectSettings = null;
		} else {
			disabledProjectSettings = Maps.newHashMap();
			for (String key : allKeys) {
				disabledProjectSettings.put(key, preferenceStore.getString(key));
			}
		}
		captureOriginalSettings();
	}

	public boolean hasProjectSpecificOptions(IProject project) {
		return preferenceStore.getBoolean(IS_PROJECT_SPECIFIC);
	}

	protected void setShell(Shell shell) {
		this.shell = shell;
	}

	protected abstract Control createContents(Composite parent);

	protected Button addCheckBox(Composite parent, String label, String key, String[] values, int indent) {
		ControlData data = new ControlData(key, values);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = 3;
		gd.horizontalIndent = indent;
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
		labelControl.setLayoutData(new GridData());
		Text textBox = new Text(parent, SWT.BORDER | SWT.SINGLE);
		textBox.setData(key);
		textBox.setLayoutData(new GridData());
		makeScrollableCompositeAware(textBox);
		labels.put(textBox, labelControl);
		updateText(textBox);
		textBox.addModifyListener(getTextModifyListener());

		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		if (widthHint != 0) {
			data.widthHint = widthHint;
		}
		data.horizontalIndent = indent;
		data.horizontalSpan = 2;
		textBox.setLayoutData(data);
		textBoxes.add(textBox);
		return textBox;
	}
	
	protected Combo addComboBox(Composite parent, String label, String code, String[] errorWarningIgnore,
			String[] errorWarningIgnoreLabels, int indent) {
		
		GridData gd = new GridData(GridData.FILL, GridData.CENTER, true, false, 2, 1);
		gd.horizontalIndent = indent;

		Label labelControl = new Label(parent, SWT.LEFT);
		labelControl.setFont(JFaceResources.getDialogFont());
		labelControl.setText(label);
		labelControl.setLayoutData(gd);
		
		String[] values = new String[] { "Error", "Warning", "Ignore" };
		String[] valueLabels = new String[] { "Error", "Warning", "Ignore" };
//		if (issueCode.hasJavaEqivalent()) {
//			values = new String[] { "Error", "Warning", "Ignore", "Java" };
//			valueLabels = new String[] { "Error", "Warning", "Ignore", "reuse Java" };
//		}

		Combo comboBox = newComboControl(parent, code, values, valueLabels);
		comboBox.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

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

		makeScrollableCompositeAware(comboBox);

		updateCombo(comboBox);

		comboBoxes.add(comboBox);
		return comboBox;
	}

	protected void updateCombo(Combo curr) {
		ControlData data = (ControlData) curr.getData();

		String currValue = getValue(data.getKey());
		curr.select(data.getSelection(currValue));
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
				public void widgetDefaultSelected(SelectionEvent e) {
				}

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
				preferenceStore.setValue(IS_PROJECT_SPECIFIC, true);
			} else {
				disabledProjectSettings = Maps.newHashMap();
				for (int i = 0; i < keys.length; i++) {
					String curr = keys[i];
					String oldSetting = preferenceStore.getString(curr);
					disabledProjectSettings.put(curr, oldSetting);
					preferenceStore.setToDefault(curr);
				}
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
		boolean needsBuild = !getPreferenceChanges().isEmpty();
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
		captureOriginalSettings();
		return true;
	}

	protected void savePreferences() {
		try {
			if (preferenceStore instanceof IPersistentPreferenceStore) {
				((IPersistentPreferenceStore) preferenceStore).save();
			}
		} catch (IOException e) {
			Activator.log(e);
		}
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
			String defValue = preferenceStore.getDefaultString(curr);
			setValue(curr, defValue);
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

	protected void updateCheckBox(Button curr) {
		ControlData data = (ControlData) curr.getData();
		String currValue = getValue(data.getKey());
		curr.setSelection(data.getSelection(currValue) == 0);
	}

	protected void updateText(Text curr) {
		String key = (String) curr.getData();
		String currValue = getValue(key);
		if (currValue != null) {
			curr.setText(currValue);
		}
	}

	protected abstract void validateSettings(String changedKey, String oldValue, String newValue);

	private void captureOriginalSettings() {
		originalSettings = Maps.newHashMapWithExpectedSize(keys.length);
		for (String key : keys) {
			originalSettings.put(key, preferenceStore.getString(key));
		}
	}

}
