/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;


import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.xtext.ui.editor.preferences.AbstractPreferencePage;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RefactoringPreferencePage extends AbstractPreferencePage {

	@Override
	protected void createFieldEditors() {
		Composite parent = getFieldEditorParent();
		Group refactoringGroup = new Group(parent, SWT.SHADOW_IN);
		refactoringGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		refactoringGroup.setText("Refactoring");
		GridLayout layout = new GridLayout(1, false);
		refactoringGroup.setLayout(layout);
		Composite composite = new Composite(refactoringGroup, SWT.NONE);
		addField(new BooleanFieldEditor(RefactoringPreferences.SAVE_ALL_BEFORE_REFACTORING,
				"Save all modified resources automatically prior to refactoring", composite));
		addField(new BooleanFieldEditor(RefactoringPreferences.USE_INLINE_REFACTORING,
				"Rename in editor without dialog if possible", composite));
		refactoringGroup.pack();
	}
}
