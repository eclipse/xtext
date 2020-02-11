/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import static org.eclipse.xtext.util.Strings.*;

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
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;
import org.eclipse.xtext.util.Strings;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Holger Schill
 */
public class RenameElementWizard extends RefactoringWizard {

	private AbstractRenameProcessor renameProcessor;
	
	private IRenameElementContext context;

	public RenameElementWizard(ProcessorBasedRefactoring refactoring, IRenameElementContext context) {
		super(refactoring, DIALOG_BASED_USER_INTERFACE);
		setWindowTitle("Rename Element");
		this.context = context;
		renameProcessor = (AbstractRenameProcessor) refactoring.getProcessor();
	}

	@Override
	protected void addUserInputPages() {
		addPage(new UserInputPage(getRenameProcessor(), context));
	}

	protected AbstractRenameProcessor getRenameProcessor() {
		return renameProcessor;
	}

	protected static class UserInputPage extends UserInputWizardPage {

		private final AbstractRenameProcessor renameProcessor;
		private Text nameField;
		private String currentName;

		public UserInputPage(AbstractRenameProcessor renameProcessor, IRenameElementContext context) {
			super("RenameElementResourceRefactoringInputPage"); //$NON-NLS-1$
			this.renameProcessor = renameProcessor;
			currentName = renameProcessor.getNewName() != null ? renameProcessor.getNewName()
					: renameProcessor.getOriginalName();
		}

		@Override
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, false));
			composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			composite.setFont(parent.getFont());
			Label label = new Label(composite, SWT.NONE);
			label.setText("New name:");//$NON-NLS-1$
			label.setLayoutData(new GridData());
			nameField = new Text(composite, SWT.BORDER);

			nameField.setText(currentName);
			nameField.setFont(composite.getFont());
			nameField.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
			nameField.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});
			nameField.selectAll();
			validatePage();
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
			if(Strings.isEmpty(text)) {
				setPageComplete(false);
			} else {
				if(equal(renameProcessor.getOriginalName(), text)) {
					setErrorMessage(null);
					setPageComplete(false);
				} else {
					RefactoringStatus status = renameProcessor.validateNewName(text);
					setPageComplete(status);
				}
			}
		}

		@Override
		protected boolean performFinish() {
			setNewName();
			//saveHelper.saveEditors(context);
			return super.performFinish();
		}

		@Override
		public IWizardPage getNextPage() {
			setNewName();
			return super.getNextPage();
		}

		private void setNewName() {
			renameProcessor.setNewName(nameField.getText());
		}
	}
}
