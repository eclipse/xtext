/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jdt.internal.ui.preferences.PreferencesAccess;
import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialog;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileConfigurationBlock;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.BuiltInProfile;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.KeySet;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.Profile;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileStore;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend.core.formatting.XtendFormatterConfig;
import org.eclipse.xtend.ide.formatting.preferences.XtendPreviewFactory.XtendFormatterPreview;
import org.eclipse.xtext.Constants;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;
import com.google.inject.name.Named;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public abstract class FormatterConfigurationBlock extends ProfileConfigurationBlock {

	private static final String PREVIEW_CONTENT = "package testpackage class XtendClass { extension Extension def fooBarBaz(String it) { fooBarBaz } }";

	@Inject
	private XtendPreviewFactory previewFactory;
	@Inject
	private FormatterModifyDialog.Factory formatterModifyDialogFactory;

	public FormatterConfigurationBlock(IProject project, PreferencesAccess access, String lastSaveLoadPathKey) {
		super(project, access, lastSaveLoadPathKey);
	}

	@Override
	protected IProfileVersioner createProfileVersioner() {
		return new FormatterProfileVersioner();
	}

	@Override
	protected ModifyDialog createModifyDialog(Shell shell, ProfileManager.Profile profile,
			ProfileManager profileManager, ProfileStore profileStore, boolean newProfile) {
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

	@Override
	protected abstract ProfileStore createProfileStore(IProfileVersioner versioner);

	public static class Factory {

		@Inject
		@Named(Constants.LANGUAGE_NAME)
		private String xtendNodeID;

		@Inject
		MembersInjector<FormatterConfigurationBlock> injector;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public ProfileConfigurationBlock create(IProject project, PreferencesAccess access, String lastSaveLoadPathKey) {

			FormatterConfigurationBlock result = new FormatterConfigurationBlock(project, access, lastSaveLoadPathKey) {

				private static final String DEFUALT_PROFILE_KEY = "org.eclipse.xtend.ide.default.eclipse_profile";
				private static final String DEFAULT_PROFILE_LABEL = "Default [built-in]";
				private static final int FORMATTER_SETTINGS_VERSION = 1;

				@Override
				protected ProfileStore createProfileStore(IProfileVersioner profileVersioner) {
					return new FormatterProfileStore(profileVersioner, xtendNodeID);
				}

				@Override
				protected ProfileManager createProfileManager(List profiles, IScopeContext context,
						PreferencesAccess access, IProfileVersioner profileVersioner) {

					addBuiltinProfiles(profiles, profileVersioner);
					KeySet[] keySet = new KeySet[] { new KeySet(xtendNodeID, new ArrayList<String>(
							getDefaultProfileSettings().keySet())) };
					return new AbstractProfileManager(profiles, context, access, profileVersioner, keySet,
							DEFUALT_PROFILE_KEY, FormatterProfileVersioner.VERSION_KEY) {

						@Override
						protected String getNodeId() {
							return xtendNodeID;
						}

						@Override
						public Profile getDefaultProfile() {
							return getProfile(DEFUALT_PROFILE_KEY);
						}
					};
				}

				private List<Profile> addBuiltinProfiles(final List profiles, IProfileVersioner profileVersioner) {
					final Profile profile = new BuiltInProfile(DEFUALT_PROFILE_KEY, DEFAULT_PROFILE_LABEL,
							getDefaultProfileSettings(), FORMATTER_SETTINGS_VERSION,
							profileVersioner.getCurrentVersion(), profileVersioner.getProfileKind());
					profiles.add(profile);
					return profiles;
				}

				protected Map getDefaultProfileSettings() {
					return new XtendFormatterConfig().asMap();
				}

			};
			injector.injectMembers(result);
			return result;
		}
	}
}
