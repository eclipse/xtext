/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences.fields;

import java.util.ArrayList;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.xtext.ui.editor.preferences.PreferencesQualifiedName;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class AbstractMasterDetailsFieldEditor extends FieldEditor {

	private List masterList;
	protected final java.util.List<?> items;
	private AbstractDetailsPart fieldEditorPreferencePage;

	public AbstractMasterDetailsFieldEditor(IPreferenceStore preferenceStore, String name, String label,
			java.util.List<?> items, Composite parent) {
		this.items = items;
		init(name, label);
		setPreferenceStore(preferenceStore);
		createControl(parent);
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {
		Control control = getLabelControl();
		((GridData) control.getLayoutData()).horizontalSpan = numColumns;
		((GridData) masterList.getLayoutData()).horizontalSpan = numColumns - 1;
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		Control control = getLabelControl(parent);
		GridData gd = new GridData();
		gd.horizontalSpan = numColumns;
		control.setLayoutData(gd);

		masterList = getMasterList(parent);
		gd = new GridData();
		gd.verticalAlignment = GridData.FILL;
		gd.horizontalSpan = numColumns - 1;
		masterList.setLayoutData(gd);

		fieldEditorPreferencePage = createDetailsPart();
		fieldEditorPreferencePage.createControl(parent);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.verticalAlignment = GridData.FILL;
		gd.horizontalSpan = numColumns - 1;
		gd.grabExcessHorizontalSpace = true;
		fieldEditorPreferencePage.getControl().setLayoutData(gd);
	}

	abstract protected AbstractDetailsPart createDetailsPart();

	private List getMasterList(Composite parent) {
		if (masterList == null) {
			masterList = new List(parent, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
			masterList.setFont(parent.getFont());
			java.util.List<String> names = new ArrayList<String>();
			for (Object ttd : items) {
				if (label(ttd) != null)
					names.add(label(ttd));
				else
					names.add("<unnamed> (" + identifier(ttd) + ")");
			}
			masterList.setItems(names.toArray(new String[0]));
			masterList.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					doLoad();
				}
			});
			masterList.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent event) {
					masterList = null;
				}
			});
			masterList.setSelection(0);
		}
		return masterList;
	}

	protected abstract String identifier(Object ttd);

	protected abstract String label(Object ttd);

	@Override
	protected void doLoad() {
		fieldEditorPreferencePage.load(calculateClientPreferencePrefix());
	}

	private PreferencesQualifiedName calculateClientPreferencePrefix() {
		return PreferencesQualifiedName.parse(getPreferenceName()).append(identifier(selectedObject()));
	}

	/**
	 * @return
	 */
	private Object selectedObject() {
		int selectionIndex = masterList.getSelectionIndex();
		Object tokenTypeDef = items.get(selectionIndex);
		return tokenTypeDef;
	}

	@Override
	protected void doLoadDefault() {
		fieldEditorPreferencePage.loadDefaults(calculateClientPreferencePrefix());
	}

	@Override
	protected void doStore() {
		fieldEditorPreferencePage.performOk();
	}

	@Override
	public int getNumberOfControls() {
		return 2;
	}

	@Override
	public void setEnabled(boolean enabled, Composite parent) {
		super.setEnabled(enabled, parent);
		getMasterList(parent).setEnabled(enabled);
	}

}