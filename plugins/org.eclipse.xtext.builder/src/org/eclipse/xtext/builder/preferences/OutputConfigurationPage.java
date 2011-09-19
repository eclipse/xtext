/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import static org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.*;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.xtext.ui.editor.preferences.fields.AbstractDetailsPart;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class OutputConfigurationPage extends AbstractDetailsPart {
	private IAdaptable adaptable;

	public IAdaptable getAdaptable() {
		return adaptable;
	}

	public OutputConfigurationPage(IPreferenceStore masterPreferenceStore) {
		super(masterPreferenceStore);
	}

	public OutputConfigurationPage(IPreferenceStore masterPreferenceStore, IAdaptable adaptable) {
		super(masterPreferenceStore);
		this.adaptable = adaptable;
	}

	@Override
	protected void createFieldEditors() {
		addField(new StringFieldEditor(OUTPUT_NAME, Messages.OutputConfigurationPage_Name, getFieldEditorParent()));
		addField(new StringFieldEditor(OUTPUT_DESCRIPTION, Messages.OutputConfigurationPage_Description,
				getFieldEditorParent()));
		if (getAdaptable() != null && getAdaptable().getAdapter(IResource.class) != null) {
			addField(new ProjectDirectoryFieldEditor(OUTPUT_DIRECTORY, Messages.OutputConfigurationPage_Directory,
					getFieldEditorParent(), ((IResource) getAdaptable()).getProject()));
		} else {
			addField(new StringFieldEditor(OUTPUT_DIRECTORY, Messages.OutputConfigurationPage_Directory,
					getFieldEditorParent()));
		}
		addField(new BooleanFieldEditor(OUTPUT_CREATE_DIRECTORY, Messages.OutputConfigurationPage_CreateDirectory,
				getFieldEditorParent()));
		addField(new BooleanFieldEditor(OUTPUT_CLEAN_DIRECTORY, Messages.OutputConfigurationPage_CleanDirectory,
				getFieldEditorParent()));
		addField(new BooleanFieldEditor(OUTPUT_OVERRIDE, Messages.OutputConfigurationPage_OverrideExistingResources,
				getFieldEditorParent()));
		addField(new BooleanFieldEditor(OUTPUT_DERIVED, Messages.OutputConfigurationPage_CreatesDerivedResources,
				getFieldEditorParent()));
		addField(new BooleanFieldEditor(OUTPUT_CLEANUP_DERIVED,
				Messages.OutputConfigurationPage_CleanupDerivedResources, getFieldEditorParent()));
	}
}
