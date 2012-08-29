/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.Map;

import org.eclipse.jdt.internal.ui.preferences.formatter.JavaPreview;
import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialog;
import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialogTabPage;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.Profile;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class FormatterModifyDialog extends ModifyDialog {

	public FormatterModifyDialog(Shell parentShell, Profile profile, ProfileManager profileManager,
			ProfileStore profileStore, boolean newProfile, String dialogPreferencesKey, String lastSavePathKey) {
		super(parentShell, profile, profileManager, profileStore, newProfile, dialogPreferencesKey, lastSavePathKey);
	}

	@Override
	protected void addPages(@SuppressWarnings("rawtypes") final Map values) {
		addTabPage("Prototype", new ModifyDialogTabPage() {

			@Override
			protected void initializePage() {
				// TODO Auto-generated method stub

			}

			@Override
			protected void doUpdatePreview() {
				// TODO Auto-generated method stub

			}

			@Override
			protected void doCreatePreferences(Composite composite, int numColumns) {
				// TODO Auto-generated method stub

			}

			@Override
			protected Composite doCreatePreviewPane(Composite composite, int numColumns) {
				createLabel(numColumns, composite, "Xtend preview");

				Control control = new Composite(composite, SWT.NONE);
				fDefaultFocusManager.add(control);

				final GridData gd = createGridData(numColumns, GridData.FILL_BOTH, 0);
				gd.widthHint = 0;
				gd.heightHint = 0;
				control.setLayoutData(gd);

				return composite;
			}

			@Override
			protected JavaPreview doCreateJavaPreview(Composite parent) {
				// Nothing to do, not java
				return null;
			}
		});
	}

	@Override
	protected String getHelpContextId() {
		return null;
	}

}
