/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.buildpath;

import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.wizards.IClasspathContainerPage;
import org.eclipse.jdt.ui.wizards.NewElementWizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendContainerWizardPage extends NewElementWizardPage implements IClasspathContainerPage {

	private IClasspathEntry containerEntry;

	@SuppressWarnings("restriction")
	public XtendContainerWizardPage() {
		super("XtendClassPathContainer"); //$NON-NLS-1$
		setTitle(Messages.XtendClasspathContainer_Description);
		setImageDescriptor(org.eclipse.jdt.internal.ui.JavaPluginImages.DESC_WIZBAN_ADD_LIBRARY);
		setDescription(Messages.XtendContainerWizardPage_Desc);
		this.containerEntry = JavaCore.newContainerEntry(XtendContainerInitializer.XTEND_LIBRARY_PATH);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		Label label = new Label(composite, SWT.NONE);
		String aboutText = NLS.bind(Messages.XtendContainerWizardPage_AboutContainer, containedBundles());
		label.setText(aboutText);
		setControl(composite);
	}

	private String containedBundles() {
		StringBuilder builder = new StringBuilder();
		for (String bundleId : XtendClasspathContainer.BUNDLE_IDS_TO_INCLUDE) {
			builder.append("\t").append(bundleId).append("\n");
		}
		return builder.toString();
	}

	@Override
	public boolean finish() {
		return true;
	}

	@Override
	public IClasspathEntry getSelection() {
		return containerEntry;

	}

	@Override
	public void setSelection(IClasspathEntry containerEntry) {
		//do nothing
	}

}
