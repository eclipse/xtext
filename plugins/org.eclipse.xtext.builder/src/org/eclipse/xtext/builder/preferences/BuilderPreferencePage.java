/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import static org.eclipse.xtext.ui.editor.preferences.PreferenceConstants.*;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.xtext.builder.EclipseOutputConfigurationProvider;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.ui.editor.preferences.AbstractPreferencePage;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class BuilderPreferencePage extends AbstractPreferencePage {
	private OutputConfigurationProvider outputConfigurationProvider;

	public OutputConfigurationProvider getOutputConfigurationProvider() {
		return outputConfigurationProvider;
	}

	@Inject
	public void setOutputConfigurationProvider(OutputConfigurationProvider outputConfigurationProvider) {
		this.outputConfigurationProvider = outputConfigurationProvider;
	}

	@Override
	protected String qualifiedName() {
		return getLanguageName() + SEPARATOR + EclipseOutputConfigurationProvider.OUTPUT_PREFERENCE_TAG;
	}

	@Override
	protected void createFieldEditors() {
		addField(new BooleanFieldEditor(BuilderPreferenceAccess.PREF_AUTO_BUILDING,
				Messages.BuilderPreferencePage_GenerateAuto, getFieldEditorParent()));
		addField(new OutputConfigurationFieldEditor(EclipseOutputConfigurationProvider.OUTPUT_PREFERENCE_TAG,
				Messages.BuilderPreferencePage_Output, getFieldEditorParent(), getPreferenceStore(),
				Lists.newArrayList(outputConfigurationProvider.getOutputConfigurations())));
	}

}
