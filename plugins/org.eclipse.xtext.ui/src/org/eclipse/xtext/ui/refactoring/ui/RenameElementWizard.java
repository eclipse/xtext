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
import org.eclipse.xtext.ui.refactoring.IRenameProcessorAdapter;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class RenameElementWizard extends RefactoringWizard {

	private IRenameProcessorAdapter renameProcessorAdapter;

	public RenameElementWizard(ProcessorBasedRefactoring refactoring, IRenameProcessorAdapter renameProcessorAdapter) {
		super(refactoring, DIALOG_BASED_USER_INTERFACE);
		this.renameProcessorAdapter = renameProcessorAdapter;
		
	}

	protected IRenameProcessorAdapter getRenameProcessorAdapter() {
		return renameProcessorAdapter;
	}

	@Override
	protected void addUserInputPages() {
		addPage(new UserInputPage(getRenameProcessorAdapter()));
	}

	protected static class UserInputPage extends UserInputWizardPage {

		private final IRenameProcessorAdapter renameProcessorAdapter;
		private Text nameField;
		private String currentName;

		public UserInputPage(IRenameProcessorAdapter renameProcessorAdapter) {
			super("RenameElementResourceRefactoringInputPage"); //$NON-NLS-1$
			this.renameProcessorAdapter = renameProcessorAdapter;
			currentName = renameProcessorAdapter.getNewName() != null ? renameProcessorAdapter.getNewName()
					: renameProcessorAdapter.getOriginalName();
		}

		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, false));
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			composite.setFont(parent.getFont());
			Label label = new Label(composite, SWT.NONE);
			label.setText("New name");//$NON-NLS-1$
			label.setLayoutData(new GridData());
			nameField = new Text(composite, SWT.BORDER);

			nameField.setText(currentName);
			nameField.setFont(composite.getFont());
			nameField.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
			nameField.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});
			nameField.selectAll();
			setPageComplete(renameProcessorAdapter.validateNewName(currentName));
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
			RefactoringStatus status = renameProcessorAdapter.validateNewName(text);
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
			renameProcessorAdapter.setNewName(nameField.getText());
		}
	}
}
