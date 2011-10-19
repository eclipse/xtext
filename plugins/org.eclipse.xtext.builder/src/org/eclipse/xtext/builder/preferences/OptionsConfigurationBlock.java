/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.DefaultScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.xtext.util.Strings;
import org.osgi.service.prefs.BackingStoreException;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Initially copied from jdt's OptionsConfigurationBlock
 * 
 * @author Michael Clay
 * @since 2.1
 */
public abstract class OptionsConfigurationBlock {

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

	private static final String REBUILD_COUNT_KEY = "preferences_build_requested"; //$NON-NLS-1$
	private static final String SETTINGS_EXPANDED = "expanded"; //$NON-NLS-1$
	protected final List<Button> checkBoxes = Lists.newArrayList();
	protected final List<Text> textBoxes = Lists.newArrayList();
	protected final Map<Control, Label> labels = Maps.newHashMap();
	protected final List<ExpandableComposite> expandedComposites = Lists.newArrayList();
	private SelectionListener selectionListener;
	private ModifyListener textModifyListener;
	protected IStatusChangeListener statusChangeListener;
	protected final IProject project;
	protected final String[] keys;
	private Shell shell;
	private Map<String, String> disabledProjectSettings;
	private int rebuildCount;
	private WorkingCopyPreferencesAccess workingCopyPreferencesAccess;
	private IWorkbenchPreferenceContainer workbenchPreferenceContainer;

	public IProject getProject() {
		return project;
	}

	public void setStatusChangeListener(IStatusChangeListener fContext) {
		this.statusChangeListener = fContext;
	}

	public OptionsConfigurationBlock(IProject project, String[] allKeys,
			WorkingCopyPreferencesAccess workingCopyPreferencesAccess, IWorkbenchPreferenceContainer container) {
		this.project = project;
		this.keys = allKeys;
		this.workingCopyPreferencesAccess = workingCopyPreferencesAccess;
		this.workbenchPreferenceContainer = container;
		if (project == null || hasProjectSpecificOptions(project)) {
			disabledProjectSettings = null;
		} else {
			disabledProjectSettings = Maps.newIdentityHashMap();
			for (String key : allKeys) {
				disabledProjectSettings.put(key, workingCopyPreferencesAccess.getValue(key));
			}
		}
		rebuildCount = getRebuildCount();
	}

	public boolean hasProjectSpecificOptions(IProject project) {
		if (project != null) {
			IScopeContext projectContext = new ProjectScope(project);
			for (int i = 0; i < keys.length; i++) {
				if (workingCopyPreferencesAccess.getValue(keys[i], projectContext) != null) {
					return true;
				}
			}
		}
		return false;
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
		return workingCopyPreferencesAccess.getValue(key);
	}

	protected String setValue(String key, String value) {
		if (disabledProjectSettings != null) {
			return disabledProjectSettings.put(key, value);
		}
		String oldValue = getValue(key);
		workingCopyPreferencesAccess.setValue(key, value);
		return oldValue;
	}

	private boolean getChanges(IScopeContext currContext, List<String> changedSettings) {
		boolean completeSettings = project != null && disabledProjectSettings == null; // complete when project settings are enabled
		boolean needsBuild = false;
		for (int i = 0; i < keys.length; i++) {
			String key = keys[i];
			String oldVal = workingCopyPreferencesAccess.getOriginalValue(key, currContext);
			String val = workingCopyPreferencesAccess.getValue(key, currContext);
			String defaultValue = workingCopyPreferencesAccess.getDefaultValue(key);
			if (val == null) {
				if (oldVal != null) {
					changedSettings.add(key);
					needsBuild |= !oldVal.equals(defaultValue);
				} else if (completeSettings) {
					workingCopyPreferencesAccess.setValue(key, currContext, defaultValue);
					changedSettings.add(key);
					// no build needed
				}
			} else if (!val.equals(oldVal)) {
				changedSettings.add(key);
				needsBuild |= oldVal != null || !val.equals(defaultValue);
			}
		}
		return needsBuild;
	}

	public void useProjectSpecificSettings(boolean enable) {
		boolean hasProjectSpecificOption = disabledProjectSettings == null;
		if (enable != hasProjectSpecificOption && project != null) {
			if (enable) {
				for (int i = 0; i < keys.length; i++) {
					String curr = keys[i];
					String val = disabledProjectSettings.get(curr);
					workingCopyPreferencesAccess.setValue(curr, val);
				}
				disabledProjectSettings = null;
				updateControls();
				validateSettings(null, null, null);
			} else {
				disabledProjectSettings = Maps.newIdentityHashMap();
				for (int i = 0; i < keys.length; i++) {
					String curr = keys[i];
					String oldSetting = workingCopyPreferencesAccess.getValue(curr);
					disabledProjectSettings.put(curr, oldSetting);
					workingCopyPreferencesAccess.setValue(curr, null); // clear project settings
				}
			}
		}
	}

	public boolean performOk() {
		return processChanges(false);
	}

	public boolean performApply() {
		return processChanges(true);
	}

	private int getRebuildCount() {
		int result = 0;
		String value = workingCopyPreferencesAccess.getValue(REBUILD_COUNT_KEY, new DefaultScope());
		if (!Strings.isEmpty(value)) {
			result = Integer.valueOf(value);
		}
		return result;
	}

	private void incrementRebuildCount() {
		rebuildCount++;
		workingCopyPreferencesAccess.setValue(REBUILD_COUNT_KEY, new DefaultScope(), String.valueOf(rebuildCount));
	}

	protected boolean processChanges(boolean applyDirect) {
		IScopeContext currContext = project != null ? new ProjectScope(project) : new InstanceScope();
		List<String> changedOptions = Lists.newArrayList();
		boolean needsBuild = getChanges(currContext, changedOptions);
		if (changedOptions.isEmpty()) {
			return true;
		}
		if (needsBuild) {
			int count = getRebuildCount();
			if (count > rebuildCount) {
				needsBuild = false; // build already requested
				rebuildCount = count;
			}
		}

		boolean doBuild = false;
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
		if (!applyDirect) {
			if (doBuild) {
				incrementRebuildCount();
				workbenchPreferenceContainer.registerUpdateJob(getBuildJob(getProject()));
			}
		} else {
			try {
				workingCopyPreferencesAccess.applyChanges();
			} catch (BackingStoreException e) {
				Activator.log(e);
				return false;
			}
			if (doBuild) {
				getBuildJob(getProject()).schedule();
			}

		}
		return true;
	}

	protected abstract Job getBuildJob(IProject project);

	protected abstract String[] getFullBuildDialogStrings(boolean workspaceSettings);

	public void performDefaults() {
		for (int i = 0; i < keys.length; i++) {
			String curr = keys[i];
			String defValue = workingCopyPreferencesAccess.getDefaultValue(curr);
			setValue(curr, defValue);
		}
		updateControls();
		validateSettings(null, null, null);
	}

	public void dispose() {
	}

	/**
	 * Updates the UI from the current settings. Must be called whenever a setting has been changed by code.
	 */
	protected void updateControls() {
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

}
