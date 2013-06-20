/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import org.apache.log4j.Logger;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;
import org.eclipse.xtext.ui.refactoring.impl.AbstractRenameProcessor;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * {@link IRenameSupport} for Xtext based rename refactorings.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultRenameSupport implements IRenameSupport {

	public static class Factory implements IRenameSupport.Factory {

		@Inject
		private IGlobalServiceProvider globalServiceProvider;

		public IRenameSupport create(Object context, String newName) {
			if (context instanceof IRenameElementContext) {
				IRenameElementContext renameElementContext = (IRenameElementContext) context;
				DefaultRenameSupport renameSupport = getDefaultRenameSupport(renameElementContext);
				if (renameSupport != null && renameSupport.initialize(renameElementContext, newName))
					return renameSupport;
			}
			return null;
		}

		protected DefaultRenameSupport getDefaultRenameSupport(IRenameElementContext renameElementContext) {
			try {
				DefaultRenameSupport renameSupport = globalServiceProvider.findService(
						renameElementContext.getTargetElementURI(), DefaultRenameSupport.class);
				return renameSupport;
			} catch (Exception e) {
				LOG.error("Error getting refactoring components from declaring language", e);
			}
			return null;
		}
	}

	private static final Logger LOG = Logger.getLogger(DefaultRenameSupport.class);

	@Inject(optional = true)
	private Provider<RenameRefactoringExecuter> executerProvider;

	@Inject(optional = true)
	private IRenameRefactoringProvider renameRefactoringProvider;

	private ProcessorBasedRefactoring renameRefactoring;

	private IRenameElementContext renameElementContext;

	@Inject
	private SaveHelper saveHelper;
	
	protected boolean initialize(IRenameElementContext renameElementContext, String newName) {
		if (executerProvider != null && renameRefactoringProvider != null) {
			this.renameRefactoring = renameRefactoringProvider.getRenameRefactoring(renameElementContext);
			if (renameRefactoring != null && renameRefactoring.getProcessor() instanceof AbstractRenameProcessor) {
				((AbstractRenameProcessor) renameRefactoring.getProcessor()).setNewName(newName);
				this.renameElementContext = renameElementContext;
				return true;
			}
		}
		return false;
	}

	public void startRefactoringWithDialog(final boolean previewOnly) throws InterruptedException {
		RenameElementWizard renameElementWizard = new RenameElementWizard(renameRefactoring, saveHelper, renameElementContext) {
			@Override
			protected void addUserInputPages() {
				if (!previewOnly) {
					super.addUserInputPages();
				}
			}
		};
		if (previewOnly) {
			renameElementWizard.setForcePreviewReview(true);
		}
		RefactoringWizardOpenOperation_NonForking openOperation = new RefactoringWizardOpenOperation_NonForking(renameElementWizard);
		openOperation.run(renameElementContext.getTriggeringEditor().getSite().getShell(), "Rename Element");
	}

	public void startDirectRefactoring() throws InterruptedException {
		RenameRefactoringExecuter renameRefactoringExecuter = executerProvider.get();
		renameRefactoringExecuter.execute(renameElementContext.getTriggeringEditor(), renameRefactoring);
	}
	
}
