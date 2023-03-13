/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.wizards;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.internal.ui.wizards.NewWizardMessages;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.LayoutUtil;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.SelectionButtonDialogFieldGroup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Robert von Massow - Initial contribution and API
 * @author Holger Schill
 * @author Anton Kosyakov - https://bugs.eclipse.org/bugs/show_bug.cgi?id=379220
 * @author Karsten Thoms - bug#378821
 */
@SuppressWarnings("restriction")
public class NewXtendClassWizardPage extends AbstractNewXtendElementWizardPage {
	private SelectionButtonDialogFieldGroup fMethodStubsButtons;

	public NewXtendClassWizardPage() {
		super(CLASS_TYPE, NewXtendClassWizard.TITLE);
		this.setTitle(NewXtendClassWizard.TITLE);
		this.setDescription(Messages.XTEND_CLASS_WIZARD_DESCRIPTION);

		// from org.eclipse.jdt.ui.wizards.NewClassWizardPage
		// TODO: Enable further options (constructors, abstract methods, comments)
		String[] buttonNames = new String[] { Messages.METHODS_MAIN };
		fMethodStubsButtons= new SelectionButtonDialogFieldGroup(SWT.CHECK, buttonNames, 1);
		fMethodStubsButtons.setLabelText(NewWizardMessages.NewClassWizardPage_methods_label);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = createCommonControls(parent);
		createSuperClassControls(composite, COLS);
		createSuperInterfacesControls(composite, COLS);
		createMethodStubSelectionControls(composite, COLS);
		setControl(composite);
	}

	@Override
	protected void doStatusUpdate() {
		IStatus[] status= new IStatus[] {
			fContainerStatus,
			fPackageStatus,
			fTypeNameStatus,
			fSuperClassStatus,
			fSuperInterfacesStatus
		};
		updateStatus(status);
	}

	@Override
	protected String getPackageDeclaration(String lineSperator) {
		return XtendTypeCreatorUtil.createPackageDeclaration(getTypeName(), getPackageFragment(), getSuperClass(), getSuperInterfaces(), lineSperator);
	}

	@Override
	protected String getTypeContent(String indentation, String lineSperator) {
		return XtendTypeCreatorUtil.createClassContent(getTypeName(), getSuperClass(), getSuperInterfaces(), indentation, lineSperator,
				isCreateMain());
	}

	@Override
	protected String getElementCreationErrorMessage() {
		return Messages.ERROR_CREATING_CLASS;
	}
	
	private void createMethodStubSelectionControls(Composite composite, int nColumns) {
		Control labelControl= fMethodStubsButtons.getLabelControl(composite);
		LayoutUtil.setHorizontalSpan(labelControl, nColumns);

		DialogField.createEmptySpace(composite);

		Control buttonGroup= fMethodStubsButtons.getSelectionButtonsGroup(composite);
		LayoutUtil.setHorizontalSpan(buttonGroup, nColumns - 1);
	}
	
	/**
	 * Returns the current selection state of the 'Create Main' checkbox.
	 *
	 * @return the selection state of the 'Create Main' checkbox
	 */
	private boolean isCreateMain() {
		return fMethodStubsButtons.isSelected(0);
	}

}
