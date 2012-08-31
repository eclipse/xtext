/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jdt.internal.ui.preferences.PreferencesAccess;
import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialog;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileConfigurationBlock;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.Profile;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileStore;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend.ide.formatting.preferences.XtendPreviewFactory.XtendFormatterPreview;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class FormatterConfigurationBlock extends ProfileConfigurationBlock {

	private static final String PREVIEW_CONTENT = "package testpackage class XtendClass { extension Extension def fooBarBaz(String it) { fooBarBaz } }";

	@Inject private XtendPreviewFactory previewFactory;
	@Inject private FormatterModifyDialog.Factory formatterModifyDialogFactory;

	public FormatterConfigurationBlock(IProject project, PreferencesAccess access, String lastSaveLoadPathKey) {
		super(project, access, lastSaveLoadPathKey);
	}

	@Override
	protected IProfileVersioner createProfileVersioner() {
		return new FormatterProfileVersioner();
	}

	@Override
	protected ProfileStore createProfileStore(IProfileVersioner profileVersioner) {
		return new FormatterProfileStore(profileVersioner);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected ProfileManager createProfileManager(List profiles, IScopeContext context, PreferencesAccess access,
			IProfileVersioner profileVersioner) {
		return new FormatterProfileManager(profiles, context, access, profileVersioner);
	}

	@Override
	protected ModifyDialog createModifyDialog(Shell shell, Profile profile, ProfileManager profileManager,
			ProfileStore profileStore, boolean newProfile) {
		return formatterModifyDialogFactory.create(shell, profile, profileManager, profileStore, newProfile, "", "");
	}

	@Override
	protected void configurePreview(Composite composite, int numColumns, ProfileManager profileManager) {
		createLabel(composite, "Xtend code preview:", numColumns);
		XtendFormatterPreview xtendPreview = previewFactory.createNewPreview(composite, PREVIEW_CONTENT);
		final GridData gd = new GridData(GridData.FILL_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = numColumns;
		gd.verticalSpan = 7;
		gd.widthHint = 0;
		gd.heightHint = 0;

		xtendPreview.getEditor().getViewer().getControl().setLayoutData(gd);
		profileManager.addObserver(xtendPreview.getObserver());
		xtendPreview.doFormat(profileManager.getSelected().getSettings());
	}

	public static class Factory {

		@Inject
		MembersInjector<FormatterConfigurationBlock> injector;

		public ProfileConfigurationBlock create(IProject project, PreferencesAccess access, String lastSaveLoadPathKey) {
			FormatterConfigurationBlock result = new FormatterConfigurationBlock(project, access, lastSaveLoadPathKey);
			injector.injectMembers(result);
			return result;
		}
	}
}
