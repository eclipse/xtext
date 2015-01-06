/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.builder;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.builder.preferences.BuilderConfigurationBlock;
import org.eclipse.xtext.xbase.compiler.JavaVersion;

/**
 * Builder configuration block that adds compiler settings for Xbase.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 */
public class XbaseBuilderConfigurationBlock extends BuilderConfigurationBlock {
	
	@Override
	protected void createGeneralSectionItems(Composite composite) {
		super.createGeneralSectionItems(composite);
		
		String javaComplianceVersion = javaValue(JavaCore.COMPILER_COMPLIANCE);
		final Button useComplianceButton = addCheckBox(composite,
				"Use language version from compiler compliance level (" + javaComplianceVersion + ")",
				XbaseBuilderPreferenceAccess.PREF_USE_COMPILER_COMPLIANCE, BOOLEAN_VALUES, 0);
		
		int valueCount = JavaVersion.values().length;
		String[] values = new String[valueCount];
		String[] valueLabels = new String[valueCount];
		for (int i = 0; i < valueCount; i++) {
			JavaVersion v = JavaVersion.values()[i];
			values[i] = v.toString();
			valueLabels[i] = v.getLabel();
		}
		final Combo versionCombo = addComboBox(composite, "Java language version of generated code:",
				XbaseBuilderPreferenceAccess.PREF_JAVA_VERSION, 0, values, valueLabels);
		versionCombo.setEnabled(!useComplianceButton.getSelection());
		useComplianceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				versionCombo.setEnabled(!useComplianceButton.getSelection());
			}
		});
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
