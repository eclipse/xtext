/*******************************************************************************
 * Copyright (c) 2011, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 
 *******************************************************************************/
package org.eclipse.xtext.ui.preferences;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ControlEnableState;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.preference.IPreferencePageContainer;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.ui.preferences.IWorkingCopyManager;
import org.eclipse.ui.preferences.WorkingCopyManager;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.DialogField;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.IDialogFieldListener;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.LayoutUtil;
import org.eclipse.xtext.ui.editor.tasks.dialogfields.SelectionButtonDialogField;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Initially copied from Jdt.
 * 
 * @author Michael Clay
 * @since 2.1
 */
public abstract class PropertyAndPreferencePage extends PreferencePage implements IWorkbenchPreferencePage,
		IWorkbenchPropertyPage {
	public static final String DATA_NO_LINK = "PropertyAndPreferencePage.nolink"; //$NON-NLS-1$
	private Control configurationBlockControl;
	private ControlEnableState blockEnableState;
	private Link changeWorkspaceSettings;
	private SelectionButtonDialogField useProjectSettings;
	private IStatus blockStatus;
	private Composite parentComposite;
	private IProject project;
	private Map<Object, Object> pageData;
	@Inject
	private IDialogSettings dialogSettings;

	public PropertyAndPreferencePage() {
		blockStatus = new StatusInfo();
		blockEnableState = null;
		project = null;
		pageData = null;
	}

	protected abstract Control createPreferenceContent(Composite composite,
			IPreferencePageContainer preferencePageContainer);

	protected abstract boolean hasProjectSpecificOptions(IProject project);

	protected abstract String getPreferencePageID();

	protected abstract String getPropertyPageID();

	protected boolean supportsProjectSpecificOptions() {
		return getPropertyPageID() != null;
	}

	protected boolean offerLink() {
		return pageData == null || !Boolean.TRUE.equals(pageData.get(DATA_NO_LINK));
	}

	@Override
	protected Label createDescriptionLabel(Composite parent) {
		parentComposite = parent;
		if (isProjectPreferencePage()) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setFont(parent.getFont());
			GridLayout layout = new GridLayout();
			layout.marginHeight = 0;
			layout.marginWidth = 0;
			layout.numColumns = 2;
			composite.setLayout(layout);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

			IDialogFieldListener listener = new IDialogFieldListener() {
				@Override
				public void dialogFieldChanged(DialogField field) {
					boolean enabled = ((SelectionButtonDialogField) field).isSelected();
					enableProjectSpecificSettings(enabled);

					if (enabled && getData() != null) {
						applyData(getData());
					}
				}
			};

			useProjectSettings = new SelectionButtonDialogField(SWT.CHECK);
			useProjectSettings.setDialogFieldListener(listener);
			useProjectSettings.setLabelText(Messages.PropertyAndPreferencePage_useprojectsettings_label);
			useProjectSettings.doFillIntoGrid(composite, 1);
			LayoutUtil.setHorizontalGrabbing(useProjectSettings.getSelectionButton(null));

			if (offerLink()) {
				changeWorkspaceSettings = createLink(composite,
						Messages.PropertyAndPreferencePage_useworkspacesettings_change);
				changeWorkspaceSettings.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false));
			} else {
				LayoutUtil.setHorizontalSpan(useProjectSettings.getSelectionButton(null), 2);
			}

			Label horizontalLine = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
			horizontalLine.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false, 2, 1));
			horizontalLine.setFont(composite.getFont());
		} else if (supportsProjectSpecificOptions() && offerLink()) {
			changeWorkspaceSettings = createLink(parent,
					Messages.PropertyAndPreferencePage_showprojectspecificsettings_label);
			changeWorkspaceSettings.setLayoutData(new GridData(SWT.END, SWT.CENTER, true, false));
		}

		return super.createDescriptionLabel(parent);
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		composite.setFont(parent.getFont());

		GridData data = new GridData(GridData.FILL, GridData.FILL, true, true);

		configurationBlockControl = createPreferenceContent(composite, getContainer());
		configurationBlockControl.setLayoutData(data);

		if (isProjectPreferencePage()) {
			boolean useProjectSettings = hasProjectSpecificOptions(getProject());
			enableProjectSpecificSettings(useProjectSettings);
		}

		Dialog.applyDialogFont(composite);
		return composite;
	}

	private Link createLink(Composite composite, String text) {
		Link link = new Link(composite, SWT.NONE);
		link.setFont(composite.getFont());
		link.setText("<A>" + text + "</A>"); //$NON-NLS-1$//$NON-NLS-2$
		link.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				doLinkActivated((Link) e.widget);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				doLinkActivated((Link) e.widget);
			}
		});
		return link;
	}

	protected boolean useProjectSettings() {
		return isProjectPreferencePage() && useProjectSettings != null && useProjectSettings.isSelected();
	}

	protected boolean isProjectPreferencePage() {
		return project != null;
	}

	protected IProject getProject() {
		return project;
	}

	final void doLinkActivated(Link link) {
		Map<Object, Object> data = getData();
		if (data == null) {
			data = new HashMap<Object, Object>();
		}
		data.put(DATA_NO_LINK, Boolean.TRUE);

		if (isProjectPreferencePage()) {
			openWorkspacePreferences(data);
		} else {
			Set<IProject> projectsWithSpecifics = Sets.newHashSet();
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			for (IProject project : projects) {
				if (XtextProjectHelper.hasNature(project) && hasProjectSpecificOptions(project)) {
					projectsWithSpecifics.add(project);
				}
			}
			ProjectSelectionDialog dialog = new ProjectSelectionDialog(getShell(), projectsWithSpecifics,
					dialogSettings);
			if (dialog.open() == Window.OK) {
				IProject project = (IProject) dialog.getFirstResult();
				openProjectProperties(project, data);
			}
		}
	}

	protected final void openWorkspacePreferences(Object data) {
		String id = getPreferencePageID();
		PreferencesUtil.createPreferenceDialogOn(getShell(), id, new String[] { id }, data).open();
	}

	protected final void openProjectProperties(IProject project, Object data) {
		String id = getPropertyPageID();
		if (id != null) {
			PreferencesUtil.createPropertyDialogOn(getShell(), project, id, new String[] { id }, data).open();
		}
	}

	protected void enableProjectSpecificSettings(boolean useProjectSpecificSettings) {
		useProjectSettings.setSelection(useProjectSpecificSettings);
		enablePreferenceContent(useProjectSpecificSettings);
		updateLinkVisibility();
		doStatusChanged();
	}

	private void updateLinkVisibility() {
		if (changeWorkspaceSettings == null || changeWorkspaceSettings.isDisposed()) {
			return;
		}

		if (isProjectPreferencePage()) {
			changeWorkspaceSettings.setEnabled(!useProjectSettings());
		}
	}

	protected void setPreferenceContentStatus(IStatus status) {
		blockStatus = status;
		doStatusChanged();
	}

	protected IStatusChangeListener getNewStatusChangedListener() {
		return new IStatusChangeListener() {
			@Override
			public void statusChanged(IStatus status) {
				setPreferenceContentStatus(status);
			}
		};
	}

	protected IStatus getPreferenceContentStatus() {
		return blockStatus;
	}

	protected void doStatusChanged() {
		if (!isProjectPreferencePage() || useProjectSettings()) {
			updateStatus(blockStatus);
		} else {
			updateStatus(new StatusInfo());
		}
	}

	protected void enablePreferenceContent(boolean enable) {
		if (enable) {
			if (blockEnableState != null) {
				blockEnableState.restore();
				blockEnableState = null;
			}
		} else {
			if (blockEnableState == null) {
				blockEnableState = ControlEnableState.disable(configurationBlockControl);
			}
		}
	}

	@Override
	protected void performDefaults() {
		if (useProjectSettings()) {
			enableProjectSpecificSettings(false);
		}
		super.performDefaults();
	}

	private void updateStatus(IStatus status) {
		setValid(!status.matches(IStatus.ERROR));
		applyToStatusLine(this, status);
	}

	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	public IAdaptable getElement() {
		return project;
	}

	@Override
	public void setElement(IAdaptable element) {
		project = Adapters.adapt(element, IProject.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void applyData(Object data) {
		if (data instanceof Map) {
			pageData = (Map<Object, Object>) data;
		}
		if (changeWorkspaceSettings != null) {
			if (!offerLink()) {
				changeWorkspaceSettings.dispose();
				parentComposite.layout(true, true);
			}
		}
	}

	protected Map<Object, Object> getData() {
		return pageData;
	}

	protected IWorkingCopyManager getWorkingCopyManager() {
		IWorkbenchPreferenceContainer container = (IWorkbenchPreferenceContainer) getContainer();
		IWorkingCopyManager manager;
		if (container == null) {
			manager = new WorkingCopyManager();
		} else {
			manager = container.getWorkingCopyManager();
		}
		return manager;
	}

	private static void applyToStatusLine(DialogPage page, IStatus status) {
		String message = status.getMessage();
		if (message != null && message.length() == 0) {
			message = null;
		}
		switch (status.getSeverity()) {
			case IStatus.OK:
				page.setMessage(message, IMessageProvider.NONE);
				page.setErrorMessage(null);
				break;
			case IStatus.WARNING:
				page.setMessage(message, IMessageProvider.WARNING);
				page.setErrorMessage(null);
				break;
			case IStatus.INFO:
				page.setMessage(message, IMessageProvider.INFORMATION);
				page.setErrorMessage(null);
				break;
			default:
				page.setMessage(null);
				page.setErrorMessage(message);
				break;
		}
	}

}
