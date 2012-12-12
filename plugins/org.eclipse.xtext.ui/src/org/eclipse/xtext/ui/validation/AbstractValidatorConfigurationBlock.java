/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.validation;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.preferences.IWorkbenchPreferenceContainer;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.preferences.OptionsConfigurationBlock;
import org.eclipse.xtext.ui.preferences.ScrolledPageContent;
import org.eclipse.xtext.ui.util.PixelConverter;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.4
 */
public abstract class AbstractValidatorConfigurationBlock extends OptionsConfigurationBlock {
	@Inject
	private IDialogSettings section;
	private PixelConverter fPixelConverter;
	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;

	protected AbstractValidatorConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			IWorkbenchPreferenceContainer container) {
		super(project, preferenceStore, container);
	}

	@Override
	public Control doCreateContents(Composite parent) {
		fPixelConverter = new PixelConverter(parent);
		setShell(parent.getShell());

		Composite mainComp = new Composite(parent, SWT.NONE);
		mainComp.setFont(parent.getFont());
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		mainComp.setLayout(layout);

		Composite commonComposite = createStyleTabContent(mainComp);
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.heightHint = fPixelConverter.convertHeightInCharsToPixels(20);
		commonComposite.setLayoutData(gridData);

		validateSettings(null, null, null);
		return mainComp;

	}

	private Composite createStyleTabContent(Composite folder) {
		int nColumns = 3;
		final ScrolledPageContent sc1 = new ScrolledPageContent(folder);

		Composite composite = sc1.getBody();
		GridLayout layout = new GridLayout(nColumns, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);

		Label description = new Label(composite, SWT.LEFT | SWT.WRAP);
		description.setFont(description.getFont());
		description.setText("Select the severity level for the following optional " + lastSegment(languageName)
				+ " compiler problems:");
		description.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, true, false, nColumns - 1, 1));

		int indentStep = fPixelConverter.convertWidthInCharsToPixels(1);

		int defaultIndent = indentStep * 0;
		//		int extraIndent = indentStep * 2;

		fillSettingsPage(composite, nColumns, defaultIndent);
		new Label(composite, SWT.NONE);
		restoreSectionExpansionStates(section);

		return sc1;

	}

	private String lastSegment(String languageFQN) {
		String simplename = languageFQN;
		int lastDot = languageFQN.lastIndexOf('.');
		if (lastDot >= 0 && lastDot < languageFQN.length() - 1) {
			simplename = languageFQN.substring(lastDot + 1, languageFQN.length());
		}
		return simplename;
	}

	protected abstract void fillSettingsPage(Composite composite, int nColumns, int defaultIndent);

	protected Composite createSection(String label, Composite composite, int nColumns) {
		ExpandableComposite excomposite = createStyleSection(composite, label, nColumns);

		Composite inner = new Composite(excomposite, SWT.NONE);
		inner.setFont(composite.getFont());
		inner.setLayout(new GridLayout(nColumns, false));
		excomposite.setClient(inner);
		return inner;
	}

	@Override
	protected Job getBuildJob(IProject project) {
		return null;
	}

	@Override
	protected String[] getFullBuildDialogStrings(boolean workspaceSettings) {
		return null;
	}

	@Override
	protected void validateSettings(String changedKey, String oldValue, String newValue) {
		// TODO Auto-generated method stub

	}

}
