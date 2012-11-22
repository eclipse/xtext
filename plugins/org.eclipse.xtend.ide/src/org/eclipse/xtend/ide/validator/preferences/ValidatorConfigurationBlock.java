/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.validator.preferences;

import java.util.Set;

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
import org.eclipse.xtext.builder.preferences.OptionsConfigurationBlock;
import org.eclipse.xtext.builder.preferences.ScrolledPageContent;
import org.eclipse.xtext.ui.util.PixelConverter;
import org.eclipse.xtext.validation.IssueCodes;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class ValidatorConfigurationBlock extends OptionsConfigurationBlock {

	@Inject
	private static IssueCodes issueCodes;
	@Inject
	private IDialogSettings section;
	private PixelConverter fPixelConverter;

	public ValidatorConfigurationBlock(IProject project, IPreferenceStore preferenceStore,
			IWorkbenchPreferenceContainer container) {
		super(project, getKeys(project), preferenceStore, container);
	}

	private static String[] getKeys(IProject project) {
		Set<String> keys = Sets.newHashSet();
		keys.add(issueCodes.forbiddenReference.getCode());
		return keys.toArray(new String[] {});
	}

	@Override
	protected Control createContents(Composite parent) {
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

		String[] errorWarningIgnore = new String[] { "Error", "Warning", "Ignore" };

		String[] errorWarningIgnoreLabels = new String[] { "Error", "Warning", "Ignore" };

		int nColumns = 3;

		final ScrolledPageContent sc1 = new ScrolledPageContent(folder);

		Composite composite = sc1.getBody();
		GridLayout layout = new GridLayout(nColumns, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);

		Label description = new Label(composite, SWT.LEFT | SWT.WRAP);
		description.setFont(description.getFont());
		description.setText("Errors/Warnings");
		description.setLayoutData(new GridData(GridData.BEGINNING, GridData.CENTER, true, false, nColumns - 1, 1));

		int indentStep = fPixelConverter.convertWidthInCharsToPixels(1);

		int defaultIndent = indentStep * 0;
//		int extraIndent = indentStep * 2;
		String label;
		ExpandableComposite excomposite;
		Composite inner;

		label = "Common Section";
		excomposite = createStyleSection(composite, label, nColumns);

		inner = new Composite(excomposite, SWT.NONE);
		inner.setFont(composite.getFont());
		inner.setLayout(new GridLayout(nColumns, false));
		excomposite.setClient(inner);

		label = "My validator config";
		addComboBox(inner, label, issueCodes.forbiddenReference.getCode(), errorWarningIgnore,
				errorWarningIgnoreLabels, defaultIndent);

		new Label(composite, SWT.NONE);

		restoreSectionExpansionStates(section);

		return sc1;

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
