/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.formatting.preferences;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.preferences.formatter.IModifyDialogTabPage;
import org.eclipse.jdt.internal.ui.preferences.formatter.ModifyDialog;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.Profile;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileStore;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.IDialogFieldListener;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.StringDialogField;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtend.ide.internal.XtendActivator;

import com.google.inject.Inject;
import com.google.inject.MembersInjector;

/**
 * The dialog to configure the Xtend formatter settings.
 * 
 * Makes use of internal JDT classes. As result was broken with Eclipse Photon. Reflective calls are needed to maintain backwards
 * compatibility. Should be replaced with new version in some future Xtend release (as soon as Xtext implements some base classes that Xtend
 * can reuse).
 * 
 * @author Dennis Huebner - Initial contribution and API
 * @author Arne Deutsch - Adapted to work with Eclipse Photon as well as with older eclipse versions.
 */
@SuppressWarnings("restriction")
public class FormatterModifyDialog extends ModifyDialog {

	public static class Factory {
		@Inject
		MembersInjector<FormatterModifyDialog> injector;

		public FormatterModifyDialog create(Shell parentShell, Profile profile, ProfileManager profileManager, ProfileStore profileStore,
				boolean newProfile, String dialogPreferencesKey, String lastSavePathKey) {
			FormatterModifyDialog modifyDialog = new FormatterModifyDialog(parentShell, profile, profileManager, profileStore, newProfile,
					dialogPreferencesKey, lastSavePathKey);
			injector.injectMembers(modifyDialog);
			return modifyDialog;
		}
	}

	@Inject
	private TabFactory tabFactory;

	// following fields are needed to maintain compatibility to Eclipse Photon
	/**
	 * The key to store the number (beginning at 0) of the tab page which had the focus last time.
	 */
	private static final String DS_KEY_LAST_FOCUS = "modify_dialog.last_focus"; //$NON-NLS-1$
	private final List<IModifyDialogTabPage> fTabPages = new ArrayList<>();
	private final Profile fProfile;
	private final String fKeyLastFocus;
	private final IDialogSettings fDialogSettings;
	private TabFolder fTabFolder;

	public FormatterModifyDialog(Shell parentShell, Profile profile, ProfileManager profileManager, ProfileStore profileStore,
			boolean newProfile, String dialogPreferencesKey, String lastSavePathKey) {
		super(parentShell, profile, profileManager, profileStore, newProfile, dialogPreferencesKey, lastSavePathKey);
		this.fProfile = profile;
		this.fKeyLastFocus = JavaUI.ID_PLUGIN + dialogPreferencesKey + DS_KEY_LAST_FOCUS;
		this.fDialogSettings = JavaPlugin.getDefault().getDialogSettings();
	}

	// @Override intentionally removed to ensure backward compatibility
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void addPages(final Map values) {
		if (isOldAPIVersion()) {
			try {
				// use reflection to not break API
				Method addTabPage = ModifyDialog.class.getDeclaredMethod("addTabPage", String.class, IModifyDialogTabPage.class);
				//		addTabPage("Indentation", tabFactory.createIndentationTab(this, values));
				addTabPage.invoke(this, "Braces", tabFactory.createBracesTab(this, values));
				addTabPage.invoke(this, "White Space", tabFactory.createWhiteSpaceTab(this, values));
				addTabPage.invoke(this, "Blank Lines", tabFactory.createBlankLinesTab(this, values));
				addTabPage.invoke(this, "New Lines", tabFactory.createNewLineTab(this, values));
				addTabPage.invoke(this, "Line Wrapping", tabFactory.createLineWrapTab(this, values));
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				XtendActivator.getInstance().getLog().log(new Status(IStatus.ERROR, XtendActivator.PLUGIN_ID, e.getMessage(), e));
			}
		} else {
			addTabPageNewAPI("Braces", tabFactory.createBracesTab(this, values));
			addTabPageNewAPI("White Space", tabFactory.createWhiteSpaceTab(this, values));
			addTabPageNewAPI("Blank Lines", tabFactory.createBlankLinesTab(this, values));
			addTabPageNewAPI("New Lines", tabFactory.createNewLineTab(this, values));
			addTabPageNewAPI("Line Wrapping", tabFactory.createLineWrapTab(this, values));
		}
	}

	// copied from Eclipse Oxygen to support old dialog in Eclipse Photon
	private final void addTabPageNewAPI(String title, IModifyDialogTabPage tabPage) {
		final TabItem tabItem = new TabItem(fTabFolder, SWT.NONE);
		applyDialogFont(tabItem.getControl());
		tabItem.setText(title);
		tabItem.setData(tabPage);
		tabItem.setControl(tabPage.createContents(fTabFolder));
		fTabPages.add(tabPage);
	}

	@Override
	public void create() {
		if (isOldAPIVersion()) {
			super.create();
			return;
		}
		// copied from Eclipse Oxygen to support old dialog in Eclipse Photon
		super.create();
		int lastFocusNr = 0;
		try {
			lastFocusNr = fDialogSettings.getInt(fKeyLastFocus);
			if (lastFocusNr < 0)
				lastFocusNr = 0;
			if (lastFocusNr > fTabPages.size() - 1)
				lastFocusNr = fTabPages.size() - 1;
		} catch (NumberFormatException x) {
			lastFocusNr = 0;
		}

		try {
			// use reflection to not break API
			Field fNewProfile = ModifyDialog.class.getDeclaredField("fNewProfile");
			fNewProfile.setAccessible(true);
			if (!fNewProfile.getBoolean(this)) {
				fTabFolder.setSelection(lastFocusNr);
				((IModifyDialogTabPage) fTabFolder.getSelection()[0].getData()).setInitialFocus();
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			XtendActivator.getInstance().getLog().log(new Status(IStatus.ERROR, XtendActivator.PLUGIN_ID, e.getMessage(), e));
		}
	}

	@Override
	@SuppressWarnings("rawtypes")
	protected Control createDialogArea(Composite parent) {
		if (isOldAPIVersion()) {
			return super.createDialogArea(parent);
		}
		try {
			// copied from Eclipse Oxygen to support old dialog in Eclipse Photon
			final Composite composite = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout();
			layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
			layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
			layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
			composite.setLayout(layout);
			composite.setLayoutData(new GridData(GridData.FILL_BOTH));
			applyDialogFont(composite);

			Composite nameComposite = new Composite(composite, SWT.NONE);
			nameComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			nameComposite.setLayout(new GridLayout(3, false));

			// use reflection to not break API
			Field fProfileNameField = ModifyDialog.class.getDeclaredField("fProfileNameField");
			fProfileNameField.setAccessible(true);
			StringDialogField f = new StringDialogField();
			fProfileNameField.set(this, f);
			f.setLabelText("&Profile name:");

			f.setText(fProfile.getName());
			f.getLabelControl(nameComposite).setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
			f.getTextControl(nameComposite).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			f.setDialogFieldListener(new IDialogFieldListener() {
				@Override
				public void dialogFieldChanged(DialogField field) {
					try {
						Method doValidate = ModifyDialog.class.getDeclaredMethod("doValidate");
						doValidate.setAccessible(true);
						doValidate.invoke(FormatterModifyDialog.this);
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						XtendActivator.getInstance().getLog().log(new Status(IStatus.ERROR, XtendActivator.PLUGIN_ID, e.getMessage(), e));
					}
				}
			});

			// use reflection to not break API
			Field fSaveButton = ModifyDialog.class.getDeclaredField("fSaveButton");
			fSaveButton.setAccessible(true);
			fSaveButton.set(this, createButton(nameComposite, IDialogConstants.CLIENT_ID + 1, "E&xport...", false));

			fTabFolder = new TabFolder(composite, SWT.NONE);
			fTabFolder.setFont(composite.getFont());
			fTabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			// use reflection to not break API
			Field fWorkingValues = ModifyDialog.class.getDeclaredField("fWorkingValues");
			fWorkingValues.setAccessible(true);
			addPages((Map) fWorkingValues.get(this));

			applyDialogFont(composite);

			fTabFolder.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
				}

				@Override
				public void widgetSelected(SelectionEvent e) {
					final TabItem tabItem = (TabItem) e.item;
					final IModifyDialogTabPage page = (IModifyDialogTabPage) tabItem.getData();
					fDialogSettings.put(fKeyLastFocus, fTabPages.indexOf(page));
					page.makeVisible();
				}
			});

			// use reflection to not break API
			Method doValidate = ModifyDialog.class.getDeclaredMethod("doValidate");
			doValidate.setAccessible(true);
			doValidate.invoke(this);

			PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, getHelpContextId());

			return composite;
		} catch (NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException
				| NoSuchFieldException e) {
			XtendActivator.getInstance().getLog().log(new Status(IStatus.ERROR, XtendActivator.PLUGIN_ID, e.getMessage(), e));
			return null;
		}
	}

	@Override
	protected String getHelpContextId() {
		return null;
	}

	/**
	 * Check if the old (<= Eclipse Oxygen) API is used or not.
	 * 
	 * @return true if the Eclipse API is Eclipse Oxygen or older, true for Eclipse Photon or newer.
	 */
	private boolean isOldAPIVersion() {
		try {
			ModifyDialog.class.getDeclaredMethod("addPages", Map.class);
			return true;
		} catch (NoSuchMethodException | SecurityException e) {
			return false;
		}
	}

}
