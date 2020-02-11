/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences.fields;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class CheckBoxGroupFieldEditor extends FieldEditor {

	private Composite checkBoxBox;
	private final boolean useGroup;
	private final String[][] labelsAndValues;
	private final int numColumns;
	private Button[] checkBoxButtons;
	protected String result;

	public CheckBoxGroupFieldEditor(String name, String labeltext, int numColumns, String[][] labelsAndValues,
			Composite fieldEditorParent, boolean useGroup) {
		init(name, labeltext);
		this.numColumns = numColumns;
		this.labelsAndValues = labelsAndValues.clone();
		this.useGroup = useGroup;
		createControl(fieldEditorParent);
	}

	/**
	 * @param settings
	 *            String[][fieldName,fieldValue,isChecked]
	 * @return value as String
	 */
	protected abstract String calculateResult(String[][] settings);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#adjustForNumColumns(int)
	 */
	@Override
	protected void adjustForNumColumns(int numColumns) {
		Control control = getLabelControl();
		if (control != null) {
			((GridData) control.getLayoutData()).horizontalSpan = numColumns;
		}
		((GridData) checkBoxBox.getLayoutData()).horizontalSpan = numColumns;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.preference.FieldEditor#doFillIntoGrid(org.eclipse.swt
	 * .widgets.Composite, int)
	 */
	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		if (useGroup) {
			Control control = getCheckBoxControl(parent);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			control.setLayoutData(gd);
		}
		else {
			Control control = getLabelControl(parent);
			GridData gd = new GridData();
			gd.horizontalSpan = numColumns;
			control.setLayoutData(gd);
			control = getCheckBoxControl(parent);
			gd = new GridData();
			gd.horizontalSpan = numColumns;
			control.setLayoutData(gd);
		}
	}

	private Control getCheckBoxControl(Composite parent) {
		if (checkBoxBox == null) {
			Font font = parent.getFont();
			if (useGroup) {
				Group group = new Group(parent, SWT.NONE);
				group.setFont(font);
				String text = getLabelText();
				if (text != null) {
					group.setText(text);
				}
				checkBoxBox = group;
				GridLayout layout = new GridLayout();
				layout.horizontalSpacing = HORIZONTAL_GAP;
				layout.numColumns = numColumns;
				checkBoxBox.setLayout(layout);
			}
			else {
				checkBoxBox = new Composite(parent, SWT.NONE);
				GridLayout layout = new GridLayout();
				layout.marginWidth = 0;
				layout.marginHeight = 0;
				layout.horizontalSpacing = HORIZONTAL_GAP;
				layout.numColumns = numColumns;
				checkBoxBox.setLayout(layout);
				checkBoxBox.setFont(font);
			}

			checkBoxButtons = new Button[labelsAndValues.length];
			for (int i = 0; i < labelsAndValues.length; i++) {
				Button checkBox = new Button(checkBoxBox, SWT.CHECK | SWT.LEFT);
				checkBoxButtons[i] = checkBox;
				String[] labelAndValue = labelsAndValues[i];
				checkBox.setText(labelAndValue[0]);
				checkBox.setData(labelAndValue[1]);
				checkBox.setFont(font);
				checkBox.addSelectionListener(new SelectionAdapter() {

					@Override
					public void widgetSelected(SelectionEvent event) {
						setPresentsDefaultValue(false);
						String oldResult = result;
						result = gatherSettings();
						fireValueChanged(VALUE, oldResult, result);
					}
				});
			}
			checkBoxBox.addDisposeListener(new DisposeListener() {
				@Override
				public void widgetDisposed(DisposeEvent event) {
					checkBoxBox = null;
					checkBoxButtons = null;
				}
			});
		}
		else {
			checkParent(checkBoxBox, parent);
		}
		return checkBoxBox;
	}

	private String gatherSettings() {
		String[][] settings = new String[checkBoxButtons.length][3];
		for (int i = 0; i < checkBoxButtons.length; i++) {
			Button currentCheckBox = checkBoxButtons[i];
			String name = currentCheckBox.getText();
			String value = (String) currentCheckBox.getData();
			String checked = String.valueOf(currentCheckBox.getSelection());
			settings[i] = new String[] { name, value, checked };
		}
		return calculateResult(settings);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doLoad()
	 */
	@Override
	protected void doLoad() {
		setupControls(getPreferenceStore().getString(getPreferenceName()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doLoadDefault()
	 */
	@Override
	protected void doLoadDefault() {
		setupControls(getPreferenceStore().getDefaultString(getPreferenceName()));
	}

	private void setupControls(String valueToSet) {
		for (int i = 0; i < checkBoxButtons.length; i++) {
			Button currentCheckBox = checkBoxButtons[i];
			currentCheckBox.setSelection(isSelected(currentCheckBox.getText(), valueToSet));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#doStore()
	 */
	@Override
	protected void doStore() {
		if (result == null) {
			return;
		}
		getPreferenceStore().setValue(getPreferenceName(), result);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.preference.FieldEditor#getNumberOfControls()
	 */
	@Override
	public int getNumberOfControls() {
		return 1;
	}

	@Override
	public void setEnabled(boolean enabled, Composite parent) {
		if (!useGroup) {
			super.setEnabled(enabled, parent);
		}
		for (Button button : checkBoxButtons) {
			button.setEnabled(enabled);
		}
	}

	abstract protected boolean isSelected(String fieldName, String valueToSet);
}
