/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.preferences;

import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.LanguageInfo;
import org.eclipse.xtext.ui.util.DontAskAgainDialogs;
import org.eclipse.xtext.ui.util.PixelConverter;
import org.eclipse.xtext.ui.util.SWTUtil;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class ResetPromptDialogSettingsField extends FieldEditor {

	private Group dontAskGroup;
	private @Inject DontAskAgainDialogs dialogs;
	private @Inject LanguageInfo languageInfo;
	
	public ResetPromptDialogSettingsField () {
		init("resetPromptDialog", "Reset Prompt Dialog");
	}

	@Override
	public int getNumberOfControls() {
		return 1;
	}

	public FieldEditor getFieldEditor(Composite parent) {
		return createField(parent, getNumberOfControls());
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
		createField(parent, numColumns);
	}

	protected ResetPromptDialogSettingsField createField(Composite parent, int colums) {
		if (dontAskGroup == null) {
			GridLayout layout = new GridLayout(2, false);
			dontAskGroup = new Group(parent, SWT.NONE);
			dontAskGroup.setLayout(layout);
			GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
			gridData.horizontalSpan = colums;
			dontAskGroup.setLayoutData(gridData);
			dontAskGroup.setText(languageInfo.getShortName() + Messages.ResetPromptDialogSettingsField_0);

			Label label = new Label(dontAskGroup, SWT.WRAP);
			label.setText(Messages.ResetPromptDialogSettingsField_1);
			label.setFont(parent.getFont());
			GridData data = new GridData(GridData.FILL, GridData.CENTER, true, false);
			data.widthHint = new PixelConverter(parent).convertHorizontalDLUsToPixels(40);
			label.setLayoutData(data);

			Button clearButton = new Button(dontAskGroup, SWT.PUSH);
			clearButton.setText("&Clear"); //$NON-NLS-1$
			GridData layoutData = new GridData(GridData.FILL, GridData.BEGINNING, false, false);
			clearButton.setLayoutData(layoutData);
			clearButton.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					unhideAllDialogs();
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					unhideAllDialogs();
				}
			});
			layoutData.widthHint = SWTUtil.getButtonWidthHint(clearButton);
		}
		return this;
	}

	private void unhideAllDialogs() {
		dialogs.forgetAllUserDecisions();
	}

	@Override
	protected void adjustForNumColumns(int numColumns) {
		if (dontAskGroup != null) {
			GridData gd = (GridData) dontAskGroup.getLayoutData();
			gd.horizontalSpan = numColumns;
		}
	}
}