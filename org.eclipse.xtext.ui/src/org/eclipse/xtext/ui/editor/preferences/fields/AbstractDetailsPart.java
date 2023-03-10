/*******************************************************************************
 * Copyright (c) 2008, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences.fields;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public abstract class AbstractDetailsPart extends FieldEditorPreferencePage {
	/**
	 * 
	 */
	protected IPreferenceStore masterPreferenceStore;
	protected PreferenceStore internalStore;
	private List<FieldEditor> internalEditorsList = new ArrayList<FieldEditor>();
	private String preferencePrefix;

	public AbstractDetailsPart(IPreferenceStore masterPreferenceStore) {
		super(GRID);
		this.masterPreferenceStore = masterPreferenceStore;
		internalStore = new PreferenceStore();
	}

	@Override
	protected final void addField(FieldEditor editor) {
		String prefix = null;
		if (getPreferencePrefix() != null)
			prefix = getPreferencePrefix() + PreferenceConstants.SEPARATOR + editor.getPreferenceName();
		else
			prefix = editor.getPreferenceName();
		editor.setPreferenceName(prefix);
		internalEditorsList.add(editor);
		super.addField(editor);
	}

	@Override
	protected final IPreferenceStore doGetPreferenceStore() {
		return new ChainedPreferenceStore(new IPreferenceStore[] { internalStore, masterPreferenceStore });
	}

	protected final void load(String preferencePrefix) {
		setPreferencePrefix(preferencePrefix);
		initialize();
	}

	protected final void loadDefaults(String preferencePrefix) {
		setPreferencePrefix(preferencePrefix);
		performDefaults();
		for (FieldEditor fe : internalEditorsList) {
			if (fe.presentsDefaultValue()) {
				internalStore.setValue(fe.getPreferenceName(), masterPreferenceStore.getDefaultString(fe
						.getPreferenceName()));
			}
		}
	}

	@Override
	public final boolean performOk() {
		int changed = 0;
		for (String prefKey : internalStore.preferenceNames()) {
			String value = internalStore.getString(prefKey);
			String defaultValue = masterPreferenceStore.getDefaultString(prefKey);
			if (!value.equals(defaultValue)) {
				masterPreferenceStore.putValue(prefKey, value);
				changed++;
			}
			else {
				masterPreferenceStore.setToDefault(prefKey);
				changed++;
			}
		}
		if (changed > 0)
			masterPreferenceStore.firePropertyChangeEvent(getPreferencePrefix(), null, null);
		resetPreferenceStore();
		return true;
	}

	/**
	 * 
	 */
	private void resetPreferenceStore() {
		internalStore = new PreferenceStore();
		setPreferenceStore(null);
	}

	@Override
	public final void createControl(Composite parent) {
		noDefaultAndApplyButton();
		super.createControl(parent);
	}

	@Override
	public final void propertyChange(PropertyChangeEvent event) {
		if (event.getSource() instanceof FieldEditor) {
			FieldEditor fe = (FieldEditor) event.getSource();
			internalStore.setValue(fe.getPreferenceName(), fe.getPreferenceStore().getDefaultString(fe.getPreferenceName()));
			// store changed value in internalStore
			fe.setPreferenceStore(internalStore);
			fe.store();
			// reset preference store of fieldEditor to chained store, so it also works for other token styles.
			fe.setPreferenceStore(getPreferenceStore());
		}
		super.propertyChange(event);
	}

	@Override
	abstract protected void createFieldEditors();

	protected final String getPreferencePrefix() {
		return preferencePrefix;
	}

	private void setPreferencePrefix(String preferencePrefix) {
		this.preferencePrefix = preferencePrefix;
		for (FieldEditor fe : internalEditorsList) {
			String oldPreferenceName = fe.getPreferenceName();
			if (oldPreferenceName.indexOf(PreferenceConstants.SEPARATOR) >= 0) {
				oldPreferenceName = oldPreferenceName.substring(oldPreferenceName
						.lastIndexOf(PreferenceConstants.SEPARATOR) + 1);
			}
			fe.setPreferenceName(getPreferencePrefix() + PreferenceConstants.SEPARATOR + oldPreferenceName);
		}
	}
}