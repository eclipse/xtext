/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.builder;

import static org.eclipse.xtext.xbase.ui.builder.XbaseBuilderPreferenceAccess.*;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.builder.preferences.BuilderConfigurationBlock;
import org.eclipse.xtext.util.JavaVersion;

import com.google.inject.Inject;

/**
 * Builder configuration block that adds compiler settings for Xbase.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 */
public class XbaseBuilderConfigurationBlock extends BuilderConfigurationBlock {
	
	@Inject
	private XbaseBuilderPreferenceAccess preferenceAccess;
	
	private Combo versionCombo;

	private Button useComplianceButton;
	
	@Override
	protected void createGeneralSectionItems(Composite composite) {
		super.createGeneralSectionItems(composite);
		
		useComplianceButton = addCheckBox(composite,
				"Use source compatibility level from Java settings",
				PREF_USE_COMPILER_SOURCE, BOOLEAN_VALUES, 0);
		
		int valueCount = JavaVersion.values().length;
		String[] values = new String[valueCount];
		String[] valueLabels = new String[valueCount];
		for (int i = 0; i < valueCount; i++) {
			JavaVersion v = JavaVersion.values()[i];
			values[i] = v.toString();
			valueLabels[i] = v.getLabel();
		}
		versionCombo = addComboBox(composite, "Source compatibility level of generated code:",
				PREF_JAVA_VERSION, 0, values, valueLabels);
		SelectionListener selectionListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateVersionCombo();
			}
		};
		selectionListener.widgetSelected(null);
		useComplianceButton.addSelectionListener(selectionListener);
		
		addCheckBox(composite, "Generate @SuppressWarnings annotations",
				PREF_GENERATE_SUPPRESS_WARNINGS, BOOLEAN_VALUES, 0);
		
		final Button generateGeneratedButton = addCheckBox(composite, "Generate @Generated annotations",
				PREF_GENERATE_GENERATED, BOOLEAN_VALUES, 0);
		
		final Button includeDateButton = addCheckBox(composite, "Include current time information",
				PREF_DATE_IN_GENERATED, BOOLEAN_VALUES, INDENT_AMOUNT);
		includeDateButton.setEnabled(generateGeneratedButton.getSelection());
		
		final Text commentText = addTextField(composite, "Comment:",
				PREF_GENERATED_COMMENT, INDENT_AMOUNT, 0);
		commentText.setEnabled(generateGeneratedButton.getSelection());
		generateGeneratedButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				includeDateButton.setEnabled(generateGeneratedButton.getSelection());
				commentText.setEnabled(generateGeneratedButton.getSelection());
			}
		});
	}
	
	@Override
	protected void updateCombo(Combo curr) {
		if(curr == versionCombo)
			updateVersionCombo();
		else
			super.updateCombo(curr);
	}
	
	private void updateVersionCombo() {
		boolean useCompliance = useComplianceButton.getSelection();
		versionCombo.setEnabled(!useCompliance);
		if (useCompliance) {
			String javaSourceOption = javaValue(JavaCore.COMPILER_SOURCE);
			JavaVersion javaVersion = preferenceAccess.fromCompilerSourceLevel(javaSourceOption);
			JavaVersion selectedVersion = JavaVersion.values()[versionCombo.getSelectionIndex()];
			if (javaVersion != selectedVersion) {
				versionCombo.select(javaVersion.ordinal());
			}
		}
	}

	protected String javaValue(final String javaPreference) {
		IJavaProject javaProject = JavaCore.create(getProject());
		if (javaProject != null && javaProject.exists() && javaProject.getProject().isAccessible()) {
			return javaProject.getOption(javaPreference, true);
		} else {
			return JavaCore.getOption(javaPreference);
		}
	}

}
