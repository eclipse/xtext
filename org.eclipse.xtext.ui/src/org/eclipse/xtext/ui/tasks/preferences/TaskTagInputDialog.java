/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tasks.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.tasks.Priority;
import org.eclipse.xtext.tasks.TaskTag;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.ComboDialogField;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.DialogField;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.IDialogFieldListener;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.LayoutUtil;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.StringDialogField;
import org.eclipse.xtext.ui.preferences.StatusInfo;

/**
 * Dialog to enter a na new task tag
 */
public class TaskTagInputDialog extends StatusDialog {

	public static final String ENABLED = "true";
	public static final String DISABLED = "false";

	private class TaskTagInputAdapter implements IDialogFieldListener {
		@Override
		public void dialogFieldChanged(DialogField field) {
			doValidation();
		}
	}

	private StringDialogField nameField;
	private ComboDialogField priorityField;
	private List<String> existingNames;
	private String languageName;

	public TaskTagInputDialog(Shell parent, TaskTag task, List<TaskTag> existingEntries,
			String languageName) {
		super(parent);
		this.languageName = languageName;

		existingNames = new ArrayList<String>(existingEntries.size());
		for (int i = 0; i < existingEntries.size(); i++) {
			TaskTag curr = existingEntries.get(i);
			if (!curr.equals(task)) {
				existingNames.add(curr.getName());
			}
		}

		if (task == null) {
			setTitle(PreferencesMessages.TaskTagInputDialog_new_title);
		} else {
			setTitle(PreferencesMessages.TaskTagInputDialog_edit_title);
		}

		TaskTagInputAdapter adapter = new TaskTagInputAdapter();

		nameField = new StringDialogField();
		nameField.setLabelText(PreferencesMessages.TaskTagInputDialog_name_label);
		nameField.setDialogFieldListener(adapter);

		nameField.setText((task != null) ? task.getName() : ""); //$NON-NLS-1$

		String[] items = new String[] { PreferencesMessages.TaskTagInputDialog_priority_high,
				PreferencesMessages.TaskTagInputDialog_priority_normal,
				PreferencesMessages.TaskTagInputDialog_priority_low };

		priorityField = new ComboDialogField(SWT.READ_ONLY);
		priorityField.setLabelText(PreferencesMessages.TaskTagInputDialog_priority_label);
		priorityField.setItems(items);
		if (task != null) {
			if (Priority.HIGH == task.getPriority()) {
				priorityField.selectItem(0);
			} else if (Priority.NORMAL == task.getPriority()) {
				priorityField.selectItem(1);
			} else {
				priorityField.selectItem(2);
			}
		} else {
			priorityField.selectItem(1);
		}
	}

	public TaskTag getResult() {
		TaskTag task = new TaskTag();
		task.setName(nameField.getText().trim());
		switch (priorityField.getSelectionIndex()) {
			case 0:
				task.setPriority(Priority.HIGH);
				break;
			case 1:
				task.setPriority(Priority.NORMAL);
				break;
			default:
				task.setPriority(Priority.LOW);
				break;
		}
		return task;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		Composite inner = new Composite(composite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 2;
		inner.setLayout(layout);

		nameField.doFillIntoGrid(inner, 2);
		priorityField.doFillIntoGrid(inner, 2);

		LayoutUtil.setHorizontalGrabbing(nameField.getTextControl(null));
		LayoutUtil.setWidthHint(nameField.getTextControl(null), convertWidthInCharsToPixels(45));

		nameField.postSetFocusOnDialogField(parent.getDisplay());

		applyDialogFont(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, getTaskTagInputDialog());

		return composite;
	}

	public String getTaskTagInputDialog() {
		return languageName + "_todo_task_input_dialog_context";
	}

	private void doValidation() {
		StatusInfo status = new StatusInfo();
		String newText = nameField.getText();
		if (newText.length() == 0) {
			status.setError(PreferencesMessages.TaskTagInputDialog_error_enterName);
		} else {
			if (newText.indexOf(',') != -1) {
				status.setError(PreferencesMessages.TaskTagInputDialog_error_comma);
			} else if (existingNames.contains(newText)) {
				status.setError(PreferencesMessages.TaskTagInputDialog_error_entryExists);
			} else if (Character.isWhitespace(newText.charAt(0))
					|| Character.isWhitespace(newText.charAt(newText.length() - 1))) {
				status.setError(PreferencesMessages.TaskTagInputDialog_error_noSpace);
			}
		}
		updateStatus(status);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(newShell, getTaskTagInputDialog());
	}
}
