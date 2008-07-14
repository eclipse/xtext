package org.eclipse.xtext.ui.editor.preferences;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;

public abstract class AbstractDetailsPart extends FieldEditorPreferencePage {
	/**
	 * 
	 */
	private PreferencesQualifiedName preferencePrefix;
	protected IPreferenceStore masterPreferenceStore;
	protected PreferenceStore internalStore;
	private List<FieldEditor> internalEditorsList = new ArrayList<FieldEditor>();

	public AbstractDetailsPart(IPreferenceStore masterPreferenceStore) {
		super(GRID);
		this.masterPreferenceStore = masterPreferenceStore;
		internalStore = new PreferenceStore();
	}

	@Override
	protected final void addField(FieldEditor editor) {
		PreferencesQualifiedName prefix = null;
		if (getPreferencePrefix() != null)
			prefix = getPreferencePrefix().append(editor.getPreferenceName());
		else
			prefix = new PreferencesQualifiedName(editor.getPreferenceName());
		editor.setPreferenceName(prefix.toString());
		internalEditorsList.add(editor);
		super.addField(editor);
	}

	@Override
	protected final IPreferenceStore doGetPreferenceStore() {
		return new ChainedPreferenceStore(new IPreferenceStore[] { internalStore, masterPreferenceStore });
	}

	protected final void loadDefaults(PreferencesQualifiedName preferencePrefix) {
		setPreferencePrefix(preferencePrefix);
		performDefaults();
	}

	private void setPreferencePrefix(PreferencesQualifiedName preferencePrefix) {
		this.preferencePrefix = preferencePrefix;
		for (FieldEditor fe : internalEditorsList) {
			PreferencesQualifiedName oldPreferenceName = PreferencesQualifiedName.parse(fe.getPreferenceName());
			fe.setPreferenceName(getPreferencePrefix().append(oldPreferenceName.lastQualifier()).toString());
		}
	}

	protected final void load(PreferencesQualifiedName preferencePrefix) {
		setPreferencePrefix(preferencePrefix);
		initialize();
	}

	@Override
	public final boolean performOk() {
		boolean performOk = super.performOk();
		for (String prefKey : internalStore.preferenceNames()) {
			masterPreferenceStore.putValue(prefKey, internalStore.getString(prefKey));
		}
		masterPreferenceStore.firePropertyChangeEvent(getPreferencePrefix().toString(), null, null);
		return performOk;
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
			fe.setPreferenceStore(internalStore);
			fe.store();
		}
		super.propertyChange(event);
	}

	@Override
	abstract protected void createFieldEditors();

	protected final PreferencesQualifiedName getPreferencePrefix() {
		return preferencePrefix;
	}

}