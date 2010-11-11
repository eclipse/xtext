/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.ui.refactoring.IRenameElementProcessor;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RenameElementWizard extends RefactoringWizard {

	public RenameElementWizard(RenameRefactoring refactoring) {
		super(refactoring, DIALOG_BASED_USER_INTERFACE);
	}

	protected IRenameElementProcessor getRefactoringProcessor() {
		return (IRenameElementProcessor) ((ProcessorBasedRefactoring) getRefactoring()).getProcessor();
	}

	@Override
	protected void addUserInputPages() {
		addPage(new UserInputPage(getRefactoringProcessor()));
	}

	protected static class UserInputPage extends UserInputWizardPage {

		private final IRenameElementProcessor renameElementProcessor;

		private Text nameField;

		public UserInputPage(IRenameElementProcessor processor) {
			super("RenameElementResourceRefactoringInputPage"); //$NON-NLS-1$
			renameElementProcessor = processor;
		}

		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, false));
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			composite.setFont(parent.getFont());
			Label label = new Label(composite, SWT.NONE);
			label.setText("New name");
			label.setLayoutData(new GridData());
			nameField = new Text(composite, SWT.BORDER);
			nameField.setText(renameElementProcessor.getRenameElementStrategy().getCurrentName());
			nameField.setFont(composite.getFont());
			nameField.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
			nameField.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});
			nameField.selectAll();
			setPageComplete(false);
			setControl(composite);
		}

		@Override
		public void setVisible(boolean visible) {
			if (visible) {
				nameField.setFocus();
			}
			super.setVisible(visible);
		}

		protected final void validatePage() {
			String text = nameField.getText();
			RefactoringStatus status = renameElementProcessor.getRenameElementStrategy().validateNewName(text);
			setPageComplete(status);
		}

		@Override
		protected boolean performFinish() {
			setNewName();
			return super.performFinish();
		}

		@Override
		public IWizardPage getNextPage() {
			setNewName();
			return super.getNextPage();
		}

		private void setNewName() {
			renameElementProcessor.setNewName(nameField.getText());
		}
	}
}
