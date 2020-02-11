/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Anton Kosyakov - https://bugs.eclipse.org/bugs/show_bug.cgi?id=379220
 */
public class NewXtendInterfaceWizardPage extends AbstractNewXtendElementWizardPage {

	public NewXtendInterfaceWizardPage() {
		super(INTERFACE_TYPE, NewXtendInterfaceWizard.TITLE);
		this.setTitle(NewXtendInterfaceWizard.TITLE);
		this.setDescription(Messages.XTEND_INTERFACE_WIZARD_DESCRIPTION);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = createCommonControls(parent);
		createSuperInterfacesControls(composite, COLS);
		setControl(composite);
	}

	@Override
	protected void doStatusUpdate() {
		IStatus[] status = new IStatus[] { fContainerStatus, fPackageStatus, fTypeNameStatus, fSuperInterfacesStatus };
		updateStatus(status);
	}

	@Override
	protected String getElementCreationErrorMessage() {
		return Messages.ERROR_CREATING_INTERFACE;
	}

	@Override
	protected String getPackageDeclaration(String lineSeparator) {
		return XtendTypeCreatorUtil.createPackageDeclaration(getTypeName(), getPackageFragment(), getSuperInterfaces(), lineSeparator);
	}

	@Override
	protected String getTypeContent(String indentation, String lineSeparator) {
		return XtendTypeCreatorUtil.createInterfaceContent(getTypeName(), getSuperInterfaces(), indentation, lineSeparator);
	}

}
