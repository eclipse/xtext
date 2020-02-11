/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.refactoring;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExtractVariableWizard extends RefactoringWizard {

	public ExtractVariableWizard(Refactoring refactoring) {
		super(refactoring, RefactoringWizard.DIALOG_BASED_USER_INTERFACE);
	}

	@Override
	protected void addUserInputPages() {
		addPage(new UserInputPage((ExtractVariableRefactoring) getRefactoring()));
	}
	
	@Override
	public String getWindowTitle() {
		return "Extract Local Variable";
	}
	
	protected static class UserInputPage extends UserInputWizardPage {

		private final ExtractVariableRefactoring refactoring;
		
		private Text nameField;

		private Button finalButton;

		public UserInputPage(ExtractVariableRefactoring refactoring) {
			super("ExtractLocalVariableInutPage"); 
			this.refactoring = refactoring;
		}

		@Override
		public void createControl(Composite parent) {
			Composite composite= new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout(2, false);
			layout.verticalSpacing = 16;
			composite.setLayout(layout);
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			composite.setFont(parent.getFont());

			Label label= new Label(composite, SWT.NONE);
			label.setText("Variable name:");
			label.setFont(composite.getFont());
			label.setLayoutData(new GridData());

			nameField= new Text(composite, SWT.BORDER);
			nameField.setText(refactoring.getVariableName());
			nameField.setFont(composite.getFont());
			nameField.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
			nameField.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});
			nameField.selectAll();
			
			finalButton = new Button(composite, SWT.CHECK);
			finalButton.setText("Declare as final 'val'");
			finalButton.setFont(composite.getFont());
			finalButton.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, false, false, 2, 1));
			finalButton.setSelection(refactoring.isFinal());
			setControl(composite);
			validatePage();
		}

		@Override
		public void setVisible(boolean visible) {
			if (visible) {
				nameField.setFocus();
			}
			super.setVisible(visible);
		}

		protected final void validatePage() {
			String variableName= nameField.getText();
			RefactoringStatus status= refactoring.validateNewVariableName(variableName);
			setPageComplete(status);
		}

		@Override
		protected boolean performFinish() {
			updateRefactoring();
			return super.performFinish();
		}

		@Override
		public IWizardPage getNextPage() {
			updateRefactoring();
			return super.getNextPage();
		}

		protected void updateRefactoring() {
			refactoring.setVariableName(nameField.getText());
			refactoring.setFinal(finalButton.getSelection());
		}
	}

}
