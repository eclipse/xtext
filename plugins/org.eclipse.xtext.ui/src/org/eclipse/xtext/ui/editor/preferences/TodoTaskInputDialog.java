package org.eclipse.xtext.ui.editor.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.editor.preferences.TaskTagsPreferencePage.TaskTag;
import org.eclipse.xtext.ui.util.LayoutUtil;
import org.eclipse.xtext.ui.wizards.dialogfields.ComboDialogField;
import org.eclipse.xtext.ui.wizards.dialogfields.DialogField;
import org.eclipse.xtext.ui.wizards.dialogfields.IDialogFieldListener;
import org.eclipse.xtext.ui.wizards.dialogfields.StringDialogField;

/**
 * Dialog to enter a na new task tag
 */
@SuppressWarnings("unchecked")
public class TodoTaskInputDialog extends StatusDialog {

	private class CompilerTodoTaskInputAdapter implements IDialogFieldListener {
		public void dialogFieldChanged(DialogField field) {
			doValidation();
		}
	}

	private StringDialogField fNameDialogField;
	private ComboDialogField fPriorityDialogField;

	private List fExistingNames;

	public TodoTaskInputDialog(Shell parent, TaskTag task, List existingEntries) {
		super(parent);

		fExistingNames = new ArrayList(existingEntries.size());
		for (int i = 0; i < existingEntries.size(); i++) {
			TaskTag curr = (TaskTag) existingEntries.get(i);
			if (!curr.equals(task)) {
				fExistingNames.add(curr.name);
			}
		}

		if (task == null) {
			setTitle(XtextUIMessages.TaskTagInputDialog_new_title);
		} else {
			setTitle(XtextUIMessages.TaskTagInputDialog_edit_title);
		}

		CompilerTodoTaskInputAdapter adapter = new CompilerTodoTaskInputAdapter();

		fNameDialogField = new StringDialogField();
		fNameDialogField
				.setLabelText(XtextUIMessages.TaskTagInputDialog_name_label);
		fNameDialogField.setDialogFieldListener(adapter);

		fNameDialogField.setText((task != null) ? task.name : ""); //$NON-NLS-1$

		String[] items = new String[] {
				XtextUIMessages.TaskTagInputDialog_priority_high,
				XtextUIMessages.TaskTagInputDialog_priority_normal,
				XtextUIMessages.TaskTagInputDialog_priority_low };

		fPriorityDialogField = new ComboDialogField(SWT.READ_ONLY);
		fPriorityDialogField
				.setLabelText(XtextUIMessages.TaskTagInputDialog_priority_label);
		fPriorityDialogField.setItems(items);
		if (task != null) {
			if (PreferenceConstants.PRIORITY_HIGH.equals(task.priority)) {
				fPriorityDialogField.selectItem(0);
			} else if (PreferenceConstants.PRIORITY_NORMAL
					.equals(task.priority)) {
				fPriorityDialogField.selectItem(1);
			} else {
				fPriorityDialogField.selectItem(2);
			}
		} else {
			fPriorityDialogField.selectItem(1);
		}
	}

	public TaskTag getResult() {
		TaskTag task = new TaskTag();
		task.name = fNameDialogField.getText().trim();
		switch (fPriorityDialogField.getSelectionIndex()) {
		case 0:
			task.priority = PreferenceConstants.PRIORITY_HIGH;
			break;
		case 1:
			task.priority = PreferenceConstants.PRIORITY_NORMAL;
			break;
		default:
			task.priority = PreferenceConstants.PRIORITY_LOW;
			break;
		}
		return task;
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		Composite inner = new Composite(composite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 2;
		inner.setLayout(layout);

		fNameDialogField.doFillIntoGrid(inner, 2);
		fPriorityDialogField.doFillIntoGrid(inner, 2);

		LayoutUtil.setHorizontalGrabbing(fNameDialogField.getTextControl(null));
		LayoutUtil.setWidthHint(fNameDialogField.getTextControl(null),
				convertWidthInCharsToPixels(45));

		fNameDialogField.postSetFocusOnDialogField(parent.getDisplay());

		applyDialogFont(composite);

		return composite;
	}

	private void doValidation() {
		StatusInfo status = new StatusInfo();
		String newText = fNameDialogField.getText();
		if (newText.length() == 0) {
			status.setError(XtextUIMessages.TaskTagInputDialog_error_enterName);
		} else {
			if (newText.indexOf(',') != -1) {
				status.setError(XtextUIMessages.TaskTagInputDialog_error_comma);
			} else if (fExistingNames.contains(newText)) {
				status
						.setError(XtextUIMessages.TaskTagInputDialog_error_entryExists);
			} else if (Character.isWhitespace(newText.charAt(0))
					|| Character.isWhitespace(newText
							.charAt(newText.length() - 1))) {
				status
						.setError(XtextUIMessages.TaskTagInputDialog_error_noSpace);
			}
		}
		updateStatus(status);
	}

}
