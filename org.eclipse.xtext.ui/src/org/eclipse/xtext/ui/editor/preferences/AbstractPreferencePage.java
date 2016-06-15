package org.eclipse.xtext.ui.editor.preferences;

/*******************************************************************************
 * Copyright (c) 2008, 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   itemis AG - initial API and implementation
 *   Cloudsmith Inc - changes to store 'use project settings' in project
 *
 *******************************************************************************/

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.xtext.ui.preferences.PropertyAndPreferencePage;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * This implementation works with a {@link FixedScopedPreferenceStore}
 * <p>
 * The following changes have been made:
 * <ul>
 * <li>'useProjectSettings' is now stored in the project preference store as opposed to the project meta-data stored in
 * the workspace. This is done so that import of a project automatically gets the intended 'useProjectSettings'.</li>
 * </ul>
 * 
 * @author Dennis Hübner - Initial contribution and API
 * @author Henrik Lindberg - changes to store 'use project settings' in project
 * @see PropertyAndPreferencePage
 */
public abstract class AbstractPreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage,
		IWorkbenchPropertyPage {

	private static final Logger log = Logger.getLogger(AbstractPreferencePage.class);

	private static final String USE_PROJECT_SETTINGS = "useProjectSettings"; //$NON-NLS-1$

	private IWorkbench workbench;
	private IProject project;

	private Button useProjectSettingsButton;
	private final List<FieldEditor> editors = new ArrayList<FieldEditor>();

	private Link link;

	@Override
	public void init(IWorkbench workbench) {
		this.workbench = workbench;
	}

	protected IWorkbench getWorkbench() {
		return workbench;
	}

	@Override
	public void setElement(IAdaptable element) {
		this.project = (IProject) element.getAdapter(IProject.class);
	}

	@Override
	public IAdaptable getElement() {
		return project;
	}

	public boolean isPropertyPage() {
		return project != null;
	}

	public AbstractPreferencePage() {
		super(GRID);
	}

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;

	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		if (isPropertyPage()) {
			return preferenceStoreAccess.getWritablePreferenceStore(currentProject());
		}
		return preferenceStoreAccess.getWritablePreferenceStore();
	}

	/**
	 * @deprecated Use {@link #qualifiedName()} instead
	 * @return the qualifer used to look up the preference node of the configured preferencesstore
	 */
	@Deprecated
	protected String getQualifier() {
		return qualifiedName();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.preference.FieldEditorPreferencePage#createContents
	 * (org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		if (isPropertyPage())
			createUseProjectSettingsControls(parent);
		return super.createContents(parent);
	}

	private void createUseProjectSettingsControls(Composite parent) {
		Composite projectSettingsParent = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		projectSettingsParent.setLayout(layout);
		projectSettingsParent.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// use project settings button
		useProjectSettingsButton = new Button(projectSettingsParent, SWT.CHECK);
		useProjectSettingsButton.setText(Messages.AbstractPreferencePage_useProjectSettings);
		useProjectSettingsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleUseProjectSettings();
				log.debug("AbstractPreferencePage.widgetSelected()"); //$NON-NLS-1$
			}
		});

		// configure ws settings link
		link = new Link(projectSettingsParent, SWT.NONE);
		link.setFont(projectSettingsParent.getFont());
		link.setText("<A>" + Messages.AbstractPreferencePage_configureWorkspaceSettings + "</A>"); //$NON-NLS-1$
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String id = qualifiedName();
				PreferencesUtil.createPreferenceDialogOn(getShell(), id, new String[] { id }, null).open();
				updateFieldEditors(false);
			}
		});
		link.setLayoutData(new GridData(SWT.END, SWT.CENTER, true, false));

		// separator line
		Label horizontalLine = new Label(projectSettingsParent, SWT.SEPARATOR | SWT.HORIZONTAL);
		horizontalLine.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false, 2, 1));
		horizontalLine.setFont(projectSettingsParent.getFont());
		//backward compatibility
		restoreOldSettings();
		useProjectSettingsButton.setSelection(isUseProjectSettings());
	}

	private void restoreOldSettings() {
		if (isPropertyPage()) {
			QualifiedName oldKey = new QualifiedName(qualifiedName(), USE_PROJECT_SETTINGS);
			try {
				String oldValue = currentProject().getPersistentProperty(oldKey);
				if (oldValue != null) {
					//remove old entry
					currentProject().setPersistentProperty(oldKey, null);
					//if were true - save copy into project settings
					if (Boolean.valueOf(oldValue)) {
						saveUseProjectSettings(true);
					}
				}
			} catch (Exception e) {
				log.debug("Failed to read persistent property", e);
			}
		}

	}

	private IProject currentProject() {
		if (project == null)
			throw new IllegalStateException("Not a property page case, but current project was requested."); //$NON-NLS-1$
		return project;
	}

	@Inject
	@Named("languageName")
	private String languageName;

	protected String getLanguageName() {
		return this.languageName;
	}

	/**
	 * @return prefix for preference keys
	 */
	protected String qualifiedName() {
		return languageName;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.eclipse.jface.preference.PreferencePage#createControl(org.eclipse
	 * .swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		if (isPropertyPage())
			handleUseProjectSettings();
	}

	@Override
	protected void addField(FieldEditor editor) {
		editors.add(editor);
		super.addField(editor);
	}

	/**
	 * Gets the 'useProjectSettings' flag in the project preferences.
	 * 
	 * @return true if the settings on this page are project specific
	 */
	private Boolean isUseProjectSettings() {
		return Boolean.valueOf(getPreferenceStore().getBoolean(useProjectSettingsPreferenceName()));
	}

	/**
	 * Produces the preference key to use for the 'use project settings' flag when this preference page is is used as a
	 * properties page.
	 * 
	 * @return the concatenation of {@link #qualifiedName()}, "." and {@link #USE_PROJECT_SETTINGS}.
	 * @since 2.8
	 */
	protected String useProjectSettingsPreferenceName() {
		return qualifiedName() + "." + USE_PROJECT_SETTINGS;
	}

	/**
	 * Switches the search scope of the preference store to use [Project, Instance, Configuration] if values are project
	 * specific, and [Instance, Configuration] otherwise. This implementation requires that the given preference store
	 * is based on the Project preference store when the page is used as a Properties page. (This is done in
	 * {@link #doGetPreferenceStore()}).
	 */
	@SuppressWarnings("deprecation")
	private void handleUseProjectSettings() {
		// Note: uses the pre Eclipse 3.6 way of specifying search scopes (deprecated since 3.6)
		boolean isUseProjectSettings = useProjectSettingsButton.getSelection();
		link.setEnabled(!isUseProjectSettings);
		if (!isUseProjectSettings) {
			((FixedScopedPreferenceStore) getPreferenceStore()).setSearchContexts(new IScopeContext[] {
					new InstanceScope(), new ConfigurationScope() });
		} else {
			((FixedScopedPreferenceStore) getPreferenceStore()).setSearchContexts(new IScopeContext[] {
					new ProjectScope(currentProject()), new InstanceScope(), new ConfigurationScope() });
			setProjectSpecificValues();
		}
		updateFieldEditors(isUseProjectSettings);
	}

	/**
	 * Loads values of all field editors using current search scopes in the preference store. Also updates fields
	 * enabled status. (The effect is that fields show project specific values when enabled, and instance scoped/default
	 * values when disabled).
	 * 
	 * @param enabled
	 */
	protected void updateFieldEditors(boolean enabled) {
		Composite parent = getFieldEditorParent();
		for (FieldEditor editor : editors) {
			editor.load();
			editor.setEnabled(enabled, parent);
		}
		getDefaultsButton().setEnabled(enabled);
	}

	@Override
	public boolean performOk() {
		boolean retVal = super.performOk();
		if (retVal && isPropertyPage()) {
			try {
				saveUseProjectSettings(useProjectSettingsButton.getSelection());
			} catch (Exception e) {
				log.error("Error", e); //$NON-NLS-1$
				retVal = false;
			}
		}
		return retVal;
	}

	/**
	 * Saves the 'use project settings' as a preference in the store using the
	 * {@link #useProjectSettingsPreferenceName()} as the key. If not project specific, all affected keys are removed
	 * from the project preferences.
	 * 
	 * @throws IOException
	 */
	private void saveUseProjectSettings(boolean isProjectSpecific) throws IOException {
		final FixedScopedPreferenceStore store = (FixedScopedPreferenceStore) getPreferenceStore();
		if (!isProjectSpecific) {
			// remove all the keys (written by various field editors)
			IEclipsePreferences storePreferences = store.getStorePreferences();
			for (FieldEditor field : editors) {
				storePreferences.remove(field.getPreferenceName());
			}
			// Also remove the master key (i.e. use default/default == false when later reading).
			storePreferences.remove(useProjectSettingsPreferenceName());
		} else {
			store.setValue(useProjectSettingsPreferenceName(), Boolean.toString(isProjectSpecific));
		}
		store.save();
	}

	/**
	 * Copies all the project specific values (except master key) to the values of the instance preference store.
	 */
	private void setProjectSpecificValues() {
		FixedScopedPreferenceStore store = (FixedScopedPreferenceStore) getPreferenceStore();
		IEclipsePreferences storePreferences = store.getStorePreferences();
		for (FieldEditor field : editors) {
			String key = field.getPreferenceName();
			storePreferences.put(key, store.getString(key));
		}
	}

}
