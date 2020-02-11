/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks.preferences;

import static org.eclipse.xtext.tasks.PreferenceTaskTagProvider.*;
import static org.eclipse.xtext.ui.tasks.preferences.TaskTagInputDialog.*;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.DialogField;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.IDialogFieldListener;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.IListAdapter;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.ListDialogField;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.SelectionButtonDialogField;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;

import com.google.inject.Inject;
import com.google.inject.name.Named;
/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class TaskTagConfigurationBlock extends OptionsConfigurationBlock {
	public static final String SETTINGS_SECTION_NAME = "TaskTagConfigurationBlock"; //$NON-NLS-1$

	private static final int IDX_ADD = 0;
	private static final int IDX_EDIT = 1;
	private static final int IDX_REMOVE = 2;

	private static final String PROPERTY_PREFIX = "TaskTagConfiguration";

	private ListDialogField taskTags;
	private SelectionButtonDialogField caseSensitiveCheckBox;
	private String languageName;

	/**
	 * @deprecated use {@link #TaskTagConfigurationBlock(String)} instead
	 */
	@Deprecated
	public TaskTagConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			IWorkbenchPreferenceContainer container, String languageName) {
		super(project, preferenceStore, container);
		this.languageName = languageName;
		initialize();

		unpackTaskTags();
		if (taskTags.getSize() > 0) {
			taskTags.selectFirstElement();
		} else {
			taskTags.enableButton(IDX_EDIT, false);
		}
	}

	@Inject
	public TaskTagConfigurationBlock(@Named(Constants.LANGUAGE_NAME) String languageName) {
		super();
		initialize();
	}

	private void initialize() {
		registerKey(getTasksCaseSensitiveKey());
		registerKey(getTaskTagsKey());
		registerKey(getTaskPrioritiesKey());
		TaskTagListAdapter adapter = new TaskTagListAdapter();
		String[] buttons = new String[] { PreferencesMessages.TaskTagConfigurationBlock_markers_tasks_add_button,
				PreferencesMessages.TaskTagConfigurationBlock_markers_tasks_edit_button,
				PreferencesMessages.TaskTagConfigurationBlock_markers_tasks_remove_button, };
		taskTags = new ListDialogField(adapter, buttons, new TaskTagLabelProvider());
		taskTags.setDialogFieldListener(adapter);
		taskTags.setRemoveButtonIndex(IDX_REMOVE);

		String[] columnsHeaders = new String[] {
				PreferencesMessages.TaskTagConfigurationBlock_markers_tasks_name_column,
				PreferencesMessages.TaskTagConfigurationBlock_markers_tasks_priority_column, };

		taskTags.setTableColumns(new ListDialogField.ColumnsDescription(columnsHeaders, true));
		taskTags.setViewerComparator(new TaskTagSorter());

		caseSensitiveCheckBox = new SelectionButtonDialogField(SWT.CHECK);
		caseSensitiveCheckBox.setLabelText(PreferencesMessages.TaskTagConfigurationBlock_casesensitive_label);
		caseSensitiveCheckBox.setDialogFieldListener(adapter);
	}

	@Override
	public void setPreferenceStore(IPreferenceStore preferenceStore) {
		super.setPreferenceStore(preferenceStore);
		unpackTaskTags();
		if (taskTags.getSize() > 0) {
			taskTags.selectFirstElement();
		} else {
			taskTags.enableButton(IDX_EDIT, false);
		}
	}

	@Override
	protected Control doCreateContents(Composite parent) {
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 2;

		PixelConverter conv = new PixelConverter(parent);

		Composite markersComposite = new Composite(parent, SWT.NULL);
		markersComposite.setLayout(layout);
		markersComposite.setFont(parent.getFont());

		GridData data = new GridData(GridData.FILL_BOTH);
		data.widthHint = conv.convertWidthInCharsToPixels(50);
		Control listControl = taskTags.getListControl(markersComposite);
		listControl.setLayoutData(data);

		Control buttonsControl = taskTags.getButtonBox(markersComposite);
		buttonsControl.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_BEGINNING));

		caseSensitiveCheckBox.doFillIntoGrid(markersComposite, 2);

		return markersComposite;
	}

	private class TaskTagLabelProvider extends LabelProvider implements ITableLabelProvider, IFontProvider {

		@Override
		public Image getImage(Object element) {
			return null;
		}

		@Override
		public String getText(Object element) {
			return getColumnText(element, 0);
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			TaskTag task = (TaskTag) element;
			if (columnIndex == 0) {
				return task.getName();
			} else {
				if (Priority.HIGH == task.getPriority()) {
					return PreferencesMessages.TaskTagConfigurationBlock_markers_tasks_high_priority;
				} else if (Priority.NORMAL == task.getPriority()) {
					return PreferencesMessages.TaskTagConfigurationBlock_markers_tasks_normal_priority;
				} else if (Priority.LOW == task.getPriority()) {
					return PreferencesMessages.TaskTagConfigurationBlock_markers_tasks_low_priority;
				}
				return "";
			}
		}

		@Override
		public Font getFont(Object element) {
			return null;
		}

	}

	private static class TaskTagSorter extends ViewerComparator {
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			return getComparator().compare(((TaskTag) e1).getName(), ((TaskTag) e2).getName());
		}
	}

	private class TaskTagListAdapter implements IListAdapter, IDialogFieldListener {

		private boolean canEdit(List<TaskTag> selectedElements) {
			return selectedElements.size() == 1;
		}

		@Override
		public void customButtonPressed(ListDialogField field, int index) {
			taskTagButtonPressed(index);
		}

		@Override
		public void selectionChanged(ListDialogField field) {
			@SuppressWarnings("unchecked")
			List<TaskTag> selectedElements = field.getSelectedElements();
			field.enableButton(IDX_EDIT, canEdit(selectedElements));
		}

		@Override
		public void doubleClicked(ListDialogField field) {
			@SuppressWarnings("unchecked")
			List<TaskTag> selectedElements = field.getSelectedElements();
			if (canEdit(selectedElements)) {
				taskTagButtonPressed(IDX_EDIT);
			}
		}

		@Override
		public void dialogFieldChanged(DialogField field) {
			updateModel(field);
		}

	}

	public void setEnabled(boolean isEnabled) {
		taskTags.setEnabled(isEnabled);
		caseSensitiveCheckBox.setEnabled(isEnabled);
	}

	protected final void updateModel(DialogField field) {
		if (field == taskTags) {
			@SuppressWarnings("unchecked")
			List<TaskTag> list = taskTags.getElements();
			setValue(getTaskTagsKey(), serializeTags(list));
			setValue(getTaskPrioritiesKey(), serializePriorities(list));
		} else if (field == caseSensitiveCheckBox) {
			String state = caseSensitiveCheckBox.isSelected() ? ENABLED : DISABLED;
			setValue(getTasksCaseSensitiveKey(), state);
		}
	}

	private String getTasksCaseSensitiveKey() {
		return CASE_SENSITIVE_KEY.getId();
	}

	private String getTaskPrioritiesKey() {
		return PRIORITIES_KEY.getId();
	}

	private String getTaskTagsKey() {
		return TAGS_KEY.getId();
	}

	@Override
	protected void updateControls() {
		super.updateControls();
		unpackTaskTags();
	}

	private void unpackTaskTags() {
		String rawTags = getValue(getTaskTagsKey());
		String rawPrios = getValue(getTaskPrioritiesKey());
		taskTags.setElements(parseTags(rawTags, rawPrios));
		boolean isCaseSensitive = ENABLED.equals(getValue(getTasksCaseSensitiveKey()));
		caseSensitiveCheckBox.setSelection(isCaseSensitive);
	}

	private void taskTagButtonPressed(int index) {
		TaskTag edited = null;
		if (index != IDX_ADD) {
			edited = (TaskTag) taskTags.getSelectedElements().get(0);
		}
		if (index == IDX_ADD || index == IDX_EDIT) {
			@SuppressWarnings("unchecked")
			TaskTagInputDialog dialog = new TaskTagInputDialog(getShell(), edited, taskTags.getElements(),
					languageName);
			if (dialog.open() == Window.OK) {
				if (edited != null) {
					taskTags.replaceElement(edited, dialog.getResult());
				} else {
					taskTags.addElement(dialog.getResult());
				}
			}
		}
	}

	@Override
	protected void validateSettings(String changedKey, String oldValue, String newValue) {
	}

	@Override
	protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
		String title = PreferencesMessages.TaskTagConfigurationBlock_needsbuild_title;
		String message;
		if (getProject() == null) {
			message = PreferencesMessages.TaskTagConfigurationBlock_needsfullbuild_message;
		} else {
			message = PreferencesMessages.TaskTagConfigurationBlock_needsprojectbuild_message;
		}
		return new String[] { title, message };
	}

	@Override
	protected Job getBuildJob(IProject project) {
		Job buildJob = new OptionsConfigurationBlock.BuildJob("Rebuild", project);
		buildJob.setRule(ResourcesPlugin.getWorkspace().getRuleFactory().buildRule());
		buildJob.setUser(true);
		return buildJob;
	}

	@Override
	public String getPropertyPrefix() {
		return PROPERTY_PREFIX;
	}
}
