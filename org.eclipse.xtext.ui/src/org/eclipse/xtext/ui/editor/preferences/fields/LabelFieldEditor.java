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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public final class LabelFieldEditor extends FieldEditor {

	public LabelFieldEditor(String labelText, Composite parent) {
		super("label", labelText, parent);
	}

	@Override
	public int getNumberOfControls() {
		return 1;
	}

	@Override
	protected void doStore() {
	}

	@Override
	protected void doLoadDefault() {
	}

	@Override
	protected void doLoad() {
	}

	@Override
	protected void doFillIntoGrid(Composite parent, int numColumns) {
		getLabelControl(parent).setLayoutData(new GridData());
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {
		GridData gd = (GridData) getLabelControl().getLayoutData();
		gd.horizontalSpan = numColumns;

	}
}