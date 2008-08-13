package org.eclipse.xtext.ui.editor.preferences;

import static org.eclipse.xtext.ui.editor.preferences.PreferenceConstants.PREF_TASK_CASE_SENSITIVE;
import static org.eclipse.xtext.ui.editor.preferences.PreferenceConstants.PREF_TASK_PRIORITIES;
import static org.eclipse.xtext.ui.editor.preferences.PreferenceConstants.PREF_TASK_TAGS;
import static org.eclipse.xtext.ui.editor.preferences.PreferenceConstants.PRIORITY_HIGH;
import static org.eclipse.xtext.ui.editor.preferences.PreferenceConstants.PRIORITY_LOW;
import static org.eclipse.xtext.ui.editor.preferences.PreferenceConstants.PRIORITY_NORMAL;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.JFaceResources;
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
import org.eclipse.xtext.ui.XtextUIMessages;
import org.eclipse.xtext.ui.util.PixelConverter;
import org.eclipse.xtext.ui.wizards.dialogfields.DialogField;
import org.eclipse.xtext.ui.wizards.dialogfields.IDialogFieldListener;
import org.eclipse.xtext.ui.wizards.dialogfields.IListAdapter;
import org.eclipse.xtext.ui.wizards.dialogfields.ListDialogField;
import org.eclipse.xtext.ui.wizards.dialogfields.SelectionButtonDialogField;

/**
 * Represents a preferences page used to configure <i>task</i> tags which are
 * utilized from within
 * {@link org.eclipse.xtext.ui.editor.TaskTagsMarkerListener} to mark concerned
 * text positions.
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 * @see org.eclipse.xtext.ui.editor.TaskTagsMarkerListener
 * 
 */
public class TaskTagsPreferencePage extends AbstractPreferencePage implements
		IExecutableExtension {

	/**
	 * Simple ValueHolder class for <i>TaskTag</i> name and priority.
	 */
	public static class TaskTag {

		public static final String ENABLED = "enabled"; //$NON-NLS-1$
		public static final String DISABLED = "disabled"; //$NON-NLS-1$

		public String name;
		public String priority;

		public TaskTag() {
		}

		public TaskTag(String name, String priority) {
			this.name = name;
			this.priority = priority;
		}

		public String getName() {
			return name;
		}

		public String getPriority() {
			return priority;
		}

		/**
		 * @param preferenceStore
		 *            containing the TaskTags
		 * @return a list of available <code>TaskTag</code> from the given
		 *         preferenceStore
		 */
		public static List<TaskTag> getTodoTaskList(
				IPreferenceStore preferenceStore) {

			String currTags = preferenceStore
					.getString(PREF_TASK_TAGS);

			String currPrios = preferenceStore
					.getString(PREF_TASK_PRIORITIES);

			String[] tags = getTokens(currTags, ",");

			String[] prios = getTokens(currPrios, ",");

			ArrayList<TaskTag> elements = new ArrayList<TaskTag>(tags.length);

			for (int i = 0; i < tags.length; i++) {
				TaskTag task = new TaskTag(tags[i].trim(),
						(i < prios.length) ? prios[i] : PRIORITY_NORMAL);

				elements.add(task);
			}

			return elements;
		}

		/**
		 * 
		 * @param preferenceStore
		 *            to use
		 * @return true means <i>TaskTag</i> should be handled in a case
		 *         sensitive way
		 */
		public static Boolean isCaseSensitive(IPreferenceStore preferenceStore) {
			return ENABLED.equalsIgnoreCase(preferenceStore
					.getString(PREF_TASK_CASE_SENSITIVE));
		}

		private static String[] getTokens(String text, String separator) {
			StringTokenizer tok = new StringTokenizer(text, separator);
			int nTokens = tok.countTokens();
			String[] res = new String[nTokens];
			for (int i = 0; i < res.length; i++) {
				res[i] = tok.nextToken().trim();
			}
			return res;
		}
	}

	private static final int IDX_ADD = 0;
	private static final int IDX_EDIT = 1;
	private static final int IDX_REMOVE = 2;
	private static final int IDX_DEFAULT = 4;

	private String namespaceIdentifier;
	private ListDialogField taskTagListDialogField;
	private SelectionButtonDialogField caseSensitiveCheckBox;

	public TaskTagsPreferencePage() {

		TaskTagAdapter adapter = new TaskTagAdapter();
		String[] buttons = new String[] {
				XtextUIMessages.TaskTagConfigurationBlock_markers_tasks_add_button,
				XtextUIMessages.TaskTagConfigurationBlock_markers_tasks_edit_button,
				XtextUIMessages.TaskTagConfigurationBlock_markers_tasks_remove_button,
				null,
				XtextUIMessages.TaskTagConfigurationBlock_markers_tasks_setdefault_button, };
		taskTagListDialogField = new ListDialogField(adapter, buttons,
				new TodoTaskLabelProvider());
		taskTagListDialogField.setDialogFieldListener(adapter);
		taskTagListDialogField.setRemoveButtonIndex(IDX_REMOVE);

		String[] columnsHeaders = new String[] {
				XtextUIMessages.TaskTagConfigurationBlock_markers_tasks_name_column,
				XtextUIMessages.TaskTagConfigurationBlock_markers_tasks_priority_column, };

		taskTagListDialogField
				.setTableColumns(new ListDialogField.ColumnsDescription(
						columnsHeaders, true));
		taskTagListDialogField.setViewerComparator(new TodoTaskSorter());

		caseSensitiveCheckBox = new SelectionButtonDialogField(SWT.CHECK);
		caseSensitiveCheckBox
				.setLabelText(XtextUIMessages.TaskTagConfigurationBlock_casesensitive_label);
		caseSensitiveCheckBox.setDialogFieldListener(adapter);

		if (taskTagListDialogField.getSize() > 0) {
			taskTagListDialogField.selectFirstElement();
		} else {
			taskTagListDialogField.enableButton(IDX_EDIT, false);
			taskTagListDialogField.enableButton(IDX_DEFAULT, false);
		}

	}

	/**
	 * @see org.eclipse.core.runtime.IExecutableExtension#setInitializationData(IConfigurationElement,
	 *      String, Object)
	 */

	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.namespaceIdentifier = config.getNamespaceIdentifier();
	}

	@Override
	protected String getQualifier() {
		return this.namespaceIdentifier;
	}

	@Override
	protected String qualifiedName() {
		return PreferenceConstants.syntaxColorerTag(getServiceScope());
	}

	@Override
	protected Control createContents(Composite parent) {
		return createMarkersTabContent(parent);
	}

	@Override
	protected void createFieldEditors() {
	}

	private boolean isDefaultTask(TaskTag task) {
		return taskTagListDialogField.getIndexOfElement(task) == 0;
	}

	private void setToDefaultTask(TaskTag task) {
		@SuppressWarnings("unchecked")
		List<TaskTag> elements = taskTagListDialogField.getElements();
		elements.remove(task);
		elements.add(0, task);
		taskTagListDialogField.setElements(elements);
		taskTagListDialogField.enableButton(IDX_DEFAULT, false);
	}

	private Composite createMarkersTabContent(Composite folder) {

		taskTagListDialogField.setElements(TaskTag
				.getTodoTaskList(getPreferenceStore()));

		caseSensitiveCheckBox.setSelection(TaskTag
				.isCaseSensitive(getPreferenceStore()));

		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.numColumns = 2;

		PixelConverter conv = new PixelConverter(folder);

		Composite markersComposite = new Composite(folder, SWT.NULL);
		markersComposite.setLayout(layout);
		markersComposite.setFont(folder.getFont());

		GridData data = new GridData(GridData.FILL_BOTH);
		data.widthHint = conv.convertWidthInCharsToPixels(50);
		Control listControl = taskTagListDialogField
				.getListControl(markersComposite);
		listControl.setLayoutData(data);

		Control buttonsControl = taskTagListDialogField
				.getButtonBox(markersComposite);
		buttonsControl.setLayoutData(new GridData(
				GridData.HORIZONTAL_ALIGN_FILL
						| GridData.VERTICAL_ALIGN_BEGINNING));

		caseSensitiveCheckBox.doFillIntoGrid(markersComposite, 2);

		return markersComposite;
	}

	private final void updateModel(DialogField field) {
		if (field == taskTagListDialogField) {
			StringBuffer tags = new StringBuffer();
			StringBuffer prios = new StringBuffer();
			@SuppressWarnings("unchecked")
			List<TaskTag> todoTaskList = taskTagListDialogField.getElements();
			for (int i = 0; i < todoTaskList.size(); i++) {
				if (i > 0) {
					tags.append(',');
					prios.append(',');
				}
				TaskTag elem = todoTaskList.get(i);
				tags.append(elem.name);
				prios.append(elem.priority);
			}
			getPreferenceStore().setValue(PREF_TASK_TAGS,
					tags.toString());
			getPreferenceStore().setValue(PREF_TASK_PRIORITIES,
					prios.toString());
		} else if (field == caseSensitiveCheckBox) {
			String state = caseSensitiveCheckBox.isSelected() ? TaskTag.ENABLED
					: TaskTag.DISABLED;
			getPreferenceStore().setValue(PREF_TASK_CASE_SENSITIVE,
					state);
		}
	}

	private void doTodoButtonPressed(int index) {
		TaskTag edited = null;
		if (index != IDX_ADD) {
			edited = (TaskTag) taskTagListDialogField.getSelectedElements()
					.get(0);
		}
		if (index == IDX_ADD || index == IDX_EDIT) {
			TodoTaskInputDialog dialog = new TodoTaskInputDialog(getShell(),
					edited, taskTagListDialogField.getElements());
			if (dialog.open() == Window.OK) {
				if (edited != null) {
					taskTagListDialogField.replaceElement(edited, dialog
							.getResult());
				} else {
					taskTagListDialogField.addElement(dialog.getResult());
				}
			}
		} else if (index == IDX_DEFAULT) {
			setToDefaultTask(edited);
		}
	}

	private class TaskTagAdapter implements IListAdapter, IDialogFieldListener {

		public void customButtonPressed(ListDialogField field, int index) {
			doTodoButtonPressed(index);
		}

		public void selectionChanged(ListDialogField field) {
			@SuppressWarnings("unchecked")
			List<TaskTag> selectedElements = field.getSelectedElements();
			field.enableButton(IDX_EDIT, canEdit(selectedElements));
			field.enableButton(IDX_DEFAULT, canSetToDefault(selectedElements));
		}

		public void doubleClicked(ListDialogField field) {
			@SuppressWarnings("unchecked")
			List<TaskTag> selectedElements = field.getSelectedElements();
			if (canEdit(selectedElements)) {
				doTodoButtonPressed(IDX_EDIT);
			}
		}

		public void dialogFieldChanged(DialogField field) {
			updateModel(field);
		}

		private boolean canEdit(List<TaskTag> selectedElements) {
			return selectedElements.size() == 1;
		}

		private boolean canSetToDefault(List<TaskTag> selectedElements) {
			return selectedElements.size() == 1
					&& !isDefaultTask((TaskTag) selectedElements.get(0));
		}

	}

	private class TodoTaskLabelProvider extends LabelProvider implements
			ITableLabelProvider, IFontProvider {

		public TodoTaskLabelProvider() {
		}

		public Image getImage(Object element) {
			return null;
		}

		public String getText(Object element) {
			return getColumnText(element, 0);
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			TaskTag task = (TaskTag) element;
			if (columnIndex == 0) {
				String name = task.name;
				if (isDefaultTask(task)) {
					name = MessageFormat
							.format(
									XtextUIMessages.TaskTagConfigurationBlock_tasks_default,
									new Object[] { name });
				}
				return name;
			} else {
				if (PRIORITY_HIGH.equals(task.priority)) {
					return XtextUIMessages.TaskTagConfigurationBlock_markers_tasks_high_priority;
				} else if (PRIORITY_NORMAL.equals(task.priority)) {
					return XtextUIMessages.TaskTagConfigurationBlock_markers_tasks_normal_priority;
				} else if (PRIORITY_LOW.equals(task.priority)) {
					return XtextUIMessages.TaskTagConfigurationBlock_markers_tasks_low_priority;
				}
				return task.priority;
			}
		}

		public Font getFont(Object element) {
			if (isDefaultTask((TaskTag) element)) {
				return JFaceResources.getFontRegistry().getBold(
						JFaceResources.DIALOG_FONT);
			}
			return null;
		}
	}

	private static class TodoTaskSorter extends ViewerComparator {
		@SuppressWarnings("unchecked")
		public int compare(Viewer viewer, Object e1, Object e2) {
			return getComparator().compare(((TaskTag) e1).name,
					((TaskTag) e2).name);
		}
	}

}
