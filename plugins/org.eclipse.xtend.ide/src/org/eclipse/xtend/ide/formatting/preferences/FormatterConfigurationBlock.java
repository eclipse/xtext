/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jdt.internal.ui.preferences.PreferencesAccess;
import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialog;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileConfigurationBlock;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.Profile;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileStore;
import org.eclipse.jface.text.Region;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtend.ide.formatting.XtendFormatterFactory;
import org.eclipse.xtend.ide.formatting.XtendFormatterFactory.ContentFormatter;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class FormatterConfigurationBlock extends ProfileConfigurationBlock {

	private static final String PREVIEW_CONTENT = "package testpackage class XtendClass { extension Extension def fooBarBaz(String it) { fooBarBaz } }";

	public static class Factory {

		@Inject
		MembersInjector<FormatterConfigurationBlock> injector;

		public ProfileConfigurationBlock create(IProject project, PreferencesAccess access, String lastSaveLoadPathKey) {
			FormatterConfigurationBlock result = new FormatterConfigurationBlock(project, access, lastSaveLoadPathKey);
			injector.injectMembers(result);
			return result;
		}
	}

	@Inject
	private EmbeddedEditorFactory editorFactory;
	@Inject
	private IEditedResourceProvider resourceProvider;
	@Inject
	protected XtendFormatterFactory xtendFormatterFactory;

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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected ProfileManager createProfileManager(List profiles, IScopeContext context, PreferencesAccess access,
			IProfileVersioner profileVersioner) {
		return new FormatterProfileManager(profiles, context, access, profileVersioner);
	}

	@Override
	protected ModifyDialog createModifyDialog(Shell shell, Profile profile, ProfileManager profileManager,
			ProfileStore profileStore, boolean newProfile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void configurePreview(Composite composite, int numColumns, ProfileManager profileManager) {
		createLabel(composite, "Xtend code preview:", numColumns);
		final EmbeddedEditor handle = editorFactory.newEditor(resourceProvider)
				.withResourceValidator(IResourceValidator.NULL).readOnly().withParent(composite);
		final GridData gd = new GridData(GridData.FILL_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = numColumns;
		gd.verticalSpan = 7;
		gd.widthHint = 0;
		gd.heightHint = 0;
		handle.getViewer().getControl().setLayoutData(gd);

		final EmbeddedEditorModelAccess partialEditor = handle.createPartialEditor();
		partialEditor.updateModel("", PREVIEW_CONTENT, "");
		PreviewUpdater updater = new PreviewUpdater(handle, xtendFormatterFactory.new ContentFormatter());
		profileManager.addObserver(updater);
		updater.doFormat();
	}

	private static class PreviewUpdater implements Observer {
		private EmbeddedEditor handle;
		private ContentFormatter contentFormatter;

		public PreviewUpdater(EmbeddedEditor handle, ContentFormatter contentFormatter) {
			this.handle = handle;
			this.contentFormatter = contentFormatter;
		}

		public void update(Observable o, Object arg) {
			final int value = ((Integer) arg).intValue();
			switch (value) {
				case ProfileManager.PROFILE_CREATED_EVENT:
				case ProfileManager.PROFILE_DELETED_EVENT:
				case ProfileManager.SELECTION_CHANGED_EVENT:
				case ProfileManager.SETTINGS_CHANGED_EVENT: {
					doFormat();
				}
			}
		}

		public void doFormat() {
			contentFormatter.format(handle.getDocument(), new Region(0, handle.getDocument().getLength()));
			handle.getViewer().refresh();
		}
	}
}
