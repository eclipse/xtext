/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.ltk.core.refactoring.participants.ProcessorBasedRefactoring;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.ui.refactoring.IRenameProcessorAdapter;
import org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultRenameSupport implements IRenameSupport {

	public static class Factory implements IRenameSupport.Factory {

		@Inject
		private IGlobalServiceProvider globalServiceProvider;

		public IRenameSupport create(Object context, String newName) {
			if (context instanceof IRenameElementContext) {
				IRenameElementContext renameElementContext = (IRenameElementContext) context;
				DeclaringLanguageComponentFactory declaringLanguageComponentFactory = getDeclaringLanguageComponentFactory(renameElementContext);
				ProcessorBasedRefactoring renameRefactoring = declaringLanguageComponentFactory.createRenameRefactoring(renameElementContext);
				if(renameRefactoring != null)
					return new DefaultRenameSupport(declaringLanguageComponentFactory,
						renameElementContext, renameRefactoring, newName);
			}
			return null;
		}

		protected DeclaringLanguageComponentFactory getDeclaringLanguageComponentFactory(
				IRenameElementContext renameElementContext) {
			try {
				DeclaringLanguageComponentFactory languageComponentFactory = globalServiceProvider.findService(
						renameElementContext.getTargetElementURI(), DeclaringLanguageComponentFactory.class);
				return languageComponentFactory;
			} catch (Exception e) {
				LOG.error("Error getting refactoring components from declaring language", e);
				throw new WrappedException(e);
			}
		}
	}

	/**
	 * Factory for components from the language holding the declaration of the renamed element.
	 * 
	 * @since 2.0
	 */
	protected static class DeclaringLanguageComponentFactory {
		@Inject(optional = true)
		private Provider<RenameRefactoringExecuter> renameRefactoringExecuterProvider;

		public RenameRefactoringExecuter createRenameRefactoringExecuter() {
			return renameRefactoringExecuterProvider.get();
		}

		@Inject(optional = true)
		private IRenameRefactoringProvider renameRefactoringProvider;

		public ProcessorBasedRefactoring createRenameRefactoring(IRenameElementContext renameElementContext) {
			return renameRefactoringProvider != null ? renameRefactoringProvider.getRenameRefactoring(renameElementContext) : null;
		}

		@Inject(optional = true)
		private IRenameProcessorAdapter.Factory renameProcessAdapterFactory;

		public IRenameProcessorAdapter createRenameProcessorAdapter(ProcessorBasedRefactoring renameRefactoring) {
			return renameProcessAdapterFactory.create((RenameProcessor) renameRefactoring.getProcessor());
		}

		public boolean hasRefactoring() {
			return renameRefactoringExecuterProvider != null && renameRefactoringProvider != null
					&& renameProcessAdapterFactory != null;
		}
	}

	private static final Logger LOG = Logger.getLogger(DefaultRenameSupport.class);

	private DeclaringLanguageComponentFactory declaringLanguage;

	private ProcessorBasedRefactoring renameRefactoring;

	private IRenameElementContext renameElementContext;

	private IRenameProcessorAdapter renameProcessorAdapter;

	protected DefaultRenameSupport(DeclaringLanguageComponentFactory declaringLanguage,
			IRenameElementContext renameElementContext, ProcessorBasedRefactoring renameRefactoring, String newName) {
		this.declaringLanguage = declaringLanguage;
		this.renameElementContext = renameElementContext;
		this.renameRefactoring = renameRefactoring;
		this.renameProcessorAdapter = declaringLanguage.createRenameProcessorAdapter(renameRefactoring);
		renameProcessorAdapter.setNewName(newName);
	}

	public void startRefactoringWithDialog(final boolean previewOnly) throws InterruptedException {
		RenameElementWizard renameElementWizard = new RenameElementWizard(renameRefactoring, renameProcessorAdapter) {
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
		RefactoringWizardOpenOperation openOperation = new RefactoringWizardOpenOperation(renameElementWizard);
		openOperation.run(renameElementContext.getTriggeringEditor().getSite().getShell(), "Rename Element");
	}

	public void startDirectRefactoring() throws InterruptedException {
		RenameRefactoringExecuter renameRefactoringExecuter = declaringLanguage.createRenameRefactoringExecuter();
		renameRefactoringExecuter.execute(renameElementContext.getTriggeringEditor(), renameRefactoring);
	}

}
